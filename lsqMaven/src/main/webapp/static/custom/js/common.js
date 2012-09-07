/**
 *全选全不选 
 */
function checkAllOrNot(obj,tag){
	if(obj.checked){
		if(tag==null){
			$("input[type='checkbox']").each(function(){this.checked=true;});
		}else{
			$("input[class='"+tag+"']").each(function(){this.checked=true;});
		}
	}else{
		if(tag==null){
			$("input[type='checkbox']").each(function(){this.checked=false;});
		}else{
			$("input[class='"+tag+"']").each(function(){this.checked=false;});
		}
	}
}

//全选
function checkAll(){
	$("input[type='checkbox']").each(function(){this.checked=true;});
}

//全不选
function checkNone(){
	$("input[type='checkbox']").each(function(){this.checked=false;});
}


//选中父菜单
function doCheckPar(obj,parId){
	if(obj.checked){
		document.getElementById(parId).checked = true;
	}
}


/**
 * 提示消息（添加、修改成功后的提示消息）
 */
function loadData(msg){
	if(msg!=''){
		alert(msg);
	}
}

/**
 * 检查必填项
 */
function checkNull(obj){
	if(obj.trim()==''){
		return false;
	}else{
		return true;
	}
}
