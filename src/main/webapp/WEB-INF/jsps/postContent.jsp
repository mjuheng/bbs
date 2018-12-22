<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/15
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>内容</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/global.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
</head>
<body>

<c:if test="${requestScope.sendResult != null}">
    <script>
        layer.open({
            type: 0,
            title: '操作结果',
            content:'${requestScope.sendResult}'
        });
        setTimeout(function (){
            layer.closeAll();
        }, 1000);
    </script>
</c:if>
<c:if test="${requestScope.result != null}">
    <script>
        layer.open({
            type: 0,
            title: '操作结果',
            content:'${requestScope.result}'
        });
        setTimeout(function (){
            layer.closeAll();
        }, 1000);
    </script>
</c:if>
<form action="${pageContext.request.contextPath}/post/findPostByTitle.do" method="get" style="position: absolute;left: 0px;top: 0px;">

    <input type="text" placeholder="搜索内容" name="title" style="height: 40px;width: 500px;">
    <input type="submit" class="layui-btn" value="搜索">
    <button class="layui-btn"><a href="${pageContext.request.contextPath}/category/findCategoryAll.do">发帖</a></button>
</form>


<div class="fly-panel">
    <div class="fly-panel-title fly-filter">
        <a>置顶</a>
    </div>
    <ul class="fly-list">
        <c:forEach items="${requestScope.peakPosts}" var="post">
            <li>
                <a href="#" class="fly-avatar">
                    <img src="${post.consumer.headImage}" alt="头像">
                </a>
                <h2>
                    <a href="/postbody/findPostbody/${post.id}.do">[${post.category.name}]${post.title}</a>
                </h2>
                <div class="fly-list-info">
                    <a href="#" onclick="showConsumerDetail(${post.consumer.id})">
                        <cite>${post.consumer.username}</cite>
                    </a>
                    <span>${post.formatLastTime}</span>
                    <span>${post.replyNum}</span>
                    <c:if test="${post.resolve == true}"><span class="layui-badge fly-badge-accept layui-hide-xs">已结</span></c:if>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>

<div class="fly-panel">
    <div class="fly-panel-title fly-filter">
        <a>帖子</a>
    </div>
    <ul class="fly-list">

        <c:forEach items="${posts}" var="post">
            <li>
                <a href="#" class="fly-avatar">
                    <img src="${post.consumer.headImage}" alt="贤心">
                </a>
                <h2>
                    <a href="/postbody/findPostbody/${post.id}.do">[${post.category.name}]${post.title}</a>
                </h2>
                <div class="fly-list-info">
                    <a href="#" onclick="showConsumerDetail(${post.consumer.id})">
                        <cite>${post.consumer.username}</cite>
                    </a>
                    <span>${post.formatLastTime}</span>
                    <span>${post.replyNum}</span>
                    <c:if test="${post.resolve == true}"><span class="layui-badge fly-badge-accept layui-hide-xs">已结</span></c:if>
                </div>
            </li>
        </c:forEach>

    </ul>
</div>
<script>
    function showConsumerDetail(id) {
        var consumer_id = '${sessionScope.consumer.id}';
        if (consumer_id === id){
            window.top.document.getElementById("content").src = "/opt/consumerDetail.do";
        } else {
            layui.use('layer', function () {
                var layer = layui.layer;

                layer.open({
                    type: 2,
                    title: '个人信息',
                    shadeClose: false,
                    area: ['300px', '370px'],
                    content: '/consumer/findBasicInfo.do?consumer_id=' + id
                });
            });
        }
    }
</script>
</body>
</html>