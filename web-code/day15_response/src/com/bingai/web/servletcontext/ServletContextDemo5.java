package com.bingai.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author bingai
 * @create 2019-11-28 17:21
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        ServletContext功能
            1. 获取MIME类型：
                * MIME类型:在互联网通信过程中定义的一种文件数据类型
                    * 格式： 大类型/小类型 text/html image/jpeg
                * 获取：String getMimeType(String file)
            2. 域对象：共享数据
                1. setAttribute(String name,Object value)
                2. getAttribute(String name)
                3. removeAttribute(String name)
                    * ServletContext对象范围：所有用户所有请求的数据
            3. 获取文件的真实(服务器)路径
                1. 方法：String getRealPath(String path)
                    String b = context.getRealPath("/b.txt");//web目录下资源访问
                    System.out.println(b);
                    String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
                    System.out.println(c);
                    String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
                    System.out.println(a);
        */

        ServletContext context = this.getServletContext();

        //获取文件的服务器路径
        String realPath = context.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(realPath);
        //File file = new File(realPath);

        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(c);

        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(a);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
