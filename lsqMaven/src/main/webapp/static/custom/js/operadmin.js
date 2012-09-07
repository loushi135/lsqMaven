/**
 * 删除一个用户
 * @param {Object} operId
 */
function deleteOne(operId){
	var isDel = window.confirm("确认要删除么？");
	if(isDel){
		if(operId==''||operId==null||operId=='undefined'){
			alert("角色ID不能为空！");
			return;
		}else{
			window.location.href="systemAdminAction_delOneOper.action?operId="+operId;
		}
	}
}

/**
 * 检查用户名是否存在
 * @param {Object} obj
 */
function checkLoginName(obj){
		var url = "systemAdminAction_checkLoginName.action";
		var sendData = {now : new Date(),loginName:obj.value};
		$.ajax({type:"post",url:url,async:false,data:sendData,dataType:"json",success:function(jsonvalue){
			if(jsonvalue!=null&&jsonvalue.success){
                $("#errorLoginName").html('<font color=red>已存在的用户</font>');
			}else{
				$("#errorLoginName").html('');
			}
		  }
		});
}

/**
 * 修改一个用户
 * @param {Object} operId
 */
function modifyOne(operId){
	if(operId==''||operId==null||operId=='undefined'){
		alert("用户ID不能为空！");
		return;
	}else{
		window.location.href="systemAdminAction_preEditOper.action?operId="+operId;
	}
}


/**
 * 用户详情
 * @param {Object} operId
 */
function detailOne(operId){
	if(operId==''||operId==null||operId=='undefined'){
		alert("用户ID不能为空！");
		return;
	}else{
		window.location.href="systemAdminAction_toOperDetail.action?operId="+operId;
	}
}


function goBack(){
	window.location.href="systemAdminAction_queryOpers.action";
}

/**
 * 删除选中的用户
 * 
 */
function deleteSelect(){
	var operIds = document.getElementsByName("operIds");
	if(operIds!=null&&operIds!=''&&operIds!='undefined'){
		var isCheck = false;
		for(var i=0 ;i<operIds.length;i++){
			if(operIds[i].checked){
				isCheck = true;
				break;
			}
		}
		if(!isCheck){
			alert("请选择一个用户!");
		}else{
			 var isDel = window.confirm("确认要删除么？");
		     if(isDel){
		    	document.pageForm.action="systemAdminAction_deleteOpers.action";
		        document.pageForm.submit();
		     }
		}
	}
}

/**
 * 锁定选中的用户
 * 
 */
function lockSelect(obj){
	var operIds = document.getElementsByName("operIds");
	if(operIds!=null&&operIds!=''&&operIds!='undefined'){
		var isCheck = false;
		for(var i=0 ;i<operIds.length;i++){
			if(operIds[i].checked){
				isCheck = true;
				break;
			}
		}
		if(!isCheck){
			alert("请选择一个用户!");
		}else{
			 var isDel = window.confirm(obj==0?"确认要禁用么？":"确认要解锁么?");
		     if(isDel){
		    	document.pageForm.action="systemAdminAction_lockOpers.action?status="+obj;
		        document.pageForm.submit();
		     }
		}
	}
}


/**
 * 添加用户
 */
function addOrEditOper(obj){
	if(obj==1){
		if($.trim($("#loginname").val())==''){
			alert("请输入登录名！");
			return;
		}
		if($("#errorLoginName").html()!=''){
			alert("登录名已存在！");
			return;
		}
		if($.trim($("#firstPsw").val())==''){
			alert("请输入密码！");
			return;
		}
		if($.trim($("#secondPsw").val())==''){
			alert("请确认密码！");
			return;
		}
	}
	if($("#secondPsw").val()!=$("#firstPsw").val()){
		alert("两次密码不一致！");
		return;
	}
	if($.trim($("#operName").val())==''){
		alert("请输入姓名！");
		return;
	}
	if($.trim($("#roleId").val())==''){
		alert("请选择角色！");
		return;
	}
	window.document.forms[0].submit();
}

function getDept(obj,domId,deptId){
	   if(obj=='')return;
	   try {
		var url = "${pageContext.request.contextPath}/systemAdminAction_getDepts.action";
		var sendData = {
			dataId : obj,
			now : new Date()
		};
		$.ajax( {
			type : "post",
			url : url,
			async : false,
			data : sendData,
			dataType : "json",
			success : function(jsonvalue) {
				if (jsonvalue != null) {
					var content = "<option value=\"\">请选择</option>";
						$.each(jsonvalue, function(i, item) {
							if(deptId==item.id){
								content += "<option selected=\"selected\" value=\"" + item.id + "\">"
										+ item.name + "</option>";
							}else{
								content += "<option value=\"" + item.id + "\">"
										+ item.name + "</option>";
							}
						});
						$("#" + domId).html(content);
				} else {
					$("#" + domId).html("<option value=\"\">请选择</option>");
				}
			},
			error : function() {
			}
		});
	} catch (e) {
	}
}


