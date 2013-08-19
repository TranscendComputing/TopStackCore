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
package com.msi.tough.model.elasticmapreduce;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "KeyValue")
public class KeyValueBean
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "StepDetail")
    private StepDetailBean stepDetail;

    @Lob
    @Column(name = "KeyString", length = 10280)
    private String key;

    @Lob
    @Column(name = "Value", length = 10280)
    private String value;

    public KeyValueBean()
    {
    }

    public KeyValueBean(Long id, StepDetailBean stepDetail)
    {
        this.id = id;
        this.stepDetail = stepDetail;
    }

    public KeyValueBean(Long id, StepDetailBean stepDetail, String key,
        String value)
    {
        this.id = id;
        this.stepDetail = stepDetail;
        this.key = key;
        this.value = value;
    }

    public Long getId()
    {
        return this.id;
    }

    public String getKey()
    {
        return this.key;
    }

    public StepDetailBean getStepDetail()
    {
        return this.stepDetail;
    }

    public String getValue()
    {
        return this.value;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public void setStepDetail(StepDetailBean stepDetail)
    {
        this.stepDetail = stepDetail;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
