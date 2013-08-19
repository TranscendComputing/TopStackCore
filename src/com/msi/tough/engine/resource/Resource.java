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
package com.msi.tough.engine.resource;

/**
 * Interface to be implemented by all Resources
 * 
 * @author raj
 * 
 */
public interface Resource {
	/**
	 * Get value for attributes defined by the AWS CF for this resource
	 * 
	 * @param key
	 *            attribute name
	 * @return attribute value
	 */
	public Object getAtt(String key);

	/**
	 * Ref value for the resource as defined by AWS CF documentation
	 * 
	 * @return reference value
	 */
	public Object ref();
}
