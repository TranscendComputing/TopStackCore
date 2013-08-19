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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Args")
public class ArgsBean
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "BootstrapActionDetail")
    private BootstrapActionDetailBean bootstrapActionDetail;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "StepDetail")
    private StepDetailBean stepDetail;

    @Column(name = "Arg")
    private String arg;

    public ArgsBean()
    {
    }

    public ArgsBean(Long id, BootstrapActionDetailBean bootstrapActionDetail,
        StepDetailBean stepDetail)
    {
        this.id = id;
        this.bootstrapActionDetail = bootstrapActionDetail;
        this.stepDetail = stepDetail;
    }

    public ArgsBean(Long id, BootstrapActionDetailBean bootstrapActionDetail,
        StepDetailBean stepDetail, String arg)
    {
        this.id = id;
        this.bootstrapActionDetail = bootstrapActionDetail;
        this.stepDetail = stepDetail;
        this.arg = arg;
    }

    public String getArg()
    {
        return this.arg;
    }

    public BootstrapActionDetailBean getBootstrapActionDetail()
    {
        return this.bootstrapActionDetail;
    }

    public Long getId()
    {
        return this.id;
    }

    public StepDetailBean getStepDetail()
    {
        return this.stepDetail;
    }

    public void setArg(String arg)
    {
        this.arg = arg;
    }

    public void setBootstrapActionDetail(
        BootstrapActionDetailBean bootstrapActionDetail)
    {
        this.bootstrapActionDetail = bootstrapActionDetail;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setStepDetail(StepDetailBean stepDetail)
    {
        this.stepDetail = stepDetail;
    }
}
