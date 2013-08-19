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
 * Copyright (c) Transcend Computing, Inc. 2012
 * All Rights Reserved.
 */
package com.msi.tough.query;

import java.util.Map;

/**
 * Generic service response for TopStack services.
 *
 * Typically corresponds to a HTTP response content and meta-data.
 *
 * @author jgardner
 *
 */
public class ServiceResponse {

    private Map<String, String[]> responseMap;

    private Object payload;

    /** Content type of response payload. */
    private String contentType;

    /** Request ID to which this is a response. */
    private final String requestId;

    public ServiceResponse(final Object payload, final String requestId) {
        this.payload = payload;
        this.requestId = requestId;
        contentType = "xml";
    }

    /**
     * @return the payload
     */
    public Object getPayload() {
        return payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public String getContentType() {
        return contentType;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }
    /**
     * @return the responseMap
     */
    public Map<String, String[]> getResponseMap() {
        return responseMap;
    }

    /**
     * @param responseMap the responseMap to set
     */
    public void setResponseMap(Map<String, String[]> responseMap) {
        this.responseMap = responseMap;
    }
}
