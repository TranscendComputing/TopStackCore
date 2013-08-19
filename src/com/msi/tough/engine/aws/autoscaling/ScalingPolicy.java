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
package com.msi.tough.engine.aws.autoscaling;

import java.util.Date;

import org.hibernate.Session;

import com.msi.tough.cf.AccountType;
import com.msi.tough.cf.CFType;
import com.msi.tough.cf.autoscaling.ScalingPolicyType;
import com.msi.tough.core.HibernateUtil;
import com.msi.tough.core.HibernateUtil.Operation;
import com.msi.tough.core.StringHelper;
import com.msi.tough.engine.core.BaseProvider;
import com.msi.tough.engine.core.CallStruct;
import com.msi.tough.engine.resource.Resource;
import com.msi.tough.model.ASPolicyBean;
import com.msi.tough.model.AccountBean;
import com.msi.tough.utils.ASUtil;
import com.msi.tough.utils.AccountUtil;

public class ScalingPolicy extends BaseProvider {

	public static String TYPE = "AWS::AutoScaling::ScalingPolicy";

	@Override
	public CFType create0(final CallStruct call) throws Exception {
		return HibernateUtil.withNewSession(new Operation<CFType>() {

			@Override
			public CFType ex(final Session s, final Object... args)
					throws Exception {
				final AccountType ac = call.getAc();
				final String name = call.getName();

				final String adjustmentType = (String) call
						.getRequiredProperty("AdjustmentType");
				final String autoScalingGroupName = (String) call
						.getRequiredProperty("AutoScalingGroupName");
				final String cooldown = (String) call.getProperty("Cooldown");
				final String scalingAdjustment = (String) call
						.getRequiredProperty("ScalingAdjustment");

				final ASPolicyBean b = new ASPolicyBean();
				b.setName(name);
				b.setAdjustmentType(adjustmentType);
				if (!StringHelper.isBlank(cooldown)) {
					b.setCooldown(Integer.parseInt(cooldown));
				}
				b.setGrpName(autoScalingGroupName);
				b.setScalingAdjustment(Integer.parseInt(scalingAdjustment));
				b.setUserId(ac.getId());
				b.setCreatedDate(new Date());
				s.save(b);

				final ScalingPolicyType ret = new ScalingPolicyType();
				ret.setAcId(ac.getId());
				ret.setAdjustmentType(adjustmentType);
				ret.setAutoScalingGroupName(autoScalingGroupName);
				ret.setCooldown(cooldown);
				ret.setCreatedTime(b.getCreatedDate());
				ret.setName(name);
				ret.setScalingAdjustment(scalingAdjustment);
				ret.setUpdatedTime(b.getCreatedDate());
				return ret;
			}
		});
	}

	@Override
	public Resource delete0(final CallStruct call) throws Exception {
		HibernateUtil.withNewSession(new Operation<Object>() {

			@Override
			public Object ex(final Session s, final Object... args)
					throws Exception {
				final AccountType ac = call.getAc();
				final String name = call.getPhysicalId();
				final AccountBean acb = AccountUtil.readAccount(s, ac.getId());
				final ASPolicyBean b = ASUtil.readASPolicy(s, acb.getId(), name);
				s.delete(b);
				return null;
			}
		});
		return null;
	}
}
