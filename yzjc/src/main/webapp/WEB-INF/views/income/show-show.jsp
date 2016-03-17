	<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
		 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
			<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html lang="en">
		<head>
		<base href="<%=basePath %>">
		<title>ECharts-基本线性图</title>

		<script src="echarts/echarts.js" type="text/javascript"></script>
		<script src="echarts/esl.js" type="text/javascript"></script>
		</head>
		<body>
		<div id="main" style="height: 500px; border: 1px solid #ccc; padding: 10px;">
		</div>
		<script type="text/javascript" language="javascript">
		// Step:4 require echarts and use it in the callback.
		// Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径


		//创建ECharts图表
		//--- 折柱 ---
		var myChart = echarts.init(document.getElementById('main'));
		//图表显示提示信息
		myChart.showLoading({
		text: "图表数据正在努力加载..."
		});
		myChart.hideLoading();
		myChart.setOption({
		title: {
		text: "我的第一个ECharts图表示例"
		},
		tooltip: {
		trigger: 'axis'
		},
		legend: {
		data: ['蒸发量', '降水量']
		},
		toolbox: {
		show: true,
		feature: {
		mark: true,
		dataView: { show:true,readOnly: false },
		magicType:{show:true, type:['line','bar']},
		restore: true,
		selfButtons:{//自定义按钮 danielinbiti,这里增加，selfbuttons可以随便取名字
		show:true,//是否显示
		title:'自定义', //鼠标移动上去显示的文字
		icon:'test.png', //图标
		option:{},
		onclick:function(option1) {//点击事件,这里的option1是chart的option信息
		alert('1');//这里可以加入自己的处理代码，切换不同的图形
		}
		},
		saveAsImage: {
		type: "png",
		name: "Echarts",
		lang: "我要保存"
		}
		}
		},
		calculable: true,
		xAxis: [
		{
		type: 'category',
		data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
		}
		],
		yAxis: [
		{
		type: 'value',
		splitArea: { show: true }
		}
		],
		series: [
		{
		name: '蒸发量',
		type: 'bar',
		data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
		},
		{
		name: '降水量',
		type: 'bar',
		data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
		}
		]
		});

		<%--var ecConfig = require('echarts/config');
		//ECharts图表的click事件监听
		myChart.on("click", function () {
		alert("你点击我了!");
		});--%>

		</script>
		</body>
		</html>