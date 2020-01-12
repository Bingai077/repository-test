package com.bingai.test;

import com.bingai.domain.Account;
import com.bingai.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**使用juint单元测试，测试配置
 * @author bingai
 * @create 2019-12-21 9:17
 */
public class AccountServiceTest {

    @Test
    public void testFindAll(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);

    }

    @Test
    public void testSave(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345.000);
        as.saveAccount(account);

    }

    @Test
    public void testUpdate(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456.000);
        as.updateAccount(account);

    }

    @Test
    public void testDelete(){
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        as.deleteAccount(4);

    }

}
