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
package com.msi.tough.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_log_tag")
public class EventLogTagBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long userId;
	private long eventId;
	private String tag;
	private Date createdTime;

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (!(other instanceof EventLogTagBean)) {
			return false;
		}
		EventLogTagBean that = (EventLogTagBean) other;
		return eventId == that.eventId && tag.equals(that.tag);
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public long getEventId() {
		return eventId;
	}

	public long getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	public long getUserId() {
		return userId;
	}

	@Override
	public int hashCode() {
		return new Long(eventId).hashCode() + tag.hashCode();
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
