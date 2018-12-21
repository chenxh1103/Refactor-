package org.chenxh.reptle.documentParser;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor{
    private static Logger log = Logger.getLogger(GithubRepoPageProcessor.class.getClass());

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        Elements elements = page.getHtml().getDocument().getElementsByClass("service J_Service");
        for (Element element:elements) {
            Elements a = element.getElementsByTag("a");
            for(Element element1:a){
                System.out.println(element1.html()+"------"+element1.attributes().get("href"));
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws Exception  {

        Spider spider = Spider.create(new GithubRepoPageProcessor()).addUrl("http://www.taobao.com");
        SpiderMonitor.instance().register(spider);
        spider.start();
    }
}
