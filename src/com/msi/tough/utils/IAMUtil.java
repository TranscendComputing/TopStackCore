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

import com.msi.tough.model.CertificateBean;

public class IAMUtil {
    @SuppressWarnings("unchecked")
    public static CertificateBean getCertificate(final Session s, final long id) {
        final Query q = s.createQuery("from CertificateBean where id=" + id);
        final List<CertificateBean> l = q.list();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static CertificateBean getCertificate(final Session s,
            final long acid, final String name) {
        final Query q = s.createQuery("from CertificateBean where accountId="
                + acid + " and name='" + name + "'");
        final List<CertificateBean> l = q.list();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }
}
