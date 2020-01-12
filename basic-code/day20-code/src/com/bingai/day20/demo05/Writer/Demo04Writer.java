package com.bingai.day20.demo05.Writer;

import java.io.FileWriter;
import java.io.IOException;

/*
     续写和换行：
     续写/追加写：使用两个参数的构造方法
        FileWriter(eFile file, boolean append)
        FileWriter(String fileName, boolean append)
        参数：
               String fileName、File file：写入数据的目的地
               boolean append：续写开关
                    true：不会创建新的文件覆盖原文件，可以续写
                    false：会创建新的文件，覆盖原文件
     换行：换行符号
        window：\r\n
        linux: /n
        mac:  /r

 */
public class Demo04Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("day20-code\\src\\com\\bingai\\day20\\demo05\\g.txt",true);
        for (int i = 0; i < 10 ; i++) {
            fw.write("HelloWorld" + i + "\r\n");
        }

        fw.close();
    }

}
