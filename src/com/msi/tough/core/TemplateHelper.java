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
 * TemplateHelper.java
 *
 * MSI Eucalyptus LoadBalancer Project
 * Copyright (C) Momentum SI
 *
 */
package com.msi.tough.core;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import com.msi.tough.utils.FTLGetConfiguration;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Helper class for Feemarker
 *
 * @author raj
 *
 */
public class TemplateHelper {

    private static Configuration cfg = null;

    private String templateDir = null;
    private String workDir = null;
    private String logDir = null;
    private static TemplateHelper instance = null;

    public static TemplateHelper getInstance() {
        if (instance == null) {
            instance = new TemplateHelper();
        }
        return instance;
    }

    public static String processFile(final String file,
            final Map<String, Object> args) {
        Writer out = null;
        try {
            final TemplateHelper th = getInstance();
            if (cfg == null) {
                cfg = new Configuration();
                cfg.setDirectoryForTemplateLoading(new File(th.getTemplateDir()));
            }
            final Template ftl = th.load(file + ".ftl");
            final StringWriter sw = new StringWriter();
            out = new java.io.BufferedWriter(sw);
            args.put("configuration", new FTLGetConfiguration());
            ftl.process(args, out);
            return sw.getBuffer().toString();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (final IOException e) {
                }
            }
        }
    }

    /**
     * Getter for where execution log should be written
     *
     * @return logDir
     */
    public String getLogDir() {
        return logDir;
    }

    /**
     * Setter for where execution log should be written.
     *
     * @return logDir
     */
    public void setLogDir(String logDir) {
        this.logDir = logDir;
    }

    /**
     * Getter for file system path of the directory where template are kept.
     *
     * @return file system path
     */
    public String getTemplateDir() {
        return templateDir;
    }

    /**
     * Setter for file system path of the directory where templates are kept.
     *
     * @return file system path
     */
    public void setTemplateDir(String templateDir) {
        this.templateDir = templateDir;
    }

    /**
     * getter for file system path of the directory where temporary scripts file
     * should be generated for execution
     *
     * @return file system path of the directory
     */
    public String getWorkDir() {
        return workDir;
    }

    /**
     * getter for file system path of the directory where temporary scripts file
     * should be generated for execution
     *
     * @return file system path of the directory
     */
    public void setWorkDir(String workDir) {
        this.workDir = workDir;
    }

    /**
     * load a ftl file
     *
     * @param name
     * @return
     */
    public Template load(final String name) {
        try {
            return cfg.getTemplate(name);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
