package com.bingai.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**重定向
 * @author bingai
 * @create 2019-11-28 11:27
 */
@WebServlet("/responceDemo5")
public class ResponceDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        //1.获取字节输出流
        ServletOutputStream os = response.getOutputStream();

        //2.输出数据
        os.write("<h1>你好啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊 response</h1>".getBytes("utf-8"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
