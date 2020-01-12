<%@ page import="com.bingai.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取对象中数据</title>
</head>
<body>

<%

    User user = new User();
    user.setName("张三");
    user.setAge(23);
    user.setBirthday(new Date());

    request.setAttribute("u",user);

    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);

    request.setAttribute("list",list);

    Map map = new HashMap();
    map.put("sname","李四");
    map.put("gender","男");
    map.put("user",user);
    request.setAttribute("map",map);


%>


<h1>el获取对象中的值</h1>
${requestScope.u}<br>

<%--
通过的是对象的属性来获取
    setter或getter方法，去掉set或get，再将剩余部分，首字母变小写。
    setName --> Name  --> name
--%>

${requestScope.u.name}<br>
${u.age}<br>
${u.birthday.month}<br>
${u.birStr}<br>

<h3>el获取list的值</h3>
${list}<br>
${list[0]}<br>
${list[1]}<br>
${list[20]}<br>

${list[2].name}<br>

<h3>el获取map的值</h3>
${map.gender}<br>
${map["gender"]}<br>
${map.user.name}<br>

<h4>empty运算符</h4>
<%
    String str = "";
    request.setAttribute("str",str);

    List list1 = new ArrayList();
    request.setAttribute("list1",list1);
%>
${not empty str}<br>
${not empty list1}<br>











</body>
</html>
