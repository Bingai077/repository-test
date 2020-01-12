package com.bingai.test;

import com.bingai.domain.QueryVo;
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
import java.util.Date;
import java.util.List;

/**
 * @author bingai
 * @create 2019-12-18 11:40
 * 测试mybatis的crud操作
 */
public class MybatisTest {

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
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);

    }

    @After //用于在测试方法之后执行
    public void destory() throws IOException {

        //提交事务
        sqlSession.commit();

        //6.释放资源
        sqlSession.close();
        is.close();
    }


    //测试查询所有
    @Test
    public void testFindAll() {

        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }


    }


    //测试保存操作
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybatais last insertid");
        user.setAddress("北京市西城区");
        user.setSex("男");
        user.setBirthday(new Date());

        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后："+user);

    }


    //测试更新操作
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(51);
        user.setUsername("mybatais Update user");
        user.setAddress("北京市西城区");
        user.setSex("女");
        user.setBirthday(new Date());

        //5.执行保存方法
        userDao.updateUser(user);

    }


    //测试删除操作
    @Test
    public void testDeleteUser() {

        //5.执行删除方法
        userDao.deleteUser(48);

    }


    //测试查询一个
    @Test
    public void testFindOne() {

        //5.执行查询一个方法
        User user = userDao.findById(46);
        System.out.println(user);
    }

    //测试模糊查询操作
    @Test
    public void testFindByName() {

        //5.执行模糊查询方法
        List<User> users = userDao.findByName("%王%");
       // List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }


    //测试查询总记录条数
    @Test
    public void testFindTotal() {

        //5.执行查询总用户数方法
        int count= userDao.findTotal();
            System.out.println("总用户数为：" + count);

    }


    //测试使用QueryVo作为查询条件
    @Test
    public void testFindUserByVo() {

        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);

        //5.执行模糊查询方法
        List<User> users = userDao.findUserByVo(vo);
        // List<User> users = userDao.findByName("王");
        for (User u : users) {
            System.out.println(u);
        }

    }





}
