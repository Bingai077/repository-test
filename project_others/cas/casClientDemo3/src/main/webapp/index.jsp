<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %><%--
  Created by IntelliJ IDEA.
  User: Bai-gai
  Date: 2020/1/28
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>杂货铺用户中心</title>
</head>
<body>
<%=SecurityContextHolder.getContext().getAuthentication().getName()%>,欢迎来到杂货铺用户中心！

<a href="/logout/cas">退出</a>
</body>
</html>
