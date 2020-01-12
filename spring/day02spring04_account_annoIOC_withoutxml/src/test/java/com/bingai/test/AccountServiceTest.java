package com.bingai.test;

import com.bingai.domain.Account;
import com.bingai.service.IAccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**使用juint单元测试，测试配置
 * @author bingai
 * @create 2019-12-21 9:17
 *
 * 当测试方法执行时，没有IOC容器，就算写了@Autowied，也无法实现注入
 *
 * spring整合junit的配置
 *  1.导入jar包
 *  2.使用juint提供的注解把原有的main方法替换了，替换成spring提供
 *      @Runwith
 *  3.告知spring的运行器，spring的ioc创建是基于xml还是注解的，并且说明位置
 *      @ContextConfiguration
 *                  Locations:指定xml文件的位置，加上classpath关键字表示在类路径下
 *                  classes：指定注解类所在的位置
 *
 *      当我们使用spring 5.x版本的时候，要求junit的jar包必须在4.12以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
//    private ApplicationContext ac;
    private IAccountService as;

//    @Before
//    public void init(){
//        //1.获取容器
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2.得到业务层对象
//        as = ac.getBean("accountService", IAccountService.class);
//    }

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
