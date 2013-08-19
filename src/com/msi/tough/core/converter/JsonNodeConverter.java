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
package com.msi.tough.core.converter;

import org.apache.commons.beanutils.converters.AbstractConverter;
import org.codehaus.jackson.JsonNode;

import com.msi.tough.core.JsonUtil;
import com.msi.tough.core.StringHelper;

public class JsonNodeConverter extends AbstractConverter {

	@Override
	protected String convertToString(final Object value) {
		return JsonUtil.toJsonString(value);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Object convertToType(final Class type, final Object value) {
		if (value instanceof JsonNode) {
			return value;
		}
		if (type.equals(String.class)) {
			return convertToString(value);
		}
		if (value instanceof String) {
			return JsonUtil.load(StringHelper.toInputStream((String) value),
					true);
		}
		throw new IllegalArgumentException("Input value is not of correct type");
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class getDefaultType() {
		return null;
	}
}
