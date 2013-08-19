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

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.msi.tough.model.monitor.AlarmBean;

@Entity
@Table(name = "alarm_tally")
public class AlarmTallyBean {
	@Id
	private Long id;
	// Alarm
	private AlarmBean alarm;
	// instanceId
	private String instanceId;
	// count this period
	private int count = 0;
	// period start
	private Calendar periodStart;
	
	public AlarmBean getAlarm() {
		return alarm;
	}

	public void setAlarm(AlarmBean alarm) {
		this.alarm = alarm;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Calendar getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(Calendar periodStart) {
		this.periodStart = periodStart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
}
