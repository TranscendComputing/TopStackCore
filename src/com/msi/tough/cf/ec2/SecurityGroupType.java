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
package com.msi.tough.cf.ec2;

import java.util.List;

import com.msi.tough.cf.CFType;

public class SecurityGroupType extends CFType {
	private String groupDescription;
	private String groupName;
	private List<AuthorizeSecurityGroupIngressType> securityGroupIngress;

	@Override
	public Object getAtt(final String key) {
		return null;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public String getGroupName() {
		return groupName;
	}

	public List<AuthorizeSecurityGroupIngressType> getSecurityGroupIngress() {
		return securityGroupIngress;
	}

	@Override
	public Object ref() {
		return groupName;
	}

	public void setGroupDescription(final String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public void setGroupName(final String groupName) {
		this.groupName = groupName;
	}

	public void setSecurityGroupIngress(
			final List<AuthorizeSecurityGroupIngressType> securityGroupIngress) {
		this.securityGroupIngress = securityGroupIngress;
	}
}
