package com.bingai.dao.impl;

import com.bingai.dao.ItemsDao;
import com.bingai.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 要想从数据库中取数据
 * 必须拥有四个属性：数据库驱动，连接数据库地址，数据库用户名称，数据库 用户密码
 *
 *
 * @author bingai
 * @create 2019-12-08 22:19
 */
public class ItemsDaoImpl implements ItemsDao {
    @Override
    public List<Items> findAll() throws Exception{
        List<Items> list = new ArrayList<Items>();
        //先获取contection对象
        Connection connection = null;
        //获取真正操作数据的对象
        PreparedStatement pst = null;
        //执行数据库查询操作
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //先获取contection对象
            connection = DriverManager.getConnection("jdbc:mysql:///maven","root", "root");
            //获取真正操作数据的对象
            pst = connection.prepareCall("select * from items");
            //执行数据库查询操作
            rs = pst.executeQuery();
            //把数据库结果集转成java的List集合

            while (rs.next()){
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                list.add(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            rs.close();
        }

        return list;
    }
}
