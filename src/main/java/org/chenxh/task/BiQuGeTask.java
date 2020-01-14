package org.chenxh.task;

import org.chenxh.reptle.documentParser.biQuGe.BiQuGeChapterPageProcessor;
import org.chenxh.reptle.pipeline.BiQuGeChapterFilePipeline;
import org.chenxh.task.lock.RedisLock;
import org.chenxh.web.entity.BookReptileBreak;
import org.chenxh.web.factory.SpringServiceFactory;
import org.chenxh.web.service.IBookReptileBreakService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.List;
@Component
public class BiQuGeTask {
    @RedisLock(lockKey = "BiQuGeKey" ,lockPrefix = "BiQuGePre",timeOut = 60)
    @Scheduled(cron = "* 0/5 * * * ? ")// 每天下午14点至15点每5分执行一次
    public void task(){
        IBookReptileBreakService bookReptileBreakService = SpringServiceFactory.getBean(IBookReptileBreakService.class);
        List<BookReptileBreak> list = bookReptileBreakService.list();
        for(int i=0;i<list.size();i++){
            int bookId = list.get(i).getBookId();
            String url = list.get(i).getBreakUrl();
            Request request = new Request();
            request.setUrl(url);
            request.setMethod(HttpConstant.Method.GET);
            Spider.create(new BiQuGeChapterPageProcessor(bookId,url))
                    .addRequest(request)
                    .addPipeline(new BiQuGeChapterFilePipeline())
                    .run();
        }
    }
}
