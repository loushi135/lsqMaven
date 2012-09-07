<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<div class="leftmenu">
	<div>
		<img src="image/menu_title1.gif" />
	</div>
	
		<c:if test="${not empty roleMenuList}">
		  <c:forEach items="${roleMenuList}" var="roleMenu">
				<div class="leftmenu_a">
					<div class="leftmenu1" onclick="showMenu2('${roleMenu.menu.menuId}')" >
						${roleMenu.menu.menuName}
						<div class="leftmenu_icon1"></div>
					</div>
					<c:if test="${not empty roleMenu.menu.childList}">
					<div class="leftmenu2"  id="${roleMenu.menu.menuId}" style="display: none;">
						   <c:forEach items="${roleMenu.menu.childList}" var="childMenu">
								<li onclick="toUrlForRight(this,'${childMenu.menuUrl}','${childMenu.menuId}')">
									${childMenu.menuName}
								</li>
						   </c:forEach>
					</div>
					</c:if>
				</div>
		  </c:forEach>
		</c:if>
</div>

<script type="text/javascript">
   function toUrlForRight(obj,url,menuid){
	   $('li').removeClass("current");
	   obj.className="current";
	   document.getElementById("rightFrame").src = url+"?menuId="+menuid;
   }
   function showMenu2(obj){
	   if($("#"+obj).css("display")=="none"){
		  $(".leftmenu2").attr("style","display:none");
		  $("#"+obj).attr("style","display:")
	   }else{
		  $("#"+obj).attr("style","display:none")
	   }
	 //$(".leftmenu2").attr("style","display:none");
	 // $("#"+obj).attr("style","display:");
	// var display = document.getElementById(obj).style.display;
	 //document.getElementById(obj).style.display=(display=="block"?"none":"block");
	   
   }
</script>