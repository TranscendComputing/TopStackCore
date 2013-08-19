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

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.component.ComponentException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.types.DataTypeFactory;

import com.msi.tough.query.ErrorResponse;

/**
 * <code>ExceptionToErrorResponse</code> converts an exception to an error
 * response, suitable to return to the user.
 */
public class ExceptionToErrorResponse extends AbstractMessageTransformer
{

    public ExceptionToErrorResponse()
    {
        super();
        // This should be com.google.protobuf.Message, but for some reason
        // transformer is invoked twice, the second time with an already
        // transformed object.
        this.registerSourceType(DataTypeFactory.create(Object.class));
        this.setReturnDataType(DataTypeFactory.create(ErrorResponse.class));
    }

    /* (non-Javadoc)
     * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
     */
    @Override
    public Object transformMessage(MuleMessage message, String outputEncoding)
            throws TransformerException {
        Throwable throwable = message.getExceptionPayload().getException();
        if (throwable instanceof ErrorResponse) {
            return (ErrorResponse) throwable;
        }
        if (throwable instanceof ComponentException) {
            ComponentException ce = (ComponentException) throwable;
            ce.setHandled(true);
            if (ce.getCause() instanceof ErrorResponse) {
                return (ErrorResponse) ce.getCause();
            }
        }
        return new ErrorResponse(
                "Provider",
                throwable.getMessage(),
                "InternalFailure", 500);
    }

}
