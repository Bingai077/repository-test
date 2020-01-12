package com.bingai.day20.demo01.OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
    一次写多个字节的方法：
        public void write(byte[] b) ：将 b.length字节从指定的字节数组写入此输出流。
        public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
 */
public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        //创建FileOutStream对象，构造方法中绑定要写入数据的目的地
        FileOutputStream fos = new FileOutputStream(new File("day20-code\\src\\com\\bingai\\day20\\demo01\\b.txt"));
        //调用FileOutputStream对象中的方法write，把数据写入到文件中
        //在文件中显示100，需要写3个字节
        fos.write(49);
        fos.write(48);
        fos.write(48);

        /*
            public void write(byte[] b) ：将 b.length字节从指定的字节数组写入此输出流。
            一次写多个字节：
                如果写的第一个字节是正数(0-127)，那么显示的时候会查询AsCII表
                如果写的第一个字节是负数，那么第一个字节和第二个字节，两个字节组成一个中文显示，查询系统默认码表(GBK)
         */
        byte[] byes = {65, 66, 67, 68, 69};//ABCDE
        //byte[] byes = {-65, -66, -67, 68, 69};//100烤紻E
        fos.write(byes);


        /*
            public void write(byte[] b, int off, int len) ：把字节数组的一部分写到文件中
                int off：数组的开始索引
                int len：写几个字节
         */
        fos.write(byes,1,2);//BC

        /*
            写入字符串的方法:可以使用String类中的方法把字符串转换为字节数组
             byte[] getBytes()  把字符串转换为字节数组
         */
        byte[] bytes = "你好".getBytes();
        System.out.println(Arrays.toString(bytes));//[-28, -67, -96, -27, -91, -67]
        fos.write(bytes);


        //释放资源
        fos.close();
    }
}
