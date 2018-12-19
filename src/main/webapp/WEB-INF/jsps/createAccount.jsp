<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/8
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <link href="${pageContext.request.contextPath}/layui/css/others/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/layui/css/others/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/layui/css/others/templatemo_style.css" rel="stylesheet" type="text/css">
    <script>
        function checkUsername(){
            var username = document.getElementById("username").value;

            $.ajax({
                url: "/consumer/checkUsername.do",
                type: "POST",
                data: JSON.stringify({
                    username:username
                }),
                contentType: "application/json;charset=UTF-8",
                dataType: "json",
                success: function(data){

                    if (data != null && data.code != 1){
                        document.getElementById('checkUsername').firstChild.nodeValue=(data.info);
                    }
                },
                error: function () {
                    alert("登录错误")
                }
            });
        }
    </script>
</head>
<body class="templatemo-bg-gray">
<h1 class="margin-bottom-15">Create Account</h1>
<div class="container">
    <div class="col-md-12">
        <form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="${pageContext.request.contextPath}/consumer/createAccount.do" method="post" enctype="multipart/form-data">
            <div class="form-inner">
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="username" class="control-label">Username<label id="checkUsername" style="color: red">&nbsp;&nbsp;</label></label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="" onchange="checkUsername()">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="password" class="control-label">Password</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="password_confirm" class="control-label">Password Confirm<c:if test="${errorPassword != null}"><label style="color: red">&nbsp;&nbsp;密码不一致，请重新输入</label></c:if> </label>
                        <input type="text" class="form-control" id="password_confirm" name="password_confirm" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="email" class="control-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="image" class="control-label">HeadImage</label>
                        <input type="file" class="form-control" id="image" name="image" placeholder="">
                    </div>
                </div>

                <br />
                <div class="form-group">
                    <div class="col-md-12">
                        <input type="submit" value="Create account" class="btn btn-info">
                        <a href="${pageContext.request.contextPath}/opt/login.do" class="pull-right">Login</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/js/bootstrap.min.js"></script>

</body>
</html>
</body>
</html>
