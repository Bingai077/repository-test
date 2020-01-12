package com.bingai.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-11-27 15:46
 */
@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据：referer
        String referer = request.getHeader("referer");
        System.out.println(referer);

        //防盗链
        if(referer != null){
            if(referer.contains("/login.html")){
                //正常访问
                //System.out.println("播放NBA");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放NBA");
            }else{
                //盗链
                //System.out.println("想看NBA吗? 来腾讯吧。。。");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("想看NBA吗? 来腾讯吧。。。");
            }
        }

    }
}
