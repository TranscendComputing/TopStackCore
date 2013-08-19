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
package com.msi.tough.engine.aws.elasticache;

import java.util.LinkedHashMap;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.msi.tough.core.JsonUtil;
import com.msi.tough.utils.Constants;

public class CacheSecurityGroupIngressResource {
	private final String type;
	private LinkedHashMap<String, Object> properties = null;
	private final String cacheSecurityGroupName;

	public CacheSecurityGroupIngressResource(
			final String cacheSecurityGroupName,
			final String ec2SecurityGroupName,
			final String ec2SecurityGroupOwnerId) {
		properties = new LinkedHashMap<String, Object>();

		type = Constants.SECURITYGROUPINGRESSTYPE;

		// properties.put("CacheSecurityGroupName", JsonUtil.toSingleHash("Ref",
		// cacheSecurityGroupName ));
		// properties.put("EC2SecurityGroupName",
		// JsonUtil.toSingleHash("Ref","WebServerSecurityGroup"));
		this.cacheSecurityGroupName = cacheSecurityGroupName;

		properties.put("CacheSecurityGroupName",
				JsonUtil.toSingleHash("Ref", cacheSecurityGroupName));
		if (ec2SecurityGroupName != null) {
			properties
					.put(Constants.EC2SECURITYGROUPNAME, ec2SecurityGroupName);

			if (ec2SecurityGroupOwnerId != null) {
				properties.put(Constants.EC2SECURITYGROUPOWNERID,
						ec2SecurityGroupOwnerId);
			}
		}
	}

	@JsonIgnore
	public String getCacheSecurityGroupName() {
		return cacheSecurityGroupName;
	}

	@JsonProperty("Properties")
	public LinkedHashMap<String, Object> getProperties() {
		return properties;
	}

	@JsonProperty("Type")
	public String getType() {
		return type;
	}

}
