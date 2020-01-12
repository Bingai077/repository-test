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
@WebServlet("/cookieDemo5")
public class CookieDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("msg","你好啊");

        //设置path，让当前服务器下部署的项目共享Cookie信息
        cookie.setPath("/");

        //3.发送Cookie
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
