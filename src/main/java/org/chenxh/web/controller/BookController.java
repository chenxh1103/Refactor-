package org.chenxh.web.controller;

import org.chenxh.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/index")
    public String index(){


        return "index";
    }
}
