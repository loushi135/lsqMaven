<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
	<title>附一院医院自助管理系统</title>
	<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
	<script type="text/javascript" src="${ctx}/static/custom/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/custom/js/roleadmin.js"></script>
    <script type="text/javascript" src="${ctx}/static/custom/js/common.js"></script>
</head>
<body onload="createJson()">
<page:default urlPath="systemAdminAction_queryRoles.action"/>
<form action="systemAdminAction_queryRoles.action" method="post" name="pageForm">
<div class="position">
  <div class="position_txt"><span class="bold">当前位置：</span>系统管理 >> 角色管理</div>
</div><div class="main_area1_a"><div class="main_area1_line"><div class="main_area1_title">角色管理</div></div>
    <div class="pad10">
      <div class="search_box">
        <table width="600" border="0" cellspacing="8" cellpadding="0">
          <tr>
            <td width="9%" nowrap="nowrap">角色名称：
              <input type="text" name="queryDto.roleName" id="textfield5" value="${queryDto.roleName}" class="input180" /></td>
            <td width="9%" nowrap="nowrap">角色说明：
              <input type="text" name="queryDto.roleRemark"  id="textfield6" value="${queryDto.roleRemark}" class="input180" /></td>
            <td width="47%">&nbsp;</td>
            <td><input name="button2" type="button" onclick="window.document.pageForm.action='systemAdminAction_queryRoles.action';window.document.pageForm.submit()" class="btn_search" id="button2" value=" " />
          </tr>
        </table>
      </div>
      <div class="marginb10">
        <input type="button" class="btn_add" value="添加角色" onclick="window.location.href='systemAdminAction_preRoleAdd.action'"/>
        <input type="button" class="btn_delete" value="删除角色" onclick="deleteSelect()"/>
</div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableData1">
        <tr>
          <th width="3%"> <input type="checkbox" onclick="checkAllOrNot(this,null)"  id="checkbox" />
          </th>
          <th width="10%">序号</th>
          <th width="10%">角色名称</th>
          <th>角色说明</th>
          <th width="13%">操作</th>
        </tr>
        <c:choose>
		    <c:when test="${not empty page.dataList}">
			    <c:forEach items="${page.dataList}" var="role" varStatus="index">
			       <tr>
			          <td><input type="checkbox" name="roleIds" value="${role.roleId}" id="checkbox3" /></td>
			          <td align="center">${index.count}&nbsp;</td>
			          <td align="center">${role.roleName}&nbsp;</td>
			          <td align="center">${role.roleRemark}&nbsp;</td>
			           <td align="center" nowrap="nowrap"><span class="marginb10">
			            <input type="button" class="btn_normal2" value="修改" onclick="modifyOne('${role.roleId}')"/>
			            <input type="button" class="btn_normal2" value="删除" onclick="deleteOne('${role.roleId}')"/>
			          </span></td>
			       </tr>
			    </c:forEach>
		    </c:when>
		    <c:otherwise>
		       <tr>
		          <td colspan="6">No result found!</td>
		       </tr>
		    </c:otherwise>
	   </c:choose>
      </table>
      <div class="page textR"><page:bar/></div>
</div>
</div>
</form>
</body>
</html>
