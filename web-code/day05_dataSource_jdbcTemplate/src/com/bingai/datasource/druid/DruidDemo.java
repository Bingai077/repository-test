package com.bingai.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author bingai
 * @create 2019-11-20 22:21
 */
/*
5. Druid：数据库连接池实现技术，由阿里巴巴提供的
    1. 步骤：
        1. 导入jar包 druid-1.0.9.jar
        2. 定义配置文件：
            * 是properties形式的
            * 可以叫任意名称，可以放在任意目录下
    3. 加载配置文件。Properties
    4. 获取数据库连接池对象：通过工厂来来获取 DruidDataSourceFactory
    5. 获取连接：getConnection

    2. 定义工具类
        1. 定义一个类 JDBCUtils
        2. 提供静态代码块加载配置文件，初始化连接池对象
        3. 提供方法
    1. 获取连接方法：通过数据库连接池获取连接
    2. 释放资源
    3. 获取连接池的方法

 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件

        //3.加载配置文件
        Properties pro = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);

        //4.获取连接池对象流
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        //5.获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
