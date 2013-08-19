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
package com.msi.tough.model.elasticache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "elasticache_parameter_group")
public class CacheParameterGroupBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private long acid;

	@Column(name = "family_id")
	private long familyId;

	@Column(name = "name", nullable = false, length = 24)
	private String name;

	// Length is NOT from AWS documentation
	@Column(name = "description", nullable = false, length = 128)
	private String description;

	public long getAcid() {
		return acid;
	}

	public String getDescription() {
		return description;
	}

	public long getFamilyId() {
		return familyId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setAcid(final long acid) {
		this.acid = acid;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public void setFamilyId(final long familyId) {
		this.familyId = familyId;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
