package com.bingai.day20.demo07.Properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
    java.util.Properties集合 extends Hashable<k,v> impluments Map<k,v>
        Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。
        Properties是唯一和IO流相结合的集合
            可以使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
            可以使用Properties集合中的方法load，把硬盘中保存的文件(键值对)，读取到结合中使用

        属性列表中每个键及其对应值都是一个字符串。
            Properties集合是一个双列集合，key和value默认都是字符串

 */
public class Demo01Properties {
    public static void main(String[] args) throws IOException {

        //show01();
        //show02();
        show03();
    }

    private static void show03() throws IOException {
        /*
            方法load，把硬盘中保存的文件(键值对)，读取到结合中使用
            void load(Reader reader)
            void load(InputStream inStream)
            参数：
                InputStream inStream：字节输入流，不能读取含有中文的键值对
                Reader reader：字符输入流，能获取含有中文的键值对
            使用步骤：
                1.创建Properties集合对象
                2.使用Properties集合对象中的方法load读取保存的键值对的文件
                3.遍历Properties集合
            注意：
                1.存储键值对的文件中，键与值默认的连接符号可以使用=，空格(其他符号)
                2.存储键值对的文件中，可以使用#进行注释，被注释的键值对不会再被读取
                3.存储键值对的文件中，键与值都是字符串，不再加引号

         */

        //1.创建Properties集合对象
        Properties properties = new Properties();
        // 2.使用Properties集合对象中的方法load读取保存的键值对的文件
        properties.load(new FileReader("day20-code\\\\src\\\\com\\\\bingai\\\\day20\\\\demo07\\\\prop.txt"));
        //properties.load(new FileInputStream("day20-code\\\\src\\\\com\\\\bingai\\\\day20\\\\demo07\\\\prop.txt"));
        //3.遍历Properties集合
        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            System.out.println(key + "<" +properties.getProperty(key));
        }
    }

    private static void show02() throws IOException {
        /*
             方法store，把集合中的临时数据，持久化写入到硬盘中存储
             void store(OutputStream out, String comments)
             void store(Writer writer, String comments)
             参数：
                OutputStream：字节输出流，不能写中文
                Writer writer：字符输出流，可以写中文
                String comments：注释，用来解释说明保存的文件是做什么用的
                                不能使用中文，会产生乱码，默认是Unicode编码
                                一般使用"空字符串"
             使用步骤：
                1.创建Properties集合对象，添加数据
                2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
                3.使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
                4.释放资源
         */
        //1.创建Properties集合对象，添加数据
        Properties properties = new Properties();
        properties.setProperty("bingai","170");
        properties.setProperty("斌","165");
        properties.setProperty("改","178");

//        //2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
//        FileWriter fw = new FileWriter("day20-code\\src\\com\\bingai\\day20\\demo07\\prop.txt");
//
//        //3.使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
//        properties.store(fw,"save data");
//
//        // 4.释放资源
//        fw.close();

        properties.store(new FileOutputStream("day20-code\\\\src\\\\com\\\\bingai\\\\day20\\\\demo07\\\\prop.txt"),"data");


    }


    /*
        使用Properties集合存储数据，遍历取出Properties集合中的数据
        Properties集合是一个双列集合，key和value默认都是字符串
        Properties集合有一些操作字符串的特有方法
            Object setProperty(String key, String value) 调用 Hashtable 的方法 put。
            String getProperty(String key)  通过key找到value值，此方法相当于Map集合中的get(key)ff
            Set<String> stringPropertyNames() 返回此属性列表中的键集，其中该键及其对应值是字符串，此方法相当于Map集合中的keySet方法

     */
    public static void show01(){
        //创建Properties集合对象
        Properties properties = new Properties();
        //使用setProperty往集合中添加数据
        properties.setProperty("bingai","170");
        properties.setProperty("斌","165");
        properties.setProperty("Coco","178");
//        properties.put("1","25");

        //使用stringPropertyNames把集合中的键取出，存储到一个Set集合中
        Set<String> stringSet = properties.stringPropertyNames();

        //遍历stringSet集合，取出Properties集合的每一个键
        for (String key : stringSet) {
            //使用getProperty方法通过key获取value
            System.out.println(key + "=" +properties.getProperty(key));
        }



    }
}
