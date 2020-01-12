package com.bingai.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-12-03 15:28
 */
//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        System.out.println("filterDemo2执行了");
        //放行
        chain.doFilter(req, resp);
        //对response对象的响应消息增强
        System.out.println("filterDemo2回来了");

    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
