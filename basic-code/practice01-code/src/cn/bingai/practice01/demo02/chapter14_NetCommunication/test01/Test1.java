package cn.bingai.practice01.demo02.chapter14_NetCommunication.test01;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bingai
 * @create 2019-11-12 22:57
 */
public class Test1 {

    /*
        1.服务端读取图片并发送给客户端，客户端保存图片到本地
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            socket = new Socket("127.0.0.1", 6666);
            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter14_NetCommunication\\test01\\1.jpg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1){
                os.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void server() {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            serverSocket = new ServerSocket(6666);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter14_NetCommunication\\test01\\1-server.jpg"));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                bos.write(bytes,0,len);
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
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }


}
