package org.chenxh.reptle.pipeline;

import org.chenxh.web.entity.Book;
import org.chenxh.web.entity.BookReptileBreak;
import org.chenxh.web.factory.SpringServiceFactory;
import org.chenxh.web.service.BookService;
import org.chenxh.web.service.IBookReptileBreakService;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

public class BiQuGeFilePipeline extends FilePersistentBase implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        Book book = resultItems.get("book");
        BookService bookService = SpringServiceFactory.getBean(BookService.class);
        bookService.insertBook(book);
        int id = book.getBookId();
        BookReptileBreak bookReptileBreak = new BookReptileBreak(id,resultItems.get("url").toString());
        IBookReptileBreakService bookReptileBreakService = SpringServiceFactory.getBean(IBookReptileBreakService.class);
        bookReptileBreakService.save(bookReptileBreak);
    }
}
