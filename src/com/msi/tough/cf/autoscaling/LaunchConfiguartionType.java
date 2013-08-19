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
package com.msi.tough.cf.autoscaling;

import java.util.Map;

import com.msi.tough.cf.CFType;

public class LaunchConfiguartionType extends CFType {
	private String blockDeviceMappings;
	private String imageId;
	private String instanceType;
	private String kernelId;
	private String keyName;
	private String ramDiskId;
	private String securityGroups;
	private String userData;

	@Override
	public Object getAtt(final String key) {
		return super.getAtt(key);
	}

	public String getBlockDeviceMappings() {
		return blockDeviceMappings;
	}

	public String getImageId() {
		return imageId;
	}

	public String getInstanceType() {
		return instanceType;
	}

	public String getKernelId() {
		return kernelId;
	}

	public String getKeyName() {
		return keyName;
	}

	public String getRamDiskId() {
		return ramDiskId;
	}

	public String getSecurityGroups() {
		return securityGroups;
	}

	public String getUserData() {
		return userData;
	}

	@Override
	public String ref() {
		return getName();
	}

	public void setBlockDeviceMappings(final String blockDeviceMappings) {
		this.blockDeviceMappings = blockDeviceMappings;
	}

	public void setImageId(final String imageId) {
		this.imageId = imageId;
	}

	public void setInstanceType(final String instanceType) {
		this.instanceType = instanceType;
	}

	public void setKernelId(final String kernelId) {
		this.kernelId = kernelId;
	}

	public void setKeyName(final String keyName) {
		this.keyName = keyName;
	}

	public void setRamDiskId(final String ramDiskId) {
		this.ramDiskId = ramDiskId;
	}

	public void setSecurityGroups(final String securityGroups) {
		this.securityGroups = securityGroups;
	}

	public void setUserData(final String userData) {
		this.userData = userData;
	}

	@Override
	public Map<String, Object> toMap() throws Exception {
		final Map<String, Object> map = super.toMap();
		return map;
	}

	@Override
	public String typeAsString() {
		return "AWS::AutoScaling::LaunchConfiguration";
	}

}
