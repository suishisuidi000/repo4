package cn.it.demo01;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Jsoup_xml {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = Jsoup_xml.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        /*Elements elements = document.getElementsByTag("student");
        Elements name = elements.get(0).getElementsByTag("name");
        System.out.println(name);*/
        Elements name = document.select("name[id='01']");
        String text = name.text();
        System.out.println(text);

        System.out.println("--------------");

        Elements elements = document.select("student[number='heima_0001']>sex");
        System.out.println(elements);
        System.out.println("------------");
        Elements select = document.select("#001");
        System.out.println(select);
        Elements name1 = document.select("name");
        System.out.println(name1);

        /*
        解析方式: Dom: 将标记语言文档一次性加载进内存,形成一颗dom树,占内存,可以进行crud操作
                  SAX: 逐行读取,基于事件驱动,不占内存,只能读取,不能增删改.
         */
        System.out.println("-----------");
        List<JXNode> jxNodes = new JXDocument(document).selN("//name[@id='01']");
        System.out.println(jxNodes);

    }
}
