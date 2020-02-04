package com.bingai.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author bingai
 * @create 2020-01-18 13:26
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class TestValue {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存值
     */
    @Test
    public void setValue(){
        redisTemplate.boundValueOps("name").set("bingai");
        redisTemplate.boundValueOps("name").expire(10, TimeUnit.SECONDS);
    }

    /**
     * 取值
     */
    @Test
    public void getValue(){
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    /**
     * 删值
     */
    @Test
    public void deleteValue(){
        redisTemplate.delete("name");
    }





}
