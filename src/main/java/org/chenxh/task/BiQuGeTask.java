package org.chenxh.task;

import org.chenxh.web.entity.BookReptileBreak;
import org.chenxh.web.factory.SpringServiceFactory;
import org.chenxh.web.service.IBookReptileBreakService;

import java.util.List;

public class BiQuGeTask {

    public void task(){
        IBookReptileBreakService bookReptileBreakService = SpringServiceFactory.getBean(IBookReptileBreakService.class);
        List<BookReptileBreak> list = bookReptileBreakService.list();
        for(int i=0;i<list.size();i++){
            int bookId = list.get(i).getBookId();
            String url = list.get(i).getBreakUrl();
        }
    }
}
