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
package com.msi.tough.utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.msi.tough.model.AZMapBean;

public class AZUtil {
    @SuppressWarnings("unchecked")
    public static String getMap(Session session, String azone, String type,
            String key) {
        Query q = session
                .createQuery("from AZMapBean where availabilityZone ='" + azone
                        + "' and mapType='" + type + "' and mapKey = '" + key
                        + "'");
        List<AZMapBean> l = q.list();
        if (l == null || l.size() != 1) {
            return null;
        }
        return l.get(0).getMapValue();
    }
}
