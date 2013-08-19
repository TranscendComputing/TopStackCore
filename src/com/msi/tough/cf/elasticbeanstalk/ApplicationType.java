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

public class ApplicationType extends CFType {
	private String description;
	private List<ApplicationVersionType> applicationVersions;
	private List<ConfigurationTemplateType> configurationTemplates;

	public List<ApplicationVersionType> getApplicationVersions() {
		return applicationVersions;
	}

	public List<ConfigurationTemplateType> getConfigurationTemplates() {
		return configurationTemplates;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public Object ref() {
		return getName();
	}

	public void setApplicationVersions(
			List<ApplicationVersionType> applicationVersions) {
		this.applicationVersions = applicationVersions;
	}

	public void setConfigurationTemplates(
			List<ConfigurationTemplateType> configurationTemplates) {
		this.configurationTemplates = configurationTemplates;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
