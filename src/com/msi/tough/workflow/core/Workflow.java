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
/**
 * Transcend Computing, Inc.
 * Confidential and Proprietary
 * Copyright (c) Transcend Computing, Inc. 2013
 * All Rights Reserved.
 */
package com.msi.tough.workflow.core;

import com.google.protobuf.Message;
import com.msi.tough.query.ServiceRequestContext;

public interface Workflow {

    /**
     * Generic workflow processing step.
     *
     * @param request
     * @return
     */
    public Message doWork(Message request, ServiceRequestContext context);

    /**
     * Generic workflow processing step, for bare messages
     *
     * @param request
     * @return
     */
    public void doWorkRaw(Object payload);
}
