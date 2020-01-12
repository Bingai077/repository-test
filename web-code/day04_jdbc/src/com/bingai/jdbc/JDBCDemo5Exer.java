package com.bingai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建一张表
 * @author bingai
 * @create 2019-11-19 21:02
 */
public class JDBCDemo5Exer {
    public static void main(String[] args)  {

        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "CREATE table student (id int , name VARCHAR(20))";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
            stat = conn.createStatement();
            int count = stat.executeUpdate(sql);
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
