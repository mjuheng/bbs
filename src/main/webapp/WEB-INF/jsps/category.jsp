<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/8
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
</head>
<body>
<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;height: 100%">
    <li class="layui-nav-item" onclick="refresh()"><a href="">全部</a></li>
    <c:forEach items="${requestScope.categories}" var="category">
        <li class="layui-nav-item"><a href="/post/findPostByCategory/${category.name}.do" target="content">${category.name}</a></li>
    </c:forEach>
</ul>
<script>
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });

    function refresh() {
        top.location.href = "/index.jsp"
    }
</script>
</body>
</html>
