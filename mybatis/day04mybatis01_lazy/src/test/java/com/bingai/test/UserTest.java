package com.bingai.test;

import com.bingai.domain.User;
import com.bingai.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bingai
 * @create 2019-12-18 11:40
 * 测试mybatis的crud操作
 */
public class UserTest {

    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before //用于在测试方法之前执行
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);

    }

    @After //用于在测试方法之后执行
    public void destory() throws IOException {

        //提交事务
        //sqlSession.commit();

        //6.释放资源
        sqlSession.close();
        is.close();
    }


    //测试查询所有
    @Test
    public void testFindAll() {

        //执行查询所有方法
        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println("====每个用户的信息====");
//            System.out.println(user);
//            System.out.println(user.getAccounts());
//
//        }


    }


    //测试查询一个
    @Test
    public void testFindOne() {

        //5.执行查询一个方法
        User user = userDao.findById(46);
        System.out.println(user);
    }








}
