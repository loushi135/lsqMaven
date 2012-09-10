var zTree;
var setting;
var status = 0;//0表示添加子节点,1表示编辑节点（按钮提交）
 setting = {
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
			onCheck: toClear
		}
	};
$(document).ready(function(){
		$.ajax({
			type:"post",
			url:_ctx+"/system/getMenuJson.do?content=json",
			async:false,
			dataType:"json",
			success:function(jsonvalue){
							var zNodes = jsonvalue.jsonData;
							zTree=$.fn.zTree.init($("#treeDemo"), setting,zNodes);
				   }
		  });
		  
		   $('#subBtn').click(function(){
			var url;
			var sendData;
			tmp = zTree.getCheckedNodes(true);
			var menuName = $("#menuName").val();
			var menuUrl = $("#menuUrl").val();
			var menuOrder = $("#menuOrder").val();
			var menuId = tmp[0].id;
			if(status==0){
			   url = _ctx+"/system/addMenu.do?content=json";
			   sendData = "menuName="+menuName+"&menuUrl="+menuUrl+"&menuOrder="+menuOrder+"&parentMenuId="+menuId+"&now="+new Date();
			   //sendData = {menu.menuName:menuName,menu.menuUrl:menuUrl,menu.menuOrder:menuOrder,parentMenuId:menuId,now:new Date()};
			}else{
			   url = _ctx+"/system/modifyMenu.do?content=json";
			   sendData = "menuName="+menuName+"&menuUrl="+menuUrl+"&menuOrder="+menuOrder+"&menuId="+menuId+"&now="+new Date();
			   //sendData = {menu.menuName:menuName,menu.menuUrl:menuUrl,menu.menuOrder:menuOrder,menu.menuId:menuId,now:new Date()};
			}
			$.ajax({type:"post",url:url,async:false,data:sendData,dataType:"json",success:function(jsonvalue){
				if(jsonvalue!=null&&jsonvalue.jsonData.success){
					if(status==0){
						var newNode = [{name:menuName,id:jsonvalue.jsonData.menuId,menuUrl:menuUrl,menuOrder:menuOrder}];
						zTree.addNodes(tmp[0],newNode);
						tmp[0].isParent = true;
						zTree.refresh();
					}else{
						tmp[0].name = menuName;
						tmp[0].menuUrl = menuUrl;
						tmp[0].menuOrder = menuOrder;
					    zTree.updateNode(tmp[0]);
					    zTree.refresh();
					}
					toClear();
				}
				    alert(jsonvalue.jsonData.message);
			  }
			});
		});
		 
		 
});

	
	/**
	 * 添加子节点
	 * @return {TypeName} 
	 */
	function addSubMenu(){
		tmp = zTree.getCheckedNodes(true);
		if(tmp.length==0){
			alert('请选择一个节点操作！');
			return;
		}
		if(tmp[0].level>=2){
			alert("当前只支持二级菜单");
			return;
		}
		$(":text").val('');
	    $("#mySubTable").attr("style","display:");
	    status = 0;
	}
	
	
	/**
	 * 编辑节点
	 */
	function editMenu(){
		tmp = zTree.getCheckedNodes(true);
		if(tmp.length==0){
			alert('请选择一个节点操作！');
			return;
		}
		if(tmp[0].level==0){
			alert("不允许编辑根节点");
			return;
		}
		var menuName = tmp[0].name;
		var menuUrl = tmp[0].menuUrl;
		var menuOrder = tmp[0].menuOrder;
		$("#menuName").val(menuName);
		$("#menuUrl").val(menuUrl);
		$("#menuOrder").val(menuOrder);
		$("#mySubTable").attr("style","display:");
		status = 1;
	}
	
	
	/**
	 * 删除节点
	 */
	function deleteMenu(){
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
			var url = _ctx+"/system/deleteMenu.do?content=json";
			var menuId = tmp[0].id;
			var sendData = "menuId="+menuId+"&now="+new Date();
			//var sendData = {menu.menuId:menuId,now:new Date()};
			$.ajax({type:"post",url:url,async:false,data:sendData,dataType:"json",success:function(jsonvalue){
				if(jsonvalue!=null&&jsonvalue.jsonData.success){
					//tmp[0].parentNode.isParent = false;
					zTree.removeNode(tmp[0]);
					zTree.refresh();
				}
				alert(jsonvalue.jsonData.message);
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