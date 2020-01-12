package com.bingai.service;

/**账户的业务层接口
 * @author bingai
 * @create 2019-12-21 22:40
 */
public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟删除账户
     * @return
     */
    int deleteAccount();
}
