package cn.bingai.practice01.demo02.chapter14_NetCommunication.test1_Internet;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**

 UDP协议的网络编程


 * @author bingai
 * @create 2019-11-11 21:33
 */
public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP方式发送的导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,8888);

        socket.send(packet);

        socket.close();


    }

    //接收端
    @Test
    public void receiver() throws IOException {

        DatagramSocket socket = new DatagramSocket(8888);

        byte[] by = new byte[1024];
        DatagramPacket packet = new DatagramPacket(by, 0, by.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();



    }

}
