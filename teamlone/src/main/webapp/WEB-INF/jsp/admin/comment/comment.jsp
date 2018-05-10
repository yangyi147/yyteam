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
	<script language="javascript" type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>
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
            	window.location.href='/admin/delCo/'+a;  
            },  
            btn2: function(index, layero){  
            },  
            cancel: function(index,layero){  
            },  
    });   
} 
function find(){
	document.forms[0].action="/admin/comment";
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
							<input value="${qemail}" name="qemail" id="qemail"
								placeholder="请输入邮箱" class="layui-input search_input"
								type="text">
						</div>
						<div class="layui-input-inline">
							<input value="${qname}" name="qname" id="qname"
								placeholder="请输入评论内容" class="layui-input search_input"
								type="text">
						</div>
						<div class="layui-inline">
							<select name="qtype" class="layui-select" id="sel">
								<option value="">请选状态</option>
								<option value="1">文章</option>
								<option value="2">课程</option>
							</select>
						</div>
						<div class="layui-input-inline">
				<label class="layui-inline">开始时间:</label>
				<div class="layui-input-inline">
					<input class="Wdate layui-input " type="text" onClick="WdatePicker()" name="startdate" value="${startdate}">
				</div>
						</div>
							<div class="layui-input-inline">
				<label class="layui-inline">结束时间:</label>
				<div class="layui-input-inline">
					<input class="Wdate layui-input " type="text" onClick="WdatePicker()" name="stopdate" value="${stopdate}">
				</div>
						</div>
						<a class="layui-btn search_btn" onclick="find()">查询</a>
					</div>
				</blockquote>
				<div
					class="layui-tab-content larry-personal-body clearfix mylog-info-box">
					<!-- 操作日志 -->
					<div class="layui-tab-item layui-field-box layui-show">
						<table class="layui-table table-hover" lay-even="" lay-skin="nob"
							id="tab">
							<thead>
								<tr>
									<th><input type="checkbox" id="selected-all"></th>
									<th>ID</th>
									<th>邮箱</th>
									<th>评论内容</th>
									<th>类型</th>
									<th>点赞</th>
									<th>回复</th>
									<th>创建时间</th>
									<th>删除</th>
								</tr>
								<c:forEach items="${tc.list}" var="p" varStatus="stea">
									<tr>
										<td><input type="checkbox"></td>
										<th>${stea.index+1 }</th>
										<th>${p.users_id.email}</th>
										<th width="400px">${p.content}</th>
										<th >${p.type}</th>
										<th >${p.praise_count}</th>
										<th >${p.reply_count}</th>
										<th><fmt:formatDate value="${p.addtime}"
												pattern="yyyy/MM/dd HH:mm" /></th>
											<th><button class="layui-btn layui-btn-sm" type="button"
												onclick="fun(${p.comment_id})">
												<i class="layui-icon">&#xe640;</i>
											</button></th>
									</tr>
								</c:forEach>
							</thead>
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
						pages:'${tc.pages}', //总页数
						curr:'${tc.pageNum}',
						groups: 5, //连续显示分页数
						jump: function(obj, first) {
							//得到了当前页，用于向服务端请求对应数据
							var curr = obj.curr;
							if(!first) {
								document.forms[0].action="/admin/comment?page="+curr;
								document.forms[0].submit();
							}
						}
					});
	 });
	   var a='${qtype}';
	   if(a!=''){
		   $("#sel").val('${qtype}');
		   }
</script>
</body>
</html>