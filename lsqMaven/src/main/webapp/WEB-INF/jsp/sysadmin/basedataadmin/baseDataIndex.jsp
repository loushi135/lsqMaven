<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
	<title></title>
	<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
	<script type="text/javascript" src="${ctx}/static/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/zTree3/js/jquery.ztree.core-3.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/zTree3/js/jquery.ztree.excheck-3.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/zTree3/js/jquery.ztree.exedit-3.1.js"></script>
	<script type="text/javascript" src="${ctx}/static/custom/js/basedataadmin.js"></script>
</head>

<body>
<div class="position">
  <div class="position_txt"><span class="bold">当前位置：</span>系统管理 >> 基础数据管理</div>
</div><div class="main_area1_a"><div class="main_area1_line">
  <div class="main_area1_title">基础数据管理</div>
</div><div class="pad10">
  <div>
       	<input type="button"  value="添加子节点" class="btn_add6" onclick="addSubBaseData()"/>			
		<input type="button"  value="修改节点" class="btn_modify" onclick="editBaseData()"/> 
		<input type="button"  value="删除节点" class="btn_delete" onclick="deleteBaseData()"/> 
<table width="100%" border="0" cellspacing="8" cellpadding="0"  style="display:none" id="mySubTable">
      <tr>
        <td width="9%" align="right" nowrap="nowrap">数据名称：</td>
        <td width="91%" nowrap="nowrap"><input type="text" name="textfield" id="name" class="input250" /></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">数据代码：</td>
        <td nowrap="nowrap"><input type="text" name="textfield2" id="code" class="input250" /></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">数据排序：</td>
        <td nowrap="nowrap"><input type="text" name="textfield2" id="orderInfo" class="input250" /></td>
      </tr>
      <tr>
        <td align="right" nowrap="nowrap">&nbsp;</td>
        <td nowrap="nowrap">
          <input type="button" name="button" id="subBtn" value="提交" class="btn_bb2"  />
          <input type="button" name="button2" id="backBtn" value="返回" class="btn_bb2" onclick="toClear()"/></td>
      </tr>
    </table>
	     <div class="zTreeDemoBackground">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
  </div>
</div></div>
</body>
</html>
