<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  	<base href="<%=basePath%>">
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
    .modal-dialog  .form-group{
    		
    }
    
    </style>
    
  </head>
  <body>
  	<div class="modal-dialog modal-lg"  style="width:40%" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="myModalLabel">角色查看</h4>
        </div>
        <div class="modal-body">
      					        <div  style="display: block"  class="form-horizontal">
      					          		<!-- //表单令牌 -->
      					  <%-- <c:when test="role.id!=null">
      					  			 <div class="form-group">
                            	<div>序号</div>
                            	<div>
                            		<input  class="form-control" name="id"  readonly="true"  value="${role.realName}">
                            	</div>
                          </div>
      					  </c:when> --%>
      					  		<div class="form-group hidden"  >
                            	<label  class="col-sm-2  col-md-offset-1 control-label">序号</label>
                            	<div class="col-sm-4">
                            		<input  class="form-control"  name="id"  readonly="true"  value="${role.id}">
                            	</div>
                          </div>
      					    <div class="form-group">
							    <label  class="col-sm-2  col-md-offset-1 control-label">登录账号</label>
							    <div class="col-sm-4">
							      <input type="text" class="form-control"  value=${role.name } >
							    </div>
							  </div>
                          <div class="form-group">
                         		 <div class="col-sm-offset-2 col-sm-10">
					                <button type="button" class="btn btn-primary"  id="closeView">确定关闭</button>
					              </div>
                          </div> 
                        </div>
        					</div>
        			</div>
                          </div>
              <!-- page end-->
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/model/domain.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <script type="text/javascript" src="assets/data-tables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>
    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
    <!--script for this page only-->
    <script src="js/dynamic-table.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#closeView").on("click",function(){
    			location.href="role";
    		})
    	});
    
    </script>
    
  </body>
</html>