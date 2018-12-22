<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/22
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/global.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/js/bootstrap.min.js"></script>
</head>
<body style="margin-top: 65px;">

<div class="fly-home fly-panel" style="width: 300px; height: 250px; position: absolute; top: 0px; left: 0px">
    <img src="${requestScope.basicConsumerInfo.headImage}" alt="贤心">
    <h1>
        ${requestScope.basicConsumerInfo.username}
    </h1>

    <br />

    <p class="fly-home-info">
        <i class="iconfont icon-chengshi"></i><span>来自${requestScope.basicConsumerInfo.city}</span>
    </p>
    <p class="fly-home-sign">
        （
            <c:if test="${requestScope.basicConsumerInfo.note == null}">用户很懒，没有个性签名</c:if>
            <c:if test="${requestScope.basicConsumerInfo.note != null}">${requestScope.basicConsumerInfo.note}</c:if>
        ）</p>

    <div class="fly-sns" data-user="">
        <c:if test="${sessionScope.consumer != null}">
            <c:if test="${requestScope.isAttention != null && requestScope.isAttention == true}">
                <a href="javascript:;" class="layui-btn layui-btn-primary fly-imActive" data-type="addFriend" onclick="deleteAttention()">取消关注</a>
            </c:if>
            <c:if test="${requestScope.isAttention == null || requestScope.isAttention == false}">
                <a href="javascript:;" class="layui-btn layui-btn-primary fly-imActive" data-type="addFriend" onclick="makeAttention()">关注</a>
            </c:if>
        </c:if>
    </div>

</div>

<script>
    function makeAttention() {
        var toConsumer_id = ${requestScope.basicConsumerInfo.id};

        $.ajax({
            url: "/attention/makeAttention.do",
            type: "POST",
            data: JSON.stringify({
                toConsumer_id:toConsumer_id
            }),
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function(data){

                if (data != null){
                    alert(data.info);
                    location.reload();
                }
            },
            error: function () {
                alert("关注错误");
            }
        });
    }

    function deleteAttention(){
        var toConsumer_id = ${requestScope.basicConsumerInfo.id};

        $.ajax({
            url: "/attention/deleteAttention.do",
            type: "POST",
            data: JSON.stringify({
                toConsumer_id:toConsumer_id
            }),
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function(data){

                if (data != null){
                    alert(data.info);
                    location.reload();
                }
            },
            error: function () {
                alert("页面错误");
            }
        });
    }
</script>



</body>
</html>