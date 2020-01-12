package com.bingai.service.impl;

import com.bingai.dao.IAccountDao;
import com.bingai.domain.Account;
import com.bingai.service.IAccountService;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-21 0:42
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
