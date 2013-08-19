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
package com.msi.tough.query;

public class QueryFaults {
	public static ErrorResponse AuthorizationNotFound() {
		return new ErrorResponse("Sender", "Authorization Not Found.",
				"AuthorizationNotFound");
	}

	public static ErrorResponse internalFailure() {
		return new ErrorResponse(
				"Provider",
				"The request processing has failed due to some unknown error, exception or failure.",
				"InternalFailure", 500);
	}

	public static ErrorResponse invalidAction() {
		return new ErrorResponse("Sender",
				"The action or operation requested is invalid.",
				"invalidAction");
	}

	public static ErrorResponse InvalidParameterCombination() {
		return new ErrorResponse(
				"Sender",
				"Parameters that must not be used together were used together.",
				"InvalidParameterCombination");
	}

	public static ErrorResponse InvalidParameterCombination(final String msg) {
		return new ErrorResponse("Sender", msg, "InvalidParameterCombination");
	}

	public static ErrorResponse InvalidParameterValue() {
		return new ErrorResponse(
				"Sender",
				"A bad or out-of-range value was supplied for the input parameter.",
				"InvalidParameterValue");
	}

	public static ErrorResponse InvalidParameterValue(final String msg) {
		return new ErrorResponse("Sender", msg, "InvalidParameterValue");
	}

	public static ErrorResponse MissingParameter() {
		return new ErrorResponse(
				"Sender",
				"An input parameter that is mandatory for processing the request is not supplied.",
				"MissingParameter");
	}

	public static ErrorResponse MissingParameter(final String msg) {
		return new ErrorResponse("Sender", msg, "MissingParameter");
	}

	public static ErrorResponse notSupported() {
		return new ErrorResponse("Provider", "Operation not supported.",
				"NotSupported");
	}

	public static Exception quotaError(final String msg) {
		return new ErrorResponse("Sender", msg, "QuotaExceeded");
	}
}
