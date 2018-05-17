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
			 $("#cname").text("课程名称只能有英文汉字数字且大于四位字符小于十六位字符!");	
				$("#cname").css({"color":"red"});
		}else{
			$.ajax({
		   		type:"post",
		   		url:"/admin/course/getCourseNameRepeat",
		   		async:true,
		   		data:{"course_name":str},
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
    				
    				$("#loseTimeSpan").css({"color":"red"});
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
    		if($("#fileSpans").text()!="√"){
    			if(fileName!=""){
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
            	alert(123)
            	  //$("#userAddForm").submit();
              }
    	})
	})
	
	
    
