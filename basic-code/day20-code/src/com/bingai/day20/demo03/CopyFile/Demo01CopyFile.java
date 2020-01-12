package com.bingai.day20.demo03.CopyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    文件复制的练习：一读一写

    明确：
        数据源：day19-code\src\com\bingai\day19\demo01\File\1.jpg
        数据目的地：day20-code\src\com\bingai\day20\demo03

    文件复制的步骤：
        1.创建一个字节输入流对象，构造方法中绑定要读取的数据源
        2.创建一个字节输出流对象，构造方法中绑定要写入的目的地
        3.使用字节输入流中的方法read读取文件
        4.使用直接输出流中的方法write，把读取的字节写入到目的地的文件中
        5.释放资源
 */
public class Demo01CopyFile {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        //1.创建一个字节输入流对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\1.jpg");
        //2.创建一个字节输出流对象，构造方法中绑定要写入的目的地
        FileOutputStream fos = new FileOutputStream("day20-code\\src\\com\\bingai\\day20\\demo03\\1.jpg");
        //3.使用字节输入流中的方法read读取文件
        //一次读取一个字节，写入一个字节的方式
//        int len = 0;
//        while((len = fis.read()) != -1){
//            //4.使用直接输出流中的方法write，把读取的字节写入到目的地的文件中
//            fos.write(len);
//        }

        //3.使用字节输入流中的方法read读取文件
        //使用数组缓冲读取多个字节，写入多个字节的方式
        byte[] bytes = new byte[1024];//创建byte类型数组
        int len = 0;//每次读取的有效字节个数
        while ((len = fis.read(bytes)) != -1) {
            //4.使用直接输出流中的方法write，把读取的字节写入到目的地的文件中
            fos.write(bytes, 0, len);//写入，从0开始到读取的字节
        }


        //5.释放资源(先关闭写的，后关闭读的；如果写完了，肯定必须读取完毕了)
        fos.close();
        fis.close();

        long end = System.currentTimeMillis();

        System.out.println("复制文件共耗时：" + (end - start) +"毫秒");


    }

}
