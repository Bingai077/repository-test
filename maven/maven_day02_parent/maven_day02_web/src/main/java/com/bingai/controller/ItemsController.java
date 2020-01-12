package com.bingai.controller;

import com.bingai.domain.Items;
import com.bingai.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bingai
 * @create 2019-12-27 23:15
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/findDetail")
    public String findDetail(Model model) {
        Items items = itemsService.findById(1);
        model.addAttribute("item",items);
        return "itemDetail";

    }

}

