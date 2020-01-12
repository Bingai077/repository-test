package com.bingai.day21.demo03.ReverseStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    java.io.InputStreamReader extends Reader
    InputStreamReader：InputStreamReader 是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。（解码：把看不懂的变成能看懂的）

    继承自父类的共性成员方法：
        int read()  读取单个字符。
        int read(char[] cbuf) 将字符读入数组。
        void close()   关闭该流并释放与之关联的所有资源。

    构造方法：
        InputStreamReader(InputStream in)  创建一个使用默认字符集的 InputStreamReader。
        InputStreamReader(InputStream in, String charsetName)  创建使用指定字符集的 InputStreamReader。
        构造方法的参数：
            InputStream in：字节输入流，用来读取文件中保存的字节
            String charsetName：指定的编码表名称，不区分大小写，可以是utf-8/UTF-8,GBK/gbk,...不指定默认使用UFT-8

     【使用步骤】(重点)
         1.创建InputStreamReader对象，构造方法中传递字节输出流和指定的编码表名称
         2.使用InputStreamReader对象中的方法read，读取文件
         3.释放资源

      注意事项：
         构造方法中指定的编码表名称要和文件的编码相同，否则会发生乱码

 */
public class Demo03InputStreamReader {
    public static void main(String[] args) throws IOException {
        //read_utf_8();
        reaf_gbk();
    }

    private static void reaf_gbk() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day21-code\\\\src\\\\com\\\\bingai\\\\day21\\\\demo01\\\\GBK.txt"),"gbk");
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("day21-code\\\\src\\\\com\\\\bingai\\\\day21\\\\demo01\\\\GBK.txt"),"uft-8");
        //2.使用InputStreamReader对象中的方法read，读取文件
        int len = 0;
        while((len = isr.read()) != -1){
            System.out.print((char)len);
        }

        //3.释放资源
        isr.close();
    }

    private static void read_utf_8() throws IOException {
        /*
            使用InputStreamReader读取UTF-8格式的文件
         */
        //1.创建InputStreamReader对象，构造方法中传递字节输出流和指定的编码表名称
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("day21-code\\\\src\\\\com\\\\bingai\\\\day21\\\\demo01\\\\utf-8.txt"),"utf-8");
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day21-code\\\\src\\\\com\\\\bingai\\\\day21\\\\demo01\\\\utf-8.txt"));
        //2.使用InputStreamReader对象中的方法read，读取文件
        int len = 0;
        while((len = isr.read()) != -1){
            System.out.print((char)len);
        }

        //3.释放资源
        isr.close();

    }
}
