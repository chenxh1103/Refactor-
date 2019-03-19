package org.chenxh.reptle.documentParser;

import org.chenxh.reptle.pipeline.JuZiMiFilePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.List;

public class JuZiMiPageProcessor implements PageProcessor {
    private final static Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        for(int j = 1;j<50;j++){
            Request request = new Request();
            request.setMethod(HttpConstant.Method.GET);
            request.setUrl("https://www.juzimi.com/totallike?page="+String.valueOf(j));
            page.addTargetRequest(request);
        }
       // JSONArray json= JSONObject.parseObject(page.getJson().jsonPath("data").toString()).getJSONArray("archives");
       /* Elements elements = page.getHtml().getDocument().getElementsByClass("views-field-phpcode");
        for (Element element :elements) {
            String html = element.getElementsByClass("views-field-phpcode-1").get(0).getElementsByTag("a").toString();
            page.putField("title",html);
        }*/
        List<String> html = page.getHtml().xpath("//*[@class=\"xlistju\"]/text()").all();
        for (String s:html) {
            page.putField(s,s+"\n");
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //https://www.juzimi.com/totallike
        Spider.create(new JuZiMiPageProcessor())
                .addUrl("https://www.juzimi.com/totallike?page=0")
                .addPipeline(new JuZiMiFilePipeline("F:/data"))
                .run();

    }
}
