package com.bingai.controller;

import com.bingai.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-12-24 9:03
 */
@Controller
@RequestMapping("/user")
public class UserControlller {

    /**
     * 返回一个字符串
     *
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString方法执行了");
        //模拟从数据库中查询User对象
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setAge(20);
        //model对象
        model.addAttribute("user", user);

        return "success";
    }


    /**
     * 返回值是void
     * 请求转发是一次请求，不用编写项目名称
     *
     * @param
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了");
        //编写请求转发的程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //直接会进行响应
        response.getWriter().print("你好");

        return;

    }


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();

        System.out.println("testVoid方法执行了");

        //模拟从数据库中查询User对象
        User user = new User();
        user.setUsername("李四");
        user.setPassword("123");
        user.setAge(22);

        //把user对象存储到mv对象当中，也会把user对象存入到request对象
        mv.addObject("user",user);

        //跳转到哪个页面
        mv.setViewName("success");

        return mv;
    }


    /**
     * 请求转发和重定向：关键字方式
     * @param
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect方法执行了");

        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";

        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     * @return
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax方法执行了");
        //客户端发送ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(20);
        //做响应
        return user;

    }





}
