package org.chenxh.reptle.pipeline;

import org.chenxh.AbstractTest;
import org.chenxh.reptle.documentParser.biQuGe.BiQuGePageProcessor;
import org.chenxh.web.factory.SpringServiceFactory;
import org.chenxh.web.eneity.Book;
import org.chenxh.web.service.BookService;
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
    @Test
    public void t(){
        Book book = new Book();
        book.setBookId(1);
        book.setBookName("chenxh");
        BookService bookService = SpringServiceFactory.getBean(BookService.class);
        bookService.selectBook(book);
    }
}