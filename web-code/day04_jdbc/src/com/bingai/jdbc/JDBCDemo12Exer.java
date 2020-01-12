package com.bingai.jdbc;

import com.bingai.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 事务操作
 *
 * @author bingai
 * @create 2019-11-19 21:02
 */

public class JDBCDemo12Exer {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);



            //2.定义sql
            //2.1张三 - 500
            String sql1 = "update account set balance = balance - ? where id = ?";
            //2.2李四 + 500
            String sql2 = "update account set balance = balance + ? where id = ?";
            //3.获取执行sql的对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //4.设置参数
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 1);
            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 2);
            //5.执行sql
            pstmt1.executeUpdate();
            //手动制造异常
            int i = 3 / 0;
            pstmt2.executeUpdate();

            //提交事务
            conn.commit();





        } catch (Exception e) {

            //事务回滚
            try {
                if(conn != null){
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


            e.printStackTrace();
        } finally {
            if (pstmt1 != null) {
                try {
                    pstmt1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt2 != null) {
                try {
                    pstmt2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
