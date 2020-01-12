package com.bingai.oracle;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import org.junit.Test;

import java.sql.*;

/**
 * @author bingai
 * @create 2019-12-27 18:30
 */
public class OracleDemo {

    @Test
    public void javaCallOracle() throws Exception {
        //加载数据库驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //得到Connection
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.245.10:1521:orcl", "bingai", "bingai");
        //得到预编译的Statement对象
        PreparedStatement pstm = connection.prepareStatement("select * from emp where empno = ?");
        //给参数赋值
        pstm.setObject(1,7788);
        //执行数据库查询操作
        ResultSet rs = pstm.executeQuery();
        //输出结果
        while(rs.next()){
            System.out.println(rs.getString("ename"));
        }
        //释放资源
        rs.close();
        pstm.close();
        connection.close();

    }


    /**
     * java调用存储过程
     *
     * {?= call <procedure-name>[(<arg1>,<arg2>, ...)]} 调用存储函数使用
        {call <procedure-name>[(<arg1>,<arg2>, ...)]}   调用存储过程使用

     *
     * @throws Exception
     */
    @Test
    public void javaCallProcedure() throws Exception {
        //加载数据库驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //得到Connection
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.245.10:1521:orcl", "bingai", "bingai");
        //得到预编译的Statement对象
        CallableStatement pstm = connection.prepareCall(" {call p_yearsal(?,?)} ");
        //给参数赋值
        pstm.setObject(1,7788);
        pstm.registerOutParameter(2, OracleTypes.NUMBER);
        //执行数据库查询操作
        pstm.execute();
        //输出结果[第二个参数]
        System.out.println(pstm.getObject(2));
        pstm.close();
        connection.close();

    }


    /**
     * java调用存储函数
     * @throws Exception
     */
    @Test
    public void javaCallFunction() throws Exception {
        //加载数据库驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //得到Connection
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.245.10:1521:orcl", "bingai", "bingai");
        //得到预编译的Statement对象
        CallableStatement pstm = connection.prepareCall(" {? = call f_yearsal(?)} ");
        //给参数赋值
        pstm.setObject(2,7788);
        pstm.registerOutParameter(1, OracleTypes.NUMBER);
        //执行数据库查询操作
        pstm.execute();
        //输出结果[第1个参数]
        System.out.println(pstm.getObject(1));
        pstm.close();
        connection.close();

    }

}
