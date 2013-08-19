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

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificate")
public class CertificateBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long accountId;

	private String name;

	private String path;

	private Date uploadDate;

	@Column(length = 10240)
	private String body;

	@Column(length = 10240)
	private String chain;

	@Column(length = 10240)
	private String pvtkey;

	public long getAccountId() {
		return accountId;
	}

	public String getBody() {
		return body;
	}

	public String getChain() {
		return chain;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public String getPvtkey() {
		return pvtkey;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setAccountId(final long accountId) {
		this.accountId = accountId;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public void setChain(final String chain) {
		this.chain = chain;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPath(final String path) {
		this.path = path;
	}

	public void setPvtkey(final String pvtkey) {
		this.pvtkey = pvtkey;
	}

	public void setUploadDate(final Date uploadDate) {
		this.uploadDate = uploadDate;
	}

}
