function cityClickCommon(v){
	var cityName=$(v).find("a").html();
	var cityId=$(v).find("a").attr("data-id");
	if(!jsValidateIsNull(cityName)){
		$(".cityPopValue").empty();
		if($(".cityPopValue").is('lable') || $(".cityPopValue").is('span')){
			$(".cityPopValue").html(cityName);
		}else if($(".cityPopValue").is('input')){
			$(".cityPopValue").val(cityName);
		}
		$(".cityPopValue").attr("data-id",cityId);
		$("#citypop").hide();
		return true;
	}
	return false;
}

/*
  选择城市的时候，城市拼音首字母，出现的城市选项
*/
function tabCutover(citystt,citysnum){
		if(!$(citystt).hasClass('current')){
		var currentvar=$(citystt).siblings(".current");
		currentvar.removeClass("current");
		$(citystt).addClass("current");
		
		
		$("#citylistnew > div").each(function(index, element) {
            if($(element).hasClass(citysnum)){
				$(element).show();
			}else{
				$(element).hide();
			}
        });
		};
	}




//点击城市  给id为citypop的兄弟节点为Input的value赋值。
$(function(){

	//移除citypop   隐藏
		$("#citypop").on("mouseleave",function(){
		$("#citypop").hide();
	});
		
		
		
   /*
    * ajax加载程序，citylistnew
    */
		$.ajax({
			url:"common/citypop?do=search",
			async:true,
			 dataType: 'json',
			timeout:10000,
			success:function(data){
					//clear
					var citylistnew=$("#citylistnew");
					citylistnew.html();
					//
					var hotCityJson=data.hotCities;
					var cityall=data.chineseCities;
					if(hotCityJson.length>0){
						var hotCityDiv="<div style='display: block;'><dl><dt></dt><dd class='hot'><ul></ul></dd></dl></div>";
						$("#citylistnew").append(hotCityDiv);
						
						var hotCitydd="";
						$.each(hotCityJson,function(e,v){
						 	$("dd.hot >ul").append("<li onclick='cityClick(this)'><a href='javascript:void(0);' data-id="+v.id+">"+v.name+"</a></li>");
						});
					}
					if(cityall.length>0){
						var arrayChar=['ABCDE','FGHJ','KLMNP','QRSTW','XYZ'];
						var cityTabl="";
						for (var i = 0; i < arrayChar.length; i++) {
							cityTabl+="<div style='display: none;'>";
	                       for (var index = 0; index < arrayChar[i].length; index++) {
							var singleChar= arrayChar[i].substring(index,index+1);
							cityTabl+="<dl><dt >"+singleChar+"</dt><dd class="+singleChar+"><ul></ul></dd></dl>";
						}
	                       cityTabl+="</div>";
						}
						$("#citylistnew").append(cityTabl);
						
						
						
						$.each(cityall,function(e,v){
							var firstCharset=v.pinyin.substring(0,1);
							
							
							$("dd."+firstCharset+" >ul").append("<li onclick='cityClick(this)'><a href='javascript:void(0);' data-id="+v.id+">"+v.name+"</a></li>");
						});
					}
					//
					$("#citylistnew > div").each(function(e,domEle){
						$(domEle).addClass("s-citys"+(e+1));
					});				
					
				
			}
		    
			
		});
	
		
});

