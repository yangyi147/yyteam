<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/static/common/ztree/css/zTreeStyle.css" type="text/css">
	<link rel="stylesheet" href="/css/bootstrap.css" />
	<script type="text/javascript" src="/js/jquery-3.0.0.js"></script>
	<script type="text/javascript" src="/js/bootstrap.js"></script>
	<script type="text/javascript" src="/inc/js/ztree/js/jquery.ztree.core.min.js"></script>
	<script type="text/javascript" src="/inc/js/ztree/js/jquery.ztree.excheck.js"></script>
	<style>
		#ztree{
			width: 100%;
			height: 100%;
		}
		
	</style>
	<SCRIPT type="text/javascript">
		 var id=0;
		 var name;
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
		        beforeClick: zTreeBeforeClick
		    }
		};
		var code;
		function setCheck() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			py = $("#py").attr("checked")? "p":"",
			sy = $("#sy").attr("checked")? "s":"",
			pn = $("#pn").attr("checked")? "p":"",
			sn = $("#sn").attr("checked")? "s":"",
			type = { "Y":py + sy, "N":pn + sn};
			zTree.setting.check.chkboxType = type;
			showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
		}
		function showCode(str) {
			if (!code) code = $("#code");
			code.empty();
			code.append("<li>"+str+"</li>");
		}
		$(document).ready(function(){
		var zNodes =${allper };
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setCheck();
			$("#py").bind("change", setCheck);
			$("#sy").bind("change", setCheck);
			$("#pn").bind("change", setCheck);
			$("#sn").bind("change", setCheck);
		});
		

		function zTreeBeforeClick(treeId, treeNode, clickFlag) {
			id=treeNode.id;
			name=treeNode.name;
		};
		function endt() {
		if(id!=0){
		$("#name").val(name);
		$("#id").val(id);
		  $("#myModal").modal("show");
		}
		if(id==0){
         	alert("请选择修改内容")	
		}
		}
        	function updatePer() {
        		
				document.forms[0].action="/Permission/endi";
				document.forms[0].submit();
			}
        	function add() {
        		    alert("12345679")
        			 $("#myModaladd").modal("show");
        		}
        	function addPer() {
        	
        		$("#pId").val(id);
				document.forms[1].action="/Permission/add";
				document.forms[1].submit();
			}
               
                	function dele() {
                		
                		if(id!=0){
                			$.ajax({
                				type:"post", 
				                url:"/Permission/dele",
				                async:true,
				                data:{"id":id},
				                dataType:"json", 
				                success:function(data){
				                	if(data.length>0){
				                		alert("此目录下还存在子节点,不能被删除");
				                	}else{
				                		window.location.href="/Permission/list";
				                	}
				                }
                			});
                			
                		}
                		if(id==0){
                         	alert("请选择修改内容")	
                		}
                		}
                        	
	</SCRIPT>
</head>
<body>
<div class="zTreeDemoBackground left" id="ztree">
		<ul id="treeDemo" class="ztree"></ul>
	</div>

	<shiro:hasPermission name="/admin/sysfunctioin/addfunction">
	<a href="#" class="btn btn-default " onclick="add();">添加</a> 
	</shiro:hasPermission>
	<shiro:hasPermission name="/admin/sysfunctioin/updatefunction">
	<a href="#" class="btn btn-default " onclick="endt();">修改</a>
	</shiro:hasPermission>
	<shiro:hasPermission name="/admin/sysfunctioin/deletefunction">
	<a href="#" class="btn btn-default " onclick="dele();">删除</a> 
	</shiro:hasPermission>
	

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        
        
        
        
  <form action="" class="form-horizontal">
    <div class="form-group">
    <input type="hidden" name="id" id="id" value="" />
    <label for="inputEmail3" class="col-sm-2 control-label">名称:</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="name" name="name" value="" placeholder="名称">
    </div>
  </div>
</form>
        
        
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="updatePer()">修改</button>
      </div>
    </div>
  </div>
</div>






<!-- Modal -->
<div class="modal fade" id="myModaladd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        
        
        
        
  <form action="" class="form-horizontal">
    <div class="form-group">
    <input type="hidden" name="pId" id="pId" value="" />
    <label for="inputEmail3" class="col-sm-2 control-label">名称:</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="name" name="name" value="" placeholder="名称">
    </div>
  </div>
  
     <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">类型:</label>
    <div class="col-sm-10">
      <select class="form-control">
  <option value="1">目录</option>
  <option value="2">功能</option>
</select>
    </div>
  </div>
  
   <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">路径:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="url" name="url" value="" placeholder="路径">
    </div>
  </div>
  
     <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">排序:</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" id="url" name="url" value="" placeholder="路径">
    </div>
  </div>
  
</form>
        
        
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="addPer()">添加</button>
      </div>
    </div>
  </div>
</div>










</body>
</html>