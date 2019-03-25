package org.chenxh.reptle.pipeline;

import org.chenxh.web.eneity.Chapter;
import org.chenxh.web.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

public class BiQuGeChapterFilePipeline extends FilePersistentBase implements Pipeline {
    @Autowired
    private ChapterService chapterService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String chapterContext = resultItems.get("chapter").toString();
        Chapter chapter = new Chapter();
        chapter.setContenxt(chapterContext);
        //TODO
        chapter.setBookId(1);
        chapter.setSortId(1);
        //chapterService.insertChapter(chapter);
    }
}
