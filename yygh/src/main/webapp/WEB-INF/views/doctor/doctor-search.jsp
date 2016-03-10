<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Untitled Document</title>
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/global.css">
<link rel="stylesheet" type="text/css" href="css/citypop.css">
<link rel="stylesheet" type="text/css" href="css/model/ijoypagination.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
</head>
<body>
	<%@ include file="/WEB-INF/views/title.jsp"%>
	<div class="container-fluid"  style="margin-bottom:60px">

		<div class="row" style="margin-top: 20px;">
			<div class="col-md-10 col-md-offset-1">

				<div class="search-condition"
					style="height: 200px; padding-bottom: 20px; border-bottom: 1px solid #ededed;">
					<!-- Nav tabs -->
				<ul class="nav  nav-pills">
						<li role="presentation" ><a href="hospitall">医院</a></li>
						<li role="presentation" ><a href="department">科室</a></li>
						<li role="presentation"  class="active" ><a href="doctor">医生</a></li>
					</ul>
					<div class="choose-city"
						style="height: 30px; margin-top: 10px; border-bottom: 1px solid #ededed; position: relative;">

						<ul class="list-inline" style="position: relative;">

							<li><span class="glyphicon glyphicon-map-marker text-showy"
								aria-label="choosecity"></span> <span
								class="text-showy cityPopValue">广东深圳</span></li>
							<li id="choose-city-li"><span><mark>更换</mark></span></li>
						</ul>
						   <div class="conditionBar  conditionBar-sm "  id="searchConditionBar"  style="position: absolute;left:200px;top:0px;">
							<ul class="list-inline">
							<!-- 	<li  data-id="3333",data-type="4444">金牛区<a><span class="glyphicon glyphicon-remove"></span></a>
								</li>
								<li  data-id="55555",data-type="7777">综合<a><span class="glyphicon glyphicon-remove"></span></a>
								</li> -->
							</ul>
						</div>


						<div class="city pop" id="citypop" style="display: none;">
							<div class="search-citys-tt">
								<a class="current click" onclick="tabCutover(this,'s-citys1')"
									href="javascript:void(0)">国内热门<span></span></a> <a
									class="click" onclick="tabCutover(this,'s-citys2')"
									href="javascript:void(0)">ABCDE<span></span></a> <a
									class="click" onclick="tabCutover(this,'s-citys3')"
									href="javascript:void(0)">FGHJ<span></span></a> <a
									class="click" onclick="tabCutover(this,'s-citys4')"
									href="javascript:void(0)">KLMNP<span></span></a> <a
									class="click" onclick="tabCutover(this,'s-citys5')"
									href="javascript:void(0)">QRSTW<span></span></a> <a
									class="click" onclick="tabCutover(this,'s-citys6')"
									href="javascript:void(0)">XYZ<span></span></a> <a class="click"
									onclick="tabCutover(this,'s-citys7')" href="javascript:void(0)">港澳台<span></span></a>
							</div>
							<div class="search-citys-list click city_all_choose"
								id="citylistnew"></div>
						</div>
					</div>
					 			<!-- Tab panes -->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active"  >

							<div class="choose-class">
								<ul class="list-inline"  data-type="type">
								</ul>
							</div>
						</div>
					</div>


				</div>

				<div class="container-fluid">
					<div class="row">
						<div class="col-md-8" style="padding-left: 0px;">
							<div class="list-bar"
						style="background-color: #fbfbfb; height: 40px; margin-bottom: 5px; padding: 0px -15px;">
						<div class="dropdown" style="float: left;" data-val="ghTotal"
							id="OrderDropdownDivId">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								预约人次 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<li><a href="javascript:;" data-val="ghTotal">预约人次</a></li>
								<li><a href="javascript:;" data-val="ghHighScore">好评数</a></li>
							</ul>
						</div>

						<div style="float: right; margin-top: 10px;">
							<span>共<code>222</code>个医院
							</span>
						</div>
					</div>
							<div id="doctors-div">
							
							
							</div>
					



						</div>
						<div class="col-md-4">
							<div id="doctors-rec-div">
								


							</div>
						</div>


					</div>




				</div>

			</div>

		</div>




	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.2.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.js"></script>
	<script src="js/gh/global.js"></script>
	<script src="js/gh/citypop.js"></script>
	<script src="js/model/domain.js"></script>
	<script>
	
	//处理查询条件查询结果
	//处理查询条件查询结果
		function initOrderDropDown(){
			$("#OrderDropdownDivId").find("ul.dropdown-menu").find("li").on(
					"click",
					function() {
						var str = $(this).find("a").attr("data-val");
						var show = $(this).find("a").html();
						console.debug(str + "    =================");
						$("#OrderDropdownDivId").attr("data-val", str);

						console.debug(str + "    ================="
								+ $("#OrderDropdownDivId").attr("data-val"));
						$("#OrderDropdownDivId").find("button").html(
								show + "<span class='caret'></span>");
						loadSearchData();
					});
	}
		 function goPage(currentPage,pageSize){
			 var ConditionBar = $("#searchConditionBar");
				var levels = "";
				var types = "";
				$.each(ConditionBar.find("li"), function(e, v) {
					var jsOb = JSON.parse($(v).attr("data"))
					if (jsOb.name == 'level') {
						levels += jsOb.value + ",";
					} else if (jsOb.name = "type") {
						types += jsOb.value + ",";
					}
				})
				var baseQuery = {
					'levels' : levels.substring(0, levels.length - 1),
					'types' : types.substring(0, types.length - 1)
				};
				//加上城市d
				baseQuery.cityId=$(".cityPopValue").attr("data-id");
				//加上排序的
				baseQuery.orderStr = $("#OrderDropdownDivId").attr("data-val");
				//加上分页的
				if(currentPage!=0  && currentPage!=null){
					baseQuery.currentPage=currentPage;
				}
				if(pageSize!=0 && pageSize!=null){
					baseQuery.pageSize=pageSize;
				}
				
				initDoctors(baseQuery);
        }
	
	function loadSearchData(){
		var ConditionBar=$("#searchConditionBar");
		var cityId=$("span.cityPopValue").attr("data-id");
		var levels="";
		var types="";
		$.each(ConditionBar.find("li"),function(e,v){
			var jsOb=JSON.parse($(v).attr("data"))
			if(jsOb.name=='level'){
				levels+=jsOb.value+",";
			}else if(jsOb.name="type"){
				types+=jsOb.value+",";
			}
		})
		var baseQuery={'levels':levels.substring(0, levels.length-1),'types':types.substring(0, types.length-1)};
		//加上排序的
		baseQuery.orderStr = $("#OrderDropdownDivId").attr("data-val");
		baseQuery.cityId=cityId;
		initDoctors(baseQuery);
	}
	/* 添加查询条件的标签*/
	function addCondition(v) {
		var dataId = $(v).attr("data-id"); //dataJson为json
		var dataType = $(v).parent("ul").attr("data-type");
		var showVal = $(v).html();

		//检查标签组中是否已经含有了dataType和dataId都相同的
		$ConditionBar = $("#searchConditionBar");
		if (!checkExist(dataType, dataId, $ConditionBar)) {
			var liVar = "<li data='{\"name\":\""+dataType+"\",\"value\":\""+dataId+"\" }'>"
					+ $(v).html()
					+ "<a  href='javascript:void(0);'  onclick=\"removeCondition(this)\"><span class='glyphicon glyphicon-remove'></span></a></li>";
			$("#searchConditionBar ul").append(liVar);

			loadSearchData();
		}
	}
	function checkExist(dataType,dataId,$ConditionBar){
		var flag=false;
		$.each($ConditionBar.find("li"),function(e,v){
		var 	jsonObjectV=JSON.parse($(v).attr("data"));
			if(jsonObjectV.value ==dataId &&  jsonObjectV.name==dataType){
				flag=true;
			} 
		});
		if(flag)return true;
		return false;
	}
	/*删除条件*/
	function removeCondition(v) {
		$(v).parent("li").remove();
		loadSearchData();
	}

	function cityClick(v) {
		if (cityClickCommon(v)) {
			//执行方法
			loadSearchData();
		}

	}
	
	
	
	/*删除条件*/
	function removeCondition(v){
	$(v).parent("li").remove();
		loadSearchData();
	}
	/* //加载部门查询class*/
	function initChooseClass(jsOb){
			var str="dep-"+jsOb.name;
			var baseQuery={'type':str};
			$
			.ajax({
				url : "dictionary",
				type : "GET",
				data : baseQuery,
				dataType : "json",
				success : function(d) {
					if (d.success && d.results.length > 0) {
						var str="<li>"+jsOb.value+"</li><li class='text-info'>全部</li>";
						var $ulVar=$("ul[data-type='"+jsOb.name+"']");
						$ulVar.empty();
						console.debug($ulVar);
						$.each(
										d.results,
										function(e, v) {
											var e_str = "";
											e_str += "<li  class='click' onclick='addCondition(this)' data-id='"+v.type+"'>"+v.name+"</li>";
											str += e_str;
										});
						$ulVar.append(str);
					}

				}
			});
	}
	
	   /**
		collect医生    收藏医生
*/
function collectDoctor(dom_this,domainName,method,id){
   var resultData=doModelDomain(domainName, method, id);
   console.debug(resultData);
   if(resultData.success){
	   $(dom_this).html("已收藏");
   };
}
	
		function initDoctors(baseQuery){
			$.ajax({
				url:"doctor?for=json",
				type:"GET",
				data:baseQuery,
				dataType:"json",
				success:function(d){
					if(d.success ){
							var str="";
							$("#doctors-div").empty();
							$.each(d.obj.rows,function(e,v){
								var e_str="";
								e_str+="<div class='thumbnail' style='border: none; position: relative; padding-left: 170px; border-bottom: 1px solid #ededed;'>"+
								"<img src="+v.pic+" alt="+v.name+" style='position: absolute; left: 0px; top: 30px; width: 150px; height: 100px;' onclick='doModelDomain(\"doctor\",null,\""+v.id+"\")'>"+
								"<div class='caption'  style='padding-right: 100px;'><h3 class='text-info click' onclick='doModelDomain(\"doctor\",null,\""+v.id+"\")'>"+v.name+"<small class='text-showy'>[主任]</small></h3>"+
								"<p>"+v.hospital.name+"</p><p>"+v.department.name+"</p><div class='float-right-tips' style='position: absolute; right: 0px; top: 30px;'>"+
								"<p class='text-showy'><span class='h3'>9</span>分</p><p><span class='star-0'></span></p><p>"+v.ghHighScore+"好评</p><p style='float: right;''><a href='javascript:;' onclick='collectDoctor(this,\"doctor\",\"collect\",\""+v.id+"\")' style='float: right;'>收藏</a></p></div></div></div>";
								str+=e_str;
							});
							$("#doctors-div").append(str);
							
							if(!jsValidateIsNull(str)){
								var pageItemStr="<div   class='col-md-offset-4 col-md-4'><ul class='pagination'>";
								var totalPage=d.obj.totalPage;
								var currentPage=d.obj.currentPage;
								console.debug(currentPage);
								console.debug(totalPage);
								var i=0;
								var j=0;
								i=currentPage-2;
								j=currentPage+2;
								i=i<=0?1:i;
								j=j>totalPage?totalPage:j;
								j=j<=5?j:5;
								var k;
								for  (k=i; k <=j; k++) {
									pageItemStr+="<li><a href='javascript:void(0);' onclick='goPage("+k+",0)'>"+k+"</a></li>";
								}
								
								pageItemStr+="</ul><div>";
								$("#doctors-div").append(pageItemStr);
							}
						};
					}
			});
		}
		
		function initRecDoctors(baseQuery){
			$.ajax({
				url:"doctor?for=json",
				type:"GET",
				data:baseQuery,
				dataType:"json",
				success:function(d){
					if(d.success && d.obj.rows.length>0){
							var str="<h3>推荐科室</h3>";
							$("#doctors-rec-div").empty();
							$.each(d.obj.rows,function(e,v){
								var e_str="";
								e_str+="	<div class='thumbnail' style='border: none; position: relative; padding-left: 60px; border-bottom: 1px solid #ededed; padding-top: 0px;'>"+
								"<img src="+v.pic+" alt="+v.name+" style='position: absolute; left: 0px; top: 15px; width: 58px; height: 70px;'  onclick='doModelDomain(\"doctor\",null,\""+v.id+"\")'>"+
								"<div class='caption'><p class='text-info click' onclick='doModelDomain(\"doctor\",null,\""+v.id+"\")'>"+v.name+"</p><p>已预约人数：<span class='text-showy'>"+v.ghTotal+"</span>"+
									"</p><p>医院："+v.hospital.name+"</p></div></div>";
								str+=e_str;
							});
							$("#doctors-rec-div").append(str);
						};
					}
			});
		}
		
		
		$(function() {
			//初始下拉条件
			initOrderDropDown();
			initChooseClass({'name':'type','value':'科室类型'});
			//加载医生
			initDoctors({"currentPage":1});
			
		
			//加载推荐医生
			initRecDoctors({"currentPage":1,"orderStr":"ghTotal","pageSize":5});
		});
	</script>
</body>
</html>