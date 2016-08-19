<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0; minimum-scale=1.0; user-scalable=no; target-densityDpi=device-dpi">
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
    <style type="text/css">
    
    </style>
  </head>

  <body>
  <section id="main-content"  data-employee_id="${sessionScope.user.id }">
          <section class="wrapper ">
              <!--state overview start-->
              <div class="row" style="padding: 0px; ">
                      <!--breadcrumbs start -->
                      <ul class="breadcrumb" >
                          <li class="active"><a href="#"><i class="icon-home"></i> 首页</a></li>
                      </ul>
                      <!--breadcrumbs end -->
              </div>
              <div class="row state-overview" style="padding: 0px; ">
                  <div class="col-lg-8 col-md-8 col-sm-8">
                      <div class="row">
                          <div class="col-lg-3 col-md-3 col-sm-3">
                              <section class="panel">
                                  <div class="symbol terques">
                                      <i class="icon-user"></i>
                                  </div>
                                  <div class="value">
                                      <h4>${allEmployeeCount }</h4>
                                      <p>新用户</p>
                                  </div>
                              </section>
                          </div> 
                          <div class="col-lg-3 col-md-3 col-sm-3" >
                              <section class="panel">
                                  <div class="symbol red">
                                      <i class="icon-user-md"></i>
                                  </div>
                                  <div class="value">
                                      <h4>5673454</h4>
                                      <p>就诊人次</p>
                                  </div>
                              </section>
                          </div>
                          <div class="col-lg-3 col-md-3 col-sm-3" >
                              <section class="panel">
                                  <div class="symbol yellow">
                                      <i class="icon-paste"></i>
                                  </div>
                                  <div class="value">
                                      <h4>${ownTaskItemCount }</h4>
                                      <p>我的任务</p>
                                  </div>
                              </section>
                          </div>
                          
                          <div class="col-lg-3 col-md-3 col-sm-3"  id="ownApplicationDivId">
                              <section class="panel">
                                  <div class="symbol blue">
                                      <a href="application" ><i class="icon-unlock"></i></a>
                                  </div>
                                  <div class="value">
                                      <h4>6</h4>
                                      <p>已授权应用</p>
                                  </div>
                              </section>
                          </div>
                      </div><!-- / -->
                      <!--custom chart start-->
                      <section class="panel">
                          <header class="panel-heading">
                              用户数
                          </header>
                          <div class="panel-body">
                              <div id="hero-bar" class="graph"></div>
                          </div>
                      </section>
                      <!--custom chart end-->
                  </div>
                  <div class="col-lg-4 col-md-4 col-sm-4">
                      <!--weather statement start-->
                      <!-- <section class="panel">
                          <div class="weather-bg">
                              <div class="panel-body weather">
                                  <div class="row">
                                      <div class="col-xs-6">
                                        <i class="icon-cloud"></i>
                                          成都市
                                      </div>
                                      <div class="col-xs-6">
                                          <div class="degree">
                                              24°
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>

                          <footer class="weather-category">
                              <ul>
                                  <li class="active">
                                      <h5>湿度</h5>
                                      56%
                                  </li>
                                  <li>
                                      <h5>雾霾</h5>
                                      中度 152
                                  </li>
                                  <li>
                                      <h5>风</h5>
                                      南风 微风
                                  </li>
                              </ul>
                          </footer>

                      </section> -->
                      <!--weather statement end-->
                      <section class="panel">
                          <div class="panel-body user-info">
                              <a href="#" class="task-thumb">
                                  <img src="img/avatar1.jpg" alt="">
                              </a>
                              <div class="task-thumb-details">
                                  <h1><a href="#">${session.user.name}</a></h1>
                                  <p>高级医师</p>
                              </div>
                          </div>
                          <table class="table table-hover personal-task">
                              <tbody>
                                <tr>
                                    <td>
                                        <i class=" icon-tasks"></i>
                                    </td>
                                    <td>新的任务</td>
                                    <td> 02</td>
                                </tr>
                                <tr>
                                    <td>
                                        <i class="icon-warning-sign"></i>
                                    </td>
                                    <td>任务待定</td>
                                    <td> 14</td>
                                </tr>
                                <tr>
                                    <td>
                                        <i class="icon-envelope"></i>
                                    </td>
                                    <td>收件箱</td>
                                    <td> 45</td>
                                </tr>
                                <tr>
                                    <td>
                                        <i class=" icon-bell-alt"></i>
                                    </td>
                                    <td>新的通知</td>
                                    <td> 09</td>
                                </tr>
                                <tr>
                                    <td>
                                        <i class=" icon-bell-alt"></i>
                                    </td>
                                    <td>新的通知</td>
                                    <td> 09</td>
                                </tr>
                                <tr>
                                    <td>
                                        <i class=" icon-bell-alt"></i>
                                    </td>
                                    <td>新的通知</td>
                                    <td> 09</td>
                                </tr>
                              </tbody>
                          </table>
                      </section>
                  </div>
              </div>
              <!--state overview end-->

              <div class="row" style="padding: 0px; ">
                  <div class="col-lg-6 col-md-6 col-sm-6">
                      <!--revenue start-->
                      <section class="panel panel-m0">
                          <div class="revenue-head has">
                              <span>
                                  <i class="icon-bar-chart"></i>
                              </span>
                              <h3>已授权应用</h3>
                              <span class="rev-combo pull-right">
                                 更多
                              </span>
                          </div>
                          <div class="panel-body">
                              <div class="row">
                                  <div class="col-lg-12 col-md-12 col-sm-12">
                                      <section class="panel panel-m0">
                                          <div class="panel-body">
                                              <ul class="summary-list"  id="OwnApplicationUlId">
                                                 
                                                    <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          预约挂号
                                                      </a>
                                                  </li>
                                              </ul>
                                          </div>
                                      </section>
                                  </div>
                              </div>
                          </div>
                      </section>
                      <!--revenue end-->
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6">
                      <!--revenue start-->
                      <section class="panel">
                          <div class="revenue-head">
                              <span>
                                  <i class="icon-bar-chart"></i>
                              </span>
                              <h3>未授权应用</h3>
                              <span class="rev-combo pull-right">
                                 更多
                              </span>
                          </div>
                          <div class="panel-body">
                              <div class="row">
                                  <div class="col-lg-12 col-md-12 col-sm-12">
                                      <section class="panel panel-m0">
                                          <div class="panel-body">
                                              <ul class="summary-list">
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          院长决策
                                                      </a>
                                                  </li>
                                                
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          移动护理
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          无线定位
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          无线考勤
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          移动会诊
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          家庭医生
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          医院物流
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          无线输液
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          语音呼叫
                                                      </a>
                                                  </li>
                                                  <!-- <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          院长决策
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          自动配药
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          资产管理
                                                      </a>
                                                  </li> -->
                                                  <!-- <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          上门巡诊
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          无线对讲
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          医疗看护
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          病人识别
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          设备定位
                                                      </a>
                                                  </li>
                                                  <li>
                                                      <a href="javascript:;">
                                                          <img src="img/app14.png" alt="">
                                                          智能导医
                                                      </a>
                                                  </li> -->
                                              </ul>
                                          </div>
                                      </section>
                                  </div>
                              </div>
                          </div>
                      </section>
                      <!--revenue end-->
                  </div>
                  <div id="examplefirst"  class="col-lg-12 col-md-12 col-sm-12" style="height: 250px;width: 100%;padding: 0px;margin-top: 200px "></div>
              </div>
    </section>
  </section>
      <!--main content end-->
  <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/jquery-1.8.3.min.js"></script>
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
    <script type="text/javascript">
                                          			function loadOwnApplication(employee_id,$ul){
                                          				
                                          				var baseQuery={};
                                          				baseQuery.employee_id=employee_id;
                                          				$.ajax({
                                          					url:"application?"+"for=json",
                                          					data:baseQuery,
                                          					type:"get",
                                          					dataType:"json",
                                          					success:function(data){
                                          						if(data.success){
                                          							$ul.empty();
                                          							str="";
                                          							$.each(data.results,function(e,v){
                                          								str+="<li onclick='goNewTab(\""+v.url+"\")'><img src='img/app14.png'>"+v.name+"</li>"
                                          							});
                                          							$ul.append(str);
                                          							$("#ownApplicationDivId").find("h4").html(data.results.length);
                                          						}
                                          					}
                                          				});
                                          			}
                                          		$(function(){
                                          			employee_id=$("#main-content").attr("data-employee_id");
                                          			loadOwnApplication(employee_id,$("#OwnApplicationUlId"));
                                          			
                                          		});
                                          	
                                          	</script>
  <script>

    /*   浏览器新打开一个tab */
		function goNewTab(url){
    	  window.open(url);
      }	;
      
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
