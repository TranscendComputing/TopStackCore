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

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.internal.ServiceUtils;

public class SwiftUtil {
	private static class SwiftClient extends AmazonS3Client {
		public SwiftClient(final AWSCredentials cred) {
			super(cred);
		}

		@Override
		protected <X extends AmazonWebServiceRequest> Request<X> createRequest(
				final String bucketName, final String key,
				final X originalRequest, final HttpMethodName httpMethod) {
			final Request<X> request = new DefaultRequest<X>(originalRequest,
					Constants.S3_SERVICE_NAME);
			request.setHttpMethod(httpMethod);
			request.setEndpoint(endpoint);

			if (bucketName != null) {
				/*
				 * We don't URL encode the bucket name, since it shouldn't
				 * contain any characters that need to be encoded based on
				 * Amazon S3's naming restrictions.
				 */
				request.setResourcePath(bucketName + "/"
						+ (key != null ? ServiceUtils.urlEncode(key) : ""));
			}

			return request;
		}
	}
	
	public static SwiftClient getSwiftClient(AWSCredentials cred){
		return new SwiftClient(cred);
	}
	
}
