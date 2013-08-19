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

import org.codehaus.jackson.annotate.JsonProperty;

public class OptionSetting{
	
	private String NameSpace;
	
	private String OptionName;
	
	private String Value;

	public OptionSetting(String NameSpace, String OptionName, String Value){
		this.NameSpace = NameSpace;
		this.OptionName = OptionName;
		this.Value = Value;
	}

	@JsonProperty("Namespace")
	public String getNamespace(){
		return this.NameSpace;
	}

	@JsonProperty("OptionName")
	public String getOptionName(){
		return this.OptionName;
	}

	@JsonProperty("Value")
	public String getOptionValue(){
		return this.Value;
	}
}