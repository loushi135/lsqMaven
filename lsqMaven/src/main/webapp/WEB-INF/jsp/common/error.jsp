<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<title></title>
</head>
<body>

<center>
<br/>
<br/>
<br/>
<br/>
<table>
    <tr>
       <td><img src="${pageContext.request.contextPath}/image/err.gif"></img></td>
    </tr>
    <tr><Td><h1>
    ${exception.message?default("")}
    ${exceptionStack?default("")}
    </h1></Td></tr>
    <tr><td><a href="${pageContext.request.contextPath}/login.jsp">返回</a></td></tr>
</table>
</center>
</body>
</html>
