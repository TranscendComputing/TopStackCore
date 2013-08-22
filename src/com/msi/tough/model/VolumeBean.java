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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author raj
 *
 */
@Entity
@Table(name = "volume")
public class VolumeBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private String volumeId;
    private long size;
    private String status;
    private String availabilityZone;
    private boolean deleteWithInstance;
    private String instanceId;

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public long getId() {
        return id;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public long getSize() {
        return size;
    }

    public String getStatus() {
        return status;
    }

    public long getUserId() {
        return userId;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public boolean isDeleteWithInstance() {
        return deleteWithInstance;
    }

    public void setAvailabilityZone(final String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public void setDeleteWithInstance(final boolean deleteWithInstance) {
        this.deleteWithInstance = deleteWithInstance;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setInstanceId(final String instanceId) {
        this.instanceId = instanceId;
    }

    public void setSize(final long size) {
        this.size = size;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public void setVolumeId(final String volumeId) {
        this.volumeId = volumeId;
    }

}
