<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>文章列表</title>
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
<script src="/js/jquery-1.7.2.min.js" type="text/javascript"
	charset="utf-8"></script>
</head>
<script type="text/javascript">

</script>
<body>
	<section class="layui-larry-box ">
	<div class="larry-personal">
		<form action="" method="post">
			<div class="layui-tab ">
				<blockquote class="layui-elem-quote news_search">
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input value="${qname}" name="qname" id="qname"
								placeholder="标题/读者/来源" class="layui-input search_input"
								type="text">
						</div>
						<td>创建时间： <input style="height: 36px" type="date" placeholder="开始创建时间" /> - <input style="height: 36px" type="date" placeholder="结束创建时间" /> </td>

						
						<a class="layui-btn search_btn" onclick="findAll()">🔎 查询</a>
					</div>
					<div class="layui-inline">
						<a class="layui-btn layui-btn-normal newsAdd_btn"
							href="/pbrandtype/listpt">Θ 清空</a>
					</div>
					<div class="layui-inline">
						<a class="layui-btn layui-btn-danger newsAdd_btn">批量删除</a>
					</div>
					<div class="layui-inline">
						<a class="layui-btn layui-btn-danger newsAdd_btn" href="/admin/essaysadd">添加文章</a>
					</div>
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
								<th style="text-align: center;">标题</th>
								<th>作者</th>
								<th>来源</th>
								<th>类型</th>
								<th>创建时间</th>
								<th>发布时间</th>
								<th>点击量</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${list}" var="a" varStatus="stea">
								<tr>
									<td><input type="checkbox"></td>
									<th>${a.title}</th>
									<th>${a.author}</th>
									<th>${a.source}</th>
									<th>
									<c:if test="${a.article_type eq 2}">
   										   文章
									</c:if>
									</th>
									<th><fmt:formatDate value="${a.create_time}" pattern="yyyy/MM/dd HH:mm"/></th>
									<th> 
									<c:if test="${empty a.publish_time}">
									未发布
									</c:if>
									<c:if test="${not empty a.publish_time}">
									<fmt:formatDate value="${a.publish_time}" pattern="yyyy/MM/dd HH:mm"/>
									</c:if>
									</th>
									<th>${a.click_num}</th>
							 	<th>
							 	
							 	
							 	
							 	<c:if test="${empty a.publish_time}">
							 	
							 	<a onclick="funupbl(${a.article_id})"
										class="layui-btn layui-btn-danger"><i class="layui-icon">现在发布</i></a>
									</c:if>
									
								<c:if test="${not empty a.publish_time}">
								<a onclick="funnoupbl(${a.article_id})"
										class="layui-btn layui-btn-danger"><i class="layui-icon">取消发布</i></a>
									</c:if>
							 	
							 	<button class="layui-btn layui-btn-sm" type="button"
										onclick="funct(${a.article_id})">
						 					<i class="layui-icon">&#xe640;</i>
										</button>
										<a onclick="funcp(${a.article_id})"
										class="layui-btn layui-btn-normal"><i class="layui-icon">&#xe642;</i></a>
										
										
										
										</th>
								</tr>
							</c:forEach>
						</thead>
					</table>
					   <div class="larry-table-page clearfix">
                          <a href="javascript:;" class="layui-btn layui-btn-small"><i class="iconfont icon-shanchu1"></i>删除</a>
				          <div id="page" class="page"></div>
			         </div>
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
		</form>
		<div class="larry-table-page clearfix">
			<a href="javascript:;" class="layui-btn layui-btn-small"><i
				class="iconfont icon-shanchu1"></i>删除</a>
			<div id="page2" class="page"></div>
		</div>
	</div>
	</div>
	</div>
	</div>
	</section>
	<script type="text/javascript" src="/comm/layui/layui.js"></script>
	<script type="text/javascript">
	
	
	function funct(article_id) {  
		var msg = "您真的确定要删除吗？\n\n请确认！";
		if (confirm(msg)){
			window.location.href = "/admin/deletearticle/"+article_id;
			}
	} 
	
	
	function funcp(article_id){
		window.location.href = "/admin/artcleupdate/"+article_id;
	}
	
	function funupbl(article_id){
		window.location.href = "/admin/publish/"+article_id;
	}
	
	function funnoupbl(article_id){
		window.location.href = "/admin/nopublish/"+article_id;
	}
	
	   layui.use(['jquery','layer','element','laypage'],function(){
		      window.jQuery = window.$ = layui.jquery;
		      window.layer = layui.layer;
	       var element = layui.element(),
	           laypage = layui.laypage;
	        laypage({
						cont: 'page',
						pages: '${tc.pages}', //总页数
						curr:'${tc.pageNum}',
						groups: 5, //连续显示分页数
						jump: function(obj, first) {
							//得到了当前页，用于向服务端请求对应数据
							var curr = obj.curr;
							if(!first) {
								document.forms[0].action="/admin/teacher?page="+curr;
								document.forms[0].submit();
							}
						}
					});
	 });
</script>
</body>
</html>