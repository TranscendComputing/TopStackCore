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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "as_scheduled")
public class ASScheduledBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "name")
	private String Name;

	@Column(name = "grp_name")
	private String grpName;

	@Column(name = "capacity")
	private int capacity;

	@Column(name = "min_size")
	private int minSize;

	@Column(name = "max_size")
	private int maxSize;

	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "end_time")
	private Date endTime;

	@Column(name = "recurrence")
	private String recurrence;

	public int getCapacity() {
		return capacity;
	}

	public Date getEndTime() {
		return endTime;
	}

	public String getGrpName() {
		return grpName;
	}

	public long getId() {
		return id;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public int getMinSize() {
		return minSize;
	}

	public String getName() {
		return Name;
	}

	public String getRecurrence() {
		return recurrence;
	}

	public Date getStartTime() {
		return startTime;
	}

	public long getUserId() {
		return userId;
	}

	public void setCapacity(final int capacity) {
		this.capacity = capacity;
	}

	public void setEndTime(final Date endTime) {
		this.endTime = endTime;
	}

	public void setGrpName(final String grpName) {
		this.grpName = grpName;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setMaxSize(final int maxSize) {
		this.maxSize = maxSize;
	}

	public void setMinSize(final int minSize) {
		this.minSize = minSize;
	}

	public void setName(final String name) {
		Name = name;
	}

	public void setRecurrence(final String recurrence) {
		this.recurrence = recurrence;
	}

	public void setStartTime(final Date startTime) {
		this.startTime = startTime;
	}

	public void setUserId(final long userId) {
		this.userId = userId;
	}

}
