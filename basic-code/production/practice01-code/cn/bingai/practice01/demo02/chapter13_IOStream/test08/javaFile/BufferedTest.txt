package cn.bingai.practice01.demo02.chapter13_IOStream.test02_IOStream;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * <p>
 * 1.缓冲流
 * BufferedInputStream：
 * BufferedOutoutStream：
 * BufferedReader：
 * BufferedWriter：
 * <p>
 * 2.作用：提高流的读取、写入速度
 * 提高读写速度的原因：内部提供了一个缓冲区
 * <p>
 * 3.处理流：就是“套接”在已有的流的基础上
 *
 * @author bingai
 * @create 2019-11-09 11:14
 */
public class BufferedTest {

    /*
        实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() {

        //1.造文件
        File srcFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\1.jpg");
        File destFile = new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\2.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //2.造流
            //2.1造文件流/节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.传输
            byte[] by = new byte[1024];
            int len;
            while ((len = bis.read(by)) != -1) {
                bos.write(by, 0, len);

                //bos.flush();//刷新缓冲区
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关流
            //要求：【先关外层，再关里面】
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时，内层流也会自动进行关闭。关于内层流的关闭，可省略
            //fos.close();
            //fis.close();
        }


    }

    @Test
    public void tsetCopyFileWithBuffered() {

        String srcPath = "D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\1.jpg";
        String destPath = "D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\2.jpg";

        long start = System.currentTimeMillis();
        copyFileWithBuffered(srcPath, destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制所用时间为：" + (end - start));

    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath, String destPath) {
        //1.造文件
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //2.造流
            //2.1造文件流/节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.传输
            byte[] by = new byte[1024];
            int len;
            while ((len = bis.read(by)) != -1) {
                bos.write(by, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    /*
        使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter() {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter13_IOStream\\test02_IOStream\\dbcp1.txt")));

            //方式一：使用char[]数组
//            char[] ch = new char[1024];
//            int len;
//            while ((len = br.read(ch)) != -1) {
//                bw.write(ch, 0, len);
//                bw.flush();
//            }

            //方式二：使用String

            String data;
            while ((data = br.readLine()) != null){
                //方法一：
                //bw.write(data + "\n");//data中不包括换行符
                //方法二：
                bw.write(data);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }




}
