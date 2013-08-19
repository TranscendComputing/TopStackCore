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
/*
 * ListenerBean.java
 *
 * MSI Eucalyptus LoadBalancer Project
 * Copyright (C) Momentum SI
 *
 */
package com.msi.tough.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class for web service object Listener. It implements hibernate entity
 * bean
 * <p>
 * Apart from the fields defined in the LoadBalancerDescription following extra
 * fields are maintained:
 * <li>id: database generated recored id</li>
 * </p>
 *
 * @author raj
 *
 */
@Entity
@Table(name = "listener")
public class ListenerBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long instancePort;
	private long loadBalancerPort;
	private String protocol;
	private String policyNames;
	private String sslCertificateId;

	/**
	 * get database record id
	 *
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * get instance port
	 *
	 * @return
	 */
	public long getInstancePort() {
		return instancePort;
	}

	/**
	 * get loadbalancer port
	 *
	 * @return
	 */
	public long getLoadBalancerPort() {
		return loadBalancerPort;
	}

	public String getPolicyNames() {
		return policyNames;
	}

	/**
	 * get protocol
	 *
	 * @return
	 */
	public String getProtocol() {
		return protocol;
	}

	public String getSslCertificateId() {
		return sslCertificateId;
	}

	/**
	 * set database id; used by hibernate
	 *
	 * @param id
	 */
	public void setId(final long id) {
		this.id = id;
	}

	/**
	 * set instance port
	 *
	 * @param instancePort
	 */
	public void setInstancePort(final long instancePort) {
		this.instancePort = instancePort;
	}

	/**
	 * set load balancer port
	 *
	 * @param loadBalancerPort
	 */
	public void setLoadBalancerPort(final long loadBalancerPort) {
		this.loadBalancerPort = loadBalancerPort;
	}

	public void setPolicyNames(final String policyNames) {
		this.policyNames = policyNames;
	}

	/**
	 * set protocol
	 *
	 * @param protocol
	 */
	public void setProtocol(final String protocol) {
		this.protocol = protocol;
	}

	public void setSslCertificateId(final String sslCertificateId) {
		this.sslCertificateId = sslCertificateId;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "'id':" + id + ", 'protocol':" + protocol + ", 'instancePort':"
				+ instancePort + ", 'loadBalancerPort':" + loadBalancerPort
				+ ", 'sslCertificateId':" + sslCertificateId;
	}
}
