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
package com.msi.tough.model.rds;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dkim
 *
 */
@Entity
@Table(name = "rds_ec2_security_group")
public class RdsEC2SecurityGroupBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rds_ec2_security_group_id")
	private long id;

	@Column(name = "ec2_security_group_name", length = 64, nullable = false)
	private String secGrpName;

	@Column(name = "ec2_security_group_owner_id", length = 64, nullable = false)
	private String secGroupOwnId;

	@Column(name = "status", length = 16, nullable = false)
	private String status = "authorized";

	@Column(name = "rds_sec_grp_id")
	private long rdsSecGroupId;
	
	@Column(name = "ec2_sec_grp_id")
	private String ec2SecGroupId;

	public RdsEC2SecurityGroupBean() {
	};

	public RdsEC2SecurityGroupBean(final long rdsSecGroupId,
			final String secGrpName, final String ec2SecGrpId, final String secGroupOwnId) {
		this();
		this.rdsSecGroupId = rdsSecGroupId;
		this.secGrpName = secGrpName;
		this.secGroupOwnId = secGroupOwnId;
		this.ec2SecGroupId = ec2SecGrpId;
	};

	public long getId() {
		return id;
	}

	public String getName() {
		return secGrpName;
	}

	public String getOwnId() {
		return secGroupOwnId;
	}

	public long getRdsSecGroupId() {
		return rdsSecGroupId;
	}

	public String getSecGroupOwnId() {
		return secGroupOwnId;
	}

	public String getSecGrpName() {
		return secGrpName;
	}

	public String getStatus() {
		return status;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setRdsSecGroupId(final long rdsSecGroupId) {
		this.rdsSecGroupId = rdsSecGroupId;
	}

	public void setSecGroupOwnId(final String secGroupOwnId) {
		this.secGroupOwnId = secGroupOwnId;
	}

	public void setSecGrpName(final String secGrpName) {
		this.secGrpName = secGrpName;
	}
	
	public void setStatus(final String status) {
		this.status = status;
	}

	public String getEc2SecGroupId() {
		return ec2SecGroupId;
	}

	public void setEc2SecGroupId(String ec2SecGroupId) {
		this.ec2SecGroupId = ec2SecGroupId;
	}
	
	
}
