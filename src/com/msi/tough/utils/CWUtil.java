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

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.msi.tough.cf.cloudwatch.MetricDimensionType;
import com.msi.tough.core.QueryBuilder;
import com.msi.tough.model.monitor.AlarmBean;
import com.msi.tough.model.monitor.DimensionBean;

public class CWUtil {

    public static AlarmBean getAlarmBean(final Session session,
            final long acid, final String name) {
        @SuppressWarnings("unchecked")
        final List<AlarmBean> a = session.createQuery(
                "from AlarmBean where userId=" + acid + " and alarmName='"
                        + name + "'").list();
        if (a.size() > 0) {
            return a.get(0);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static DimensionBean getDimensionBean(final Session session,
            final long acid, final String key, final String value,
            final boolean addNew) throws Exception {
        QueryBuilder qb = new QueryBuilder("from DimensionBean as d,").append(
                "InstanceBean as i").equals("d.key", key);
        // If seeking instances, look by ec2Id as well as UUID.
        if ("InstanceId".equals(key)) {
            qb.append("and (d.value = i.ec2Id").equals("i.instanceId", value)
                    .append(") or ( 1=1").equals("d.value", value).append(")");
        } else {
            qb.equals("d.value", value);
        }
        final Query q = qb.toQuery(session);
        final List<Object> l = q.list();
        if (l.size() > 0) {
            Object o = l.get(0);
            if (o instanceof DimensionBean) {
                return (DimensionBean) o;
            }
            if (o instanceof Object[]) {
                return (DimensionBean) ((Object[]) o)[0];
            }
        }
        if (addNew) {
            final DimensionBean b = new DimensionBean();
            b.setKey(key);
            b.setValue(value);
            session.save(b);
            return b;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static List<MetricDimensionType> toMetricDimensionList(
            final Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            throw new RuntimeException("Not a list");
        }
        final List<MetricDimensionType> l = new ArrayList<MetricDimensionType>();
        for (final Object o : (List<Object>) obj) {
            if (o instanceof MetricDimensionType) {
                l.add((MetricDimensionType) o);
                continue;
            } else if (o instanceof JsonNode) {
                final JsonNode j = (JsonNode) o;
                final MetricDimensionType a = new MetricDimensionType();
                if (j.get("Name") != null) {
                    a.setName(j.get("Name").getValueAsText());
                }
                if (j.get("Value") != null) {
                    a.setValue(j.get("Value").getValueAsText());
                }
                l.add(a);
                continue;
            }
            throw new RuntimeException("Couldn't convert " + o);
        }
        return l;
    }

}
