<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
<head>
	<title></title>
	<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
</head>

<body>
  <div id="container"><jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include><jsp:include page="/WEB-INF/jsp/common/nav.jsp"></jsp:include><div> <jsp:include page="/WEB-INF/jsp/common/left.jsp"></jsp:include>
<div class="main"><div class="floatL widFull">
 <script type="text/javascript">
			function reinitIframe(){
				var iframe = document.getElementById("rightFrame");
				try{
					var bHeight = iframe.contentWindow.document.body.scrollHeight;
					iframe.height =  bHeight;
				}catch (ex){}
			}
			window.setInterval("reinitIframe()", 200);
 </script>
<iframe src="${ctx}/default.jsp" scrolling="no" frameborder="0" id="rightFrame" name="iFrame3" width="100%" onload="this.height=iFrame3.document.body.scrollHeight"></iframe></div>
</div>
</div>
  <div class="push"></div></div> 
  <jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
</body>
</html>
