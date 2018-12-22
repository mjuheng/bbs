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
<c:if test="${requestScope.result != null}">
    <script>
        alert("${result}")
    </script>
</c:if>
<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;height: 100%">
    <li class="layui-nav-item" onclick="refresh()"><a href="">全部</a></li>
    <c:forEach items="${requestScope.categories}" var="category">
        <li class="layui-nav-item">
            <a href="/post/findPostByCategory/${category.name}.do" target="content">${category.name}&nbsp;&nbsp;
                <c:if test="${sessionScope.consumer.admin == true}">
                    <button class="layui-btn layui-btn-primary layui-btn-sm" onclick="updateCategory(${category.id})"><i class="layui-icon"></i></button>
                    <button class="layui-btn layui-btn-primary layui-btn-sm" onclick="deleteCategory(${category.id})"><i class="layui-icon"></i></button>
                </c:if>
            </a>
        </li>
    </c:forEach>
    <c:if test="${sessionScope.consumer.admin == true}">
        <li class="layui-nav-item"><a href="">&nbsp;</a></li>
        <form action="${pageContext.request.contextPath}/category/addCategory.do" id="formCategory" >
            <li class="layui-nav-item"><input type="text" name="name" placeholder="请输入分类名" autocomplete="off" class="layui-input" style="width: 150px;position: relative;left: 17px;"></li>
            <li class="layui-nav-item"><a href=""><input type="submit" value="添加" class="layui-btn layui-btn-primary layui-btn-sm">&nbsp;</a></li>
        </form>
    </c:if>
</ul>
<script>

    function deleteCategory(id){
        if (confirm("删除该分类，将会删除该分类下的全部帖子，是否确定删除？")){
            window.location.href = "/category/deleteCategory.do?category_id=" + id;
            top.location.href = "/index.jsp";
        }
    }

    function updateCategory(id) {
        var category_name = prompt("请输入新的分类名：");
        if (category_name != null && category_name.length > 0){
            window.location.href = "/category/updateCategory.do?id=" + id + "&name=" + category_name;
            top.location.href = "/index.jsp";
        }
    }

    function addCategory(){
        var category = document.getElementById("category").value;

    }

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
