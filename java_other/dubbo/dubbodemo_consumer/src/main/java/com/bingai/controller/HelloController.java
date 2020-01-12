package com.bingai.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bingai.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bingai
 * @create 2020-01-08 17:08
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Reference //查找服务
    private HelloService helloService;

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(String name){
        return helloService.sayHello(name);
    }


}
