package com.bingai.test;

import com.bingai.dao.UserDao;
import com.bingai.domain.User;
import org.junit.Test;

/**
 * @author bingai
 * @create 2019-11-27 18:49
 */
public class UserDaoTest {

    @Test
    public void testLogin(){

        User loginuser = new User();
        loginuser.setUsername("superbaby");
        loginuser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }

}
