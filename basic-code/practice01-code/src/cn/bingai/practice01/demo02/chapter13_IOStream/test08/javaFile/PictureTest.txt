package cn.bingai.practice01.demo02.chapter13_IOStream.test02_IOStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 实现图片加密解密操作
 * @author bingai
 * @create 2019-11-09 12:36
 */
public class PictureTest {

    //图片加密
    @Test
    public void test1() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\1.jpg");
            fos = new FileOutputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\1-secret.jpg");

            byte[] by = new byte[1024];
            int len ;
            while((len = fis.read(by)) != -1){
                //字节数据进行修改
                //错误的
    //            for(byte b : by){
    //                b = (byte)(b ^ 5);
    //            }

                //正确的
                for (int i = 0; i < len; i++) {
                    by[i] = (byte)(by[i] ^ 5);
                }

                fos.write(by,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //图片解密
    @Test
    public void test2() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\1-secret.jpg");
            fos = new FileOutputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\1-1.jpg");

            byte[] by = new byte[1024];
            int len ;
            while((len = fis.read(by)) != -1){
                //字节数据进行修改
                //错误的
                //            for(byte b : by){
                //                b = (byte)(b ^ 5);
                //            }

                //正确的
                for (int i = 0; i < len; i++) {
                    by[i] = (byte)(by[i] ^ 5);
                }

                fos.write(by,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
