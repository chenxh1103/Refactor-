package org.chenxh.reptle.documentParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TaoBao implements DocumentParser{
    private static final String url = "http://www.taobao.com";

    @Override
    public void parserDocument(String documentString) {
        Document document = Jsoup.parse(documentString);
        Elements elements = document.getElementsByClass("service J_Service");
        for (Element element:elements) {
            Elements a = element.getElementsByTag("a");
            for(Element element1:a){
                System.out.println(element1.html()+"------"+element1.attributes().get("href"));
            }
        }
    }
}
