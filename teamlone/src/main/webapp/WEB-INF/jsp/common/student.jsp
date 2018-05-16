<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link rel="stylesheet" type="text/css" href="/comm/layui/css/layui.css"
	media="all">
<link rel="stylesheet" type="text/css"
	href="/comm/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/comm/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<script src="/js/jquery-3.0.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/bootstrap-table.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>

</head>
<script type="text/javascript">
		$("myModal").modal("hide");

		function xiugai(id) {
			$("#user_id").val(id);
		}
	
	</script>

<body>

	<form action="" method="post">
		<!--
                  修改模态框
            -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改用户密码</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<input type="hidden" name="user_id" id="user_id">
							<div class="form-group" style="height: 50px;">
								<label for="passwords" class="col-sm-2 control-label">密码：</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="passwords"
										name="passwords" style="width: 300px">
								</div>
							</div>
							<div class="form-group" style="height: 50px;">
								<label for="password" class="col-sm-2 control-label">确认密码：</label>
								<div class="col-sm-10">
									<input type="password" class="form-control"
										style="width: 300px" id="password" name="password">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" onclick="yangfan()">确定</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<section class="layui-larry-box">
	<div class="larry-personal">
		<div class="layui-tab">
			<blockquote class="layui-elem-quote news_search">
				<form action="/admin/users/list" method="post">
					<table class="layui-table table-hover" lay-even="" lay-skin="nob">
						<tr>
							<td><input type="text" id="pname" name="pname"
								class="form-control" value="" placeholder="邮箱/手机/姓名"
								style="width: 130px" /></td>
							<td><select class="form-control" style="width: 130px;"
								name="class_id" id="class_id">
									<option value="-1">请选择班级</option>
									<c:forEach items="${listc}" var="c" varStatus="stea">
										<option value="${c.id}">${c.cname}</option>
									</c:forEach>
							</select></td>
							<td><select class="form-control" style="width: 130px;"
								name="is_avalible" id="is_avalible">
									<option value="-1">请选择状态</option>
									<option value="1">正常</option>
									<option value="0">冻结</option>

							</select></td>
							<td>注册时间:</td>
							<td><input type="text" name="start" id="start"
								class="form-control" style="width: 150px"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								placeholder="开始注册时间" /></td>
							<td><input type="text" name="end" id="end"
								class="form-control" style="width: 150px"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
								placeholder="结束注册时间" /></td>
							<td><button type="submit" class="btn btn-info">查找学员</button></td>
							<td><button type="reset" class="btn btn-info">清空</button></td>
							<td><a href="/admin/users/getAction" class="btn btn-info">导出Excel</a></td>
						</tr>

					</table>
				</form>
			</blockquote>

			<div
				class="layui-tab-content larry-personal-body clearfix mylog-info-box">
				<!-- 操作日志 -->
				<div class="layui-tab-item layui-field-box layui-show">
					<form action="" method="post">
						<table class="layui-table table-hover" lay-even="" lay-skin="nob"
							id="mytab" name="mytab">
							<thead>
								<tr>
									<th>邮箱</th>
									<th>手机号</th>
									<th>用户名</th>
									<th>昵称</th>
									<th>性别</th>
									<th>年龄</th>
									<th>注册时间</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="t1" name="t1">
								<c:forEach items="${list}" var="p" varStatus="stea">
									<tr>
										<th>${p.email}</th>
										<th>${p.mobile}</th>
										<th>${p.user_name}</th>
										<th>${p.show_name}</th>
										<th><c:if test="${p.sex==1}">
														 男
													</c:if> <c:if test="${p.sex==0}">
														女
													</c:if></th>
										<th>${p.age}</th>
										<th><fmt:formatDate value="${p.create_time}" type="date"
												pattern="yyyy-MM-dd hh:mm:ss" /></th>
										<th><c:if test="${p.is_avalible==1}">
														正常
													</c:if> <c:if test="${p.is_avalible==0}">
														冻结
													</c:if></th>
										<th>
											<!-- Button trigger modal -->
											<button type="button" class="layui-btn" data-toggle="modal"
												onclick="xiugai(${p.user_id})" data-target="#myModal">
												修改密码</button> <c:if test="${p.is_avalible==1}">
												<a
													href="/admin/users/updateid/${p.user_id}/${p.is_avalible}"
													class="layui-btn layui-btn-primary">冻结</a>
											</c:if> <c:if test="${p.is_avalible==0}">
												<a
													href="/admin/users/updateid/${p.user_id}/${p.is_avalible}"
													class="layui-btn layui-btn-primary">解冻</a>
											</c:if>
										</th>
									</tr>
								</c:forEach>
							</tbody>


						</table>

						<table class="layui-table table-hover" lay-even="" lay-skin="nob">
							<tr>

								<td><c:if test="${page.isFirstPage==true }">
										<a>首页</a>
									</c:if> <c:if test="${page.isFirstPage==false }">
										<a href="/admin/users/list?page=${page.firstPage }">首页</a>
									</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
										test="${page.hasPreviousPage==true }">
										<a href="/admin/users/list?page=${page.prePage }">上一页</a>
									</c:if> <c:if test="${page.hasPreviousPage==false }">
										<a>上一页</a>
									</c:if> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									每页${page.pageSize }条
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${page.pageNum }/${page.pages }
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
										test="${page.hasNextPage==true }">
										<a href="/admin/users/list?page=${page.nextPage }">下一页</a>
									</c:if> <c:if test="${page.hasNextPage==false }">
										<a>下一页</a>
									</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
										test="${page.isLastPage==false }">
										<a href="/admin/users/list?page=${page.lastPage }">末页</a>
									</c:if> <c:if test="${page.isLastPage==true }">
										<a>末页</a>
									</c:if></td>
							</tr>
						</table>
					</form>
					<!-- <div class="larry-table-page clearfix ">
						<div id="page" class="page"></div>
					</div> -->
				</div>

				<!-- 登录日志 -->
				<div class="layui-tab-item layui-field-box ">
					<table class="layui-table table-hover " lay-even=" "
						lay-skin="nob ">
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


				</div>
			</div>
		</div>
	</div>
	</section>
	<script type="text/javascript" src="/comm/layui/layui.js "></script>

	<!-- 		<script type="text/javascript "> 
			var tid = document.getElementById("tid ");
			tid.value = '${tid}';
		</script>  
		
		<script type="text/javascript">
		 layui.use(['jquery','layer','element','laypage'],function(){
		      window.jQuery = window.$ = layui.jquery;
		      window.layer = layui.layer;
	       var element = layui.element();
	           laypage = layui.laypage;
	        laypage({
						cont:'page',
						pages:'${page.pages}', //总页数
						curr:'${page.pageNum}',
                         GROUPS: 5, //连续显示分页数
						jump: function(obj, first) {
							//得到了当前页，用于向服务端请求对应数据
							var curr = obj.curr;
							
							if(!first) {
								document.forms[0].action="/admin/users/list?page="+curr;
								document.forms[0].submit();
							}
						}
					});
	 });
		</script>
		
		-->
</body>

<script type="text/javascript">
		function yangfan() {
			var user_id = document.getElementById("user_id").value;
			var password = document.getElementById("password").value;
			var passwords = document.getElementById("passwords").value;
			if(password.trim().length == 0 && passwords.trim().length == 0) {
				alert("输入框不能为空");
			} else {
				if(password == passwords) {
					window.location.href = "/admin/users/update?user_id=" + user_id + "&password=" + password;
				} else {
					alert("两次输入不一致！请重新输入");
				}
			}
		}

	
	</script>

</html>