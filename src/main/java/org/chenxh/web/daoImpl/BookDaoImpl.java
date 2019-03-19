package org.chenxh.web.daoImpl;

import org.chenxh.web.dao.BookDao;
import org.chenxh.web.eneity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Book selectBookByBookName(String bookName) {
        return null;
    }
}
