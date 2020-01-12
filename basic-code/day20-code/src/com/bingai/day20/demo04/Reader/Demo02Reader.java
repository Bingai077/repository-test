package com.bingai.day20.demo04.Reader;

import java.io.FileReader;
import java.io.IOException;

/*
    java.io.Reader：字符输入流，是字符输入流的最顶层的父类，定义了一些共性的成员方法，是一个抽象类。

    共性的成员方法：
         int read()  读取单个字符。
         int read(char[] cbuf) 将字符读入数组。
         void close()   关闭该流并释放与之关联的所有资源。

     java.io.FileReader extends InputStreamReader extends Reader
     FileReader：文件字符输入流
     作用：把硬盘文件中的数据以字符的方式读取到内存中

     构造方法：
        FileReader(File file) 在给定从中读取数据的 File 的情况下创建一个新 FileReader。
        FileReader(String fileName) 在给定从中读取数据的文件名的情况下创建一个新 FileReader。
        参数：读取文件的数据源
            File file：文件
            String fileName：文件的路径
        FileReader构造方法的作用：
            1.创建一个FileReader对象
            2.会把FileReader对象指向要读取的文件

     字符输入流的【使用步骤】：
        1.创建FileReader对象，构造方法中绑定要读取的数据
        2.使用FileReader对象中的方法read读取文件
        3.释放资源

      String类的构造方法
           String(char[] value)：把字符数组转换为字符串
           String(char[] value, int offset, int count)：把字符数组的一部分转换成字符串
               offset数组的开始索引，count转换的个数


 */
public class Demo02Reader {
    public static void main(String[] args) throws IOException {
        // 1.创建FileReader对象，构造方法中绑定要读取的数据
        FileReader fr = new FileReader("day20-code\\src\\com\\bingai\\day20\\demo01\\c.txt");

        //2.使用FileReader对象中的方法read读取文件

        //int read()  读取单个字符。
//        int len = 0;
//        while ((len = fr.read()) != -1) {
//            System.out.print((char) len);
//        }

        //int read(char[] cbuf) 将字符读入数组。
        char[] chars = new char[1024];//存储读取到的多个字符
        int len = 0;
        while((len = fr.read(chars)) != -1){

            System.out.println(new String(chars,0,len));//使用String构造方法
        }

        //3.释放资源
        fr.close();
    }

}
