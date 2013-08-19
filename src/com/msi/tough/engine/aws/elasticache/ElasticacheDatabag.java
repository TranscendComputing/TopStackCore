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

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;

import com.msi.tough.core.JsonUtil;

public class ElasticacheDatabag {
	
	private ElasticacheConfigDatabagItem config ;
	private ElasticacheParameterGroupDatabagItem parameterGroup;
	
	public ElasticacheDatabag( 
			ElasticacheConfigDatabagItem config, 
			ElasticacheParameterGroupDatabagItem parameterGroup ){
		this.config = config ;
		this.parameterGroup = parameterGroup ;
	}

	@JsonProperty("config")
	public ElasticacheConfigDatabagItem getConfig(){
		return config ;
	}

	@JsonProperty("parametergroup")
	public ElasticacheParameterGroupDatabagItem getParameterGroup(){
		return parameterGroup ;
	}

	public String toJson() throws JsonGenerationException, JsonMappingException, IOException {
		return JsonUtil.toJsonString(this);
	}

}
