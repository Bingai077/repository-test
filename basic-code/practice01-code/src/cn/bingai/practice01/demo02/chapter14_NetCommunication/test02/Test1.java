package cn.bingai.practice01.demo02.chapter14_NetCommunication.test02;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bingai
 * @create 2019-11-13 9:52
 */
public class Test1 {
    /*
        客户端向服务器发送数据
        服务器向客户端回写数据
     */
    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            os = socket.getOutputStream();

            //发
            os.write("你好，服务器！".getBytes());

            socket.shutdownOutput();

            is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while((len = is.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is != null){
                try {
                    is.close();
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
    public void server(){

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            //收，读写
            byte[] bytes = new byte[1024];
            int len;
            while((len = is.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }

            //发
            os = socket.getOutputStream();
            os.write("收到，谢谢你！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(os != null){
                try {
                    os.close();
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
