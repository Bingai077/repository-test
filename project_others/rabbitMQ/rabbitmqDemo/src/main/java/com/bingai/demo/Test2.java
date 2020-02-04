package com.bingai.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bingai
 * @create 2020-01-22 13:31
 */
public class Test2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-rabbitmq-consumer.xml");
    }
}
