package cn.bingai.practice01.demo02.chapter14_NetCommunication.test1_Internet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 实现tcp的网络编程
 例子1：客户端发送信息给服务器端，服务器端将数据显示在控制台上


 * @author bingai
 * @create 2019-11-11 19:25
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket对象，指明服务器端ip和端口号
            socket = new Socket("127.0.0.1", 6688);

            //2.获取输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据操作
            os.write("你好，我是客户端".getBytes());
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
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }


    //服务器端
    @Test
    public void server(){

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.创建服务器端ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(6688);

            //2.调用accept()表示接收来自客户端的socket
            socket = serverSocket.accept();

            //3.获取输入流
            is = socket.getInputStream();

            //不建议这样写，可能会乱码
//            byte[] by = new byte[1024];
//            int len ;
//            while ((len = is.read(by)) != -1){
//                System.out.println(new String(by,0,len));
//            }
            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();

            byte[] by = new byte[1024];
            int len ;
            while ((len = is.read(by)) != -1){
                baos.write(by,0,len);
            }
            System.out.println(baos.toString());

            System.out.println("收到了来自于" + socket.getInetAddress().getHostAddress() + "的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                try {
                    baos.close();
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
