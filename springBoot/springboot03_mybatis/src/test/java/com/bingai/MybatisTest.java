package com.bingai;

import com.bingai.domain.User;
import com.bingai.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author bingai
 * @create 2020-01-03 18:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot03MybatisApplication.class)
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.queryUserList();
        System.out.println(users);
    }

}
