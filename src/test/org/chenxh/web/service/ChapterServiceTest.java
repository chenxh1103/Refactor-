package org.chenxh.web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.chenxh.AbstractTest;
import org.chenxh.web.entity.Chapter;
import org.chenxh.web.factory.SpringServiceFactory;
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
    @Test
    public void contenxt(){
        ChapterService chapterService = SpringServiceFactory.getBean(ChapterService.class);
        Chapter chapter = chapterService.getOne(new QueryWrapper<Chapter>().orderByDesc("sort_id").eq("book_id",1122));
    }


}