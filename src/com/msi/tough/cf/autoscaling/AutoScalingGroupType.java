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

public class AutoScalingGroupType extends CFType {
	private String availabilityZones;
	private String cooldown;
	private String desiredCapacity;
	private String healthCheckGracePeriod;
	private String healthCheckType;
	private String launchConfigurationName;
	private String loadBalancerNames;
	private String maxSize;
	private String minSize;
	private String notificationConfiguration;
	private String tags;

	@Override
	public Object getAtt(final String key) {
		return super.getAtt(key);
	}

	public String getAvailabilityZones() {
		return availabilityZones;
	}

	public String getCooldown() {
		return cooldown;
	}

	public String getDesiredCapacity() {
		return desiredCapacity;
	}

	public String getHealthCheckGracePeriod() {
		return healthCheckGracePeriod;
	}

	public String getHealthCheckType() {
		return healthCheckType;
	}

	public String getLaunchConfigurationName() {
		return launchConfigurationName;
	}

	public String getLoadBalancerNames() {
		return loadBalancerNames;
	}

	public String getMaxSize() {
		return maxSize;
	}

	public String getMinSize() {
		return minSize;
	}

	public String getNotificationConfiguration() {
		return notificationConfiguration;
	}

	public String getTags() {
		return tags;
	}

	@Override
	public String ref() {
		return getName();
	}

	public void setAvailabilityZones(final String availabilityZones) {
		this.availabilityZones = availabilityZones;
	}

	public void setCooldown(final String cooldown) {
		this.cooldown = cooldown;
	}

	public void setHealthCheckGracePeriod(final String healthCheckGracePeriod) {
		this.healthCheckGracePeriod = healthCheckGracePeriod;
	}

	public void setHealthCheckType(final String healthCheckType) {
		this.healthCheckType = healthCheckType;
	}

	public void setLaunchConfigurationName(final String launchConfigurationName) {
		this.launchConfigurationName = launchConfigurationName;
	}

	public void setLoadBalancerNames(final String loadBalancerNames) {
		this.loadBalancerNames = loadBalancerNames;
	}

	public void setMaxSize(final String maxSize) {
		this.maxSize = maxSize;
	}

	public void setMinSize(final String minSize) {
		this.minSize = minSize;
	}

	public void setNotificationConfiguration(
			final String notificationConfiguration) {
		this.notificationConfiguration = notificationConfiguration;
	}

	public void setTags(final String tags) {
		this.tags = tags;
	}

	@Override
	public Map<String, Object> toMap() throws Exception {
		final Map<String, Object> map = super.toMap();
		return map;
	}

	@Override
	public String typeAsString() {
		return "AWS::AutoScaling::AutoScalingGroup";
	}

}
