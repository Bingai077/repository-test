<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--常用注解--%>
<a href="anno/testRequestParam?name=haha">RequestParam</a>

<br>

<form action="anno/testRequestBody" method="post">

    用户名：<input type="text" name="username"><br/>
    用户年龄：<input type="text" name="age"><br/>
    <input type="submit" value="提交">

</form>

<a href="anno/testPathVaribale/10">/testPathVaribale</a>

<br>

<a href="anno/testRequestHeader">/testRequestHeader</a>

<br>

<a href="anno/testCookieValue">/testCookieValue</a>

<br>

<form action="anno/testModelAttribute" method="post">

    用户名：<input type="text" name="uname"><br/>
    用户年龄：<input type="text" name="age"><br/>
    <input type="submit" value="提交">

</form>

<br>

<a href="anno/testSessionAttribute">SessionAttribute</a>
<br>
<a href="anno/getSessionAttribute">SessionAttribute</a>
<br>
<a href="anno/delSessionAttribute">SessionAttribute</a>

</body>
</html>
