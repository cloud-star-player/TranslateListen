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
    <form class="layui-form" action="${pageContext.request.contextPath }/Bannerupload" enctype="multipart/form-data" method="post">
        <div class="layui-form-item">
            <label for="banner_name" class="layui-form-label">
                <span class="x-red">*</span>Banner名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="banner_name" name="banner_name"  required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="banner_image" class="layui-form-label">
                <span class="x-red">*</span>Banner图片
            </label>
            <div class="layui-input-inline">
                <input type="file" id="banner_image" name="banner_image"  required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
                <img src="" id="banner_image2" style="width: 20rem;height: 15rem;">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="banner_weizhi" class="layui-form-label">
                <span class="x-red">*</span>Banner位置
            </label>
            <div class="layui-input-inline">
                <input type="text" id="banner_weizhi" name="banner_weizhi"  required="" lay-verify="phone"
                       autocomplete="off" class="layui-input" onkeyup="this.value=this.value.replace(/\D/g,'')"
                       onafterpaste="this.value=this.value.replace(/\D/g,'')">
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
        增加
    </button>
</div>
</form>
</div>
<script>
    $("#banner_image").change(function(){
        var objUrl = getObjectURL(this.files[0]) ;//获取文件信息
        var banner_image=document.getElementById("banner_image").value;
        if(!/.(gif|jpg|jpeg|png|GIF|JPG|bmp|PNG)$/.test(banner_image)){
            alert("图片类型必须是.gif,jpeg,jpg,png,bmp中的一种");
            var obj = document.getElementById('banner_image') ;
        }
        console.log("objUrl = "+objUrl);
        if (objUrl) {
            $("#banner_image2").attr("src", objUrl);
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
    //设置防止输入错误类型
    $("#weizhi").keyup(function(){  //keyup事件处理
        $(this).val($(this).val().replace(/\D|^0/g,''));
    }).bind("paste",function(){  //CTR+V事件处理
        $(this).val($(this).val().replace(/\D|^0/g,''));
    }).css("ime-mode", "disabled");  //CSS设置输入法不可用
    $('#fenlei').css("margin-left","9.2rem");
    $('#banner_weizhi').change(function(){
        var banner_weizhi = document.getElementById("banner_weizhi").value;
        $.ajax({
            //地址

            url: "/weizhi/"+banner_weizhi,
            //提交方式
            type: "POST",
            //发送请求时所传递的参数
            //返回的数据使用json
            dataType: "json",
            //成功
            success: function (data) {
                if (data == 1) {
                    alert("添加位置时请不要写与其他图片相冲突的位置");
                    return false;
                }else{
                    return true;
                }
            }
        });
    })
    $('.layui-btn').click(function() {
        var banner_name = document.getElementById("banner_name").value;
        var banner_image = document.getElementById("banner_image").value;
        var banner_weizhi = document.getElementById("banner_weizhi").value;
        if (banner_name == "") {
            alert("请填写Banner名");
            return false;
        }
        if (banner_image == "" || banner_image.length == 0) {
            alert("请选择文件");
            return false;
        }
        if (banner_weizhi == "") {
            alert("请填写Banner位置");
            return false;
        }
        if (banner_weizhi <= 0) {
            alert("位置不能小于等于0");
            return false;
        }


        if (!/.(gif|jpg|jpeg|png|GIF|JPG|bmp|PNG)$/.test(banner_image)) {
            alert("图片类型必须是.gif,jpeg,jpg,png,bmp中的一种");
            return false;
        }
    });
    <%--$('.layui-btn').click(function(){--%>
        <%--var banner_name=$("#bannername").val();--%>
        <%--var banner_author=$("#bannerauthor").val();--%>
        <%--var banner_image=$('#bannerimage').val();--%>
        <%--var banner_banner=$('#bannerfile').val();--%>

        <%--$.ajax({--%>
            <%--//地址--%>

            <%--url :"${pageContext.request.contextPath}/upload/",--%>
            <%--//提交方式--%>
            <%--type : "POST",--%>
            <%--fileElementId:['banner_image','banner_banner'],--%>
            <%--// data : JSON.stringify({banner_image:banner_image,banner_author:banner_author,banner_name:banner_name,banner_banner:banner_banner}),--%>
            <%--dataType: 'json',--%>
            <%--data: {--%>
                <%--banner_name:banner_name,--%>
                <%--banner_author:banner_author,--%>
                <%--banner_image:banner_image,--%>
                <%--banner_banner:banner_banner--%>
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