package com.bingai.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**Document/Element对象功能
 * @author bingai
 * @create 2019-11-26 16:48
 *
 */
public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path = JsoupDemo2.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.获取元素对象
        //3.1获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);

        System.out.println("-----------------------");

        //3.2获取属性名为id的元素对象们
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);

        System.out.println("============");
        //3.3获取number属性值为s001的元素对象
        Elements elements2 = document.getElementsByAttributeValue("number", "s001");
        System.out.println(elements2);

        System.out.println("===========");
        //3.4获取id属性值的元素
        Element element = document.getElementById("bin");
        System.out.println(element);



    }
}
