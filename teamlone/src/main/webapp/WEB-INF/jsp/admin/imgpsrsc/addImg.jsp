<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<meta charset=utf-8 " />
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
<link rel="stylesheet" href="/css/demo.css" type="text/css">
<link rel="stylesheet" href="/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/js/jquery-form.js"></script>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/bootstrap-colorpicker.css" rel="stylesheet">
<style type="text/css">
.colorpicker-component {
	margin-top: 10px;
}
</style>
</head>
<script type="text/javascript">
	
</script>
<body>
	<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit"> <span>添加图片</span> </header>
		<!-- /header -->
		<div class="larry-personal-body clearfix">
			<form class="layui-form col-lg-5" action="/admin/inImg"
				enctype="multipart/form-data" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">图片标题</label>
					<div class="layui-input-block">
						<input type="text" name="title" class="layui-input  "
							lay-verify="required" value="">
					</div>
				</div>
				<input type="hidden" name="filename" id="filename"
					value="" />
				<div class="layui-form-item">
					<label class="layui-form-label">图片背景颜色</label>
					<div id="cp6" class="input-group colorpicker-component"
						title="Using horizontal option">
						<input type="text" class="form-control input-lg" name="color"
							value="" /> <span class="input-group-addon"><i></i></span>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">图片描述</label>
					<div class="layui-input-block">
						<input type="text" name="describes" class="layui-input"
							value="">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">图片类行</label>
					<div class="layui-input-block">
						<select name="type_id" lay-filter="aihao" id="sel">
							<option value="-1">请选择</option>
							<c:forEach items="${ty }" var="ty">
								<option value="${ty.type_id }">${ty.type_name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">图片</label>
					<div class="layui-input-block">
						<img src="" width="300" height="200" id="img" /> 
						<input type="file" name="imgfile" id="imgfile" class="layui-upload-file">
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	</section>
	<script type="text/javascript" src="/comm/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use([ 'form', 'upload' ], function() {
			var form = layui.form();
			layui.upload({
				url : '/admin/uploadfind/img',//上传接口 
				success : function(res) {
					$("#img").attr("src", "/images/img/" + res.url);
					$("#filename").val(res.url);
					alert(res.url);
				}
			});
		});
		$("#sel").val("${im.t_id.type_id}");
	</script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
	</script>
	<script src="/js/bootstrap-colorpicker.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#mycp').colorpicker();
		});
		$(function() {
			$('#cp2, #cp3a, #cp3b').colorpicker();
			$('#cp4').colorpicker({
				"color" : "#16813D"
			});
			$('#cp5').colorpicker({
				format : "rgba"
			});
			$('#cp6').colorpicker({
				horizontal : true
			});
			$('#cp9').colorpicker({
				useAlpha : false
			});
			$('#cp10').colorpicker({
				useHashPrefix : false
			});
		});
	</script>
</body>
</html>