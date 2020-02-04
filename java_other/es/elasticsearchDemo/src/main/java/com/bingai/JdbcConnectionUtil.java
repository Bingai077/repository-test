package com.bingai;

import java.sql.*;

public class JdbcConnectionUtil {

    public static Connection getConnection(String URL,String DRIVERCLASSNAME,String USERNAME,String PASSWORD) {
        Connection conn = null;
        try {
            Class.forName(DRIVERCLASSNAME);//加载驱动
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void destroy(Connection conn, Statement sm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (sm != null) {
            try {
                sm.close();
                sm = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
     }


}
