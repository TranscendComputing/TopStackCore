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
package com.msi.tough.utils;

import java.util.Arrays;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.msi.tough.cf.AccountType;

public class AWSUtil {
	public static AmazonEC2Client getClient(final AccountType ac,
			final String avZone) {
		try {
			final BasicAWSCredentials cred = new BasicAWSCredentials(
					ac.getAccessKey(), ac.getSecretKey());
			final String endpoint = (String) ConfigurationUtil
					.getConfiguration(Arrays.asList(new String[] { "EC2_URL",
							avZone }));
			final AmazonEC2Client ec2 = new AmazonEC2Client(cred);
			ec2.setEndpoint(endpoint);
			return ec2;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
