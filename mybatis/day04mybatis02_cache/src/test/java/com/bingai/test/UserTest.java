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
    private SqlSessionFactory factory;

    @Before //用于在测试方法之前执行
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(is);
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


    //测试一级缓存
    @Test
    public void testFirstLevelCache() {

        User user1 = userDao.findById(41);
        System.out.println(user1);

//        sqlSession.close();
//        //再次获取sqlSession对象
//        sqlSession = factory.openSession();

        sqlSession.clearCache();//此方法也可以清空缓存
        userDao = sqlSession.getMapper(IUserDao.class);


        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);

    }

    //测试缓存同步
    @Test
    public void testClearCache() {
        //1.根据id查询用户
        User user1 = userDao.findById(41);
        System.out.println(user1);

        //2.更新用户信息
        user1.setUsername("update user clear cache");
        user1.setAddress("宁波市鄞州区");
        user1.setSex("男");

        userDao.updateUser(user1);

//        sqlSession.clearCache();//此方法也可以清空缓存
//        userDao = sqlSession.getMapper(IUserDao.class);

        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);


    }









}
