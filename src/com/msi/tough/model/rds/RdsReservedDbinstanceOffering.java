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

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * RdsReservedDbinstanceOffering generated by hbm2java
 */
@Entity
@Table(name = "rds_reserved_dbinstance_offer")
public class RdsReservedDbinstanceOffering {

	private String reservedDbinstanceOfferingId;
	private String dbinstanceClass;
	private String productDescription;
	private Integer duration;
	private Double fixedPrice;
	private Double usagePrice;
	private Boolean multiAz;

	public RdsReservedDbinstanceOffering() {
	}

	public RdsReservedDbinstanceOffering(String reservedDbinstanceOfferingId) {
		this.reservedDbinstanceOfferingId = reservedDbinstanceOfferingId;
	}

	public RdsReservedDbinstanceOffering(String reservedDbinstanceOfferingId,
			String dbinstanceClass, String productDescription,
			Integer duration, Double fixedPrice, Double usagePrice,
			Boolean multiAz) {
		this.reservedDbinstanceOfferingId = reservedDbinstanceOfferingId;
		this.dbinstanceClass = dbinstanceClass;
		this.productDescription = productDescription;
		this.duration = duration;
		this.fixedPrice = fixedPrice;
		this.usagePrice = usagePrice;
		this.multiAz = multiAz;
	}

	public String getDbinstanceClass() {
		return dbinstanceClass;
	}

	public Integer getDuration() {
		return duration;
	}

	public Double getFixedPrice() {
		return fixedPrice;
	}

	public Boolean getMultiAz() {
		return multiAz;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public String getReservedDbinstanceOfferingId() {
		return reservedDbinstanceOfferingId;
	}

	public Double getUsagePrice() {
		return usagePrice;
	}

	public void setDbinstanceClass(String dbinstanceClass) {
		this.dbinstanceClass = dbinstanceClass;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public void setFixedPrice(Double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public void setMultiAz(Boolean multiAz) {
		this.multiAz = multiAz;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setReservedDbinstanceOfferingId(
			String reservedDbinstanceOfferingId) {
		this.reservedDbinstanceOfferingId = reservedDbinstanceOfferingId;
	}

	public void setUsagePrice(Double usagePrice) {
		this.usagePrice = usagePrice;
	}

}
