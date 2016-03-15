<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html class="login-bg">
<head>
	<base  href="<%=basePath%>"/>
		<title>Detail Admin - Sign up</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />
    <!-- libraries -->
    
    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/elements.css" />

    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/signup.css" type="text/css" media="screen" />

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script  src="js/jquery.js" type="text/javascript"></script>
	<script  src="js/validation/jquery.validate.js" type="text/javascript"></script>
	<!-- domain.js for domain -->
     <script src="js/model/domain.js"></script>
	<script type="text/javascript">
	$().ready(function(){
		$.validator.addMethod("stringCheck",function(value,element){
			return this.optional(element) ||  /^[a-zA-Z](?![a-zA-Z]+$)\w{4,10}$/.test(value);
		},"必须包括英文字母，数字，可以含义下划线 且以字母开头 5-10位");
		$("#loginSaveForm").validate({
			rules:{
				name:{
					required:true,
					stringCheck:true,
					remote:pathjs+"loginInfo/checkname.action"
				},
				password:{
					required:true,
					stringCheck:true
				},
				confirmpassword:{
					equalTo:'#password'
				}
				
			},
			messages:{
				name:{
					required:"没有填写用户名！",
					stringCheck:"必须包含英文和数字，且5-10位！",
					remote:"用户名已经存在"
				},
				password:{
					required:"没有填写密码",
					stringCheck:"必须包含英文和数字,且5-10位！"
				},
				confirmpassword:{
					equalTo:"确认密码必须与密码相同！"
				}
				
			}
		});
	});
</script>
</head>
<body>
<form action="<%=basePath %>loginInfo/save.action" id="loginSaveForm" method="post">

<div class="row-fluid login-wrapper">
        <div class="box">
            <div class="content-wrap">
                <div id="" class="">
                    <a href="" title="">
                        <i class="signuplogo"></i>
                    </a>
                </div>
                <!-- <input class="span12" type="text" placeholder="邮箱" /> -->
                <!--  用户名为数字和字母结合6-12位,无重复 -->
                <input class="span12" type="text" name="name" placeholder="用户名" />
                <!--  用户名为数字和字母结合6-12位-->
                <input class="span12" type="password" name="password" id="password" placeholder="密码"/>
                 <!--  用户名为数字和字母结合6-12位-->
                <input class="span12" type="password" name="confirmpassword"  placeholder="确认密码"/>
                <div class="action">
                    <button class="btn-glow success signup">注册</button>
                </div>  
                <div class="pull-right- text-left color-text-grayer pt_15">
                    点击注册，表明你同意我们的<a href="/terms" class="color-text-grayer">《服务条款》</a>
                </div>              
            </div>
        </div>

        <div class="span3 already">
            <a href="login.action">返回登录</a>
        </div>
    </div>

	
</form>
</body>
</html>
