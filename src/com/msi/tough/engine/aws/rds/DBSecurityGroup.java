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
import org.slf4j.Logger;

import com.msi.tough.cf.AccountType;
import com.msi.tough.cf.CFType;
import com.msi.tough.cf.rds.DBSecurityGroupType;
import com.msi.tough.core.Appctx;
import com.msi.tough.core.HibernateUtil;
import com.msi.tough.core.HibernateUtil.Operation;
import com.msi.tough.engine.core.BaseProvider;
import com.msi.tough.engine.core.CallStruct;
import com.msi.tough.engine.resource.Resource;
import com.msi.tough.model.AccountBean;
import com.msi.tough.model.rds.RdsDbsecurityGroup;
import com.msi.tough.utils.AccountUtil;
import com.msi.tough.utils.RDSQueryFaults;
import com.msi.tough.utils.rds.SecurityGroupEntity;

public class DBSecurityGroup extends BaseProvider {

	private static final Logger logger = Appctx.getLogger(DBSecurityGroup.class
			.getName());

	public static String TYPE = "AWS::RDS::DBSecurityGroup";

	@Override
	public CFType create0(final CallStruct call) throws Exception {
		final AccountType ac = call.getAc();
		final String name = call.getName();
		final String description = (String) call.getProperty("Description");

		HibernateUtil.withNewSession(new Operation<Object>() {

			@Override
			public Object ex(final Session s, final Object... args)
					throws Exception {
				final AccountBean acct = AccountUtil.readAccount(s, ac.getId());
				SecurityGroupEntity.insertSecurityGroup(s, acct, name,
						description);
				return null;
			}
		});

		final DBSecurityGroupType ret = new DBSecurityGroupType();
		ret.setName(name);
		return ret;
	}

	@Override
	public Resource delete0(final CallStruct call) throws Exception {
		super.delete0(call);
		final AccountType ac = call.getAc();
		final String name = call.getPhysicalId();

		HibernateUtil.withNewSession(new Operation<Object>() {

			@Override
			public Object ex(final Session s, final Object... args)
					throws Exception {

				final RdsDbsecurityGroup secGrp = SecurityGroupEntity
						.getSecurityGroup(s, name, ac.getId());
				if (secGrp == null) {
					throw RDSQueryFaults.DBSecurityGroupNotFound();
				}
				SecurityGroupEntity.deleteSecurityGroup(s, secGrp);
				return null;
			}
		});
		logger.debug("DBSecurityGroup deleted " + name);
		return null;
	}
}
