<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
	<title></title>
	<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
	<script type="text/javascript" src="${ctx}/static/custom/js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="${ctx}/static/custom/js/operadmin.js"></script>
    <script type="text/javascript" src="${ctx}/static/custom/js/common.js"></script>
</head>
<body onload="loadData('${msg}')">
<page:default urlPath="systemAdminAction_queryOpers.action"/>
<form action="systemAdminAction_queryOpers.action" method="post" name="pageForm">
<div class="position">
  <div class="position_txt"><span class="bold">当前位置：</span>系统管理 >> 系统用户管理</div>
</div><div class="main_area1_a"><div class="main_area1_line"><div class="main_area1_title">系统用户管理</div></div>
    <div class="pad10">
      <div class="search_box">
        <table width="600" border="0" cellspacing="8" cellpadding="0">
          <tr>
            <td width="9%" nowrap="nowrap">登录名：
              <input type="text" name="queryDto.operLoginName" id="textfield5" value="${queryDto.operLoginName}" class="input180" /></td>
            <td width="9%" nowrap="nowrap">用户姓名：
              <input type="text" name="queryDto.operName"  id="textfield6" value="${queryDto.operName}" class="input180" /></td>
            <td width="47%">&nbsp;</td>
            <td><input name="button2" type="button" onclick="window.document.pageForm.action='systemAdminAction_queryOpers.action';window.document.pageForm.submit()" class="btn_search" id="button2" value=" " />
          </tr>
        </table>
      </div>
      <div class="marginb10">
        <input type="button" class="btn_add" value="添加用户" onclick="window.location.href='systemAdminAction_preAddOper.action'"/>
        <input type="button" class="btn_delete" value="注销用户" onclick="deleteSelect()"/>
        <input type="button" class="btn_delete" value="锁定用户" onclick="lockSelect(0)"/>
        <input type="button" class="btn_delete" value="解锁用户" onclick="lockSelect(1)"/>
</div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableData1">
        <tr>
          <th width="3%"> <input type="checkbox" onclick="checkAllOrNot(this,null)"  id="checkbox" />
          </th>
          <th width="10%">序号</th>
          <th width="10%">用户登录名称</th>
          <th>用户姓名</th>
          <th>用户角色</th>
          <th>用户邮箱</th>
          <th>上次登陆时间</th>
          <th>用户状态</th>
          <th width="13%">操作</th>
        </tr>
        <c:choose>
		    <c:when test="${not empty page.dataList}">
			    <c:forEach items="${page.dataList}" var="oper" varStatus="index">
			       <tr>
			          <td>
				          <input type="checkbox" name="operIds" value="${oper.id}" id="checkbox3"/>
			          </td>
			          <td align="center">${index.count}&nbsp;</td>
			          <td align="center">${oper.loginname}&nbsp;</td>
			          <td align="center">${oper.name}&nbsp;</td>
			          <td align="center">${oper.role.roleName}&nbsp;</td>
			          <td align="center">${oper.email}&nbsp;</td>
			          <td align="center">${oper.lastOpDate}&nbsp;</td>
			          <td align="center"><c:if test="${oper.status eq 0}">禁用</c:if><c:if test="${oper.status eq 1}">启用</c:if><c:if test="${oper.status eq 2}">已注销</c:if>&nbsp;</td>
			           <td align="center" nowrap="nowrap"><span class="marginb10">
			          	<input type="button" class="btn_normal2" value="详情" onclick="detailOne('${oper.id}')"/>
			          	<c:if test="${oper.loginname ne 'sysadmin'}"></c:if>
				            <c:if test="${oper.status ne 2}"><input type="button" class="btn_normal2" value="修改" onclick="modifyOne('${oper.id}')"/>
				              <input type="button" class="btn_normal2" value="注销" onclick="deleteOne('${oper.id}')"/>
			           		 </c:if>
			          </span></td>
			       </tr>
			    </c:forEach>
		    </c:when>
		    <c:otherwise>
		       <tr>
		          <td colspan="7">No result found!</td>
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
