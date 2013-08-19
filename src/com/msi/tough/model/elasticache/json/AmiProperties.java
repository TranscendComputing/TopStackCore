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
package com.msi.tough.model.elasticache.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class AmiProperties {
	
	private static String MSIChefRoles = "__MSI_Chef_Roles__" ;
	private static String MSIChefRole = "__MSI_Chef_Role__" ;
	
	private String type ;
	private LinkedHashMap<String,Object> Properties = null ;

	public AmiProperties(){
		this.Properties = new LinkedHashMap<String, Object>();
	}
	public AmiProperties( String type ){
		this();
		this.type = type;
	}
	
	@JsonProperty("Type")
	public String getType() { return type ;} 
	@JsonProperty("Properties")
	public LinkedHashMap<String,Object> getProperties() { return Properties; }

	public void setType( String type ) { this.type = type ; }
	public void setProperties( LinkedHashMap<String,Object> properties) { this.Properties = properties ; }

	public void setProperties( 
			//String imageId, 
			//String kernelId, 
			//String ramdiskId, 
			int numCacheNodes,
			String instanceType, 
			String availabilityZone,
			String [] securityGroups,
			String keyName)
	{
		//Properties.put("ImageId", imageId) ;
		//Properties.put("KernelId", kernelId) ;
		//Properties.put("RamdiskId", ramdiskId) ;
		Properties.put("NumCacheNodes", numCacheNodes);
		Properties.put("InstanceType", instanceType) ;
		Properties.put("AvailabilityZone", availabilityZone) ;

		Properties.put("SecurityGroups", securityGroups) ;
		Properties.put("KeyName", keyName);
	}
	
	public void setChefRoles( String [] roleList ){
		
		ArrayList<Map<String,String>> roles = new ArrayList<Map<String,String>>() ;
		for( String roleName : roleList){
			Map<String,String> role = new HashMap<String,String>() ;
			role.put(MSIChefRole, roleName);
			roles.add(role);
		}
		Properties.put(MSIChefRoles, roles) ;
	}

}
