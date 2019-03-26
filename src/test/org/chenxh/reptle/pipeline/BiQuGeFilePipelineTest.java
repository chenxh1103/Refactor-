package org.chenxh.reptle.pipeline;

import org.chenxh.AbstractTest;
import org.chenxh.reptle.documentParser.biQuGe.BiQuGeChapterPageProcessor;
import org.chenxh.reptle.documentParser.biQuGe.BiQuGePageProcessor;
import org.junit.Test;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.utils.HttpConstant;

public class BiQuGeFilePipelineTest extends AbstractTest {

    @Test
    public void task(){
        Spider.create(new BiQuGePageProcessor())
                .addUrl("https://www.sbiquge.com/31_31715")//遮天抓包
                .addPipeline(new BiQuGeFilePipeline())
                .run();
    }
    @Test
    public void BiQuGeChapterTest(){
        String lastReplatUrl = "https://www.sbiquge.com/31_31715/18971814.html";
        Request request = new Request();
        request.setUrl(lastReplatUrl);
        request.setMethod(HttpConstant.Method.GET);
        Spider.create(new BiQuGeChapterPageProcessor(1122,lastReplatUrl))
                .addRequest(request)
                .addPipeline(new BiQuGeChapterFilePipeline())
                .run();
    }
}