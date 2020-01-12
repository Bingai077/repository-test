package com.bingai.test;

import com.bingai.dao.IUserDao;
import com.bingai.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.nio.cs.US_ASCII;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author bingai
 * @create 2019-12-19 23:07
 */
public class UserTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;


    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("=====每个用户的信息======");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(53);
        System.out.println(user);

        User user1 = userDao.findById(53);
        System.out.println(user1);

        System.out.println(user == user1);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }



}
