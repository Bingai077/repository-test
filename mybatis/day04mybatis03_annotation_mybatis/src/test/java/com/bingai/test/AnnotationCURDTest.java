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
public class AnnotationCURDTest {
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
    public void testSave(){
        User user = new User();
        user.setUsername("mybaties annonation");
        user.setAddress("宁波市鄞州区");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(53);
        user.setAddress("宁波市江北区");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setUsername("bai");

        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteUser(67);
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(53);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        //List<User> users = userDao.findUserByName("%王%");
        List<User> users = userDao.findUserByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int totalUser = userDao.findTotalUser();
        System.out.println(totalUser);
    }



}
