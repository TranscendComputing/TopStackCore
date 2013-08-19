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
package com.msi.tough.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RdsAvailabilityZone generated by hbm2java
 */
@Entity
@Table(name = "azmap")
public class AZMapBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "availability_zone")
	private String availabilityZone;

	@Column(name = "map_type")
	private String mapType;

	@Column(name = "map_key")
	private String mapKey;

	@Column(name = "map_value")
	private String mapValue;

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public long getId() {
		return id;
	}

	public String getMapKey() {
		return mapKey;
	}

	public String getMapType() {
		return mapType;
	}

	public String getMapValue() {
		return mapValue;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMapKey(String mapKey) {
		this.mapKey = mapKey;
	}

	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	public void setMapValue(String mapValue) {
		this.mapValue = mapValue;
	}

}
