package com.zahuopu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zahuopu.pojo.system.LoginLog;
import com.zahuopu.service.system.LoginLogService;
import com.zahuopu.util.WebUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author bingai
 * @create 2020-01-16 19:28
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Reference
    private LoginLogService loginLogService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //登录后会调用
        System.out.println("登录成功了，我要在这里记录日志");

        String loginName = authentication.getName();
        String ip = request.getRemoteAddr();


        LoginLog loginLog = new LoginLog();
        loginLog.setLoginName(loginName);//当前登录管理员
        loginLog.setLoginTime(new Date());//当前登录时间
        loginLog.setIp(ip);//远程客户端的ip
        loginLog.setLocation(WebUtil.getCityByIP(ip));//地区

        String header = request.getHeader("user-agent");
        System.out.println("agent:"+ header);

        loginLog.setBrowserName(WebUtil.getBrowserName(header));//浏览器名称

        loginLogService.add(loginLog);
        request.getRequestDispatcher("/main.html").forward(request,response);

    }
}
