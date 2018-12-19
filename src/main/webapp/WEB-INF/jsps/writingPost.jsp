<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/16
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>发帖</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/global.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/js/bootstrap.min.js"></script>
</head>
<body>
<div style="float: top;position: absolute;top: 0px;">
<fieldset class="layui-elem-field layui-field-title">
    <legend>发帖</legend>
</fieldset>
<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/post/writingPost.do" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">标题</label>
        <div class="layui-input-block">
            <input type="text" name="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>



    <div class="layui-form-item">
        <label class="layui-form-label">分类</label>
        <div class="layui-input-block">
            <select lay-filter="aihao" name="category">
                <c:forEach items="${requestScope.categories}" var="category">
                    <option value="${category.name}">${category.name}</option>
                </c:forEach>
            </select>

        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">内容</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" class="layui-textarea" name="content" cols="100" rows="15"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <input type="submit" value="发表" class="layui-btn">
    </div>
</form>
</div>

<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        //……

        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
        form.render();
    });
</script>

</body>
</html>