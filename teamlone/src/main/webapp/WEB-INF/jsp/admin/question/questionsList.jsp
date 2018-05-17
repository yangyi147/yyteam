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
            content: '<div style="color:#767676">确定删除所有内容吗</div>',  
            btn: ['确定', '取消'],  
            shadeClose: true,  
            //回调函数  
            yes: function(index, layero){  
            	window.location.href="/admin/questions/delete/"+a;  
            },  
            btn2: function(index, layero){  
            },  
            cancel: function(index,layero){  
            },  
    });   
} 

$("#is_best").val("${is_best}");
$("#question_id").val("${question_id}");
function update(id,is_best){
	 if(is_best==0){
		 location.href = "/admin/questions_comment/update/"+id;
	 }else{
		alert("已经采纳为最佳！"); 
	 }	  
}

$(function(){
	$("#btn").click(function(){
		 document.forms[0].action="/admin/questions/listAll";
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
						<form action="" method="post">
							<label class="layui-form-label">标题</label>
							<div class="layui-input-inline">
								<input name="title" value="${title}"  class="layui-input"
									type="text">
							</div>
							<label class="layui-inline">问答标签:</label>
							<div class="layui-input-inline">
								<select class="layui-input" name="type" id="type">
									<option value="-1">全选</option>
									<option value="1">课程问答</option>
									<option value="2">学习分享</option>
								</select>
							</div>
							<div class="layui-input-inline">
								<label class="layui-inline">开始时间:</label>
								<div class="layui-input-inline">
									<input class="Wdate layui-input" type="text" name="start"
										onClick="WdatePicker()" value="${start}" />
								</div>
							</div>
							<div class="layui-input-inline">
								<label class="layui-inline">结束时间:</label>
								<div class="layui-input-inline">
									<input class="Wdate layui-input" type="text" name="end"
										onClick="WdatePicker()"  value="${end }"/>
								</div>
							</div>
					</div>
					<button type="button" class="layui-btn search_btn" id="btn">查询</button>
				</blockquote>
			</div>
			<table class="layui-table">
				<colgroup>
					<col width="2%">
					<col width="7%">
					<col width="10%">
					<col width="3%">
					<col width="3%">
					<col width="3%">
					<col width="3%">
					<col width="7%">
					<col width="14%">
				</colgroup>
				<tr>
					<td>ID</td>
					<td>发表人</td>
					<td>问答标题</td>
					<td>类型</td>
					<td>回复数</td>
					<td>浏览数</td>
					<td>点赞数</td>
					<td>添加时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${page.list }" var="q">
					<tr>
						<td>${q.id }</td>
						<td>${q.edu_user.email }</td>
						<td>${q.title }</td>
						<td><c:if test="${q.type==1 }">
					课程问答
				</c:if> <c:if test="${q.type==2 }">
					学习分享
				</c:if></td>
						<td>${q.reply_count }</td>
						<td>${q.browse_count }</td>
						<td>${q.praise_count }</td>
						<td><fmt:formatDate value="${q.add_time }" type="date"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td><a class="layui-btn layui-btn-sm layui-btn-normal"
							href="javascript:;"  onclick="fun(${q.id})"> <i
								class="layui-icon"></i>
						</a>
							<a class="layui-btn layui-btn-xs"
								href="/admin/questions_comment/getById1/${q.id }">查看回复</a></td>
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
						pages:'${page.pages}', //总页数
						curr:'${page.pageNum}',
						groups: 5, //连续显示分页数
						jump: function(obj, first) {
							//得到了当前页，用于向服务端请求对应数据
							var curr = obj.curr;
							if(!first) {
								document.forms[0].action="/admin/questions/listAll?page="+curr;
								document.forms[0].submit();
							}
						}
					});
	 });
	   $("#type").val("${type}");
</script>
</body>
</html>