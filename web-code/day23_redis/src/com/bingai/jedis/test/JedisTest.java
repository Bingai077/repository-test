package com.bingai.jedis.test;

import com.bingai.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.sql.JDBCType;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis测试类
 *
 * @author bingai
 * @create 2019-12-05 11:29
 */
public class JedisTest {
    /*
        快速入门
     */
    @Test
    public void test1() {
        //1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作

        jedis.set("username", "zhangsan");

        //3.关闭连接
        jedis.close();
    }

    /*
        Jedis操作各种redis中的数据结构
        1) 字符串类型 string
            set
            get
        2) 哈希类型 hash ： map格式
            hset
            hget
            hgetAll
        3) 列表类型 list ： linkedlist格式。支持重复元素
            lpush/rpush
            lpop/rpop
            lrange start end :范围获取
        4) 集合类型 set ： 不允许重复元素
            sadd
            smenbers:获取所有元素

        5) 有序集合类型 sortedset：不允许重复元素，且元素有顺序
            zadd
     */

    /*
    1) 字符串类型 string
            set
            get
            serex():有时限的
     */
    @Test
    public void test2() {
        //1.获取连接,如果使用空参构造，默认值："localhost",6379端口
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        //存储
        jedis.set("username", "zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期时间的key value
        jedis.setex("activecode", 20, "hehe");//将activecode:hehe 键值对存入redis，并且20秒后自动删除该键值对


        //3.关闭连接
        jedis.close();
    }


    /*
     2) 哈希类型 hash ： map格式
            hset
            hget
            hgetAll
     */
    @Test
    public void test3() {
        //1.获取连接,如果使用空参构造，默认值："localhost",6379端口
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        //存储hash
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "female");

        String name = jedis.hget("user", "name");
        System.out.println(name);

        //获取hash的所有map的数据
        Map<String, String> user = jedis.hgetAll("user");

        //keyset
        Set<String> keySet = user.keySet();
        for (String s : keySet) {
            String value = user.get(s);
            System.out.println(s + ":" + value);
        }

        //3.关闭连接
        jedis.close();
    }

    /*
        3) 列表类型 list ： linkedlist格式。支持重复元素
            lpush/rpush
            lpop/rpop
            lrange start end :范围获取
     */
    @Test
    public void test4() {
        //1.获取连接,如果使用空参构造，默认值："localhost",6379端口
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        //list存储
        jedis.lpush("mylist","a","b","c");//从左边存
        jedis.rpush("mylist","a","b","c");//从右边存

        //list范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //list弹出
        String element1 = jedis.lpop("mylist");//c
        System.out.println(element1);
        String element2 = jedis.rpop("mylist");//c
        System.out.println(element2);

        List<String> mylist1 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist1);

        //3.关闭连接
        jedis.close();
    }


    /*
        4) 集合类型 set ： 不允许重复元素
            sadd
            smenbers:获取所有元素
     */
    @Test
    public void test5() {
        //1.获取连接,如果使用空参构造，默认值："localhost",6379端口
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        //set 存储
        jedis.sadd("myset","java","php","c++");

        //set获取
        Set<String> myset = jedis.smembers("myset");

        System.out.println(myset);

        //3.关闭连接
        jedis.close();
    }

    /*
        5) 有序集合类型 sortedset：不允许重复元素，且元素有顺序
            zadd
     */
    @Test
    public void test6() {
        //1.获取连接,如果使用空参构造，默认值："localhost",6379端口
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        //存储
        jedis.zadd("mysortedset",30,"关羽");
        jedis.zadd("mysortedset",55,"刘备");
        jedis.zadd("mysortedset",80,"张飞");

        //获取
        Set<String> set = jedis.zrange("mysortedset", 0, -1);
        System.out.println(set);

        //3.关闭连接
        jedis.close();

    }


    /*
        jedis连接池使用
     */
    @Test
    public void test7() {
        //0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        //1.创建jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);

        //2.获取连接
        Jedis jedis = jedisPool.getResource();

        //3.使用
        jedis.set("hehe","hihi");

        //4.关闭，归还到连接池中
        jedis.close();

    }


    /**
     * jedis连接池的工具类
     */
    @Test
    public void test8() {

        //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        //3.使用
        jedis.set("hello","world");

        //4.关闭，归还到连接池中
        jedis.close();

    }




}
