<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">

    <title>IJOY无线数字医疗系统</title>

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
                    <li><a href="loginInfo_register.action">注册</a>
                    </li>
                    <li>
                        <input type="text" class="form-control search" placeholder="搜索">
                    </li>
                    <!-- user login dropdown start-->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <img alt="" src="img/avatar1_s.jpg">
                            <span class="username">${session.user.name}</span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <div class="log-arrow-up"></div>
                            <li><a href="#"><i class=" icon-suitcase"></i>我的任务</a></li>
                            <li><a href="#"><i class="icon-cog"></i> 设置</a></li>
                            <li><a href="#"><i class="icon-bell-alt"></i> 帮助中心</a></li>
                            <li><a href="<%=basePath%>loginInfo_logout.action"><i class="icon-key"></i> 退出</a></li>
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
                      <a class="" href="index.html">
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
      <section id="main-content">
       <iframe src="<%=basePath%>index_main.action" id="iframepage" onLoad="iFrameHeight()" frameborder="0" scrolling="no"  width="1200px;"   name="main" align="left" style="border-top-width: 60px;"></iframe> 
       </section>
         
  </section>
  
  <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/jquery-1.8.3.min.js"></script>
      <script>
      
      function iFrameHeight(){
    	  console.debug(window.screen.height);
    	  $("#iframepage").attr("height",window.screen.height-140);
      }
      (function(){
    	  $.ajax({
   			type:"GET",
   			url:"userContext_loadMenu.action",
   			dataType:"json",
   			async:false,
   			success:function(data){
   				var menuhtml;
   				$.each(data,function(i,n){
   					if(n.parent==null){
   					 console.debug("???????????");
   						console.debug(n);
   						console.debug("||||||||||||");
   						menuhtml+="<li class='sub-menu'>";
   						menuhtml+="<a href='javascript:;' target='main' class=''><i class='icon-cogs'></i><span>"+n.text+"</span><span class='arrow'></span></a>";
   						menuhtml+=buildMenu(n);
   						menuhtml+="</li>";
   						console.debug(menuhtml);
   					}
   				});
   				$(menuhtml).insertAfter("#sidebar > ul > li :eq(0)");
   			}
   		});
      })();
     function  buildMenu(data){
   	  /*
   	  如果 n有子菜单
   	  */
   	  var childhtml="<ul class='sub'>";
   	  if(data.children.length>0){
   		  $.each(data.children,function(i,child){
   			  console.debug("---------");
   			 console.debug(child); 
   			console.debug("++++++++");
   			 childhtml+="<li><a class='' target='main' href="+child.url+">"+child.text+"</a></li>";
   		  });
   	  }
   	  childhtml+="</ul>";
   	  return childhtml;
     }
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
