var setting = {
				check: {
					enable: true
				},
				data: {
					simpleData: {
						enable: true
					}
				}
			};
var zTreeIN;
var zTreeOUT;
		$(document).ready(function(){
			var deptId = $("input[name='dept.deptId']").val();
			$.ajax({
			type:"post",
			url:"systemAdminAction_getDeptJson.action",
			async:false,
			data:{deptId:deptId},
			dataType:"json",
			success:function(jsonvalue){
					var zNodes = jsonvalue;
					zTreeIN=$.fn.zTree.init($("#treeDemoIN"), setting,zNodes);
					zTreeOUT=$.fn.zTree.init($("#treeDemoOUT"), setting,zNodes);
				   }
		  });
		});

/**
 * 删除一个角色
 * @param {Object} roleId
 */
function deleteOne(roleId){
	var isDel = window.confirm("确认要删除么？");
	if(isDel){
		if(roleId==''||roleId==null||roleId=='undefined'){
			alert("角色ID不能为空！");
			return;
		}else{
			window.location.href="systemAdminAction_delOneRole.action?roleId="+roleId;
		}
	}
}

/**
 * 删除选中的角色
 * 
 */
function deleteSelect(){
	var roleIds = document.getElementsByName("roleIds");
	//var selectedNum = $("input[name='roleIds'][type='checkbox'][checked=true]").length;
	if(roleIds!=null&&roleIds!=''&&roleIds!='undefined'){
		var isCheck = false;
		for(var i=0 ;i<roleIds.length;i++){
			if(roleIds[i].checked){
				isCheck = true;
				break;
			}
		}
		if(!isCheck){
			alert("请选择一个角色!");
		}else{
			 var isDel = window.confirm("确认要删除么？");
		     if(isDel){
		    	document.pageForm.action="systemAdminAction_deleteRoles.action";
		        document.pageForm.submit();
		     }
		}
	}
}
/**
 * 修改一个角色
 * @param {Object} roleId
 */
function modifyOne(roleId){
	if(roleId==''||roleId==null||roleId=='undefined'){
		alert("角色ID不能为空！");
		return;
	}else{
		window.location.href="systemAdminAction_preRoleEdit.action?roleId="+roleId;
	}
}

function goBack(){
	window.location.href="systemAdminAction_queryRoles.action";
}


/**
 * 添加角色/修改
 */
function addOrEditRole(type){
	if($("#roleName").val()==''){
		$("#errMsg").html('<font color=red>请输入角色名！</font>');
		return;
	}else{
		var checkedNodes = zTree.getCheckedNodes(true);
		var menuIds="";
		var roleName = $("#roleName").val();
		var roleRemark = $("#roleRemark").val();
		for(var i=0;i<checkedNodes.length;i++){
			if(i==0){
				menuIds+="menuIds="+checkedNodes[i].id;
			}else{
				menuIds+="&menuIds="+checkedNodes[i].id;
			}
		}
		if(type==0){//添加角色
			location = "systemAdminAction_roleAdd.action?"+menuIds+"&role.roleName="+roleName+"&role.roleRemark="+roleRemark;
		}else if(type==1){
			var roleId = $("#roleId").val();
			location = "systemAdminAction_roleEdit.action?"+menuIds+"&role.roleId="+roleId+"&role.roleName="+roleName+"&role.roleRemark="+roleRemark;
		}
		
	}
}

