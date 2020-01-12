package cn.bingai.practice01.demo02.chapter14_NetCommunication.test01;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bingai
 * @create 2019-11-12 23:10
 */
public class Test2 {
    /*
        2.客户端给服务端发送文本， 服务端会将文本转成大写在返回给客户端。
     */

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedReader br = null;
        InputStream is = null;
        BufferedReader br1 = null;
        BufferedWriter bw = null;
        try {
            socket = new Socket("127.0.0.1", 6666);
            os = socket.getOutputStream();
            br = new BufferedReader(new FileReader("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter14_NetCommunication\\test01\\1.txt"));

            //发送
            is = socket.getInputStream();
            bw = new BufferedWriter(new FileWriter("D:\\IdeaProjects\\basic-code\\practice01-code\\src\\cn\\bingai\\practice01\\demo02\\chapter14_NetCommunication\\test01\\1-client.txt"));

            String str;
            while ((str = br.readLine()) != null) {
                //System.out.println(str);
                os.write(str.getBytes());
                os.write("\n".getBytes());
//                bw.write(str);
//                bw.newLine();
            }

            socket.shutdownOutput();
            br1 = new BufferedReader(new InputStreamReader(is));

            //接收
            String str1;
            while((str1 = br1.readLine()) != null){
                //System.out.println(str1);
                bw.write(str1);
                bw.newLine();
            }

//            byte[] by = new byte[1024];
//            int len;
//            while ((len = is.read(by)) != -1) {
//                str1 = new String(by, 0, len);
//                bw.write(str1);
//                bw.newLine();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br1 != null){
                try {
                    br1.close();
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
            if(br != null){
                try {
                    br.close();
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
        BufferedReader br = null;
        OutputStream os = null;
        BufferedWriter bw = null;
        try {
            serverSocket = new ServerSocket(6666);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            //转成大写
            os = socket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(os));

            String str = null;

            while((str = br.readLine()) != null){
                //System.out.println(str);
                String str1 = str.toUpperCase();

                //System.out.println(str1);
                bw.write(str1);
                bw.newLine();
            }


//            byte[] by = new byte[1024];
//            int len;
//            while ((len = is.read(by)) != -1) {
//                str = new String(by, 0, len);
//                String str1 = str.toUpperCase() ;
//
//                System.out.println(str1);
//                os.write(str1.getBytes());
//                os.write("\n".getBytes());
//
//            }


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
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
