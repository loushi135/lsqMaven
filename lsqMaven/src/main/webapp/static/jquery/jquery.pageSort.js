//结合分页组件page.tld排序插件 
/*
	sortValue排序字段 ，hasAscing是否升序 true升序，false降序
	要求 <input type="button"  value=" " sort="true" 
	class="btn_arrowDown" sortValue="honorAccount" hasAscing="true" />
	需要排序的列，在th里加上上面的
	
	调用： $.pageSort("${page.sortValue}","${page.hasAscing}");
*/

(function ($){
		$.extend(
			{
				"pageSort":function(sortValue,hasAscing){
						$("input[sort=true]").each(function(){
		    			var btnSortValue = $(this).attr("sortValue");
		    			//var sortValue = "${page.sortValue}";
		    			//var hasAscing = "${page.hasAscing}";
		    			if(btnSortValue==sortValue){
		   					if(hasAscing=='true'){
		    							$(this).attr("hasAscing",false);
				    					$(this).attr("class","btn_arrowUpC");
				   					}else if(hasAscing=='false'){
				    					$(this).attr("hasAscing",true);
				    					$(this).attr("class","btn_arrowDownC");
				   					}
				    			}
				    		});
				    		$(document).ready(function () {
								$("input[sort=true]").click(function(){
							   			$("input[name=page.sortValue]").attr("value",$(this).attr("sortValue"));
							   			$("input[name=page.hasAscing]").attr("value",$(this).attr("hasAscing"));
							   			document.pageForm.submit();
							   		})
							});
				}			
			}
		);
	
})(jQuery)


