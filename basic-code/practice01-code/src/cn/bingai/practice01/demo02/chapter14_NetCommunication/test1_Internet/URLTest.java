package cn.bingai.practice01.demo02.chapter14_NetCommunication.test1_Internet;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 URL网络编程：
 1.URL：统一资源定位符，对应着互联网的某一资源地址
 2.格式：
    http://localhost:8080/example/beauty.jpg?username=Tom
    协议   主机名    端口号     资源地址       参数列表

 * @author bingai
 * @create 2019-11-11 21:50
 */
public class URLTest {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://nba.stats.qq.com/player/?id=4563");

            //public String getProtocol( ) 获取该URL的协议名
            System.out.println(url.getProtocol());//https

            //public String getHost( ) 获取该URL的主机名
            System.out.println(url.getHost());//nba.stats.qq.com

            //public String getPort( ) 获取该URL的端口号
            System.out.println(url.getPort());//-1

            //public String getPath( ) 获取该URL的文件路径
            System.out.println(url.getHost());//nba.stats.qq.com

            //public String getFile( ) 获取该URL的文件名
            System.out.println(url.getFile());///player/?id=4563

            //public String getQuery( ) 获取该URL的查询名
            System.out.println(url.getQuery());//id=4563



        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
