<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/21
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/global.css">
</head>
<body>
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

<div class="layui-container fly-marginTop fly-user-main">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
        <li class="layui-nav-item">
            <a href="${pageContext.request.contextPath}/opt/consumerDetail.do">
                <i class="layui-icon">&#xe609;</i>
                我的主页
            </a>
        </li>
        <li class="layui-nav-item">
            <a href="${pageContext.request.contextPath}/post/findPostByConsumerId.do?consumer_id=${sessionScope.consumer.id}">
                <i class="layui-icon">&#xe612;</i>
                用户中心
            </a>
        </li>
        <li class="layui-nav-item">
            <a href="${pageContext.request.contextPath}/opt/setConsumer.do">
                <i class="layui-icon">&#xe620;</i>
                基本设置
            </a>
        </li>
        <li class="layui-nav-item">
            <a href="${pageContext.request.contextPath}/message/findMessage.do">
                <i class="layui-icon">&#xe611;</i>
                我的消息
            </a>
        </li>
    </ul>


    <div class="fly-panel fly-panel-user" pad20>

        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title" id="LAY_mine">
                <li data-type="mine-jie" lay-id="index" class="layui-this">个人信息</li>
            </ul>
            <div class="layui-tab-content" style="padding: 20px 0;">
                <div class="layui-tab-item layui-show">
                    <ul class="mine-view jie-row">
                        昵称 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${sessionScope.consumer.username}<br /><br /><br />
                        性别 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${sessionScope.consumer.gender}<br /><br /><br />
                        城市 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${sessionScope.consumer.city}<br /><br /><br />
                        职业 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${sessionScope.consumer.career}<br /><br /><br />
                        邮箱 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${sessionScope.consumer.email}<br /><br /><br />
                        简介 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${sessionScope.consumer.note}<br /><br /><br />
                    </ul>
                    <div id="LAY_page"></div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
