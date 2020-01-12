package com.bingai.jdbc;

import java.sql.*;

/**
 * 创建一张表
 * @author bingai
 * @create 2019-11-19 21:02
 */
public class JDBCDemo6 {
    public static void main(String[] args)  {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs =null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","root");
            //3.定义sql
            String sql = "SELECT * FROM account";
            //4.获取执行sql的对象
            stat = conn.createStatement();
            //5.执行sql
            rs = stat.executeQuery(sql);

            //6.处理结果
            //6.1 让游标向下移一行
            rs.next();
            //6.2 获取数据
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double balance = rs.getDouble(3);

            System.out.println(id + "---" + name + "---" + balance);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
