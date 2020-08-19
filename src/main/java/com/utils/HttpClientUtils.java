package com.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);
    private static final CookieStore cookieStore;
    private static final CloseableHttpClient httpClient;
    private static final HttpClientContext context;

    static {
        // 避免javax.net.ssl.SSLProtocolException: handshake alert: unrecognized_name
        System.setProperty("jsse.enableSNIExtension", "false");
        cookieStore = new BasicCookieStore();
        context = HttpClientContext.create();
        context.setCookieStore(cookieStore);
        httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    }

    public static String doGet(String url, Map<String, Object> param) {
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, String.valueOf(param.get(key)));
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpClient.execute(httpGet, context);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                for (StackTraceElement ele : e.getStackTrace()) {
                    if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                        log.error(ele.toString());
                    }
                }
                log.error(e.toString());
            }
        }
        return resultString;
    }

    public static String doGet(String url) {
        return doGet(url, null);
    }

    public static String doPost(String url, Map<String, Object> param) {
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, String.valueOf(param.get(key))));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost, context);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                for (StackTraceElement ele : e.getStackTrace()) {
                    if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                        log.error(ele.toString());
                    }
                }
                log.error(e.toString());
            }
        }
        return resultString;
    }

    public static String doPost(String url) {
        return doPost(url, null);
    }

    public static String doPostJson(String url, String json) {
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost, context);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            for (StackTraceElement ele : e.getStackTrace()) {
                if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                    log.error(ele.toString());
                }
            }
            log.error(e.toString());
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                for (StackTraceElement ele : e.getStackTrace()) {
                    if (ele.toString().indexOf(Thread.currentThread().getStackTrace()[1].getClassName()) > -1) {
                        log.error(ele.toString());
                    }
                }
                log.error(e.toString());
            }
        }
        return resultString;
    }

    public static void main(String[] args) {
    }
}
