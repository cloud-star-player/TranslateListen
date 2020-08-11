<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href=" <%=basePath%>">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-body">
    <form class="layui-form" action="${pageContext.request.contextPath }/upload" enctype="multipart/form-data"
          method="post">
        <div class="layui-form-item">
            <label for="music_name" class="layui-form-label">
                <span class="x-red">*</span>音乐名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="music_name" name="music_name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="music_image" class="layui-form-label">
                <span class="x-red">*</span>音乐图片
            </label>
            <div class="layui-input-inline">
                <input type="file" id="music_image" name="music_image" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
                <img src="" id="music_image2" style="width: 20rem;height: 15rem;">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="music_music" class="layui-form-label">
                <span class="x-red">*</span>音乐文件
            </label>
            <div class="layui-input-inline">
                <input type="file" id="music_music" name="music_music" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
                <audio id="music_music2" src="" controls loop preload: auto></audio>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="music_author_id" class="layui-form-label">
                <span class="x-red">*</span>音乐作者
            </label>
            <div class="layui-input-inline">
                <select name="music_author_id" id="music_author_id">
                    <option value="">音乐作者</option>
                    <c:forEach items="${authorid}" var="item">
                        <option value="${item.author_id}">${item.author_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="music_type" class="layui-form-label">
                <span class="x-red">*</span>音乐分类
            </label>
            <div class="layui-input-inline">
                <select name="music_type" id="music_type">
                    <option value="">音乐分类</option>
                    <option value=0>暂无类型</option>
                    <option value=1>畅听热歌</option>
                    <option value=2>热门歌曲</option>
                    <option value=3>励志歌曲</option>
                    <option value=4>伤感歌曲</option>
                    <option value=5>其他歌曲</option>
                </select>
            </div>
            <%--<div class="layui-form-item layui-form-text">--%>
            <%--<label for="desc" class="layui-form-label">--%>
            <%--商品增加--%>
            <%--</label>--%>
            <%--<div class="layui-input-block">--%>
            <%--<table class="layui-table">--%>
            <%--<tbody>--%>
            <%--<tr>--%>
            <%--<td>haier海尔 BC-93TMPF 93升单门冰箱</div></td>--%>
            <%--<td>0.01</div></td>--%>
            <%--<td>984</div></td>--%>
            <%--<td>1</td>--%>
            <%--<td>删除</td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>haier海尔 BC-93TMPF 93升单门冰箱</div></td>--%>
            <%--<td>0.01</div></td>--%>
            <%--<td>984</div></td>--%>
            <%--<td>1</td>--%>
            <%--<td>删除</td>--%>
            <%--</tr>--%>
            <%--</tbody>--%>
            <%--</table>--%>
            <%--</div>--%>
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>

            <button class="layui-btn" lay-filter="add" lay-submit="">
                增加
            </button>
        </div>
    </form>
</div>
<script>
    $("#music_image").change(function () {
        var objUrl = getObjectURL(this.files[0]);//获取文件信息
        var music_image = document.getElementById("music_image").value;
        if (!/.(gif|jpg|jpeg|png|GIF|JPG|bmp|PNG)$/.test(music_image)) {
            alert("图片类型必须是.gif,jpeg,jpg,png,bmp中的一种");
            var obj = document.getElementById('music_image');
        }
        console.log("objUrl = " + objUrl);
        if (objUrl) {
            $("#music_image2").attr("src", objUrl);
        }
    });
    $("#music_music").change(function () {
        var objUrl = getObjectURL(this.files[0]);//获取文件信息
        var music_music = document.getElementById("music_music").value;
        if (!/.(aif|aiff|mp3|mp1)$/.test(music_music)) {
            alert("音乐类型必须是aif，aiff，mp3，mp1中的一种");
            var obj = document.getElementById('music_music');
        }
        console.log("objUrl = " + objUrl);
        if (objUrl) {
            $("#music_music2").attr("src", objUrl);
        }
    });

    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }

    $('.layui-btn').click(function () {
        var music_name = document.getElementById("music_name").value;
        var music_author_id = document.getElementById("music_author_id").value;
        var music_image = document.getElementById("music_image").value;
        var music_music = document.getElementById("music_music").value;
        var music_type = document.getElementById("music_type").value;
        if (music_name == "") {
            alert("请填写音乐名");
            return false;
        }
        if (music_author_id == " " || music_author_id == "" || music_author_id.length == 0) {
            alert("请选择作者");
            return false;
        }
        if (music_image == "" || music_image.length == 0 || music_music == "" || music_music.length == 0) {
            alert("请选择文件");
            return false;
        }
        if (music_type == " ") {
            alert("请选择类型");
            return false;
        }
        if (!/.(gif|jpg|jpeg|png|GIF|JPG|bmp|PNG)$/.test(music_image)) {
            alert("图片类型必须是.gif,jpeg,jpg,png,bmp中的一种");
            return false;
        }
        if (!/.(aif|aiff|mp3|mp1)$/.test(music_music)) {
            alert("音乐类型必须是aif，aiff，mp3，mp1中的一种");
            return false;
        }
        alert("上传成功");
        return true;
    });

</script>
<script>var _hmt = _hmt || [];
(function () {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>