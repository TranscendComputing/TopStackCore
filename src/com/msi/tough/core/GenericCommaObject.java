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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GenericCommaObject <T> {
	private String separator = ",";
	protected List<T> list;
	/** A sample object; subtypes must either set this, or handle null response from toArray. */
	protected T sampleObj;

	public GenericCommaObject() {
		list = new ArrayList<T>();
	}

	public GenericCommaObject(final List<T> in) {
		list = in == null ? new ArrayList<T>() : new ArrayList<T>(in);
	}

	public void add(final T item) {
		if (!toList().contains(item)) {
			list.add(item);
		}
	}

	public List<T> getList() {
		return list;
	}

	public String getSeparator() {
		return separator;
	}

	public void remove(final T item) {
		list.remove(item);
	}

	public void setList(final List<T> list) {
		this.list = list;
	}

	public void setSeparator(final String separator) {
		this.separator = separator;
	}

	@SuppressWarnings("unchecked")
    public T[] toArray() {
	    if (list.size() > 0) {
	        return (T[]) list.toArray((T[])Array.newInstance(list.get(0).getClass(), list.size()));
	    }
	    if (sampleObj != null) {
	        return (T[]) list.toArray((T[])Array.newInstance(sampleObj.getClass(), list.size()));
	    }
	    return null;
	}

	public List<T> toList() {
		return list;
	}

	public boolean isEmpty(T item) {
	    return item == null;
	}

	@Override
	public String toString() {
		if (list.size() == 0) {
			return null;
		}
		final StringBuilder sb = new StringBuilder();
		int i = 0;
		for (final T s : list) {
			if (isEmpty(s)) {
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
