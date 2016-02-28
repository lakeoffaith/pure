// JavaScript Document
//排班表控件

$(function()
{
		$(".schedule >li").on("mouseenter",function(){
		$(this).find(".pop").css("display","block");
	
	});
	$(".schedule >li").on("mouseleave",function(){
		if($(this).find(".pop").length===1){
			$(this).find(".pop").css("display","none");
		}
		
	});
	

});