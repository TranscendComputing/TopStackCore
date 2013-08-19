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

import java.util.Map;

import com.msi.tough.cf.CFType;

public class AppCookieStickinessPolicyType extends CFType implements
		PolicyNameType {
	private String cookieName;
	private String policyName;

	public String getCookieName() {
		return cookieName;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setCookieName(final String cookieName) {
		this.cookieName = cookieName;
	}

	public void setPolicyName(final String policyName) {
		this.policyName = policyName;
	}

	@Override
	public Map<String, Object> toMap() throws Exception {
		final Map<String, Object> map = super.toMap();
		map.put("CookieName", cookieName);
		map.put("PolicyName", policyName);
		return map;
	}

}
