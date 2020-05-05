package com.xuecheng.test.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.TimeoutException;

/**rabbitmq的入门程序
 * @author bingai
 * @create 2020-02-11 12:47
 */
public class Producer01 {

    //对列
    private static final String QUEUE = "helloworld";

    public static void main(String[] args) {
        //通过连接工厂创建新的连接和mq建立连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);//端口
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        //设置虚拟机,一个mq的服务可以设置多个虚拟机，每一个虚拟机相当于一个独立的mq
        connectionFactory.setVirtualHost("/");
        //建立新连接
        Connection connection = null;
        Channel channel = null;
        try {
            //建立新连接
            connection = connectionFactory.newConnection();
            //创建会话通道,所有生产者和mq服务都在channel中完成
            channel = connection.createChannel();
            //声明队列:如果对列在mq中没有，则需要创建
            //参数：String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
            /**
             * 参数明细：
             * 1.queue：对列名称
             * 2.durable：是否持久化，如果持久化，mq重启后队列还在
             * 3.exclusive：是否独占连接，队列只允许在该连接中访问，如果连接关闭，队列自动删除,如果将此参数设置为true可用于临时队列的创建
             * 4.autoDelete：是否自动删除，将此参数和exclusion设置为true，可以实现临时队列
             * 5.arguments：参数，可以设置一个队列的扩展参数，比如：可设置存活时间
             */

            channel.queueDeclare(QUEUE,true,false,false,null);

            //发送消息
            //参数：String exchange, String routingKey, boolean mandatory, boolean immediate, BasicProperties props, byte[] body
            /**
             * 参数明细：
             * 1.exchange：交换机，如果不指定将使用mq默认的交换机,使用""
             * 2.routingKey：路由key，交换机根据路由key来将消息转发到指定的队列，如果使用默认交换机，routingKey设置为队列的名称             * 3.mandatory：
             * 4.props：消息的属性
             * 5.body：消息内容
             */
            String message = "Hello world 斌改！！";
            channel.basicPublish("",QUEUE,null,message.getBytes());
            System.out.println("send to mq"+message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            //关闭；连接
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }

}
