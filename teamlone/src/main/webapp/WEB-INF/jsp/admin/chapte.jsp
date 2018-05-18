<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <script type="text/javascript" src="/static/common/uploadify/ccswfobject.js"></script>
        <script type="text/javascript" src="/static/common/uploadify/swfobject.js"></script>
        <script type="text/javascript" src="/static/common/uploadify/jquery.uploadify.v2.1.4.min.js"></script>
</head>
<style> 
.top{
margin-top: 100px;
margin-left: 50px;
}
</style>
<SCRIPT type="text/javascript">

	var id=0;
	var name;
	var pId;
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
				beforeClick : zTreeBeforeClick,
			}
		};

		var zNodes =${allEdu_course_KpointByCourseID};

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		function zTreeBeforeClick(treeId, treeNode, clickFlag) {
			id = treeNode.id;
			name=treeNode.name;
			 pId=treeNode.pId;
			if(pId!=null&&pId!=""){
				$("#idone").val(id);
			
				$(".cj").hide();
				initUpdateKpoint();
				$("#edit").css({"display":"block"});
				$("#filename").show();
				
			}else{
				$(".cj").show();
				
				$("#edit").css({"display":"none"});
			}
		};
		function qx() {
			id=0;
		}
		function add() {
			
		}
		
		 
		 $(function () {
			$("#addVideo").click(function () {
				$("#pId").val(id);
				if(id==0){
					
					$("#names").attr("name","name");
					$("#names").parent().parent().show();
					$("#name").parent().parent().hide();
				}else{
					$("#name").attr("name","name");
					$("#name").parent().parent().show();
					$("#names").parent().parent().hide();
				}
				$("#myModal").modal("show");
			})
			$("#add").click(function () {
				document.forms[1].action="/admin/course/addVideo";
				document.forms[1].submit();
			})
			$("#file").change(function () {
				var localhost= $("#file").val();
			});
			$("#btn").click(function(){
				document.forms[0].action="/admin/course/storageUrl";
				document.forms[0].submit();
			});
		})
	</SCRIPT>
<body>
<div class="zTreeDemoBackground left" id="ztree" style="width: 50%;">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	
	<shiro:hasPermission name="/admin/kpoint/addkpoint" >
		<input type="button" id="addVideo" class="top btn btn-default cj"   value="创建视频节点" /><input type="button" class="top btn btn-default cj" onclick="qx()" value="取消选中" />
	</shiro:hasPermission>
	<div style="width: 50%;position: absolute;left: 35%; top: 0px; height: 100%;display: none " id="edit" >
	   <form action="" method="post">
	   <input type="hidden" id="idone" name="id"/>
	    <input type="hidden" value="${id }" name="courseid"/>
	        <input type="file" id="fileupload" class="vam" id="filename"  name="mp4" style="display: block !important;" /> 
	        <div id="fileQueue" class="mt10">
											</div>
											<input type="hidden" name="video_url" id="videourl" value="" style="width: 360px;"/>
											<input type="button" id="btn"  value="上传"/>
											</form>
	</div>
	
	
	
	
	
	


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
 <input type="hidden" value="${id }" name="id"/>
 <input type="hidden" value="" id="pId" name="pId"/>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">目录名称</label>
    <div class="col-sm-10">
      <input type="text" id="names" class="form-control "  >
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">节点名称</label>
    <div class="col-sm-10">
      <input type="text" id="name" class="form-control "  >
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">排序</label>
    <div class="col-sm-10">
     <input type="number" class="form-control" name="sort" >
    </div>
  </div>

  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">类型</label>
    <div class="col-sm-10">
     <select class="form-control" name="is_free">
      <option value="1">免费</option>
      <option value="2">收费</option>
     </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">选择教师</label>
    <div class="col-sm-10">
     <select  class="form-control" name="tid">
    <c:forEach items="${allTeacherBySubjectId }" var="allTeacher">
    <option value="${allTeacher.id }">${allTeacher.name }</option>
    </c:forEach>
</select>
    </div>
  </div>



</form>
      
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="add">添加</button>
      </div>
    </div>
  </div>
</div>
	
	



	
</body>

<script type="text/javascript">




//上传控件加载
function uploadPicLoad(fileupload,showId,fileQueue){
	$("#fileuploadUploader").remove();
	$("#"+fileupload).uploadify({
		'uploader' : '/static/common/uploadify/uploadify.swf', //上传控件的主体文件，flash控件  默认值='uploadify.swf'
		'script'  :'/admin/course/storeVideo',
		'scriptData':{"fileType":"mp4","param":"video"},
		'queueID' : fileQueue, //文件队列ID
		'fileDataName' : 'uploadfile', //您的文件在上传服务器脚本阵列的名称
		'auto' : true, //选定文件后是否自动上传
		'multi' :false, //是否允许同时上传多文件
		'hideButton' : false,//上传按钮的隐藏
		'buttonText' : 'Browse',//默认按钮的名字
		'buttonImg' : '/static/common/uploadify/liulan.png',//使用图片按钮，设定图片的路径即可
		'width' : 105,
		'simUploadLimit' : 3,//多文件上传时，同时上传文件数目限制
		'sizeLimit' : 5120000000,//控制上传文件的大小
		'queueSizeLimit' : 3,//限制在一次队列中的次数（可选定几个文件）
		'fileDesc' : '支持格式:mp4.',//出现在上传对话框中的文件类型描述
		'fileExt' : '*.MP4;*.mp4;*.flv;',//支持的格式，启用本项时需同时声明fileDesc
		'cancelImg' : '/static/common/uploadify/cancel.png',
		onSelect : function(event, queueID,fileObj) {
			fileuploadIndex = 1;
			$("#"+fileQueue).html("");
			if (fileObj.size > 5120000000) {
				alert('文件太大最大限制5120000kb');
				return false;
			}
		},
		onComplete : function(event,queueID, fileObj, response,data) {
			$("#"+showId).val(response);
			//$("#"+showId).show();
			$("#edit").show();
		},
		onError : function(event, queueID, fileObj,errorObj) {
			$("#"+fileQueue).html("<br/><font color='red'>"+ fileObj.name + "上传失败</font>");
		}
	});
}

function initUpdateKpoint(){
	uploadPicLoad('fileupload','videourl','fileQueue');
}

</script>

</html>