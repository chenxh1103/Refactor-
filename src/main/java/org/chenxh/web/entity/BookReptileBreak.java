package org.chenxh.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("Book_Reptile_Break")
public class BookReptileBreak {
    @TableId(type = IdType.INPUT)
    private int bookId;
    private String breakUrl;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBreakUrl() {
        return breakUrl;
    }

    public void setBreakUrl(String breakUrl) {
        this.breakUrl = breakUrl;
    }

    public BookReptileBreak(int bookId, String breakUrl) {
        this.bookId = bookId;
        this.breakUrl = breakUrl;
    }
}
