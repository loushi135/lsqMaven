<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
	<head>
	    <%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
		<title></title>
	</head>
	<body style="background: #3c7206;">
		<div style="width:500px; height:517px; margin:0 auto; margin-top:150px; padding-top:103px; padding-left:180px;">
	<form:form id="loginForm" action="${ctx}/login/toIndex.do" method="post"
		class="well well-large form-inline pull-left">
		<form:errors path="*" cssStyle="color:red"></form:errors><br/>
		<span><font color="red">${msg}</font></span>
				<li>
					<label>
						用户名：
					</label>
					<input name="loginName" type="text" class="input-medium" placeholder="your username" />
				</li>
				<li>
					<label>
						密&nbsp;&nbsp;码：
					</label>
					<input name="password" type="password" class="input-medium" placeholder="Password"
						name="textfield2" />
				</li>
				<li>
					<label>
						验证码：
					</label>
					<input name="srand" type="text" class="input-medium" size="9" />
					<img src="${ctx}/image.jsp" style="cursor: pointer;" onclick="this.src='${ctx}/image.jsp?d='+new Date()" width="65" height="30" align="top" />
				</li>
			<div style="text-align: center; margin-top: 20px;">
				<input type="submit" name="button" id="button" 
					 class="btn" value="登录"/>
				<a class="btn btn-small btn-primary "
					href="${ctx }/account/user/regist">注册</a>
			</div>
  </form:form>
		</div>
	</body>
</html>
