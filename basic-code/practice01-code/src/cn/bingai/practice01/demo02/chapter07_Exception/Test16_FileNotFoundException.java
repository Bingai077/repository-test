package cn.bingai.practice01.demo02.chapter07_Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//FileNotFoundException 文件未找到
public class Test16_FileNotFoundException {
    public static void main(String[] args) {
        FileInputStream fis = null;
        File file = new File("a.txt");
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
