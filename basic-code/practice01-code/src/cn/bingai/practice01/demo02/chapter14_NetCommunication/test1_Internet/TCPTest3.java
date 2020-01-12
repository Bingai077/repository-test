package cn.bingai.practice01.demo02.chapter14_NetCommunication.test1_Internet;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**实现TCP网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接。
 * @author bingai
 * @create 2019-11-11 20:48
 */
public class TCPTest3 {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
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


            socket.shutdownOutput();

            //5.接收来自服务器端的数据，打印到控制台
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int len1;
            while ((len1 = is.read(bytes)) != -1){
                baos.write(bytes,0,len1);
            }

            System.out.println(baos.toString());
            System.out.println("收到了来自于" + socket.getInetAddress().getHostAddress() + "的数据");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        OutputStream os = null;

        try {
            //1.
            serverSocket = new ServerSocket(8888);
            //2.
            socket = serverSocket.accept();
            //3.
            is = socket.getInputStream();
            //4.
            fos = new FileOutputStream("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter14_NetCommunication\\test1_Internet\\2-server.jpg");

            //5.
            byte[] by = new byte[1024];
            int len;
            while((len = is.read(by)) != -1){
                fos.write(by,0,len);
            }


            System.out.println("图片传输完成");
            //6.服务器端给予客户端反馈
            os = socket.getOutputStream();
            os.write("图片上传成功！".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
