package com.bingai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**控制器
 * @author bingai
 * @create 2019-12-23 15:05
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(value = "/testResquestMapping",params = {"username=hehehe"},headers = {"Accept"})
    public String testResquestMapping(){
        System.out.println("测试ResquestMapping注解。。。");
        return "success";
    }
}
