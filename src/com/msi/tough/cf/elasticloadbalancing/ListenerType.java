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
package com.msi.tough.cf.elasticloadbalancing;

import java.util.List;
import java.util.Map;

import com.msi.tough.cf.CFType;
import com.msi.tough.core.MapUtil;

public class ListenerType extends CFType {
	private String instancePort;
	private String loadBalancerPort;
	private String protocol;
	private String SSLCertificateId;
	private List<PolicyNameType> policyNames;

	public String getInstancePort() {
		return instancePort;
	}

	public String getLoadBalancerPort() {
		return loadBalancerPort;
	}

	public List<PolicyNameType> getPolicyNames() {
		return policyNames;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getSSLCertificateId() {
		return SSLCertificateId;
	}

	public void setInstancePort(final String instancePort) {
		this.instancePort = instancePort;
	}

	public void setLoadBalancerPort(final String loadBalancerPort) {
		this.loadBalancerPort = loadBalancerPort;
	}

	public void setPolicyNames(final List<PolicyNameType> policyNames) {
		this.policyNames = policyNames;
	}

	public void setProtocol(final String protocol) {
		this.protocol = protocol;
	}

	public void setSSLCertificateId(final String sSLCertificateId) {
		SSLCertificateId = sSLCertificateId;
	}

	@Override
	public Map<String, Object> toMap() throws Exception {
		final Map<String, Object> map = MapUtil.create("InstancePort",
				instancePort, "LoadBalancerPort", loadBalancerPort, "Protocol",
				protocol);
		if (SSLCertificateId != null) {
			map.put("SSLCertificateId", SSLCertificateId);
		}
		// private final List<PolicyNameType> policyNames;
		return map;
	}
}
