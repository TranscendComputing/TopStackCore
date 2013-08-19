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
package com.msi.tough.security;

import static org.junit.Assert.*;
import javax.crypto.SecretKey;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
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
public class AESSecurityTest {


	static SecretKey sk;
	static String encryptedString;
	//access key from database
	final static String awsSecretKey = "testing";
	//Install password
	final static String password = "transcend";

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEncrypt(){
		try{
			encryptedString = AESSecurity.encrypt(awsSecretKey);
			System.out.println("Encrypted Secret Key: " + encryptedString);
			assertFalse(encryptedString.equals(awsSecretKey));
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail("Exception " + e.toString() + " thrown.  Testing the encryption failed!");
		}
	}

	@Test
	public void testDecrypt() {
		try{
			String decryptedString = AESSecurity.decrypt(encryptedString);
			assert(decryptedString.equals(awsSecretKey));
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail("Exception " + e.toString() + " thrown.  Testing the decryption failed!");
		}
	}



}