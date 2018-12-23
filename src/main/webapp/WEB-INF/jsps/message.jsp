<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/23
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <meta charset="utf-8">
    <title>我的消息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/global.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
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

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>


    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief" lay-filter="user" id="LAY_msg" style="margin-top: 15px;">
            <c:if test="${fn:length(messages) > 0}"><button class="layui-btn layui-btn-danger" id="LAY_delallmsg" onclick="deleteAll()">清空全部消息</button></c:if>
            <div  id="LAY_minemsg" style="margin-top: 10px;">
                <c:if test="${fn:length(messages) == 0}"><div class="fly-none">您暂时没有最新消息</div></c:if>
                <ul class="mine-msg">
                    <c:forEach items="${requestScope.messages}" var="message">
                        <li data-id="123">
                            <blockquote class="layui-elem-quote">
                                <a href="#" onclick="showConsumerDetail(${message.fromConsumer.id})"><cite>${message.fromConsumer.username}</cite></a>${message.content}<a href="/postbody/findPostbody/${message.post.id}.do"><cite>${message.post.title}</cite></a>
                                <a href="${pageContext.request.contextPath}/message/deleteMessageOne.do?message_id=${message.id}" class="layui-btn layui-btn-small layui-btn-danger fly-delete" style="float: right">删除</a>

                            </blockquote>
                            <span>${message.formatSendTime}</span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>

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

    function deleteAll() {
        window.location.href = "/message/deleteAll.do";
    }
</script>

</body>
</html>