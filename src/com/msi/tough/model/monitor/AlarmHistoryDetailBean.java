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
package com.msi.tough.model.monitor;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alarm_hist")
public class AlarmHistoryDetailBean {
	//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String alarmName;
	@Column(name = "timestamp")
	private Calendar timestamp;
	@Column(name = "type")
	private String type;
	@Column(name = "summary")
	private String summary;
	@Column(name = "data")
	private String data;

	public String getAlarmName() {
		return alarmName;
	}

	public String getData() {
		return data;
	}

	public Long getId() {
		return id;
	}

	public String getSummary() {
		return summary;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public String getType() {
		return type;
	}

	public void setAlarmName(final String alarmName) {
		this.alarmName = alarmName;
	}

	public void setData(final String data) {
		this.data = data;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setSummary(final String summary) {
		this.summary = summary;
	}

	public void setTimestamp(final Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public void setType(final String type) {
		this.type = type;
	}

}
