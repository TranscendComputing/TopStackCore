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
package com.msi.tough.engine.aws.elasticache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClient;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.msi.tough.core.Appctx;
import com.msi.tough.core.converter.ToJson;
import com.msi.tough.model.AccountBean;
import com.msi.tough.utils.ChefUtil;

public class ElasticacheServiceUtils {

	final static Logger logger = LoggerFactory
			.getLogger(ElasticacheServiceUtils.class);

	public static void CallCloudFormation(final AccountBean ac) {

		// NOT in use, this is an example WS call

		final BasicAWSCredentials cred = new BasicAWSCredentials(
				ac.getAccessKey(), ac.getSecretKey());
		final AmazonCloudFormationClient client = new com.amazonaws.services.cloudformation.AmazonCloudFormationClient(
				cred);

		final String url = (String) Appctx.getConfiguration().get(
				"CloudFormationURL");
		logger.debug("CloudFormation URL" + url);

		client.setEndpoint(url);

		// Object o = new
		// com.amazonaws.services.cloudformation.model.CreateStackRequest();
		final CreateStackRequest request = new CreateStackRequest();
		client.createStack(request);
	}

	private static boolean createDatabagItem(final ChefUtil chefUtil,
			final String dataBagName, final String dataBagItemName,
			final ToJson databag) {

		boolean createdSuccessfully = true;
		try {
			ChefUtil.createDatabagItem(dataBagName, dataBagItemName);
			ChefUtil.putDatabagItem(dataBagName, dataBagItemName,
					databag.toJson());
		} catch (final Exception ex) {
			logger.debug("Exception creating Data Bag Item " + dataBagName
					+ " " + ex.getMessage());
			createdSuccessfully = false;
		}
		return createdSuccessfully;
	}

	public static boolean createElasticacheDatabag(final String dataBagName,
			final ElasticacheDatabag dataBag) {

		boolean createdSuccessfully = true;

		try {
			final ChefUtil chefUtil = new ChefUtil();

			ChefUtil.createDatabag(dataBagName);

			createdSuccessfully = createDatabagItem(chefUtil, dataBagName,
					"config", dataBag.getConfig());
			if (createdSuccessfully) {
				createdSuccessfully = createDatabagItem(chefUtil, dataBagName,
						"parameters", dataBag.getParameterGroup());
			}
		} catch (final Exception ex) {
			ex.printStackTrace();
			logger.debug("Exception creating Data Bag Item " + dataBagName
					+ " " + ex.getMessage());
			createdSuccessfully = false;
		}

		return createdSuccessfully;
	}

}
