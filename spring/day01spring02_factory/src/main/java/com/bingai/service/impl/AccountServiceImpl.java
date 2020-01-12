package com.bingai.service.impl;

import com.bingai.dao.IAccountDao;
import com.bingai.factory.BeanFactory;
import com.bingai.service.IAccountService;

/**账户的业务层实现类
 * @author bingai
 * @create 2019-12-20 9:35
 */
public class AccountServiceImpl implements IAccountService{

    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    //private int i = 1;

    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
