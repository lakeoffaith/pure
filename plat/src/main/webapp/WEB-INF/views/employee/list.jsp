<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="ption" prefix="page" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  	<base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    <link href="css/model/ijoymodel.css" rel="stylesheet" />
    <script src="js/jquery.js"></script>
     <!-- domain.js for domain -->

    <script src="js/bootstrap.min.js"></script>
         <script src="js/model/domain.js"></script>
              <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <!--common script for all pages-->
         <script src="js/common-scripts.js"></script>
<!--      <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script> 


    <script src="js/common-scripts.js"></script>-->
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
              <!-- page start-->
              <div class="row" style="width: 100%;padding: 0px; ">
                  <ul class="breadcrumb">
                      <li><a href='javascript:window.top.location="index.action";document.body.innerHTML="";'><i class="icon-home"></i> 首页</a></li>
                      <li class="active">员工管理</li>
                  </ul>
                  <div class="col-lg-12 col-md-12 col-sm-12" style="margin: 0px 15px 0px">
                      <section class="panel">
                          <header class="panel-heading">
                             员工管理
                          </header>
                          <table class="table">
                          <thead>
                            <tr>
                              <th colspan="10" class="oprow-btn">
                              	<div class="row">
                              	<div class="col-lg-8 col-md-8 col-sm-8">
                               		  <!-- <label for="newInputDomainID" class="btn btn-info " ><i class="icon-plus">&nbsp;新增</i></label>
    								<input type="button" id="newInputDomainID" class="hidden"   onclick="doDomain('employee','input')"></input> -->
    								<label for="batchDeleteDomainID" class="btn btn-danger " ><i class="icon-trash">&nbsp;批量删除</i></label>
    								<input type="button" id="batchDeleteDomainID" class="hidden"  style="margin-left:10px"  onclick="batchDeleteDomain('employee')"></input>
    								</div>
    								<div class="col-lg-4 col-md-4 col-sm-4" align="right">
								  	<label >登录账号</label>
								  	<input name="baseQuery.name" id="name" cssClass="form-control" cssStyle="width:100px;">
								  			<label for="searchDomainID" class="btn btn-info " ><i class="icon-search">&nbsp;查询</i></label>
    								<input type="button" id="searchDomainID" class="hidden" style="float: right"  onclick="doDomain('employee','search')"></input>
    								</div>
    								</div>
                              </th>
                          </tr>
                          <tr>
                              <th style="width:8px;"><input type="checkbox" id="checkboxes" /></th>
                              <th>序号</th>
                              <th class="hidden-phone">真实姓名</th>
                              <th class="hidden-phone">登录账号</th>
                              <th class="hidden-phone">所属科室</th>
                              <th class="hidden-phone">所属角色</th>
                              <th class="hidden-phone">联系电话</th>
                              <th class="hidden-phone" width="9%" style="min-width: 80px;"><i class="icon-edit"></i> 操作 
                              </th>
                          </tr>
                          </thead>
                          <tbody >
                          	<c:forEach  items="${pageResult.rows }"   var="r">
                          			<tr class="odd gradeX">
                              <td><input type="checkbox"  value="1" /></td>
                              <td>${r.id}</td>
                              <td class="hidden-phone">${r.realName}</td>
                              <td class="hidden-phone">${r.name}</td>
                              <td class="hidden-phone">${r.department}</td>
                              <td class="hidden-phone">${r.role.name}</td>
                              <td class="hidden-phone">${r.cellphone}</td>
                              <td>
                                  	<label for="viewDomainID" class="btn btn-success btn-xs" title="查看" onclick="doModelDomain('employee','goUpdate','${r.id}')"><i class="icon-file"></i></label>
    								<input type="button" id="viewDomainID" class="hidden"   ></input>
                                   <label for="inputDomainID" class="btn btn-primary btn-xs" title="编辑" onclick="doModelDomain('employee','goUpdate','${r.id}')"><i class="icon-pencil"></i></label>
    								<input type="button" id="inputDomainID" class="hidden"   ></input>
                                   <label for="deleteDomainID" class="btn btn-danger btn-xs" title="删除" onclick="doModelDomain('employee','delete','${r.id}')"><i class="icon-trash"></i></label>
    								<input type="button" id="deleteDomainID" class="hidden"></input>
                              </td>
                          </tr>
                          	</c:forEach>
                          </tbody>
                          </table>
                      </section>
                     
                  </div>
              </div>
              <!-- page end-->
              <page:htmlPage pageNo="${pageResult.currentPage}" url='employee/list.action' totalSum="${pageResult.totalCount}" showPage="5" pageSize="${pageResult.pageSize}"/>
    <!-- js placed at the end of the document so the pages load faster -->

   			  <div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>
  
  </body>
</html>