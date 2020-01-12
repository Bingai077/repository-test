package com.bingai.jdbctemplate;

import com.bingai.dao.IAccountDao;
import com.bingai.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**JdbcTemplate最基本的用法
 * @author bingai
 * @create 2019-12-22 15:48
 */
public class JdbcTemplateDemo4 {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        Account account = accountDao.findAccountById(1);
        System.out.println(account);

        account.setMoney(30000.0);
        accountDao.updateAccount(account);




    }
}
