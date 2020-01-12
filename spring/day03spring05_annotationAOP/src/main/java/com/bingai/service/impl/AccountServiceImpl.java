package com.bingai.service.impl;

import com.bingai.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author bingai
 * @create 2019-12-21 22:43
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService{


    public void saveAccount() {
        System.out.println("执行了保存");
        //int i= 1/0;
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新" + i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
