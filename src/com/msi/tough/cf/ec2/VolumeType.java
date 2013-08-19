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

public class VolumeType extends CFType {
	private String availabilityZone;
	private String size;
	private String snapshotId;
	private String volumeId;
	private List<EC2TagType> tags;

	@Override
	public Object getAtt(final String key) {
		return null;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public String getSize() {
		return size;
	}

	public String getSnapshotId() {
		return snapshotId;
	}

	public List<EC2TagType> getTags() {
		return tags;
	}

	public String getVolumeId() {
		return volumeId;
	}

	@Override
	public Object ref() {
		return volumeId;
	}

	public void setAvailabilityZone(final String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public void setSize(final String size) {
		this.size = size;
	}

	public void setSnapshotId(final String snapshotId) {
		this.snapshotId = snapshotId;
	}

	public void setTags(final List<EC2TagType> tags) {
		this.tags = tags;
	}

	public void setVolumeId(final String volumeId) {
		this.volumeId = volumeId;
	}

}
