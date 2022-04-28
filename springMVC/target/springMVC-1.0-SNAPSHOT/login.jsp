<%--
  Created by IntelliJ IDEA.
  User: long-an
  Date: 2022/3/23
  Time: 下午6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录也</h1>
<form action="/hello/test">
    <table>
        <tr>
            <td>名字</td>
            <td><input name="name" type="text" ></td>
        </tr><tr>
            <td>年龄</td>
            <td><input name="age" type="text" ></td>
        </tr><tr>
            <td>出生日期</td>
            <td><input name="date" type="date" ></td>
        </tr>
        <tr>
            <td>
<%--                <input name="Mstr['s1'].name" type="text">--%>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
