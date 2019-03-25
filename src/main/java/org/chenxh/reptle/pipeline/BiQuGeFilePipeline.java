package org.chenxh.reptle.pipeline;

import org.chenxh.web.eneity.Book;
import org.chenxh.web.service.BookService;
import org.chenxh.web.serviceImpl.BookServiceImpl;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

public class BiQuGeFilePipeline extends FilePersistentBase implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        Book book = resultItems.get("book");
        BookService bookService = new BookServiceImpl();
        bookService.insertBook(book);
    }
}
