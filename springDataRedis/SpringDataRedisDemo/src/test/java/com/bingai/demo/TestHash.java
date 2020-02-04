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
public class TestHash {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存值
     */
    @Test
    public void setValue(){
        redisTemplate.boundHashOps("namehash").put("a","唐僧");
        redisTemplate.boundHashOps("namehash").put("b","悟空");
        redisTemplate.boundHashOps("namehash").put("c","八戒");
        redisTemplate.boundHashOps("namehash").put("d","沙僧");
    }

    /**
     * 查询所有的key
     */
    @Test
    public void getKeys(){
        Set keys = redisTemplate.boundHashOps("namehash").keys();
        System.out.println(keys);
    }

    /**
     * 查询所有的value
     */
    @Test
    public void getValues(){
        List values = redisTemplate.boundHashOps("namehash").values();
        System.out.println(values);
    }

    /**
     * 根据key查询值
     */
    @Test
    public void getValueByKey(){
        String s =(String) redisTemplate.boundHashOps("namehash").get("b");
        System.out.println(s);
    }



    /**
     * 删除
     */
    @Test
    public void deleteValueByKey(){
        redisTemplate.boundHashOps("namehash").delete("c");
    }



}
