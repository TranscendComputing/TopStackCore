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
package com.msi.tough.core;

import java.util.ArrayList;
import java.util.List;

public class SlashObject {
	private String separator = "/";
	private List<String> list;

	public SlashObject() {
		list = new ArrayList<String>();
	}

	public SlashObject(final List<String> in) {
		list = in == null ? new ArrayList<String>() : new ArrayList<String>(in);
	}

	public SlashObject(final String in) {
		this();
		if (in != null) {
			final String[] sp = StringHelper.split(in, separator);
			if (sp != null && sp.length > 0) {
				for (final String s : sp) {
					final String t = s.trim();
					if (t != null && t.length() > 0) {
						list.add(t);
					}
				}
			}
		}
	}

	public void add(final String str) {
		if (!toList().contains(str)) {
			list.add(str);
		}
	}

	public List<String> getList() {
		return list;
	}

	public String getSeparator() {
		return separator;
	}

	public void remove(final String str) {
		list.remove(str);
	}

	public void setList(final List<String> list) {
		this.list = list;
	}

	public void setSeparator(final String separator) {
		this.separator = separator;
	}

	public String[] toArray() {
		return list.toArray(new String[0]);
	}

	public List<String> toList() {
		return list;
	}

	@Override
	public String toString() {
		if (list.size() == 0) {
			return null;
		}
		final StringBuilder sb = new StringBuilder();
		int i = 0;
		for (final String s : list) {
			if (s == null || s.length() == 0) {
				continue;
			}
			if (i++ != 0) {
				sb.append(separator);
			}
			sb.append(s);
		}
		return sb.toString();
	}
}
