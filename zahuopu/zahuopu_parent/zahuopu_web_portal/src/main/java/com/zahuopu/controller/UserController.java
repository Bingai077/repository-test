package com.zahuopu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zahuopu.entity.Result;
import com.zahuopu.pojo.user.User;
import com.zahuopu.service.user.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author bingai
 * @create 2020-01-22 20:57
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    /**
     * 发送短信验证码
     * @param phone
     * @return
     */
    @GetMapping("/sendSms")
    public Result sendSms(String phone){
        userService.sendSms(phone);
        return new Result();
    }


    @PostMapping("/save")
    public Result save(@RequestBody User user, String smsCode){

        //密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newpassword = encoder.encode(user.getPassword());
        user.setPassword(newpassword);

        userService.add(user,smsCode);
        return new Result();


    }

}
