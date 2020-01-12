package com.bingai.web.servlet;

import com.bingai.service.UserService;
import com.bingai.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-12-02 19:40
 */
@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        UserService service = new UserServiceImpl();
        service.deleteUser(id);

        //3.跳转到查询所有的Servlet
         response.sendRedirect(request.getContextPath() + "//userListServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
