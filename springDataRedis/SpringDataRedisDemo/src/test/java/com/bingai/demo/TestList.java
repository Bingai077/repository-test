package com.bingai.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * @author bingai
 * @create 2020-01-18 13:26
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class TestList {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存值，右压栈（后添加的对象排后面）
     */
    @Test
    public void setValue1(){
        redisTemplate.boundListOps("nameList1").rightPush("刘备");
        redisTemplate.boundListOps("nameList1").rightPush("关羽");
        redisTemplate.boundListOps("nameList1").rightPush("张飞");
    }

    /**
     * 存值，左压栈（后添加的对象排前面）
     */
    @Test
    public void setValue2(){
        redisTemplate.boundListOps("nameList2").leftPush("刘备");
        redisTemplate.boundListOps("nameList2").leftPush("关羽");
        redisTemplate.boundListOps("nameList2").leftPush("张飞");
    }

    /**
     * 取值（右压栈）
     */
    @Test
    public void getValue1(){
        //range(开始索引，查询个数) 查询个数为-1不限制个数
        List nameList1 = redisTemplate.boundListOps("nameList1").range(0, -1);
        System.out.println(nameList1);
    }

    /**
     * 取值（左压栈）
     */
    @Test
    public void getValue2(){
        //range(开始索引，查询个数) 查询个数为-1不限制个数
        List nameList2 = redisTemplate.boundListOps("nameList2").range(0, -1);
        System.out.println(nameList2);
    }

    /**
     *按索引查询某个位置元素，索引从0开始
     */
    @Test
    public void testSearchByIndex(){
        String name =(String) redisTemplate.boundListOps("nameList2").index(0);
        System.out.println(name);
    }



    /**
     * 删值其中一个元素
     */
    @Test
    public void deleteValue(){
        redisTemplate.boundListOps("nameList2").remove(2,"关羽");//删除元素的个数
    }


    /**
     * 全部删除
     */
    @Test
    public void delete(){
        redisTemplate.delete("nameSet");
    }
    
}
