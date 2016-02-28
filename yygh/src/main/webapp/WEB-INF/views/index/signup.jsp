<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html class="login-bg">
<head>
	<base href="<%=basePath%>">
	<title>Detail Admin - Sign up</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
   
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <!-- libraries -->
    
    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/elements.css" />

    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/signup.css" type="text/css" media="screen" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
     
<body>
    <div class="row-fluid login-wrapper col-md-offset-4 col-md-4">
        <div class="box">
            <div class="content-wrap">
                <div id="" class="">
                    <a href="" title="">
                        <i class="signuplogo"></i>
                    </a>
                </div>
                <div class="form-group has-error">
  <label class="control-label" for="inputEmail">输入邮箱格式不对</label>
  <input type="text" class="form-control" id="inputEmail" placeholder="邮箱">
</div>
<div class="form-group has-error">
  <label class="control-label" for="inputName">用户名已经存在</label>
  <input type="text" class="form-control" id="inputName" placeholder="用户名">
</div>
<div class="form-group has-warning">
  <label class="control-label" for="inputPassword">密码太弱</label>
  <input type="password" class="form-control" id="inputPassword" placeholder="密码">
</div>
                
                <button class="btn btn-primary btn-lg">注册</button> 
                <div class="pull-right- text-left color-text-grayer pt_15">
                    点击注册，表明你同意我们的<a href="/terms" class="color-text-grayer">《服务条款》</a>
                </div>              
            </div>
        </div>

        <div class="span3 already">
            <a href="signin.html">返回登录</a>
        </div>
    </div>
</body>
</html>