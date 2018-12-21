package org.chenxh.reptle;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    private static final String UTF_8 = "UTF-8";
    private static final String EMPTY  = "";

    public static Document doPost(String url, Map<String,Object> param){
        return doPost(url,param,UTF_8);
    }

    public static Document doPost(String url, Map<String,Object> param, String charset){
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        try {
            if(param != null){
                //设置参数
                List<NameValuePair> list = new ArrayList<>();
                for (Map.Entry<String,Object> entry : param.entrySet()) {
                    list.add(new BasicNameValuePair(entry.getKey(),String.valueOf(entry.getValue())));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);
            return Jsoup.parse(EntityUtils.toString(httpResponse.getEntity(),UTF_8));
        }catch (Exception e){
            //TODO
        }
        return Jsoup.parse(EMPTY);
    }
}
