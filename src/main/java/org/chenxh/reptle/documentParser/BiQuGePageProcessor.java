package org.chenxh.reptle.documentParser;

import org.chenxh.reptle.pipeline.BiQuGeFilePipeline;
import org.chenxh.web.eneity.Book;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class BiQuGePageProcessor implements PageProcessor {
    private final static Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    private Book book = new Book();

    @Override
    public void process(Page page) {
        List<Selectable> nodes = page.getHtml().xpath("//*[@class=\"listmain\"]//d1").nodes();
        Selectable fristNode = null;
        for(int i=0;i<nodes.size();i++){
            String html = nodes.get(0).xpath("/text()").toString();
            html.contains("正文卷");
            fristNode = nodes.get(i+1);
            break;
        }
        String fristChapterUrl = fristNode.xpath("//a/@href").toString();
        String bookName = page.getHtml().xpath("//*[@id=\"info\"]//h1/text()").toString();
        String author = page.getHtml().xpath("//*[@id=\"info\"]//p").nodes().get(0).xpath("text()").toString();
        /*        charpUrl.forEach((url)-> {Request request = new Request();
            request.setUrl(page.getUrl().toString()+url);
            request.setMethod(HttpConstant.Method.GET);
            page.addTargetRequest(request);});*/
        book.setBookName(bookName);
        book.setAuthor(author);
        page.putField("book",book);
        page.putField("url",fristChapterUrl);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new BiQuGePageProcessor())
                .addUrl("https://www.sbiquge.com/31_31715")//遮天抓包
                .addPipeline(new BiQuGeFilePipeline())
                .run();

    }
}
/*
    Object s0 =page.getHtml().xpath("//div[@class='detail-wrapper']//div[@class='header ']/a/img/@src")

    //获取上述前缀的a标签下的div下的class名为name的span标签里面的内容
    Object s1 =page.getHtml().xpath("//div[@class='detail-wrapper']//div[@class='header ']/a/div/span[@class='name']/text()")

    //获取class名为time timeago的span标签里的内容
    Object s2 =page.getHtml().xpath("//div[@class='detail-wrapper']//div[@class='header ']/a/div/span[@class='time timeago']/text()")

    //获取p标签下的内容
    Object s3 =page.getHtml().xpath("//div[@class='detail-wrapper']//div[@class='content-wrapper']//h1[@class='title']/p/text()")
*/
