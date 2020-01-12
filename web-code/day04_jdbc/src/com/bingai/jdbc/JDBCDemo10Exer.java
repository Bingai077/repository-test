package com.bingai.jdbc;

import com.bingai.domain.Emp;
import com.bingai.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 1.通过键盘录入用户名和密码
 2.判断用户是否登录成功
    select *  from user where username = "" and passsword = "";
    如果这个sql有查询结果，则成功，反之，则失败

 分析：创建数据库表user

 *
 * @author bingai
 * @create 2019-11-19 21:02
 */

public class JDBCDemo10Exer {

    public static void main(String[] args) {
        //1.键盘录入，接收用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        sc.close();

        //2.调用方法
        boolean flag = new JDBCDemo10Exer().login(username, password);

        //System.out.println(flag);
        //3.判断结果，输出不同语句
        if(flag){
            System.out.println("登录成功!");
        }else{
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 登录方法
     */
    public boolean login(String username,String password){
        if(username == null || password == null){
            return false;
        }
        //连接数据库判断是否登录成功
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "select * from user where username = '" + username + "' and password = '" + password +"'";
            System.out.println(sql);
            //3.获取执行sql的对象
            stmt = conn.createStatement();
            //4.执行查询
            rs = stmt.executeQuery(sql);
            //5.判断结果集
//        if(rs.next()){
//            return true;
//        }else{
//            return false;
//        }
            //System.out.println(rs.next());
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            JDBCUtils.close(rs,stmt,conn);
        }


        return false;
    }


}
