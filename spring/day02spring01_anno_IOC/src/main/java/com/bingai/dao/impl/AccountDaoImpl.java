package com.bingai.dao.impl;

import com.bingai.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**账户的持久层实现类
 * @author bingai
 * @create 2019-12-20 9:39
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {


    public void saveAccount() {
        System.out.println("保存了账户111111111111111");
    }
}
