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

public class SourceBundleType extends CFType {
	private String s3Bucket;
	private String s3Key;

	public String getS3Bucket() {
		return s3Bucket;
	}

	public String getS3Key() {
		return s3Key;
	}

	public void setS3Bucket(String s3Bucket) {
		this.s3Bucket = s3Bucket;
	}

	public void setS3Key(String s3Key) {
		this.s3Key = s3Key;
	}

}
