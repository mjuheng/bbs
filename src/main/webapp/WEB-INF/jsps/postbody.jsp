<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/17
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>帖子内容</title>
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
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8 content detail">
            <div class="fly-panel detail-box" style="height: 300px">
                <h1>${requestScope.postbodys[0].post.title}</h1>
                <div class="fly-detail-info">
                    <c:if test="${sessionScope.consumer.admin == true && requestScope.postbodys[0].post.peak == false}">
                        <span class="layui-badge layui-bg-red"><a href="${pageContext.request.contextPath}/post/makePeak.do?post_id=${requestScope.postbodys[0].post.id}">置顶</a></span>
                    </c:if>
                    <c:if test="${sessionScope.consumer.admin == true && requestScope.postbodys[0].post.peak == true}">
                        <span class="layui-badge layui-bg-red"><a href="${pageContext.request.contextPath}/post/removePeak.do?post_id=${requestScope.postbodys[0].post.id}">取消置顶</a></span>
                    </c:if>
                    <c:if test="${sessionScope.consumer.id == requestScope.postbodys[0].consumer.id || sessionScope.consumer.admin == true}">
                        <span class="layui-btn layui-btn-xs jie-admin" type="del"><a href="${pageContext.request.contextPath}/post/deletePost.do?post_id=${requestScope.postbodys[0].post.id}">删除</a></span>
                    </c:if>
                    <!-- <span class="layui-badge" style="background-color: #5FB878;">已结</span> -->

                    <br />
                    <div class="fly-admin-box" data-id="123">
                        <%--<span class="layui-btn layui-btn-xs jie-admin" type="set" field="stick" rank="0" style="background-color:#ccc;">取消置顶</span>--%>
                    </div>
                    <span class="fly-list-nums">
            <a href="#comment"><i class="iconfont" title="回答">&#xe60c;</i> ${requestScope.postbodys[0].post.replyNum}</a>
            <i class="iconfont" title="人气">&#xe60b;</i> ${requestScope.postbodys[0].post.watchNum}
          </span>
                </div>
                <div class="detail-about">
                    <a class="fly-avatar" href="#">
                        <img src="${requestScope.postbodys[0].consumer.headImage}" alt="贤心">
                    </a>
                    <div class="fly-detail-user">
                        <a href="#" class="fly-link" onclick="showConsumerDetail(${requestScope.postbodys[0].consumer.id})">
                            <cite>${requestScope.postbodys[0].consumer.username}</cite>
                        </a>
                        <span>${requestScope.postbodys[0].formatReplyTime}</span>
                    </div>
                    <div class="detail-hits" id="LAY_jieAdmin" data-id="123">
                        <br />
                        <%--<span class="layui-btn layui-btn-xs jie-admin" type="edit"><a href="add.html">删除此贴</a></span>--%>
                    </div>
                </div>
                <div class="detail-body photos">
                    <p>
                        ${requestScope.postbodys[0].content}
                    </p>

                </div>
            </div>

            <div class="fly-panel detail-box" id="flyReply">
                <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
                    <legend>回帖</legend>
                </fieldset>
                <ul class="jieda" id="jieda">
                    <c:forEach items="${requestScope.postbodys}" var="postbody" begin="1">
                        <li data-id="111">
                            <a name="item-1111111111"></a>
                            <div class="detail-about detail-about-reply">
                                <a class="fly-avatar" href="">
                                    <img src="${postbody.consumer.headImage}" alt="头像">
                                </a>
                                <div class="fly-detail-user">
                                    <a href="#" class="fly-link" onclick="showConsumerDetail(${postbody.consumer.id})">
                                        <cite>${postbody.consumer.username}</cite>
                                    </a>
                                </div>
                                <div class="detail-hits">
                                    <span>${postbody.formatReplyTime}</span>
                                </div>
                            </div>
                            <c:if test="${postbody.adopt == true}">
                                <i class="iconfont icon-caina" title="最佳答案"></i>
                            </c:if>
                            <div class="detail-body jieda-body photos">
                                <p>${postbody.content}</p>
                            </div>
                            <div class="jieda-reply">
                                <span type="reply">
                                    <i class="iconfont icon-svgmoban53"></i>回复
                                </span>

                                <div class="jieda-admin">
                                    <c:if test="${sessionScope.consumer.id == requestScope.postbodys[0].consumer.id}">
                                        <span class="jieda-accept" type="accept"><a href="${pageContext.request.contextPath}/postbody/makeAdopt.do?post_id=${requestScope.postbodys[0].post.id}&postbody_id=${postbody.id}"> 采纳</a></span>
                                    </c:if>
                                    <c:if test="${sessionScope.consumer.id == postbody.consumer.id || sessionScope.consumer.id == requestScope.postbodys[0].consumer.id}">
                                        <span type="del"><a href="${pageContext.request.contextPath}/postbody/deletePost.do?post_id=${requestScope.postbodys[0].post.id}&postbody_id=${postbody.id}">删除</span>
                                    </c:if>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                    <c:if test="${fn:length(postbodys) == 1}"><li class="fly-none">消灭零回复</li></c:if>
                    <!-- 无数据时 -->
                    <%--<li class="fly-none"></li>--%>
                </ul>

                <div class="layui-form layui-form-pane">
                    <form action="${pageContext.request.contextPath}/postbody/writingDiscuss.do" method="post">
                        <div class="layui-form-item layui-form-text">
                            <a name="comment"></a>
                            <div class="layui-input-block">
                                <textarea id="L_content" name="content" required lay-verify="required" placeholder="请输入内容"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <input type="hidden" name="post_id" value="${requestScope.postbodys[0].post.id}">
                            <input type="submit" class="layui-btn" value="提交回复">
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
    <div class="fly-footer">
        <p><a href="http://fly.layui.com/" target="_blank">Made In BBS DISCUSS</a></p>
    </div>
</div>


<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    function showConsumerDetail(id) {
        var consumer_id = ${sessionScope.consumer.id};
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
                    offset: ['300px','300px'],
                    content: '/consumer/findBasicInfo.do?consumer_id=' + id
                });
            });
        }
    }
</script>
</body>
</html>