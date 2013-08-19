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
package com.msi.tough.dasein;

import org.junit.Test;

public class RackspaceTest {
	@Test
	public void testConnection() throws Exception {
		// // curl -X POST https://identity.api.rackspacecloud.com/v2.0/tokens
		// -d
		// // '{ "auth":{ "RAX-KSKEY:apiKeyCredentials":{ "username":"tscend",
		// // "apiKey":"a4b3a99024593ce3999b4c68a8a17700" } } }' -H
		// // "Content-type: application/json"
		//
		// final String accessKey = "tscend";
		// final String secretKey = "a4b3a99024593ce3999b4c68a8a17700";
		// final String endPoint =
		// "https://identity.api.rackspacecloud.com/v2.0";
		// final String providerName = "Rackspace";
		// final String account = "706238";
		//
		// final ProviderLoader loader = new ProviderLoader();
		// final Map<String, String> prop = MapUtil.create("DSN_PROVIDER_CLASS",
		// NovaOpenStack.class.getName(), "DSN_ENDPOINT", endPoint,
		// /* "DSN_REGION", region, */"DSN_ACCOUNT", account,
		// "DSN_API_SHARED", accessKey, "DSN_API_SECRET", secretKey,
		// "DSN_API_VERSION", "2.0",
		// /*
		// * "DSN_CLOUD_NAME", cloud,
		// */"DSN_CLOUD_PROVIDER", providerName);
		// final CloudProvider provider = loader.getProvider(prop);
		//
		// // final ListImages lister = new ListImages(provider);
		// final ListServers lister = new ListServers(provider);
		// try {
		// lister.list();
		// } finally {
		// provider.close();
		// }
	}
}
