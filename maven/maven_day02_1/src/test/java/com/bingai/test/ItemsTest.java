package com.bingai.test;

import com.bingai.dao.ItemsDao;
import com.bingai.domain.Items;
import com.bingai.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bingai
 * @create 2019-12-27 22:35
 */
public class ItemsTest {

    @Test
    public void findById(){
        //获取spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //dao测试
        /*//从容器中拿到所需的dao代理对象
        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
        //调用方法
        Items items = itemsDao.findById(1);
        System.out.println(items);*/

        //sercice测试
        ItemsService itemsService = ac.getBean(ItemsService.class);
        //调用方法
        Items items = itemsService.findById(1);
        System.out.println(items);

    }
}
