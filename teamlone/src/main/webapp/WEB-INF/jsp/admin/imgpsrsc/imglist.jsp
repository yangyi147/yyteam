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
function find(){
	document.forms[0].action="/admin/imglist";
	document.forms[0].submit();
}
</script>
<body>
	<section class="layui-larry-box ">
	<div class="larry-personal">
		<form action="" method="post">
			<div class="layui-tab ">
				<blockquote class="layui-elem-quote news_search">
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input value="${title}" name="title" 
								placeholder="请输入图片标题" class="layui-input search_input" type="text">
						</div>
						<div class="layui-input-inline">
							<input value="${desc}" name="desc" 
								placeholder="请输入图片描述内容" class="layui-input search_input"
								type="text">
						</div>
						<div class="layui-inline">
							<select name="type_id" class="layui-select" id="sel">
							<option value="-1">请选择</option>
							<c:forEach items="${ty}" var="ty">
								<option value="${ty.type_id }">${ty.type_name}</option>
							</c:forEach>
						</select>
						</div>
						<a class="layui-btn search_btn" onclick="find()">查询</a>
						<div class="layui-inline">
							<a class="layui-btn layui-btn-normal newsAdd_btn"
								href="/admin/img/insert">添加图片</a>
						</div>
					</div>
				</blockquote>
				<div
					class="layui-tab-content larry-personal-body clearfix mylog-info-box">
					<!-- 操作日志 -->
					<div class="layui-tab-item layui-field-box layui-show">
						<table  class="layui-table table-hover" lay-even="" lay-skin="nob"
							id="tab">
								<tr>
									<td>ID</td>
									<td>图片</td>
									<td>图片标题</td>
									<td>图片类型</td>
									<td>背景色</td>
									<td>图片描述</td>
									<td>删除</td>
									<td>修改</td>
								</tr>
								<c:forEach items="${tc.list}" var="p" varStatus="stea">
									<tr>
										<td >${stea.index+1 }</td>
										<td ><img src="/images/img/${p.image_url}" width="100" height="100" style="padding-top: 10px"/></td>
										<td >${p.title}</td>
										<td >${p.t_id.type_name}</td>
										<td >${p.color}</td>
										<td >${p.describes}</td>
										<td><button class="layui-btn layui-btn-sm" type="button"
												onclick="fun(${p.image_id})">
												<i class="layui-icon">&#xe640;</i>
											</button></td>
										<td><a href="/admin/getImg/${p.image_id}"
											class="layui-btn layui-btn-normal"><i class="layui-icon">&#xe642;</i></a></td>
									</tr>
								</c:forEach>
						</table>
					</div>
				</div>
				<!-- 登录日志 -->
				<div class="layui-tab-item layui-field-box">
					<table class="layui-table table-hover" lay-even="" lay-skin="nob">
						<thead>
							<tr>
								<th><input type="checkbox" id="selected-all"></th>
								<th>ID</th>
								<th>管理员账号</th>
								<th>状态</th>
								<th>最后登录时间</th>
								<th>上次登录IP</th>
								<th>登录IP</th>
								<th>IP所在位置</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox"></td>
								<td>110</td>
								<td>admin</td>
								<td>后台登录成功</td>
								<td>2016-12-19 14:26:03</td>
								<td>127.0.0.1</td>
								<td>127.0.0.1</td>
								<td>Unknown</td>
							</tr>
						</tbody>
					</table>
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
						pages:'${tc.pages}', //总页数
						curr:'${tc.pageNum}',
						groups: 5, //连续显示分页数
						jump: function(obj, first) {
							//得到了当前页，用于向服务端请求对应数据
							var curr = obj.curr;
							if(!first) {
								document.forms[0].action="/admin/imglist?page="+curr;
								document.forms[0].submit();
							}
						}
					});
	 });
	   var a='${type_id}';
	   if(a!=''){
		   $("#sel").val('${type_id}');
		   }
</script>
</body>
</html>