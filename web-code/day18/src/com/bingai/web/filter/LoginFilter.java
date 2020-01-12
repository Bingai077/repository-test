package com.bingai.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**登录验证的过滤器
 * @author bingai
 * @create 2019-12-03 16:56
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println(req);
        //0.强制转换
        HttpServletRequest request = (HttpServletRequest)req;

        //1.获取资源的请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源,要注意排除掉 css/js/图片/验证码等资源
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")){
            //包含，证明用户就是想登录，放行
            chain.doFilter(req, resp);
        }else{
            //不包含，需要验证用户是否登录
            //3.从session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user != null){
                //登录了。放行
                chain.doFilter(req, resp);
            }else{
                //没有登录
                request.setAttribute("login_msg","您尚未登录,请先登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }


        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
