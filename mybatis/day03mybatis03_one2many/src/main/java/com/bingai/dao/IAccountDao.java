package com.bingai.dao;

import com.bingai.domain.Account;
import com.bingai.domain.AccountUser;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-19 11:16
 */
public interface IAccountDao {
    /**
     * 查询所有账户,同时还要获取当前账户所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     *查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();


}
