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
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
  </head>
  <body>
    <%@ include file="/WEB-INF/views/title.jsp" %>
        	<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">预约挂号信息核对</h4>
      </div>
      <div class="modal-body">
        	<table class="ml20">
        	   <tr>
                	<td class="tar">编号：</td>
                    <td class="tal"  id="yyItemId">1</td>
                </tr>
            	<tr>
                	<td class="tar">姓名：</td>
                    <td class="tal" >李振纲</td>
                </tr>
                <tr>
                	<td class="tar">身份证：</td>
                    <td class="tal" >421023********0654</td>
                </tr>
                <tr>
                	<td class="tar">联系电话：</td>
                    <td>18228084571</td>
                </tr>
                <tr>
                	<td class="tar">预约医生：</td>
                    <td>四川华西医药/眼科/李好</td>
                </tr>
                <tr>
                	<td class="tar">诊断费：</td>
                    <td>2元</td>
                </tr>
                <tr>
                	<td class="tar">就诊时间：</td>
                    <td>2015年12月10日 08:24 上午</td>
                </tr>	
            </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary sureMsgBtn"  id="suerYyBtn">确认</button>
      </div>
    </div>
  </div>
</div>
	<div class="container-fluid">
    	
        <div class="row" style="margin-top:20px;">
        	<div class="col-md-10 col-md-offset-1">
          		
            	<div class="dep-header">
                	  <ol class="breadcrumb">
                      <li><a href="main">首页</a></li>
					  <li><a href="hospital">广东省东升农场医院</a></li>
					  <li class="active">儿科门诊 </li>
                    </ol>
                    
                    <ul class="list-inline" style="position:relative;">
                    	<li class="h3">儿科门诊</li>
                        <li><small class="text-showy">区级重点医院</small></li>
                        <li style="position: absolute; right: 0px;bottom:10px;" ><span class="text-info">
                        成都第二人民医院</span></li>
                    </ul>
          <div class="panel panel-default">
          <div class="panel-body panel-info">
            公告：本科室周六，周日不受理预约挂号
          </div>
			</div>
             <div class="header">
             	<h3>科室排班 <small>（ 今日 <code>19:00</code> 开始可预约至<code>2016年 02 月 05 日</code>号源 )</small>
                <span class="float-right">
                <small>
                 	已预约<span class="text-showy">629,135</span>人
                </small> </span></h3>
             </div>   
                <div>
                    	<div class="schedule-header" style="height:67px; border-top:1px solid #efefef;border-bottom:1px solid #efefef;">
        	<div class="schedule-title" style="height:67px; padding:20px 0px;float:left;"  >
            	<div style="width:150px;float:left;padding-left:30px;">
            	<span class="h4" >
                科室专家
                </span>
                </div>
            </div>
            <div class="schedule-title" style="height:67px; padding:20px 0px;float:left;"  >
            	<div style="width:150px;float:left;padding-left:30px;">
            	<span class="h4" >
                擅长
                </span>
                </div>
            </div>
            <div class="schedule-title" style="height:67px; padding:20px 0px;float:left;"  >
            	<div style="width:150px;float:left;padding-left:30px;">
            	<span class="h4" >
                医生服务
                </span>
                </div>
            </div>
           <div class="schedule-date " style="float:right;width:600px;height:67px;padding-top:9px;">
            
  <ul class="schedule" >
    <li class="previous previous-icon disable"><a><span class="glyphicon glyphicon-menu-left"></span></a></li>
    <li class="nostyle"><span>01/20<br>&nbsp;周三</span></li>
    <li class="nostyle"><span>01/21<br>&nbsp;周四</span></li>
    <li class="nostyle"><span>01/22<br>&nbsp;周五</span></li>
    <li class="nostyle"><span>01/23<br>&nbsp;周六</span></li>
    <li class="nostyle"><span>01/24<br>&nbsp;周日</span></li>
    <li class="nostyle"><span>01/25<br>&nbsp;周一</span></li>
    <li class="nostyle"><span>01/26<br>&nbsp;周二</span></li>
    <li class="next next-icon"><a><span class="glyphicon glyphicon-menu-right"></span></a></li>
  </ul>
            </div>
        </div>
    
     
    
  
  		<div class="schedule-body" style="margin-top:20px;">
         <div class="schedule-item" style="height:120px;border-bottom:1px solid #efefef;padding-bottom:10px;">
         	<div class="item-title" style="float:left;width:150px;height:100%;padding-left:10px;padding-top:20px;">
            	<div class="media">
  <div class="media-left">
    <a href="#">
      <img class="media-object" src="images/gh/doc1.jpg" alt="">
    </a>
  </div>
  <div class="media-body">
    <h4 class="media-heading">刘强</h4>
    <small>副主任医师</small>
  </div>
</div>
                
            </div>
            <div class="item-title" style="float:left;width:150px;height:100%;padding-left:10px;padding-top:20px;">
            	主攻白内障20多年,对老年性白内障，
                
            </div>
            <div class="item-title" style="float:left;width:150px;height:100%; padding-left:10px;padding-top:20px;">
            	<p><span class="glyphicon glyphicon-time text-showy"></span>预约<span class="text-showy">25262</span></p>
                <p><span class="glyphicon glyphicon-heart text-showy"></span>好评<span class="text-showy">414</span></p>
            </div>
             <div class="item-date" style="float:right;width:600px;height:100%;">
              <div style="height:50px;margin-bottom:10px;">
          
            <ul class="schedule" >
    <li class="previous nostyle"><span>上<br>午</span></li>
    <li  class="disvisible"><span></span></li>
    <li><span >预<br>约</span></li>
    <li><span >预<br>约</span></li>
    <li><span >预<br>约</span></li>
    <li><span >预<br>约</span></li>
    <li><span >预<br>约</span></li>
    <li><span >预<br>约</span>
    <div class="pop pop-md" style="display: none;">
            放号
            <i>25</i>
            <br>
            剩余
            <i>8</i>
            <br>
            挂号费
            <i>23</i>
            元
            </div>
    </li>
   
  </ul>
              </div>
              <div style="height:50%;">
              <ul class="schedule" >
    <li class="previous nostyle"><span>下<br>午</span></li>
    <li ><span >预<br>约</span></li>
    <li><span >预<br>约</span></li>
    <li><span >预<br>约</span></li>
    <li><span >预<br>约</span></li>
    <li><span >预<br>约</span></li>
    <li><span >预<br>约</span></li>
    <li><span >预<br>约</span></li>
   
  </ul>
              </div>
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
   <script>
   			$(function(){
   						//将预约流程变为   sure
   					$("#suerYyBtn").on("click",function(){
   						var yyId=$("#yyItemId").html();
   						 $.ajax({
   							 url:"yuyue/sure/"+yyId,
   							 dataType:"json",
   							 success:function(data){
   								 if(data.success && data.code==2){
   									 location.href=data.msg;
   								 }
   							 }
   						 });
   					});
   			});
   </script>
   
</body>
</html>