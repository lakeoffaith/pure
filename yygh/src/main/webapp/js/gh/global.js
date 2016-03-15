	
/*点击关闭导航栏中平台中心，浏览器能跳到平台的tab页面中，并把当前页面关闭*/
$(function(){
	$(".conditionBar").find("span.glyphicon-remove").on("click",function(){
		var userAgent = navigator.userAgent;
		if (userAgent.indexOf("Firefox") != -1 || userAgent.indexOf("Chrome") !=-1) {
		   window.location.href="http://localhost:8889/plat/index";
		} else {
		   window.opener = "http://localhost:8889/plat/index";
		   window.open("", "_self");
		   window.close();
		};
		});
	});
function dateFormat(dd){
				var d=new Date(dd);
				var year=d.getFullYear().toString();
				var month=d.getMonth()+1;
				if(month.toString().length==1){
					month="0"+month.toString();
				}
				var day=d.getDate();
				if(day.toString().length==1){
					day="0"+day.toString();
				}
				return year+"-"+month+"-"+day;
			}





// JavaScript Document
 function showCityPoP(){
	 if($("#citypop").css("display")==='none'){
			$("#citypop").show();
		}else{
			$("#citypop").hide();
		}
 }

 function GenerateJson(jsonObj,s,v){
		if(!jsValidateIsNull(jsonObj)){
			if(!jsValidateIsNull(s) && !jsValidateIsNull(v)){
				jsonObj[""+s+""]=v;
				console.debug("GenerateJson=====  "+jsonObj);
				return jsonObj;
			}
		}
	}
 
 /*
  * jsValidateIsNull
  */
 function  jsValidateIsNull(ntt){
	
	 return ntt===null|ntt===""|ntt===undefined;
 }

$(function(){
	
	/**
	 * footer放在页面底部
	 */
/*	var screenHeight=$(window).height();
	var footerHeight=$("#footerDiv").height();
	$("#footerDiv").css("bottom",0);*/
	/* $(window).scroll(function(){
		var scrollHeight=$(document).scrollTop();
		 $("#footerDiv").css("top",scrollHeight-footerHeight-1+screenHeight); 
		
	}); */
	
	
	/**
	点击搜索输入框  清空
	*/
	$("#search_key").on("click",function(){
		
		$("#search_key").attr("placeholder","");
		
	});
	//丢失焦点
	$("#search_key").on("focusout",function(){
		$("#search_key").attr("placeholder",'输入医院名称/医生姓名/科室名称');
	});
	
   
	
	
	
	
	/**
	点击搜索，发送查询 同步ajax
	$("#btn_search").on("click",function(){
		var search_key_val=$("#search_key").val();
		var search_type_val=$("#search_type").val();
		if(search_key_val!=undefined && search_type_val!=undefined){
			$.ajax({
				url:search_url，
				type:POST,
				dataType:'json',
				async:true,
				success: function(json){
					if(json.code==-99){
					}
					else if(json.code==1){
						
					}
				}
			});
			
		}
		
	});
	*/
	
	
	
	
	
	
	/**
		点击 名医推荐的滑动栏的左侧按钮   id   act-pre-btn
	*/
	
	$("#act-pre-btn").on("click",function(){
		//
		if($(".doc_list_wrap > ul:first-child").css("left")=="0px"){
			$(".doc_list_wrap > ul:first-child").css("left","-950px");
		}else{
			$(".doc_list_wrap > ul:first-child").css("left","0px");
		}
		
	});
	
	
	
	
	$("#act-next-btn").on("click",function(){
		
		if($(".doc_list_wrap > ul:first-child").css("left")==="-950px"){
			$(".doc_list_wrap > ul:first-child").css("left","0px");
		}else{
			$(".doc_list_wrap > ul:first-child").css("left","-950px");
		}

     });
	 
	 //act_rolls_num
	 
	$("#act_rolls_num a").on("click",function(){
		if(!$(this).hasClass("on")){
			$("#act_rolls_num a.on").removeClass("on");
			$(this).addClass("on");
			if($(".doc_list_wrap > ul:first-child").css("left")==="-950px"){
			$(".doc_list_wrap > ul:first-child").css("left","0px");
		}else{
			$(".doc_list_wrap > ul:first-child").css("left","-950px");
		}
		}
	});
	 
	
	
	
	//个人中心取消预约
	$(".use_central .cancleyy").on("click",function(){
		
		$("#myModal").modal({'show':true});
		
	});
	
	
	
	
	
	
	/**
	
		预约挂号首页
	
	*/
	//快速挂号，点击城市躺出城市选择框
	$("#qgh_city_btn").on("click",function(){
		
		showCityPoP();
		
	});
	/**
	 查找医院，科室，医生，更改城市
	*/
	
	$("#choose-city-li").on("click",function(){
		showCityPoP();
	});
	
	
	
	
$('[data-toggle="tooltip"]').tooltip({placement:'bottom'});
	
	
	
	
});
    
	
	