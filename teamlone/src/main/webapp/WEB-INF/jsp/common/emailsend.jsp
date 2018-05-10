<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>学员管理</title>

		<meta charset="UTF-8">
		<title>个人信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
 
		<link rel="stylesheet" type="text/css" href="/comm/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="/comm/bootstrap/css/bootstrap.css" media="all">
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="/comm/global.css" media="all">
		<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
		<script src="/js/jquery-3.0.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
     
     	
     </head>
	<script type="text/javascript">
	</script>

	<body>
		<section class="layui-larry-box">
			<div class="larry-personal">
				<div class="layui-tab">
					<blockquote class="layui-elem-quote news_search">
					<form action="/admin/email/list" method="post">
						<table  class="layui-table table-hover" lay-even="" lay-skin="nob" >
							<tr>
								<td><input type="text" id="email" name="email"  class="form-control" placeholder="邮箱" style="width: 160px"/></td>
									
								<td>
									<select class="form-control"style="width: 150px; " id="type" name="type">
										<option value="0">选择类型</option>
										<option value="1">普通</option>
										<option value="2">定时</option>
									
									</select>
								</td>
					
									<td>
								
									<select class="form-control"style="width: 150px;"id="status" name="status" >
										<option value="0">选择是否发送</option>
										<option value="1">已发送</option>
										<option value="2">未发送</option>
							               
									</select>
								</td>
								<td>发送时间:</td>
								<td><input type="text" name="start" id="start"  class="form-control" style="width: 160px"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /> </td>	
								<td>结束时间:</td>
								   <td><input type="text"  name="end" id="end"  class="form-control" style="width: 160px"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />   </td>
								<td><button type="submit" class="btn btn-info">查询</button></td>
								<td><button type="button" class="btn btn-info" onclick="">清空</button></td>
							</tr>

						</table></form>
					</blockquote>

					<div class="layui-tab-content larry-personal-body clearfix mylog-info-box">
						<!-- 操作日志 -->
						<div class="layui-tab-item layui-field-box layui-show">
							<form action="" method="post">
								<table class="layui-table table-hover" lay-even="" lay-skin="nob" id="mytab" name="mytab">

									<thead>
										<tr>
											<th>ID</th>
											<th>邮箱类型</th>
											<th>是否发送</th>
											<th>邮件标题</th>
											<th>邮箱</th>
											<th>创建时间</th>
											<th>发送时间</th>
											<th>操作人</th>
											<th>操作</th>
										</tr>
									</thead>
										<tbody id="t1" name="t1">
											<c:forEach items="${list}" var="p" varStatus="stea">
												<tr>
										
													<th>${p.id}</th>
													<th><c:if test="${p.type==1}">普通</c:if>
													<c:if test="${p.type==2}">定时</c:if></th>
													<th><c:if test="${p.status==1}">已发送</c:if>
									                <c:if test="${p.status==2}">未发送</c:if></th>
													<th>${p.title}</th>
													<th>${p.email}</th>
													<th><fmt:formatDate value="${p.create_time}" type="date" pattern="yyyy-MM-dd hh:mm:ss"/></th>
													<th><fmt:formatDate value="${p.send_time}" type="date" pattern="yyyy-MM-dd hh:mm:ss"/></th>
													<th>${p.user_id.user_name}</th>
													<th>
														<a href="/admin/email/initId/${p.id}" class="layui-btn" >查看</a>
													</th>
												</tr>
											</c:forEach>
										</tbody>
								</table>
						</div>
						<!-- 登录日志 -->
						<div class="layui-tab-item layui-field-box ">
							<table class="layui-table table-hover " lay-even=" " lay-skin="nob ">
								<thead>
									<tr>
										<th><input type="checkbox " id="selected-all "></th>
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
										<td><input type="checkbox "></td>
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
							<div class="larry-table-page clearfix ">
								<a href="javascript:; " class="layui-btn layui-btn-small "><i class="iconfont icon-shanchu1 "></i>删除</a>
								<div id="page2 " class="page "></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<script type="text/javascript " src="/comm/layui/layui.js "></script>
		
		<script type="text/javascript ">
			var tid = document.getElementById("tid ");
			tid.value = '${tid}';
		</script>
	</body>

</html>