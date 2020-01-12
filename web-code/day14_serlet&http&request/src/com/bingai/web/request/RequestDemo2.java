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
@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //* (*)String getHeader(String name):通过请求头的名称获取请求头的值


        //* Enumeration<String> getHeaderNames():获取所有的请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //遍历
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            //根据名称获得请求头的值
            System.out.println(name + "---" + request.getHeader(name));
        }

    }
}
