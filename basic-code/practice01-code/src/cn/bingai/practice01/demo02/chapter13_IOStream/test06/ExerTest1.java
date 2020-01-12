package cn.bingai.practice01.demo02.chapter13_IOStream.test06;

import org.junit.Test;

import java.io.*;

/**
 * @author bingai
 * @create 2019-11-12 10:32
 */
public class ExerTest1 {
    /*
    分别使用节点流： FileInputStream、 FileOutputStream和缓冲流：
    BufferedInputStream、 BufferedOutputStream实现文本文件/图片/视频文件的
    复制。并比较二者在数据复制方面的效率

     */
    @Test
    public void test(){

        long start = System.currentTimeMillis();
        File srcFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test06\\1.txt");
        File destFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test06\\1-1.txt");
        //copyPictureIO(srcFile,destFile);
        copyPictureBufferedIO(srcFile,destFile);
        long end = System.currentTimeMillis();
        System.out.println("复制时间为：" + (end - start) + "毫秒");//7,3//1,0

    }

    private void copyPictureIO(File srcFile, File destFile){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] by = new byte[1024];
            int len;
            while((len = fis.read(by)) != -1){
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

    private void copyPictureBufferedIO(File srcFile, File destFile) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(destFile));

            byte[] by = new byte[1024];
            int len;
            while((len = bis.read(by)) != -1){
                bos.write(by,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }





}
