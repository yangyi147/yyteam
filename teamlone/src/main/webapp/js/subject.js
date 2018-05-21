function updateSubject(str){
			if(id==0){
				alert("请选择修改的专业!")
			}else{
				
			$("#id").val(id);
			$("#nameTow").val(name);
			$("#myModalupdate").modal("show");
			}
}

function querySubjectRepeat(str,type){
	
	if(type==1){
		if(str==''&&str.trim().length==0){
			$("#nameSpan").text("专业名称不能为空!");
			$("#nameSpan").css({"color":"green"})
			$("#nameSpan").show();
		}else{
			if(str!=name){
				var nameTow=/^[a-zA-Z0-9\u4e00-\u9fa5]{4,8}$/;	
				var names= str.match(nameTow)
				if(names==null){
					$("#nameSpan").text("专业名称只能有英文汉字数字且大于四位字符-八位字符!");	
					$("#nameSpan").css({"color":"red"});
					$("#nameSpan").show();
				}else{
					$.ajax({
						type:"post",
						url:"/admin/professional/querySubjectRepeat",
						async:true,
						data:{"name":str},
						dataType:"json",
						success: function(data){
							if(data==1){
								$("#nameSpan").text("√");
								$("#nameSpan").css({"color":"green"});
								$("#nameSpan").hide();
							}else{
								$("#nameSpan").text("已存在专业名称!");	
								$("#nameSpan").css({"color":"red"});
								$("#nameSpan").show();
							}
						}
					});  
				}
			}
		
		}
	}else{
		if(str==''&&str.trim().length==0){
			$("#nameSpanTow").text("专业名称不能为空!");
			$("#nameSpanTow").css({"color":"green"})
			$("#nameSpanTow").show();
		}else{
			if(str!=name){
				var nameTow=/^[a-zA-Z0-9\u4e00-\u9fa5]{4,8}$/;	
				var names= str.match(nameTow)
				if(names==null){
					$("#nameSpanTow").text("专业名称只能有英文汉字数字且大于四位字符-八位字符!");	
					$("#nameSpanTow").css({"color":"red"});
					$("#nameSpanTow").show();
				}else{
					$.ajax({
						type:"post",
						url:"/admin/professional/querySubjectRepeat",
						async:true,
						data:{"name":str},
						dataType:"json",
						success: function(data){
							if(data==1){
								$("#nameSpanTow").text("√");
								$("#nameSpanTow").css({"color":"green"});
								$("#nameSpanTow").hide();
							}else{
								$("#nameSpanTow").text("已存在专业名称!");	
								$("#nameSpanTow").css({"color":"red"});
								$("#nameSpanTow").show();
							}
						}
					});  
				}
			}
		
		}
	}

	
}

function paixu(str){
	if(str==''||str<0){
		$("#paixuSpan").text("不能为空或小于0");
		$("#paixuSpan").css({"color":"red"});
		$("#paixuSpan").show();
	}else{
		$("#paixuSpan").text("√");
		$("#paixuSpan").hide();
	}
}

function updateSubjectSubmit(){
	if($("#nameTow").val()==name){
		$("#myModalupdate").modal("hide");
		
	}else if($("#nameSpanTow").text()=='√'){
		
			document.forms[1].action = "/admin/professional/updateSubject";
			document.forms[1].submit();
	
	}else if($("#nameSpanTow").text()!='√'){
		$("#nameSpanTow").text("请按照规范填写");	
		$("#nameSpanTow").css({"color":"red"});
		$("#nameSpanTow").show();
	}
	
}
function deleteSubject(){
	if(id==0){
		alert("请选择删除节点!")
	}else{
	   window.location.href="/admin/professional/daleteSubject/"+id;
	}

}
function insert() {
	if($("#nameSpan").text()!="√"){
		$("#nameSpan").text("请按照规范输入专业名称");	
		$("#nameSpan").css({"color":"red"});
		$("#nameSpan").show();
	}
	if($("#paixu").val()<0&&$("#paixu").val()==''){
		$("#paixuSpan").text("不能为空或小于0");
		$("#paixuSpan").css({"color":"red"});
		$("#paixuSpan").show();
	}
	if($("#nameSpan").text()=="√"&&$("#paixu").val()>=0){
		document.forms[0].action = "/admin/professional/insertSubject";
		document.forms[0].submit();
	}
}



