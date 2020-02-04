package com.bingai.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @author bingai
 * @create 2020-01-18 13:26
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class TestZset {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存值
     */
    @Test
    public void setValue(){
        redisTemplate.boundZSetOps("namezset").add("曹操",100000);
        redisTemplate.boundZSetOps("namezset").add("孙权",0);
        redisTemplate.boundZSetOps("namezset").add("刘备",1000);
    }

    /**
     * 取值(由低到高排)
     */
    @Test
    public void getValue(){
        Set namezset = redisTemplate.boundZSetOps("namezset").range(0, -1);
        System.out.println(namezset);
    }

    /**
     * 取值(由高到低排)，土豪榜（前十）
     */
    @Test
    public void getValue1(){
        Set namezset = redisTemplate.boundZSetOps("namezset").reverseRange(0, 10);
        System.out.println(namezset);
    }


    /**
     * 增加分数
     */
    @Test
    public void addScore(){
        redisTemplate.boundZSetOps("namezset").incrementScore("孙权",2000);
        redisTemplate.boundZSetOps("namezset").incrementScore("刘备",100);
    }

    /**
     * 查询值和分数
     */
    @Test
    public void getValueAndScore(){
        Set<ZSetOperations.TypedTuple> namezset = redisTemplate.boundZSetOps("namezset").reverseRangeWithScores(0, 9);
        for (ZSetOperations.TypedTuple typedTuple : namezset) {
            System.out.println("姓名：" + typedTuple.getValue());
            System.out.println("分数：" + typedTuple.getScore());
        }
        
    }



}
