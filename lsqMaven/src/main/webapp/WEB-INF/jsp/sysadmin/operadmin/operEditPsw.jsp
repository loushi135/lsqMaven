<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
	<title></title>
	<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
    <script type="text/javascript" src="${ctx}/static/custom/js/common.js"></script>
	<script type="text/javascript" src="${ctx}/static/custom/js/jquery-1.6.2.min.js"></script>
</head>
<body>
<div class="dataTable2_content">
<table cellspacing="1" cellpadding="2" border="0" width="100%" class="tableData1">
    <tbody>
    <tr>
      <td nowrap="nowrap">请输入旧密码：</td>
      <td nowrap="nowrap"><input type="password" id="oldpsw"/></td>
    </tr>
    <tr>
      <td nowrap="nowrap">请输入新密码：</td>
      <td nowrap="nowrap"><input type="password" id="psw1"/></td>
    </tr>
    <tr>
      <td nowrap="nowrap">请确认新密码：</td>
      <td nowrap="nowrap"><input type="password" id="psw2"/></td>
    </tr>
  </tbody>
 </table>
     <div class="textM">
	    <input type="button" class="btn_bb2" value="确定" onclick="toModifyPsw()"/>
          <input type="button" class="btn_bb2" value="关闭" onclick="window.close();"/>
</div>
	</div>
	<script type="text/javascript">
	   function toModifyPsw(){
	      var oldpsw = $("#oldpsw").val();
	      var psw1 = $("#psw1").val();
	      var psw2 = $("#psw2").val();
	      var url = "systemAdminAction_modifyPsw.action";
	      var sendData = {oldpsw:oldpsw,psw1:psw1,psw2:psw2};
	      $.post(url,sendData,function(returnValue){
	         if(returnValue=="true"){
	            alert("密码修改成功！");
	         }else{
	           alert(returnValue);
	         }
	      },"text");
	   }
	</script>
</body>
</html>
