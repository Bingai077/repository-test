package com.bingai.controller;

import com.bingai.domain.User;
import com.bingai.utils.StringToDateConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author bingai
 * @create 2019-12-23 20:00
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes("msg")//把msg=张三存入session域
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了");
        System.out.println(body);
        return "success";
    }


    /**
     * PathVaribale注解
     * @return
     */
    @RequestMapping(value = "/testPathVaribale/{sid}")
    public String testPathVaribale(@PathVariable(name = "sid") String id){
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }


    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "accept") String header){
        System.out.println("执行了");
        System.out.println(header);
        return "success";
    }


    /**
     * 获得cookie的值
     * @param
     * @return
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了");
        System.out.println(cookieValue);
        return "success";
    }


    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了");
        System.out.println(user);
        return "success";
    }


    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了。。。");
        //通过用户名查数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
    }



    /**
     * 该方法会先执行
     */
   /* @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了。。。");
        //通过用户名查数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }
*/


    /**
     * @SessionAttribute
     * @return
     */
    @RequestMapping(value = "/testSessionAttribute")
    public String testSessionAttribute(Model model){
        System.out.println("testSessionAttribute.....");
        //底层会存储到request域对象中
        model.addAttribute("msg","张三");
        return "success";
    }

    /**
     * 从session域中取值
     * @param modelmap
     * @return
     */
    @RequestMapping(value = "/getSessionAttribute")
    public String getSessionAttribute(ModelMap modelmap){
        System.out.println("getSessionAttribute.....");
        //底层会存储到request域对象中
        Object msg = modelmap.get("msg");
        System.out.println(msg);
        return "success";
    }


    /**
     * 清除session域中的值
     * @param status
     * @return
     */
    @RequestMapping(value = "/delSessionAttribute")
    public String delSessionAttribute(SessionStatus status){
        System.out.println("delSessionAttribute.....");
        status.setComplete();
        return "success";
    }



}

