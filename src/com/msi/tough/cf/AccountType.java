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
package com.msi.tough.cf;

import com.msi.tough.engine.resource.Resource;
import com.msi.tough.security.AESSecurity;

public class AccountType implements Resource {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String accessKey;
	private String secretKey;
	private String tenant;
	private String defSecurityGroups;
	private String defKeyName;
	private String defZone;

	public String getAccessKey() {
		return accessKey;
	}

	@Override
	public Object getAtt(final String key) {
		if (key.equals("Id")) {
			return id;
		}
		if (key.equals("Name")) {
			return name;
		}
		if (key.equals("AccessKey")) {
			return accessKey;
		}
		if (key.equals("SecretKey")) {
			return secretKey;
		}
		if (key.equals("DefSecurityGroups")) {
			return defSecurityGroups;
		}
		if (key.equals("DefKeyName")) {
			return defKeyName;
		}
		throw new RuntimeException("invalid key " + key);
	}

	public String getDefKeyName() {
		return defKeyName;
	}

	public String getDefSecurityGroups() {
		return defSecurityGroups;
	}

	public String getDefZone() {
		return defZone;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSecretKey() {
		return AESSecurity.decrypt(secretKey);
	}

	public String getTenant() {
		return tenant;
	}

	@Override
	public Object ref() {
		return this;
	}

	public void setAccessKey(final String accessKey) {
		this.accessKey = accessKey;
	}

	public void setDefKeyName(final String defKeyName) {
		this.defKeyName = defKeyName;
	}

	public void setDefSecurityGroups(final String defSecurityGroups) {
		this.defSecurityGroups = defSecurityGroups;
	}

	public void setDefZone(final String defZone) {
		this.defZone = defZone;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setSecretKey(final String secretKey) {
		this.secretKey = AESSecurity.encrypt(secretKey);
	}

	public void setTenant(final String tenant) {
		this.tenant = tenant;
	}

}
