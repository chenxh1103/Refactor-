package org.chenxh.reptle.pipeline;

import org.chenxh.web.entity.BookReptileBreak;
import org.chenxh.web.entity.Chapter;
import org.chenxh.web.factory.SpringServiceFactory;
import org.chenxh.web.service.ChapterService;
import org.chenxh.web.service.IBookReptileBreakService;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

public class BiQuGeChapterFilePipeline extends FilePersistentBase implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        Chapter chapter = resultItems.get("chapter");
        if(chapter != null){
            ChapterService chapterService = SpringServiceFactory.getBean(ChapterService.class);
            chapterService.insertChapter(chapter);
            int bookId = chapter.getBookId();
            BookReptileBreak bookReptileBreak = new BookReptileBreak(bookId,resultItems.get("url").toString());
            IBookReptileBreakService bookReptileBreakService = SpringServiceFactory.getBean(IBookReptileBreakService.class);
            bookReptileBreakService.updateById(bookReptileBreak);
        }
    }
}
