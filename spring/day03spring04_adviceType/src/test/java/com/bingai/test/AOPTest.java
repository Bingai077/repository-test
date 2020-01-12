package com.bingai.test;

import com.bingai.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bingai
 * @create 2019-12-21 23:16
 */
public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        as.saveAccount();

    }
}
