	 // 自动补全  
     var maxcount = 0;// 表示他最大的值  
     var thisCount =0;// 初始化他框的位置 
     var currentDivId;//当前提示框div的id
     var currentInputId;//当前输入框的id
 //url为action  item为输入框id
 function autoComplete(url,sourceId,divId){
         var txt = $("#"+sourceId).val();//这里是取得他的输入框的值  
         currentDivId = divId;
         currentInputId = sourceId; //height:150px;overflow-y:auto;
         $("body").prepend("<div style='width:120px; display:none; background:#FFFFFF; position: absolute;' id='"+currentDivId+"'></div>");
         if (txt != "") {  
            //拼装数据  
             $.ajax({  
                 url : url,
                 type : "post",  
                 dataType : "json",  
                 data : {"name" : txt  
               },  
              success : function(data) {  
                    var offset = $("#"+currentInputId).offset();  
                     $("#"+currentDivId).show();  
                     $("#"+currentDivId).css("top", (offset.top + 22) + "px");  
                   	 $("#"+currentDivId).css("left", offset.left + "px");  
                   	 var width = $("#"+currentInputId).css("width");
                   	 var list = data.list;
                     var Candidate = "";  
                      maxcount = 0;//再重新得值  
                    $(list).each(function(i,item){
										Candidate+="<li id='" +i+ "' onclick='select(this)'  onmouseover='changeColor(this)' >" + item.name + "</li>"; 
										maxcount++; 
								})
                    $("#"+currentDivId).html(Candidate);  
                    $("#"+currentDivId+" li:eq(0)").css({"background":"#A8A5A5","width":width});
                    $("#"+currentDivId+" li:gt(0)").css({"width":width});    
                     event.preventDefault();  
                },  
               error : function() {  
                    $("#"+currentDivId).html("");  
                   $("#"+currentDivId).hide();  
                   maxcount = 0;  
                }  
            });  
        } else {  
             $("#"+currentDivId).hide();  
            maxcount = 0;  
         }  
 }
 
$(function(){
     //当单击html时则隐藏搜索值  
     $("html").click(function(){
        $("#"+currentDivId).html("");  
        $("#"+currentDivId).hide();  
       thisCount=0;  
    });  
     // 写移动事件//上键３８ 下键４０ 确定键 １３  
     $("body").keyup(function(even) {  
         var keyCode = even.which;  
             if (keyCode == 38)// 按上键时  
             {  
                if(thisCount!=0){//等于零时则证明不能上了。所以获得焦点  
                     $("#"+currentInputId).blur();  
                     if(thisCount>0)  
                        --thisCount;  
                    else thisCount=0;  
                 $("#"+currentDivId+" li").css("background", "#FFFFFF");  
                 $("#"+currentDivId+" li:eq("+thisCount+")").css("background", "#A8A5A5");  
                 }else{
                 $("#"+currentInputId).focus();
                 }  
            } else if (keyCode == 40) {// 按下键时  
                if(thisCount<maxcount-1)  
                 {  
                     $("#"+currentInputId).blur();  
                     ++thisCount;  
                     $("#"+currentDivId+" li").css("background", "#FFFFFF");  
                     $("#"+currentDivId+" li:eq("+thisCount+")").css("background", "#A8A5A5");  
                 }  
            } else if (keyCode == 13) {// 按确认键时  
                 var tt=$("#"+thisCount).text();  
                 if(tt!="")  
                     {  
                        $("#"+currentInputId).val(tt);  
                         $("#"+currentDivId).html("");  
                         $("#"+currentDivId).hide();  
                     }else 
                     {  
                        if($("#"+currentInputId).val()!=""){} 
                   }  
             } else {  
                if($("#"+currentDivId).html()!="")  
                     {  
                        $("#"+currentInputId).focus();  
                         thisCount=0;  
                     }  
            }  
			});  
});
	 function changeColor(item){
	    	$(item).mouseover(function(){
	    			$(this).siblings().css("background", "#FFFFFF");
	    			$(this).css("background", "#A8A5A5");
	    			thisCount = parseInt($(this).attr("id"));
	    	})
	    }
	 function select(item){
	 		$("#"+currentInputId).val($(item).text());  
	 		$("#"+currentDivId).hide();
	 }
