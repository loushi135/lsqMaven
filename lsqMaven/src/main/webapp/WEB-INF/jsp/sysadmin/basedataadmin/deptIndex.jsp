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
				var title="苏州市"+name+"数据详细信息";
				$("#deptTitle").html(title);
				$.post(
						"systemAdminAction_getDeptOr3PartInAndOut.action",
						sendData,
						function(data){
								//alert(data.baseData.childList.length);
								$("#inputData").html("");
								$("#outputData").html("");
								var inputList = data.baseData.childList[0].childList;
								var outputList =  data.baseData.childList[1].childList;
								var inputContent = "";
								var outputContent = "";
								$(inputList).each(function(i,item){
										inputContent+="<li>"+item.name+"</li>";
								})
								$(outputList).each(function(i,item){
										outputContent+="<li>"+item.name+"</li>";
								})
								$("#inputData").html(inputContent);
								$("#outputData").html(outputContent);
						},'json'
				)
			}
		</script>
	</head>
	<body onload="loadData('${msg}')">
			<div class="position">
				<div class="position_txt">
					<span class="bold">当前位置：</span>合作部门数据管理
				</div>
			</div>
				<div class="main_area1_a">
					<div class="main_area1_line">
						<div class="main_area1_title">
							合作部门数据管理
						</div>
					</div>
					<div class="pad10">
						<div class="search_box">
							<table border="0" cellspacing="8" cellpadding="0">
								<tr>
									<td width="6%" class="bold">
										合作部门列表
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
						<div class="CoDepart_box">
							<div class="dataTable2_title" id="deptTitle">
								
							</div>
							<div class="pad10">
								<fieldset>
									<legend class="input80 textM">
										输入信息
									</legend>
									<div class="Lgend">
										<div>
											<ul class="CoDepart_info" id="inputData">
											</ul>
										</div>
									</div>
								</fieldset>
								<fieldset>
									<legend class="input80 textM">
										输出信息
									</legend>
									<div class="Lgend">
										<div>
											<ul class="CoDepart_info" id="outputData">
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
