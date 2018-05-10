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



 <style type="text/css">
 body {
	background-color: white;
}
 </style>
<script type="text/javascript">

	$(function() {
		$("#yan").hide();
		$("#div1").hide();
		$("#type").change(function() {
			var type = $(this).val();
			if (type == '1') {
				$("#div1").hide();
			} else {
				$("#div1").show();
			}
		});

	});

	

	var b = "";
	function xianshi() {		
		var emass = $("#eid").val();
		
		if (emass == 0) {
			alert("请选择联系人")
		} else {
			b = b + emass + ";";
			$("#email").val(b);
		}
	}
	function test(obj){
		 //对电子邮件的验证
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		 if(!myreg.test(obj))
		 {
		 alert('请输入有效的邮箱！');
		return false;
		 }
		 }
	function yanzheng() {
	  
		if ($("#title").val().length>5) {
			$("#yan").show();
		} else{
			$("#yan").hide();	
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
   #yan{
    color: red;
   }
    </style>
</head>

<body >

	<form action="/admin/email/sendEmail" method="post">
		<div id="d1">
			<table style="margin-top: 30px; width: 1200px" >
				<tr>
					<td>
						<table align="left" id="tab1" >
							<tr height="50px">
								<td id="t1"><span id="span1">*</span>	添加联系人:</td>
								<td id="t2">
								 
								<textarea name="email" id="email" rows="8"
										cols="50" style="width: 600px; height: 50px;" class="form-control"
										placeholder="请选输入对方邮箱,多个请用(;)分号隔开" ></textarea>
							
								</td>
								<td></td>
							</tr>

						</table>
					</td>

					<td>

						<table >

							<tr>
								<td
									style="height: 35px; font-family: '微软雅黑'; font-size: 16px; font-weight: bold; text-align: center;">
									通讯录
									</td>
							</tr>

							<tr >
								<td style="height: 20px; font-family: '微软雅黑'; font-size: 14px; text-align: center;" >

									<select id="eid" name="eid" onchange="xianshi()" class="form-control" style="width: 160px">
										<option value="0"> 请选择联系人</option>
										<c:forEach items="${lists}" var="u">
											<option value="${u.email}">${u.user_name}</option>
										</c:forEach>
								</select>
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
						value="" placeholder="请输入邮件标题" class="form-control"
						 class="form-control" 
						style="width:500px; height: 30px " onclick="yanzheng()"/>
						  <span id="yan">标题长度不能超出20字!</span>
						</td>
				</tr>
				<tr>
					<td><span id="span3">*</span>正文内容：</td>
					<td>
                         <script type="text/plain" id="content"  name="content"style="width:900px;height:300px;">
                                              
                                   </script>
					</td>
				</tr>
				<tr height="80px">
					<td><span id="span4">*</span>邮箱类型：</td>
					<td><select name="type" id="type" onchange="dingshi()" class="form-control" style="width: 160px">
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
					<td colspan="2" style=" padding: 0px 800px"><input type="submit" 
						value="发送" class="layui-btn"  class="form-control"/></td>
				</tr>
			</table>
			</div>
			
		
			
	</form>
	
	
	<!--　<form>
            <div class="form-group">
                <label>Username</label>
                <input type="text" class="form-control" name="username" />
            </div>
            <div class="form-group">
                <label>Email address</label>
                <input type="text" class="form-control" name="email" />
            </div>
            <div class="form-group">
                <button type="submit" name="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>-->

</body>
<script type="text/javascript">
	var um = UM.getEditor('content');

	
</script>

</html>