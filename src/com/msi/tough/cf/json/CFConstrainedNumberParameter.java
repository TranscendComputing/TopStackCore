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

public class CFConstrainedNumberParameter extends CFDefaultParameter {

	private int minValue ;
	private int maxValue ;
	private String constraintDescription ;
 
	
	public CFConstrainedNumberParameter ( String description, int defaultValue, int minValue, int maxValue, String constraintDescription ) {
		super( "Number", description, Integer.toString(defaultValue));

		this.minValue = minValue ;
		this.maxValue = maxValue ;
		this.constraintDescription = constraintDescription ;
	}

	@JsonProperty("ConstraintDescription")
	public String getConstraintDescription() { return constraintDescription ; }
	
	@JsonProperty("MaxValue")
	public String getMaxValue() { return Integer.toString(maxValue); }
	
	@JsonProperty("MinValue")
	public String getMinValue() { return Integer.toString(minValue); }
	
}
