<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
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
    <link rel="stylesheet" href="assets/dist/themes/default/style.min.css" />
    <script src="js/jquery.js"></script>
    
     <!-- domain.js for domain -->
     <script src="js/model/domain.js"></script>
     <script src="assets/dist/jstree.min.js"></script>
    <script src="js/bindJsTree.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
     <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
    

</head>

<body>
	  <!-- page start-->
              <div class="row" style="width: 100%;padding: 0px; ">
                  <ul class="breadcrumb">
                      <li><a href='javascript:window.top.location="index.action";document.body.innerHTML="";'><i class="icon-home"></i> 首页</a></li>
                      <li class="active">权限管理</li>
                  </ul>
                  <div class="col-lg-12 col-md-12 col-sm-12" style="margin: 0px 15px 0px">
                      <section class="panel">
                          <header class="panel-heading">
                           权限配置
                          </header>
                          <div class="panel-body panel-body-n" >
                          <select list="roles" cssClass="form-control" cssStyle="width:150px" listKey="id" listValue="name" id="role_menu_select" >
                          </select>
                 		<div id="jstree_div"></div>
   					    </div>
   						<div class="panel-body panel-body-n">
                              <button type="button" class="btn btn-success" id="role_menu_save"><i class=" icon-save"></i>&nbsp;保存</button>
                      </div>
                      </section>
                      </div>
                      </div>
                      
                      
   <script>
   
   //初始化
   $(function(){
	   //1：定义jquery变量
	   var role_menu_select=$("#role_menu_select");
	   var role_menu_save=$("#role_menu_save");
	   
	   //2:常用参数
	   
	  var jsondata;
	   //3:初始化控件事件
	   $("#role_menu_select").on('change',function(){
		   jsondata={roleid:role_menu_select.val(),async:false};
		    initDeptTreeview(jsondata); 
		  
	   });
	   $("#role_menu_save").on('click',function(){
		   jsondata={roleid:role_menu_select.val()};
		   var ouList = $('#jstree_div').jstree('get_selected');
		   var halfList="";
		   $('#jstree_div').find(".jstree-undetermined").each(function(){
			   console.debug(this);
			   halfList=halfList+$(this).closest(".jstree-node").attr("id")+",";
			   console.debug(halfList);
		   });
		   //save 需要防止重复提交  
		    var tokendata=$("input[name='token']").val();
		   var jsondata = { roleid:role_menu_select.val(), ouList: halfList+ouList.join(','),token:tokendata,'struts.token.name':'token'};
		   saveMenuData(jsondata); 
		  
	   });
	   
	   //4:调用方法
	   jsondata={roleid:role_menu_select.val()};
	   initDeptTreeview(jsondata);
	   
   });
   function initDeptTreeview(jsondata) {
       var treeUrl = 'permission/load';
       bindJsTree("jstree_div",jsondata,treeUrl,true);
   
   };
   function saveMenuData(jsondata) {
       var url = 'permission/save';
       $.post(url, jsondata, function (json) {
           if(json.success){
        	   alert(json.message);
           }
       }).error(function () {
           showTips("您未被授权使用该功能，请联系管理员进行处理。");
       });
   }
  
   </script>
   
</body>

</html>
