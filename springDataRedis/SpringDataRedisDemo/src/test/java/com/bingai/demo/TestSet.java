package com.bingai.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @author bingai
 * @create 2020-01-18 13:26
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class TestSet {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存值
     */
    @Test
    public void setValue(){
        redisTemplate.boundSetOps("nameSet").add("曹操");
        redisTemplate.boundSetOps("nameSet").add("刘备");
        redisTemplate.boundSetOps("nameSet").add("孙权");
    }

    /**
     * 取值
     */
    @Test
    public void getValue(){
        Set nameSet = redisTemplate.boundSetOps("nameSet").members();
        System.out.println(nameSet);
    }

    /**
     * 删值其中一个值
     */
    @Test
    public void deleteValue(){
        redisTemplate.boundSetOps("nameSet").remove("孙权");
    }


    /**
     * 删值
     */
    @Test
    public void delete(){
        redisTemplate.delete("nameSet");
    }

}
