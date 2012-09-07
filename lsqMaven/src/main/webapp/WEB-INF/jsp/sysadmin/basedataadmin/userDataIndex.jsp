<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
	<head>
		<title></title>
		<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
		<script type="text/javascript" src="${ctx}/static/custom/js/jquery-1.6.2.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/custom/js/common.js"></script>
		<script type="text/javascript">
			function getData(id,name){
				var sendData ="baseData.id="+id;
				$.post(
						"systemAdminAction_getDeptOr3PartInAndOut.action",
						sendData,
						function(data){
								$("#deptTitle").html("");
								$("#partUserInfo").html("");
								$("#unPartUserInfo").html("");
								$("#backData").html("");
								var partUserInfoList = data.baseData.childList[0].childList;
								var unPartUserInfoList =  data.baseData.childList[1].childList;
								var partContent = "";
								var unPartContent = "";
								$(partUserInfoList).each(function(i,item){
										partContent+="<li><input name='' type='button' class='btn_normal1' onclick=\"getDetailData('"
										+item.id+"','"+item.name+"')\" value='"+item.name+"' />";
								})
								//alert(partContent);
								$(unPartUserInfoList).each(function(i,item){
										unPartContent+="<li><input name='' type='button' class='btn_normal1' onclick=\"getDetailData('"
										+item.id+"','"+item.name+"')\" value='"+item.name+"' />";
								})
								$("#partUserInfo").html(partContent);
								$("#unPartUserInfo").html(unPartContent);
						},'json'
				)
			}
			
			function getDetailData(id,name){
				var sendData ="baseData.id="+id;
				var deptTitle =name+"明细项目";
				$("#deptTitle").html(deptTitle);
				$.post(
						"systemAdminAction_getDeptOr3PartInAndOut.action",
						sendData,
						function(data){
								//alert(data.baseData.childList.length);
								$("#backData").html("");
								var backList = data.baseData.childList;
								var backContent = "";
								$(backList).each(function(i,item){
										backContent+="<li>"+item.name+"</li>";
								})
								$("#backData").html(backContent);
						},'json'
				)
			}
		</script>
	</head>
	<body onload="loadData('${msg}')">
			<div class="position">
				<div class="position_txt">
					<span class="bold">当前位置：</span>个人用户数据管理
				</div>
			</div>
				<div class="main_area1_a">
					<div class="main_area1_line">
						<div class="main_area1_title">
							个人用户数据管理
						</div>
					</div>
					<div class="pad10">
						<div class="search_box">
							<table border="0" cellspacing="8" cellpadding="0">
								<tr>
									<td width="6%" class="bold">
										认证等级
									</td>
								</tr>
								<tr>
									<td>
										<ul class="CoDepart">
											<c:forEach items="${baseDataList}" var="baseData">
												<li>
													<input name="" type="button" class="btn_normal1"
														value="${baseData.name }" onclick="getData('${baseData.id}','${baseData.name }')" />
												</li>
											</c:forEach>
										</ul>
									</td>
								</tr>
							</table>
						</div>
						<div class="search_box">
							<table border="0" cellspacing="8" cellpadding="0">
								<tr>
									<td width="6%" class="bold">
										个人信息分类
									</td>
								</tr>
								<tr>
									<td>
										<ul class="CoDepart" id="partUserInfo">
											
										</ul>
									</td>
								</tr>
							</table>
							<table border="0" cellspacing="8" cellpadding="0">
								<tr>
									<td width="6%" class="bold"  >
										未分类信息项目
									</td>
								</tr>
								<tr>
									<td>
										<ul class="CoDepart" id="unPartUserInfo">
											
										</ul>
									</td>
								</tr>
							</table>
						</div>
						
						<div class="CoDepart_box">
							<div class="dataTable2_title" id="deptTitle">
								
							</div>
							<div class="pad10">
								<fieldset>
									<div class="Lgend">
										<div>
											<ul class="CoDepart_info" id="backData">
											</ul>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
					</div>
				</div>
	</body>
</html>
