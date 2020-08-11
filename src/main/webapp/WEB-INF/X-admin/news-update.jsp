<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台登录-X-admin2.0</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <%
        String path=request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href=" <%=basePath%>">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
</head>

<body>
<div class="x-body">
    <form class="layui-form" id="layui-form">
        <div class="layui-form-item">
            <label for="news_id" class="layui-form-label">
                <span class="x-red">*</span>消息修改
            </label>
            <div class="layui-input-inline">
                <input type="hidden" id="news_id" name="news_id" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="" >
            </div>
        </div>
        <div class="layui-form-item">
            <label for="news_title" class="layui-form-label">
                <span class="x-red">*</span>消息标题
            </label>
            <div class="layui-input-inline">
                <input type="text" id="news_title" name="news_title"   required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="news_text" class="layui-form-label">
                <span class="x-red">*</span>歌曲内容
            </label>
            <div class="layui-input-inline">
                <input type="text"  name="news_text" id="news_text" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="news_author_id" class="layui-form-label">
                <span class="x-red">*</span>音乐作者
            </label>
            <div class="layui-input-inline">
                <select name="news_author_id" id="news_author_id">
                    <option value="">音乐作者</option>
                    <c:forEach items="${authorid}" var="item">
                        <option value="${item.author_id}">${item.author_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="news_type" class="layui-form-label">
                <span class="x-red">*</span>消息分类
            </label>
            <div class="layui-input-inline" >
                <select name="news_type" id="news_type">
                    <option value="">消息分类</option>
                    <option value=1>歌曲消息</option>
                    <%--<option value=0>其它消息</option>--%>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_news_title" class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="save" lay-submit="">
                修改
            </button>
        </div>
    </form>
</div>
<script>
    $.ajax({
        type:"get",
        url:"<%=basePath%>newsselect2/"+${news.news_id},
        dataType : "json",
        contentType : "application/json;charset=UTF-8",
        success:function(data) {
            $("#news_id").val(data.news_id);
            $("#news_title").val(data.news_title);
            $("#news_text").val(data.news_text);
            $("#news_author_id").val(data.news_author_id);
            $("#news_type").val(data.news_type);
        }});
    $('.layui-btn').click(function() {
        $.post("<%=basePath%>newsupdate",
            $("#layui-form").serialize(), function (data) {
                if (data == 1) {
                    alert("修改成功！");
                    parent.location.reload();
                } else {
                    alert("修改失败！");
                    parent.location.reload();
                }
            });

    })


    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        //监听提交



    });
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>