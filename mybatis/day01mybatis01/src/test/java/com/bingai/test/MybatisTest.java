package com.bingai.test;


import com.bingai.dao.IUserDao;
import com.bingai.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**mybatis入门案例
 * @author bingai
 * @create 2019-12-17 20:16
 */
public class MybatisTest {

    public static void main(String[] args) throws Exception {

        //1.读取配置文件
            //【重点】：1.使用类加载器读（只能读取类路径的配置文件）
            //         2.使用ServletContext对象的getRealPath()
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
            //使用了构建者模式，build就是构建者，把对象的创建细节隐藏，使使用者直接调用方法即可拿到对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);

        //3.使用工厂生产SqlSession对象
            //使用了工厂模式，优势：解耦（降低类 之间的依赖关系）
        SqlSession session = factory.openSession();

        //4.使用SqlSession创建Dao接口的代理对象
            //代理模式：不修改源码的基础上，对已有方法增强
        IUserDao userDao = session.getMapper(IUserDao.class);

        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }

        //6.释放资源
        session.close();
        is.close();

    }

}
