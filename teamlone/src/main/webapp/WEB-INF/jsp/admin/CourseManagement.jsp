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
		<script src="/comm/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/JavaScript" src="/static/My97DatePicker/WdatePicker.js"></script> 
	</head>

<style>
     
     .in{
         height: 40px
         
     }
     .no{
     width: 80px
     }
</style>

	<body>
		<section class="layui-larry-box">
			<div class="larry-personal">
				<div class="layui-tab">
					<blockquote class="layui-elem-quote news_search">
						<form action="/admin/course/list" method="post">
							<table class="layui-table table-hover" lay-even="" lay-skin="nob">
								<tr>
									<td><input type="text" id="nameid" name="name" value="${map.name }" class="form-control" placeholder="请输入搜索名称" /></td>
									<td>
										<select class="form-control " id="ztid" name="ztid" style="width: 120px; ">
											<option value="-1">请选择状态</option>
											<option value="1">上架</option>
											<option value="2">下架</option>
										</select>
									</td>
									<td>
										<select class="form-control " id="zyid" name="zyid" style="width: 120px;">
											<option value="-1">请选择专业</option>
											<c:forEach items="${allSubjict }" var="subjiect">
											<option value="${subjiect.id }" >${subjiect.name }</option>
											</c:forEach>
										</select>
									</td>
									<td >
									创建时间: <input type="date" name="stattime" id="stattime" value="${map.stattim }"/> - <input type="date" id="endtime" name="endtime" value="${map.endtime}" /> </td>
									<td><button type="submit" class="btn btn-info no">查找课程</button></td>
									<td><button type="button" class="btn btn-info no" onclick="addCourse()">添加课程</button></td>
									<td><button type="button" class="btn btn-info no" onclick="qk()">清空</button></td>
								</tr>

							</table>
						</form>
					</blockquote>

					<div class="layui-tab-content larry-personal-body clearfix mylog-info-box">
						<!-- 操作日志 -->
						<div class="layui-tab-item layui-field-box layui-show">
							<form action="" method="post">
								<table class="layui-table table-hover" lay-even="" lay-skin="nob" id="mytab" name="mytab">
									<thead>
										<tr>
										<th>课程名称</th>
										<th>状态</th>
										<th>专业</th>
										<th>原价</th>
										<th>优惠价</th>
										<th>课时</th>
										<th>销售量</th>
										<th>浏览量</th>
										<th>创建时间</th>
										<th>有效结束时间</th>
										<th>操作</th>
										</tr>
									</thead>
										<tbody id="t1" name="t1">
										<c:forEach items="${allEnd_Course.list }" var="course" varStatus="stat">
										<tr>
										<th>${course.course_name }</th>
										<th>
										<c:if test="${course.is_avaliable==1 }">
										上架
										</c:if>
										<c:if test="${course.is_avaliable==2 }">
										下架
										</c:if>
										</th>
										<th>${course.subject.name }</th>
										<th>${course.source_price }</th>
										<th>${course.current_price }</th>
										<th>${course.lession_num }</th>
										<th>${course.page_buycount }</th>
										<th>${course.page_vlewcount }</th>
										<th> <fmt:formatDate value="${course.update_time }" type="date" pattern="yyyy-MM-dd" /></th>
										<th><c:if test="${course.losetype==1 }">
										<fmt:formatDate value="${course.update_time }" type="date" pattern="yyyy-MM-dd" />
										</c:if>
										<c:if test="${course.losetype==2 }">
										购买后的${course.lose_time }天
										</c:if>
										</th>
										<th><input type="button" class="btn btn-default in" onclick="chapte(${course.course_id })"  value="章节管理" style="background: black; color: white;" /><input type="button" class="btn btn-default in" onclick="chapter(${course.subject.id },${course.is_avaliable },${course.course_id })" value="修改" style="background: black; color: white;" /><input type="button" class="btn btn-default in" value="删除" style="background: black; color: white;" /></th>
										</tr>
											</c:forEach>
										</tbody>
								</table>
						</div>
							</form>
							<div class="larry-table-page clearfix ">
								<div id="page" class="page "></div>
							</div>
						</div>
					</div>
				</div>
	
		</section>
		<script type="text/javascript " src="/comm/layui/layui.js "></script>
	<script type="text/javascript">
	   layui.use(['jquery','layer','element','laypage'],function(){
		      window.jQuery = window.$ = layui.jquery;
		      window.layer = layui.layer;
	       var element = layui.element(),
	           laypage = layui.laypage;
	        laypage({
						cont: 'page',
						pages: '${allEnd_Course.pages}', //总页数
						curr:'${allEnd_Course.pageNum}',
						groups: 5, //连续显示分页数
						jump: function(obj, first) {
							//得到了当前页，用于向服务端请求对应数据
							var curr = obj.curr;
							if(!first) {
								document.forms[0].action="/admin/course/list?page="+curr;
								document.forms[0].submit();
							}
						}
					});
	 });
	   
	   function chapter(id,aid,cid) {
		window.location.href="/admin/course/chapter/"+id+"/"+aid+"/"+cid;
	}
	   $(function () {
		$("#ztid").val(${map.ztid});
		$("#zyid").val(${map.zyid});
	})
	function qk() {
		   $("#ztid").val("-1");
			$("#zyid").val("-1");
			$("#nameid").val("");
			$("#stattime").val("");
			$("#endtime").val("");
			
	}
	   function chapte(id) {
		window.location.href="/admin/course/chapte/"+id;
	}
	   
	   function addCourse() {
		window.location.href="/admin/course/addCourse"
	}
	   
</script>

	</body>
            

</html>