package com.ares.recycle.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author qiaomu.wang
 * @date 2018-02-26
 */
@Slf4j
public class HttpClient {

    public static String sendGet(String httpUrl) throws IOException {
        URL url = new URL(httpUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(Boolean.TRUE);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        bufferedReader.close();

        log.info("Sending 'GET' request to URL={},responseCode={},response={}",
                httpUrl, connection.getResponseCode(), response.toString());
        return response.toString();
    }

    public static String sendPost(String httpUrl, String params) throws IOException {
        URL obj = new URL(httpUrl);
        HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestProperty("Connection", "Keep-Alive");
        conn.setRequestProperty("Charset", "UTF-8");
        // 设置文件类型:
        conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        conn.setRequestProperty("accept","application/json");

        //发送Post请求
        conn.setDoOutput(Boolean.TRUE);
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.write(params.getBytes("utf-8"));
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        log.info("Sending 'POST' request to URL={},parameters={},responseCode={},response={}",
                httpUrl, params, conn.getResponseCode(), response.toString());
        return response.toString();
    }

    public static String getParamsString(Map<String, String> params)throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }
}
