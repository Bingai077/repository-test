package com.bingai.demo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**消息监听类
 * @author bingai
 * @create 2020-01-22 13:09
 */
public class MessageConsumer1 implements MessageListener {
    public void onMessage(Message message) {

        System.out.println("MessageConsumer1");
        System.out.println("接收到消息："+new String(message.getBody()));
    }
}
