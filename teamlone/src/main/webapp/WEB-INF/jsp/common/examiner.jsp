<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>查看邮件</title>
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
<link rel="stylesheet" type="text/css" href="/comm/global.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
<script src="/js/jquery-3.0.0.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
<!-- 发送邮件 -->

</script>
<style>
   #d1{
   margin: 30px 100px;   
   }
  
    </style>
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>邮件详情</span>
		</header><!-- /header -->
		<div class="larry-personal-body clearfix changepwd">
			<form class="layui-form col-lg-4" method="post" action="">
			 	<div class="layui-form-item">
					<label class="layui-form-label">邮件标题</label>
					<div class="layui-input-block">  
						<input type="text" name="title" value="${emailsend.title}" autocomplete="off"  class="layui-input layui-disabled"  disabled="disabled" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">邮件类型</label>
					<div class="layui-input-block">  
					<c:if test="${emailsend.type==1}" >
					<input type="text" name="title" value="普通" autocomplete="off"  class="layui-input layui-disabled"  disabled="disabled" >
			       </c:if>
			       	<c:if test="${emailsend.type==2}">
			       	<input type="text" name="title" value="定时" autocomplete="off"  class="layui-input layui-disabled"  disabled="disabled" >
			      
			       </c:if>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">是否发送</label>
					<div class="layui-input-block">  
						<c:if test="${emailsend.status==1}">
							<input type="text" name="title" value="已发送" autocomplete="off"  class="layui-input layui-disabled"  disabled="disabled" >
			       </c:if>
			      <c:if test="${emailsend.status==2}">
			      <input type="text" name="title" value="未发送" autocomplete="off"  class="layui-input layui-disabled"  disabled="disabled" >
			    
			       </c:if>
					</div>
				</div>
				 	<div class="layui-form-item">
					<label class="layui-form-label">创建时间</label>
					<div class="layui-input-block"> 
					
					  <input type="text" name="title" value="  <fmt:formatDate value="${emailsend.create_time}" type="date" pattern="yyyy-MM-dd hh:mm:ss"/> " autocomplete="off"  class="layui-input layui-disabled"  disabled="disabled" >
					</div>
				</div>
				 	<div class="layui-form-item">
					<label class="layui-form-label">发送人</label>
					<div class="layui-input-block">  
						<input type="text" name="title" value="admin" autocomplete="off"  class="layui-input layui-disabled"  disabled="disabled" >
					</div>
				</div>
				 	<div class="layui-form-item">
					<label class="layui-form-label">接收人</label>
					<div class="layui-input-block">  
						<input type="text" name="title" value="${emailsend.user_id.user_name}" autocomplete="off"  class="layui-input layui-disabled"  disabled="disabled" >
					</div>
				</div>
				 	<div class="layui-form-item">
					<label class="layui-form-label">邮件内容</label>
					<div class="layui-input-block">  
					<script type="text/plain" value="" id="content" style="width:900px;height:300px;">${emailsend.content}</script>
					</div>
				</div>
					<div class="layui-form-item change-submit">
					<div class="layui-input-block">
					<td colspan="2" style=" padding: 0px 800px;height: 80px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="/admin/email/list"  class="layui-btn layui-btn-primary" >返回</a></td>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
	
</body>
<script type="text/javascript">
	var um = UM.getEditor('content');
	var um = UM.getEditor('contents')
</script>
</html>