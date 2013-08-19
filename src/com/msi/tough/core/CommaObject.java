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

import java.util.List;

public class CommaObject extends GenericCommaObject<String> {

	public CommaObject() {
	    super();
	    sampleObj = new String();
	}

	public CommaObject(final List<String> in) {
        super(in);
	}

	public CommaObject(final String in) {
		this();
		setString(in);
	}

    public void setString(final String in) {
        if (in != null) {
            final String[] sp = StringHelper.split(in, getSeparator());
            if (sp != null && sp.length > 0) {
                for (final String s : sp) {
                    final String t = s.trim();
                    if (t != null && t.length() > 0) {
                        add(t);
                    }
                }
            }
        }
    }

	public void add(final String item) {
	    if (!toList().contains(item)) {
	        list.add(item);
	    }
	}

    public boolean isEmpty(String item) {
        return item == null || item.length() == 0;
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
				sb.append(getSeparator());
			}
			sb.append(s);
		}
		return sb.toString();
	}
}
