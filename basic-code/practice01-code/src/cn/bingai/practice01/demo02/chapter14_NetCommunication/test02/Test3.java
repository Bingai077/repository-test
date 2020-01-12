package cn.bingai.practice01.demo02.chapter14_NetCommunication.test02;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bingai
 * @create 2019-11-13 10:07
 */
public class Test3 {

    /*
        文件上传分析
            1. 【客户端】输入流，从硬盘读取文件数据到程序中。
            2. 【客户端】输出流，写出文件数据到服务端。
            3. 【服务端】输入流，读取文件数据到服务端程序。
            4. 【服务端】输出流，写出文件数据到服务器硬盘中
     */

    @Test
    public void client() {
        System.out.println("客户端开始上传文件");
        BufferedInputStream bis = null;
        Socket socket = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("D:\\Java学习相关\\0课件笔记源码资料\\4_文档资料\\桌面壁纸\\1代\\6.jpg"));

            socket = new Socket("127.0.0.1", 8888);
            bos = new BufferedOutputStream(socket.getOutputStream());

            //读写
            byte[] by = new byte[1024];
            int len;
            while ((len = bis.read(by)) != -1) {
                bos.write(by, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("文件上传完毕");


    }


    @Test
    public void server() throws IOException {

        System.out.println("服务器启动...");
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            Socket socket = serverSocket.accept();

            new Thread(() -> {

                try {
                    BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter14_NetCommunication\\test02\\jpgFile\\" + System.currentTimeMillis() + ".jpg"));
                    byte[] by = new byte[1024];
                    int len;
                    while ((len = bis.read(by)) != -1) {
                        bos.write(by, 0, len);
                        bos.flush();
                    }


                    bos.close();
                    bis.close();
                    socket.close();
                    //serverSocket.close();
                    System.out.println("文件保存成功");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();

        }


    }


}


