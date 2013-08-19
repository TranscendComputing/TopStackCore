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

public class ScalingPolicyType extends CFType {
	private String adjustmentType;
	private String autoScalingGroupName;
	private String cooldown;
	private String scalingAdjustment;

	public String getAdjustmentType() {
		return adjustmentType;
	}

	@Override
	public Object getAtt(final String key) {
		return super.getAtt(key);
	}

	public String getAutoScalingGroupName() {
		return autoScalingGroupName;
	}

	public String getCooldown() {
		return cooldown;
	}

	public String getScalingAdjustment() {
		return scalingAdjustment;
	}

	@Override
	public String ref() {
		return getName();
	}

	public void setAdjustmentType(final String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public void setAutoScalingGroupName(final String autoScalingGroupName) {
		this.autoScalingGroupName = autoScalingGroupName;
	}

	public void setCooldown(final String cooldown) {
		this.cooldown = cooldown;
	}

	public void setScalingAdjustment(final String scalingAdjustment) {
		this.scalingAdjustment = scalingAdjustment;
	}

	@Override
	public Map<String, Object> toMap() throws Exception {
		final Map<String, Object> map = super.toMap();
		return map;
	}

	@Override
	public String typeAsString() {
		return "AWS::AutoScaling::ScalingPolicy";
	}

}
