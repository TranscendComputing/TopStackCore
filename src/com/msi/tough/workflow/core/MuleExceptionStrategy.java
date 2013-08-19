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

import org.mule.component.ComponentException;
import org.mule.exception.CatchMessagingExceptionStrategy;
import org.slf4j.Logger;

import com.msi.tough.core.Appctx;
import com.msi.tough.query.ErrorResponse;

/**
 * Exception strategy for Transcend.
 *
 * Primarily exists to skip logging, since we handle with a dedicated flow.
 *
 * @author jgardner
 *
 */
public class MuleExceptionStrategy extends CatchMessagingExceptionStrategy {
    private final Logger logger = Appctx
            .getLogger(MuleExceptionStrategy.class.getName());

    public MuleExceptionStrategy() {
        super();
    }

    /* (non-Javadoc)
     * @see org.mule.exception.AbstractExceptionListener#logException(java.lang.Throwable)
     */
    @Override
    protected void logException(Throwable t) {
        if (t instanceof ComponentException && t.getCause() != null &&
                t.getCause() instanceof ErrorResponse) {
            // Just log as informational if it's a well formatted error
            // response.
            logger.info("Generated error response: " + t.getCause().getMessage());
            return;
        }
        super.logException(t);
    }

}
