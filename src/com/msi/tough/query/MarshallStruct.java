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

import java.util.Map;

import com.generationjava.io.xml.XMLNode;

public class MarshallStruct<T> {
    static public final String RESPONSE_METADATA = "ResponseMetadata";
    static public final String REQUESTID = "RequestId";

    private final T mainObject;
    private final String requestId;
    private String contentType;
    private Map<String, Object> otherData;

    public MarshallStruct(final T mainObject, final String requestId) {
        this.mainObject = mainObject;
        this.requestId = requestId;
        contentType = "xml";
    }

    /*
     * @param parentNode XMLNode parent, if null, create a new parent
     *
     * @param parentNodeName String name of the parent node if created
     *
     * @return XMLNode parentNode
     */
    public XMLNode addResponseMetadata(XMLNode parentNode,
            final String parentNodeName) {
        final XMLNode nodeMetadata = new XMLNode(RESPONSE_METADATA);

        if (parentNode == null) {
            parentNode = new XMLNode(parentNodeName);
        }
        parentNode.addNode(nodeMetadata);

        final XMLNode nodeRequestId = new XMLNode(REQUESTID);
        nodeMetadata.addNode(nodeRequestId);
        final XMLNode nodeRequestIdText = new XMLNode();
        nodeRequestIdText.setPlaintext(getRequestId());
        nodeRequestId.addNode(nodeRequestIdText);

        return parentNode;
    }

    public String getContentType() {
        return contentType;
    }

    public T getMainObject() {
        return mainObject;
    }

    public Map<String, Object> getOtherData() {
        return otherData;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    public void setOtherData(final Map<String, Object> otherData) {
        this.otherData = otherData;
    }

}
