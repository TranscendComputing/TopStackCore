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
package com.msi.tough.engine.core;

import java.util.Map;

import org.hibernate.Session;

/**
 * Hook to be called by PostWait event in ASInternal
 * 
 * @author raj
 * 
 */
public interface WaitHook {
	/**
	 * This method to called by ASInternal
	 * 
	 * @param s
	 *            Database Session to use
	 * @param success
	 *            whether chef role implementation was success or failure
	 * @param acid
	 *            ID of the account which owns the resource
	 * @param stackId
	 *            ID of the stack to which this resource belongs
	 * @param parameter
	 *            Parameters passed back, they are defined at the time of
	 *            resource creation
	 */
	public void postWait(final Session s, boolean success, long acid,
			String stackId, String physicalId, String resourceData,
			Map<String, String[]> map);
}
