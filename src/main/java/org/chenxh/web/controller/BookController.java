package org.chenxh.web.controller;

import org.chenxh.web.entity.Book;
import org.chenxh.web.enums.BookState;
import org.chenxh.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/index")
    public String index(){

        return "index";
    }
    @RequestMapping(value = "/{bookId}/{sortId}.html")
    public String book(@PathVariable String bookId, @PathVariable String sortId){
        System.out.println(bookId);
        return "index";
    }
    @ResponseBody
    @RequestMapping(value = "/{bookId}")
    public Book selectBook(@PathVariable("bookId") String bookId){
        Book book = new Book();
        book.setBookId(1);
        book.setBookName("chen");
        book.setAuthor("三大");
        book.setBookState(BookState.Serial);
        return book;
    }
}
