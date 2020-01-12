package com.bingai.day21.demo03.ReverseStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    FileReader可以读取默认编码格式（UFT-8）的文件
    FileReader读取系统默认编码（中文GBK）会产生乱码
 */
public class Demo01FileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("day21-code\\src\\com\\bingai\\day21\\demo01\\我是GBK格式的文本.txt");
        int len = 0;
        while((len = fr.read()) !=-1 ){
            System.out.println((char)len);
        }

        fr.close();
    }
}
