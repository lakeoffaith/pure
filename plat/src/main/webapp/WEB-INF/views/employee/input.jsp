<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword"
	content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
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
.lg-modal {
	width: 75%;
}
</style>

</head>
<body>
	<div class="modal-dialog  lg-modal" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">用户编辑</h4>
			</div>
			<div class="modal-body">
				<div class="container">
					<div class="row">
						<div
							style="background-color: red; padding-right: 20px; display: block"
							class="col-md-6">
							<form action="employee" id="domainFormID" class="form-horizontal"
								method="post">
								<!-- 保存所选的应用的序列 -->
								 <input type="hidden" name="applicationIds"  id="ItemStrInput">

								<c:if test="${employee.id !=null}">
									<div class="form-group hidden">
										<label class="col-sm-2  col-md-offset-1 control-label">序号</label>
										<div class="col-sm-4">
											<input class="form-control" name="id" readonly="true"
												value="${employee.id}">
										</div>
									</div>
								</c:if>
								<div class="form-group">
									<label class="col-sm-2  col-md-offset-1 control-label">登录账号</label>
									<div class="col-sm-4">
										<input type="text" class="form-control"
											value=${employee.name }>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2  col-md-offset-1 control-label">真实姓名</label>
									<div class="col-sm-4">
										<input class="form-control" name="realName"
											value="${employee.realName}">
									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2  col-md-offset-1 control-label">所属部门</label>
									<div class="col-sm-4">
										<input class="form-control" name="department"
											value="${employee.department}">
									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2  col-md-offset-1 control-label">所属角色</label>
									<div class="col-sm-4">
										<!--  <select  list="roles"  listKey="id"  listValue="name"  id="role_menu_select" name="role.id">  </select> -->
									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2  col-md-offset-1 control-label">电话：</label>
									<div class="col-sm-4">
										<input class="form-control" name="cellphone"
											value="${employee.cellphone}">
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-primary">确定保存</button>
									</div>
								</div>
							</form>
						</div>
						<div style="padding-left: 20px; display: block" class="col-md-6">
							<div class="row">
								<select id="notOwnApplicationSelectId"><option
										selected="selected">预约挂号</option>
									<option>院长决策</option></select>
								<button onclick="addItem()">增加应用</button>
							</div>
							<script type="text/javascript">
												
												
											       //将tbody里面的内容的id拼成,
													function freshAjaxItemStr(){
											    	     $td=$("#itemData").find("tbody tr");
											    	     var itemStr="";
											    	    $.each($td,function(e,v){
											    	    	id=$(v).find("td:eq(0)").attr("data-item_id");
											    	    	console.debug("-----------------------"+id);
											    	    	itemStr+=id+",";
											    	    });
											    	    itemStr=  itemStr.substring(0, itemStr.length-1);
											    	    console.debug(itemStr);
											    	    $("#ItemStrInput").val(itemStr);
											    	     
											       };
											       function addItem(){
											    	   id=$("#notOwnApplicationSelectId").find("option[selected=selected]").attr("data-id");
											    	   name=$("#notOwnApplicationSelectId").find("option[selected=selected]").html();
											    	   if(jsValidateIsNull(id) || jsValidateIsNull(name)){
											    		   alter("请先选择应用");
											    		   return;
											    	   };
											    	   str="<tr><td data-item_id="+id+">"+name+"</td><td><button onclick='deleteItem(this)'>删除</button></td></tr>";
											    	   $("#itemData").find("tbody").append(str);
											    	   $("#notOwnApplicationSelectId").find("option[selected=selected]").remove();
											    	 $firstOption= $("#notOwnApplicationSelectId").find("option:eq(0)");
											    	  if(jsValidateIsNull($firstOption)){
											    		  $("#notOwnApplicationSelectId").val("无剩余应用");	
											    	  }else {
											    		  $firstOption.attr("selected","selected");
													};
													//更新id 为itemStr 里的内容
										 			freshAjaxItemStr();
												};
													function deleteItem(item){
											 			$(item).parents("tr").remove();
											 			//更新id 为itemStr 里的内容
											 			freshAjaxItemStr();
											 		};
											</script>
							<div class="row" id="itemData">
								<table>
									<thead>
										<tr>
											<th>应用名称</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td data-item_id='2'>预约挂号</td>
											<td>
												<button onclick="deleteItem(this)">删除</button>
											</td>
										</tr>
										<tr>
											<td data-item_id='2'>预约挂号</td>
											<td>
												<button onclick="deleteItem(this)">删除</button>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
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
	<script type="text/javascript"
		src="assets/data-tables/jquery.dataTables.js"></script>
	<script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>


	<!--common script for all pages-->
	<script src="js/common-scripts.js"></script>
	<!--script for this page only-->
	<script src="js/dynamic-table.js"></script>
   <script src="js/ijoy/global.js"></script>
	<script type="text/javascript">
	
	
	
	
	function loadOwnApplication(employee_id,$table){
		var baseQuery={};
		baseQuery.employee_id=employee_id;
		baseQuery.pageSize=10;
		console.debug(baseQuery);
		$.ajax({
			url:"application?"+"for=json",
			type:"get",
			data:baseQuery,
			dataType:"json",
			success:function(data){
				if(data.success){
					$table.find("tbody").empty();
					str="";
					$.each(data.results,function(e,v){
						 str+="<tr><td data-item_id="+v.id+">"+v.name+"</td><td><button  onclick='deleteItem(this)'>删除</button></td></tr>";
					});
					$table.find("tbody").append(str);
				}
			}
		});
	};
	/* notOwnApplicationSelectId */
	function loadNotOwnApplication(employee_id){
		$select=$("#notOwnApplicationSelectId");
		var baseQuery={};
		baseQuery.notEmployee_id=employee_id;
		baseQuery.pageSize=20;
		console.debug(baseQuery);
		$.ajax({
			url:"application?"+"for=json",
			type:"get",
			data:baseQuery,
			dataType:"json",
			success:function(data){
				if(data.success){
					$select.empty();
					str="";
					$.each(data.results,function(e,v){
						 str+="<option data-id="+v.id+">"+v.name+"</option>";
					});
					$select.append(str);
					$select.find("option:eq(0)").attr("selected","selected");
				}
			}
		})
	};
	$(function(){
		//更新id 为itemStr 里的内容
			freshAjaxItemStr();
		var employee_id=$("input[name=id]").val();
		 //给notOwnApplicationSelectId加载选项
		 	loadNotOwnApplication(employee_id);
		   
		 //loadOwnApplicatio  加载用户已经拥有的应用
		 loadOwnApplication(employee_id,$("#itemData"));
		 
	});
	</script>
</body>
</html>