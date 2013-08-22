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
 * InstanceBean.java.java
 *
 * MSI Eucalyptus LoadBalancer Project
 * Copyright (C) Momentum SI
 *
 */

package com.msi.tough.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author raj
 *
 */
@Entity
@Table(name = "instance")
public class InstanceBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private String instanceId;
    private String privateIp;
    private String status;
    private String publicIpId;
    private String publicIp;
    private String avzone;
    private String volumes;
    private String hostname;
    private String chefRoles;
    private String databag;
    private String logicalId;
    private boolean addedByLB;
    private int lbCount;
    private String ec2Id;
    private Date launchTime;
    private long launchConfigId;
    private String health;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "as_group_id", nullable = true)
    private ASGroupBean asGroup;

    public String getAvzone() {
        return avzone;
    }

    public String getChefRoles() {
        return chefRoles;
    }

    public String getDatabag() {
        return databag;
    }

    public String getEc2Id() {
        return ec2Id;
    }

    public String getHealth() {
        return health;
    }

    public String getHostname() {
        return hostname;
    }

    public long getId() {
        return id;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public long getLaunchConfigId() {
        return launchConfigId;
    }

    public Date getLaunchTime() {
        return launchTime;
    }

    public int getLbCount() {
        return lbCount;
    }

    public String getLogicalId() {
        return logicalId;
    }

    public String getPrivateIp() {
        return privateIp;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public String getPublicIpId() {
        return publicIpId;
    }

    public String getStatus() {
        return status;
    }

    public long getUserId() {
        return userId;
    }

    public String getVolumes() {
        return volumes;
    }

    public boolean isAddedByLB() {
        return addedByLB;
    }

    public void setAddedByLB(final boolean addedByLB) {
        this.addedByLB = addedByLB;
    }

    public void setAvzone(final String avzone) {
        this.avzone = avzone;
    }

    public void setChefRoles(final String chefRoles) {
        this.chefRoles = chefRoles;
    }

    public void setDatabag(final String databag) {
        this.databag = databag;
    }

    public void setEc2Id(final String ec2Id) {
        this.ec2Id = ec2Id;
    }

    public void setHealth(final String health) {
        this.health = health;
    }

    public void setHostname(final String hostname) {
        this.hostname = hostname;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setInstanceId(final String instanceId) {
        this.instanceId = instanceId;
    }

    public void setLaunchConfigId(final long launchConfigId) {
        this.launchConfigId = launchConfigId;
    }

    public void setLaunchTime(final Date launchTime) {
        this.launchTime = launchTime;
    }

    public void setLbCount(final int lbCount) {
        this.lbCount = lbCount;
    }

    public void setLogicalId(final String logicalId) {
        this.logicalId = logicalId;
    }

    public void setPrivateIp(final String ipAddress) {
        privateIp = ipAddress;
    }

    public void setPublicIp(final String publicIp) {
        this.publicIp = publicIp;
    }

    public void setPublicIpId(final String publicIpId) {
        this.publicIpId = publicIpId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public void setVolumes(final String volumes) {
        this.volumes = volumes;
    }

    /**
     * @return the asGroup
     */
    public ASGroupBean getAsGroup() {
        return asGroup;
    }

    /**
     * @param asGroup the asGroup to set
     */
    public void setAsGroup(ASGroupBean asGroup) {
        this.asGroup = asGroup;
    }
}
