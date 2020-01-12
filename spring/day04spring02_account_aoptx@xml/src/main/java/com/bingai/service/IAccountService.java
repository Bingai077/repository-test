package com.bingai.service;

import com.bingai.domain.Account;

import java.util.List;

/**账户的业务层接口
 * @author bingai
 * @create 2019-12-21 0:35
 */
public interface IAccountService {

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
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money   转账金额
     */
    void transfer(String sourceName, String targetName, Double money);

    void test();//只是连接点，但不是切入点，因为没有被增强

}
