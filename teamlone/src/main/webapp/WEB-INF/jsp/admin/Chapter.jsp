<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/comm/layui/css/layui.css" media="all">
<link href="/static/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="/comm/bootstrap/css/bootstrap.css" media="all">
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="/comm/global.css" media="all">
		<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
		<link rel="stylesheet" href="/static/common/ztree/css/demo.css" type="text/css">
			<link rel="stylesheet" href="/static/common/ztree/css/zTreeStyle.css"type="text/css">
        <link rel="stylesheet" href="/css/bootstrap.css" />
        <script type="text/javascript" src="/static/utf8-jsp/third-party/jquery.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap.js"></script>
        <script type="text/javascript"src="/inc/js/ztree/js/jquery.ztree.core.min.js"></script>
        <script type="text/javascript"src="/inc/js/ztree/js/jquery.ztree.excheck.js"></script>
		<script type="text/javascript" src="/js/bootstrap.js"></script>
		
 		<script type="text/javascript" charset="utf-8" src="/static/utf8-jsp/umeditor.config.js"></script> 
         <script type="text/javascript" charset="utf-8" src="/static/utf8-jsp/umeditor.min.js"></script> 
        <script type="text/JavaScript" src="/static/My97DatePicker/WdatePicker.js"></script>
            <script type="text/javascript" src="/static/utf8-jsp/lang/zh-cn/zh-cn.js"></script> 
                        <script type="text/javascript" src="/js/jquery-zh.js"></script>
            
		<style>
           .oh{
             width: 150px
           }
           .th{
             width: 200px
           }
           .form-horizontal>.form-group>.col-sm-10>select{
           		display:inline-block;
           }
           #jz{
           display: none;
           }
              .bz{
        display:inline-block
        }
                   h1{
            font-family: "微软雅黑";
            font-weight: normal;
        }
        .btn {
            display: inline-block;
            *display: inline;
            padding: 4px 12px;
            margin-bottom: 0;
            *margin-left: .3em;
            font-size: 14px;
            line-height: 20px;
            color: #333333;
            text-align: center;
            text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
            vertical-align: middle;
            cursor: pointer;
            background-color: #f5f5f5;
            *background-color: #e6e6e6;
            background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6));
            background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: -o-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: linear-gradient(to bottom, #ffffff, #e6e6e6);
            background-repeat: repeat-x;
            border: 1px solid #cccccc;
            *border: 0;
            border-color: #e6e6e6 #e6e6e6 #bfbfbf;
            border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
            border-bottom-color: #b3b3b3;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff', endColorstr='#ffe6e6e6', GradientType=0);
            filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
            *zoom: 1;
            -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .btn:hover,
        .btn:focus,
        .btn:active,
        .btn.active,
        .btn.disabled,
        .btn[disabled] {
            color: #333333;
            background-color: #e6e6e6;
            *background-color: #d9d9d9;
        }

        .btn:active,
        .btn.active {
            background-color: #cccccc \9;
        }

        .btn:first-child {
            *margin-left: 0;
        }

        .btn:hover,
        .btn:focus {
            color: #333333;
            text-decoration: none;
            background-position: 0 -15px;
            -webkit-transition: background-position 0.1s linear;
            -moz-transition: background-position 0.1s linear;
            -o-transition: background-position 0.1s linear;
            transition: background-position 0.1s linear;
        }

        .btn:focus {
            outline: thin dotted #333;
            outline: 5px auto -webkit-focus-ring-color;
            outline-offset: -2px;
        }

        .btn.active,
        .btn:active {
            background-image: none;
            outline: 0;
            -webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .btn.disabled,
        .btn[disabled] {
            cursor: default;
            background-image: none;
            opacity: 0.65;
            filter: alpha(opacity=65);
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            box-shadow: none;
        }
        </style>
        <script type="text/javascript">
     
        var setting = {
    			check: {
    				enable: true,
    				chkStyle: "radio",
    				radioType: "all"
    			},
    			view: {
    				dblClickExpand: false
    			},
    			data: {
    				simpleData: {
    					enable: true
    				}
    			},
    			callback: {
    				onClick: onClick,
    				onCheck: onCheck
    			}
    		};

    		var zNodes =${allSubjict};

    		function onClick(e, treeId, treeNode) {
    			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
    			zTree.checkNode(treeNode, !treeNode.checked, null, true);
    			return false;
    		}

    		function onCheck(e, treeId, treeNode) {
    			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
    			nodes = zTree.getCheckedNodes(true),
    			v = "";
    			var b=0;
    			if(nodes.length==0){
    				$("#subject").text("");
    				$("#ssid").val('');
    			}
    			for (var i=0, l=nodes.length; i<l; i++) {
    				v += nodes[i].name + ",";
    			}
    			for (var i=0, l=nodes.length; i<l; i++) {
    				b = nodes[i].id ;
    			}
    			if (v.length > 0 ) v = v.substring(0, v.length-1);
    			var cityObj = $("#citySel");
    			cityObj.attr("value", v);
    			$("#ssid").val(b);
    			if($("#ssid").val()!=null){
    				$("#subject").text("√");
    			}
    		}

    		function showMenu() {
    			var cityObj = $("#citySel");
    			var cityOffset = $("#citySel").offset();
    			$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

    			$("body").bind("mousedown", onBodyDown);
    		}
    		function hideMenu() {
    			$("#menuContent").fadeOut("fast");
    			$("body").unbind("mousedown", onBodyDown);
    		}
    		function onBodyDown(event) {
    			if (!(event.target.id == "menuBtn" || event.target.id == "citySel" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
    				hideMenu();
    			}
    		}

    		$(document).ready(function(){
    			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
    		});
        
        
        
        
        
        
		function szz() {
			var id= $("#sz").val();
			if (id==1) {
				$("#jz").css({
					display: "none"
				})
				$("#ts").css({
					display: "block"
				})
				
			}else{
				$("#jz").css({
					display: "block"
				})
				$("#ts").css({
					display: "none"
				})
				
			}
		}
        function edit() {
        	var pNode= $("#pNode").val();
        	$.ajax({
        		type:"post",
        		url:"/admin/course/getcourse",
        		async:true,
        		data:{"id":pNode},
        		dataType:"json",
        		success:function  (data) {
        			$(".cn").remove();
        			if(data.length>0){
        				$("#cn").show();
        				for (i=0;i<data.length;i++) {
                			$("#cn").append("<option class='cn' value='"+data[i].id+"'>"+data[i].name+"</option>");
                			}	
        			}else{
        				$("#cn").hide();
        			}
        			
        		}
        	});
		}
    	function edits(input) {
    		if (input.files && input.files[0]) {
    			var reader = new FileReader();
    			reader.onload = function(e) {
    				$('#images').attr('src', e.target.result);
    			}
    			reader.readAsDataURL(input.files[0]);
    			$("#images").show();
    		}
    	}
    	$(function () {
			$("#file").change(function () {
				edits(this);
			})
		})



        </script>
</head>
<body>
<form action="/admin/course/editChapter" class="form-horizontal"  method="post" enctype="multipart/form-data">
<input type="hidden" name="course_id" value="${courseByID.course_id }"/>
<input type="hidden" name="ssid" id="ssid" value=""/>
  <div class="form-group" >
    <label for="inputPassword" class="col-sm-2 control-label">专业管理</label>
<div class="">
	<div class="zTreeDemoBackground left">
		<ul class="list">
			<li class="title"> <input id="citySel" class="form-control th bz" type="text" readonly value="${sname }" style="width:120px;"onclick="showMenu();" " />
			<span id="subject" style="display: none;"></span>
		</li>
		</ul>
	</div>
	
</div>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;z-index: 999">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>
  </div>
  <div class="form-group">                                       
    <label for="inputPassword" class="col-sm-2 control-label" >状态</label>
    <div class="col-sm-10">
    <select name="is_avaliable" class="form-control">
            <option value="1" >上架</option> 
             <option value="2" >下架</option> 
</select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label">总课时</label>
    <div class="col-sm-10">
      <input type="number" class="form-control th bz" name="lession_num" value="${courseByID.lession_num }" onclick="courseLessionNum(this.value)" onkeyup="courseLessionNum(this.value)"  >
      <span id="lessionNum"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label">课程原价格</label>
    <div class="col-sm-10">
      <input type="number" class="form-control th bz" onclick="courseSoursePrice(this.value)" onkeyup="courseSoursePrice(this.value)" name="source_price"  value="${courseByID.source_price }"  >
      <span id="soursePrices"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label">课程销售价格</label>
    <div class="col-sm-10">
      <input type="number" class="form-control th" onclick="courseCurrentPrice(this.value)" onkeyup="courseCurrentPrice(this.value)" id="current_price" name="current_price" value="${courseByID.current_price }"  >
      <span id="currentPrice"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label" >有效期类型</label>
    <div class="col-sm-10">
                <select class="form-control oh" onchange="szz()" id="sz" name="losetype" >
  <option value="1">按天数</option>
  <option value="2">截至日期</option>
</select>
    </div>
  </div>
  <div class="form-group" id="ts">
    <label for="inputPassword" class="col-sm-2 control-label">按天数</label>
    <div class="col-sm-10">
      <input type="number" class="form-control oh bz" onclick="endsj(this.value)" onkeyup="endsj(this.value)" id="loseTime" name="lose_time" style="width: 150px" value="${courseByID.lose_time }"  >
      <span id="loseTimeSpan"></span>
    </div>
  </div>
  <div class="form-group" id="jz">
    <label for="inputPassword" class="col-sm-2 control-label">截至时间</label>
    <div class="col-sm-10">
      <input type="date" class="form-control th bz" name="end_times" id="endTime"  value="${courseByID.end_time }" >
      <span id="endTimeSpan"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label">添加教师</label>
    <div class="col-sm-10">
       <select class="form-control oh" name="tid" style="width: 150px">
       <c:forEach items="${allTeacher }" var="teacher">
     <option value="${teacher.id }">${teacher.name }</option>
       </c:forEach>
</select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label">课程简介</label>
    <div class="col-sm-10">
      <input type="text" class="form-control th bz" name="title" onkeyup="titleValue(this.value)"  style="width: 600px" value="${courseByID.title }" >
       <span id="titles"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label">课程图片</label>
    <div class="col-sm-10">
      <input type="image" src="${courseByID.logo }" id="images" style="width: 300px;height: 200px;display: none" >
      <input type="file" value="上传图片" name="file" id="file" onchange="edits(this)" />
      <span id="fileSpans" style="padding-top: 5px"></span>
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label">课程详情</label>
    <div class="col-sm-8">
<script type="text/plain" id="context" name="context" style="width:1000px;height:240px;">
   ${courseByID.context }
</script>
<span id="contextSpan"></span>
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword" class="col-sm-2 control-label"></label>
    <div class="col-sm-8">
      
     <input type="submit"  value="提交"/>
    </div>
  </div>
</form>

</body>
   <script type="text/javascript">
   var um = UM.getEditor('context');
   um.addListener('blur',function(){
       $('#focush2').html('编辑器失去焦点了')
   });
   um.addListener('focus',function(){
       $('#focush2').html('')
   });
   </script>

</html>