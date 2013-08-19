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

public class ApplicationVersion {
	@JsonProperty("VersionLabel")
	private String versionLabel;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("SourceBundle")
	private SourceBundle sourceBundle;
	
	public ApplicationVersion(String label, String desc, SourceBundle s){
		this.versionLabel = label;
		this.sourceBundle = s;
		if(desc == null){
			this.description = "";
		}
	}
	
	public ApplicationVersion(String label, String desc, String S3Bucket, String S3Key){
		this.versionLabel = label;
		this.sourceBundle = new SourceBundle(S3Bucket, S3Key);
		if(desc == null){
			this.description = "";
		}
	}
}
