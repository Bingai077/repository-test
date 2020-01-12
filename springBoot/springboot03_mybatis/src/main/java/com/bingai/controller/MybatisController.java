package com.bingai.controller;

import com.bingai.domain.User;
import com.bingai.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author bingai
 * @create 2020-01-03 17:59
 */
@Controller
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();

        return  users;
    }

}
