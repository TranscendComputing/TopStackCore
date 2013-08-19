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

import java.util.Map;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.msi.tough.core.Appctx;
import com.msi.tough.engine.core.WaitHook;

/**
 * Wait hook to be called on transcend_memcached chef role installation
 * completion
 * 
 * @author raj
 * 
 */
public class ElasticacheClusterWaitHook implements WaitHook {
	private static Logger logger = Appctx
			.getLogger(ElasticacheClusterWaitHook.class.getName());

	@Override
	public void postWait(final Session s, final boolean success,
			final long acid, final String stackId, final String physicalId,
			final String parameter, Map<String, String[]> map) {

		// convert passed back parameter to Map using JSON
		// if (parameter != null) {
		// final Map<String, Object> m = JsonUtil.toMap(JsonUtil
		// .load(parameter));
		// }
		//
		// logger.debug("Changing status of Cluster " + physicalId);
		//
		// final AccountBean ac = AccountUtil.readAccount(s, acid);
		// final CacheClusterBean cc = EcacheUtil.getCacheClusterBean(s,
		// ac.getId(), physicalId);
		// if (cc != null) {
		// cc.setCacheClusterStatus("ready");
		// }
		// s.save(cc);
	}
}
