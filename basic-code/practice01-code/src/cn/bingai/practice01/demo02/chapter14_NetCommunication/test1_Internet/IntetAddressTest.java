package cn.bingai.practice01.demo02.chapter14_NetCommunication.test1_Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 一、网络编程中的两个主要问题：
 如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 找到主机后如何可靠高效地进行数据传输

 二、网络编程中的两个要素
 1.对应问题一:IP和端口号
 2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理层+数据链路层）

 三、通信要素一：IP和端口号

 1.IP：唯一的标识Internet上的计算机（通信实体）
 2.在java中使用InetAddress类代表IP
 3.IP分类：IPv4和IPv6：万维网 和 局域网
 4.域名：www.baidu.com  www.mi.com  www.sina.com www.jd.com
        www.vip.com
 5.本地回路地址：127.0.0.1 对应着：localhost

 6.如何实例化InetAddress：两个方法：getByName(String host)/getLocalHost()
       两个常用方法：getHostName()/getHostAddress()

 7.端口号： 标识正在计算机上运行的进程（程序）
    要求：不同的进程有不同的端口号
    范围：被规定为一个 16 位的整数 0~65535。

 8. 端口号与IP地址的组合得出一个网络套接字： Socket。
 *
 * @author bingai
 * @create 2019-11-11 17:50
 */
public class IntetAddressTest {

    public static void main(String[] args) {

        try {
            //File file = new File("hello.txt");
            InetAddress inet1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            //获取本机ip地址
            System.out.println(InetAddress.getByName("localhost"));//localhost/127.0.0.1
            System.out.println(InetAddress.getLocalHost());//DESKTOP-3DV5VPB/192.168.0.10

            //getHostName()
            System.out.println(inet2.getHostName());//www.baidu.com

            //getHostAddress()
            System.out.println(inet2.getHostAddress());//180.101.49.12

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
