package org.chenxh.web.service;

import org.chenxh.AbstractTest;
import org.chenxh.web.eneity.Chapter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChapterServiceTest extends AbstractTest {
    @Autowired
    private ChapterService chapterService;

    @Test
    public void insert(){
        Chapter chapter = new Chapter();
        chapter.setBookId(1);
        chapter.setTitle("第一章");
        chapter.setContenxt1("test1");
        chapter.setContenxt2("test2");
        int size = chapterService.insertChapter(chapter);
        Assert.assertEquals(1,size);
    }

}