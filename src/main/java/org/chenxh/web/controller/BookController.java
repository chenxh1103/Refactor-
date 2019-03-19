package org.chenxh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping(value = "/index")
    public String index(){


        return "index";
    }
}
