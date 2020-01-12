package com.bingai.test;

import com.bingai.dao.AccountDao;
import com.bingai.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author bingai
 * @create 2019-12-25 17:49
 */
public class TestMyBatis {

    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {

        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }

        //关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {

        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);

        Account account = new Account();
        account.setName("王五");
        account.setMoney(400.0);
        //保存
        dao.saveAccount(account);

        //提交事务
        session.commit();

        //关闭资源
        session.close();
        in.close();
    }
}
