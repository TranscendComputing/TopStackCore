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
package com.msi.tough.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

public class ResourceUtils {

	/**
	 * Load the resource either using current class loader or using parent class
	 * loader
	 * 
	 * @param fileName
	 * @return
	 */
	public static File getFileFromClasspath(final String fileName) {
		File file = null;

		// Load the resource using current class loader
		URL url = Thread.currentThread().getClass().getResource(fileName);

		if (url != null) {
			file = new File(url.getFile());
		} else {
			// load the resource using the parent context
			url = Thread.currentThread().getContextClassLoader()
					.getResource(fileName);
			if (url != null) {
				file = new File(url.getFile());
			}
		}

		return file;
	}

	public static InputStream getInputStreamFromClasspathFile(
			final String fileName) throws FileNotFoundException {
		return new FileInputStream(getFileFromClasspath(fileName));
	}

	public static String readStream(final InputStream strm) throws Exception {
		final StringBuilder sb = new StringBuilder();
		final byte[] b = new byte[1024];
		for (;;) {
			final int c = strm.read(b);
			if (c <= 0) {
				break;
			}
			sb.append(new String(b, 0, c));
		}
		return sb.toString();
	}
}
