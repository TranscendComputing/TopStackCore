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

public class EucalyptusLaunchInstanceTest {
	@Test
	public void testConnection() throws Exception {
		// final String accessKey = "RGDKEBJ0EW6KHEKMKLPQA";
		// final String secretKey = "uZP2v09m60YW8zSvayolpcuNFUL3HBtxrOtdP8ej";
		// final String endPoint =
		// "http://euca3fe.momentumsoftware.com:8773/services";
		// // final String cloud = "essex";
		// final String providerName = "Eucalyptus";
		// // final String region = "nova";
		// final String account = "480836315940";
		//
		// final ProviderLoader loader = new ProviderLoader();
		// final Map<String, String> prop = MapUtil.create("DSN_PROVIDER_CLASS",
		// AWSCloud.class.getName(), "DSN_ENDPOINT", endPoint,
		// /* "DSN_REGION", region, */"DSN_ACCOUNT", account,
		// "DSN_API_SHARED", accessKey, "DSN_API_SECRET", secretKey,
		// // "DSN_API_VERSION", "2.0",
		// /*
		// * "DSN_CLOUD_NAME", cloud,
		// */"DSN_CLOUD_PROVIDER", providerName);
		// final CloudProvider provider = loader.getProvider(prop);
		//
		// // final ListImages lister = new ListImages(provider);
		// try {
		// final ComputeServices comp = provider.getComputeServices();
		// final VirtualMachineSupport vms = comp.getVirtualMachineSupport();
		// final VMLaunchOptions opts = VMLaunchOptions.getInstance(
		// "m1.large", "emi-2B7A3857", "host", "host", "host");
		// opts.withBoostrapKey("rarora");
		// opts.behindFirewalls(new String[] { "rarora" });
		// opts.getMetaData().put("kernelId", "eki-378633D6");
		// opts.getMetaData().put("ramdiskId", "eri-AF813779");
		// final VirtualMachine vm = vms.launch(opts);
		// } finally {
		// provider.close();
		// }
	}
}
