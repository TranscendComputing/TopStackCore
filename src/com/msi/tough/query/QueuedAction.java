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
package com.msi.tough.query;

import org.hibernate.Session;

import com.msi.tough.workflow.core.Workflow;

public interface QueuedAction {
    /**
     * Deposit the request for processing.
     * @param req
     * @param resp
     */
    public void process(ServiceRequest req, ServiceResponse resp);

    public String getAction();

    public void setAction(String action);

    public boolean isUseContextSession();

    public void setUseContextSession(boolean useContextSession);

    public Workflow getWorkflow();

    public void setWorkflow(Workflow workflow);

    public Session getSession();

}
