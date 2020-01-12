package com.bingai.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-11-29 15:52
 */
@WebServlet("/sessionDemo4")
public class SessionDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用session共享数据
        //1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
