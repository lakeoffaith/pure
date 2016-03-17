<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>" />
<title>页面报错</title>
    <script src="js/jquery.js"></script>
     <!-- domain.js for domain -->
     <script src="js/model/domain.js"></script>
<script type="text/javascript"> 
	var t = 5; 
	function countDown(){ 
	var time = document.getElementById("time"); 
	t--; 
	//time.value=t;
	time.innerHTML = t;
	if (t<=0) { 
	top.location.href="index.action"; 
	clearInterval(inter); 
	}; 
	} 
	var inter = setInterval("countDown()",1000); 
</script> 
</head>
<body onload="countDown()">
	<div align="center">
		访问的页面找不到，<span id="time">5</span>秒后回到 主页面<br>
		若5秒后，没有跳转<a href='javascript:window.top.location="index.action";document.body.innerHTML="";'>点击这里</a>
	</div>

</body>
</html>
