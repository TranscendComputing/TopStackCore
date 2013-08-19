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
package com.msi.tough.engine.aws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-toughcore-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class ArnTest {

    private static String SNS_ARN =
            "arn:aws:sns:us-east-1:1234567890:queuename";
    private static String AUTOMATE_ARN_WITH_BLANKS =
            "arn:aws:automate::ec2:stop";
    private static String AUTOMATE_ARN =
            "arn:aws:automate::ec2:stop";

    @Test
    public void testAccessors() throws Exception {
        Arn arn = new Arn(SNS_ARN);
        assertEquals("Expect parsed value.", "sns", arn.getService());
        assertEquals("Expect parsed value.", "us-east-1", arn.getRegion());
        assertEquals("Expect parsed value.", "1234567890", arn.getNamespace());
        assertEquals("Expect parsed value.", "queuename", arn.getRelativeId());
    }

    @Test
    public void testPlaceholders() throws Exception {
        Arn arn = new Arn(AUTOMATE_ARN_WITH_BLANKS);
        assertTrue("Expect empty", arn.getRegion().isEmpty());
        assertEquals("Expect parsed value.", "ec2", arn.getNamespace());
        Arn arn2 = new Arn(AUTOMATE_ARN);
        assertTrue("Expect same form.", arn2.isOfType(arn));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadFormat() throws Exception {
        new Arn("not a good arn");
    }
}
