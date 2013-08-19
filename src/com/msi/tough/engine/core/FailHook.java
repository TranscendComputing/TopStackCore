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

/**
 * Hook to be called by PostWait event in ASInternal
 * 
 * @author raj
 * 
 */
public interface FailHook {
	public void endFail(long acid, String stackId, String physicalId,
			String parameter);

	/**
	 * This method to called when creation of a stack fails
	 * 
	 * @param acid
	 *            ID of the account which owns the resource
	 * @param stackId
	 *            ID of the stack to which this resource belongs
	 * @param physicalkId
	 *            ID of the of the resource failed
	 * @param parameter
	 *            Parameters passed back, they are defined at the time of
	 *            resource creation
	 */
	public void startFail(long acid, String stackId, String physicalId,
			String parameter);
}
