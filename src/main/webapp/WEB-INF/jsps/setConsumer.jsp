<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/21
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>帐号设置</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/global.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/js/bootstrap.min.js"></script>
</head>
<body>

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
            <a href="message.html">
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
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title" id="LAY_mine">
                <li class="layui-this" lay-id="info">我的资料</li>
                <li lay-id="pass">密码</li>
            </ul>
            <div class="layui-tab-content" style="padding: 20px 0;">
                <div class="layui-form layui-form-pane layui-tab-item layui-show">
                    <div method="post">
                        <form action="${pageContext.request.contextPath}/consumer/updateInfo.do" method="post">
                            <div class="layui-form-item">
                                <label for="career" class="layui-form-label">职业</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="career" name="career" required lay-verify="required" autocomplete="off" value="" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="city" class="layui-form-label">城市</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="city" name="city" autocomplete="off" value="" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="gender" class="layui-form-label">性别</label>
                                <div class="layui-input-inline">
                                    <select lay-filter="gender" name="gender" id="gender">
                                        <option></option>
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-form-item layui-form-text">
                                <label for="note" class="layui-form-label">签名</label>
                                <div class="layui-input-block">
                                    <textarea placeholder="随便写些什么刷下存在感" id="note"  name="note" autocomplete="off" class="layui-textarea" style="height: 80px;"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <input type="submit" class="layui-btn" value="确认修改">
                            </div>
                        </form>
                    </div>
                </div>


                <div class="layui-form layui-form-pane layui-tab-item">
                    <form action="${pageContext.request.contextPath}/consumer/updatePassword.do" method="post">
                        <div class="layui-form-item">
                            <label for="password" class="layui-form-label">新密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="password" name="password" required lay-verify="required" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="confirm_password" class="layui-form-label">确认密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="confirm_password" name="confirm_password" required lay-verify="required" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <input type="submit" class="layui-btn" value="确认修改">
                        </div>
                    </form>
                </div>


            </div>

        </div>
    </div>
</div>
</div>



<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        form.render();
    });
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块



    });
</script>

</body>
</html>