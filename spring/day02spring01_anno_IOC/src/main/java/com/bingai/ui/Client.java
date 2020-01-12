package com.bingai.ui;


import com.bingai.dao.IAccountDao;
import com.bingai.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 *
 * @author bingai
 * @create 2019-12-20 9:41
 */
public class Client {
    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用类：
     *      ClassPathXmlApplicationContext:可以加载类路径下的配置文件，要求配置文件必须在类路径下
     *      FileSystemXmlApplicationContext：可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *
     *      AnnotationConfigApplicationContext：用于读取注解创建容器
     *
     *核心容器的两个接口引发出的问题：
     *      ApplicationContext：   【单例对象适用】    通常采用此接口定义容器对象
     *          在构建核心容器时，创建对象采用的是立即加载的方式。只要一读配置文件马上创建配置文件的配置对象。
     *      BeanFactory：          【多例对象适用】
     *          在构建核心容器时，创建对象采用的是延迟加载的方式。什么时候根据id获取对象了，什么时候真正创建对象。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as2 = (IAccountService) ac.getBean("accountService");

//        System.out.println(as);
//
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(adao);
//        System.out.println(as == as2);
        as.saveAccount();
        ac.close();



    }
}
