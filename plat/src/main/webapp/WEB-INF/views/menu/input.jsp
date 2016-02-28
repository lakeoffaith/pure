<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="<%=path%>/img/favicon.html">

    <title>IJOY无线数字医疗系统</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="<%=path%>/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="<%=path%>/css/style.css" rel="stylesheet">
    <link href="<%=path%>/css/style-responsive.css" rel="stylesheet" />

    <link href="<%=path%>/css/res-style.css" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  	<div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="myModalLabel">菜单编辑</h4>
        </div>
        <div class="modal-body">
         
        <form action="<%=basePath%>menu/save.action" class="form-horizontal" id="domainFormID" method="post">
      					<!-- //表单令牌 -->
      				<s:token></s:token>
                          <s:if test="id!=null">
            <div class="form-group">
              <div>序号</div>
              <div><s:textfield cssClass="form-control" name="id" readonly="true"/>
              </div>
            </div>
            </s:if>
                            <div class="form-group">
                            	<div>菜单名称</div>
                            	<div><s:textfield cssClass="form-control" name="name"/></div>
                          </div>
                          <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">确定保存</button>
              </div>
            </div>
          </form>
           </div>
      </div>
    </div>
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="<%=path%>/js/jquery.js"></script>
    <script src="<%=path%>/js/model/domain.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script src="<%=path%>/js/jquery.scrollTo.min.js"></script>
    <script src="<%=path%>/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script type="<%=path%>/text/javascript" src="assets/data-tables/jquery.dataTables.js"></script>
    <script type="<%=path%>/text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>


    <!--common script for all pages-->
    <script src="<%=path%>/js/common-scripts.js"></script>

    <!--script for this page only-->
    <script src="<%=path%>/js/dynamic-table.js"></script>
    
   </form>
  </body>
</html>