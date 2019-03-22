package org.chenxh.web.service;

import org.chenxh.web.eneity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {

    Book selectBookByBookId(String id);

    Book selectBook(Book book);

    int insertBook(Book book);

    int insertBook(List<Book> bookList);

    int deleteBook(String bookId);

    int deleteBook(Book book);
}
