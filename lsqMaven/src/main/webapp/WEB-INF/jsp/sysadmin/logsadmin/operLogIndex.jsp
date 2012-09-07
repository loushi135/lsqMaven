<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
	<title></title>
	<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
	<script type="text/javascript" src="${ctx}/static/datepicker/WdatePicker.js" defer="defer"></script>
</head>
<body>
<page:default urlPath="SystemAdminAction_queryOperLogs.action"/>
<form action="SystemAdminAction_queryOperLogs.action" method="post" name="pageForm">
<div class="position">
  <div class="position_txt"><span class="bold">当前位置：</span>系统管理 >> 系统日志</div>
</div><div class="main_area1"><div class="main_area1_a"><div class="main_area1_line"><div class="main_area1_title">系统日志</div></div>
    <div class="pad10">
      <div class="search_box">
        <table width="600" border="0" cellspacing="8" cellpadding="0">
          <tr>
            <td width="9%" nowrap="nowrap">操作员姓名：
              <input type="text" name="queryDto.operName" id="textfield5" value="${queryDto.operName}" class="input180" /></td>
            <td width="9%" nowrap="nowrap">起始时间：
              <input type="text" name="queryDto.startDate"  id="textfield6" onclick="WdatePicker()" value="${queryDto.startDate}" class="input180" /></td>
            <td width="9%" nowrap="nowrap">结束时间：
              <input type="text" name="queryDto.endDate"  id="textfield6" onclick="WdatePicker()" value="${queryDto.endDate}" class="input180" /></td>
            <td width="47%">&nbsp;</td>
            <td><input name="button2" type="button" onclick="window.document.pageForm.action='SystemAdminAction_queryOperLogs.action';window.document.pageForm.submit()" class="btn_search" id="button2" value=" " />
          </tr>
        </table>
      </div>
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableData1">
        <tr>
          <th width="10%">序号</th>
          <th width="10%">用户姓名</th>
          <th>IP</th>
          <th>操作</th>
          <th>时间</th>
        </tr>
        <c:choose>
		    <c:when test="${not empty page.dataList}">
			    <c:forEach items="${page.dataList}" var="operLog" varStatus="index">
			       <tr>
			          <td align="center">${index.count}&nbsp;</td>
			          <td align="center">${operLog.oper.name}&nbsp;</td>
			          <td align="center">${operLog.ip}&nbsp;</td>
			          <td align="center">${operLog.content}&nbsp;</td>
			          <td align="center"><fmt:formatDate value="${operLog.opertime}" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;</td>
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
</div>
</form>
</body>
</html>
