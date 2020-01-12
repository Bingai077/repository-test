package com.bingai.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author bingai
 * @create 2019-11-27 15:46
 */
@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //post 获取请求参数
//        String username = request.getParameter("username");
//        System.out.println("post:" + username);
        
        //根据参数获取参数值的数组
//        String[] hobbies = request.getParameterValues("hobby");
//        for (String hobby : hobbies) {
//            System.out.println(hobby);
//        }

        //3. Enumeration<String> getParameterNames():获取所有请求的参数名称
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            String name = parameterNames.nextElement();
////            System.out.println(name);
//            String value = request.getParameter(name);
//            System.out.println(name + "--->" + value);
//            System.out.println("-----------");
//        }

        //4. Map<String,String[]> getParameterMap():获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> set = parameterMap.keySet();
        for (String name : set) {
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("-------------");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get 获取请求参数
//        String username = request.getParameter("username");
//        System.out.println("get:" + username);

        this.doPost(request,response);

    }
}
