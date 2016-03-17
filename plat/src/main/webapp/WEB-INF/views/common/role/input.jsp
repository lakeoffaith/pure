<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  	<base  href="<%=basePath%>">
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

    <link href="css/ijoy/tree/permissionTree.css" rel="stylesheet"/>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>

    <![endif]-->
  </head>

  <body>
     <div class="modal-dialog lg-modal"  role="document">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="myModalLabel">角色编辑</h4>
        </div>
        <div class="modal-body">
        <div  class="container">
            <div class="row">
                <div class="col-md-6 "  >
                        <form action="role" class="form-horizontal" id="domainFormID" method="post">
                        <!-- //表单令牌 -->
                        <!-- <s:token></s:token> -->
                        <c:if test="${role.id!=null }">
                            <div class="form-group hidden"  >

                            <label  class="col-sm-2  col-md-offset-1 control-label">序号</label>
                            <div class="col-sm-4">
                            <input  class="form-control"  name="id"  readonly="true"  value="${role.id}">
                            </div>
                            </div>
                        </c:if>
                        <div class="form-group">
                        <label  class="col-sm-2  col-md-offset-1 control-label">角色名称</label>
                        <div class="col-sm-4">
                        <input  class="form-control" name="name"  value="${role.name}">
                        </div>
                        </div>
                        <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                         <button id="saveBtn" class="btn btn-primary">确定保存</button>
                        </div>
                        </div>
    <input id="treeids" name="ids">
                        </form>


                </div>
                <div  class="col-md-6">

                        <lable>用户权限配置</lable>
                        <div class="tree">

                        </div>

                </div>
            </div>

        </div>


           </div>
      </div>
    </div>
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
    <script src="js/ijoy/global.js"></script>
    <script src="js/ijoy/tree/permissionTree.js"></script>

    <script type="text/javascript">
        //点击保存按钮时，先获得所选的权限，再提交表单
        function inputTreeids(){
            var ids=getTreeids($(".tree"));
    console.debug("ids     "+ids);

    $("#treeids").val(ids);



        }
        //根据角色id加载menu
        $(function(){
            var id=$("input[name=id]").val();
            if(!jsValidateIsNull(id) && !jsValidateIsNull($(".tree"))){
                var baseQuery={};
                baseQuery.roleid=id;

                loadTreeAjax(baseQuery,$(".tree"));
             };

            $("#saveBtn").on("click",function(){

            inputTreeids();

    });

    });
    </script>
   
  </body>
</html>