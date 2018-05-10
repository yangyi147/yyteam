<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css" href="/comm/layui/css/layui.css"
	media="all">
<link rel="stylesheet" type="text/css"
	href="/comm/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/comm/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<script src="/js/jquery-3.0.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script language="javascript" type="text/javascript"
	src="/My97DatePicker/WdatePicker.js"></script>
	</head>
<script type="text/javascript">
function fun(a) {   
    layer.open({  
            title: ['温馨提示'],  
            content: '<div style="color:#767676">确定删除吗</div>',  
            btn: ['确定', '取消'],  
            shadeClose: true,  
            //回调函数  
            yes: function(index, layero){  
            	window.location.href='/admin/delImg/'+a;  
            },  
            btn2: function(index, layero){  
            },  
            cancel: function(index,layero){  
            },  
    });   
} 

$(function(){
	$("#btn").click(function(){
		 document.forms[0].action="/admin/questions_tag/save";
		document.forms[0].submit();
	});
});
</script>
<body>
	<section class="layui-larry-box ">
	<div class="larry-personal">
		<form action="" method="post">
			<div class="layui-tab ">
				<blockquote class="layui-elem-quote news_search">
					<div class="layui-inline">
			<label>问答标签</label>
			<div class="layui-input-inline">
				<input name="questions_tag_name"  class="layui-input"
					type="text">
			</div>
			<input type="hidden" name="status" value="0" />
			<input type="hidden" name="parent_id" value="0" />
			<button class="layui-btn" type="button" id="btn">添加</button>
				</blockquote>
				<div
					class="layui-tab-content larry-personal-body clearfix mylog-info-box">
					<!-- 操作日志 -->
					<div class="layui-tab-item layui-field-box layui-show">
				<table class="layui-table">
		<colgroup>
			<col width="5%">
			<col width="14%">
		</colgroup>
		<c:forEach items="${tags }" var="t">
			<tr>
				<td>${t.questions_tag_name }</td>
				<td><a class="layui-btn layui-btn-sm layui-btn-normal"
						href="/admin/questions_tag/updateStatus/${t.questions_tag_id }">
						<i class="layui-icon"></i>
					</a>
					<a class="layui-btn layui-btn-xs" href="/admin/questions_tag/init/${t.questions_tag_id }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
				</div>
				<div class="larry-table-page clearfix">
					<div id="page" class="page"></div>
				</div>
			</div>
		</form>
	</div>
	</section>
	<script type="text/javascript" src="/comm/layui/layui.js"></script>
	<script type="text/javascript">
	   layui.use(['jquery','layer','element','laypage'],function(){
		      window.jQuery = window.$ = layui.jquery;
		      window.layer = layui.layer;
	       var element = layui.element(),
	           laypage = layui.laypage;
	        laypage({
						cont:'page',
						pages:'${page.pages}', //总页数
						curr:'${page.pageNum}',
						groups: 5, //连续显示分页数
						jump: function(obj, first) {
							//得到了当前页，用于向服务端请求对应数据
							var curr = obj.curr;
							if(!first) {
								document.forms[0].action="/admin/questions_tag/listAll?page="+curr;
								document.forms[0].submit();
							}
						}
					});
	 });
</script>
</body>
</html>