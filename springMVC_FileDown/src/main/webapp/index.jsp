<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>成功页</title>
</head>
<body>
<img src="http://localhost:8888/images/${img}">

<form action="/fileDown/start?fileName=${img}" method="post">
    <input type="submit" value="文件下载">
</form>
</body>
</html>