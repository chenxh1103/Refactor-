package org.chenxh.web.mapper;

import org.chenxh.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChapterMapperTest extends AbstractTest {
    @Autowired
    private ChapterMapper chapterMapper;

    @Test
    public void selectMaxSortIdByBookId(){
        int sortId = chapterMapper.selectMaxSortIdByBookId(112);
        Assert.assertEquals(1,sortId);
    }
}