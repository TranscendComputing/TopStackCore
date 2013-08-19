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

import org.hibernate.Session;

import com.msi.tough.core.HibernateUtil;
import com.msi.tough.core.HibernateUtil.Operation;
import com.msi.tough.engine.core.FailHook;
import com.msi.tough.model.rds.RdsDbinstance;
import com.msi.tough.model.rds.RdsSnapshot;
import com.msi.tough.utils.rds.InstanceEntity;
import com.msi.tough.utils.rds.SnapshotEntity;

public class DBSnapshotFailHook implements FailHook{

	@Override
	public void endFail(final long acid, final String stackId, final String physicalId,
			final String parameter) {
		// nothing to do
	}

	@Override
	public void startFail(final long acid, final String stackId, final String physicalId,
			final String parameter) {
		HibernateUtil.withNewSession(new Operation<Object>() {
			@Override
			public Object ex(final Session session, final Object... args)
					throws Exception {
				RdsSnapshot failed = SnapshotEntity.selectSnapshot(session, null, physicalId, acid);
				failed.setStatus("error");
				String dbInstId = failed.getDbinstanceId();
				RdsDbinstance inst = InstanceEntity.selectDBInstance(session, dbInstId, acid);
				inst.setDbinstanceStatus("available");
				session.save(inst);
				session.save(failed);
				return null;
			}
		});
	}

}
