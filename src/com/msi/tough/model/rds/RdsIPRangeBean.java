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

@Entity
@Table(name = "rds_ip_range")
public class RdsIPRangeBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rds_ip_range_id")
	private long id;

	@Column(name = "cidrip", length = 32, nullable = false)
	private String cidrip;

	@Column(name = "status", length = 16, nullable = false)
	private String status = "authorized";

	@Column(name = "rds_sec_grp_id")
	private long rdsSecGroupId;

	public RdsIPRangeBean() {
	}

	public RdsIPRangeBean(final long rdsSecGrpId, final String cidrip) {
		rdsSecGroupId = rdsSecGrpId;
		this.cidrip = cidrip;
	};

	public String getCidrip() {
		return cidrip;
	}

	public long getId() {
		return id;
	}

	public long getRdsSecGroupId() {
		return rdsSecGroupId;
	}

	public String getStatus() {
		return status;
	}

	public void setCidrip(final String cidrip) {
		this.cidrip = cidrip;
	}

	public void setRdsSecGroupId(final long rdsSecGroupId) {
		this.rdsSecGroupId = rdsSecGroupId;
	}

	public void setStatus(final String status) {
		this.status = status;
	}
}
