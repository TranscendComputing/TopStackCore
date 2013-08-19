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

public class CFConstrainedStringParameter extends CFDefaultParameter {
	
	private String[] allowedValues = null ;
	private String constraintDescription ;


	CFConstrainedStringParameter( String description, String defaultValue, String constraintDescription, String [] allowedValues ){
		super("String", description, defaultValue );
		this.allowedValues = allowedValues ;
		this.constraintDescription = constraintDescription ;
	}

	@JsonProperty("AllowedValues")
	public String[] getAllowedValues() { return allowedValues ; }

	@JsonProperty("ConstraintDescription")
	public String getConstraintDescription() { return constraintDescription ; }

}
