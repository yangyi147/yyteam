<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>发送邮件</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="/js/utf8-jsp/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="/comm/layui/css/layui.css"
	media="all">
<link rel="stylesheet" type="text/css"
	href="/comm/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/comm/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
 <link href="/js/bootstrapValidator.min.css" rel="stylesheet" />
<script src="/js/jquery-3.0.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/bootstrap-table.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/js/utf8-jsp/third-party/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.min.js"></script>
<script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>
 <script src="/js/bootstrapValidator.min.js"></script>
<script src="/comm/layui/layui.js" charset="utf-8"></script>


 <style type="text/css">
 body {
	background-color: white;
}
 </style>
<script type="text/javascript">
		$(function() {
			
				$("#div1").hide();
				$("#type").change(function() {
					var type = $(this).val();
					if(type == '1') {
						$("#div1").hide();
					} else {
						$("#div1").show();
					}
				});

			});

			function del() {
				var c = "是否要发送邮件？";
				if(confirm(c) == true) {
					return true;
				} else {
					return false;
				}
			}

			var b = [];
			var d = 0;

			function yangfan() {

				var emass = document.getElementsByName("subcheck");
				for(var i = 0; i < emass.length; i++) {
					if(emass[i].checked) {

						b.push(emass[i].value);
					}
				}
				var c = "";

				for(var i = 0; i < b.length; i++) {

					if(c.trim().length == 0) {
						c = b[i] + ";";
					} else {
						c += b[i] + ";";
					}

				}
				$("#email").val(c);

			}


			function dingshi() {
				var type = $("#type").val();
				if(type == 1) {
					document.getElementById("div").style.display = "none";
				} else if(type == 2) {
					document.getElementById("div").style.display = "";
				}
			}

			//全选反选
			function fun1() {
				var checklist = document.getElementsByName("subcheck");
				if(document.getElementById("checkbox").checked) {
					for(var i = 0; i < checklist.length; i++) {
						checklist[i].checked = 1;
					}
				} else {
					for(var j = 0; j < checklist.length; j++) {
						checklist[j].checked = 0;
					}
				}
			}


	function fun(a, b) {
			var v = a.value;
			var t;
			if(b == 1) {
				var reg =/^[0-9]*$/;
				t = document.getElementById("d2");
				if(v.trim().length == 0) {
					t.innerText = "标题不能为空!";
					t.style.color = "red";
					$("#btn").attr({ disabled: "disabled" });
				}else if(reg.test(v)){
					t.innerText = "标题不能为纯数字";
					t.style.color = "red";
				} else{
					t.innerText = "";
					$("#btn").removeAttr("disabled");
				}

			} else if(b == 2) {
				str = v.substr(0,v.length-1);
				var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
				t = document.getElementById("ds");
				if(v.trim().length == 0) {
					t.innerText = "邮箱不能为空!";
					t.style.color = "red";
					$("#btn").attr({ disabled: "disabled" });
				} else if(!myreg.test(str)){
					t.innerText = "邮箱格式有误";
					t.style.color = "red";
				} else{
					t.innerText = "";
					$("#btn").removeAttr("disabled");
				}
			}
	}
		

</script>
    <style>
   #d1{
   margin: 80px 100px;   
   }
   #span1,#span2,#span3,#span4,#span5{
    color: red;
   }

    </style>
</head>

<body >

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
						<h4 class="modal-title" id="myModalLabel">请选择联系人</h4>
					</div>
					<div class="modal-body">
				 
						<table class="layui-table table-hover" lay-even="" lay-skin="nob"
							id="mytab" name="mytab">
							<thead>
								<tr><td><input type="checkbox" id="checkbox" name="checkbox" onclick="fun1()"></td>
									<th>邮箱</th>
									<th>用户名</th>
								
								</tr>
							</thead>
							<tbody id="t1" name="t1">
								<c:forEach items="${lists}" var="p" varStatus="stea">
									<tr>
									   <td><input type="checkbox" id="subcheck" name="subcheck" value="${p.email}"></td>
										<th>${p.email}</th>
										<th>${p.user_name}</th>

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
					
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="yangfan()">确定</button>
					</div>
				</div>
			</div>
		</div>





	<form action="/admin/email/sendEmail" method="post" id="form1">
		<div id="d1">
			<table style="margin-top: 30px; width: 1200px" >
				<tr>
					<td>
						<table align="left" id="tab1" >
							<tr height="50px">
								<td id="t1"><span id="span1">*</span>	添加联系人:</td>
								<td id="t2">
								 
								<textarea name="email" id="email" rows="8"   onblur="fun(this,2)"
										cols="50" style="width: 600px; height: 50px;" class="form-control"
										placeholder="请选输入对方邮箱,多个请用(;)分号隔开"></textarea>
										
										<span id="ds"></span>
							
								</td>
								<td><button type="button" class="layui-btn" data-toggle="modal"
												onclick="xiugai(${p.user_id})" data-target="#myModal">
												请选择联系人</button>
									  
								</td>
							</tr>

						</table>
					</td>

				</tr>

			</table>

			<table
				style="font-family: '微软雅黑'; margin-top: 30px; line-height: 50px; font-size: 16px;  color: red; text-align: left; width: 100%;"
				id="tab2">
				<tr height="30px">
					<td>规则</td>

				</tr>
				<tr>
					<td>1.邮件格式：****@qq.com</td>

				</tr>
				<tr>
					<td>或者******@126.com,*****@163.com,*****@sina.com..等</td>

				</tr>
				<tr>
					<td>2.发送流程：添加邮箱号->设置邮箱号->提交发送</td>

				</tr>
				<tr>
					<td>3.添加邮箱号时，查询后可以选择添加所选学员及添加所有学员，请慎重选择。</td>

				</tr>
				<tr>
					<td>4.群发邮件最多不能超过1000条</td>

				</tr>
				<tr>
					<td>5.定时邮件会有几分钟的延迟。</td>

				</tr>

			</table>
			<table align="left" style="padding: 30px; margin-top: 30px;">
				<tr>
					<td>
					<span id="span2">*</span>邮箱标题：</td>
					<td height="80px">
					
				<input type="text" name="title" id="title" 
						value="" placeholder="请输入邮件标题" 
						 class="form-control"  onblur="fun(this,1)"
						style="width:500px; height: 30px " />
						    <span id="d2"></span>
						</td>
				</tr>
				<tr>
					<td><span id="span3">*</span>正文内容：</td>
					<td>
                         <script type="text/plain" id="content"  name="content"style="width:900px;height:300px;" >
                                                  
                        </script>
					</td>
				</tr>
				<tr height="80px">
					<td><span id="span4">*</span>邮箱类型：</td>
					<td><select name="type" id="type"  class="form-control" style="width: 160px">
							<option value="1">正常</option>
							<option value="2">定时</option>
					     </select></td>
					
				</tr>
				<Tr height="50px">
				         <Td></Td>
					<td >
						<div id="div1">
						
						<input type="text" name="starttime" id="starttime"  class="form-control" 
						style="width: 160px;"    placeholder="请选择定时时间"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
						</div>
					</td>
				</Tr>
				<tr>
					<td colspan="2" style=" padding: 0px 800px">
             <input type="submit"  id="btn" class="form-control" value="发送" ></input></td>
				</tr>
			</table>
			</div>
			
		
			
	</form>
	
	
	

</body>

<script type="text/javascript">
	var um = UM.getEditor('content');

</script>

</html>