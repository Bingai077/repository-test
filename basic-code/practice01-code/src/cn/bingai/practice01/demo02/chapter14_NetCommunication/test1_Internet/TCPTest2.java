package cn.bingai.practice01.demo02.chapter14_NetCommunication.test1_Internet;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务端， 服务端将文件保存在本地(上传操作)
 *
 * @author bingai
 * @create 2019-11-11 20:11
 */
public class TCPTest2 {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            //1.
            socket = new Socket("127.0.0.1", 8888);
            //2.
            os = socket.getOutputStream();

            //3.
            fis = new FileInputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter14_NetCommunication\\test1_Internet\\1.jpg");
            byte[] by = new byte[1024];
            int len;
            while((len = fis.read(by)) != -1){
                //4.
                os.write(by,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.
            if(fis != null) {
                try {
                    fis.close();
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
        FileOutputStream fos = null;
        try {
            //1.
            serverSocket = new ServerSocket(8888);
            //2.
            socket = serverSocket.accept();
            //3.
            is = socket.getInputStream();
            //4.
            fos = new FileOutputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter14_NetCommunication\\test1_Internet\\1-server.jpg");

            //5.
            byte[] by = new byte[1024];
            int len;
            while((len = is.read(by)) != -1){
                fos.write(by,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.
            if(fos != null){
                try {
                    fos.close();
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
