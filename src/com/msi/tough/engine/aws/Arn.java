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
package com.msi.tough.engine.aws;

import com.msi.tough.core.CommaObject;

/**
 * Object wrapper around an Amazon Resource Name (ARN).
 *
 * The format is like:
 * arn:aws:<service>:<region>:<namespace>:<relative-id>
 * where:
 * service is the AWS product
 * namespace is the AWS account ID without hyphens, or a reserved AWS namespace.
 *
 * Some examples:
 * arn:aws:cloudwatch:us-east-1:1234567890:alarm:alarmname
 * arn:aws:sns:us-east-1:1234567890:queuename
 * arn:aws:automate:us-east-1:ec2:stop
 *
 * @author jgardner
 *
 */
public class Arn extends CommaObject {

    private static final int POS_CLOUD = 1;
    private static final int POS_SERVICE = 2;
    private static final int POS_REGION = 3;
    private static final int POS_NAMESPACE = 4;
    private static final int POS_RELATIVE_ID = 5;

    public Arn() {
        super();
        setSeparator(":");
    }

    public Arn(String stringArn) {
        super();
        if (!stringArn.startsWith("arn:")) {
            throw new IllegalArgumentException("ARN is not valid:" + stringArn);
        }
        setSeparator(":");
        setString(stringArn);
    }

    @Override
    /**
     * Unlike base, we need to keep nulls and emtpy strings.
     */
    public void setString(final String in) {
        if (in != null) {
            final String[] sp = in.split(getSeparator());
            if (sp != null && sp.length > 0) {
                for (final String s : sp) {
                    final String t = s.trim();
                    add(t);
                }
            }
        }
    }

    public final String getCloud() {
        return toArray()[POS_CLOUD];
    }

    public final String getService() {
        return toArray()[POS_SERVICE];
    }

    public final String getRegion() {
        return toArray()[POS_REGION];
    }

    public final String getNamespace() {
        return toArray()[POS_NAMESPACE];
    }

    public String getRelativeId() {
        return toArray()[POS_RELATIVE_ID];
    }

    public boolean isOfType(Arn protoArn) {
        String[] parts = toArray();
        int pos = 0;
        for (String val : protoArn.toArray()) {
            if (!val.isEmpty()) {
                if (! val.equals(parts[pos])) {
                    return false;
                }
            }
            pos++;
        }
        return true;
    }
}
