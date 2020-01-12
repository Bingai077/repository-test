package com.bingai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 修改account表金额
 * @author bingai
 * @create 2019-11-19 21:02
 */
public class JDBCDemo3Exer {
    public static void main(String[] args)  {
        Connection conn = null;
        Statement stat = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","root");
            //3.定义sql
            String sql = "update account set balance = 1500 where id = 3";
            //4.获取执行sql的对象
            stat = conn.createStatement();
            //5.执行sql
            int count = stat.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if(count > 0){
                System.out.println("修改成功!");
            }else{
                System.out.println("修改失败!");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            if(stat != null){
                try {
                    stat.close();
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
}
