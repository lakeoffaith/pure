<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html class="login-bg" >
<head>
	<base  href="<%=basePath%>"/>
<title>Ijoy登录</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/elements.css" />

    <!-- libraries -->
    <!-- <link rel="stylesheet" type="text/css" href="css/lib/font-awesome.css" /> -->
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/signin.css" type="text/css" media="screen" />
	
	<script  src="js/jquery.js" type="text/javascript"></script>
	<script  src="js/validation/jquery.validate.js" type="text/javascript"></script>
	<script type="text/javascript">
	if(window.top!=window.self){
		 document.write=""; // write an empty text node to the document. (not sure why) 
		  window.top.location=window.self.location; // set the parent document's location to this document's location.
		  setTimeout( function(){document.body.innerHTML=""}, 0.01); // after 1 millisecond make this document's HTML empty. (Probably a memory leak fix) 
		  window.self.onload = function(){document.body.innerHTML=""} // 
	}
	
	$().ready(function(){
		$.validator.addMethod("stringCheck",function(value,element){
			return this.optional(element) ||  /^[a-zA-Z](?![a-zA-Z]+$)\w{4,10}$/.test(value);
		},"必须包括英文字母，数字，可以含义下划线 且以字母开头 5-10位");
		$("#loginForm").validate({
			rules:{
				name:{
					required:true,
					stringCheck:true,
				},
				password:{
					required:true,
					stringCheck:true
				}
			},
			messages:{
				name:{
					required:"没有填写用户名",
					stringCheck:"必须包含英文和数字，且5-10位",
				},
				password:{
					required:"没有填写密码",
					stringCheck:"必须包含英文和数字,且5-10位"
				}
			}
		});
	});
</script>
</head>
<body>
<form action="loginInfo/check" id="loginForm" method="post">
	<div class="row-fluid login-wrapper">
        <a href="index.html">
            <img class="logo" src="img/signin-logo.png" />
        </a>
        <div class="span4 box">
            <div class="content-wrap">
                <h6>用户登录</h6>
                <!--  用户名为数字和字母结合6-12位,无重复 -->
                <input  cssClass="span12" type="text" name="name" placeholder="用户名" value="admin1"/> 
                <!--  用户名为数字和字母结合6-12位-->
                <input cssClass="span12" type="password" name="password" placeholder="密码" value="admin1"  />
                <a href="#" class="forgot">忘记密码?</a>
                <div class="remember">
                		<input id="remember-me"  type="checkbox"  name="rememberFlag" />
                    <label for="remember-me">记住密码</label>           
                </div>
                <button class="btn-glow primary login">登录</button>
            </div>
        </div>
        <div class="span4 no-account">
            <p>还没有帐号?</p>
            <a href="loginInfo/register">注册</a>
        </div>
    </div>

</form>
</body>
</html>
