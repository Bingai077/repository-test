package com.bingai.dao.impl;

import com.bingai.dao.IUserDao;
import com.bingai.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-18 18:14
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现列表查询
        List<User> users = session.selectList("com.bingai.dao.IUserDao.findAll");//参数就是能获取配置信息的key
        //3.释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现保存
        session.insert("com.bingai.dao.IUserDao.saveUser",user);
        //3.提交事务
        session.commit();
        //释放资源
        session.close();


    }

    public void updateUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现更新
        session.insert("com.bingai.dao.IUserDao.updateUser",user);
        //3.提交事务
        session.commit();
        //释放资源
        session.close();
    }

    public void deleteUser(Integer userId) {
//1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现更新
        session.insert("com.bingai.dao.IUserDao.deleteUser",userId);
        //3.提交事务
        session.commit();
        //释放资源
        session.close();
    }

    public User findById(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现列表查询
        User user = session.selectOne("com.bingai.dao.IUserDao.findById",userId);
        session.close();
        return user;
    }

    public List<User> findByName(String name) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现列表查询
        List<User> users = session.selectList("com.bingai.dao.IUserDao.findByName",name);//参数就是能获取配置信息的key
        //3.释放资源
        session.close();
        return users;
    }


    public int findTotal() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现列表查询
        Integer count = session.selectOne("com.bingai.dao.IUserDao.findTotal");
        session.close();
        return count;
    }
}
