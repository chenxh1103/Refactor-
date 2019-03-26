package org.chenxh.web.entity;

import com.baomidou.mybatisplus.annotation.*;
import org.chenxh.web.enums.BookState;

import java.util.List;

//CREATE SEQUENCE IF NOT EXISTS SEQ_BOOK START WITH 1 INCREMENT BY 1;
//@KeySequence("SEQ_BOOK")
@TableName("Book")
public class Book {
    @TableId(type = IdType.AUTO)
    private int bookId;
    private String bookName;
    private String author;
    private BookState bookState;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;
    @TableField(exist = false)
    private List<Chapter> chapters;

    public BookState getBookState() {
        return bookState;
    }

    public void setBookState(BookState bookState) {
        this.bookState = bookState;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }
}
