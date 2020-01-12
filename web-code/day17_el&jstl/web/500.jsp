<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>服务器正忙...</h1>
    <%
        String message = exception.getMessage();
        System.out.println(message);

    %>

</body>
</html>
