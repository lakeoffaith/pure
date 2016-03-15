<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
     	<base href="<%=basePath%>">
  </head>
  <body>
  	<h1>设置中心</h1>
  	<form action="employee/saveSet.action" method="post">
  	<label>记住密码天数</label>
  	<s:textfield name="rememberdays"></s:textfield>
  	<s:submit value="保存"></s:submit>
  	</form>
  	<a href='javascript:window.top.location.href="index";window.body.innerHTML="";' >返回首页</a>
  	</body>
</html>