package org.chenxh.reptle.documentParser.biQuGe;

import org.chenxh.web.eneity.Book;
import org.chenxh.web.enums.BookState;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class BiQuGePageProcessor implements PageProcessor {
    private final static Site site = Site.me().setTimeOut(3000).setRetryTimes(3).setSleepTime(1000);
    private Book book = new Book();

    @Override
    public void process(Page page) {
        List<Selectable> nodes = page.getHtml().xpath("//*[@class=\"listmain\"]//dl/").nodes();
        for(int i=0;i<nodes.size();i++){
            String html = nodes.get(i).get();
            if(html.contains("正文卷")){
                Selectable fristNode = nodes.get(i+1);
                //page.putField("url","https://www.sbiquge.com"+fristNode.xpath("//*/a/@href").toString());
                book.setExt1("https://www.sbiquge.com"+fristNode.xpath("//*/a/@href").toString());
                book.setExt2(page.getUrl().toString().replaceAll("https://www.sbiquge.com",""));
                break;
            }
        }
        String bookName = page.getHtml().xpath("//*[@id=\"info\"]//h1/text()").toString();
        String author =  page.getHtml().xpath("//*[@id=\"info\"]//p[1]/text()").toString().substring(4);
        String bookState =  page.getHtml().xpath("//*[@id=\"info\"]//p[2]/text()").toString().substring(4);
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setBookState(BookState.valueOfDesc(bookState));
        page.putField("book",book);
    }

    @Override
    public Site getSite() {
        return site;
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
