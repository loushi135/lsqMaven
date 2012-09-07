
$(function(){
    $("#sele").keyup(function(even) {
         var keyCode = even.which;  
         if (keyCode == 38 || keyCode == 40 || keyCode == 13)// 当点击上下键或者确定键时阻止他传送数据  
            {  
             return;  
             }  
        	autoComplete("DoctorAction_selectDeptByName.action","sele","autoTxt")
     });  
     $("#input").keyup(function(even) {
         var keyCode = even.which;  
         if (keyCode == 38 || keyCode == 40 || keyCode == 13||keyCode == 37||keyCode == 39)// 当点击上下键或者确定键时阻止他传送数据  
            {  
             return;  
             }  
        	autoComplete("DoctorAction_selectDeptByName.action","input","autoTxt1")
     });  
});

