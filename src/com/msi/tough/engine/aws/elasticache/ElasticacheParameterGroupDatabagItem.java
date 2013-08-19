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
package com.msi.tough.engine.aws.elasticache;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;

import com.msi.tough.cf.json.DatabagParameter;
import com.msi.tough.core.converter.ToJson;
import com.msi.tough.model.elasticache.CacheNodeTypeBean;
import com.msi.tough.model.elasticache.CacheParameterGroupBean;
import com.msi.tough.model.elasticache.ParameterBean;
import com.msi.tough.utils.EcacheUtil;
import com.mysql.jdbc.StringUtils;

public class ElasticacheParameterGroupDatabagItem implements ToJson {

	private final String Id;
	private LinkedHashMap<String, Object> parameters = null;

	public ElasticacheParameterGroupDatabagItem(final Session session,
			final String Id, final CacheParameterGroupBean parameterGroup,
			final CacheNodeTypeBean nodeType) {
		this.Id = Id;

		// Add regular parameters
		final List<ParameterBean> pbs = EcacheUtil.selectParameterBean(session,
				parameterGroup.getId());
		parameters = new LinkedHashMap<String, Object>();
		for (final ParameterBean p : pbs) {

			if (!StringUtils.isNullOrEmpty(p.getParameterValue())) {
				final DatabagParameter dbp = DatabagParameter.factory(
						p.getDataType(), p.getParameterValue(),
						p.isModifiable());
				parameters.put(p.getName(), dbp);
			}
		}
	}

	@JsonProperty("id")
	public String getId() {
		return Id;
	}

	@JsonProperty("Parameters")
	public LinkedHashMap<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(final LinkedHashMap<String, Object> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toJson() throws JsonGenerationException,
			JsonMappingException, IOException {
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}

}
