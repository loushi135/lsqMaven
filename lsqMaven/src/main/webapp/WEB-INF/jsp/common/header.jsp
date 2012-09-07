<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div class="top_bg">
	<div class="floatL">
		<img src="${ctx}/static/custom/images/top_pic1.jpg" />
	</div>
	<div class="top_menu">
		<li class="top_menu_icon1">
			<a href="#">前台主页</a>
		</li>
		<li class="top_menu_icon3">
			<a href="javascript:void(0)" onclick="toEditPsw()">修改密码</a>
		</li>
		<li class="top_menu_icon2">
			<a href="systemAdminAction_logout.action">退出系统</a>
		</li>
	</div>
</div>
<script type="text/javascript">
  function toEditPsw(){
       	var url = "systemAdminAction_toEditPswPage.action";
	    var sFeatures = "center:yes;dialogHeight:190px;dialogWidth:350px;resizable:no";
	    window.showModalDialog(url,"",sFeatures);
  }
</script>
