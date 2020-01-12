package com.bingai.dao.impl;

import com.bingai.dao.IUserDao;
import com.bingai.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-17 23:18
 */
public class UserDaoImpl implements IUserDao{

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        //1.使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2.使用session执行查询方法
        List<User> users = session.selectList("com.bingai.dao.IUserDao.findAll");

        //3.返回查询结果
        return users;
    }


}
