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

import com.msi.tough.engine.resource.Resource;

public class AssociateAddressType implements Resource {
	private String availabilityZone;
	private String publicIp;

	@Override
	public Object getAtt(String key) {
		if (key.equals("PublicIp")) {
			return publicIp;
		}
		return null;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public String getPublicIp() {
		return publicIp;
	}

	@Override
	public Object ref() {
		return this;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}

}
