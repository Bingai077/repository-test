package com.bingai.test;

import com.bingai.dao.IAccountDao;
import com.bingai.dao.IUserDao;
import com.bingai.domain.Account;
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
import java.util.List;

/**
 * @author bingai
 * @create 2019-12-19 23:07
 */
public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;


    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("=====每个账户的信息======");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }



}
