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

import com.msi.tough.cf.CFType;

public class ApplicationVersionType extends CFType {
	private String versionLabel;
	private SourceBundleType sourceBundle;

	public SourceBundleType getSourceBundle() {
		return sourceBundle;
	}

	public String getVersionLabel() {
		return versionLabel;
	}

	public void setSourceBundle(SourceBundleType sourceBundle) {
		this.sourceBundle = sourceBundle;
	}

	public void setVersionLabel(String versionLabel) {
		this.versionLabel = versionLabel;
	}

}
