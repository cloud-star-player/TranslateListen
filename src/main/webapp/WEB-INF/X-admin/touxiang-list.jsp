<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,music-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
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
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加图片','${pageContext.request.contextPath}/totouxiangadd')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${list.getTotal()}条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>TouXiang编号</th>
            <th>图片</th>
            <th>上传(修改)时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list.list}" var="cod" varStatus="s">
            <tr>
                <td>
                    <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${cod.touxiang_id}'><i class="layui-icon">&#xe605;</i></div>
                </td>
                <td>${cod.touxiang_id}</td>
                <td><img src="${pageContext.request.contextPath}/TouXiangShowImage?picName=${cod.touxiang_image}" class="tupian"></td>
                <td><fmt:formatDate value="${cod.touxiang_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td class="td-status">

                    <c:if test="${cod.touxiang_state==1}">
                    <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>
                    </c:if>
                     <c:if test="${cod.touxiang_state==0}">
                        <span class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled">已停用</span>
                     </c:if>

                </td>
                <td class="td-manage">
                    <c:if test="${cod.touxiang_state==1}">
                        <a onclick="member_stop(this,'${cod.touxiang_id}')" href="javascript:;"  title="启用">
                            <i class="layui-icon">&#xe601;</i>
                    </a>
                    </c:if>
                    <c:if test="${cod.touxiang_state==0}">
                        <a onclick="member_stop(this,'${cod.touxiang_id}')" href="javascript:;"  title="停用">

                            <i class="layui-icon">&#xe62f;</i>
                        </a>
                    </c:if>
                    <a onclick="x_admin_show('修改','${pageContext.request.contextPath}/touxiangselect/${cod.touxiang_id}',1000,600)" title="修改图片" href="javascript:;">
                        <i class="layui-icon">&#xe631;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'${cod.touxiang_id}')" href="javascript:;" class=".u">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <c:if test="${list.pageNum!=1}">
                <a class="prev" href="${pageContext.request.contextPath}/touxiangall?pn=1">首页</a>
                <a class="prev" href="${pageContext.request.contextPath}/touxiangall?pn=${list.pageNum-1}">&lt;&lt;</a>
            </c:if>
            <c:forEach items="${list.navigatepageNums }" var="num">
                <c:if test="${num==list.pageNum }">
                    <span class="current">${num}</span>
                </c:if>
                <c:if test="${num !=list.pageNum }">
                    <a class="num" href="${pageContext.request.contextPath}/touxiangall?pn=${num}">${num}</a>
                </c:if>
            </c:forEach>
            <c:if test="${list.pageNum!=list.pages}">
                <a class="prev" href="${pageContext.request.contextPath}/touxiangall?pn=${list.pageNum+1}">&gt;&gt;</a>
                <a class="prev" href="${pageContext.request.contextPath}/touxiangall?pn=${list.pageSize}">尾页</a>
            </c:if>

        </div>
    </div>

</div>
<script>
    /*用户-删除*/
    function member_del(obj,touxiang_id){
        var touxiang_id=parseInt(touxiang_id);
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $.ajax({
                //地址
                url :"${pageContext.request.contextPath}/touxiangdeletefyid/"+touxiang_id,
                //提交方式
                type : "POST",

                //发送请求时所传递的参数
                //返回的数据使用json
                dataType : "json",
                contentType : "application/json;charset=UTF-8",
                //成功
                success : function(data){

                    if(data == 1){
                        layer.msg('已删除!',{icon:1,time:1000});
                        location.href = "${pageContext.request.contextPath}/touxiangall?pn=${list.pageNum}";
                        //console.log("用户名为："+data.touxiangname+"，密码为："+data.password);
                    }
                    else {
                        layer.msg('请检查!',{icon:1,time:1000});
                        return;
                    }
                }
            });
            $(obj).parents("tr").remove();
        });
    }



    function delAll (argument) {

        var datas = tableCheck.getData();
        var arr = [];
        for (var i in datas) {
            arr.push(parseInt(datas[i]));
        }
        console.log(arr);
        layer.confirm('确认要删除吗？'+datas,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            if(arr==null||arr=='') {
                layer.msg('没有选择删除数据', {icon: 0});
                return;
            }
            $(".layui-form-checked").not('.header').parents('tr').remove();
            $.ajax({
                //地址
                url :"${pageContext.request.contextPath}/touxiangdelectall/"+arr,
                //提交方式
                type : "POST",
                data : JSON.stringify({list:arr}),
                //发送请求时所传递的参数
                //返回的数据使用json
                dataType : "json",
                contentType : "application/json;charset=UTF-8",
                //成功
                success : function(data){
                    if(data >= 1){
                        location.href = "${pageContext.request.contextPath}/touxiangall?pn=${list.pageNum}";
                        //console.log("用户名为："+data.touxiangname+"，密码为："+data.password);
                    }
                    else {
                        alert("请检查");
                        return;
                    }
                }
            });
        });

    }
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    /*用户-停用*/
    function member_stop(obj,touxiang_id){
        var touxiang_state;
        layer.confirm('确认要停用(启用)吗？',function(index){
            if($(obj).attr('title')=='启用'){
                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');
                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});
                touxiang_state=0;

            }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');
                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
                touxiang_state=1;
            }
            $.ajax({
                //地址
                url :"${pageContext.request.contextPath}/touxiangupdatesta/"+touxiang_id+"/"+touxiang_state,
                //提交方式
                type : "POST",

                //发送请求时所传递的参数
                //返回的数据使用json
                dataType : "json",
                contentType : "application/json;charset=UTF-8",
                //成功
                success : function(data){

                }
            });

        });
    }

    /*用户-删除*/



</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>