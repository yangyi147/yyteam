<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="/js/iscroll-zoom.js"></script>
<script src="/js/hammer.js"></script>
<script src="/js/lrz.all.bundle.js"></script>
<script src="/js/jquery.photoClip.js"></script>
<style>
#clipArea {
	margin: 20px;
	height: 300px;
}

#file, #clipBtn {
	margin: 20px;
}

#view {
	margin: 0 auto;
	width: 200px;
	height: 200px;
}
</style>
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
				pidKey : "pId"
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
			alert("只能选择城市...");
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
			f = nodes[i].id;
		}
		if (v.length > 0)
			v = v.substring(0, v.length - 1);
		var cityObj = $("#citySel");
		cityObj.attr("value", v);
		$("#subjectid").attr("value", f)
	}
	function showMenu() {
		var cityObj = $("#citySel");
		var cityOffset = $("#citySel").offset();
		$("#menuContent").css({
			left : cityOffset.left + "px",
			top : cityOffset.top + cityObj.outerHeight() + "px",
			zIndex : 9999
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
		var zNodes = ${su};
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});

	function fun(a, b) {
		var regs = /^[\u4E00-\u9FA5]+$/;
		var v = a.value;
		var t;
		if (b == 1) {
			var reg = /^[0-9]*$/;
			t = document.getElementById("d1");
			if (v.trim().length == 0) {
				t.innerText = "姓名不能为空!";
				t.style.color = "red";
				$("#btn").attr({
					disabled : "disabled"
				});
			} else if (v.trim().length < 2 || v.trim().length > 6) {
				t.innerText = "姓名不能小于两个字或者大于6位!";
				t.style.color = "red";
				$("#btn").attr({
					disabled : "disabled"
				});
			} else if (reg.test(v)) {
				t.innerText = "姓名不能为纯数字";
				t.style.color = "red";
			} else if (!regs.test(v)) {
				t.innerText = "必须输入中文!";
				t.style.color = "red";
				return false;
			} else {
				t.innerText = "";
				$("#btn").removeAttr("disabled");
			}
		} else if (b == 2) {
			var reg = /^[0-9]*$/;
			t = document.getElementById("d2");
			if (v.trim().length == 0) {
				t.innerText = "资历不能为空!";
				t.style.color = "red";
				$("#btn").attr({
					disabled : "disabled"
				});
			} else if (v.trim().length < 5) {
				t.innerText = "资历不能小于五个字!";
				t.style.color = "red";
				$("#btn").attr({
					disabled : "disabled"
				});
			} else if (reg.test(v)) {
				t.innerText = "资历不能为纯数字";
				t.style.color = "red";
			} else {
				t.innerText = "";
				$("#btn").removeAttr("disabled");
			}
		} else if (b == 3) {
			t = document.getElementById("d3");
			if (v.trim().length == 0) {
				t.innerText = "专业不能为空!";
				t.style.color = "red";
				$("#btn").attr({
					disabled : "disabled"
				});
			} else if (v.trim().length < 2) {
				t.innerText = "专业不能小于两个字!";
				t.style.color = "red";
				$("#btn").attr({
					disabled : "disabled"
				});
			} else {
				t.innerText = "";
				$("#btn").removeAttr("disabled");
			}

		} else if (b == 4) {
			var reg = /^[0-9]*$/;
			t = document.getElementById("d4");
			if (v.trim().length == 0) {
				t.innerText = "讲师不能为空!";
				t.style.color = "red";
				$("#btn").attr({
					disabled : "disabled"
				});
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
		<header class="larry-personal-tit"> <span>添加个人信息</span> </header>
		<!-- /header -->
		<div class="larry-personal-body clearfix">
			<form class="layui-form col-lg-5" action="/admin/upload"
				enctype="multipart/form-data" method="post">
				 <input type="hidden" name="filename" id="filename" hidden="hidden"  value="${te.pic_path}"/>
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" name="name" class="layui-input  "
							onblur="fun(this,1)" lay-verify="required" value=""><span
							id="d1"></span>
					</div>

				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">资历</label>
					<div class="layui-input-block">
						<input type="text" name="education" class="layui-input "
							onblur="fun(this,2)" value="" lay-verify="required"><span
							id="d2"></span>
					</div>

				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">专业</label>
					<div class="layui-input-block">
						<input type="text" name="sd" id="subjectid" class="layui-input"
							value="" hidden="hidden"> <input type="text" id="citySel"
							class="layui-input" readonly="readonly" onblur="fun(this,3)"
							value="">
						<div id="menuContent" class="menuContent"
							style="display: none; position: absolute;">
							<ul id="treeDemo" class="ztree"
								style="margin-top: -154px; width: 160px; margin-left: -58px;"></ul>
						</div>
						<a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
						<span id="d3"></span>
					</div>

				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">等级</label>
					<div class="layui-input-block">
						<select name="th_name" lay-filter="aihao">
							<option value="-1">请选择</option>
							<option value="首席讲师">首席讲师</option>
							<option value="高级讲师">高级讲师</option>
							<option value="普通讲师">普通讲师</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">讲师排序</label>
					<div class="layui-input-block">
						<input type="text" name="sort" class="layui-input"
							onblur="fun(this,4)" placeholder="请输入"><span id="d4"></span>
					</div>

				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">图片</label>
					<div class="layui-input-block">
<!-- 						<div id="clipArea"></div> -->
						<img src="${te.pic_path }" width="300" height="200" id="img"/>
						<input type="file" id="file" name="file" class="layui-upload-file">
<!-- 						<input type="button" id="clipBtn"  value="截取"> -->
<!-- 						<div id="view"></div> -->
					</div>
				</div>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">简介</label>
					<div class="layui-input-block">
						<textarea placeholder="既然选择了远方，便只顾风雨兼程；路漫漫其修远兮，吾将上下而求索" value=""
							class="layui-textarea" name="career"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" id="btn"
							lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</section>
	<script type="text/javascript" src="/comm/layui/layui.js"></script>
	<script type="text/javascript">
	layui.use([ 'form', 'upload' ], function() {
		var form = layui.form();
					layui.upload({
						url : '/admin/uploadfind',//上传接口 
						success : function(res) {
							alert("alert")
							$("#img").attr("src","/images/"+res.url);
							$("#filename").val(res.url);
							alert(res.url);
						}
					});
	});

// 		var clipArea = new bjj.PhotoClip("#clipArea", {
// 			size : [ 260, 260 ],
// 			outputSize : [ 640, 640 ],
// 			file : "#file",
// 			view : "#view",
// 			ok : "#clipBtn",
// 			loadStart : function() {
// 				console.log("照片读取中");
// 			},
// 			loadComplete : function() {
// 				console.log("照片读取完成");
// 			},
// 			clipFinish : function(dataURL) {
// 				console.log(dataURL);
// 			}
// 		});
		//clipArea.destroy();
	</script>

</body>
</html>