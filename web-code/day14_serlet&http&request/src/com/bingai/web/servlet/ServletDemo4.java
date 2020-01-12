package com.bingai.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**Servlet路径配置
 * @author bingai
 * @create 2019-11-27 10:34
 */
@WebServlet({"/demo4","/d4","/dd4","/ddd4"})
//@WebServlet("/user/demo4")
//@WebServlet("/user/*")
//@WebServlet("/*")
//@WebServlet("*.do")//自定义拓展名
public class ServletDemo4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4.........");
        System.out.println(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...............");
    }
}
