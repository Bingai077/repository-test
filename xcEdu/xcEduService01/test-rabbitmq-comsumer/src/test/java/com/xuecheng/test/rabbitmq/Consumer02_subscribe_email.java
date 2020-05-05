package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author bingai
 * @create 2020-02-11 15:09
 */
public class Consumer02_subscribe_email {

    //队列名称
    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String EXCHANGE_FANOUT_INFORM="exchange_fanout_inform";

    public static void main(String[] args){
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
        try {
            //建立新连接
            connection = connectionFactory.newConnection();
            //创建会话通道,所有生产者和mq服务都在channel中完成
            Channel channel = connection.createChannel();
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

            channel.queueDeclare(QUEUE_INFORM_EMAIL,true,false,false,null);
            //声明一个交换机
            channel.exchangeDeclare(EXCHANGE_FANOUT_INFORM, BuiltinExchangeType.FANOUT);
            /**
             * 参数：String exchange, String type
             * 参数明细：
             * exchange：交换机名称
             * type：交换机类型
             *      fanout:对应的rabbitmq的工作模式：public/subscribe
             *      direct：对应Routing工作模式
             *      topic： 对应Topics的工作模式
             *      headers：对应headers工作模式
             */

            //进行交换机队列的绑定
            channel.queueBind(QUEUE_INFORM_EMAIL,EXCHANGE_FANOUT_INFORM,"");



            //实现消费方法
            DefaultConsumer defaultConsumer = new DefaultConsumer(channel){

                /**
                 *   当接收到消息后此方法将会被调用
                 * @param consumerTag  消费者标签，用来标识消费者的，在监听对象时设置
                 * @param envelope     信封，通过envelope
                 * @param properties   消息属性
                 * @param body         消息内容
                 * @throws IOException
                 */
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    //交换机
                    String exchange = envelope.getExchange();
                    //消息id，mq在通道中用来标识消息的id，可用于确认消息已接收
                    long deliveryTag = envelope.getDeliveryTag();
                    //消息内容
                    String message = new String(body,"utf-8");
                    System.out.println("receive message:" + message);
                }

            };

            //监听队列
            channel.basicConsume(QUEUE_INFORM_EMAIL,true,defaultConsumer);
            //接收消息
            //参数：String queue, boolean autoAck, Consumer callback
            /**
             * 1.queue：队列名称
             * 2.autoAck: 自动回复，当消费者接收到消息后告诉mq消息已接收，如果参数设置为true会自动回复，设置为false则需要编程回复
             * 3.callback: 消费方法，当消费者接收到消息要执行的方法
             */

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }

}
