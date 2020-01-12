package cn.bingai.practice01.demo02.chapter07_Exception;

import java.io.FileInputStream;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter07_Exception\\Test\\atguigushk.txt");
            int b;
            b = fis.read();
            while(b != -1){
                System.out.print((char)b);
                b = fis.read();
            }

            System.out.println();
        }catch (IOException e){
            System.out.println(e);
        }finally {
            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("It's OK！");
        }
    }
}
