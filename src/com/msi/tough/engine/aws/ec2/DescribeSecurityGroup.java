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
package com.msi.tough.engine.aws.ec2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dasein.cloud.CloudProvider;
import org.dasein.cloud.network.Firewall;
import org.dasein.cloud.network.FirewallRule;
import org.dasein.cloud.network.FirewallSupport;
import org.dasein.cloud.network.NetworkServices;
import org.slf4j.Logger;

import com.msi.tough.cf.CFType;
import com.msi.tough.cf.ec2.AuthorizeSecurityGroupIngressType;
import com.msi.tough.cf.ec2.SecurityGroupType;
import com.msi.tough.core.Appctx;
import com.msi.tough.engine.core.BaseProvider;
import com.msi.tough.engine.core.CallStruct;

public class DescribeSecurityGroup extends BaseProvider {
	private static Logger logger = Appctx.getLogger(DescribeSecurityGroup.class
			.getName());
	public static String TYPE = "AWS::EC2::DescribeSecurityGroup";

	@Override
	public CFType create0(final CallStruct call) throws Exception {
		final SecurityGroupType ret = new SecurityGroupType();
		final String name = call.getName();
		final CloudProvider cloudProvider = call.getCloudProvider();
		final NetworkServices network = cloudProvider.getNetworkServices();
		final FirewallSupport firewall = network.getFirewallSupport();
		final Firewall g = firewall.getFirewall(name);
		ret.setGroupName(name);
		ret.setGroupDescription(g.getDescription());
		final List<AuthorizeSecurityGroupIngressType> l = new ArrayList<AuthorizeSecurityGroupIngressType>();
		final Collection<FirewallRule> rules = firewall.getRules(name);
		for (final FirewallRule p : rules) {
			final AuthorizeSecurityGroupIngressType ing = new AuthorizeSecurityGroupIngressType();
			final String ruleType = p.getSourceEndpoint().getRuleTargetType().toString();
			ing.setFromPort("" + p.getStartPort());
			ing.setIpProtocol(p.getProtocol().name());
			ing.setToPort("" + p.getEndPort());
			if(ruleType.equals("GLOBAL")){
				final String groupId = p.getSourceEndpoint().getProviderFirewallId();
				ing.setSourceSecurityGroupId(groupId);
				ing.setSourceSecurityGroupName(firewall.getFirewall(groupId).getName());
			}
			else if(ruleType.equals("CIDR")){
				ing.setCidrIp(p.getSourceEndpoint().getCidr());
			}
			l.add(ing);
		}
		// for (final UserIdGroupPair ec2grp : p.getUserIdGroupPairs()) {
		// final AuthorizeSecurityGroupIngressType ing = new
		// AuthorizeSecurityGroupIngressType();
		// ing.setFromPort("" + p.getFromPort());
		// ing.setIpProtocol(p.getIpProtocol());
		// ing.setToPort("" + p.getToPort());
		// ing.setSourceSecurityGroupName(ec2grp.getGroupName());
		// ing.setSourceSecurityGroupOwnerId(ec2grp.getUserId());
		// l.add(ing);
		// }
		// }
		logger.debug("Security Group " + name);
		ret.setSecurityGroupIngress(l);
		return ret;
	}

	@Override
	protected boolean isResource() {
		return false;
	}
}
