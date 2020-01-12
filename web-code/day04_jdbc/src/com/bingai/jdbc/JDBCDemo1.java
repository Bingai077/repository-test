package com.bingai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**JDBC快速入门
 * @author bingai
 * @create 2019-11-19 19:24
 */
/*
    五大对象：
    1.DiverManager：驱动管理对象
        功能：1.注册驱动：告诉程序该使用哪个数据库驱动jar
                static void registerDriver​(Driver driver) 使用 DriverManager注册给定的驱动程序。
                写代码使用：Class.forName("com.mysql.jdbc.Driver");
                通过查看源码发现：在com.mysql.jdbc.Driver类中存在静态代码块
                    static {
                        try {
                            java.sql.DriverManager.registerDriver(new Driver());//注册驱动
                        } catch (SQLException E) {
                            throw new RuntimeException("Can't register driver!");
                        }
                    }
                【注意】：mysql5之后的驱动jar包可以省略注册驱动的步骤
             2.获取数据库连接
                 方法：static Connection getConnection​(String url, String user, String password)
                 参数：
                    url：指定连接的路径
                        语法：jdbc:mysql://ip地址(域名):端口号
                        例子：jdbc:mysql://localhost:3306/db3
                        细节：如果连接的是本机mysql服务器，并且mysql服务器默认端口是3306，
                             则url可以简写为：jdbc:mysql:///db3
                    user：用户名
                    password：密码

    2.Connection：数据库连接对象
        功能：1.获取执行sql的对象
                Statement createStatement​()
                PreparedStatement prepareStatement​(String sql)
             2.管理事务：
                开启事务：void setAutoCommit​(boolean autoCommit) ：调用该方法设置参数为false，即开启事务
                提交事务：void commit​()
                回滚事务：void rollback​()

    3.Statement：执行sql的对象
            1.执行sql
                1.boolean execute​(String sql) ：可以执行任意的sql
                2.int executeUpdate​(String sql) ：执行【DML】（insert、update、delete）语句、【DDL】（create、alter、drop）语句
                        返回值：影响的行数,可以通过影响的行数判断DML语句是否执行成功，返回值>0,则执行成功，反之，则失败
                3.ResultSet executeQuery​(String sql) ：执行【DQL】（select）语句


    4.ResultSet：结果集对象，封装查询结果
            1.boolean next():游标向下移动一行,判断当前行是否是最后一行末尾（是否有数据），如果是，则返回false，不是，则返回true
            2.getXxx(参数):获取数据
                 Xxx：代表数据类型  如：int getInt(), String getString()
                 参数：
                    1.int:代表列的【编号】,从1开始。如：getString(1)
                    2.String:代表列的名称。 如：getDouble("balance")
            【注意】
                使用步骤：
                    1.游标向下移动一行
                    2.判断是否有数据
                    3.获取数据

    5.PreparedStatement：执行sql的对象
        1.DQL注入问题：在拼接sql时，有一些特殊关键字参与字符串的拼接。会造成安全性问题
            1.输入用户名随便，输入密码：a' or 'a' = 'a'
            2.sql：SELECT * FROM USER WHERE username ='sjjhjfsuhd' AND PASSWORD = 'a' OR 'a' = 'a';

        2.解决sql注入问题：使用PreparedStatement对象解决

        3.预编译的SQL：参数使用?作为占位符
        4.步骤：
            1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
            2. 注册驱动
            3. 获取数据库连接对象 Connection
            4. 定义sql
                * 注意：sql的参数使用？作为占位符。 如：select * from user where username = ? and password = ?;
            5. 获取执行sql语句的对象 PreparedStatement Connection.prepareStatement(String sql)
            6. 给？赋值：
                * 方法： setXxx(参数1,参数2)
                * 参数1：？的位置编号 从1 开始
                * 参数2：？的值
            7. 执行sql，接受返回结果，不需要传递sql语句
            8. 处理结果
            9. 释放资源
        5.【注意】：后期都使用PreparaedStatement来增删改查的所有操作
            1.可防止SQL注入
            2.效率更高

JDBC控制事务
    1.事务：一个包含多个步骤的业务操作。如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败。
    2.操作：
        1.开启事务
        2.提交事务
        3.回滚事务
    3.使用connection对象来管理事务
        开启事务：void setAutoCommit​(boolean autoCommit) ：调用该方法设置参数为false，即开启事务
            *在执行sql之前开启事务
        提交事务：void commit​()
            *在所有sql都执行完提交事务
        回滚事务：void rollback​()
            *在catch()中回滚事务



 */
public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
           //复制jar包到项目的libs下，然后右键选择 add as Library
        //2.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
        //4.定义sql语句
        //String sql = "update account set balance = 2000 where id = 1";
        String sql = "update account set balance = 1500 ";
        //5.获取执行sql的对象
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();

    }

}
