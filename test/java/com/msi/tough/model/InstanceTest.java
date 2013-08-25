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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.msi.tough.core.HibernateUtil;
import com.msi.tough.core.QueryBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-toughcore-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class InstanceTest {

    protected final SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS-");
    private final String baseName = dateFormat.format(new Date())+
            UUID.randomUUID().toString().substring(0, 3);

    String name1 = "tsc-i-1-" + baseName;

    @Test
    public void testBasicConstruction() throws Exception {
        final Session session = HibernateUtil.newSession();
        Transaction tx = session.beginTransaction();
        try {
            InstanceBean instance = new InstanceBean();
            instance.setInstanceId(name1);
            session.save(instance);
            tx.commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void testDependencies() throws Exception {
        final Session session = HibernateUtil.newSession();
        ASGroupBean asGroup = new ASGroupBean();
        asGroup.setName(name1);
        InstanceBean instance = new InstanceBean();
        instance.setInstanceId(name1);
        instance.setLogicalId(name1);
        Transaction tx = session.beginTransaction();
        try {
            session.save(asGroup);
            instance.setAsGroup(asGroup);
            session.save(instance);
            tx.commit();
            QueryBuilder builder = new QueryBuilder("from InstanceBean");
            builder.equals("asGroup", asGroup);
            Query query = builder.toQuery(session);
            InstanceBean ret = (InstanceBean) query.uniqueResult();
            assertNotNull(ret);
            assertNotNull(ret.getAsGroup());
            assertEquals(asGroup.getId(), ret.getAsGroup().getId());
        } finally {
            session.close();
        }
    }

    @After
    public void cleanUp() {
        Session session = HibernateUtil.newSession();
        Transaction tx = session.beginTransaction();
        try {
            QueryBuilder builder = new QueryBuilder("from InstanceBean");
            builder.equals("instanceId", name1);
            Query query = builder.toQuery(session);
            List<?> ret = query.list();
            for (Object o : ret) {
                session.delete(o);
            }
            tx.commit();
        }
        finally {
            session.close();
        }
        session = HibernateUtil.newSession();
        tx = session.beginTransaction();
        try {
            QueryBuilder builder = new QueryBuilder("from ASGroupBean");
            builder.equals("name", name1);
            Query query = builder.toQuery(session);
            List<?> ret = query.list();
            for (Object o : ret) {
                session.delete(o);
            }
            tx.commit();
        }
        finally {
            session.close();
        }
    }
}
