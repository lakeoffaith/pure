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
  	<base  href="<%=basePath %>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    
    <link rel="shortcut icon" href="img/favicon.html">

   <title>ijoy院长决策系统</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="assets/morris.js-0.4.3/morris.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />
    <link href="css/res-style.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
<%--        <script type="text/javascript">
  	if(window.top!=window.self){
    		 document.write=""; // write an empty text node to the document. (not sure why) 
    		  window.top.location=window.self.location; // set the parent document's location to this document's location.
    		  setTimeout( function(){document.body.innerHTML=""}, 0.01); // after 1 millisecond make this document's HTML empty. (Probably a memory leak fix) 
    		  window.self.onload = function(){document.body.innerHTML=""} // 
    	} 
    </script> --%>
  </head>
  <body>
  <section id="container" class=""  >
      <!--header start-->
      <header class="header white-bg">
            <div class="sidebar-toggle-box">
                <div data-original-title="切换导航" data-placement="right" class="icon-reorder tooltips"></div>
            </div>
            <!--logo start-->
            <a href="#" class="logo"><img src="img/IJOY.jpg" alt=""><span>移动互联网智慧医疗系统</span><span class="tlt2">四川大学华西医院</span></a>
            <!--logo end-->
            <div class="top-nav ">
                <!--search & user info start-->
                <ul class="nav pull-right top-menu">
                    
                    <li>
                        <input type="text" class="form-control search" placeholder="搜索">
                    </li>
                    <!-- user login dropdown start-->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <img alt="" src="img/avatar1_s.jpg">
                            <span class="username">${sessionScope.user.name }</span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <div class="log-arrow-up"></div>
                            <li><a href="task/list" target="main"><i class=" icon-suitcase"></i>我的任务</a></li>
                            <li><a href="employee/set" target="main"><i class="icon-cog"></i> 设置</a></li>
                            <li><a href="employee/help" target="main"><i class="icon-bell-alt"></i> 帮助中心</a></li>
                            <li><a href="loginInfo/logout" target="main"><i class="icon-key"></i> 退出</a></li>
                        </ul>
                    </li>
                    <!-- user login dropdown end -->
                </ul>
                <!--search & user info end-->
            </div>
        </header>
      <!--header end-->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu">
                  <li class="active">
                      <a class="" href="index.action">
                          <i class="icon-home"></i>
                          <span>首页</span>
                      </a>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      <!--main content start-->
         <iframe src="main" id="iframe"  style="margin-left: 180px;margin-top: 60px;"    frameborder="0" scrolling="yes"    name="main" align="left" ></iframe> 
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/model/domain.js"></script>
    <script src="js/jquery-1.8.3.min.js"></script>
     <script src="js/ijoy/global.js"></script>
      <script  type="text/javascript">
      
  	$(function() {
  		$.ajax({
  			url:"menu/load",
   			type:"GET",
   			async:false,
   			dataType:"json",
   			success:function(data){
   				if(data.success){
   					var menuhtml="";
   	   				
   	   				$.each(data.results,function(i,n){
   	   					if(n.parent_id==null){
   	   						menuhtml+="<li class='sub-menu' data-menu_id="+n.id+">";
   	   						if(!jsValidateIsNull(n.url)){
   	   						var urlval=console.debug(n.url);
   	   						menuhtml+="<a href="+n.url;
   	   						}else{
   	   							menuhtml+="<a href='javascript:void(0)'";
   	   						}
   	   						menuhtml+=" target='main' class=''><i class="+n.iconname+"></i><span>"+n.name+"</span>";
   	   					//如果有子类的话
   	   						if(n.childNum>0){
   	   							menuhtml+="<span class='arrow'></span>";
   	   						}
   	   						menuhtml+="</a></li>";
   	   					}
   	   				});
   	   				console.debug(menuhtml);
   	   				$(menuhtml).insertAfter("#sidebar > ul > li :eq(0)");
   	   				$("span.arrow").on("click",function(){
   	   					var $menu=$(this).parents("li.sub-menu");
   	   					var id=$menu.attr("data-menu_id");
   	   				var baseQuery={"parent_id":id};
   	   					$.ajax({
   	   						url:"menu?for=json",
   	   						data:baseQuery,
   	   						type:"get",
   	   						dataType:"json",
   	   						success:function(data){
   	   							if(data.success){
   	   							$menu.find("ul").remove();
   	   							var childhtml="<ul class='sub'>";
   	   			   		  $.each(data.results,function(i,child){
   	   			   		/*  */
   	   			   			 childhtml+="<li><a class='' target='main' href="+child.url+">"+child.name+"</a></li>";
   	   			   		  });
   	   			   	  childhtml+="</ul>";
   	   			   	  	$menu.append(childhtml);
   	   			      
   	   			 
   	   			   	  	
   	   			   	  	
   	   							}
   	   						}
   	   					});
   	   				 if( $menu.find("span.arrow").hasClass("open")){
      	   				$menu.find("span.arrow").removeClass("open");
      	   	   				$menu.find("span.arrow").addClass("close");
      	   	   		$menu.removeClass("active");
      	   	   				}else{
      	   	   			$menu.find("span.arrow").removeClass("close");
      	   	   				$menu.find("span.arrow").addClass("open");
      	   	   	$menu.addClass("active");
      	   	   				};
   	   				
   	   				});
   				}
   			}
   		});
	});
  	
      $('#iframe').css({
        	'width':$(window).width()-180,
        	'height':$(window).height()-60
        });
     </script>
    
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="js/jquery.sparkline.js" type="text/javascript"></script>
    <script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
    <script src="js/owl.carousel.js" ></script>
    <script src="js/jquery.customSelect.min.js" ></script>

    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="js/easy-pie-chart.js"></script>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/morris.js-0.4.3/morris.min.js" type="text/javascript"></script>
    <script src="assets/morris.js-0.4.3/raphael-min.js" type="text/javascript"></script>
    <script src="assets/chart-master/Chart.js"></script>

    <!-- script for this page only-->
    <script src="js/morris-script.js"></script>
    <script src="js/all-chartjs.js"></script>
    <script src="js/sparkline-chart.js"></script>
   
  <script>

      //owl carousel
     //修改iframepage的初始宽度上
       
      $(document).ready(function() {
          $("#owl-demo").owlCarousel({
              navigation : true,
              slideSpeed : 300,
              paginationSpeed : 400,
              singleItem : true

          });
      });

      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });
      
     
  </script>


  </body>
</html>
