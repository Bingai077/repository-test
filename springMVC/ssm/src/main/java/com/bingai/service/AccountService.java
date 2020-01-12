package com.bingai.service;

import com.bingai.domain.Account;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-25 12:13
 */
public interface AccountService {

    //查询所有
    public List<Account> findAll();

    //保存账户信息
    public void saveAccount(Account account);
}
