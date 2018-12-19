<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/8
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>头部导航栏</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
</head>
<body>
<ul class="layui-nav">
    <li class="layui-nav-item">&nbsp;</li>
    <img src="${pageContext.request.contextPath}/layui/images/logo.png" style="position: absolute;left: 0px;" onclick="refresh()">
    <%--未登录状态--%>
    <c:if test="${sessionScope.consumer == null}">
        <div style="float: right">
            <li class="layui-nav-item"  onclick="toLogin()"><a href="">登录</a></li>
            <li class="layui-nav-item"  onclick="toCreateAccount()"><a href="">注册</a></li>
        </div>
    </c:if>
    <%--登录状态--%>
    <c:if test="${sessionScope.consumer != null}">
        <div style="float: right">
            <li class="layui-nav-item"><img src="${sessionScope.consumer.headImage}" width="50px" height="50px" alt="头像"/></li>
            <li class="layui-nav-item" onclick="findConsumerDetial(${sessionScope.consumer.id})">您好，${sessionScope.consumer.username}</li>
        </div>
    </c:if>
</ul>
<script>

    function refresh(){
        top.location.href = "/index.jsp"
    }

    function toLogin(){
        top.location.href = "/opt/login.do";
    }
    function toCreateAccount(){
        top.location.href = "/opt/createAccount.do";
    }

    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
</body>
</html>
