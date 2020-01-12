package com.bingai.day21.demo01.BufferedStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    java.io.BufferedInputStream extends InputStream
    BufferedInputStream:字节缓冲输入流

    继承自父类的成员方法：
        public void close() ：关闭此输入流并释放与此流相关联的任何系统资源。
        public abstract int read() ： 从输入流读取数据的下一个字节。
        public int read(byte[] b) ： 从输入流中读取一些字节数，并将它们存储到字节数组 b中

    构造方法：
    BufferedInputStream(InputStream in) 创建一个 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
    BufferedInputStream(InputStream in, int size) 创建具有指定缓冲区大小的 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
        参数：
            InputStream in：字节输入流
                我们可以传递FileInputStream，缓冲流会给FileInputStream增加一个缓冲区，提高FileInputStream的读取效率
            int size:指定缓冲流内部缓冲区的大小，不指定默认

    【使用步骤】（重点）：
        1.创建FileInputputStream对象，构造方法中绑定要读取的数据源
        2.创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream对象的效率
        3.使用BufferedInputStream对象中的方法read，读取文件
        4.释放资源



 */
public class Demo02BufferendInputStream {
    public static void main(String[] args) throws IOException {
        //1.创建FileInputputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("day21-code\\src\\com\\bingai\\day21\\demo01\\a.txt");
        //2.创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream对象的效率
        BufferedInputStream bis = new BufferedInputStream(fis);
        //3.使用BufferedInputStream对象中的方法read，读取文件

        //int read() ： 从输入流读取数据的下一个字节。
        /*int len = 0;//记录每次读取的字节
        while((len = bis.read()) != -1){
            System.out.println(len);
        }*/

        //public int read(byte[] b) ： 从输入流中读取一些字节数，并将它们存储到字节数组 b中
        byte[] bytes = new byte[1024];//存取每次读取的数据
        int len = 0;////记录每次读取的有效字节个数
        while((len = bis.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));//把数组转化为字符串
        }

        //4.释放资源
        bis.close();
    }
}
