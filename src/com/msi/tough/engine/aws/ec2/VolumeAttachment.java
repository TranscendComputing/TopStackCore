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
package com.msi.tough.engine.aws.ec2;

import org.slf4j.Logger;

import com.msi.tough.cf.CFType;
import com.msi.tough.core.Appctx;
import com.msi.tough.engine.core.BaseProvider;
import com.msi.tough.engine.core.CallStruct;

public class VolumeAttachment extends BaseProvider {
	private static Logger logger = Appctx.getLogger(VolumeAttachment.class
			.getName());
	public static String TYPE = "AWS::EC2::VolumeAttachment";

	@Override
	public CFType create0(final CallStruct call) throws Exception {
		return Volume.attach(call);
	}

	@Override
	protected boolean isResource() {
		return true;
	}
}
