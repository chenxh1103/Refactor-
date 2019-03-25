package org.chenxh.web.eneity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.lang.reflect.Method;

@TableName(value = "Chapter")
public class Chapter {
    @TableId
    private int bookId;
    private int sortId;
    private String title;
    private String contenxt1;
    private String contenxt2;
    private String contenxt3;
    private String contenxt4;
    private String contenxt5;
    private String ext1;
    private String ext2;
    private String ext3;
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContenxt1() {
        return contenxt1;
    }

    public void setContenxt1(String contenxt1) {
        this.contenxt1 = contenxt1;
    }

    public String getContenxt2() {
        return contenxt2;
    }

    public void setContenxt2(String contenxt2) {
        this.contenxt2 = contenxt2;
    }

    public String getContenxt3() {
        return contenxt3;
    }

    public void setContenxt3(String contenxt3) {
        this.contenxt3 = contenxt3;
    }

    public String getContenxt4() {
        return contenxt4;
    }

    public void setContenxt4(String contenxt4) {
        this.contenxt4 = contenxt4;
    }

    public String getContenxt5() {
        return contenxt5;
    }

    public void setContenxt5(String contenxt5) {
        this.contenxt5 = contenxt5;
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

    public String getContenxt(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getContenxt1()).append(getContenxt2())
                .append(getContenxt3()).append(getContenxt4()).append(getContenxt5());
        return stringBuffer.toString();
    }
    private static final int SPLITE_LENGTH = 2000;
    public void setContenxt(String contenxt){
        StringBuffer meta = new StringBuffer(contenxt);
        char[] buf = meta.toString().toCharArray();
        int splitNode = 0;
        int index = 1;
        try {
            while (splitNode < meta.length()){
                Method method = Chapter.class.getMethod("setContenxt"+index, String.class);
                method.invoke(this,new String(buf,splitNode,SPLITE_LENGTH));
                index++;
                splitNode+=SPLITE_LENGTH;
            }
        }catch (Exception e){

        }
    }
}
