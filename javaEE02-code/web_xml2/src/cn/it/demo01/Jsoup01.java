package cn.it.demo01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Jsoup01 {
    public static void main(String[] args) throws IOException {
        //获取配置文件
        String path = Jsoup01.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        /*Document docu = Jsoup.parse(new File(path), "utf-8");
        System.out.println(docu);*/
 /*       Elements ages = docu.getElementsByTag("age");
        Element age1 = ages.get(0);
        String age = age1.text();
        System.out.println(age);*/
       String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
               "\n" +
               "<students>\n" +
               " \t<student number=\"heima_0001\">\n" +
               "\t\t<name>sds</name>\n" +
               "\t\t<age>15</age>\n" +
               "\t\t<sex>male</sex>\n" +
               "\t</student>\n" +
               "\t<student number=\"heima_0002\">\n" +
               "\t\t<name>zzz</name>\n" +
               "\t\t<age>15</age>\n" +
               "\t\t<sex>male</sex>\n" +
               "\t</student>\n" +
               "\t\t \n" +
               " </students>";
       /* Document document = Jsoup.parse(str);
        System.out.println(document);*/
      /*  Document document = Jsoup.parse(new URL(""), 3000);
        System.out.println(document);*/

        Document document1 = Jsoup.parse(new File(path), "utf-8");
        /*Elements students1 = document1.getElementsByTag("student");
        System.out.println(students1);*/
       /* Elements student2 = document1.getElementsByAttribute("id");
        System.out.println(student2);*/
        Elements id = document1.getElementsByAttributeValue("id", "001");
        System.out.println(id);
        Elements student = document1.select("student");
        System.out.println(student);
        System.out.println("--------------");
        Elements age = document1.select("student[number='heima_0001']>age");
        System.out.println(age);
    }
}
