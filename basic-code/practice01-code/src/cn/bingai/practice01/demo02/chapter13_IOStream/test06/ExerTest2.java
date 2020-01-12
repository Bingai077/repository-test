package cn.bingai.practice01.demo02.chapter13_IOStream.test06;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-11-12 11:05
 */
public class ExerTest2 {

    /*
        实现图片加密操作
     */
    @Test
    public void test() {
        File srcFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test06\\1.txt");
        File destFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test06\\1-secret.txt");
        File destFile1 = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test06\\1-decrypt.txt");

        secretPicture(srcFile,destFile);

        secretPicture(destFile,destFile1);
    }




    private void secretPicture(File srcFile, File destFile) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] by = new byte[1024];
            int len;
            while ((len = fis.read(by)) != -1) {

                //加密
                for (int i = 0; i < by.length; i++) {
                    by[i] ^= 5;
                }

                fos.write(by, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}