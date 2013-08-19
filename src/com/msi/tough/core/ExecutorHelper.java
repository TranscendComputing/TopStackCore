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
 * ExecutorHelper.java.java
 *
 * MSI Eucalyptus LoadBalancer Project
 * Copyright (C) Momentum SI
 *
 */

package com.msi.tough.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author raj
 *
 */
public class ExecutorHelper {
	public static abstract class Executable implements Runnable {
		private final Object[] args;

		public Executable(final Object... args) {
			this.args = args;
		}

		public Object[] getArgs() {
			return args;
		}
	}

	public static Future<?> execute(final Runnable r) {
		final ExecutorService exsrv = Appctx.getExecutorService();
		return exsrv.submit(r);
	}
}
