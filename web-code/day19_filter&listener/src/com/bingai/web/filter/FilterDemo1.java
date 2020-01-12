package com.bingai.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**过滤器快速入门
 * @author bingai
 * @create 2019-12-03 15:09
 */
//@WebFilter("/*")//访问所有资源之前都会执行该过滤器
public class FilterDemo1 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("FilterDemo1被执行了");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
