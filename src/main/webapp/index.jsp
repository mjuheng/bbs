<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/15
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>页面</title>
</head>
<body>
<div style="float: top;">
    <iframe src="${pageContext.request.contextPath}/opt/head.do"
            height="60px;"
            width="100%"
            >
    </iframe>
</div>
<div style="float: top">
    <div style="float: left;width: auto">
        <iframe src="${pageContext.request.contextPath}/category/findCategoryToIndex.do" height="100%" name="ifd"
                scrolling="no"
                width="200px"
                style="position: relative; bottom: 2px;"
                frameborder="0">
        </iframe>
    </div>
    <div style="float: left;width: auto">
        <iframe src="${pageContext.request.contextPath}/post/findPostAll.do" name="content" id="content"
                width="1500"
                height="935px"
                frameborder="0"
        >
        </iframe>
    </div>
</div>

</body>
</html>
