package com.xuecheng.rabbitmq.mq;

import com.rabbitmq.client.Channel;
import com.xuecheng.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author bingai
 * @create 2020-02-11 18:29
 */
@Component
public class ReceiveHandler {

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void send_email(String msg, Message message, Channel channel){

        System.out.println("receive message is:" + msg);

    }
}
