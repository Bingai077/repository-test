package com.bingai.day20.demo05.Writer;

import java.io.FileWriter;
import java.io.IOException;

/*
    字符输出流写数据的其他方法：
        void write(char[] cbuf) 写入字符数组。
        void write(char[] cbuf, int off, int len) 写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        void write(String str) 写入字符串。
        void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
 */
public class Demo03Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("day20-code\\src\\com\\bingai\\day20\\demo05\\f.txt");
        // void write(char[] cbuf) 写入字符数组。
        char[] chars = {'a','b','c','d','e'};
        fw.write(chars);//abcde

        //void write(char[] cbuf, int off, int len) 写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        fw.write(chars,0,2);

        //void write(String str) 写入字符串。
        fw.write("斌改");

        //void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
        fw.write("滨河街关键是大货车",0,3);


        fw.close();





    }
}
