package com.bingai.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bingai.service.HelloService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bingai
 * @create 2020-01-08 12:30
 */
@Service(interfaceClass = HelloService.class,protocol = "dubbo")  //发布为服务必须使用dubbo提供的注解
@Transactional
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "8088 hello," + name;
    }
}
