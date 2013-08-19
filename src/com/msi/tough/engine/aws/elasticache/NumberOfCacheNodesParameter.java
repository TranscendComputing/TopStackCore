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

import org.codehaus.jackson.annotate.JsonProperty;

public class NumberOfCacheNodesParameter {

	private String defaultNodeCount ;
	private String description ;
	private String type ;
	private int minValue ;
	private int maxValue ;
	private String constraintDescription ;

	public NumberOfCacheNodesParameter(){
		defaultNodeCount = "1" ;
		description = "The number of Cache Nodes the Cache Cluster should have" ;
		type = "Number" ;
		minValue = 1;
		maxValue = 20 ;
		constraintDescription = "must be between 1 and 20." ;
	}

	@JsonProperty("Default")
	public String getDefault() { return defaultNodeCount; }

	@JsonProperty("Description")
	public String getDescription() { return description; }

	@JsonProperty("Type")
	public String getType() { return type ; }

	@JsonProperty("MinValue")
	public int getMinValue() { return minValue; }

	@JsonProperty("MaxValue")
	public int getMaxValue() { return maxValue; }

	@JsonProperty("ConstraintDescription")
	public String getConstraintDescription() { return constraintDescription ; }
}
