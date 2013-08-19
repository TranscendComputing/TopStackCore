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
package com.msi.tough.utils;

import java.util.HashMap;
import java.util.Map;

import com.msi.tough.cf.AccountType;
import com.msi.tough.cf.ec2.VolumeType;
import com.msi.tough.engine.aws.ec2.SecurityGroup;
import com.msi.tough.engine.aws.ec2.Volume;
import com.msi.tough.engine.core.CallStruct;
import com.msi.tough.engine.core.TemplateContext;

public class VolumeUtil {

	public static VolumeType createVolume(final AccountType ac,
			final String name, final TemplateContext ctx,
			final String parentId, final String stackId,
			final String availabilityZone, final int allocatedStorage)
			throws Exception {

		final CallStruct c = new CallStruct();
		c.setAc(ac);
		c.setCtx(ctx == null ? new TemplateContext(null) : ctx);
		c.setParentId(parentId);
		c.setStackId(stackId);
		c.setName(name);
		c.setAvailabilityZone(availabilityZone);
		c.setType(Volume.TYPE);

		final Volume vol = new Volume();
		final Map<String, Object> prop = new HashMap<String, Object>();
		prop.put(Constants.AVAILABILITYZONE, availabilityZone);
		prop.put("Size", allocatedStorage);
		c.setProperties(prop);
		final VolumeType volumeInfo = (VolumeType) vol.create(c);
		return volumeInfo;
	}
	
	public static VolumeType createDBSnapshotVolume(final AccountType ac,
			final String name, final TemplateContext ctx,
			final String parentId, final String stackId,
			final String availabilityZone, final int allocatedStorage, final String failHook)
			throws Exception {

		final CallStruct c = new CallStruct();
		c.setAc(ac);
		c.setCtx(ctx == null ? new TemplateContext(null) : ctx);
		c.setParentId(parentId);
		c.setStackId(stackId);
		c.setName(name);
		c.setAvailabilityZone(availabilityZone);
		c.setType(Volume.TYPE);

		final Volume vol = new Volume();
		final Map<String, Object> prop = new HashMap<String, Object>();
		prop.put(Constants.AVAILABILITYZONE, availabilityZone);
		prop.put("Size", allocatedStorage);
		c.setProperties(prop);
		final VolumeType volumeInfo = (VolumeType) vol.create(c);
		return volumeInfo;
	}

	public static void deleteVolume(final AccountType ac, final String stackId,
			final String availabilityZone, final String volId) throws Exception {

		final CallStruct c = new CallStruct();
		c.setAc(ac);
		c.setCtx(new TemplateContext(null));
		c.setStackId(stackId);
		c.setAvailabilityZone(availabilityZone);
		c.setName(volId);
		final Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(Constants.AVAILABILITYZONE, availabilityZone);
		c.setProperties(properties);
		c.setType(SecurityGroup.TYPE);
		final Volume provider = new Volume();
		provider.delete(c);
	}
}
