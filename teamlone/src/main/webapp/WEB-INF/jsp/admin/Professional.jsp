<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/static/common/ztree/css/zTreeStyle.css"type="text/css">
        <link rel="stylesheet" href="/css/bootstrap.css" />
        <script type="text/javascript" src="/js/jquery-3.0.0.js"></script>
        <script type="text/javascript" src="/js/bootstrap.js"></script>
        <script type="text/javascript"src="/inc/js/ztree/js/jquery.ztree.core.min.js"></script>
        <script type="text/javascript"src="/inc/js/ztree/js/jquery.ztree.excheck.js"></script>
<title>Insert title here</title>
</head>
<style>
   
   .add{
   margin-left: 300px
   }

</style>
	<SCRIPT type="text/javascript">
	var id=0;
	var name;
		var setting = {
			view: {
				showLine: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback : {
				beforeClick : zTreeBeforeClick
			}
		};

		var zNodes =${allper};

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		function zTreeBeforeClick(treeId, treeNode, clickFlag) {
			id = treeNode.id;
			name = treeNode.name;
		};
		function add() {
			$("#pid").val(id)
			$("#myModal").modal("show");
		}
		function insert() {
			document.forms[0].action = "/admin/professional/insertSubject";
			document.forms[0].submit();
		}
	</SCRIPT>
<body>
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div> 
	
		<shiro:hasPermission name="/admin/subj/createSubject">
		<input type="button" class="btn btn-default add" value="增加专业" onclick="add()" />
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
       
       
<form class="form-horizontal" method="post">
<input type="hidden" value="" name="pId" id="pid" />
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">专业名称</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="name" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label" name="">排序</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" id="inputEmail3" name="sort" >
    </div>
  </div>


</form>


      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭e</button>
        <button type="button" class="btn btn-primary" onclick="insert()">添加</button>
      </div>
    </div>
  </div>
</div>
	
	
	
	
</body>
</html>