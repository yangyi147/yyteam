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
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link rel="stylesheet" type="text/css" href="/comm/layui/css/layui.css" media="all">
		<link rel="stylesheet" type="text/css" href="/comm/bootstrap/css/bootstrap.css" media="all">
		<link rel="stylesheet" type="text/css" href="/comm/global.css" media="all">
		<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
		<link rel="stylesheet" href="/css/demo.css" type="text/css">
		<link rel="stylesheet" href="/css/zTreeStyle.css" type="text/css">
		<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="/js/jquery.ztree.core.js"></script>
		<script type="text/javascript" charset="utf-8" src="/static/utf8-jsp/ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="/static/utf8-jsp/ueditor.all.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="/static/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
	</head>

	<script type="text/javascript">
		function fun(a, b) {
			var v = a.value;
			var t;
			if(b == 1) {
				var reg = /^[0-9]*$/;
				t = document.getElementById("d1");
				if(v.trim().length == 0) {
					t.innerText = "标题不能为空!";
					t.style.color = "red";
					$("#btn").attr({ disabled: "disabled" });
				} else if(reg.test(v)) {
					t.innerText = "标题不能为纯数字";
					t.style.color = "red";
				} else {
					t.innerText = "";
					$("#btn").removeAttr("disabled");
				}

			} else if(b == 2) {
				var reg = /^[0-9]*$/;
				t = document.getElementById("d2");
				if(v.trim().length == 0) {
					t.innerText = "不能为空!";
					t.style.color = "red";
					$("#btn").attr({ disabled: "disabled" });
				} else if(v.trim().length < 15) {
					t.innerText = "不能小于十五个字!";
					t.style.color = "red";
					$("#btn").attr({ disabled: "disabled" });
				} else if(reg.test(v)) {
					t.innerText = "不能为纯数字";
					t.style.color = "red";
				} else {
					t.innerText = "";
					$("#btn").removeAttr("disabled");
				}
			} else if(b == 3) {
				t = document.getElementById("d3");
				if(v.trim().length == 0) {
					t.innerText = "作者不能为空!";
					t.style.color = "red";
					$("#btn").attr({ disabled: "disabled" });
				} else if(v.trim().length < 2) {
					t.innerText = "作者不能小于两个字!";
					t.style.color = "red";
					$("#btn").attr({ disabled: "disabled" });
				} else {
					t.innerText = "";
					$("#btn").removeAttr("disabled");
				}
			} else if(b == 4) {
				var reg = /^[0-9]*$/;
				t = document.getElementById("d4");
				if(v.trim().length == 0) {
					t.innerText = "来源不能为空!";
					t.style.color = "red";
					$("#btn").attr({ disabled: "disabled" });
				} else {
					t.innerText = "";
					$("#btn").removeAttr("disabled");
				}
			}

		}
	</script>

	<body>
		<section class="layui-larry-box">
			<div class="larry-personal">
				<header class="larry-personal-tit"> <span>修改文章</span> </header>
				<!-- /header -->
				<div class="larry-personal-body clearfix">
					<form class="layui-form col-lg-5" action="/admin/updateadd" method="post" enctype="multipart/form-data">

						<div class="layui-form-item">
							<label class="layui-form-label">*标题:</label>
							<div class="layui-input-block">
								<input type="text" name="title" id="title" class="form-control" lay-verify="required" onblur="fun(this,1)" value="${eacget.edu_article.title}">
								<input type="hidden" id="article_id" name="article_id" value="${eacget.edu_article.article_id }"><span id="d1"></span>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">*摘要:</label>
							<div class="layui-input-block">
								<input type="text" class="form-control" id="summary" onblur="fun(this,2)" value="${eacget.edu_article.summary }" name="summary" placeholder="允许输入3-200字符" onblur="summaryFun()">
							<span id="d2"></span></div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">*作者:</label>
							<div class="layui-input-block">
								<input type="text" name="author" id="author" class="form-control" onblur="fun(this,3)" value="${eacget.edu_article.author}"><span id="d3"></span>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">*来源:</label>
							<div class="layui-input-block">
								<input type="text" name="source" id="source" class="form-control" onblur="fun(this,4)" value="${eacget.edu_article.source}"><span id="d4"></span>
							</div>
						</div>
						<div class="layui-form-item" hidden="hidden">
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
										<td>
											<image id="blah" src="${eacget.edu_article.image_url } " style="width:300px; height:150px;" />
											<input type="hidden" name="hiddens" value="${eacget.edu_article.image_url } ">
										</td>
										<td><input type="file" value="${eacget.edu_article.image_url }" name="file" id="imgInp"></td>
									</tr>
								</table>
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">内容:</label>
							<div class="layui-input-block">
								<div id="editor">
									<script id="container" name="content" type="text/plain" style="height: 360px; width: 600px;">
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
								<input type="text" name="sort" id="sort" class="form-control" value="${eacget.edu_article.sort}" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" />
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-input-block">

								<input type="submit" style="height: 35px; width: 120px;" class="btn btn-danger" id="btn" value="修改" />
								<button type="reset" style="height: 35px; width: 120px;" class="btn btn-danger">重置</button>
							</div>
						</div>
					</form>
				</div>
		</section>
		<script type="text/javascript">
			var editor = UE.getEditor('container',

				{
					toolbars: [
						['fontfamily', 'fontsize', 'undo',
							'redo', '|', 'emotion',
							'forecolor', 'backcolor',
							'bold', 'underline',
							'strikethrough', '|',
							'justifyleft',
							'justifyright',
							'justifycenter', 'link',
							'unlink', 'simpleupload',
							'insertimage'
						],
						['removeformat', 'formatmatch',
							'source',
						]
					],
					autoHeightEnabled: true,
					autoFloatEnabled: true

				});
		</script>
		<script type="text/javascript" src="/comm/layui/layui.js"></script>

		<script type="text/javascript">
			function readURL(input) {
				if(input.files && input.files[0]) {
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