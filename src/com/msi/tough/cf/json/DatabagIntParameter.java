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
package com.msi.tough.cf.json;

import org.codehaus.jackson.annotate.JsonProperty;

public class DatabagIntParameter extends DatabagParameter {
	
	private int value ;
	
	public DatabagIntParameter( int value, boolean isModifiable ){
		super( isModifiable ) ;
		this.value = value ;
	}
	
	public DatabagIntParameter( int value, boolean isModifiable, String applyType ){
		super( isModifiable, applyType ) ;
		this.value = value ;
	}
	
	@JsonProperty("value")
	public int getValue(){
		return value ;
	}
}
