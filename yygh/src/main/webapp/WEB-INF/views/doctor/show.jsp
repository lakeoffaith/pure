<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	<%@ include file="/WEB-INF/views/title.jsp"%>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">预约挂号信息核对</h4>
				</div>
				<div class="modal-body">
					<table class="ml20">
						<!-- <tr>
							<td class="tar">姓名：</td>
							<td class="tal">李振纲</td>
						</tr>
						<tr>
							<td class="tar">身份证：</td>
							<td class="tal">421023********0654</td>
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
							<td class="tar">挂号费：</td>
							<td>2元</td>
						</tr>
						<tr>
							<td class="tar">就诊时间：</td>
							<td>2015年12月10日 08:24 上午</td>
						</tr> -->
					</table>
				</div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">

		<div class="row" style="margin-top: 20px;">
			<div class="col-md-10 col-md-offset-1">

				<div class="dep-header">
					<ol class="breadcrumb">
						 <li><a href="main">首页</a></li>
					  <li><a href="hospital">${doctor.hospital.name }</a></li>
					    <li><a href="hospital">${doctor.department.name }</a></li>
					  <li class="active">${doctor.name} </li>
					</ol>

					<ul class="list-inline" style="position: relative;">
						<li class="h3">${doctor.name}</li>
						<li><small class="text-showy">副主任</small></li>
						<li style="position: absolute; right: 0px; bottom: 10px;"><span
							class="text-info"> ${doctor.hospital.name }</span></li>

					</ul>
					<div class="panel panel-default">
						<div class="panel-body panel-info">${doctor.introduce}
						</div>
					</div>

					<div class="header">
						<h3>
							个人排班 <small>（ 今日 <code>19:00</code> 开始可预约至<code>2016年
									02 月 05 日</code>号源 )
							</small> <span class="float-right"> <small> 已预约<span
									class="text-showy">${doctor.ghTotal }</span>人
							</small>
							</span>
						</h3>

					</div>

					<div>

						<div class="schedule-header"
							style="height: 67px; border-top: 1px solid #efefef; border-bottom: 1px solid #efefef;">

							<div class="schedule-title"
								style="height: 67px; padding: 20px 0px; float: left;">
								<div style="width: 150px; float: left; padding-left: 30px;">
									<span class="h4"> 医生服务 </span>
								</div>
							</div>
							<div class="schedule-date "
								style="float: right; width: 600px; height: 67px; padding-top: 9px;">
											
								<ul class="schedule">
									<li class="previous previous-icon disable"><a><span
											class="glyphicon glyphicon-menu-left"></span></a></li>
									<!--<li class="nostyle"><span>01/20<br>&nbsp;周三
									</span></li>
								 	<li class="nostyle"><span>01/21<br>&nbsp;周四
									</span></li>
									<li class="nostyle"><span>01/22<br>&nbsp;周五
									</span></li>
									<li class="nostyle"><span>01/23<br>&nbsp;周六
									</span></li>
									<li class="nostyle"><span>01/24<br>&nbsp;周日
									</span></li>
									<li class="nostyle"><span>01/25<br>&nbsp;周一
									</span></li>
									<li class="nostyle"><span>01/26<br>&nbsp;周二
									</span></li> -->
									<li class="next next-icon"><a><span
											class="glyphicon glyphicon-menu-right"></span></a></li>
								</ul>
							</div>
						</div>
						<div class="schedule-body" style="margin-top: 20px;">
							<!--  schedule-item   data-id存放医生的id -->
							<div class="schedule-item"
								style="height: 120px; border-bottom: 1px solid #efefef; padding-bottom: 10px;"
								data-doctor_id="${doctor.id}">
							<div class="item-title"
									style="float: left; width: 150px; height: 100%; padding-left: 10px; padding-top: 20px;">
									<p>
										<span class="glyphicon glyphicon-time text-showy"></span>预约<span
											class="text-showy">${doctor.ghTotal }</span>
									</p>
									<p>
										<span class="glyphicon glyphicon-heart text-showy"></span>好评<span
											class="text-showy">${doctor.ghHighScore}</span>
									</p>
								</div> 
								<div class="item-date"
									style="float: right; width: 600px; height: 100%;">
									<div style="height: 50px; margin-bottom: 10px;">
										<!--  schedule   data-id 存放上下午的类型 -->
										<ul class="schedule" >
											<li class="previous nostyle"><span>上<br>午
											</span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
										</ul>
									</div>
									<div style="height: 50%;">
										<ul class="schedule">
											<li class="previous nostyle"><span>下<br>午
											</span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
											<li class="disvisible"><span></span></li>
										
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
	<%@ include file="/WEB-INF/views/footer.jsp"%>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.2.min.js"></script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->

	<script src="js/bootstrap.js"></script>
	<script src="js/gh/global.js"></script>
	<script src="js/gh/schedule.js"></script>

	<script type="text/javascript">
		
			function getWeekValue(d){
				var arr_week=["周日","周一","周二","周三","周四","周五","周六"];
				var i=new Date(d).getDay()
				return arr_week[i];
			}
			function dateArrayWeek(startDate,days){
	 			var result='{"results":[';
				for (var i = 0; i < 7; i++) {
					var d=(new Date(startDate)).getTime()+i*24*60*60*1000;
					var weekValue=getWeekValue(d);
					var mon=new Date(d).getMonth()+1;
					if(mon.length==1){
						mon="0"+mon;
					}
					var day=new Date(d).getDate();
					console.debug(mon+"-------------------"+days);
					 var e_Val='{"name":"'+mon+'|'+day+'","value":"'+weekValue+'","date":"'+d+'"},';  
					result+=e_Val;
				}
				result=result.substring(0, result.length-1);
				result+=']}';
				console.debug(result);
				
				
				return JSON.parse(result);
			}
		function loadScheduleDate(jsonV){
			//先清空
			$(".schedule-date").find("li").remove();
			//加上前后按钮
			var listr="<li class='previous previous-icon disable'><a><span  class='glyphicon glyphicon-menu-left'></span></a></li>";
			listr+="<li class='next next-icon' onclick='nextScheduleDate()'><a><span  class='glyphicon glyphicon-menu-right'></span></a></li>";
			$(".schedule-date").find("ul").append(listr);
			
			
			var startDate=jsonV.startDate;
			var days=jsonV.days;
			var jsOb=dateArrayWeek(startDate,days); 
			console.debug(jsOb);
		    listr="";	
			$.each(jsOb.results,function(e,v){
					console.debug(v.name+"                  "+v.value);
					listr+="<li class='nostyle' data-date="+v.date+"><span>"+v.name+"<br>&nbsp;"+v.value+"</span></li>";
				}) ;
			//清空
			
			$(".schedule-date").find("li:eq(0)").after(listr);
		/* 	01/20<br>&nbsp;周三 
			<div class="schedule-date "
								style="float: right; width: 600px; height: 67px; padding-top: 9px;">
											
								<ul class="schedule">
									<li class="previous previous-icon disable"><a><span
											class="glyphicon glyphicon-menu-left"></span></a></li>
									<!--<li class="nostyle"><span>01/20<br>&nbsp;周三
									</span></li>
								 	<li class="nostyle"><span>01/21<br>&nbsp;周四
		*/ 
		}
		function dateColumn(endDate,startDate){
		var startD=new Date(dateFormat(startDate));
		var endD=new Date(dateFormat(endDate));
		console.debug(startD);
			console.debug(endD);
		var num= ( (new Date(endD)).getTime()-(new Date(startD)).getTime())/(24*60*60*1000);
		if(num>=0){
			return Math.floor(num);
		}else{
			return -1;
		}
		}
		function loadSchedule(jsonV){
			console.debug("++++++");
			console.debug(jsonV);
			
			var doctor_id=jsonV.doctor_id;
			var startDate=dateFormat(jsonV.startDate);
			
			console.debug(startDate);
			console.debug("----------");
			console.debug(doctor_id);
			var dataStr="doctor_id="+doctor_id+"&startDate="+startDate+"&days=7";
			$.ajax({
				url:"schedule?"+dataStr,
				type:"GET",
				dataType:"JSON",
				success:function(d){
					if(d.success && d.results.length>0){
						$.each(d.results,function(e,v){
							console.debug(startDate);
							var num=dateColumn(v.date,startDate);
							console.debug('---------------');
							var noonType=v.noonType;
							var  $li=$(".schedule-item[data-doctor_id="+doctor_id+"]").find(".item-date>div:eq("+noonType+")").find("li:eq("+(num+1)+")");
							$li.removeClass("disvisible").empty();
							$li.attr("data-schedule_id",v.id);
							$li.append("<span>预<br>约</span><div class='pop pop-md' style='display: none;'>放号 <i>"+v.numbers+"</i> <br> 剩余 <i>"+v.residueNumbers+"</i> <br> 挂号费 <iclass='cost'>"+v.cost+"</i> 元</div>");
									
						});
					}
				}
			});
		}
		function viewYyMessage(exV){
			var orderItem=exV.orderItem;
			var $modal = $("#myModal  .modal-body table");
			$modal.empty();
			var use;
			$.ajax({
				url : 'employee?tip=insession',
				type : "get",
				async:false,
				dataType : "JSON",
				success : function(d) {
					if (d.success && d.obj!=null) {
						use= d.obj;
					}
				}
			});
			if(use==null || orderItem==null)return;
			$modal.attr("data-orderItem_id",orderItem.id);
			//
			$("#myModalLabel").html("你已成功预约");
			$("#myModal .modal-footer").empty().append("<button type='button' class='btn btn-default' data-dismiss='modal'  onclick='goUserCenter()'>关闭</button>");
			
			var noonValue="上午";
					if(orderItem.schedule.noonType==1)  {
						noonValue="下午";
					}
			str = "<tr data-use_id="+use.id+"><td >姓名：</td><td >"+use.name+"</td></tr><tr><td >身份证：</td><td >"+use.idCardNo+"</td></tr>"
					+ "<tr><td >联系电话：</td><td>"+use.cellphone+"</td></tr><tr><td >预约医生：</td><td>"+orderItem.doctor.hospital.name+"/"+orderItem.doctor.department.name+"/"+orderItem.doctor.name+"</td></tr><tr>"
					+ "<td >挂号费：</td><td>"
					+ orderItem.schedule.cost
					+ "元</td></tr><tr   ><td >就诊时间：</td><td>"
					+  (new Date(orderItem.schedule.date)).toLocaleDateString()
					+ "   "
					+ noonValue + "</td></tr><tr><td>取号密码:</td><td class='text-showy'>"+orderItem.takePassword+"</td></tr>"
					
					$modal .append(str);
			
					
			
		}
	
	
		function LoadModalMessage(exV) {
			//将数据加载进myModal
			var $modal = $("#myModal  .modal-body table");
			$modal.empty();
			$("#myModalLabel").html("预约挂号信息核对");
			$("#myModal .modal-footer").empty().append("<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>").
			append("<button type='button' class='btn btn-primary'  onclick='makeSureYy()'>确认</button>");
			var use;
			$.ajax({
				url : 'employee?tip=insession',
				type : "get",
				async:false,
				dataType : "JSON",
				success : function(d) {
					if (d.success && d.obj!=null) {
						use= d.obj;
					}
				}
			});
			console.debug(use);
			var schedule ;
			$.ajax({
				url : 'schedule/'+exV.schedule_id,
				type : "get",
				async:false,
				dataType : "JSON",
				success : function(d) {
					if (d.success && d.obj!=null) {
						schedule= d.obj;
					}
				}
			});
			$modal.attr("data-schedule_id",schedule.id);
			var noonValue="上午";
					if(schedule.noonType==1)  {
						noonValue="下午";
					}
			str = "<tr data-use_id="+use.id+"><td >姓名：</td><td >"+use.name+"</td></tr><tr><td >身份证：</td><td >"+use.idCardNo+"</td></tr>"
					+ "<tr><td >联系电话：</td><td>"+use.cellphone+"</td></tr><tr><td >预约医生：</td><td>"+schedule.doctor.hospital.name+"/"+schedule.doctor.department.name+"/"+schedule.doctor.name+"</td></tr><tr>"
					+ "<td >挂号费：</td><td>"
					+ schedule.cost
					+ "元</td></tr><tr   ><td >就诊时间：</td><td>"
					+ (new Date(schedule.date)).toLocaleDateString()
					+ "   "
					+ noonValue + "</td></tr>"
					
					$modal .append(str);
		}
		
		function makeSureYy(){
			//发送ajax
			var $modal = $("#myModal  .modal-body table");
				
				var use_id=$modal.find("tr[data-use_id]").attr("data-use_id");
				var schedule_id=$modal.attr("data-schedule_id");
				var urlstr="yuyue/"+use_id+"/"+schedule_id;
				$.ajax({
					url:urlstr,
					async:false,
					type:"get",
					dataType:"json",
					success:function(d){
						if(d.success){
							viewYyMessage({'orderItem':d.obj});
						}
					}
				});
		}
		function goUserCenter(){
			location.href="use/center";
		}
		//下一个7天的排班表
		function nextScheduleDate(){
			//获得第一个
			var dateStr=$("ul.schedule").find("li.nostyle:eq(0)").attr("data-date");
			var startDate=parseInt(dateStr);
			startDate=	startDate+7*24*60*60*1000;
			loadScheduleDate({'startDate':new Date(startDate),'days':7});
			//根据doctor_id  ，startDate加载未来七天的schedule;
			loadSchedule({'doctor_id':$(".schedule-item").attr("data-doctor_id"),'startDate':new Date(startDate)});
		}
		//给新增的排班添加点击事件
		function initScheduleLiClick(){
			$(".schedule >li").on(
					"click",
					function() {
						
						
						if ($(this).find(".pop").length === 1) {

							//日期，上午，医生id
							var schedule_id = $(this).attr("data-schedule_id");
							LoadModalMessage({
								'schedule_id' : schedule_id
							});
							///* 弹出确认框 */
							$("#myModal").modal('show');
						}
					});
		}
		
		$(function() {
			//根据开始时间加载日期
			loadScheduleDate({'startDate':new Date(),'days':7});
			
			//根据doctor_id  ，startDate加载未来七天的schedule;
			loadSchedule({'doctor_id':$(".schedule-item").attr("data-doctor_id"),'startDate':new Date()});
			
			
			//点击预约 弹出确认对话框
			initScheduleLiClick();
			


		})
	</script>
</body>
</html>