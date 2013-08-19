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
package com.msi.tough.cf.elasticache;

import com.msi.tough.cf.CFType;

public class SecurityGroupType extends CFType {
	private String cacheClusterId;
	private String cacheNodeType;
	private String engine;
	private String engineVersion;
	private String numCacheNodes;
	private String cacheClusterCreateTime;
	private String cacheClusterStatus;
	private String preferredAvailabilityZone;
	private String PreferredMaintenanceWindow;

	public String getCacheClusterCreateTime() {
		return cacheClusterCreateTime;
	}

	public String getCacheClusterId() {
		return cacheClusterId;
	}

	public String getCacheClusterStatus() {
		return cacheClusterStatus;
	}

	public String getCacheNodeType() {
		return cacheNodeType;
	}

	public String getEngine() {
		return engine;
	}

	public String getEngineVersion() {
		return engineVersion;
	}

	public String getNumCacheNodes() {
		return numCacheNodes;
	}

	public String getPreferredAvailabilityZone() {
		return preferredAvailabilityZone;
	}

	public String getPreferredMaintenanceWindow() {
		return PreferredMaintenanceWindow;
	}

	@Override
	public Object ref() {
		return getName();
	}

	public void setCacheClusterCreateTime(final String cacheClusterCreateTime) {
		this.cacheClusterCreateTime = cacheClusterCreateTime;
	}

	public void setCacheClusterId(final String cacheClusterId) {
		this.cacheClusterId = cacheClusterId;
	}

	public void setCacheClusterStatus(final String cacheClusterStatus) {
		this.cacheClusterStatus = cacheClusterStatus;
	}

	public void setCacheNodeType(final String cacheNodeType) {
		this.cacheNodeType = cacheNodeType;
	}

	public void setEngine(final String engine) {
		this.engine = engine;
	}

	public void setEngineVersion(final String engineVersion) {
		this.engineVersion = engineVersion;
	}

	public void setNumCacheNodes(final String numCacheNodes) {
		this.numCacheNodes = numCacheNodes;
	}

	public void setPreferredAvailabilityZone(
			final String preferredAvailabilityZone) {
		this.preferredAvailabilityZone = preferredAvailabilityZone;
	}

	public void setPreferredMaintenanceWindow(
			final String preferredMaintenanceWindow) {
		PreferredMaintenanceWindow = preferredMaintenanceWindow;
	}
}
