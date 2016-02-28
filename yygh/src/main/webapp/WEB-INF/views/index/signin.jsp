<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html class="login-bg" >
<head>
	<base href="<%=basePath%>">
	<title>Ijoy登录</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	
    <!-- bootstrap -->
   <link rel="stylesheet" type="text/css" href="css/bootstrap.css">


    <!-- libraries -->
    <!-- <link rel="stylesheet" type="text/css" href="css/lib/font-awesome.css" /> -->
    
    <!-- this page specific styles -->
   <link rel="stylesheet" type="text/css" href="css/signin.css">

<body>
    <div class="login-wrapper col-md-offset-4 col-md-4">
        <a href="index.html" >
            <img  src="images/signin-logo.png" style="margin-bottom:30px;"/>
        </a>

        <div class="span4 box">
            <div class="content-wrap">
            
                <h6>用户登录</h6>
                <div class="form-group has-error">
  <label class="control-label" for="inputName">不存在此用户名</label>
  <input type="text" class="form-control" id="inputName" placeholder="用户名">
</div>
               <div class="form-group has-warning">
  <label class="control-label" for="inputPassowrd">密码强度太弱</label>
  <input type="text" class="form-control" id="inputPassowrd" placeholder="密码">
</div>

                <a href="#" class="forgot">忘记密码?</a>
                <div class="remember">
                    <input id="remember-me" type="checkbox" />
                    <label for="remember-me">记住密码</label>
                </div>
                <button class="btn btn-primary">登录</button>
            </div>
        </div>

        <div class="span4 no-account">
            <p>还没有帐号?</p>
            <a href="signup.html">注册</a>
        </div>
    </div>
</body>
</html>