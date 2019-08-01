package org.chenxh.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.log4j.helpers.LogLog;

import java.lang.reflect.Method;
import java.util.Date;

@TableName(value = "Chapter")
public class Chapter {
    private int bookId;
    private int sortId;
    private String title;
    private Date createTime;
    private String contenxt1;
    private String contenxt2;
    private String contenxt3;
    private String contenxt4;
    private String contenxt5;
    private String ext1;
    private String ext2;
    private String ext3;

    public Chapter() {
        this.setCreateTime(new Date());
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

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

    private String getContenxt1() {
        return contenxt1;
    }

    private void setContenxt1(String contenxt1) {
        this.contenxt1 = contenxt1;
    }

    private String getContenxt2() {
        return contenxt2;
    }

    private void setContenxt2(String contenxt2) {
        this.contenxt2 = contenxt2;
    }

    private String getContenxt3() {
        return contenxt3;
    }

    private void setContenxt3(String contenxt3) {
        this.contenxt3 = contenxt3;
    }

    private String getContenxt4() {
        return contenxt4;
    }

    private void setContenxt4(String contenxt4) {
        this.contenxt4 = contenxt4;
    }

    private String getContenxt5() {
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
                Method method = Chapter.class.getDeclaredMethod("setContenxt"+index, String.class);
                int sub = SPLITE_LENGTH;
                if((meta.length()-(index*SPLITE_LENGTH)) < 0){
                    sub = meta.length() - (index-1)*SPLITE_LENGTH;
                }
                method.invoke(this,new String(buf,splitNode,sub));
                index++;
                splitNode+=SPLITE_LENGTH;
            }
        }catch (Exception e){
            LogLog.error("章节内容转换失败："+contenxt);
        }
    }
}
