<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    ${pageContext.request}<br>
    <h4>在jsp页面动态获取虚拟目录</h4>
    ${pageContext.request.contextPath}

<%

%>


</body>
</html>
