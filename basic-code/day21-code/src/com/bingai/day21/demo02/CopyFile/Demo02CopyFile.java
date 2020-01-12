package com.bingai.day21.demo02.CopyFile;

import java.io.*;

/*
    文件复制的练习：一读一写(使用缓冲流)

    明确：
        数据源：day19-code\src\com\bingai\day19\demo01\File\1.jpg
        数据目的地：day20-code\src\com\bingai\day20\demo03

    文件复制的步骤：
        1.创建字节缓冲输入流对象，构造方法中传递字节输入流
        2.创建字节缓冲输出流对象，构造方法中传递字节输出流
        3.使用字节缓冲输入流对象中的read方法，读取文件
        4.使用字节缓冲输出流中的方法write，把读取的数据写入到内部缓冲区
        5.释放资源（会先把缓冲区的数据，刷新到文件中）

    文件字节数：483,207 字节
     一次读取一个字节：19毫秒
     使用数组缓冲区：  2毫秒



 */
public class Demo02CopyFile {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        //1.创建字节缓冲输入流对象，构造方法中传递字节输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\1.jpg"));
        //2.创建字节缓冲输出流对象，构造方法中传递字节输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day20-code\\src\\com\\bingai\\day20\\demo03\\1.jpg"));
        //3.使用字节缓冲输入流对象中的read方法，读取文件
        //一次读取一个字节，写入一个字节的方式
//        int len = 0;
//        while((len = bis.read()) != -1){
//            bos.write(len);
//        }

        //3.使用字节缓冲输入流对象中的read方法，读取文件
        //使用数组缓冲读取多个字节，写入多个字节的方式
        byte[] bytes = new byte[1024];//创建byte类型数组
        int len = 0;//每次读取的有效字节个数
        while ((len = bis.read(bytes)) != -1) {
            //4.使用字节缓冲输出流中的方法write，把读取的数据写入到内部缓冲区
            bos.write(bytes, 0, len);//写入，从0开始到读取的字节
        }


        //5.释放资源(先关闭写的，后关闭读的；如果写完了，肯定必须读取完毕了)
        bos.close();
        bis.close();

        long end = System.currentTimeMillis();

        System.out.println("复制文件共耗时：" + (end - start) +"毫秒");


    }

}
