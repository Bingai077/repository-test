package com.bingai.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-11-27 10:34
 */
//【特别注意：资源名称有/】
@WebServlet("/demo2")
public class ServletDemo2 extends GenericServlet {


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo2...............");
    }
}
