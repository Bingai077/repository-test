package com.zahuopu.service.impl;

import com.zahuopu.service.business.AdService;
import com.zahuopu.service.goods.CategoryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author bingai
 * @create 2020-01-18 21:33
 */
@Component
public class Init implements InitializingBean {

    @Autowired
    private AdService adService;

    public void afterPropertiesSet() throws Exception {
        System.out.println("=======缓存预热=======");
        adService.saveAllAdToRedies();
    }


}
