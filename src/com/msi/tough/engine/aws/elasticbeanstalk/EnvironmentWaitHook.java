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
package com.msi.tough.engine.aws.elasticbeanstalk;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.slf4j.Logger;

import com.msi.tough.core.Appctx;
import com.msi.tough.core.JsonUtil;
import com.msi.tough.engine.core.WaitHook;
import com.msi.tough.model.EnvironmentBean;
import com.msi.tough.utils.EBSUtil;

/**
 * Wait hook to be called on transcend_loadbalancer chef role installtion
 * completion
 * 
 * @author raj
 * 
 */
public class EnvironmentWaitHook implements WaitHook {
	private static Logger logger = Appctx.getLogger(EnvironmentWaitHook.class
			.getName());

	@Override
	public void postWait(final Session s, final boolean success,
			final long acid, final String stackId, final String physicalId,
			final String parameter, final Map<String, String[]> map) {
		logger.debug("EnvironmentWaitHook " + acid + " " + stackId + " "
				+ physicalId + " " + parameter);
		// convert passed back parameter to Map using JSON
		if (parameter != null) {
			final Map<String, Object> m = JsonUtil.toMap(JsonUtil
					.load(parameter));
		}

		// change the environment status to ready
		final List<EnvironmentBean> leb = EBSUtil.selectEnvironments(s, acid,
				null, null, physicalId, null);
		final EnvironmentBean eb = leb.get(0);
		eb.setStatus("ready");
		s.save(eb);
	}
}
