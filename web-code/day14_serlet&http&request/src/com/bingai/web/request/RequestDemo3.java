package com.bingai.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**演示Request获取请求头数据
 * @author bingai
 * @create 2019-11-27 15:46
 */
@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //* (*)String getHeader(String name):通过请求头的名称获取请求头的值
        //获取user-agent
        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if(agent.contains("Chrome")){
            //谷歌
            System.out.println("谷歌来啦");
        }else if(agent.contains("Firefox")){
            //火狐
            System.out.println("火狐来啦");
        }

    }
}
