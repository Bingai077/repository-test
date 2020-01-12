package com.bingai.dao;

import com.bingai.domain.Account;

import java.util.List;

/**账户的持久层接口
 * @author bingai
 * @create 2019-12-21 0:44
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return 如果有唯一的结果就返回，如果没有结果就返回null
     *         如果结果集超出一个就抛异常
     */
    Account findAccountByName(String accountName);
}
