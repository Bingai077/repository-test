<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>传统文件上传</h3>
    <form action="user/fileupload1" method="post" ENCTYPE="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>

    <h3>SpringMVC文件上传</h3>
    <form action="user/fileupload2" method="post" ENCTYPE="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>

    <h3>跨服务器文件上传</h3>
    <form action="user/fileupload3" method="post" ENCTYPE="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>


</body>
</html>
