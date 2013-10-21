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
package com.msi.tough.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonNode;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.msi.tough.core.Appctx;
import com.msi.tough.core.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-toughcore-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class ChefUtilTest {

    private final static Logger logger = Appctx
            .getLogger(ChefUtilTest.class.getName());

    static final SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd-HH-mm-ss-SSS");
    static private final String baseName = dateFormat.format(new Date())
            + UUID.randomUUID().toString().substring(0, 4);

    static String name1 = "chefutil-" + baseName;
    static String name2 = "chefutil2-" + baseName;

    static String bag1 = "chefutil-bag1-" + baseName;
    static String bag2 = "chefutil-bag2-" + baseName;

    @Resource
    ChefUtil chefUtil = null;

    @Test
    public void testClient() throws Exception {
        String json = ChefUtil.createClient(name1);
        assertThat("Create returns private key.", json, containsString("BEGIN"));
        assertThat("Create returns private key.", json, containsString("END"));
        json = ChefUtil.getClient(name1);
        assertThat("Client is created.", json,
                containsString("\"name\":\""+name1));
        json = ChefUtil.putClientAsAdmin(name1);
        assertThat("Client can be made admin.", json,
                containsString("\"admin\":true"));
        json = ChefUtil.getClient(name1);
        assertThat("Client is admin.", json,
                containsString("\"admin\":true"));
    }

    @Test(expected=ChefUtil.InvalidChefRequest.class)
    public void testClientBadArgs() throws Exception {
        String oldClientId = chefUtil.getChefClientId();
        try {
            chefUtil.setChefClientId("some-bad-garbage-id");

            String json = ChefUtil.createClient(name2);
            logger.debug("Got response:"+json);
            json = ChefUtil.getClient(name2);
            logger.debug("Got response:"+json);
        } finally {
            chefUtil.setChefClientId(oldClientId);
        }
    }

    @Test
    public void testDatabag() throws Exception {
        String json = ChefUtil.createDatabag(bag1);
        assertThat("Databag is created.", json,
                containsString(bag1));

        json = ChefUtil.createDatabagItem(bag1, "item1");
        assertThat("Databag item is created.", json,
                containsString("\"id\":\"item1\""));
        final String databag = ChefUtil.getDatabag(bag1);
        logger.debug("Got databag:" + databag);
        // final JsonNode json = JsonUtil.load(databag);
        ChefUtil.putDatabagItem(bag1, "item1",
                "{\"id\":\"item1\",\"f\":\"fff\"}");
        json = ChefUtil.getDatabagItem(bag1, "item1");
        assertThat("Databag item put ok.", json,
                containsString("\"f\":\"fff\""));

        ChefUtil.deleteDatabagItem(bag1, "item1");
        ChefUtil.deleteDatabag(bag1);
    }

    @Test
    public void testNode() throws Exception {
        String jsonText = ChefUtil.createNode(name1);
        logger.debug(jsonText);
        assertThat("Node is created.", jsonText,
                containsString(name1));
        jsonText = ChefUtil.getNode(name1);
        logger.debug(jsonText);
        JsonNode json = JsonUtil.load(jsonText);
        //logger.debug(JsonUtil.toJsonPrettyPrintString(json));
        assertThat("Node name is correct.", json.get("name").getTextValue(),
                is(name1));
    }

    @Test
    public void testNodeUpdateRunlist() throws Exception {
        try {
            ChefUtil.createNode(name1);
        } catch (Exception e) {
            // ignore failure; may have already been created.
        }
        String jsonText = ChefUtil.putNodeRunlist(name1, "role[transcend_defaultrole]");
        logger.debug(jsonText);
        jsonText = ChefUtil.getNode(name1);
        JsonNode json = JsonUtil.load(jsonText);
        logger.debug(JsonUtil.toJsonPrettyPrintString(json));
        assertThat("Node name is correct.", json.get("name").getTextValue(),
                is(name1));
    }

    @Test
    public void testBasicGet() throws Exception {
        final String json = ChefUtil.executeJson("GET", "/clients", "");
        assertNotNull("client response is valid", json);
    }

    @Test
    public void testSearchNode() throws Exception {
        try {
            ChefUtil.createNode(name1);
        } catch (Exception e) {
            // ignore failure; may have already been created.
        }

        // Search for :"name:chefutil-*";
        String search = "name%3A" + name1.substring(0, 9) + "*";
        final List<String> nodes = ChefUtil.searchNodes(search) ;

        //final JsonNode jsonNodes = JsonUtil.load(nodes);
        for (String node : nodes) {
            System.out.println(node);
        }
    }

    @AfterClass
    public static void cleanupCreated() throws Exception {
        try {
            ChefUtil.deleteClient(name1);
        } catch (Exception e) {
            // ignore.
        }
        try {
            ChefUtil.deleteDatabag(bag1);
        } catch (Exception e) {
            // ignore.
        }
        try {
            ChefUtil.deleteNode(name1);
        } catch (Exception e) {
            // ignore.
        }
    }


}
