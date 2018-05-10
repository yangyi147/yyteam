<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<meta content="multipart/form-data; charset=utf-8" />
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
</head>
<script type="text/javascript">
     var f;
	var setting = {
		view : {
			dblClickExpand : false
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pidKey :"pId"
			}
		},
		callback : {
			beforeClick : beforeClick,
			onClick : onClick
		}
	};
	function beforeClick(treeId, treeNode) {
		var check = (treeNode && !treeNode.isParent);
		if (!check)
			alert("只能选择专业");
		return check;
	}
	function onClick(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), nodes = zTree
				.getSelectedNodes(), v = "";
		nodes.sort(function compare(a, b) {
			return a.id - b.id;
		});
		for (var i = 0, l = nodes.length; i < l; i++) {
			v += nodes[i].name + ",";
			f=nodes[i].id ;
		}
		if (v.length > 0)
			v = v.substring(0, v.length - 1);
		var cityObj = $("#citySel");
		cityObj.attr("value", v);
		$("#subjectid").attr("value",f)
	}
	function showMenu() {
		var cityObj = $("#citySel");
		var cityOffset = $("#citySel").offset();
		$("#menuContent").css({
			left : cityOffset.left + "px",
			top : cityOffset.top + cityObj.outerHeight() + "px",
			zIndex:9999
		}).slideDown("fast");
		$("body").bind("mousedown", onBodyDown);
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(
				event.target).parents("#menuContent").length > 0)) {
			hideMenu();
		}
	}
	$(document).ready(function() {
		var zNodes =${su};
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
</script>
<body>
	<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit"> <span>修改个人信息</span> </header>
		<!-- /header -->
		<div class="larry-personal-body clearfix">
			<form class="layui-form col-lg-5" action="/admin/upTer" enctype="multipart/form-data"   method="post" >
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" name="name" class="layui-input  "
							lay-verify="required" value="${te.name }">
					</div>
				</div>
				 <input type="hidden" name="pic_path" id="filename" hidden="hidden"  value="${te.pic_path}"/>
				  <input type="hidden" name="id" value="${te.id}" hidden="hidden"/>
				<div class="layui-form-item">
					<label class="layui-form-label">资历</label>
					<div class="layui-input-block">
						<input type="text" name="education" class="layui-input " value="${te.education }" lay-verify="required">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">专业</label>
					<div class="layui-input-block">
					<input type="text" name="sd" id="subjectid"
							class="layui-input" value="${te.subject_id.id}"  hidden="hidden" >
						<input type="text"  id="citySel"
							class="layui-input" readonly="readonly" value="${te.subject_id.name}" >
						<div id="menuContent" class="menuContent" style="display: none; position: absolute;">
							<ul id="treeDemo" class="ztree"
								style="margin-top: -154px; width: 160px;margin-left: -58px;"></ul>
						</div>
						<a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">等级</label>
					<div class="layui-input-block">
						<select name="th_name" lay-filter="aihao" id="sel">
							<option value="-1">请选择</option>
							<option value="首席讲师" >首席讲师</option>
							<option value="高级讲师" >高级讲师</option>
							<option value="普通讲师">普通讲师</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">讲师排序</label>
					<div class="layui-input-block">
						<input type="text" name="sort" class="layui-input"
							placeholder="请输入"  value="${te.sort }">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">图片</label>
					<div class="layui-input-block">
						<img src="${te.pic_path }" width="300" height="200" id="img"/>
                  <input type="file" name="file"  class="layui-upload-file">  
					</div>
				</div>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">简介</label>
					<div class="layui-input-block">
						<textarea  
							class="layui-textarea" name="career">${te.career}</textarea>
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
							url : '/admin/uploadfind',//上传接口 
							success : function(res) {
								$("#img").attr("src","/images/"+res.url);
								$("#filename").val(res.url);
								alert(res.url);
							}
						});
		});
		
		$("#sel").val("${te.th_name}");
	</script>
</body>
</html>