package com.bingai.dao;

import com.bingai.domain.Account;

/**账户的持久层接口
 * @author bingai
 * @create 2019-12-22 16:54
 */
public interface IAccountDao {
    /**
     *根据Id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

}
