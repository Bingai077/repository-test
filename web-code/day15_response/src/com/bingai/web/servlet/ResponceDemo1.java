package com.bingai.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**重定向
 * @author bingai
 * @create 2019-11-28 11:27
 */
@WebServlet("/responceDemo1")
public class ResponceDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("demo1.........");

//        //访问/responseDemo1,会自动跳转到/responseDemo2资源
//        //1.设置状态码为302
//        response.setStatus(302);
//        //2.设置响应头为location
//        response.setHeader("location","/day15_response/responceDemo2");

        request.setAttribute("msg","response");

        //3.动态获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        //简单的重定向方法
        response.sendRedirect(contextPath + "/responceDemo2");
        //response.sendRedirect("https://www.baidu.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
