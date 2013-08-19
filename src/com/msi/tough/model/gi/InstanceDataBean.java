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


@Entity
@Table( name = "gi_instancedata")
public class InstanceDataBean {

	@Id
	@Column( name = "long_id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)		
	private long id;
	
	@Column( name = "instance_id")	
	private String instance_id;	
	
	@Column( name = "kernel_id")	
	private String kernel;
	
	@Column( name = "ramdisk_id")	
	private String ramdisk;
	
	@Column( name = "disk_id")	
	private String disk;
	
	@Column( name = "type")	
	private String type;
	
	@Column( name = "keypair")	
	private String keypair;
	
	@Column( name = "metadata")	
	private String metadata;
	
	public InstanceDataBean(){
		
	}
	
	public InstanceDataBean(String givenID, String eki, String eri, String emi, String givenType){
		instance_id = givenID;
		kernel = eki;
		ramdisk = eri;
		disk = emi;
		type = givenType;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long givenId){
		id = givenId;
	}
	
	public String getInstance_id(){
		return instance_id;
	}
	
	public void setInstance_id(String givenInstance){
		instance_id = givenInstance;
	}
	
	public String getKernel(){
		return kernel;
	}
	
	public void setKernel(String givenKernel){
		kernel = givenKernel;
	}
	
	public String getRamdisk(){
		return ramdisk;
	}
	
	public void setRamdisk(String givenRam){
		ramdisk = givenRam;
	}
	
	public String getDisk(){
		return disk;
	}
	
	public void setDisk(String givenDisk){
		disk = givenDisk;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String givenType){
		type = givenType;
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
	
	public void setMetadata(String givenMeta){
		metadata = givenMeta;
	}
}
