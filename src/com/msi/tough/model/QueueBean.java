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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "queue")
public class QueueBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "acctId")
	private long accountId;	//Set Manually in createQueue (Hard Coded)
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "QueueURL")
	private String queueURL;
	
	@Column(name = "QueueCreatedTimestamp")
	long timeCreated;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAccountId() {
		return accountId;
	}
	
	public String getQueueURL() {
		return queueURL;
	}
	
	public long getQueueCreatedTimestamp() {
		Calendar cal = Calendar.getInstance();
		timeCreated = (long) (cal.getTimeInMillis()/1000.0);
		return timeCreated;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setQueueURL(String URL) {
		this.queueURL = URL;
	}
}
