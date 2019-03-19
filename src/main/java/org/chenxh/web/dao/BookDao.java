package org.chenxh.web.dao;

import org.chenxh.web.eneity.Book;

public interface BookDao {

    Book selectBookByBookName(String bookName);
}
