package org.chenxh.reptle.documentParser.biQuGe;

import org.chenxh.web.entity.Chapter;
import org.chenxh.web.factory.SpringServiceFactory;
import org.chenxh.web.service.ChapterService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

public class BiQuGeChapterPageProcessor implements PageProcessor {

    private final static Site site = Site.me().setTimeOut(3000).setRetryTimes(6).setSleepTime(2000);
    //上次最后抓取的一个url
    private String lastReptleUrl;
    private int bookId;
    private int sortId;

    public int getSortId() {
        return sortId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getLastReptleUrl() {
        return lastReptleUrl;
    }

    public void setLastReptleUrl(String lastReptleUrl) {
        this.lastReptleUrl = lastReptleUrl;
    }

    public BiQuGeChapterPageProcessor(int bookId,String lastReptleUrl) {
        this.bookId = bookId;
        if(lastReptleUrl == null){
            this.lastReptleUrl = "";
        }else{
            this.lastReptleUrl = lastReptleUrl;
        }
        ChapterService chapterService = SpringServiceFactory.getBean(ChapterService.class);
        this.sortId = chapterService.selectMaxSortIdByBookId(bookId);
    }

    @Override
    public void process(Page page) {
        String nextChapterUrl = "https://www.sbiquge.com"+page.getHtml().xpath("//div[@class='page_chapter']//li[3]/a/@href").toString();
        if(nextChapterUrl.endsWith(".html")){
            //如果还有下一章
            Request request = new Request();
            request.setUrl(nextChapterUrl);
            request.setMethod(HttpConstant.Method.GET);
            page.addTargetRequest(request);
        }
        if(getLastReptleUrl().equals(page.getUrl().toString())){
            //如果上次抓取的最后一个url与这次相同，ue则这次不做入表操作
            return;
        }
        String title = page.getHtml().xpath("//div[@id='book']//div[@class='content']/h1/text()").toString();
        String context = page.getHtml().xpath("//div[@id='content']/html()").toString();
        Chapter chapter = new Chapter();
        chapter.setBookId(this.getBookId());
        sortIdIncrement();//sortId自增
        chapter.setSortId(this.getSortId());
        chapter.setTitle(title);
        chapter.setContenxt(context);
        page.putField("chapter",chapter);
        page.putField("url",page.getUrl().toString());
    }

    @Override
    public Site getSite() {
        return site;
    }

    private void sortIdIncrement(){
        this.sortId++;
    }
}
