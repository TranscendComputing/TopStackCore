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

//Valid AWS types as of 2011-11-06
//memcached1.4

@Entity
@Table(name = "elasticache_parameter_family")
public class CacheParameterGroupFamilyBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "family", nullable = false, length = 24)
	private String family;

	public CacheParameterGroupFamilyBean() {
	}

	public CacheParameterGroupFamilyBean(final String family) {
		this();
		this.family = family;
	}

	// Getters

	public String getFamily() {
		return family;
	}

	public int getId() {
		return id;
	}

}
