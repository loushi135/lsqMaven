/**
 * 删除一个联系人
 * @param {Object} operId
 */
function deleteOne(code){
	var isDel = window.confirm("确认要删除么？");
	if(isDel){
		if(code==''||code==null||code=='undefined'){
			alert("联系人编号不能为空！");
			return;
		}else{
			window.location.href="ContractAction_delOneContractor.action?code="+code;
		}
	}
}



/**
 * 修改一个用户
 * @param {Object} operId
 */
function modifyOne(code){
	if(code==''||code==null||code=='undefined'){
		alert("联系人编号不能为空！");
		return;
	}else{
		window.location.href="ContractAction_preEditContractor.action?code="+code;
	}
}





function goBack(){
	window.location.href="ContractAction_queryContract.action";
}

/**
 * 删除选中的用户
 * 
 */
function deleteSelect(){
	var contractIds = document.getElementsByName("contractIds");
	if(contractIds!=null&&contractIds!=''&&contractIds!='undefined'){
		var isCheck = false;
		for(var i=0 ;i<contractIds.length;i++){
			if(contractIds[i].checked){
				isCheck = true;
				break;
			}
		}
		if(!isCheck){
			alert("请选择一个用户!");
		}else{
			 var isDel = window.confirm("确认要删除么？");
		     if(isDel){
		    	document.pageForm.action="ContractAction_deleteContractors.action";
		        document.pageForm.submit();
		     }
		}
	}
}



/**
 * 新增或修改联系人
 */
function addOrEditContractor(obj){
    if(obj==1){
       var url = "ContractAction_queryDoctorByCodeAndName.action";
       var sendData = {doctorName:$("#project").val(),doctorCode:$("#employeeCode").val()};
       $.post(url,sendData,function(returnValue){
         if(returnValue=="true"){
            url = "ContractAction_checkCanAddEmpContractor.action";
            sendData = {doctorCode:$("#employeeCode").val()};
            $.post(url,sendData,function(returnValue){
               if(returnValue=="true"){
                   document.forms[0].submit();
               }else{
                   alert("联系人已经存在!");
               }
            },"text");
            
         }else{
              alert("找不到这个专家!");
              return;
         }
       
       },"text");
    }
    if(obj==2){
       document.forms[0].submit();
    }
}

