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

import org.slf4j.Logger;

import com.msi.tough.cf.CFType;
import com.msi.tough.core.Appctx;
import com.msi.tough.engine.core.BaseProvider;
import com.msi.tough.engine.core.CallStruct;

public class ApplicationVersion extends BaseProvider {

	private static Logger logger = Appctx.getLogger(ApplicationVersion.class
			.getName());

	@Override
	public CFType create0(final CallStruct call) throws Exception {
		// final String name = (String) task.getRequiredProperty("__NAME__");
		// final MapResource res = new MapResource();
		// res.put("Id", name);
		// return Arrays.asList(new Resource[] { res });
		return null;
	}

	@Override
	protected boolean isResource() {
		return false;
	}
}
