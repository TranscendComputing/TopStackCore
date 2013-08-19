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
package com.msi.tough.engine.core;

import org.slf4j.Logger;

import com.msi.tough.core.Appctx;

/**
 * Template execution engine
 * 
 * @author raj
 * 
 */
public class TemplateEngine {
	private final static Logger logger = Appctx.getLogger(TemplateEngine.class
			.getName());

	/**
	 * sleep time between cycles to execute queued templates
	 */
	private final long sleepSec;

	public TemplateEngine(final long sleepSec) {
		this.sleepSec = sleepSec;
	}
	//
	// /**
	// * execution loop
	// */
	// @SuppressWarnings("unchecked")
	// public void execute() {
	// for (;;) {
	// try {
	// for (;;) {
	// final Session s = HibernateUtil.newSession();
	// CFQueueBean b = null;
	// String script = null;
	// String type = null;
	// String stack = null;
	// String stackId = null;
	// String region = null;
	// Long acid = null;
	// try {
	// s.beginTransaction();
	// final Query q = s
	// .createQuery("from CFQueueBean where status='new' order by id");
	// // final Query q = s.createQuery("from ResourcesBean");
	// final List<CFQueueBean> l = q.list();
	// if (l.size() > 0) {
	// b = l.get(0);
	// b.setScript("processing");
	// s.save(b);
	// script = b.getScript();
	// stack = b.getStackName();
	// stackId = b.getStackId();
	// region = b.getRegion();
	// type = b.getType();
	// acid = b.getUserId();
	// }
	// s.getTransaction().commit();
	// } catch (final Exception e) {
	// logger.debug("Exception = " + e.getClass().getName()
	// + " : " + e.getMessage());
	// s.getTransaction().rollback();
	// e.printStackTrace();
	// } finally {
	// try {
	// s.close();
	// } catch (final Exception e) {
	// }
	// }
	// if (b == null) {
	// break;
	// }
	// if (type.equals("AWS")) {
	// processAWS(acid, stackId, stack, region, script);
	// }
	// }
	// Thread.sleep(sleepSec * 1000);
	// } catch (final Exception e) {
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// /**
	// * Process Aws CF script
	// *
	// * @param acid
	// * @param stackId
	// * @param stack
	// * @param region
	// * @param script
	// * @throws Exception
	// */
	// private void processAWS(final long acid, final String stackId,
	// final String stack, final String region, final String script)
	// throws Exception {
	// final TemplateExecutor ex = Appctx.getBean("TemplateExecutor");
	// HibernateUtil.withNewSession(new HibernateUtil.Operation<Object>() {
	//
	// @Override
	// public Object ex(final Session session, final Object... args)
	// throws Exception {
	// final AccountBean ac = AccountUtil.readAccount(session, acid);
	// // ex.executeNewThread(AccountUtil.toAccount(ac), stackId,
	// // stack,
	// // region, script);
	// return null;
	// }
	// });
	// }
}
