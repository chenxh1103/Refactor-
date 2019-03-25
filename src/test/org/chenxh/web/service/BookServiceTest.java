package org.chenxh.web.service;

import org.chenxh.web.eneity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:refactor-servletTest.xml"})
public class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Test
    public void insertBook(){
        Book book = new Book();
        book.setAuthor("陈");
        book.setBookName("人");
        int result = bookService.insertBook(book);
        Assert.assertEquals(1,result);
    }
    @Test
    public void deleteBook(){
        Book book = new Book();
        book.setBookId(1);
        book.setBookName("chenxh");
        int result = bookService.deleteBook(book);
        Assert.assertEquals(1,result);
    }
    @Test
    public void selectBook(){
        Book book = new Book();
        book.setBookId(1116);
        Book selectBook = bookService.selectBook(book);
        Assert.assertNotNull(selectBook);
    }
}