<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
	<title>附一院医院自助管理系统</title>
	<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
	<script type="text/javascript" src="${ctx}/static/custom/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/zTree3/js/jquery.ztree.core-3.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/zTree3/js/jquery.ztree.excheck-3.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/zTree3/js/jquery.ztree.exedit-3.1.js"></script>
	<script type="text/javascript" src="${ctx}/static/custom/js/roleadmin.js"></script>
</head>
<body>
<form action="SystemAdminAction_roleAdd.action" method="post">
<div class="position">
  <div class="position_txt"><span class="bold">当前位置：</span>系统管理 &gt;&gt; 添加角色</div>
</div><div class="main_area1"><div class="main_area1_a"><div class="main_area1_line">
  <div class="main_area1_title">添加角色</div>
</div>
    <div class="pad10">
      <div>
        <table width="100%" border="0" cellspacing="8" cellpadding="0" class="floatL">

          <tr>
            <td width="9%" align="right" nowrap="nowrap">角色名：</td>
            <td width="91%" nowrap="nowrap"><input type="text" name="role.roleName" id="roleName" class="input250" /><span id="errMsg"></span></td>
          </tr>
          <tr>
            <td  align="right" nowrap="nowrap">角色描述：</td>
            <td  nowrap="nowrap"><input type="text" name="role.roleRemark" id="roleRemark" class="input250" /><span id="errMsg"></span></td>
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
            <td nowrap="nowrap"><input type="button" name="button" id="button" value="提交" onclick="addOrEditRole(0)" class="btn_bb2"  />
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