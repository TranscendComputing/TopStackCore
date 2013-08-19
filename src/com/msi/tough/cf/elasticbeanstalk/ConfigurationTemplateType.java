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
package com.msi.tough.cf.elasticbeanstalk;

import java.util.List;

import com.msi.tough.cf.CFType;

public class ConfigurationTemplateType extends CFType {
	private String templateName;
	private List<OptionSettingsType> optionSettings;
	private String solutionStackName;
	private SourceConfigurationType sourceConfiguration;

	public List<OptionSettingsType> getOptionSettings() {
		return optionSettings;
	}

	public String getSolutionStackName() {
		return solutionStackName;
	}

	public SourceConfigurationType getSourceConfiguration() {
		return sourceConfiguration;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setOptionSettings(List<OptionSettingsType> optionSettings) {
		this.optionSettings = optionSettings;
	}

	public void setSolutionStackName(String solutionStackName) {
		this.solutionStackName = solutionStackName;
	}

	public void setSourceConfiguration(
			SourceConfigurationType sourceConfiguration) {
		this.sourceConfiguration = sourceConfiguration;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

}
