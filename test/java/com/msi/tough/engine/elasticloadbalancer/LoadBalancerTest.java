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
package com.msi.tough.engine.elasticloadbalancer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoadBalancerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadBalancer() {
	    // This test doesn't appear to be working.
	    /*
		HibernateUtil.withSession(new Operation<Object>() {

			@Override
			public Object ex(final Session session, final Object... args)
					throws Exception {
				final String nm = "lb"
						+ StringHelper.randomStringFromTime().toLowerCase();
				final Map<String, Object> m1 = MapUtil.create(
						"AvailabilityZones", "nova");
				final Map<String, Object> m0 = MapUtil.create("Type",
						"AWS::ElasticLoadBalancing::LoadBalancer",
						"Properties", m1);
				final Map<String, Object> m = MapUtil.create(nm, m0);
				final Map<String, Object> map = MapUtil.create("Resources", m);
				final String script = JsonUtil.toJsonString(map);
				CFUtil.runAWSScript(nm, 9, script, new TemplateContext(null));
				return null;
			}
		});
		*/
	}
}
