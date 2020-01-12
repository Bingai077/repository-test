package com.bingai.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-12-03 16:04
 */
//浏览器直接请求资源时，该过滤器会被执行
//@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//只有转发访问index.jsp时，该过滤器才会被执行
//@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.FORWARD)

//以上两种都会执行
//@WebFilter(value="/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo5 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo5");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
