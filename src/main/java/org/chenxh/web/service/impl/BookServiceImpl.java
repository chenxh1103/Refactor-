package org.chenxh.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.chenxh.web.entity.Book;
import org.chenxh.web.mapper.BookMapper;
import org.chenxh.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book selectBookByBookId(String id) {
        return bookMapper.selectById(id);
    }

    @Override
    public Book selectBook(Book book) {
        return bookMapper.selectOne(new QueryWrapper<>(book));
    }

    @Override
    public int insertBook(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    public int insertBook(List<Book> bookList) {
        return 0;
    }

    @Override
    public int deleteBook(String bookId) {
        return bookMapper.deleteById(bookId);
    }

    @Override
    public int deleteBook(Book book) {
        return bookMapper.delete(new QueryWrapper<>(book));
    }
}
