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

import com.msi.tough.model.SystemDefaultsBean;

public class SystemDefaultsUtil {
	@SuppressWarnings("unchecked")
	public static String getDefault(Session sess, String type) {
		//String sql = "from SystemDefaultsBean where type='" + type + "' and def=true";
		String sql = "from SystemDefaultsBean where type='" + type + "' and def=true";
		Query query = sess.createQuery(sql);
		List<SystemDefaultsBean> l = query.list();
		if (l == null || l.size() != 1) {
			return null;
		}
		return l.get(0).getValue();
	}

	@SuppressWarnings("unchecked")
	public static List<SystemDefaultsBean> getDefaults(Session sess, String type) {
		String sql = "from SystemDefaultsBean where type='" + type + "'";
		Query query = sess.createQuery(sql);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public static String getSystemKeyValue(Session sess, String type, String key) {
		String sql = "from SystemDefaultsBean where type='" + type
				+ "' and key='" + key + "'";
		Query query = sess.createQuery(sql);
		List<SystemDefaultsBean> l = query.list();
		if (l == null || l.size() != 1) {
			return null;
		}
		return l.get(0).getValue();
	}
}
