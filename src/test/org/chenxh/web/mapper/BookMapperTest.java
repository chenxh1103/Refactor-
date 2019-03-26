package org.chenxh.web.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.chenxh.web.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:refactor-servletTest.xml"})
public class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;
    @Test
    public void test(){
        Book book = bookMapper.selectOne(new QueryWrapper<Book>().eq("id",1));
        Assert.assertNull(book);
    }
}