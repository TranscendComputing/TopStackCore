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

import java.util.List;

import com.msi.tough.cf.CFType;

public class UserType extends CFType {
	String path;
	List<GroupType> groups;
	LoginProfileType loginProfile;
	List<PolicyType> policies;
	String userName;
	String arn;

	@Override
	public Object getAtt(String key) {
		if (key.equals("Arn")) {
			return arn;
		}
		return super.getAtt(key);
	}

	@Override
	public Object ref() {
		return userName;
	}

	@Override
	public String typeAsString() {
		return "AWS::IAM::User";
	}

}
