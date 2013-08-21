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
package com.msi.tough.model.cf;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RdsDbinstance generated by hbm2java
 */

@Entity
@Table(name = "cf_stack")
public class CFStackBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private Boolean disableRollBack;
    private String notifications;
    private String parameters;
    private String stackName;
    private String stackId;
    private String region;
    private Date createdTime;
    private String status;

    @Column(name = "templateBody", length = 60000)
    private String templateBody;

    private String templateURL;
    private int timeoutInMins;
    private String urn;

    public Date getCreatedTime() {
        return createdTime;
    }

    public Boolean getDisableRollBack() {
        return disableRollBack;
    }

    public long getId() {
        return id;
    }

    public String getNotifications() {
        return notifications;
    }

    public String getParameters() {
        return parameters;
    }

    public String getRegion() {
        return region;
    }

    public String getStackId() {
        return stackId;
    }

    public String getStackName() {
        return stackName;
    }

    public String getStatus() {
        return status;
    }

    public String getTemplateBody() {
        return templateBody;
    }

    public String getTemplateURL() {
        return templateURL;
    }

    public int getTimeoutInMins() {
        return timeoutInMins;
    }

    public String getUrn() {
        return urn;
    }

    public long getUserId() {
        return userId;
    }

    public void setCreatedTime(final Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setDisableRollBack(final Boolean disableRollBack) {
        this.disableRollBack = disableRollBack;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setNotifications(final String notifications) {
        this.notifications = notifications;
    }

    public void setParameters(final String parameters) {
        this.parameters = parameters;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public void setStackId(final String stackId) {
        this.stackId = stackId;
    }

    public void setStackName(final String stackName) {
        this.stackName = stackName;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setTemplateBody(final String templateBody) {
        this.templateBody = templateBody;
    }

    public void setTemplateURL(final String templateURL) {
        this.templateURL = templateURL;
    }

    public void setTimeoutInMins(final int timeoutInMins) {
        this.timeoutInMins = timeoutInMins;
    }

    public void setUrn(final String urn) {
        this.urn = urn;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

}
