package com.bingai.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-11-28 17:21
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        ServletContext对象获取
            1. 通过request对象获取
                request.getServletContext();
            2. 通过HttpServlet获取
                this.getServletContext();
        */
        ServletContext context1 = request.getServletContext();

        ServletContext context2 = this.getServletContext();

        System.out.println(context1);
        System.out.println(context2);
        System.out.println(context1 == context2);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
