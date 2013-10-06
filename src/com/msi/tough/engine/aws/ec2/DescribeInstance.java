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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.codehaus.jackson.node.ArrayNode;
import org.dasein.cloud.CloudProvider;
import org.dasein.cloud.compute.ComputeServices;
import org.dasein.cloud.compute.VirtualMachine;
import org.dasein.cloud.compute.VirtualMachineSupport;
import org.slf4j.Logger;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.msi.tough.cf.AccountType;
import com.msi.tough.cf.CFType;
import com.msi.tough.cf.ec2.InstanceType;
import com.msi.tough.core.Appctx;
import com.msi.tough.dasein.DaseinHelper;
import com.msi.tough.engine.core.BaseProvider;
import com.msi.tough.engine.core.CallStruct;
import com.msi.tough.engine.utils.InstanceUtils;
import com.msi.tough.model.AccountBean;

public class DescribeInstance extends BaseProvider {
	private final static Logger logger = Appctx
			.getLogger(DescribeInstance.class.getName());
	public static String TYPE = "AWS::EC2::DescribeInstance";

	@SuppressWarnings("unchecked")
	@Override
	public CFType create0(final CallStruct call) throws Exception {
		final AccountType ac = call.getAc();

        final CloudProvider cloudProvider = DaseinHelper.getProvider(
                ac.getDefZone(), ac.getTenant(),
                ac.getAccessKey(), ac.getSecretKey());
        final ComputeServices comp = cloudProvider.getComputeServices();

        final VirtualMachineSupport vmServ = comp.getVirtualMachineSupport();

		final InstanceType ins = new InstanceType();
		ins.setAvailabilityZone((String) call.getProperty("AvailabilityZone"));


		final Object ids = call.getProperty("InstanceIds");
        final Collection<String> instanceIds = new ArrayList<String>();
		if (ids != null) {
			if (ids instanceof ArrayNode) {
				final ArrayNode an = (ArrayNode) ids;
				for (int i = 0; i < an.size(); i++) {
					instanceIds.add(an.get(i).getTextValue());
				}
			} else if (ids instanceof List) {
				final List<String> an = (List<String>) ids;
				for (final String i : an) {
					instanceIds.add(i);
				}
			} else {
				instanceIds.add(ids.toString());
			}
		}
		for (final String instanceId : instanceIds) {
		    VirtualMachine vm = vmServ.getVirtualMachine(instanceId);
			InstanceUtils.toResource(ins, vm, ins.getAvailabilityZone());
		}
		logger.debug("Instance " + ins.getInstanceId() + " "
				+ ins.getPublicIp());
		return ins;
	}

	@Override
	protected boolean isResource() {
		return false;
	}
}
