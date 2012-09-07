/*读取排班*/
function readNo(){
  var myForm =  document.getElementsByName("viewWorkDay")[0];
  myForm.action = "MzRequestDayAction_toMzRequestDayIndex.action";
  myForm.submit();
}

/*进入修改排班页面*/
function toEditWorkDay(){
   var workIndexsObjs = document.getElementsByName("workIndexs");
   var checkValue = "";
   for(var i=0;i<workIndexsObjs.length;i++){
      if(workIndexsObjs[i].checked){
         checkValue = workIndexsObjs[i].value;
      }
   }
   if(checkValue==""){
     alert("请选择要修改的排班！");
   }else{
     var url = "MzRequestDayAction_checkCanModifyWorkDay.action";
     var sendData = {workIndexs:checkValue};
     $.post(url,sendData,function(returnValue){
       if(returnValue=="true"){
	      	var url = "MzRequestDayAction_preMzrequestEdit.action?workIndexs="+checkValue+"&d="+new Date().getTime();
	      	var sFeatures = "center:yes;dialogHeight:800px;dialogWidth:1000px;resizable:no";
	    	window.showModalDialog(url,"",sFeatures);
	     	window.document.getElementsByName("viewWorkDay")[0].submit();
       }else{
          alert(returnValue);
       }
     },"text");
   }

}


/**进入新增排班页面*/
function toAddWorkDay(){
  var dom = document.getElementById("deptSelect");
  var deptIndex = dom.selectedIndex;
  if(deptIndex<=0){
   	alert("请先选择科室！");
  }else{
     var deptCode = dom.options[deptIndex].value;
     var deptName = dom.options[deptIndex].title;
   　 var url = "MzRequestDayAction_preMzrequestAdd.action?deptCode="+deptCode+"&deptName="+encodeURI(deptName)+"&d="+new Date().getTime();;
     var sFeatures = "center:yes;dialogHeight:800px;dialogWidth:1000px;resizable:no";
     window.showModalDialog(url,"",sFeatures);
     window.document.getElementsByName("viewWorkDay")[0].submit();
  }
}

/*查看各时间段信息*/
function toViewTimeSet(workIndexs){
 	var url = "MzRequestDayAction_toShowTime.action?workIndexs="+workIndexs+"&d="+new Date().getTime();;
	var sFeatures = "center:yes;dialogHeight:200px;dialogWidth:500px;resizable:no";
	window.showModalDialog(url,"",sFeatures);
	//window.document.getElementsByName("viewWorkDay")[0].submit();
}


/*查看停诊信息*/
function toStopWorkDayPage(){
　　var workIndexsObjs = document.getElementsByName("workIndexs");
   var checkValue = "";
   for(var i=0;i<workIndexsObjs.length;i++){
      if(workIndexsObjs[i].checked){
         checkValue = workIndexsObjs[i].value;
      }
   }
   if(checkValue==""){
     alert("请选择需要停诊的排班！");
   }else{
       var url = "MzRequestDayAction_toStopWorkDay.action?workIndexs="+checkValue+"&d="+new Date().getTime();;
	　　var sFeatures = "center:yes;dialogHeight:500px;dialogWidth:500px;resizable:no";
	　　window.showModalDialog(url,"",sFeatures);
	　　window.document.getElementsByName("viewWorkDay")[0].submit();
   }
}

/**
*保存排班
*/
function doSaveWorkDay(){
  　var requestDay = $("#requestDay").val();
    var totleNum = $("#totleNum").val();
　　 var doctorName = $("#project").val(); 
    var startNo = $("#q1P").val();
　　var times = document.getElementsByName("timesSets");
　　 if(doctorName==""){
      $("#doctorCode").val("");
    }
    if(requestDay==""){
      alert("排班日期不能为空！");
      return;
    }
    if(totleNum==""){
      alert("总号数不能为空！");
      return;
    }
    var count = 0;
    if(times!=null&&times!="undefined"){
      for(var i=0;i<times.length;i++){
		var tValue = times[i].value;      
		var v = tValue.split("_")[1];
		if(v!=""){
		 count+=parseInt(v);
		}
      }
    }
    if(count!=0){
       if(startNo==""){
         alert("预约时间段内号不为空，请输入预约起始号！");
         return;
       }
       if(count>parseInt(totleNum)-parseInt(startNo)+1){
         alert("预约总号超过可预约数量！");
         return;
      }
    }
　　document.getElementsByName("addForm")[0].submit();
}

/*修改排班*/
function doEditWorkDay(){
    var totleNum = $("#totleNum").val();
    var startNo = $("#q1P").val();
　　var times = document.getElementsByName("timesSets");
    if(totleNum==""){
      alert("总号数不能为空！");
      return;
    }
    var count = 0;
    if(times!=null&&times!="undefined"){
      for(var i=0;i<times.length;i++){
		var tValue = times[i].value;      
		var v = tValue.split("_")[1];
		if(v!=""){
		 count+=parseInt(v);
		}
      }
    }
    if(count!=0){
       if(startNo==""){
         alert("预约时间段内号不为空，请输入预约起始号！");
         return;
       }
       if(count>parseInt(totleNum)-parseInt(startNo)+1){
         alert("预约总号超过可预约数量！");
         return;
      }
    }
　　document.getElementsByName("editForm")[0].submit();
}


/**
*返回
*/
function doBackModelDialog(){
  window.close();
}


/*确认停诊*/
function confirmAndSendNote(workIndex){
   var url = "MzRequestDayAction_stopWorkDay.action";
     var sendData = {workIndexs:workIndex};
     $.post(url,sendData,function(returnValue){
       if(returnValue=="true"){
          alert("停诊成功！");
          window.close();
       }else{
          alert(returnValue);
       }
     },"text");
}

/**
*时间键盘响应事件
*/
function doCheckWorkTime(obj){
  var hiddenId = "myTime"+obj.lang;
  var timeValue = obj.value;
  var regx = /^[1-9]\d*$/;
  if(!regx.test(timeValue)){
     obj.value="";
     document.getElementById(hiddenId).value=obj.lang+"_";
  }else{
    document.getElementById(hiddenId).value=obj.lang+"_"+obj.value;
  }
}


/*只能输入数字*/
function doCheckNum(obj){
   var regx = /^[1-9]\d*$/;
   if(!regx.test(obj.value)){
     obj.value="";
   }
}

/*更新部门信息*/
function updateDept(obj){
    var url = "JsonAction_getDeptJson.action";
    var sendData = {deptSearchContext:obj.value};
    $.post(url,sendData,function(returnValue){
      if(returnValue!=null){
         if(returnValue.depts!=null){
            var content = "<option value=\"\">科室名称</option>";
            $.each(returnValue.depts,function(i,item){
               if(item.deptName.length<10){
              	 content+="<option title=\""+item.deptName+"\" value=\""+item.deptCode+"\">"+item.deptName+"</option>";
               }else{
                  content+="<option title=\""+item.deptName+"\" value=\""+item.deptCode+"\">"+item.deptName.substring(0,10)+"...</option>";
               }
            });
            $("#deptSelect").html(content);
         }
      }
    },"json");
    
}



 

function changeTimeSet(obj){
  if(obj.value=='a'){
     $(".am").attr("style","display:");
     $(".pm").attr("style","display:none");
     $(".timeValue").val("");
     
     $(".hiddenValue").val($(".hiddenValue").val().split("_")[0]+"_");
  }
  
  if(obj.value=='p'){
     $(".am").attr("style","display:none");
     $(".pm").attr("style","display:");
     $(".timeValue").val("");
      $(".hiddenValue").val($(".hiddenValue").val().split("_")[0]+"_");
  }
   if(obj.value=='d'){
     $(".am").attr("style","display:");
     $(".pm").attr("style","display:");
     $(".timeValue").val("");
      $(".hiddenValue").val($(".hiddenValue").val().split("_")[0]+"_");
  }

}