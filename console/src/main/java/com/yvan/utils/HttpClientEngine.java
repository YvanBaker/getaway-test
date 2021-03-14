/*
 * Copyright (c) 2014, Baidu and/or its affiliates. All rights reserved.
 * Baidu PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.yvan.utils;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The <code>HttpClientEngine</code> class is used to execute HTTP post and get
 * request using apache httpclient and return the response results.
 *
 * @author chenjiawen
 */

public class HttpClientEngine {
    // Get the log4j instance
//    private Logger logger = Logger.getLogger(HttpClientEngine.class);

    private DefaultHttpClient httpClient;

    public HttpClientEngine() {
        // Instance one HttpParams instance
        HttpParams httpParams = new BasicHttpParams();
        // set connection timeout
        HttpConnectionParams.setConnectionTimeout(httpParams, 20 * 1000);
        // set socket timeout
        HttpConnectionParams.setSoTimeout(httpParams, 20 * 1000);
        // Initialize http client instance
        this.httpClient = new DefaultHttpClient(httpParams);
    }

    public HttpClientEngine(String userName, String password) {
        // Instance one HttpParams instance
        HttpParams httpParams = new BasicHttpParams();
        // set connection timeout
        HttpConnectionParams.setConnectionTimeout(httpParams, 20 * 1000);
        // set socket timeout
        HttpConnectionParams.setSoTimeout(httpParams, 20 * 1000);
        // Initialize http client instance
        this.httpClient = new DefaultHttpClient(httpParams);
        this.httpClient.getCredentialsProvider().setCredentials(
                new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
                new UsernamePasswordCredentials(userName, password));
    }

    /**
     * Proceeds the http post request and return reponse results.
     *
     * @param reqEntity The request entity which wraps the http request parameters
     * @param resEntity The response entity which stores the parsing results
     * @return the http response result
     */
    public String doPost(RequestEntity reqEntity, ResponseEntity resEntity) {
        // Set default return code to error
        resEntity.setRetCode(ConstantUtil.RETCODE_ERROR);

        // Initialize http response result to null
        String responseContent = null;

        try {

            // Create one http post instance from requested url
            HttpPost httpPost = new HttpPost(reqEntity.getRequestUrl());

            // Wrap header parameters from requested header parameters
            wrapRequestHeaders(httpPost, reqEntity);

            // Wrap post body and form data
            wrapRequestData(httpPost, reqEntity);

            // Record http request execution start time
            long startTime = System.currentTimeMillis();

            // Execute the http post request
            HttpResponse httpResponse = httpClient.execute(httpPost);

            // Convert the response content to string
            responseContent = EntityUtils.toString(httpResponse.getEntity());

            // Record http request execution end time
            long endTime = System.currentTimeMillis();

            // Calculate the response time
            double responseTime = ((double) endTime - startTime) / 1000;

            // Get the response headers
            Map<Object, Object> responseHeader = getResponseHeader(httpResponse);

            // Judge the encoding format of the response content,if it's
            // iso8859 encoding,convert it to utf-8
            responseContent = convertStrToUtf8(responseContent);

            // Get the http response code
            short responseCode = (short) httpResponse.getStatusLine().getStatusCode();

            // Reset the return code to 0
            resEntity.setRetCode(0);

            // Set response code
            resEntity.setResponseCode(responseCode);

            // Set response time
            resEntity.setResponseTime(responseTime);

            // Set response header
            resEntity.setResponseHeader(responseHeader);

            // Set return message
            resEntity.setRetMsg(ConstantUtil.RETMSG_CORRECT);

            // Set the response result
            resEntity.setResponseContent(responseContent);

        } catch (Exception e) {


            // Set the return message
            resEntity.setRetMsg(ConstantUtil.RETMSG_HTTP_POST_FAIL + e.getMessage());
        } finally {
            // Close http connection and release resource
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return responseContent;

    }

    public String doPut(RequestEntity reqEntity, ResponseEntity resEntity) {
        // Set default return code to error
        resEntity.setRetCode(ConstantUtil.RETCODE_ERROR);

        // Initialize http response result to null
        String responseContent = null;

        try {

            // Create one http put instance from requested url
            HttpPut httpPut = new HttpPut(reqEntity.getRequestUrl());

            // Wrap header parameters from requested header parameters
            wrapRequestHeaders(httpPut, reqEntity);

            // Wrap post body and form data
            wrapRequestData(httpPut, reqEntity);

            // Record http request execution start time
            long startTime = System.currentTimeMillis();

            // Execute the http post request
            HttpResponse httpResponse = httpClient.execute(httpPut);

            // Convert the response content to string
            responseContent = EntityUtils.toString(httpResponse.getEntity());

            // Record http request execution end time
            long endTime = System.currentTimeMillis();

            // Calculate the response time
            double responseTime = ((double) endTime - startTime) / 1000;

            // Get the response headers
            Map<Object, Object> responseHeader = getResponseHeader(httpResponse);

            // Judge the encoding format of the response content,if it's
            // iso8859 encoding,convert it to utf-8
            responseContent = convertStrToUtf8(responseContent);

            // Get the http response code
            short responseCode = (short) httpResponse.getStatusLine().getStatusCode();

            // Reset the return code to 0
            resEntity.setRetCode(0);

            // Set response code
            resEntity.setResponseCode(responseCode);

            // Set response time
            resEntity.setResponseTime(responseTime);

            // Set response header
            resEntity.setResponseHeader(responseHeader);

            // Set return message
            resEntity.setRetMsg(ConstantUtil.RETMSG_CORRECT);

            // Set the response result
            resEntity.setResponseContent(responseContent);

        } catch (Exception e) {


            // Set the return message
            resEntity.setRetMsg(ConstantUtil.RETMSG_HTTP_PUT_FAIL + e.getMessage());
        } finally {
            // Close http connection and release resource
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return responseContent;
    }


    public String doDelete(RequestEntity reqEntity, ResponseEntity resEntity) {
        // Initialize http response result to null
        String responseContent = null;

        // Set default return code to error
        resEntity.setRetCode(ConstantUtil.RETCODE_ERROR);

        try {
            // Create one http delete instance from requested url
            HttpDelete httpDelete = new HttpDelete(reqEntity.getRequestUrl());

            // Wrap header parameters from requested header parameters
            wrapRequestHeaders(httpDelete, reqEntity);

            // Wrap http get url
            wrapHttpGetOrDeleteUrl(httpDelete, reqEntity);

            // Record http request execution start time
            long startTime = System.currentTimeMillis();

            // Execute the http get request
            HttpResponse httpResponse = httpClient.execute(httpDelete);

            // Convert the response content to string
            responseContent = EntityUtils.toString(httpResponse.getEntity());

            // Record http request execution end time
            long endTime = System.currentTimeMillis();

            // Calculate the response time
            double responseTime = ((double) endTime - startTime) / 1000;

            // Get the response headers
            Map<Object, Object> responseHeader = getResponseHeader(httpResponse);

            // Get the http response code
            short responseCode = (short) httpResponse.getStatusLine().getStatusCode();

            // Judge the encoding format of the response content,if it's
            // iso8859 encoding,convert it to utf-8
            responseContent = convertStrToUtf8(responseContent);

            // Reset the return code to 0
            resEntity.setRetCode(0);

            // Set response code
            resEntity.setResponseCode(responseCode);

            // Set response time
            resEntity.setResponseTime(responseTime);

            // Set response header
            resEntity.setResponseHeader(responseHeader);

            // Set return message
            resEntity.setRetMsg(ConstantUtil.RETMSG_CORRECT);

            // Set the response result
            resEntity.setResponseContent(responseContent);

        } catch (Exception e) {


            // Set return message
            resEntity.setRetMsg(ConstantUtil.RETMSG_HTTP_DELETE_FAIL + e.getMessage());
        } finally {
            // Close http connection and release resource
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }

        }
        return responseContent;
    }

    /**
     * Proceeds the http get request and return reponse results.
     *
     * @param reqEntity The request entity which wraps the http request parameters
     * @param resEntity The response entity which stores the parsing results
     * @return the http response result
     */
    public String doGet(RequestEntity reqEntity, ResponseEntity resEntity) {
        // Initialize http response result to null
        String responseContent = null;

        // Set default return code to error
        resEntity.setRetCode(ConstantUtil.RETCODE_ERROR);

        try {
            // Create one http post instance from requested url
            HttpGet httpGet = new HttpGet(reqEntity.getRequestUrl());

            // Wrap header parameters from requested header parameters
            wrapRequestHeaders(httpGet, reqEntity);

            // Wrap http get url
            wrapHttpGetOrDeleteUrl(httpGet, reqEntity);

            // Record http request execution start time
            long startTime = System.currentTimeMillis();

            // Execute the http get request
            HttpResponse httpResponse = httpClient.execute(httpGet);

            // Convert the response content to string
            responseContent = EntityUtils.toString(httpResponse.getEntity());

            // Record http request execution end time
            long endTime = System.currentTimeMillis();

            // Calculate the response time
            double responseTime = ((double) endTime - startTime) / 1000;

            // Get the response headers
            Map<Object, Object> responseHeader = getResponseHeader(httpResponse);

            // Get the http response code
            short responseCode = (short) httpResponse.getStatusLine().getStatusCode();

            // Judge the encoding format of the response content,if it's
            // iso8859 encoding,convert it to utf-8
            responseContent = convertStrToUtf8(responseContent);

            // Reset the return code to 0
            resEntity.setRetCode(0);

            // Set response code
            resEntity.setResponseCode(responseCode);

            // Set response time
            resEntity.setResponseTime(responseTime);

            // Set response header
            resEntity.setResponseHeader(responseHeader);

            // Set return message
            resEntity.setRetMsg(ConstantUtil.RETMSG_CORRECT);

            // Set the response result
            resEntity.setResponseContent(responseContent);

        } catch (Exception e) {


            // Set return message
            resEntity.setRetMsg(ConstantUtil.RETMSG_HTTP_GET_FAIL + e.getMessage());
        } finally {
            // Close http connection and release resource
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }

        }
        return responseContent;

    }

    /**
     * Proceeds the http get request by URI and return reponse results.
     *
     * @param reqEntity The request entity which wraps the http request parameters
     * @param resEntity The response entity which stores the parsing results
     * @return the http response result
     */
    public String doGetByURI(RequestEntity reqEntity, ResponseEntity resEntity) {
        // Initialize http response result to null
        String responseContent = null;

        // Set default return code to error
        resEntity.setRetCode(ConstantUtil.RETCODE_ERROR);

        try {
            // Create one http post instance from requested url by URI
            URL url = new URL(reqEntity.getRequestUrl());
            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
            HttpGet httpGet = new HttpGet(uri);

            // Wrap header parameters from requested header parameters
            wrapRequestHeaders(httpGet, reqEntity);

            // Wrap http get url
            wrapHttpGetOrDeleteUrl(httpGet, reqEntity);

            // Record http request execution start time
            long startTime = System.currentTimeMillis();

            // Execute the http get request
            HttpResponse httpResponse = httpClient.execute(httpGet);

            // Convert the response content to string
            responseContent = EntityUtils.toString(httpResponse.getEntity());

            // Record http request execution end time
            long endTime = System.currentTimeMillis();

            // Calculate the response time
            double responseTime = ((double) endTime - startTime) / 1000;

            // Get the response headers
            Map<Object, Object> responseHeader = getResponseHeader(httpResponse);

            // Get the http response code
            short responseCode = (short) httpResponse.getStatusLine().getStatusCode();

            // Judge the encoding format of the response content,if it's
            // iso8859 encoding,convert it to utf-8
            responseContent = convertStrToUtf8(responseContent);

            // Reset the return code to 0
            resEntity.setRetCode(0);

            // Set response code
            resEntity.setResponseCode(responseCode);

            // Set response time
            resEntity.setResponseTime(responseTime);

            // Set response header
            resEntity.setResponseHeader(responseHeader);

            // Set return message
            resEntity.setRetMsg(ConstantUtil.RETMSG_CORRECT);

            // Set the response result
            resEntity.setResponseContent(responseContent);

        } catch (Exception e) {


            // Set return message
            resEntity.setRetMsg(ConstantUtil.RETMSG_HTTP_GET_FAIL + e.getMessage());
        } finally {
            // Close http connection and release resource
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }

        }
        return responseContent;

    }

    /**
     * Wraps the http get url using request parameters from request entity.
     *
     * @param httpGet
     * @param reqEntity
     * @throws ParseException
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @throws URISyntaxException
     */
    private void wrapHttpGetOrDeleteUrl(HttpRequestBase httpRequest, RequestEntity reqEntity) throws ParseException,
            UnsupportedEncodingException, IOException, URISyntaxException {

        if ((httpRequest instanceof HttpGet || httpRequest instanceof HttpDelete) == false) {
            return;
        }
        // Get request parameters from request entity
        Map<Object, Object> requestParams = reqEntity.getRequestParams();

        if (requestParams != null && !requestParams.isEmpty()) {
            /*
             * Parses request parameters HashMap object to HTTP client
             * NameValuePair list object.
             */
            List<NameValuePair> params = parseMapToList(requestParams);

            // Convert encoded form entity to string.
            String str = EntityUtils.toString(new UrlEncodedFormEntity(params, ConstantUtil.DEFAULT_CHARSET));

            // Regenerate the http get uri using request parameters
            httpRequest.setURI(new URI(httpRequest.getURI().toString() + "?" + str));
        }
    }

    /**
     * Convert the response content encoding from iso8859-1 to utf-8.
     *
     * @param responseContent The input string
     * @return the encoded string
     * @throws UnsupportedEncodingException
     */
    private String convertStrToUtf8(String responseContent) throws UnsupportedEncodingException {

        if (responseContent.equals(new String(responseContent.getBytes(ConstantUtil.CHARSET_ISO),
                ConstantUtil.CHARSET_ISO))) {
            responseContent = new String(responseContent.getBytes(ConstantUtil.CHARSET_ISO),
                    ConstantUtil.DEFAULT_CHARSET);
        }
        return responseContent;
    }

    /**
     * Get the response header from http response and generate them to HashMap
     * object.
     *
     * @param httpResponse The http response
     * @return the generated response header HashMap Object
     */
    private Map<Object, Object> getResponseHeader(HttpResponse httpResponse) {
        Map<Object, Object> responseHeader = new HashMap<Object, Object>();

        // Get all of response headers from http response.
        Header[] headerArray = httpResponse.getAllHeaders();

        // Compose the response header map object using header name and value.
        for (Header header : headerArray) {
            if (header != null) {
                responseHeader.put(header.getName(), header.getValue());
            }

        }
        return responseHeader;
    }

    /**
     * Wraps the request headers for HttpPost or HttpGet from request entity.
     *
     * @param httpPost  The http post object
     * @param httpGet   The http get object
     * @param reqEntity The request entity which wraps the http request parameters
     * @throws UnsupportedEncodingException
     */
    private void wrapRequestHeaders(HttpRequestBase httpReuest, RequestEntity reqEntity)
            throws UnsupportedEncodingException {
        // Get the header parameters from request entity
        Map<Object, Object> headerParams = reqEntity.getHeaderParams();

        if (headerParams != null && !headerParams.isEmpty()) {
            for (Entry<Object, Object> entry : headerParams.entrySet()) {
                Object paramKey = entry.getKey();
                if (paramKey != null && !paramKey.equals("")) {
                    String paramValue = entry.getValue().toString();
                    if (httpReuest != null) { // wrap the request headers for http
                        httpReuest.setHeader(paramKey.toString(),
                                URLDecoder.decode(paramValue, ConstantUtil.DEFAULT_CHARSET));
                    }
                }
            }

        }
    }

    /**
     * Wraps the request data for http post from request entity.
     *
     * @param httpPostOrPut The http post object
     * @param reqEntity     The request entity which wraps the http request parameters
     * @throws UnsupportedEncodingException
     */
    private void wrapRequestData(HttpEntityEnclosingRequestBase httpPostOrPut, RequestEntity reqEntity)
            throws UnsupportedEncodingException {
        Map<Object, Object> requestParams = reqEntity.getRequestParams();
        if (requestParams != null && !requestParams.isEmpty()) {
            // Proceed post body data.The post body data are put in messageBody
            // attribute.
            Object messageBody = requestParams.get(ConstantUtil.POST_BODY_FLAG);
            if (messageBody != null) { // Proceed post body data
                StringEntity strEntity = new StringEntity(messageBody.toString(), Consts.UTF_8);
                httpPostOrPut.setEntity(strEntity);
            } else { // Proceed post form data
                List<NameValuePair> paramsList = parseMapToList(requestParams);
                UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(paramsList, ConstantUtil.DEFAULT_CHARSET);
                httpPostOrPut.setEntity(uefEntity);
            }

        }
    }


    /**
     * Parses request parameters HashMap object to HTTP client NameValuePair
     * list object.
     *
     * @param paramsMap The request parameters HashMap object from request entity
     * @return the HTTP client NameValuePair list object
     * @throws UnsupportedEncodingException
     */
    private List<NameValuePair> parseMapToList(Map<Object, Object> paramsMap) throws UnsupportedEncodingException {
        // Instantiate one NameValuePair list object
        List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
        for (Entry<Object, Object> entry : paramsMap.entrySet()) {
            // Get the parameter name
            Object paramKey = entry.getKey();
            if (paramKey != null && !paramKey.equals("")) {
                // Get the parameter value
                String paramValue = entry.getValue().toString();

                /*
                 * Add the parameter key and value to http client NameValuePair
                 * list.
                 */
                paramsList.add(new BasicNameValuePair(paramKey.toString(), java.net.URLDecoder.decode(paramValue,
                        ConstantUtil.DEFAULT_CHARSET)));

            }
        }
        return paramsList;
    }

}
