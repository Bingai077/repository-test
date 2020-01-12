package com.bingai.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**Servlet快速入门
 * @author bingai
 * @create 2019-11-26 21:56
 */
public class ServletDemo1 implements Servlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    //提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello ,servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
