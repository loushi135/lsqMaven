<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
<title>附一院医院自助管理系统</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/mainstyle.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/zTree3/css/zTreeStyle/zTreeStyle.css"
	type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/zTree3/js/jquery.ztree.core-3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/zTree3/js/jquery.ztree.excheck-3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/zTree3/js/jquery.ztree.exedit-3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/roleadmin.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common.js"></script>
</head>
<body onload="loadData('${msg}')>
	<form action="systemAdminAction_roleEdit.action" method="post">
	<div class="position">
	  <div class="position_txt"><span class="bold">当前位置：</span>系统管理 &gt;&gt; 修改角色</div>
	</div><div class="main_area1"><div class="main_area1_a"><div class="main_area1_line">
	  <div class="main_area1_title">修改角色</div>
	</div>
	    <div class="pad10">
	      <div>
	        <table width="100%" border="0" cellspacing="8" cellpadding="0" class="floatL">
	          <input type="hidden" name="role.roleId" id="roleId" value="${role.roleId}"/>
	          <tr>
	            <td width="9%" align="right" nowrap="nowrap">角色名：</td>
	            <td width="91%" nowrap="nowrap"><input type="text" name="role.roleName" id="roleName" value="${role.roleName}" class="input250" /><span id="errMsg"></span></td>
	          </tr>
	          <tr>
	            <td  align="right" nowrap="nowrap">角色描述：</td>
	            <td  nowrap="nowrap"><input type="text" name="role.roleRemark" id="roleRemark" class="input250" value="${role.roleRemark}"  /><span id="errMsg"></span></td>
	          </tr>
	          <tr>
	            <td align="right" nowrap="nowrap">角色权限设置：</td>
	            <td nowrap="nowrap">
					<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
	          </td>
	          </tr>
	          <tr>
	            <td align="right" nowrap="nowrap">&nbsp;</td>
	            <td nowrap="nowrap"><input type="button" name="button" id="button" value="提交" onclick="addOrEditRole(1)" class="btn_bb2"  />
	              <input type="button" name="button3" id="button3" value="重置" class="btn_bb2"  onclick="checkNone();"/>
	              <input type="button" name="button2" id="button2" value="返回" class="btn_bb2" onclick="javascript:location='systemAdminAction_queryRoles.action'"/>            </td>
	          </tr>
	        </table>
	      </div>
	    </div>
	</div></div>
	</form>
</body>
</html>