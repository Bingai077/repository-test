package com.bingai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bingai
 * @create 2019-12-25 9:23
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor() {

        System.out.println("testInterceptor执行了。。。。。");

        return "success";
    }
}
