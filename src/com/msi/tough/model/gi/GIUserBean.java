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
package com.msi.tough.model.gi;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table( name = "gi_user")
public class GIUserBean {
	
	@Id
	@Column( name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column( name = "user_name")	
	private String username;
	
	@Column( name = "keypair")	
	private String keypair;

	@Column( name = "metadata")	
	private String metadata;

	@Column( name = "user_id")
	private String userid;

	@Column( name = "admin_status")
	@Type( type = "boolean")
	private boolean adminstatus;
	
	public GIUserBean(){
		
	}
		
	public GIUserBean(String name, String key, boolean status){
		username = name;
		keypair = key;
		adminstatus = status;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long givenId){
		id = givenId;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String givenName){
		username = givenName;
	}
	
	public String getKeypair(){
		return keypair;
	}
	
	public void setKeypair(String givenKey){
		keypair = givenKey;
	}
	
	public String getMetadata(){
		return metadata;
	}

	public void setMetadata(String recipe){
		metadata = recipe;
	}
	
	public String getUserid(){
		return userid;
	}
	
	public void setUserid(String i){
		userid = i; 
	}
	
	public boolean getAdminstatus(){
		return adminstatus;
	}
	
	public void setAdminstatus(boolean status){
		adminstatus = status;
	}
	
}
