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

public class PolicyType extends CFType {
	private String policyName;
	private String policyDocument;
	private List<GroupType> groups;
	private List<UserType> users;

	@Override
	public Object getAtt(String key) {
		return super.getAtt(key);
	}

	public List<GroupType> getGroups() {
		return groups;
	}

	public String getPolicyDocument() {
		return policyDocument;
	}

	public String getPolicyName() {
		return policyName;
	}

	public List<UserType> getUsers() {
		return users;
	}

	public void setGroups(List<GroupType> groups) {
		this.groups = groups;
	}

	public void setPolicyDocument(String policyDocument) {
		this.policyDocument = policyDocument;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public void setUsers(List<UserType> users) {
		this.users = users;
	}

	@Override
	public String typeAsString() {
		return "AWS::IAM::Policy";
	}

}
