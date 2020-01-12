package com.bingai.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author bingai
 * @create 2019-11-27 15:46
 */
@WebServlet("/RequestDemo7")
public class RequestDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.设置流的编码
        request.setCharacterEncoding("utf-8");

        //post 获取请求参数
        String username = request.getParameter("username");
        System.out.println("post:" + username);
        



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get 获取请求参数
//        String username = request.getParameter("username");
//        System.out.println("get:" + username);

        this.doPost(request,response);

    }
}
