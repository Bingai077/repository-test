package com.bingai.test;

import com.bingai.dao.IUserDao;
import com.bingai.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author bingai
 * @create 2019-12-20 0:36
 */
public class SecondLevelCatchTest {

    private InputStream in;
    private SqlSessionFactory factory;



    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);

    }

    @After
    public void destory() throws IOException {

        in.close();
    }


    @Test
    public void testFindOne(){
        SqlSession session = factory.openSession();
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = userDao.findById(53);
        System.out.println(user);

        session.close();


        SqlSession session1 = factory.openSession();
        IUserDao userDao1 = session1.getMapper(IUserDao.class);
        User user1 = userDao1.findById(53);
        System.out.println(user1);

        System.out.println(user == user1);
    }

}
