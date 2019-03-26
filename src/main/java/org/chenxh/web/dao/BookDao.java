package org.chenxh.web.dao;

import org.chenxh.web.entity.Book;

public interface BookDao {

    Book selectBookByBookName(String bookName);
}
