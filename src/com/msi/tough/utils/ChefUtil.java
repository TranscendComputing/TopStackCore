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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SimpleTimeZone;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.bouncycastle.openssl.PEMReader;
import org.codehaus.jackson.JsonNode;
import org.jclouds.ContextBuilder;
import org.jclouds.chef.ChefApi;
import org.jclouds.chef.ChefContext;
import org.jclouds.chef.ChefService;
import org.jclouds.chef.domain.DatabagItem;
import org.jclouds.chef.domain.Node;
import org.jclouds.chef.domain.SearchResult;
import org.jclouds.chef.options.SearchOptions;
import org.slf4j.Logger;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.msi.tough.core.Appctx;
import com.msi.tough.core.CommaObject;
import com.msi.tough.core.JsonUtil;

/**
 * @author rarora
 *
 */
public class ChefUtil {
    private final static Logger logger = Appctx.getLogger(ChefUtil.class
            .getName());
    private static final String databagLockItem = "__databag__lock__";
    private static String databagLockedValue;

    private String chefClientId = null;

    private String privateKeyPath = null;

    private String chefApiUrl = null;

    private ChefApi chefApi;

    private static ChefUtil _instance = null;


    public static ChefUtil getInstance() {
        if (_instance == null) {
            _instance = new ChefUtil();
        }
        return _instance;
    }

    public static String createDatabag(final String name) throws Exception {
        logger.info("createDatabag " + name);

        return ChefUtil.createDatabag(name, Boolean.FALSE);
    }

    public static String createDatabagItem(final String bag, final String item)
            throws Exception {
        logger.info("createDatabagItem " + bag + " " + item);
        return executeJson("POST", "/data/" + bag, "{\"id\":\"" + item + "\"}");
    }

    public static void createDatabagItem(final String databag,
            final String item, final String str) throws Exception {
        logger.info("createDatabagItem " + databag + " " + item + " " + str);
        createDatabag(databag);
        createDatabagItem(databag, item);
        putDatabagItem(databag, item, str);
    }

    public static String createStringToSign(final String request,
            final byte[] bs, final byte[] contentHash, final String timestamp,
            final String userId) {

        return new StringBuilder().append("Method:").append(request)
                .append("\n").append("Hashed Path:").append(new String(bs))
                .append("\n").append("X-Ops-Content-Hash:")
                .append(new String(contentHash)).append("\n")
                .append("X-Ops-Timestamp:").append(timestamp).append("\n")
                .append("X-Ops-UserId:").append(userId).toString();

    }

    public static String deleteClient(final String name) throws Exception {
        logger.info("deleteClient " + name);
        return executeJson("DELETE", "/clients/" + name, "");
    }

    public static String deleteDatabag(final String bag) throws Exception {
        logger.info("deleteDatabag " + bag);
        return executeJson("DELETE", "/data/" + bag, "");
    }

    public static String deleteDatabagItem(final String bag, final String item)
            throws Exception {
        logger.info("deleteDatabagItem " + bag + " " + item);
        return executeJson("DELETE", "/data/" + bag + "/" + item, "");
    }

    public static String deleteNode(final String name) throws Exception {
        logger.info("deleteNode " + name);
        return executeJson("DELETE", "/nodes/" + name, "");
    }

    public static String editDatabag(final String json) throws Exception {
        return executeJson("PUT", "/data", json);
    }

    public static void endDatabagUpdate(final String databagName)
            throws Exception {
        // So long as databag is update unlocked, the chef client
        // must converge on the databag items
        ChefUtil.putDatabagItem(databagName, ChefUtil.databagLockedValue,
                Boolean.FALSE.toString());
    }

    public static String executeJson(final String method,
            final String endpointPath, final String payload)
                    throws ChefApiException {
        final String userId = getInstance().getChefClientId();
        assert (userId != null);
        final String privateKey = getInstance().getPrivateKeyPath();

        assert (privateKey != null);
        final String url = getInstance().getChefApiUrl();
        assert (url != null);
        final Map<String, String> headers = new HashMap<String, String>();
        final SimpleDateFormat iso8601DateParser = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss'Z'");
        iso8601DateParser.setTimeZone(new SimpleTimeZone(0, "UTC"));
        final String timestamp = iso8601DateParser.format(new Date());
        process(method, endpointPath, headers, payload, timestamp, userId,
                privateKey);
        final String uri = url + endpointPath;
        HttpUriRequest cmd = null;
        if (method.equals("GET")) {
            cmd = new HttpGet(uri);
        }
        if (method.equals("POST")) {
            final HttpPost post = new HttpPost(uri);
            HttpEntity entity;
            try {
                entity = new StringEntity(payload);
                post.setEntity(entity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                throw new InvalidChefRequest();
            }
            cmd = post;
        }
        if (method.equals("PUT")) {
            final HttpPut put = new HttpPut(uri);
            HttpEntity entity;
            try {
                entity = new StringEntity(payload);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                throw new InvalidChefRequest();
            }
            put.setEntity(entity);
            cmd = put;
        }
        if (method.equals("DELETE")) {
            cmd = new HttpDelete(uri);
        }
        for (final Map.Entry<String, String> en : headers.entrySet()) {
            cmd.setHeader(en.getKey(), en.getValue());
        }
        final HttpClient cl = getInstance().getHttpClient(uri);
        HttpResponse res;
        try {
            res = cl.execute(cmd);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            throw new ChefApiException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ChefApiException();
        }
        if (res.getStatusLine().getStatusCode() > 400) {
            logger.warn("Chef action returned: " + res.getStatusLine());
            logger.warn("Chef client:"+userId+", pem: " + privateKey);
            throw new InvalidChefRequest();
        }
        final HttpEntity resen = res.getEntity();
        InputStream resin;
        final StringBuilder sb = new StringBuilder();
        try {
            resin = resen.getContent();
            for (;;) {
                final byte[] bs = new byte[1000];
                final int i = resin.read(bs);
                if (i == -1) {
                    break;
                }
                final String str = new String(Arrays.copyOf(bs, i));
                sb.append(str);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            throw new ChefApiException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ChefApiException("Failed to read response.");
        }
        return sb.toString();
    }

    private static String executeJsonGet(final String endpoint)
            throws Exception {
        return executeJson("GET", endpoint, "");
    }

    public static String getDatabag(final String name) throws Exception {
        return executeJson("GET", "/data/" + name, "");
    }

    public static String getDatabagItem(final String bag, final String item)
            throws Exception {
        return executeJson("GET", "/data/" + bag + "/" + item, "");
    }

    public static String getNode(final String name) throws Exception {
        return executeJsonGet("/nodes/" + name);
    }

    public static String getClient(final String name) throws Exception {
        return executeJsonGet("/clients/" + name);
    }

    private static byte[] hashBody(final String payload)
            throws ChefApiException {
        if (payload == null) {
            return null;
        }
        try {
            return Base64.encodeBase64(SHA1(payload));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ChefApiException();
        }
    }

    private static byte[] hashPath(final String path) throws ChefApiException {
        try {
            return Base64.encodeBase64(SHA1(path));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ChefApiException();
        }
    }

    public static void process(final String method, final String endpointPath,
            final Map<String, String> headers, final String payload,
            final String timestamp, final String userId, final String privateKey)
             throws ChefApiException {
        final byte[] contentHash = hashBody(payload);
        headers.put("X-Ops-Content-Hash", new String(contentHash));
        headers.put("X-Ops-Userid", userId);
        headers.put("X-Ops-Sign", "version=1.0");
        headers.put("X-Ops-Timestamp", timestamp);
        headers.put("X-Chef-Version", "0.8.16");
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        final String toSign = createStringToSign(method,
                hashPath(endpointPath), contentHash, timestamp, userId);
        calculateAndReplaceAuthorizationHeaders(toSign, headers, privateKey);
    }

    public static PublicKey publicKeyFromFile(final String fileName)
            throws Exception {
        final Reader frdr = new FileReader(fileName);
        final PEMReader pem = new PEMReader(frdr);
        final KeyPair kp = (KeyPair) pem.readObject();
        frdr.close();
        pem.close();
        return kp.getPublic();
    }

    public static String putClientAsAdmin(final String client) throws Exception {
        logger.info("putClientAsAdmin " + client);
        final String payload = "{\"admin\":true,\"name\":\"" + client + "\"}";
        return executeJson("PUT", "/clients/" + client, payload);
    }

    public static void putDatabagItem(final String bag,
            final String itemName, final String item) throws Exception {
        logger.info("putDatabagItem " + bag + " " + itemName);
        ChefApi api = getInstance().getChefApi();
        DatabagItem databagItem = new DatabagItem(itemName, item);
        databagItem = api.updateDatabagItem(bag, databagItem);
        //return executeJson("PUT", "/data/" + bag + "/" + itemName, item);
    }

    public static String putSingleDatabagValue(final String bag,
            final String itemName, final String value) throws Exception {
        logger.info("putDatabagItem " + bag + " " + itemName);
        ChefApi api = getInstance().getChefApi();
        final String payload = "{\"id\":\""+itemName+"\"}";

        DatabagItem databagItem = new DatabagItem(itemName, payload);
        databagItem = api.updateDatabagItem(bag, databagItem);
        return databagItem.toString();
    }

    @SuppressWarnings("unchecked")
    public static String putNodeAttribute(final String node,
            final String attrib, final String value) throws Exception {
        logger.info("putNodeAttribute " + node + " " + attrib + " " + value);
        final String s = executeJsonGet("/nodes/" + node);
        final JsonNode n = JsonUtil.load(s);
        final Map<String, Object> m = JsonUtil.toMap(n);
        Object normal = m.get("normal");
        if (normal == null) {
            normal = new HashMap<String, Object>();
        }
        if (!(normal instanceof Map)) {
            if (normal instanceof JsonNode) {
                normal = JsonUtil.toMap((JsonNode) normal);
            } else {
                throw new Exception("normal is not Map or JsonNode");
            }
        }
        final Map<String, Object> nm = (Map<String, Object>) normal;
        nm.put(attrib, value);
        m.remove("normal");
        final String payload = JsonUtil.toJsonString(m).substring(1);
        final String nms = JsonUtil.toJsonString(nm);
        final String pay = "{ \"normal\":" + nms + "," + payload;
        return executeJson("PUT", "/nodes/" + node, pay);
    }

    public static String putNodeRunlist(final String node, final String runList)
            throws Exception {
        logger.info("putNodeRunlist " + node + " " + runList);
        ChefApi api = getInstance().getChefApi();
        Node nodeObj = api.getNode(node);
        CommaObject runListComma = new CommaObject(runList);
        nodeObj = new Node(nodeObj.getName(), nodeObj.getNormal(),
                nodeObj.getOverride(), nodeObj.getDefault(),
                nodeObj.getAutomatic(), runListComma.toList(),
                nodeObj.getChefEnvironment());
        nodeObj = api.updateNode(nodeObj);
        // final Object noderunList = nodeMap.get("run_list");
        //nodeMap.remove("run_list");
        //final String payload = JsonUtil.toJsonString(nodeMap).substring(1);
        //final String pay = "{ \"run_list\":\"" + runList + "\"," + payload;
        //return executeJson("PUT", "/nodes/" + node, pay);
        return nodeObj.getRunList().toString();
    }

    public static PrivateKey readKeyFromFile(final String fileName)
            throws ChefApiException {
        logger.debug("readKeyFromFile " + fileName);
        Reader frdr;
        PEMReader pem;
        try {
            frdr = new FileReader(fileName);
            pem = new PEMReader(frdr);
            final KeyPair kp = (KeyPair) pem.readObject();
            frdr.close();
            pem.close();
            return kp.getPrivate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadChefConfiguration();
        }
    }

    public static byte[] rsaDecrypt(final byte[] data, final PublicKey key)
            throws Exception {
        final Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        final byte[] cipherData = cipher.doFinal(data);
        return cipherData;
    }

    public static byte[] rsaEncrypt(final byte[] data, final PrivateKey pvtKey)
             {
        try {
            final Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pvtKey);
            final byte[] cipherData = cipher.doFinal(data);
            return cipherData;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to encrypt chef request.");
        }
    }

    public static List<String> searchNodes(final String search) throws Exception {
        ChefApi api = getInstance().getChefApi();
        SearchResult<? extends Node> searchResult =
                api.searchNodes(SearchOptions.Builder.query(search));
        ArrayList<String> result = new ArrayList<String>();
        for (Node n : searchResult) {
            result.add(n.toString());
        }
        return result;
    }

    public static byte[] SHA1(final String text) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        final byte[] sha1hash = md.digest();
        return sha1hash;
    }

    public static byte[] sign(final String toSign, final String privateKey)
        throws ChefApiException {
        final byte[] encrypted = rsaEncrypt(toSign.getBytes(),
                readKeyFromFile(privateKey));
        return Base64.encodeBase64(encrypted);
    }

    /**
     * Use this string for the Chef Node Attribute that contains the databag
     * name
     */
    final public String TRANSCEND_NODE_DATABAG_ATTRIBUTE_NAME = "__TRANSCEND__DATABAG__";

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    private static void calculateAndReplaceAuthorizationHeaders(
            final String toSign, final Map<String, String> headers,
            final String privateKey)  throws ChefApiException {
        final String signature = new String(sign(toSign, privateKey));
        final int len = signature.length();
        for (int i = 0;; i++) {
            if (i * 60 >= len) {
                break;
            }
            String line = null;
            if ((i + 1) * 60 <= len) {
                line = signature.substring(i * 60, (i + 1) * 60);
            } else {
                line = signature.substring(i * 60);
            }
            headers.put("X-Ops-Authorization-" + (i + 1), line);
        }
    }

    public static String canonicalPath(String path) {
        path = path.replaceAll("\\/+", "/");
        return path.endsWith("/") && path.length() > 1 ? path.substring(0,
                path.length() - 1) : path;
    }

    /**
     * Creates a node
     *
     * @param name
     * @return node json
     * @throws Exception
     */
    public static String createNode(final String name) throws Exception {
        logger.debug("createNode " + name);
        // Despite the docs, it seems that chef 10 requires a run list and
        // a json class to create a node.
        String nodeTemplate = "{\"run_list\":[],\"json_class\":\"Chef::Node\"}";
        final String json = executeJson("POST", "/nodes", "{\"name\":\""
                + name + "\", " + nodeTemplate.substring(1));
        return json;
    }

    /**
     * Creates a client and returns its private key
     *
     * @param name
     * @return private key
     * @throws Exception
     */
    public static String createClient(final String name) throws ChefApiException {
        logger.debug("createClient " + name);
        final String json = executeJson("POST", "/clients", "{\"name\":\""
                + name + "\"}");
        final JsonNode node = JsonUtil.load(json);
        return node.get("private_key").getTextValue();
    }

    public static String createDatabag(final String name, final Boolean lockFlag)
            throws Exception {
        logger.debug("createDatabag " + name);
        final String dbag = executeJson("POST", "/data", "{\"name\":\"" + name
                + "\"}");

        // we always must have a lock item to prevent partial convergence
        // while changes take place in bulk.
        ChefUtil.createDatabagItem(name, ChefUtil.databagLockItem);
        ChefUtil.putSingleDatabagValue(name, ChefUtil.databagLockItem,
                lockFlag.toString());

        return dbag;
    }

    /**
     * @param uri the URI to which we'll connect.
     *
     * @return the http client to connect to chef server.
     */
    public HttpClient getHttpClient(String uri) {
        if (uri.toLowerCase().startsWith("http:")) {
            return new DefaultHttpClient();
        }
        HttpClient client = null;
        TrustStrategy easyStrategy = new TrustStrategy() {

            @Override
            public boolean isTrusted(X509Certificate[] certificate, String authType)
                    throws CertificateException {
                return true;
            }
        };
        try {

            SSLSocketFactory sf = new SSLSocketFactory(easyStrategy,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("https", 443, sf));

            ClientConnectionManager ccm = new PoolingClientConnectionManager(registry);
            client = new DefaultHttpClient(ccm);

        } catch (KeyManagementException e1) {
            e1.printStackTrace();
        } catch (UnrecoverableKeyException e1) {
            e1.printStackTrace();
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (KeyStoreException e1) {
            e1.printStackTrace();
        }
        return client;
    }

    /**
     * @return the chefClientId
     */
    public String getChefClientId() {
        if (chefClientId == null) {
            chefClientId = Appctx.getConfigurationBean("CHEF_USER_ID");
        }
        return chefClientId;
    }

    /**
     * @return the privateKeyPath
     */
    public String getPrivateKeyPath() {
        if (privateKeyPath == null) {
            privateKeyPath = Appctx.getConfigurationBean("CHEF_PRIVATE_KEY");
        }
        return privateKeyPath;
    }

    /**
     * @return the chefApiUrl
     */
    public String getChefApiUrl() {
        if (chefApiUrl == null) {
            chefApiUrl = Appctx.getConfigurationBean("CHEF_API_URL");
        }
        return chefApiUrl;
    }

    /**
     * @param chefClientId the chefClientId to set
     */
    public void setChefClientId(String chefClientId) {
        this.chefClientId = chefClientId;
    }

    /**
     * @param privateKeyPath the privateKeyPath to set
     */
    public void setPrivateKeyPath(String privateKeyPath) {
        this.privateKeyPath = privateKeyPath;
    }

    /**
     * @param chefApiUrl the chefApiUrl to set
     */
    public void setChefApiUrl(String chefApiUrl) {
        this.chefApiUrl = chefApiUrl;
    }

    public ChefApi getChefApi() throws ChefApiException {
        if (chefApi != null) {
            return chefApi;
        }
        String credential;
        try {
            credential = Files.toString(new File(privateKeyPath), Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            throw new InvalidChefRequest();
        }

        Properties overrides = new Properties();
        overrides.setProperty("jclouds.trust-all-certs", Boolean.TRUE.toString());
        overrides.setProperty("jclouds.relax-hostname", Boolean.TRUE.toString());

        ChefContext context = ContextBuilder.newBuilder("chef")
                .endpoint(getChefApiUrl())
                .credentials(getChefClientId(), credential)
                .overrides(overrides)
                .buildView(ChefContext.class);

        chefApi = context.getApi(ChefApi.class);
        return chefApi;
    }

    public static class ChefApiException extends Exception {

        /**
         *
         */
        public ChefApiException() {
            super();
        }

        /**
         * @param arg0
         * @param arg1
         */
        public ChefApiException(String arg0, Throwable arg1) {
            super(arg0, arg1);
        }

        /**
         * @param arg0
         */
        public ChefApiException(Throwable arg0) {
            super(arg0);
        }

        /**
         * @param string
         */
        public ChefApiException(String string) {
        }

        /**
         *
         */
        private static final long serialVersionUID = 1L;

    }

    public static class InvalidChefRequest extends ChefApiException {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

    }

    public static class BadChefConfiguration extends ChefApiException {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

    }
}
