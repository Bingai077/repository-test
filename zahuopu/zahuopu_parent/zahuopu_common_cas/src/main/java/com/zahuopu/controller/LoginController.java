package com.zahuopu.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bingai
 * @create 2020-01-28 18:24
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * 获取当前用户名
     * @return
     */
    @GetMapping("/username")
    public Map username(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        System.out.println("当前登录用户："+username);
        if("anonymousUser".equals(username)){//未登录
            username="";
        }

        Map map = new HashMap();
        map.put("username",username);
        return map;
    }
}
