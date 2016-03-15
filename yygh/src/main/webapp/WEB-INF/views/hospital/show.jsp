<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
	<base href="<%=basePath%>">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Untitled Document</title>
    <!-- Bootstrap -->
	<link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/global.css">
    
  </head>
  <body>
   <%@ include file="/WEB-INF/views/title.jsp" %>
	<div class="container-fluid">
    	
        <div class="row" style="margin-top:20px;">
        	<div class="col-md-10 col-md-offset-1">
          		<div class="hos-header">
                	  <ol class="breadcrumb">
  <li><a href="main">首页</a></li>
  <li><a href="hospital">医院</a></li>
  <li class="active">${hospital.name} </li>
</ol>
                <h3>${hospital.name}  <small class="text-showy">${hospital.level}</small></h3>
                
                <div class="thumbnail" style="border:none;position:relative;padding-left:170px;border-bottom:1px solid #ededed;" >
      <img src="images/gh/hos1.jpg" alt="..." style="position:absolute;left:0px;top:10px;width:150px;height:150px;">
      <div class="caption" style="padding-right:100px;">
        <p>医院：${hospital.name }</p>
        <p>地址：${hospital.address }</p>
        <p>官网：${hospital.url }</p>
        <p>电话：${hospital.tel}</p>
        <p>简介 : 集医疗、科研、教学、预防、保健、康复服务为一体的现代化综合医院</p>
       
        
        
      </div>
    </div>
                
                </div>
            	<div>
                	<h3>科室展示</h3>
                        <ul class="list-inline" style="position:relative;">
                          <li>电话：0755-28177681</li>
                          <li>地址：深圳市龙岗区布吉深惠路359号</li>
                          
                          <span class="float-right">已预约 <span class="h4 text-showy">${hospital.ghTotal }</span> 人</span>
                        </ul>
                        
                        
                 
                    
                   <div class="thumbnail back-info" style="border:none;position:relative;padding-left:50px;border-bottom:1px solid #ededed;" >
    	<span class="glyphicon glyphicon-warning-sign text-showy " style="font-size:xx-large;position:absolute;left:15px;top:20px;" ></span>
      <div class="caption" style="padding-right:100px;">
        <ol>
        	<li>为了方便患者就诊，我院开通了网上预约挂号服务,网上预约不收取手续费。</li>
            <li>网上预约挂号采用实名制，预约前请先注册，一个手机号和身份证只能申请一个注册号，持注册号可预约7天内（含当天）出诊专家号。电话咨询0755-28177681</li>
            <li>因医院号源随时有变化，您在91160网站预约成功以后，我们会尽快致电您，跟您确认预约时间和医生。请谅解！</li>
        </ol>
       
        
        
      </div>
    </div> 
                    
                    </div>
            	
                
                <div class="hos-dep">
                <div class="dep-item row" style="margin-top:12px;padding-bottom:12px;border-bottom:1px solid #ededed;">
                		<div id="departmentUlDiv"  data-hospital_id="${hospital.id }">
                		</div>
                	<div class="header col-md-2" >
                    	<p class="h4">
                    	<span class="glyphicon glyphicon-euro text-info"></span> 妇科</p>
                    </div>
                    <div class="body col-md-10">
                   

     
                    <ul class="list-inline" style="padding-top:10px;">
                        <li><a data-toggle="tooltip" title="妇科(有号)">妇科</a><span class="label label-info" data-toggle="tooltip" title="院内特色">院</span></li>
                        <li><a onclick="show('department/show','1')">无痛人流</a></li>
                        <li><a onclick="show('department/show','1')">妇科炎症</a></li>
                        <li><a onclick="show('department/show','1')">白带异常</a></li>
                        <li><a onclick="show('department/show','1')">不孕不育</a></li>
                        <li><a onclick="show('department/show','1')">妇科炎症</a></li>
                        <li><a onclick="show('department/show','1')">白带异常</a></li>
                        <li><a onclick="show('department/show','1')">不孕不育</a></li>
                    </ul>
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
    <script src="js/model/domain.js"></script>
   <script type="text/javascript">
   //加载医院所拥有的科室
   $(function(){
	   var hospital_id=$("#departmentUlDiv").attr("data-hospital_id");
	   var baseQuery={"hosId":hospital_id};
	   $.ajax({
		   url:"department?for=json",
			data:baseQuery,
			type:"get",
			dataType:"json",
			success:function(data){
				if(data.success){
					$("#departmentUlDiv").empty();
					var str="<ul class='list-inline' style='padding-top:10px;'>";
					$.each(data.obj.rows,function(e,v){
						str+=" <li><a onclick='doModelDomain(\"department\",null,\""+v.id+"\")'>"+v.name+"</a></li>";
					});
					str+="</ul>"
					$("#departmentUlDiv").append(str);
				}
			}
	   });
   });
   
   </script>
   
</body>
</html>