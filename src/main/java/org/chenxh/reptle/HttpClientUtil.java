package org.chenxh.reptle;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    public static final String UTF_8 = "UTF-8";


    public static void doPost(String url, Map<String,Object> param, String charset){
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        try {
            if(param != null){
                //设置参数
                List<NameValuePair> list = new ArrayList<NameValuePair>();
                for (Map.Entry<String,Object> entry : param.entrySet()) {
                    list.add(new BasicNameValuePair(entry.getKey(),String.valueOf(entry.getValue())));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);
            String result = EntityUtils.toString(httpResponse.getEntity(),UTF_8);
        }catch (Exception e){

        }
    }
    //https://www.zhihu.com/node/ExploreRecommendListV2
    public static void main(String[] args) {

    }

}
