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
package com.msi.tough.engine.utils;

import org.dasein.cloud.compute.VirtualMachine;

import com.amazonaws.services.ec2.model.Instance;
import com.msi.tough.cf.ec2.InstanceType;

public class InstanceUtils {
	public static void toResource(final InstanceType b, final Instance i) {
		// b.setAcId(acId);
		// b.setAvailabilityZone(i.getPlacement().getAvailabilityZone());
		// b.setDatabag(databag);
		// b.setDisableApiTermination(disableApiTermination);
		b.setImageId(i.getImageId());
		// b.setInstanceType(instanceType);
		b.setKernelId(i.getKernelId());
		b.setKeyName(i.getKeyName());
		// b.setLogicalId(logicalId);
		// b.setMonitoring(monitoring);
		// b.setName(name);
		b.setPhysicalId(i.getInstanceId());
		b.setInstanceId(i.getInstanceId());
		final String key = i.getInstanceId();
		String uuid = i.getInstanceId();
		final int c = key.indexOf("(");
		if (c != -1) {
			uuid = uuid.substring(1, uuid.length() - 1).trim();
		}
		b.setUuid(uuid);
		// b.setPlacementGroupName(i.getPlacement());
		// b.setPostWaitUrl(postWaitUrl);
		// b.setPrivateDnsName(privateDnsName);
		b.setPrivateIpAddress(i.getPrivateIpAddress());
		b.setPublicDnsName(i.getPublicDnsName());
		b.setPublicIp(i.getPublicIpAddress());
		b.setRamDiskId(i.getRamdiskId());
		// b.setSecurityGroupIds(securityGroupIds);
		// b.setSourceDestCheck(sourceDestCheck);
		// b.setStackId(stackId);
		// b.setTags(i.getTags());
		// b.setTenancy(tenancy);
		// b.setUserData(userData);
		// b.setVolumes(volumes);
	}

	public static void toResource(final InstanceType b, final VirtualMachine vm) {
		b.setImageId(vm.getProviderMachineImageId());
		// b.setKeyName(vm.get);
		b.setPhysicalId(vm.getProviderVirtualMachineId());
		b.setInstanceId(vm.getProviderVirtualMachineId());
		b.setUuid(b.getInstanceId());
		if (vm.getPrivateIpAddresses() != null
				&& vm.getPrivateIpAddresses().length > 0) {
			b.setPrivateIpAddress(vm.getPrivateIpAddresses()[0]);
		}
		b.setPublicDnsName(vm.getPublicDnsAddress());
		if (vm.getPublicIpAddresses() != null
				&& vm.getPublicIpAddresses().length > 0) {
			b.setPublicIp(vm.getPublicIpAddresses()[0]);
		}
	}
}
