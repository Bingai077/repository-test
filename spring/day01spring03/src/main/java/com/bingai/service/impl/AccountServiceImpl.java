package com.bingai.service.impl;

import com.bingai.dao.IAccountDao;
import com.bingai.dao.impl.AccountDaoImpl;
import com.bingai.service.IAccountService;

/**账户的业务层实现类
 * @author bingai
 * @create 2019-12-20 9:35
 */
public class AccountServiceImpl implements IAccountService{

    private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
