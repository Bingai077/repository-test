package com.bingai.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**Element对象功能
 * @author bingai
 * @create 2019-11-26 16:48
 *
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        /*
            2. 获取属性值
                * String attr(String key)：根据属性名称获取属性值
            3. 获取文本内容
                * String text():获取文本内容
                * String html():获取标签体的所有内容(包括字标签的字符串内容)
         */
        //通过Document对象获取name标签，获取所有的name标签，可以获取到两个
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());

        //通过Element对象获得子标签对象
        Element element_student = document.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());

        //获取student对象的属性值
        String number = element_student.attr("NUMBER");
        System.out.println(number);

        //获取文本内容
        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println(text);
        System.out.println(html);


    }
}
