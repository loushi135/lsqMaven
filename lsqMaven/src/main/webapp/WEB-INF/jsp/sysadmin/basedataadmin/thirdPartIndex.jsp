<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp"%>
<html>
	<head>
		<title></title>
		<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>
		<script type="text/javascript" src="${ctx}/static/custom/js/common.js"></script>
		<script type="text/javascript">
			function getData(id){
				var sendData ="baseData.id="+id;
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
					<span class="bold">当前位置：</span>合作平台用户等级管理
				</div>
			</div>
				<div class="main_area1_a">
					<div class="main_area1_line">
						<div class="main_area1_title">
							合作平台用户等级管理
						</div>
					</div>
					<div class="pad10">
						<div class="search_box">
							<table border="0" cellspacing="8" cellpadding="0">
								<tr>
									<td width="6%" class="bold">
										用户等级分类
									</td>
								</tr>
								<tr>
									<td>
										<ul class="CoDepart">
											<c:forEach items="${baseDataList}" var="baseData">
												<li>
													<input name="" type="button" class="btn_normal1"
														value="${baseData.name }" onclick="getData('${baseData.id}')" />
												</li>
											</c:forEach>
										</ul>
									</td>
								</tr>
							</table>
						</div>
						<div class="CoDepart_box">
							<div class="dataTable2_title" id="deptTitle">
								合作平台用户反馈等级信息
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
