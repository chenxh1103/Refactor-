package org.chenxh.reptle.pipeline;

import org.chenxh.AbstractTest;
import org.chenxh.reptle.documentParser.biQuGe.BiQuGePageProcessor;
import org.junit.Test;
import us.codecraft.webmagic.Spider;

public class BiQuGeFilePipelineTest extends AbstractTest {

    @Test
    public void task(){
        Spider.create(new BiQuGePageProcessor())
                .addUrl("https://www.sbiquge.com/31_31715")//遮天抓包
                .addPipeline(new BiQuGeFilePipeline())
                .run();
    }
}