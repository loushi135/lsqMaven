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
<form action="systemAdminAction_editOper.action" method="post">
<div class="position">
  <div class="position_txt"><span class="bold">当前位置：</span>系统管理 >> 修改后台用户</div>
</div><div class="main_area1"><div class="main_area1_a"><div class="main_area1_line">
  <div class="main_area1_title">修改后台用户</div>
</div><div class="pad10">
  <div>
<table width="100%" border="0" cellspacing="8" cellpadding="0" class="floatL"  id="mySubTable">
      <tr>
        <td width="9%" align="right" nowrap="nowrap">登录名：</td>
        <td width="91%" nowrap="nowrap">${oper.loginname}<input type="hidden" name="oper.id" value="${oper.id}"/></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">密码：</td>
        <td nowrap="nowrap"><input type="password" name="oper.password"  id="firstPsw" class="input250" /><font color="red">*</font></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">密码确认：</td>
        <td nowrap="nowrap"><input type="password"  id="secondPsw" class="input250"/><font color="red">*</font></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">用户姓名：</td>
        <td nowrap="nowrap"><input type="text" name="oper.name" id="operName" value="${oper.name}" class="input250" /><font color="red">*</font></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">选择角色：</td>
        <td nowrap="nowrap">
           <select name="oper.role.roleId" id="roleId">
              <option value="">请选择角色</option>
              <c:if test="${not empty roles}">
                <c:forEach items="${roles}" var="role">
                     <option value="${role.roleId}"  <c:if test="${oper.role.roleId eq role.roleId}">selected="selected"</c:if>>${role.roleName}</option>
                </c:forEach>
              </c:if>
           </select><font color="red">*</font>
        </td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">用户邮箱：</td>
        <td nowrap="nowrap"><input type="text" name="oper.email" id="email" class="input250" value="${oper.email}"/></td>
      </tr>
       <tr>
        <td align="right" nowrap="nowrap">身份证号：</td>
        <td nowrap="nowrap"><input type="text" name="oper.idno" id="idno" class="input250" value="${oper.idno}"/></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">手机号：</td>
        <td nowrap="nowrap"><input type="text" name="oper.tel" id="tel" class="input250" value="${oper.tel}"/></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">邮编：</td>
        <td nowrap="nowrap"><input type="text" name="oper.postcode" id="staffno" class="input250" value="${oper.postcode}"/></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">通信地址：</td>
        <td nowrap="nowrap"><input type="text" name="oper.address" id="address" class="input250" value="${oper.address}"/></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">备注：</td>
        <td nowrap="nowrap"><input type="text" name="oper.remark" id="remark" class="input250" value="${oper.remark}"/></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">&nbsp;</td>
        <td nowrap="nowrap">
          <input type="button" name="button" id="subBtn" value="提交" class="btn_bb2"  onclick="addOrEditOper(2)"/>
          <input type="button" name="button2" id="backBtn" value="返回" class="btn_bb2" onclick="goBack();"/></td>
      </tr>
    </table>
  </div>
</div>
</div></div>
</form>
</body>
</html>
