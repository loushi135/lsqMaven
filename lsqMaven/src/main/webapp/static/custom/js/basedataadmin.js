var setting;//异步  autoParam: ["id=parentId"]   后台接收parentId  设置 id 属性作为 parentId 成为自动提交的参数
var zTree;
var status = 0;//0表示添加子节点,1表示编辑节点（按钮提交）
$(function(){
	 setting = {
			async: {
				enable: true,
				url:"systemAdminAction_getBaseDataJson.action",
				autoParam: ["id=parentId"]
			},
			check: {
				enable: true,
				chkStyle: "radio",
				radioType: "all"
				},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onCheck: toClear,
				onClick: zTreeOnClick
			}
		};
			//$.fn.zTree.init($("#treeDemo"), setting);
			zTree=$.fn.zTree.init($("#treeDemo"), setting);
			
			$('#subBtn').click(function(){
				var url;
				var sendData;
				tmp = zTree.getCheckedNodes(true);
				var name = $("#name").val();
				var orderInfo = $("#orderInfo").val();
				var code = $("#code").val();
				var baseDataId = tmp[0].id;
				if(status==0){
				   url = "systemAdminAction_addSubBaseDataJson.action";
				   sendData = "baseData.name="+name+"&baseData.orderInfo="+orderInfo+"&baseData.code="+code+"&parentId="+baseDataId+"&now="+new Date();
				}else{
				   url = "systemAdminAction_editSubBaseDataJson.action";
				   sendData = "baseData.name="+name+"&baseData.orderInfo="+orderInfo+"&baseData.code="+code+"&baseData.id="+baseDataId+"&now="+new Date();
				}
				$.ajax({type:"post",url:url,async:false,data:sendData,dataType:"json",success:function(jsonvalue){
					if(jsonvalue!=null&&jsonvalue.success){
						if(status==0){
							var newNode = [{name:name,id:jsonvalue.baseDataId,orderInfo:orderInfo}];
							zTree.addNodes(tmp[0],newNode);
							tmp[0].isParent = true;
							zTree.refresh();
						}else{
							tmp[0].name = name;
							tmp[0].orderInfo = orderInfo;
							tmp[0].code = code;
						    zTree.updateNode(tmp[0]);
						    zTree.refresh();
						}
						toClear();
					}
					    alert(jsonvalue.message);
				  }
				});
			});
		
	});
		

	/**
	 * 添加子节点
	 * @return {TypeName} 
	 */
	function addSubBaseData(){
		tmp = zTree.getCheckedNodes(true);
		if(tmp.length==0){
			alert('请选择一个节点操作！');
			return;
		}
		//if(tmp[0].level>=2){
		//	alert("当前只支持二级菜单");
		//	return;
		//}
		$(":text").val('');
	    $("#mySubTable").attr("style","display:");
	    status = 0;
	}
	
	
	/**
	 * 编辑节点
	 */
	function editBaseData(){
		tmp = zTree.getCheckedNodes(true);
		if(tmp.length==0){
			alert('请选择一个节点操作！');
			return;
		}
		if(tmp[0].level==0){
			alert("不允许编辑根节点");
			return;
		}
		var name = tmp[0].name;
		var code = tmp[0].code;
		var orderInfo = tmp[0].orderInfo;
		$("#name").val(name);
		$("#code").val(code);
		$("#orderInfo").val(orderInfo);
		$("#mySubTable").attr("style","display:");
		status = 1;
	}
	
	
	/**
	 * 删除节点
	 */
	function deleteBaseData(){
		tmp = zTree.getCheckedNodes(true);
		if(tmp.length==0){
			alert('请选择一个节点操作！');
			return;
		}
		if(tmp[0].level==0){
			alert("不允许删除根节点");
			return;
		}
		var isDelete = window.confirm("确认要删除么");
		if(isDelete){
			var url = "systemAdminAction_deleteSubBaseDataJson.action";
			var baseDataId = tmp[0].id;
			var sendData = "baseData.id="+baseDataId+"&now="+new Date();
			$.ajax({type:"post",url:url,async:false,data:sendData,dataType:"json",success:function(jsonvalue){
				if(jsonvalue!=null&&jsonvalue.success){
					//tmp[0].parentNode.isParent = false;
					zTree.removeNode(tmp[0]);
					zTree.refresh();
				}
				alert(jsonvalue.message);
			  }
			});
		}
	}
		
/**
	 * 隐藏文本框并清除值
	 */
	function toClear(){
		$(":text").val('');
		$("#mySubTable").attr("style","display:none");
	}
	
	function zTreeOnClick(){
		
	
	}