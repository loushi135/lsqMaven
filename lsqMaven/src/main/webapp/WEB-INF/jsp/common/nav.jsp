<%@ page language="java" import="java.text.*,java.util.*" pageEncoding="UTF-8"%>
<% 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 EEE");
	String now = sdf.format(new Date());
%>
<div class="nav_bg" ><li class="nav_bg_icon1">欢迎您：${oper.name }</li> <li class="nav_bg_icon2">今天是：<%=now %>
</li> </div>