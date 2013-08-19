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
@Table(name = "node_specific_value")
public class CacheNodeTypeSpecificValueBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "parameter_id", nullable = false)
	private long parameterId;

	@Column(name = "node_type_id", nullable = false)
	private long nodeTypeId;

	@Column(name = "parameter_value", nullable = false, length = 256)
	private String parameterValue;

	public int getId() {
		return id;
	}

	public long getNodeTypeId() {
		return nodeTypeId;
	}

	public long getParameterId() {
		return parameterId;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setNodeTypeId(final long nodeTypeId) {
		this.nodeTypeId = nodeTypeId;
	}

	public void setParameterId(final long parameterId) {
		this.parameterId = parameterId;
	}

	public void setParameterValue(final String parameterValue) {
		this.parameterValue = parameterValue;
	}

}
