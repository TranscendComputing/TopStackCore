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
package com.msi.tough.instance;

import java.util.Map;

public class EucaSetup {
	private Map<String, Object> config;

	public Map<String, Object> getConfig() {
		return config;
	}

	public void setConfig(Map<String, Object> config) {
		this.config = config;
	}

	public String setup() {
		StringBuilder sb = new StringBuilder();
		sb.append("export EUCA_SERVER=").append(config.get("EUCA_SERVER"))
				.append("\n").append("export EUCA_KEY_DIR=").append(
						config.get("EUCA_KEY_DIR")).append("\n").append(
						"export EC2_ACCESS_KEY=").append(
						config.get("EC2_ACCESS_KEY")).append("\n").append(
						"export EC2_SECRET_KEY=").append(
						config.get("EC2_SECRET_KEY")).append("\n").append(
						"export S3_URL=").append(config.get("S3_URL")).append(
						"\n").append("export EC2_URL=").append(
						config.get("EC2_URL")).append("\n").append(
						"export EC2_PRIVATE_KEY=").append(
						config.get("EC2_PRIVATE_KEY")).append("\n").append(
						"export EC2_CERT=").append(config.get("EC2_CERT"))
				.append("\n").append("export EC2_JVM_ARGS=").append(
						config.get("EC2_JVM_ARGS")).append("\n").append(
						"export EUCALYPTUS_CERT=").append(
						config.get("EUCALYPTUS_CERT")).append("\n").append(
						"export EC2_USER_ID=")
				.append(config.get("EC2_USER_ID")).append("\n");
		return sb.toString();
	}
}
