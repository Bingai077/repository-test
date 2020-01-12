package com.bingai.test;

import com.bingai.domain.Account;
import com.bingai.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    private IAccountService as;

    @Test
    public void testFindAll(){
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);

    }

    @Test
    public void testSave(){
        //3.执行方法
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345.000);
        as.saveAccount(account);

    }

    @Test
    public void testUpdate(){
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456.000);
        as.updateAccount(account);

    }

    @Test
    public void testDelete(){
        //3.执行方法
        as.deleteAccount(4);

    }

}
