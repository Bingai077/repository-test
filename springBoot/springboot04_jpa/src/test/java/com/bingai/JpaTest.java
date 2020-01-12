package com.bingai;

import com.bingai.domain.User;
import com.bingai.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author bingai
 * @create 2020-01-03 18:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot04JpaApplication.class)
public class JpaTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        List<User> list = userRepository.findAll();
        System.out.println(list);
    }

}
