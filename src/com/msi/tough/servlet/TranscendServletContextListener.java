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
package com.msi.tough.servlet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.msi.tough.core.Appctx;
import com.msi.tough.utils.MetricsUtil;

public class TranscendServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(final ServletContextEvent ev) {
		// destroy meters
		MetricsUtil.stopAllMeters();

		final ExecutorService executor = Appctx.getExecutorService();
		if (executor != null) {
			executor.shutdownNow();
			final TimeUnit unit = TimeUnit.SECONDS;
			try {
				executor.awaitTermination(30, unit);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void contextInitialized(final ServletContextEvent ev) {
	}
}
