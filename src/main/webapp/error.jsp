<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/24
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误</title>
</head>
<body>
<h1>您还没有登录，请点击<a href="/opt/login.do">登录</a></h1>
<script>
    setTimeout(function (){
        top.window.location.href = "/opt/login.do";
    }, 3000);
</script>
</body>
</html>
