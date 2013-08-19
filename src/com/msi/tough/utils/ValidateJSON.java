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

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.MappingJsonFactory;

public class ValidateJSON {
	private static final MappingJsonFactory fac = new MappingJsonFactory();

	public static JsonNode load(final InputStream in) throws Exception {
		final JsonParser parser = fac.createJsonParser(in);
		parser.configure(Feature.ALLOW_COMMENTS, true);
		parser.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		parser.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		final JsonNode node = parser.readValueAsTree();
		return node;
	}

	public static void main(final String[] args) throws Exception {
		try {
			BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(args[0]));
			load(in);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
