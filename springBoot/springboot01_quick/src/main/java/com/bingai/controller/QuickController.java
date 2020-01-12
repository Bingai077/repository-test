package com.bingai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bingai
 * @create 2020-01-03 10:36
 */
@Controller
public class QuickController {

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "hello springboot";
    }


}
