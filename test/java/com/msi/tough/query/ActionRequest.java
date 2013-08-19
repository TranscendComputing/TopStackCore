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

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Utility class for making requests against AbstractAction-derived classes.
 *
 * @author jgardner
 *
 */
public class ActionRequest {
    final Map<String, String[]> parameterMap =
            new HashMap<String, String[]>();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    public void put(String key, String value) {
        parameterMap.put(key, new String[] {value});
    }

    public void putList(String key, String[] values) {
        for (int i = 0; i < values.length; i++) {
            put(key + ".member."+(i+1), values[i]);
        }
    }

    public void put(String key, Integer value) {
        this.put(key, value.toString());
    }

    public void put(String key, Double value) {
        this.put(key, value.toString());
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Map<String, String[]> getMap() {
        return parameterMap;
    }

    /**
     * Reset request, to allow reuse.
     */
    public void reset() {
        parameterMap.clear();
        request.clearAttributes();
        response = new MockHttpServletResponse();
    }

}
