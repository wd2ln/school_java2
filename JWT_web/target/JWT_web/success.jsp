<%--
  Created by IntelliJ IDEA.
  User: long-an
  Date: 2022/4/5
  Time: 下午4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.8.3.min.js"/>
</head>
<body>
<h1>欢迎<span id="name"></span>登录成功</h1>
</body>
<script type="application/javascript">
    $(function () {
        //从本地拿取token
        var token=localStorage.getItem("token");
        $.ajax( {
            type:"post",
            url:"user/isToken",
            data:{"token":token},
            success:function (data) {
                if (data.username!=null){
                    $("#name").val(data.username);
                }else {
                    $(location).attr("href","/login.html");
                }
            }
        });
    })
</script>
</html>
