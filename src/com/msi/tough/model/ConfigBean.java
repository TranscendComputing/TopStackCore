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
 * AvzoneBean.java
 *
 * MSI Eucalyptus LoadBalancer Project
 * Copyright (C) Momentum SI
 *
 */
package com.msi.tough.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model class for web service object AvailabilityZones. It implements hibernate
 * entity bean
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
@Table(name = "config")
public class ConfigBean {
    // TODO add parent relationship back to ConfigTemplateBean

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_space")
    private String nameSpace;

    @Column(name = "opt")
    private String option;

    @Column(name = "val")
    private String value;

    public long getId() {
        return id;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public String getOption() {
        return option;
    }

    public String getValue() {
        return value;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setNameSpace(final String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public void setOption(final String option) {
        this.option = option;
    }

    public void setValue(final String value) {
        this.value = value;
    }

}