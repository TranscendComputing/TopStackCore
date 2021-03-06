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
/**
 * Transcend Computing, Inc.
 * Confidential and Proprietary
 * Copyright (c) Transcend Computing, Inc. 2013
 * All Rights Reserved.
 */
package com.msi.tough.workflow.core;

import org.mule.api.MuleContext;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.msi.tough.core.Appctx;
import com.msi.tough.workflow.WorkflowIgniter;

/**
 * Programmatic instantiation of mule (for non-web contexts).
 *
 * @author jgardner
 *
 */
public class MuleIgniter implements ApplicationContextAware, WorkflowIgniter {
    private final Logger logger = Appctx
            .getLogger(MuleIgniter.class.getName());

    private static MuleIgniter instance = null;
    private MuleContext muleContext = null;
    private ApplicationContext appContext;
    private String configFiles = null;
    private boolean initialized = false;

    public MuleIgniter() {
    }

    public static MuleIgniter getInstance() {
        if (instance == null) {
            instance = new MuleIgniter();
        }
        return instance;
    }

    public void setConfigFiles(String configFiles) {
        this.configFiles = configFiles;
    }

    public void init() throws Exception {
        if (!initialized) {
            SpringXmlConfigurationBuilder builder =
                    new SpringXmlConfigurationBuilder(configFiles);
            builder.setParentContext(appContext);

            muleContext =
                    new DefaultMuleContextFactory().createMuleContext(builder);
            muleContext.start();
            initialized = true;
            logger.debug("Started Mule.");
        }
    }

    public void destroy() throws Exception {
        if (initialized) {
            muleContext.dispose();
        }
    }

    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.appContext = applicationContext;
    }
}
