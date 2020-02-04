package com.zahuopu.service.impl;

import com.zahuopu.service.goods.CategoryService;
import com.zahuopu.service.goods.SkuService;
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
    private CategoryService categoryService;

    @Autowired
    private SkuService skuService;

    public void afterPropertiesSet() throws Exception {
        System.out.println("=======缓存预热=======");
        categoryService.saveCategoryTreeToRedis();
        skuService.saveAllPriceToRedis();
    }



}
