package com.zahuopu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zahuopu.pojo.business.Ad;
import com.zahuopu.service.business.AdService;
import com.zahuopu.service.goods.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-17 12:45
 */
@Controller
public class IndexController {

    @Reference
    private AdService adService;

    @Reference
    private CategoryService categoryService;

    @GetMapping("/index")
    public String index(Model model){

        //得到首页广告轮播图列表
        List<Ad> lbtList = adService.findByPosition("index_lb");
        model.addAttribute("lbt",lbtList);

        //分类导航
        List<Map> categoryList = categoryService.findCategoryTree();
        model.addAttribute("categoryList",categoryList);

        return "index";

    }









}
