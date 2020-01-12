package com.bingai.day20.demo06.trycatch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    JDK7的新特性：
        在try的后边可以增加一个(),在括号中可以定义对象
        那么这个对象的作用域就在try中有效
        try中的代码执行完毕，会自动把流对象释放，不用写finally了
    格式：
        try(定义流对象;定义流对象...){
            可能会产生异常的代码
        }catch(异常类变量 变量名){
            异常的处理逻辑
        }
 */
public class Demo02JDK7 {
    public static void main(String[] args) {

        //自动关闭流对象
        try(//1.创建一个字节输入流对象，构造方法中绑定要读取的数据源
            FileInputStream fis = new FileInputStream("day19-code\\src\\com\\bingai\\day19\\demo01\\File\\1.jpg");
            //2.创建一个字节输出流对象，构造方法中绑定要写入的目的地
            FileOutputStream fos = new FileOutputStream("day20-code\\src\\com\\bingai\\day20\\demo03\\1.jpg");){

            //3.使用字节输入流中的方法read读取文件
            byte[] bytes = new byte[1024];//创建byte类型数组
            int len = 0;//每次读取的有效字节个数
            while ((len = fis.read(bytes)) != -1) {
                //4.使用直接输出流中的方法write，把读取的字节写入到目的地的文件中
                fos.write(bytes, 0, len);//写入，从0开始到读取的字节
            }


        }catch (IOException e){
            System.out.println(e);
        }


    }
}
