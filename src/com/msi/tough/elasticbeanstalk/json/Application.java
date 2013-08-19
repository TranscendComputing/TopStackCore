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
package com.msi.tough.elasticbeanstalk.json;

import java.util.LinkedHashMap;

import org.codehaus.jackson.annotate.JsonProperty;

import com.msi.tough.core.JsonUtil;

public class Application {
	
	@JsonProperty("Type")
	private String type;
	
	@JsonProperty("Properties")
	private LinkedHashMap<String,Object> properties = null ;
	
	public Application(){
		this.type = "AWS::ElasticBeanstalk::Application";
		this.properties = new LinkedHashMap<String, Object>();
	}
	
	public void addProperty(String key, Object value){
		this.properties.put(key, value);
	}
	
	/*public void addRefParameter( LinkedHashMap<String,Object> properties, String parameter ){
		properties.put(parameter, JsonUtil.toSingleHash("Ref", parameter)) ;
	}*/
	
	
}
