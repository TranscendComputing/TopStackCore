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
package com.msi.tough.cf.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author jlomax
 * 
 *         Could likely have been written as DatabagParameter<T>, but there were
 *         so many odd serializations that and string types it was make a
 *         stringy heirarchy
 */
public class DatabagParameter {

	/**
	 * Factory pattern
	 * 
	 * @param dataType
	 *            (string, integer)
	 * @param value
	 *            (string)
	 * @param isModifiable
	 * @return
	 */
	public static DatabagParameter factory(final String dataType,
			final String value, final boolean isModifiable) {

		if (dataType.equals("integer")) {
			return new DatabagIntParameter(Integer.parseInt(value),
					isModifiable);
		} else if (dataType.equals("boolean")) {
			return new DatabagBooleanParameter(Boolean.parseBoolean(value),
					isModifiable);
		} else {
			return new DatabagStringParameter(value.toString(), isModifiable);
		}
	}

	/**
	 * Factory pattern
	 * 
	 * @param dataType
	 *            (string, integer)
	 * @param value
	 *            (string)
	 * @param isModifiable
	 * @param applyType
	 * @return
	 */
	public static DatabagParameter factory(final String dataType,
			final String value, final boolean isModifiable,
			final String applyType) {
		if (value.charAt(0) == '{') {
			return new DatabagStringParameter(value, isModifiable, applyType);
		}
		if (dataType.equals("string")) {
			return new DatabagStringParameter(value, isModifiable, applyType);
		} else if (dataType.equals("integer")) {
			return new DatabagIntParameter(Integer.parseInt(value),
					isModifiable, applyType);
		} else if (dataType.equals("boolean")) {
			return new DatabagBooleanParameter(Boolean.parseBoolean(value),
					isModifiable, applyType);
		}
		// there is no DataType such as "float", but I'll leave this for now
		else if (dataType.equals("float")) {
			return new DatabagFloatParameter(Float.parseFloat(value),
					isModifiable, applyType);
		}
		return null;
	}

	private final boolean isModifiable;

	private String applyType;

	public DatabagParameter(final boolean isModifiable) {
		this.isModifiable = isModifiable;
	}

	public DatabagParameter(final boolean isModifiable, final String applyType) {
		this(isModifiable);
		this.applyType = applyType;
	}

	@JsonProperty("applyType")
	public String getapplyType() {
		return applyType;
	}

	@JsonProperty("modifiable")
	public boolean getIsModifiable() {
		return isModifiable; // Boolean.toString(isModifiable) ;
	}
}
