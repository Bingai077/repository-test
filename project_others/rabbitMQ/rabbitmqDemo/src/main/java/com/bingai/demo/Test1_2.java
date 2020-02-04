package com.bingai.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bingai
 * @create 2020-01-22 13:01
 */
public class Test1_2 {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-rabbitmq-producer.xml");
        RabbitTemplate rabbitTemplate = (RabbitTemplate) context.getBean("rabbitTemplate");

        rabbitTemplate.convertAndSend("exchange.fanout_test","","分列模式测试");

        ((ClassPathXmlApplicationContext)context).close();

    }
}
