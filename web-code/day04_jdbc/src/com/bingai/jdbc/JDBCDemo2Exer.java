package com.bingai.jdbc;

import java.sql.*;

/**
 * account表 添加一条记录 insert 语句
 * @author bingai
 * @create 2019-11-19 20:39
 */
public class JDBCDemo2Exer {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql = "insert into account values(null,'王五',3000)";
            //3.获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
            //4.获取执行sql的对象 Statement
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);//影响的行数
            //6.处理结果
            System.out.println(count);
            if(count > 0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(stmt != null){//避免空指针异常
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn  != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
