/*
 * TopStack (c) Copyright 2012-2013 Transcend Computing, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the License);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an AS IS BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.msi.tough.engine.aws.rds;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.msi.tough.core.Appctx;
import com.msi.tough.core.HibernateUtil;
import com.msi.tough.core.HibernateUtil.Operation;
import com.msi.tough.engine.core.FailHook;
import com.msi.tough.model.rds.RdsDbinstance;
import com.msi.tough.utils.RDSUtil;

public class DBInstanceFailHook implements FailHook {
	private static Logger logger = Appctx.getLogger(DBInstanceFailHook.class
			.getName());

	private static RdsDbinstance selectDBInstance(final Session sess,
			final String instanceID, final long userID) {
		final List<RdsDbinstance> l = RDSUtil.selectInstances(sess, instanceID, userID, null, 0);
		if (l == null || l.size() == 0 || l.size() > 1) {
			logger.debug("There is no DBInstance with such identifier in this user's account...");
			return null;
		}
		return l.get(0);
	}

	@Override
	public void endFail(final long acid, final String stackId,
			final String physicalId, final String parameter) {
		// nothing to do will be taken care by stack deletion
	}

	@Override
	public void startFail(final long acid, final String stackId,
			final String physicalId, final String parameter) {
		HibernateUtil.withNewSession(new Operation<Object>() {
			@Override
			public Object ex(final Session session, final Object... args)
					throws Exception {
				final RdsDbinstance dbInstance = selectDBInstance(session,
						physicalId, acid);
				if (dbInstance != null) {
					dbInstance.setDbinstanceStatus("error");
					session.save(dbInstance);
				}
				return null;
			}
		});
	}
}
