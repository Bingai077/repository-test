package com.bingai.jdbc;

import com.bingai.domain.Emp;
import com.bingai.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回
 * 1.定义Emp类
 * 2.定义方法public List<Emp> findAll(){}
 * 3.实现方法 select * from emp;
 *
 * @author bingai
 * @create 2019-11-19 21:02
 */

public class JDBCDemo9Exer {

    public static void main(String[] args) {
        List<Emp> list = new JDBCDemo9Exer().findAll1();

        list.forEach(System.out::println);

        System.out.println(list.size());
    }


    /*
        查询所有Emp对象,演示JDBC工具类
     */
    public List<Emp> findAll1() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;

        try {
//            //1.注册驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            //2.获取连接
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");

            conn = JDBCUtils.getConnection();


            //3.定义sql
            String sql = "select * from emp";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Emp emp = null;
            list = new ArrayList<>();
            while (rs.next()) {
                //获取数据
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getInt("bonus");
                int dept_id = rs.getInt("dept_id");

                //创建emp对象,并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                //装载集合
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.close(rs,stmt,conn);


//            //7.释放资源
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//
//                }
//            }
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }



        }


        return list;
    }

}
