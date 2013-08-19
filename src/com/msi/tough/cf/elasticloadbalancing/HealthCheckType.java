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

public class HealthCheckType extends CFType {
	private String healthyThreshold;
	private String interval;
	private String target;
	private String timeout;
	private String unhealthyThreshold;

	public String getHealthyThreshold() {
		return healthyThreshold;
	}

	public String getInterval() {
		return interval;
	}

	public String getTarget() {
		return target;
	}

	public String getTimeout() {
		return timeout;
	}

	public String getUnhealthyThreshold() {
		return unhealthyThreshold;
	}

	public void setHealthyThreshold(final String healthyThreshold) {
		this.healthyThreshold = healthyThreshold;
	}

	public void setInterval(final String interval) {
		this.interval = interval;
	}

	public void setTarget(final String target) {
		this.target = target;
	}

	public void setTimeout(final String timeout) {
		this.timeout = timeout;
	}

	public void setUnhealthyThreshold(final String unhealthyThreshold) {
		this.unhealthyThreshold = unhealthyThreshold;
	}

	@Override
	public Map<String, Object> toMap() throws Exception {
		final Map<String, Object> map = super.toMap();
		map.put("HealthyThreshold", healthyThreshold);
		map.put("Interval", interval);
		map.put("Target", target);
		map.put("Timeout", timeout);
		map.put("UnhealthyThreshold", unhealthyThreshold);
		return map;
	}

}
