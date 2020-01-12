package com.bingai.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**Cookie快速入门
 * @author bingai
 * @create 2019-11-29 10:43
 */
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("msg","setMaxAge");
        //2.设置cookie的存活时间
        //cookie.setMaxAge(30);//将cookie持久化到硬盘，30秒后会自动删除cookie文件
        //cookie.setMaxAge(-1);//默认值
        cookie.setMaxAge(0);//删除cookie信息

        //3.发送Cookie
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
