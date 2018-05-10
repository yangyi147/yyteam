<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<link rel="stylesheet" href="/static/common/ztree/css/zTreeStyle.css"type="text/css">
        <link rel="stylesheet" href="/css/bootstrap.css" />
        <script type="text/javascript" src="/js/jquery-3.0.0.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap.js"></script>
        <script type="text/javascript"src="/inc/js/ztree/js/jquery.ztree.core.min.js"></script>
        <script type="text/javascript"src="/inc/js/ztree/js/jquery.ztree.excheck.js"></script>
</head>
<style>
   #uu{
   width: 20%
  
   }
   
   #ss{
    position: absolute;
   left: 120px;
   top: 130px;
   }
   
   #treeDemo{
   width: 80%;
    position: absolute;
   left: 300px;
   top: 50px;
   }

</style>
<SCRIPT type="text/javascript">
		 var id=0;
		 var name;
		var setting = {
				
			check: {
				enable: true,
				chkStyle: "checkbox",
				chkboxType: { "Y" : "ps", "N" : "ps"}
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
		}
		function showCode(str) {
			if (!code) code = $("#code");
			code.empty();
			code.append("<li>"+str+"</li>");
		}
		$(document).ready(function(){
		var zNodes =${allper};
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			zTree.setting.check.chkboxType = type;
// 			setCheck();
// 			$("#py").bind("change", setCheck);
// 			$("#sy").bind("change", setCheck);
// 			$("#pn").bind("change", setCheck);
// 			$("#sn").bind("change", setCheck);
		});
		
		function zTreeBeforeClick(treeId, treeNode, clickFlag) {
			id=treeNode.id;
			name=treeNode.name;
		};
		
	    function GetCheckedAll() {
	        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	        var nodes = treeObj.getCheckedNodes(true);
	        var msg =""
	        var id=$("#ss").val();
	        for (var i = 0; i < nodes.length; i++) {
	           // msg[i].p = nodes[i].id;
	           msg+=nodes[i].id+",";
	        }
	        window.location.href="/admin/RoleManagement/insertRole_Function?id="+id+"&str="+msg;
	    }
		function read() {
			var id=$("#ss").val();
		   window.location.href="/admin/RoleManagement/list?id="+id;
		}

                        	
	</SCRIPT>
<body>
<div class="zTreeDemoBackground left" id="ztree">
        <ul id="uu" class="">
        <select id="ss" onchange="read()">
        <c:forEach items="${allRole }" var="roleAll">
        <c:if test="${roleAll.role_id==id }">
        <option value="${roleAll.role_id }" selected="selected">${roleAll.role_name }</option>
        </c:if>
         <c:if test="${roleAll.role_id!=id }">
        <option value="${roleAll.role_id }">${roleAll.role_name }</option>
        </c:if>
        </c:forEach>
        </select>
        </ul>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<input type="button" value="确定" onclick="GetCheckedAll()"/>
</body>
</html>