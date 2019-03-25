package org.chenxh.reptle.documentParser.biQuGe;

import org.chenxh.reptle.pipeline.BiQuGeChapterFilePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class BiQuGeChapterPageProcessor implements PageProcessor {

    private final static Site site = Site.me().setTimeOut(3000).setRetryTimes(6).setSleepTime(2000);

    @Override
    public void process(Page page) {
        String nextChapterUrl = "https://www.sbiquge.com"+page.getHtml().xpath("//div[@class='page_chapter']//li[3]/a/@href").toString();
        if(nextChapterUrl.endsWith(".html")){
            page.addTargetRequest(nextChapterUrl);
        }
        String context = page.getHtml().xpath("//div[@id='content']/html()").toString();
        page.putField("chapter",context);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //https://www.sbiquge.com/31_31715/18962523.html
        Spider.create(new BiQuGeChapterPageProcessor())
                .addUrl("https://www.sbiquge.com/31_31715/18962523.html")//遮天抓包
                .addPipeline(new BiQuGeChapterFilePipeline())
                .run();
    }
}
