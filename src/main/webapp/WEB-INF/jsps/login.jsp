<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/13
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/layui/css/others/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/layui/css/others/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/layui/css/others/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/layui/css/others/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
<div class="container">
    <div class="col-md-12">
        <h1 class="margin-bottom-15">Login Form One</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="${pageContext.request.contextPath}/consumer/login.do" method="post">
            <c:if test="${loginError != null}">
                <div>
                    <label style="color: red">${loginError.info}</label>
                </div>
            </c:if>
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        <label for="username" class="control-label fa-label"><img src="${pageContext.request.contextPath}/layui/images/name.png" style="position: relative;right: 5px;"/></label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <label for="password" class="control-label fa-label"><img src="${pageContext.request.contextPath}/layui/images/pwd.png" style="position: relative;right: 5px"/></label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>
                </div>
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/consumer/getCapture.do" onclick="this.src=this.src+'?c='+Math.random();" />
                <input type="password" id="verify" placeholder="verify" name="verify" style="height: 35px; width: 330px">
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="checkbox control-wrapper">
                        <label>
                            <input type="checkbox"> Remember me
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <input type="submit" value="Login" class="btn btn-info">
                        <a href="forgot-password.html" class="text-right pull-right">Forgot password?</a>
                    </div>
                </div>
            </div>

        </form>
        <div class="text-center">
            <a href="${pageContext.request.contextPath}/opt/createAccount.do" class="templatemo-create-new">Create new account <i class="fa fa-arrow-circle-o-right"></i></a>
        </div>
    </div>
</div>
</body>
</html>
