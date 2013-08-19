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
package com.msi.tough.cf.iam;

import com.msi.tough.cf.CFType;

public class AccessKeyType extends CFType {
	String serial;
	String status;
	String userName;
	String accessKeyId;
	String secretAccessKey;

	public String getAccessKeyId() {
		return accessKeyId;
	}

	@Override
	public Object getAtt(String key) {
		if (key.equals("SecretAccessKey")) {
			return secretAccessKey;
		}
		return super.getAtt(key);
	}

	public String getSecretAccessKey() {
		return secretAccessKey;
	}

	public String getSerial() {
		return serial;
	}

	public String getStatus() {
		return status;
	}

	public String getUserName() {
		return userName;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public void setSecretAccessKey(String secretAccessKey) {
		this.secretAccessKey = secretAccessKey;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String typeAsString() {
		return "AWS::IAM::AccessKey";
	}

}
