package com.bingai.ui;

import com.bingai.factory.BeanFactory;
import com.bingai.service.IAccountService;

/**模拟一个表现层，用于调用业务层
 * @author bingai
 * @create 2019-12-20 9:41
 */
public class Client {
    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}

