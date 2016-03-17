<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath %>">
	<link href="css/ijoy/roll/roll.css" rel="stylesheet">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap" rel="stylesheet">
	<style>
			div.roll>ul{
				list-style:none;
	}
			div.roll>ul >li{
			display:inline;
			height:inherit;



	}
	div.roll>ul >li:hover{
	cursor:pointer;

	}
	.roll li.title{
	background-color:yellow;
	paddind:0px 3px;
	}
	</style>
	<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="echarts/echarts.js"></script>
	</head>
	<body>

	<div  class="col-md-2">
				<div class="roll">
					<ul>
						<li class="title">年份：</li>
						<li class="pre"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></li>
						<li>
							2013
						</li>
						<li>2014</li>
						<li>2015</li>
						<li>2016</li>
						<li class="next"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></li>
					</ul>
				</div>
	</div>
	<div  class="col-md-2">
	<div class="roll">
	<ul>
	<li class="title">月份：</li>
	<li class="pre"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></li>
	<li>
	一月
	</li>
	<li>二月</li>
	<li>三月</li>
	<li>四月</li>
	<li class="next"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></li>
	</ul>
	</div>
	</div>
	<div id="psLine" style="width:600px;height:600px"></div>

		<script type="text/javascript">
		var psLineChar = echarts.init(document.getElementById('psLine'))

				<%--var option={
				title:{
				text:'全院门诊收入'
	},
				tooltip:{},
				legend:{
					data:['收入']
	},
				xAxis:{
					data:['一月','二月','三月']
	},
				yAxis:{

	},
				series:[{
					name:'收入',
					type:'line',
					data:[20000,30000,40000]
	}]


	};--%>
		$.ajax({
		url:"income?section=hospital&for=json",
		type:"get",
		dataType:"json",
		success:function(data){
		if(data.success){
			console.debug(data.obj);
	psLineChar.setOption(data.obj);
	};
	}
	});


	    </script>
	</body>
</html>