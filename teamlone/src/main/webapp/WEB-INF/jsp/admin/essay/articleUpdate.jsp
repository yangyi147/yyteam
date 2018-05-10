<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
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
<script type="text/javascript" charset="utf-8"
	src="/static/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/static/utf8-jsp/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/static/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
</head>
<script type="text/javascript">
//实例化编辑器
//var ue = UE.getEditor('content');
//function tijiao(){
// $(document).ready(function() {
// 	var cd = ${eacget.content };
// 	alert(cd)
// ue.ready(function() {
	
//     ue.setContent(cd);
// });
//	 UE.getEditor('editor').setContent("fshduf");
//	 alert(cd);
//	var ti = ${eacget.edu_article.title};
//	$("#title").val(ti);
// 	${ea.edu_article.title}
// 	${ea.edu_article.summary}
// 	${ea.edu_article.author}
// 	${ea.edu_article.source});
</script>
<body>
	<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit"> <span>添加文章</span> </header>
		<!-- /header -->
		<div class="larry-personal-body clearfix">
			<form class="layui-form col-lg-5" action="/admin/articleadd" method="post"
	enctype="multipart/form-data">
	
				<div class="layui-form-item">
					<label class="layui-form-label">*标题:</label>
					<div class="layui-input-block">
						<input type="text" name="title" id="title" class="form-control"
							lay-verify="required" value="${eacget.edu_article.title}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">*摘要:</label>
					<div class="layui-input-block">
				<input type="text" class="form-control" id="summary"
					value="${eacget.edu_article.summary }" name="summary"
					placeholder="允许输入3-200字符" onblur="summaryFun()">
			</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">*作者:</label>
					<div class="layui-input-block">
					<input type="text" name="author" id="author"
							class="form-control" value="${eacget.edu_article.author}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">*来源:</label>
					<div class="layui-input-block">
					<input type="text" name="source" id="source"
							class="form-control" value="${eacget.edu_article.source}">
					</div>
				</div>
				<div class="layui-form-item"  hidden="hidden">
					<label class="layui-form-label">*文章类型:</label>
					<div class="layui-input-block">
					<select name="article_type" id="article_type">
					<option value="2">文章</option>
			</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">*封面图片:</label>
					<div class="layui-input-block">
						<table>
					<tr>
						<td><image id="blah" src="${eacget.edu_article.image_url } " style="width:300px; height:150px;" /></td>
						<td><input type="file" value="${eacget.edu_article.image_url }" name="file" id="imgInp"></td>
					</tr>
				</table>
					</div>
				</div>
				
				
				
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">内容:</label>
					<div class="layui-input-block">
					<div id="editor" name="content">
					<script id="container" name="content" type="text/plain"  style="height: 360px; width: 600px;">
            ${eacget.content }
        </script>
					
					<script type="text/javascript" charset="utf-8">
						<p>123</p>
					</script>
					</div>
				</div> 
				</div>
				
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">*排序值:</label>
					<div class="layui-input-block">
					<input type="text" name="sort" id="sort" 
							class="form-control" value="${eacget.edu_article.sort}" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"  />
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
					
						<input type="submit" style="height: 35px; width: 120px;"
		class="btn btn-danger" value="添加" />
	<button type="reset" style="height: 35px; width: 120px;"
		class="btn btn-danger">重置</button>
					</div>
				</div>
			</form>
	</div>
	</section>
	<script type="text/javascript">
        var editor = UE.getEditor('container',
        		
        		{	toolbars : [
							[ 'fontfamily', 'fontsize', 'undo',
									'redo', '|', 'emotion',
									'forecolor', 'backcolor',
									'bold', 'underline',
									'strikethrough', '|',
									'justifyleft',
									'justifyright',
									'justifycenter', 'link',
									'unlink', 'simpleupload',
									'insertimage' ],
							[ 'removeformat', 'formatmatch',
									'source', ] ],
					autoHeightEnabled : true,
					autoFloatEnabled : true
					
});
    </script>
	<script type="text/javascript" src="/comm/layui/layui.js"></script>
	
	<script type="text/javascript">
	
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#imgInp").change(function() {
		readURL(this);
	});
	</script>
</body>
</html>