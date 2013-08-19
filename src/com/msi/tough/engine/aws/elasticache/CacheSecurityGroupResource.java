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

public class CacheSecurityGroupResource {
	private String type ;
	private LinkedHashMap<String,Object> properties = null ;
	private String name ;
	
	public CacheSecurityGroupResource( String name, String description ){
		properties = new LinkedHashMap<String, Object>() ;

		this.name = name ;
		this.type = "AWS::ElastiCache::SecurityGroup" ;

		properties.put("Description", description );
	}

	@JsonProperty("Type")
	public String getType() { return type ;} 

	@JsonProperty("Properties")
	public LinkedHashMap<String, Object> getProperties() { return properties; }

	@JsonIgnore
	public String getName() { return name ; }

	public void setType( String type ) { this.type = type ; }
	public void setProperties( LinkedHashMap<String,Object> properties) { this.properties = properties ; }
	public void setProperties( String description ){
		properties.put("Description", description ) ;
	}
	public void setName( String name ) { this.name = name ; }
}
