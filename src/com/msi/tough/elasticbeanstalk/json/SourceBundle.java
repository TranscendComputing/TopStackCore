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

public class SourceBundle {
	@JsonProperty("S3Bucket")
	private String S3Bucket;
	@JsonProperty("S3Key")
	private String S3Key;
	
	public SourceBundle(String bucket, String key){
		this.S3Bucket = bucket;
		this.S3Key = key;
	}
}
