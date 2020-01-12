<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>查询所有账户信息</h3>

<c:forEach items="${list}" var="account">
    ${account.name}<br>
    ${account.money}<br>
</c:forEach>
</body>
</html>
