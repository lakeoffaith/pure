<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
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
    <script src="js/jquery.js"></script>
     <!-- domain.js for domain -->
     <script src="js/model/domain.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
     <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
 <%--  action="<%=basePath %>task/list.action" --%>
       <form id="domainForm" Class="form-inline" action="task/list.action">
              <!-- page start-->
              <div class="row" style="width: 100%;padding: 0px; ">
                  <ul class="breadcrumb">
                      <li><a href='javascript:window.top.location="index.action";document.body.innerHTML="";'><i class="icon-home"></i> 首页</a></li>
                      <li class="active">任务管理</li>
                  </ul>
                  <div class="col-lg-12 col-md-12 col-sm-12" style="margin: 0px 15px 0px">
                      <section class="panel">
                          <header class="panel-heading">
                             任务管理
                          </header>
                          <table class="table">
                          <thead>
                            <tr>
                              <th colspan="13" class="oprow-btn">
                              	<div class="row">
                              	<div class="col-lg-8 col-md-8 col-sm-8">
                               		  <label for="newInputDomainID" class="btn btn-info " ><i class="icon-plus">&nbsp;新增</i></label>
    								<input type="button" id="newInputDomainID" class="hidden"   onclick="doDomain('task','input')"></input>
    								<label for="batchDeleteDomainID" class="btn btn-danger " ><i class="icon-trash">&nbsp;批量删除</i></label>
    								<input type="button" id="batchDeleteDomainID" class="hidden"  style="margin-left:10px"  onclick="batchDeleteDomain('task')"></input>
    								</div>
    								<div class="col-lg-4 col-md-4 col-sm-4" align="right">
								  	<label >名称</label>
								  			<input  name="baseQuery.name"  id="name"  cssClass="form-control"  cssStyle="width:100px;" >
								  			<label for="searchDomainID" class="btn btn-info " ><i class="icon-search">&nbsp;查询</i></label>
    								<input type="button" id="searchDomainID" class="hidden" style="float: right"  onclick="doDomain('task','search')"></input>
    								</div>
    								</div>
                              </th>
                          </tr>
                          <tr>
                              <th style="width:8px;"><input type="checkbox" id="checkboxes" /></th>
                              <th>序号</th>
                              <th class="hidden-phone">月份</th>
                              <th class="hidden-phone">任务名称</th>
                              <th class="hidden-phone">任务周期</th>
                              <th class="hidden-phone">任务描述</th>
                              <th class="hidden-phone">任务重要程度</th>
                              <th class="hidden-phone">责任部门</th>
                              <th class="hidden-phone">责任人</th>
                              <th class="hidden-phone">任务状态</th>
                              <th class="hidden-phone">开始时间</th>
                              <th class="hidden-phone">完成时间</th>
                              <th class="hidden-phone" width="9%" style="min-width: 80px;"><i class="icon-edit"></i> 操作 
                              </th>
                          </tr>
                          </thead>
                          <tbody >
                          <c:forEach  items="pageResult.rows" >
                          			<tr class="odd gradeX">
                              <td><input type="checkbox"  value="1" /></td>
                              <td>${id}</td>
                              <td class="hidden-phone">${month}</td>
                              <td class="hidden-phone">${name}</td>
                              <td class="hidden-phone">${taskcycle}</td>
                              <td class="hidden-phone">${describe}</td>
                              <td class="hidden-phone">${type}</td>
                              <td class="hidden-phone">${department}</td>
                              <td class="hidden-phone">${employee.name}</td>
                              <td class="hidden-phone">${state}</td>
                              <td class="hidden-phone">${starttime }</td>
                              <td class="hidden-phone">${endtime }</td>
                              
                              <td width="12%">
                                  	<label for="viewDomainID" class="btn btn-success btn-xs" title="查看" onclick="doDomain('task','input','${id}')"><i class="icon-file"></i></label>
    								<input type="button" id="viewDomainID" class="hidden"   ></input>
                                   <label for="inputDomainID" class="btn btn-primary btn-xs" title="编辑" onclick="doDomain('task','input','${id}')"><i class="icon-pencil"></i></label>
    								<input type="button" id="inputDomainID" class="hidden"   ></input>
                                   <label for="deleteDomainID" class="btn btn-danger btn-xs" title="删除" onclick="doDomain('task','delete','${id}')"><i class="icon-trash"></i></label>
    								<input type="button" id="deleteDomainID" class="hidden"></input>
                                  <label for="inputItemDomainID" class="btn btn-success btn-xs" title="增加子任务" onclick="doDomain('task','inputItem','${id}')"><i class="icon-plus"></i></label>
    								<input type="button" id="inputItemDomainID" class="hidden"></input>
                              </td>
                          </tr>
                          </c:forEach>
                          </tbody>
                          </table>
                      </section>
                  </div>
              </div>
              <!-- page end-->
              <page:htmlPage pageNo="${pageResult.currentPage}" url='task/list.action' totalSum="${pageResult.totalCount}" showPage="5" pageSize="${pageResult.pageSize}"/>
          </form>  
		<!-- Modal -->
  <div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>
   
	
	
    
  
  </body>
</html>