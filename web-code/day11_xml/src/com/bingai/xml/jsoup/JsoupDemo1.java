package com.bingai.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**Jsoup快速入门
 * @author bingai
 * @create 2019-11-26 11:57
 */


/*
 对象的使用：
1. Jsoup：工具类，可以解析html或xml文档，返回Document
    * parse：解析html或xml文档，返回Document
    * parse(File in, String charsetName)：解析xml或html文件的。
    * parse(String html)：解析xml或html字符串
    * parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
2. Document：文档对象。代表内存中的dom树
    * 获取Element对象
        * getElementById(String id)：根据id属性值获取唯一的element对象
        * getElementsByTag(String tagName)：根据标签名称获取元素对象集合
        * getElementsByAttribute(String key)：根据属性名称获取元素对象集合
        * getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
3. Elements：元素Element对象的集合。可以当做 ArrayList<Element>来使用
4. Element：元素对象
    1. 获取子元素对象
        * getElementById(String id)：根据id属性值获取唯一的element对象
        * getElementsByTag(String tagName)：根据标签名称获取元素对象集合
        * getElementsByAttribute(String key)：根据属性名称获取元素对象集合
        * getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
    2. 获取属性值
        * String attr(String key)：根据属性名称获取属性值
    3. 获取文本内容
        * String text():获取文本内容
        * String html():获取标签体的所有内容(包括字标签的字符串内容)
5. Node：节点对象
    * 是Document和Element的父类

 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //1.导入jar包
        //2.获取Document对象，根据xml文档获取
        //2.1获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树  ---> Document
        //Document document = Jsoup.parse(new File(path), "utf-8");
        //System.out.println(document);

        //2.parse(String html)：解析xml或html字符串
//        String str = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
//                "\n" +
//                "<students>\n" +
//                "\t<student number=\"s001\">\n" +
//                "\t\t<name>tom</name>\n" +
//                "\t\t<age>23</age>\n" +
//                "\t\t<sex>male</sex>\n" +
//                "\t</student>\n" +
//                "\n" +
//                "\t<student number=\"s002\">\n" +
//                "\t\t<name>jack</name>\n" +
//                "\t\t<age>24</age>\n" +
//                "\t\t<sex>female</sex>\n" +
//                "\t</student>\n" +
//                "</students>";
//        Document document = Jsoup.parse(str);
//        System.out.println(document);

        //3. parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
        URL url = new URL("https://www.baidu.com");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);


        //3.获取元素对象 Element
//        Elements elements = document.getElementsByTag("name");
//        System.out.println(elements.size());
//        //3.1获取第一个name的Element对象
//        Element element = elements.get(0);
//        //3.2获取数据
//        String name = element.text();
//        System.out.println(name);


    }

}
