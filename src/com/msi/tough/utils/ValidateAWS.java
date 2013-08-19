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

/**
 * @author jlomax
 * 
 */
public final class ValidateAWS {

	// private ValidateAWS() { throw new AssertionError(); }

	/**
	 * Test AWS hyphenated id, must start with lower case letter, alphanumeric +
	 * hyphen, cannot have two hypens in a row or end with a hyphen.
	 * 
	 * @param s
	 *            string to test
	 * @param maxLength
	 *            maximum length to allow
	 * @return true if valid
	 */
	public static Boolean isAWSHyphenatedId(final String s, final int maxLength) {
		// Other regex candidates
		// ^[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*$
		// ^[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]$
		final java.util.regex.Pattern p = java.util.regex.Pattern
				.compile("^[a-z](?:[^-]|-(?!-)){1," + maxLength + "}$");
		final java.util.regex.Matcher m = p.matcher(s.toLowerCase());
		return m.find();
	}

}
