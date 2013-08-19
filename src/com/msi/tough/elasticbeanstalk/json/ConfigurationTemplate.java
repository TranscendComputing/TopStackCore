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

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ConfigurationTemplate {
	@JsonProperty("TemplateName")
	private String name;
	
	@JsonProperty("Description")
	private String description = "";
	
	@JsonProperty("OptionSettings")
	private List<OptionSetting> opSettings = null;
	
	@JsonProperty("OptionsToRemove")
	private List<OptionToRemove> opRemove = null;
	
	public ConfigurationTemplate(String name, String desc){
		this.name = name;
		this.opSettings = new ArrayList<OptionSetting>();
		this.opRemove = new ArrayList<OptionToRemove>();
		if(desc == null){
			this.description = "";
		}
	}
	
	public void addOptionSetting(OptionSetting os){
		this.opSettings.add(os);
	}
	
	public void addOptionToRemove(OptionToRemove otr){
		this.opRemove.add(otr);
	}
}
