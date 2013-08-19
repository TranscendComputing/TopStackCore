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

import com.msi.tough.cf.CFType;

public class AuthorizeSecurityGroupIngressType extends CFType {
	private String groupName;
	private String groupId;
	private String ipProtocol;
	private String cidrIp;
	private String sourceSecurityGroupName;
	private String sourceSecurityGroupId;
	private String sourceSecurityGroupOwnerId;
	private String fromPort;
	private String toPort;

	@Override
	public Object getAtt(final String key) {
		return null;
	}

	public String getCidrIp() {
		return cidrIp;
	}

	public String getFromPort() {
		return fromPort;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getIpProtocol() {
		return ipProtocol;
	}

	public String getSourceSecurityGroupId() {
		return sourceSecurityGroupId;
	}

	public String getSourceSecurityGroupName() {
		return sourceSecurityGroupName;
	}

	public String getSourceSecurityGroupOwnerId() {
		return sourceSecurityGroupOwnerId;
	}

	public String getToPort() {
		return toPort;
	}

	public void setCidrIp(final String cidrIp) {
		this.cidrIp = cidrIp;
	}

	public void setFromPort(final String fromPort) {
		this.fromPort = fromPort;
	}

	public void setGroupId(final String groupId) {
		this.groupId = groupId;
	}

	public void setGroupName(final String groupName) {
		this.groupName = groupName;
	}

	public void setIpProtocol(final String ipProtocol) {
		this.ipProtocol = ipProtocol;
	}

	public void setSourceSecurityGroupId(final String sourceSecurityGroupId) {
		this.sourceSecurityGroupId = sourceSecurityGroupId;
	}

	public void setSourceSecurityGroupName(final String sourceSecurityGroupName) {
		this.sourceSecurityGroupName = sourceSecurityGroupName;
	}

	public void setSourceSecurityGroupOwnerId(
			final String sourceSecurityGroupOwnerId) {
		this.sourceSecurityGroupOwnerId = sourceSecurityGroupOwnerId;
	}

	public void setToPort(final String toPort) {
		this.toPort = toPort;
	}

}
