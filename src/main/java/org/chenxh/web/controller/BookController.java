package org.chenxh.web.controller;

import org.chenxh.web.entity.Book;
import org.chenxh.web.service.BookService;
import org.chenxh.web.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ChapterService chapterService;

    @RequestMapping(value = "/test")
    public String test(Model model, HttpServletRequest request){
        request.getLocale();
        model.addAttribute("msg", "Hello Spring MVC 5!中文测试");
        return "test";
    }
    @RequestMapping(value = "/{bookId}/{sortId}.html")
    public String book(@PathVariable String bookId, @PathVariable String sortId,Model model){
        model.addAttribute("contenxt",  chapterService.selectChapterByBookIdAndSortId(bookId,sortId).getContenxt());
        return "book";
    }



    @ResponseBody
    @RequestMapping(value = "/{bookId}",method = RequestMethod.GET)
    public Book selectBookJson(@PathVariable("bookId") String bookId){
        Book book = bookService.selectBookByBookId(bookId);
        return book;
    }


}
