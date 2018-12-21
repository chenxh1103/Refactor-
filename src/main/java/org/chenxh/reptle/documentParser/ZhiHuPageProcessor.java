package org.chenxh.reptle.documentParser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZhiHuPageProcessor implements PageProcessor {
    private final static Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    private List<HashMap<String,String>> list = new ArrayList<>();
    @Override
    public void process(Page page) {
        for(int j = 1;j<6;j++){
            Request request = new Request();
            request.setMethod(HttpConstant.Method.GET);
            request.setUrl("https://api.bilibili.com/x/web-interface/newlist?pn="+String.valueOf(j)+"&ps=2");
            page.addTargetRequest(request);
        }
        JSONArray json= JSONObject.parseObject(page.getJson().jsonPath("data").toString()).getJSONArray("archives");
        for (int i=0;i<json.size();i++) {
            Map<String,String> map = new HashMap<>();
            page.putField("title", json.getJSONObject(i).getString("title"));
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new ZhiHuPageProcessor())
                .addUrl("https://api.bilibili.com/x/web-interface/newlist?pn=0&ps=1")
                .addPipeline(new JsonFilePipeline("F:/data"))
                .run();
    }
}
