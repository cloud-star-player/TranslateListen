<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
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
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-body">
    <form class="layui-form" action="${pageContext.request.contextPath }/musicupdate/${music.music_id}" enctype="multipart/form-data" method="post">
            <div class="layui-form-item">
                <label for="music_name" class="layui-form-label">
                    <span class="x-red">*</span>音乐id
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="music_id" name="music_id"  required="" lay-verify="required"
                           autocomplete="off" class="layui-input" value="" disabled="disabled">
                </div>
            </div>
        <div class="layui-form-item">
            <label for="music_name" class="layui-form-label">
                <span class="x-red">*</span>音乐名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="music_name" name="music_name"  required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="music_collect" class="layui-form-label">
                <span class="x-red">*</span>音乐收藏数
            </label>
            <div class="layui-input-inline">
                <input type="text" id="music_collect" name="music_collect"  required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="music_hot" class="layui-form-label" value="">
                <span class="x-red">*</span>音乐热度
            </label>
            <div class="layui-input-inline">
                <input type="text" id="music_hot" name="music_hot"  required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="music_image" class="layui-form-label">
                <span class="x-red">*</span>音乐图片
            </label>
            <div class="layui-input-inline">
                <input type="text" value="${music.music_image}" id="music_image0" class="layui-input" placeholder="请选择图片文件" disabled/>
                <input type="file" id="music_image" name="music_image"
                       autocomplete="off" class="layui-input" value="" style="display:none">
                <img src="${pageContext.request.contextPath}/ShowImage?picName=${music.music_image}" id="music_image2" style="width: 20rem;height: 15rem;">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="music_music" class="layui-form-label">
                <span class="x-red">*</span>音乐文件
            </label>
            <div class="layui-input-inline">
                <input type="text" value="${music.music_music}" id="music_music0" class="layui-input" placeholder="请选择音乐文件" disabled/>
                <input type="file" id="music_music" name="music_music"  required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="" style="display:none">

                <audio id="music_music2" src="${pageContext.request.contextPath}/ShowMusic?sicName=${music.music_music}" controls loop preload: auto></audio>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="music_author_id" class="layui-form-label">
                <span class="x-red">*</span>音乐作者
            </label>
            <div class="layui-input-inline" >
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
            <div class="layui-input-inline" >
            <select name="music_type" id="music_type">
                <option value="">音乐分类</option>
                <option value=0>暂无类型</option>
                <option value=1>流行歌曲</option>
                <option value=2>KTV歌曲</option>
                <option value=3>励志歌曲</option>
                <option value=4>伤感歌曲</option>
                <option value=5>其他歌曲</option>
            </select>
            </div>
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

    <button  class="layui-btn" lay-filter="add" lay-submit="">
        修改
    </button>
</div>
</form>
</div>
<script>
    $("#music_image2").click(function() {
        $("#music_image").trigger("click");
    });
    $("#music_music2").click(function() {
        $("#music_music").trigger("click");
    });
    $("#music_image").change(function(){
        var x = document.getElementById("music_image").files;
        $("#music_image0").val(x[0].name);
        var objUrl = getObjectURL(this.files[0]) ;//获取文件信息
        var music_image=document.getElementById("music_image").value;
        if(!/.(gif|jpg|jpeg|png|GIF|JPG|bmp|PNG)$/.test(music_image)){
            alert("图片类型必须是.gif,jpeg,jpg,png,bmp中的一种");
            var obj = document.getElementById('music_image') ;
        }
        console.log("objUrl = "+objUrl);
        if (objUrl) {
            $("#music_image2").attr("src", objUrl);
        }
    }) ;
    $("#music_music").change(function(){
        var x = document.getElementById("music_music").files;
        $("#music_music0").val(x[0].name);
        var objUrl = getObjectURL(this.files[0]) ;//获取文件信息
        var music_music=document.getElementById("music_music").value;
        if(!/.(aif|aiff|mp3|mp1)$/.test(music_music)){
            alert("音乐类型必须是aif，aiff，mp3，mp1中的一种");
            var obj = document.getElementById('music_music') ;
        }
        console.log("objUrl = "+objUrl);
        if (objUrl) {
            $("#music_music2").attr("src", objUrl);
        }
    });
    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL!=undefined) {
            url = window.createObjectURL(file) ;
        }
        else if (window.URL!=undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } else if (window.webkitURL!=undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file) ;
        }
        return url ;
    }
        $.ajax({
            type:"get",
            url:"<%=basePath%>musicselect2/"+${music.music_id},
            dataType : "json",
            contentType : "application/json;charset=UTF-8",
            success:function(data) {
                $("#music_id").val(data.music_id);
                $("#music_name").val(data.music_name);
                $("#music_collect").val(data.music_collect);
                $("#music_hot").val(data.music_hot);
                $("#music_type").val(data.music_type);
                <%--$("#music_music2").attr("src",<%=basePath%>ShowImage?sicName=music_music);--%>
                <%--$("#music_image2").attr("src",i+data.music_image);--%>
                $("#music_author_id").val(data.music_author_id);

            }});
    $('.layui-btn').click(function() {
        var music_name=document.getElementById("music_name").value;
        var music_author_id=document.getElementById("music_author_id").value;
        var music_image=document.getElementById("music_image").value;
        var music_music=document.getElementById("music_music").value;
        var music_type=$('#music_type').val();
            if(music_name== ""){
                alert("请填写音乐名");
                return false;
            }

            if(music_image == "" || music_image.length == 0||music_music==""||music_music.length==0){
                alert("请选择文件");
                return false;
            }
        if(music_author_id==" "||music_author_id==""||music_author_id.length==0){
            alert("请选择作者");
            return false;
        }
        if(music_type==" "||music_type==""||music_type.length==0){
            alert("请选择类型");
            return false;
        }
            if(!/.(gif|jpg|jpeg|png|GIF|JPG|bmp|PNG)$/.test(music_image)){
                 alert("图片类型必须是.gif,jpeg,jpg,png,bmp中的一种");
                 return false;
            }
           if(!/.(aif|aiff|mp3|mp1)$/.test(music_music)){
            alert("音乐类型必须是aif，aiff，mp3，mp1中的一种");
            return false;
           }
           alert("修改成功");
           return true;
    });
    <%--$('.layui-btn').click(function(){--%>
        <%--var music_name=$("#musicname").val();--%>
        <%--var music_author=$("#musicauthor").val();--%>
        <%--var music_image=$('#musicimage').val();--%>
        <%--var music_music=$('#musicfile').val();--%>

        <%--$.ajax({--%>
            <%--//地址--%>

            <%--url :"${pageContext.request.contextPath}/upload/",--%>
            <%--//提交方式--%>
            <%--type : "POST",--%>
            <%--fileElementId:['music_image','music_music'],--%>
            <%--// data : JSON.stringify({music_image:music_image,music_author:music_author,music_name:music_name,music_music:music_music}),--%>
            <%--dataType: 'json',--%>
            <%--data: {--%>
                <%--music_name:music_name,--%>
                <%--music_author:music_author,--%>
                <%--music_image:music_image,--%>
                <%--music_music:music_music--%>
            <%--},--%>
            <%--cache: false,   //上传文件无需缓存--%>
            <%--processData: false,   // 用于对参数进行序列化处理，这里必须设为false--%>

            <%--//发送请求时所传递的参数--%>
            <%--//返回的数据使用json--%>
            <%--dataType : "json",--%>
            <%--contentType:false,--%>
            <%--//成功--%>
            <%--success : function(data){--%>

                <%--if(data == 1){--%>
                    <%--alert("成功");--%>

                    <%--//console.log("用户名为："+data.username+"，密码为："+data.password);--%>
                <%--}--%>
                <%--else {--%>
                    <%--alert("请检查");--%>
                    <%--return;--%>
                <%--}--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
    // layui.use(['form','layer'], function(){
    //     $ = layui.jquery;
    //     var form = layui.form
    //         ,layer = layui.layer;
    //
    //     //自定义验证规则
    //     form.verify({
    //         nikename: function(value){
    //             if(value.length < 5){
    //                 return '昵称至少得5个字符啊';
    //             }
    //         }
    //         ,pass: [/(.+){6,12}$/, '密码必须6到12位']
    //         ,repass: function(value){
    //             if($('#L_pass').val()!=$('#L_repass').val()){
    //                 return '两次密码不一致';
    //             }
    //         }
    //     });
    //
    //     //监听提交
    //     form.on('submit(add)', function(data){
    //         console.log(data);
    //         //发异步，把数据提交给php
    //         layer.alert("增加成功", {icon: 6},function () {
    //             // 获得frame索引
    //             var index = parent.layer.getFrameIndex(window.name);
    //             //关闭当前frame
    //             parent.layer.close(index);
    //         });
    //         return false;
    //     });
    //
    // });
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>