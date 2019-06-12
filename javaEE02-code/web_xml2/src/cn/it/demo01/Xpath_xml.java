package cn.it.demo01;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Xpath_xml {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = Xpath_xml.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("-----------------");
        List<JXNode> jxNodes1 = jxDocument.selN("//student[@id]");
        for (JXNode jxNode : jxNodes1) {
            System.out.println(jxNode);

        }


    }
}
