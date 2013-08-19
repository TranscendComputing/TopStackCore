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
package com.msi.tough.core;

import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.springframework.util.PropertyPlaceholderHelper;

public class SystemEnvUtils {
	private static Logger logger = Appctx.getLogger(SystemEnvUtils.class
			.getName());

	private static Properties properties = null;

	public static String expand(final String str) {
		if (properties == null) {
			properties = System.getProperties();
			final Map<String, String> env = System.getenv();
			for (final String envName : env.keySet()) {
				properties.put(envName, env.get(envName));
			}
		}
		final PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper(
				"${", "}");
		return helper.replacePlaceholders(str, properties);
	}

	public static void expandMap(final Map<String, Object> map) {
		for (final String k : map.keySet()) {
			final Object v = map.get(k);
			if (v instanceof String && ((String) v).indexOf('$') != -1) {
				final String vn = expand((String) v);
				map.put(k, vn);
				logger.debug("expanding " + v.toString() + " to " + vn);
			}
		}
	}
}
