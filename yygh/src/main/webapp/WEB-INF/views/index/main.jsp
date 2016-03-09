<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
  <head>
   
  	<base href="<%=basePath%>">
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ijoy预约挂号首页</title>
    <!-- Bootstrap -->
	<link href="css/bootstrap.css" rel="stylesheet">
    
    <link rel="stylesheet" type="text/css" href="css/global.css">
    <link rel="stylesheet" type="text/css" href="css/citypop.css">
    
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
  </head>
  <body>
  	<!--  navbar-fixed-top-->
  	<%@ include file="/WEB-INF/views/title.jsp" %>
  	<div class="container-fluid">
    	
    	
        <div class="row" style="margin-top:20px;">
        	<div class="col-md-10 col-md-offset-1">
            <div class="row">
            	<div class="col-md-8" id="logo" style="height:310px;">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="images/gh/160-1.jpg" alt="...">
      <div class="carousel-caption">
        ...
      </div>
    </div>
    <div class="item">
      <img src="images/gh/160-2.jpg" alt="...">
      <div class="carousel-caption">
        ...
      </div>
    </div>
   <div class="item">
      <img src="images/gh/160-3.jpg" alt="...">
      <div class="carousel-caption">
        ...
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
                
                
                
                </div>
                <div class="col-md-4" id="search">
    <div class="quikegh">
    
    	<div class="header">
            <ul class="list-inline">
            	<li><h2>快速挂号</h2></li>
            	<li><a href="hospital?type=html">找医院</a></li>
                <li><a href="department?type=html">找科室</a></li>
                <li><a href="doctor?type=html">找医生</a></li>
            </ul>
        </div>
 
 <div class="inputBody">
 	<div class="form-horizontal">
    	<div class="form-group">
        	<label for="inputCity" class="col-sm-2 control-label"><p>城市：</p></label>
    <div class="col-sm-10">
    <div class="input-group" style="position:relative;">
      <input type="text" class="form-control cityPopValue" id="inputCity"  aria-describedby="basic-addon2" style="position:relative;">
      <div class="input-group-btn" >
        <button type="button" id="qgh_city_btn" class="btn btn-default" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-globe"></span></button>
        
      </div>
      <div class="city pop" id="citypop"  style="display: none;">
                  <div class="search-citys-tt"> <a class="current click" onclick="tabCutover(this,'s-citys1')" href="javascript:void(0)">国内热门<span></span></a> <a class="click" onclick="tabCutover(this,'s-citys2')" href="javascript:void(0)">ABCDE<span></span></a> <a class="click" onclick="tabCutover(this,'s-citys3')" href="javascript:void(0)">FGHJ<span></span></a> <a class="click" onclick="tabCutover(this,'s-citys4')" href="javascript:void(0)">KLMNP<span></span></a> <a class="click" onclick="tabCutover(this,'s-citys5')" href="javascript:void(0)">QRSTW<span></span></a> <a class="click" onclick="tabCutover(this,'s-citys6')" href="javascript:void(0)">XYZ<span></span></a> </div>
                  <div class="search-citys-list click city_all_choose" id="citylistnew">
                    
                   
                  </div>
                </div>
      </div>
      <!-- /btn-group -->
    </div>
        </div>
    
    <div class="form-group">
        	<label for="inputHos" class="col-sm-2 control-label"><p>医院：</p></label>
    <div class="col-sm-10">
    <div class="input-group">
      <input type="text" class="form-control" id="inputHos"  aria-describedby="basic-addon2" >
      <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-triangle-bottom"></span></button>
        <ul class="dropdown-menu dropdown-menu-right" id="hosDropDownMenuUl">
         
        </ul>
      </div>
      </div>
      <!-- /btn-group -->
  
          
      
      
      
    </div>
        </div>
        
        <div class="form-group">
        	<label for="inputDep" class="col-sm-2 control-label"><p>科室：</p></label>
    <div class="col-sm-10">
    <div class="input-group">
      <input type="text" class="form-control" id="inputDep"  aria-describedby="basic-addon2">
      <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-triangle-bottom"></span></button>
        <ul class="dropdown-menu dropdown-menu-right" id="depDropDownMenuUl">
        
        </ul>
      </div>
      </div>
      <!-- /btn-group -->
    </div>
        </div>
    <button id="qkghBtn" class="btn  btn-warning btn-lg btn-block">快速挂号</button>
   </div>

 </div>   	
  
    </div>
                </div>
            </div>
        
            </div>
        </div>
  	</div>
   <%@ include file="/WEB-INF/views/footer.jsp" %>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
	<script src="js/jquery-1.11.2.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed --> 
	<script src="js/bootstrap.js"></script>
   <script src="js/gh/global.js"></script> 
   <script src="js/gh/citypop.js"></script>
   <script>
   function cityClick(v){
	   if(cityClickCommon(v)){
			//执行方法
		   /*
			 * 根据城市zip  查找医院。
			 */
			addHosByCity($(".cityPopValue").attr("data-id"));
		}
}
   function addHosByCity(cityId){
	   if(!jsValidateIsNull(cityId)){
		   $.ajax({
			  url:"hospital?for=json",
			  type:"GET",
			  data:{"cityId":cityId,"pageSize":'200'},
			 dataType:"json",
			  async:true,
			  success:function(d){
				  console.debug(d.obj.rows);
				 if(d.success && d.obj.rows.length>0){
					 $("#hosDropDownMenuUl").html();
					  var hosAddStr="";
					  $.each(d.obj.rows,function(e,v){
						 hosAddStr+="<li onclick='hosClick(this)'><a href='javascript:void(0)' data-id="+v.id+">"+v.name+"</a></li>";
					  });
					  $("#hosDropDownMenuUl").append(hosAddStr);
				 }
			  }
		   });
	   }
   }
   
   function addDepartmentByHosId(hosId){
	   if(!jsValidateIsNull(hosId)){
		   $.ajax({
			  url:"department",
			 type:"GET",
			 data:{"hosId":hosId,"pageSize":'200'},
					dataType:"json",
			  async:true,
			  success:function(d){
				  if(d.success && d.obj.rows.length>0){
					  $("#depDropDownMenuUl").html();
					  var depAddStr="";
					  $.each(d.obj.rows,function(e,v){
						  depAddStr+="<li onclick='depClick(this)'><a href='javascript:void(0)' data-id="+v.id+">"+v.name+"</a></li>";
					  });
					  $("#depDropDownMenuUl").append(depAddStr);
				  }
			  }
		   });
	   }
   }
   	
	function hosClick(hosLi){
	    if(!jsValidateIsNull(hosLi)){
	    	var dropdownMenuId=$(hosLi).find("a:first").attr("data-id");
	    	var dropdownMenuVal=$(hosLi).find("a:first").html();
	    	$("#inputHos").val(dropdownMenuVal);
	    	$("#inputHos").attr("data-id",dropdownMenuId);
	    	//加载相应医院的科室
	    	addDepartmentByHosId(dropdownMenuId);
	    }
	};
	function depClick(depLi){
	    if(!jsValidateIsNull(depLi)){
	    	var dropdownMenuId=$(depLi).find("a:first").attr("data-id");
	    	var dropdownMenuVal=$(depLi).find("a:first").html();
	    	$("#inputDep").val(dropdownMenuVal);
	    	$("#inputDep").attr("data-id",dropdownMenuId);
	    }
	};
	
	
	//快速挂号
	$(function(){
		$("#qkghBtn").on("click",function(){
			var jsonData={};
			var cityId=$("#inputCity").attr("data-id");
			var hosId=$("#inputHos").attr("data-id");
			var depId=$("#inputDep").attr("data-id");
			var qkghUrl="qkgh";
			$.ajax({
				url:qkghUrl,
				type:"POST",
				data:{"cityId":cityId,"hosId":hosId,"depId":depId},
				success:function(data){
				 if(!jsValidateIsNull(data)){
					if(data.success){
						location.href="use/center";
					}else{
						alert("预约挂号失败");
					}
				 };
				},
				error:function(){
					alert("预约挂号失败");
				}
			});
		});
		
		
		
	});
	
	
	
   
   </script>
   
  </body>
</html>