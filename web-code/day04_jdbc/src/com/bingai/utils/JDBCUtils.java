package com.bingai.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
    目的：简化书写
    分析：
        1.注册驱动也抽取
        2.抽取一个方法获取连接对象
            需求：不想传递参数（麻烦），还得保证工具类的通用性。
            解决：配置文件
                jdbc.properties
                    url=
                    user=
                    root=
        3.抽取一个方法释放资源


 * @author bingai
 * @create 2019-11-20 11:51
 */
//工具类的方法都是静态的
public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件的读取，只需要读取一次即可拿到这些值。使用静态代码块
     */
    static {
        //读取资源文件，获取值。

        try {
            //1.创建Properties集合类
            Properties pro = new Properties();

            //获取src路径下文件的方式---> ClassLoader 类加载器
            //动态获取配置文件路径
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            //System.out.println(path);


            //2.加载文件
            pro.load(new FileReader(path));
            //pro.load(new FileReader("D:\\IdeaProjects\\web-code\\day04_jdbc\\src\\jdbc.properties"));


            //3.获取数据，赋值,【特别注意】:取出的值需要加双引号
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");


            //4.注册驱动
            Class.forName(driver);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }


    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 释放资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




}
