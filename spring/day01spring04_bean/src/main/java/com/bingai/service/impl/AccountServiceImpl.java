package com.bingai.service.impl;

import com.bingai.service.IAccountService;

/**账户的业务层实现类
 * @author bingai
 * @create 2019-12-20 9:35
 */
public class AccountServiceImpl implements IAccountService{

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了。。。");
    }

    public void init() {
        System.out.println("对象初始化了。。。");
    }

    public void destory() {
        System.out.println("对象销毁了。。。");
    }

}
