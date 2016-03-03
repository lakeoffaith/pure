<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <style type="text/css">
    .yylog-ul > li{
    	display:block;
    	height: 100px;
    	margin-top:5px;
       border-bottom: 1px solid;
    }
    
  </style>
    
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
        <h4 class="modal-title" id="myModalLabel">取消预约挂号</h4>
      </div>
      <div class="modal-body">
        	<table class="ml20"  data-orderItem_id="">
            	
            </table>
            
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary sureCancleyy" >取消预约</button>
      </div>
    </div>
  </div>
</div>
	<div class="container-fluid" id="wrapper">
         <div class="row" style="margin-top:20px;">
        	<div class="col-md-10 col-md-offset-1">
            <div class="use_central " style="display: block;">
	<div  class="col-md-3">
	    <h2>用户中心</h2>
 </div>
    <div class="col-md-9 fr wrapper15">
    
    <h3 class="bg-color-primary">预约记录</h3>
    <div>
    	<ul class="yylog-ul"   data-user_id="3">
        	
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
 <script type="text/javascript">
	function makeCancleYy(tt){
		var $modal = $("#myModal  .modal-body table");
		var orderItem_id=$modal.attr("data-orderItem_id");
		$.ajax({
			url:"orderItem/"+orderItem_id+"?type=cancle",
					type:"get",
					async:false,
					dataType:"json",
					success:function(d){
						
						if(d.success && d.code==2){
							alert(d.msg);
							location.href=d.msg;
						}
					}
		});
	} 	
	function LoadModalMessage(exV) {
		var orderItem_id=exV.orderItem_id;
		//将数据加载进myModal
		var $modal = $("#myModal  .modal-body table");
		$modal.empty();
		$("#myModalLabel").html("取消预约挂号");
		$("#myModal .modal-footer").empty().append("<button type='button' class='btn btn-default' data-dismiss='modal'>返回</button>").
		append("<button type='button' class='btn btn-primary'  onclick='makeCancleYy(this)'>确认</button>");
		var obj;
		$.ajax({
			url : "orderItem/"+orderItem_id,
			type : "get",
			async:false,
			dataType : "JSON",
			success : function(d) {
				if (d.success && d.obj!=null) {
					obj= d.obj;
				}
			}
		});
		$modal.attr("data-orderItem_id",orderItem_id);
		console.debug(obj);
		var noonValue="上午";
				if(obj.schedule.noonType==1)  {
					noonValue="下午";
				}
		str = "<tr><td class='tar'>姓名：</td><td class='tal'>"+obj.employee.name+"</td></tr> <tr><td class='tar'>身份证：</td><td class='tal'>"+obj.employee.idCardNo+"</td></tr>"+
        "<tr><td class='tar'>联系电话：</td><td>"+obj.employee.cellphone+"</td></tr><tr><td class='tar'>预约医生：</td><td>/"+obj.department.name+"/"+obj.doctor.name+"</td></tr><tr><td class='tar'>诊断费：</td><td>"+obj.schedule.cost+"元</td>"+
        "</tr><tr><td class='tar'>就诊时间：</td><td>"+dateFormat(obj.schedule.date)+" "+noonValue+"</td></tr>";
				$modal .append(str);
	}
 
 
 function loadYyLog(userId){
	 $.ajax({
		 url:"use/center/2",
		 type:"GET",
		 dataType:"json",
		 success:function(data){
			 if(data.success && data.results.length>0){
				 var $ul=$(".yylog-ul");
				 $ul.empty();
				 $.each(data.results,function(e,v){
					 if(v.state==3){
						 stateVal="预约成功";
					 }else if(v.state=4){
						 stateVal="已经取消";
					 }
					 var str="<li class='li bg-li' data-orderItemId="+v.id+"><div class='col-md-2' ><img class='img img-sm' src="+v.doctor.pic+"></div><div class='col-md-4'>"+
	                " <div><b>医院:</b><span class='info'></span></div><div><b>科室:</b><span class='info'>"+v.department.name+"</span></div><div><b>医生:</b> <span class='info'>"+v.doctor.name+"</span>"+
	                " </div><div><b>挂号费:</b><span>"+v.schedule.cost+"元</span></div></div>   <div class='col-md-4'><div><b>时间:</b><span>"+dateFormat(v.schedule.date)+"</span> </div><div><b>状态:</b>"+
	               "<span class='warning'> "+stateVal+"</span></div><div> <b>取号密码:</b><span class='warning'>"+v.takePassword+"</span></div> </div>    <div class='col-md-2'> ";
	               if(v.state==3){
	            	   str+="<button class='btn btn-warning cancleyy'  onclick='cancleYy(this)'>取消</button>";
	               }
	               str+="</div> </li>";
	            $ul.append(str);
				 });
			 }
		 }
	 });
 }
 function cancleYy(tt){
	 console.debug($(tt).parents("li"));
	 var orderItem_id=$(tt).parents("li").attr("data-orderItemId");
		if (orderItem_id!=null) {
			LoadModalMessage({
				'orderItem_id' : orderItem_id
			});
			///* 弹出确认框 */
			$("#myModal").modal('show');
		}
	 
 }
 	$(function(){
 		var user_id=$(".yylog-ul").attr("data-user_id");
 		loadYyLog(user_id);
 	});
 </script>
 
</body>
</html>