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
package com.msi.tough.core;

import org.apache.commons.beanutils.ConvertUtilsBean;
import org.codehaus.jackson.JsonNode;

import com.msi.tough.core.converter.JsonNodeConverter;

public class ConvertUtils extends ConvertUtilsBean {
	public ConvertUtils() {
		register(new JsonNodeConverter(), JsonNode.class);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Object value, Class targetType) {
		if (value.getClass() == targetType) {
			return value;
		}
		return super.convert(value, targetType);
	}
}
