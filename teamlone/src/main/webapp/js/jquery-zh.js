 var fileName;
 
	function getDays(year,month){

		 
		//获取年份
		var year = year;

		//获取当前月份
		var mouth = month;

		//定义当月的天数；
		var days ;
		 
		//当月份为二月时，根据闰年还是非闰年判断天数
		if(mouth == 2){
		        days= year % 4 == 0 ? 29 : 28;
		         
		    }
		    else if(mouth == 1 || mouth == 3 || mouth == 5 || mouth == 7 || mouth == 8 || mouth == 10 || mouth == 12){
		        //月份为：1,3,5,7,8,10,12 时，为大月.则天数为31；
		        days= 31;
		    }
		    else{
		        //其他月份，天数为：30.
		        days= 30;
		         
		    }
		  
		    return days;
		   
		}

  //课程名
	function uname(str) {
		var name=/^[a-zA-Z0-9\u4e00-\u9fa5]{4,16}$/;	
		  var names= str.match(name)
		if( names == null){
			 $("#cname").text("课程名称只能有英文汉字数字且大于四位字符-十六位字符!");	
				$("#cname").css({"color":"red"});
		}else{
			$.ajax({
		   		type:"post",
		   		url:"/admin/course/getCourseNameRepeat",
		   		async:true,
		   		data:{"name":str},
		   		dataType:"json",
		   		success: function(data){
		   			if(data==1){
		   			$("#cname").text("√");
		   			$("#cname").css({"color":"green"});
		   			}else{
		   			$("#cname").text("已存在课程名称!");	
		   			$("#cname").css({"color":"red"});
		   			}
		   		}
		   	});
		}
	}
	//课时
	function courseLessionNum(val) {
		if(val!=''&&val<1000&&val>0){
			$("#lessionNum").text("√");
			$("#lessionNum").css({"color":"green"});
		}else{
			$("#lessionNum").text("课时不能为空且不能大于1000!");
			$("#lessionNum").css({"color":"red"});
		}
	}
	
    function courseSoursePrice(soursePrices) {
		if(soursePrices>0&&soursePrices<100000){
			$("#soursePrices").text("√");
  			$("#soursePrices").css({"color":"green"});
		}else{
			$("#soursePrices").text("请输入正确的价格");
  			$("#soursePrices").css({"color":"red"});
		}
}

    function courseCurrentPrice(currentPrice) {
   	 var soursePrice= $("#soursePrice").val();
   	 if(soursePrice<=0){
   		 $("#currentPrice").text("课程原价格不能为空且不能小于0!");
  			$("#currentPrice").css({"color":"red"});
   	 }else{
   		if(currentPrice>0&&currentPrice<=soursePrice){
   			$("#currentPrice").text("√");
     			$("#currentPrice").css({"color":"green"});
   		}else{
   			$("#currentPrice").text("课程销售价格不能大于课程原价格!");
     			$("#currentPrice").css({"color":"red"});
   		}
   	 }
	}
    
    function titleValue(titl) {
		if(titl==""){
			$("#titles").text("课程详情不能为空!")
			$("#titles").css({"color":"red"});
		}else{
			$("#titles").text("√")
			$("#titles").css({"color":"green"});
		}
	}
	function edits(input) {
		var tp=/\.(?:png|jpe?g|jpg)$/;
		if(input.files.length>0){
			fileName=input.files[0].name;
			var a=fileName.match(tp)
			    
				if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#images').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
				$("#images").show();
			}
			if(a==null){
				$("#fileSpans").text("不支持当前图片格式,请使用(png,jpe,jpeg,jpg)图片格式!");
				$("#fileSpans").css({"color":"red"});
			}else{
				$("#fileSpans").text("√");
				$("#fileSpans").css({"display":"none"});
			}
		}else{
			fileName="";
			$("#images").css({"display":"none"});
			$("#fileSpans").text("课程图片不能为空");
			$("#fileSpans").css({"display":"block"});
		}
	
	}
	function endsj(date) {
		if(date>0&&date<712&&date!=''){
			$("#loseTimeSpan").text("√");
			$("#endTimeSpan").text("√");
			$("#endTimeSpan").css({"display":"none"});
			$("#loseTimeSpan").show();
			$("#loseTimeSpan").css({"color":"red"});
		}else{
			$("#loseTimeSpan").text("天数不能为空且不能大于712!");
			$("#loseTimeSpan").css({"color":"red"});
		}
	}
	function endTimesxcw() {
		 $("#endTimeSpan").text("请选择正确的时间")
			 $("#endTimeSpan").css({"color":"red"});
			$("#endTimeSpan").show(); 
		$("#loseTimeSpan").css({"display":"none"});
	}
	function endTimesxzq() {
		$("#endTimeSpan").text("√");
		$("#endTimeSpan").css({"color":"green"});
		$("#endTimeSpan").show();
		$("#loseTimeSpan").text("√")
		$("#loseTimeSpan").css({"display":"none"});
	}
    $(function () {
    	$("#btn").click(function () {
    		if($("#cname").text()!="√"){
    			$("#cname").text("课程不能为空!");
    			$("#cname").css({"color":"red"});
    		}
    		if($("#lessionNum").text()!="√"&&$("#lessionNnum").val>0){
    			$("#lessionNum").text("课时不能为空且不能小于0!");
    			$("#lessionNum").css({"color":"red"});
    		}
    		if($("#soursePrices").text()!="√"&&$("#soursePrice").val>0){
    			$("#soursePrices").text("请输入正确的课程原价!");
      			$("#soursePrices").css({"color":"red"});
    		}
    		if($("#currentPrice").text()!="√"){
    			$("#currentPrice").text("请输入正确的课程销售价格!");
      			$("#currentPrice").css({"color":"red"});
    		}
    		
    		if($("#sz").val()==1){
    			if($("#loseTime").val()!=""&&$("#loseTime").val()<=712&&$("#loseTime").val()>0){
    				$("#loseTimeSpan").text("√");
    				$("#endTimeSpan").text("√");
    				$("#endTimeSpan").css({"display":"none"});
    				
    				$("#loseTimeSpan").css({"color":"green"});
    			}else{
    				$("#loseTimeSpan").text("天数不能为空且不能大于712!");
    				$("#loseTimeSpan").css({"color":"red"});
    			}
    		}else{
    			 
    			if($("#endTime").val()==""){
    				$("#endTimeSpan").text("时间不能为空!");
    				$("#endTimeSpan").css({"color":"red"});
    			}else{
    				var myDate = new Date();
    				var year=myDate.getFullYear();
    				var month=myDate.getMonth()+1;
    				var date=myDate.getDate();
    			    var now=year+"-"+month+"-"+date
    				var time=$("#endTime").val();
       			 var times= time.split("-");
       		
       			 if(times[0]>year && times[1]>0&&times[1]<13){
       				var ts= getDays(times[0],times[1]);
       				 if(times[2]>0&&times[2]<=ts){
       					 var nowTow=year+2+"-"+month+"-"+date;
//       				 alert(times[0]<=(year+2))
//       				 alert(times[1]<=month)
//       				 alert(times[2]<=date)
       				 if(times[0]<=(year+2)){
       					if(times[0]==(year+2)){
       						if(times[1]<=month){
       							if(times[1]==month){
       								if(times[2]<=date){
       									endTimesxzq();
       								}else{
       									endTimesxcw();	
       								}
       							}else{
       								endTimesxzq();
       							}
       						}else{
       							endTimesxcw();
       						}
       					}else{
       						endTimesxzq();
       					}
       				 }else{
       					endTimesxcw();
       				 } 
       				 }else{
       					endTimesxcw(); 
       				 }
       			 }else{
       				endTimesxcw(); 
       			 }
       			 
//    				$("#loseTimeSpan").text("√");
//    				$("#endTimeSpan").text("√");
//    				$("#endTimeSpan").css({"display":"block"});
//    				$("#loseTimeSpan").css({"display":"none"});
//    				$("#loseTimeSpan").css({"color":"red"});
    			}
    		}
    		if($("#titles").text()!="√"){
    			$("#titles").text("请输入课程简介!");
    			$("#titles").css({"color":"red"});
    		}
    		alert($("#fileSpans").text())
    		if($("#fileSpans").text()!="√"){
    			alert(fileName)
    			if(fileName!=""&&fileName!="undefined"&&fileName!=null){
    				$("#fileSpans").text("请选择正确的图片格式!");
    				$("#fileSpans").css({"color":"red"});
    				$("#fileSpans").css({"display":"block"});
    			}else{
    				$("#fileSpans").text("课程图片不能为空!");
    				$("#fileSpans").css({"color":"red"});
    				$("#fileSpans").css({"display":"block"});
    			}
    		}
    		var html = um.getContent();
              if(html==""){
            	 $("#contextSpan").text("课程详情不能为空!") 
            	 $("#contextSpan").css({"color":"red"});
              }else{
            	  $("#contextSpan").text("√")
            	  $("#contextSpan").css({"display":"none"});
              }
              if($("#ssid").val()==0||$("#ssid").val()==''){
            	  $("#subject").text("请选择专业!");
            	  $("#subject").css({"color":"red"});
            	  $("#subject").show();
              }else{
            	  $("#subject").text("√");
            	  $("#subejct").hide();
              }
//              alert($("#cname").text()=="√")
//              alert($("#lessionNum").text()=="√");
//              alert($("#soursePrices").text()=="√")
//              alert($("#currentPrice").text()=="√")
//              alert($("#loseTimeSpan").text()=="√")
//              alert($("#endTimeSpan").text()=="√")
//              alert($("#titles").text()=="√")
//              alert($("#fileSpans").text()=="√")
//              alert($("#contextSpan").text()=="√")
              if($("#subject").text()=="√"&&$("#cname").text()=="√"&&$("#lessionNum").text()=="√"&&$("#soursePrices").text()=="√"&&$("#currentPrice").text()=="√"&&$("#loseTimeSpan").text()=="√"&&$("#endTimeSpan").text()=="√"&&$("#titles").text()=="√"&&$("#fileSpans").text()=="√"&&$("#contextSpan").text()=="√"){
            	  $("#userAddForm").submit();
              }
    	})
	})
	
	// 校验添加 修改用户
	
	function loginName(str) {
    	if(lgiName!=null&&lgiName.trim().length>0&&lgiName==str){
    		$("#login_nameSpan").text("√");
   			$("#login_nameSpan").hide();
    	}else{
        	if(str.trim().length==0){
        		$("#login_nameSpan").text("用户名不能为空!");	
    			$("#login_nameSpan").css({"color":"red"});
        	}else{
        	var name=/^[a-zA-Z0-9]{6,16}$/;	
    		  var names= str.match(name)
    		if( names == null){
    			 $("#login_nameSpan").text("只能有字母数字且大于六位字符小于十六位字符!");	
    				$("#login_nameSpan").css({"color":"red"});
    				$("#login_nameSpan").show();
    		}else{
    			$("#login_nameSpan").hide();
    			$.ajax({
    		   		type:"post",
    		   		url:"/admin/user/checkRepeat",
    		   		async:true,
    		   		data:{"login_name":str},
    		   		dataType:"json",
    		   		success: function(data){
    		   			if(data==true){
    		   			$("#login_nameSpan").text("√");
    		   			$("#login_nameSpan").hide();
    		   			}else{
    		   			$("#login_nameSpan").text("已存在用户名!");	
    		   			$("#login_nameSpan").css({"color":"red"});
    		   			$("#login_nameSpan").show();
    		   			}
    		   		}
    		   	});
    		}
    	}
    	}

    }
	
    function loginPwds(str) {
    	if(str!=loginPwd){
    		$("#login_pwd").attr("name","login_pwd")
    	if(str.trim().length==0){
    		  $("#loginPwdSpan").text("密码不能为空!");
    		  $("#loginPwdSpan").css({"color":"red"});
    		  $("#loginPwdSpan").show() 
    	}else{
    	var name=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
    	  var names= str.match(name);
    	  if(names==null){
    		  $("#loginPwdSpan").text("密码长度位6-16且不能全为字母或者全为数字");
    		  $("#loginPwdSpan").css({"color":"red"});
    		  $("#loginPwdSpan").show() 
    	  }else{
    		  $("#loginPwdSpan").text("√"); 
    		  $("#loginPwdSpan").hide() 
    	  }
    	}
    	}
	}
    function userName(str) {
   	if(str.trim().length==0){
    		  $("#user_nameSpan").text("用户名不能为空!");
    		  $("#user_nameSpan").css({"color":"red"});
    		  $("#user_nameSpan").show() 
    	}else{
    	var hz=/^[\u4e00-\u9fa5]{2,4}$/;
    	var yw=/^[ a-zA-Z]{4,10}$/;
    	  var names= str.match(hz);
    	  if(names==null){
    		  var namef= str.match(yw);
    		  if(namef==null){
    			  $("#user_nameSpan").text("中文2-4位,英文4-10位");
        		  $("#user_nameSpan").css({"color":"red"});
        		  $("#user_nameSpan").show()   
    		  }else{
    			  $("#user_nameSpan").text("√"); 
        		  $("#user_nameSpan").hide() 
    		  }
    		  
    	  }else{
    		  $("#user_nameSpan").text("√"); 
    		  $("#user_nameSpan").hide() 
    	  }
    	}
	}
    
    function emailValidation(str){
    	var name= /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
    	if(str.trim().length==0){
    		 $("#emailSpan").text("Email不能为空")
    		 $("#emailSpan").css({"color":"red"});
   		     $("#emailSpan").show()   
    	}else{
    		var names= str.match(name);
    		if(names==null){
    			$("#emailSpan").text("请使用正确的Email格式")
    			$("#emailSpan").css({"color":"red"});
    			$("#emailSpan").show() 
    		}else{
    			$("#emailSpan").text("√")
    			$("#emailSpan").hide()  
    		}
    	}
    }
    
    function phoneValidation(str){
    	if(str==null &&str.trim().length==0){
    		$("#telSpan").text("电话不能为空!");
    		$("#telSpan").css({"color":"red"});
			$("#telSpan").show() 
    	}else{
    		var  regex = /^((0\d{2,3}-\d{5,8})|(1[35784]\d{9}))$/;
            var name= str.match(regex);	
            if(name==null){        
            		$("#telSpan").text("请输入正确的电话格式!");
            		$("#telSpan").css({"color":"red"});	
            		$("#telSpan").show();
            }else{
            	$("#telSpan").text("√");
    			$("#telSpan").hide() 
            }
    	}
    }
    
    function subject(){
    	if($("#login_nameSpan").text()!="√"&&$("#login_nameSpan").text()!=""){
    		$("#login_nameSpan").text("格式不正确!");	
   			$("#login_nameSpan").css({"color":"red"});
   			$("#login_nameSpan").show();
    	}
    	
    	if($("#login_pwd").val()!=loginPwd){
    
    		if( $("#loginPwdSpan").text()!="√"&&$("#loginPwdSpan").text()!=""){
    			$("#loginPwdSpan").text("格式不正确");
    			$("#loginPwdSpan").css({"color":"red"});
    			$("#loginPwdSpan").show() 
    			$("#login_pwd").attr("name","")
    		}else{
    			$("#login_pwd").attr("name","login_pwd")
    		}
    	}
    	if( $("#user_nameSpan").text()!="√"&&$("#user_nameSpan").text()!=""){
    		$("#user_nameSpan").text("格式不正确");
    		$("#user_nameSpan").css({"color":"red"});
    		$("#user_nameSpan").show() 
    	}
    	if( $("#emailSpan").text()!="√"&&$("#emailSpan").text()!=""){
    		$("#emailSpan").text("格式不正确");
    		$("#emailSpan").css({"color":"red"});
    		$("#emailSpan").show() 
    	}
    	if( $("#telSpan").text()!="√"&&$("#telSpan").text()!=""){
    		$("#telSpan").text("格式不正确");
    		$("#telSpan").css({"color":"red"});
    		$("#telSpan").show() 
    	}
    	if($("#telSpan").text()=="√"||$("#telSpan").text()==""&&$("#emailSpan").text()=="√"||$("#emailSpan").text()==""&&$("#user_nameSpan").text()=="√"||$("#user_nameSpan").text()==""&&$("#loginPwdSpan").text()=="√"||$("#loginPwdSpan").text()==""&&$("#login_nameSpan").text()=="√"||$("#login_nameSpan").text()==""){
    		$("#updateSubject").submit();
    	}      
    }
