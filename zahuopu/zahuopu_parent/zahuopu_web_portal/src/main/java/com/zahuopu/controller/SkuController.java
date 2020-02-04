package com.zahuopu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zahuopu.service.goods.SkuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bingai
 * @create 2020-01-19 0:12
 */
@RestController
@RequestMapping("/sku")
@CrossOrigin
public class SkuController {

    @Reference
    private SkuService skuService;

    @GetMapping("/price")
    public Integer price(String id){
        return skuService.findPrice(id);
    }

}
