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
		<script src="js/jquery.js"></script>
		<script src="echarts/echarts.js"></script>
	</head>
	<body>
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