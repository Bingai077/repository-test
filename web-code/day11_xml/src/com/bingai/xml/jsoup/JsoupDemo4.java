package com.bingai.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**选择器查询
 * @author bingai
 * @create 2019-11-26 16:48
 *
 */
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.查询name标签
        /*
            div{

            }
         */
        Elements elements = document.select("name");
        System.out.println(elements);

        System.out.println("======================");
        //4.查询id值为bin的元素
        Elements elements1 = document.select("#bin");
        System.out.println(elements1);

        //5.1 获取student标签并且number属性值为s001的标签
        Elements elements2 = document.select("student[number ='s001']");
        System.out.println(elements2);
        System.out.println("---------------------");

        //5.2 获取student标签并且number属性值为s001的age的子标签
        Elements elements3 = document.select("student[number ='s001'] age");
        System.out.println(elements3);
        System.out.println("---------------------");




    }
}
