<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
	<title></title>
	<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
	<script type="text/javascript" src="${ctx}/static/custom/js/operadmin.js"></script>
</head>

<body>
<div class="position">
  <div class="position_txt"><span class="bold">当前位置：</span>系统管理 >> 查看后台用户</div>
</div><div class="main_area1"><div class="main_area1_a"><div class="main_area1_line">
  <div class="main_area1_title">查看后台用户</div>
</div><div class="pad10">
  <div>
<table width="100%" border="0" cellspacing="8" cellpadding="0" class="floatL"  id="mySubTable">
      <tr>
        <td width="9%" align="right" nowrap="nowrap">登录名：</td>
        <td width="91%" nowrap="nowrap">${oper.loginname}</td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">用户姓名：</td>
        <td nowrap="nowrap">${oper.name}&nbsp;</td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">身份证号：</td>
        <td nowrap="nowrap">${oper.idno}&nbsp;</td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">角色：</td>
        <td nowrap="nowrap">
         ${oper.role.roleName}&nbsp;
        </td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">用户邮箱：</td>
        <td nowrap="nowrap">${oper.email}&nbsp;</td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">手机号：</td>
        <td nowrap="nowrap">${oper.tel}&nbsp;</td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">邮编：</td>
        <td nowrap="nowrap">${oper.postcode}&nbsp;</td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">通信地址：</td>
        <td nowrap="nowrap">${oper.address}&nbsp;</td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">备注：</td>
        <td nowrap="nowrap">${oper.remark}&nbsp;</td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">平台注册时间：</td>
        <td nowrap="nowrap">${oper.createDate}&nbsp;</td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">上次登陆时间：</td>
        <td nowrap="nowrap">${oper.lastOpDate}&nbsp;</td>
      </tr>
       <tr>
        <td align="right" nowrap="nowrap">&nbsp;</td>
        <td nowrap="nowrap">
          <input type="button" name="button2" id="backBtn" value="返回" class="btn_bb2" onclick="goBack();"/></td>
      </tr>
    </table>
  </div>
</div>
</div></div>
</body>
</html>
