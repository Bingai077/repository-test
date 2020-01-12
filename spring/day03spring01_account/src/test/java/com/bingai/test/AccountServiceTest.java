package com.bingai.test;

import com.bingai.domain.Account;
import com.bingai.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**使用juint单元测试，测试配置
 * @author bingai
 * @create 2019-12-21 9:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService as;

    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100.00);
    }

}
