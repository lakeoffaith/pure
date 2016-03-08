<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
  	<base  href="<%=basePath %>">
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
    <link href="css/ijoy/modal/modal.css" />
    
    <script src="js/jquery.js"></script>
     <!-- domain.js for domain -->
     <script src="js/model/domain.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
     <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	

    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
    <script src="js/ijoy/select.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
     
  </head>

  <body>
      <div class="modal-dialog lg-modal" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="myModalLabel"><s:property value="task.name"/></h4>
          
        </div>
        
         
        <!-- //添加一个面板，里面有很多选项 -->
        <div class="modal-body">
         	<div class="panel panel-default">
         		<div class="panel-heading">
         			<h3 class="panel-title">添加新的子任务</h3>
         		</div>
         		<div class="panel-body">
     				<!-- 任务周期下拉 -->
     				
     				<!-- 隐藏的task_id -->
     				<input type="hidden" name="task_id" value="${task.id}">
     				
        		    <div class="form-group col-lg-2 col-md-2 col-sm-2" >
        		    	<label for="taskcycleSelect" class="control-label">任务周期</label>
        		    		<select class="form-control" id="itemCycle">
        		    			<option value="-1" selected="selected">--请选择--</option>
        		    			<option>1</option>
        		    			<option>2</option>
        		    			<option>3</option>
        		    			<option>4</option>
        		    		</select>
        		    </div>
        		    <!-- 任务描述填写 -->
        		    <div class="form-group col-lg-3 col-md-3 col-sm-3 " >
        		    	<label for="describe" class="control-label">任务描述</label>
        		    	<input type="text" class="form-control" id="itemdescribe" >
        		    </div>
        		    <!-- 重要程度 -->
        		    <div class="form-group col-lg-2 col-md-2 col-sm-2">
        		    	<label for="type" class="control-label">重要程度</label>
        		    	<select class="form-control" id="itemtype">
        		    			<option value="-1" selected="selected">--请选择--</option>
        		    			<option>1</option>
        		    			<option>2</option>
        		    			<option>3</option>
        		    			<option>4</option>
        		    	</select>
        		    </div>
        		      <!-- 责任部门 -->
        		    <div class="form-group col-lg-2 col-md-2 col-sm-2">
        		    	<label for="department" class="control-label">责任部门</label>
        		    	<input type="text" class="form-control" id="department">
        		    </div>
        		     <!-- 责任人 -->
        		    <div class="form-group col-lg-2 col-md-2 col-sm-2">
        		    	<label for="employee" class="control-label">责任人</label>
        		    	
        		    	<select  Class="form-control"   id="employeeid"  >
        		    			<option value="-1" selected="selected">--请选择--</option>
        		    			<c:forEach  items="${employees }"  var="e">
        		    				<option  data-id="${e.id }">${e.name }</option>
        		    			</c:forEach>
        		    	</select>
        		    </div>
        		    <div class="col-lg-1 col-md-1 col-sm-1" style="margin-top: 25px">
         			<input type="button" class="btn btn-info" id="saveItem" value="添加"></input>
         			</div>
         		</div>
         	</div>
           </div>
           
     	<!-- 子项目添加区 -->
     	<table class="table">
     		<thead>
     			<tr>
                              <th class="hidden-phone">任务周期</th>
                              <th class="hidden-phone">任务描述</th>
                              <th class="hidden-phone">任务重要程度</th>
                              <th class="hidden-phone">任务状态</th>
                              <th class="hidden-phone">责任部门</th>
                              <th class="hidden-phone">责任人</th>
                              <th class="hidden-phone" width="9%" style="min-width: 80px;"><i class="icon-edit"></i> 操作 
                              </th>
     			</tr>
     		</thead>
     		<tbody id="itemBody">
     			
     				<c:forEach  items="${task.taskItems }"   var="item">
     							<tr>		
                              <td class="hidden-phone">${item.itemCycle}</td>
                              <td class="hidden-phone">${item.itemdescribe }</td>
                              <td class="hidden-phone">${item.itemtype }</td>
                              <c:choose>
                              			<c:when test="${item.state==0 }">
                              				<td class="hidden-phone" background="gray">创建</td>
                              			</c:when>
                              			<c:when test="${item.state==1 }">
                              				<td class="hidden-phone" background="gray">认领</td>
                              			</c:when>
                              			<c:when test="${item.state==2 }">
                              				<td class="hidden-phone" background="gray">完成</td>
                              			</c:when>
                              			<c:otherwise>
                              			<td class="hidden-phone"><font style="color: red">关闭</font></td>
                              			</c:otherwise>
                              </c:choose>
                              <td class="hidden-phone">${item.department }</td>
                              <td class="hidden-phone">${item.employee.name }</td>
                              <td width="12%">
                                   <label class="btn btn-danger btn-xs" title="删除" onclick='deleteTaskItem(${item.id},this)'><i   class="icon-trash"></i></label>
                              </td>
                              </tr>
     				</c:forEach>
     		</tbody>
     		
     	</table>
     	<div align="right">
     		<button class="btn btn-info" style="margin-right: 25px;margin-bottom: 20px" data-dismiss="modal">关闭</button>
     	</div>
      </div>
    </div>
 
      <script type="text/javascript">
		
    	$(function(){
    		//主任务的id
			var taskid,itemCycle,itemtype,itemdescribe,department,employeeid;
    		
    		//声明jquery变量.
    		var taskid$=$("input[name='task_id']");
    		var itemCycle$=$("#itemCycle");
    		var itemType$=$("#itemtype");
    		var itemDescribe$=$("#itemdescribe");
    		var itemDepartment$=$("#department");
    		var employeeid$=$("#employeeid");
    		//页面加载从后台取出数据
    		$.ajax({
    			url:"taskItem",
    			data:{'taskItem.task_id':$("input[name='task_id']").val()},
    			type:'POST',
    			success:function(taskItems){
    				if(taskItems && typeof taskItems==='json' ){
    					$.each(taskItems,function(e,v){
    						//调用函数处理e
    						appendItem(e);
    					});
    				};
    			}
    		});
    		
    		$("#saveItem").on('click',function(){
    			
    			//准备数据
    			taskid=taskid$.val();    
        		itemCycle=itemCycle$.val();
        		itemType=itemType$.val();
        		itemDescribe=itemDescribe$.val();
        		itemDepartment=itemDepartment$.val();
        		employeeid=employeeid$.attr("data-id");
        		
        		
        		
        		
    			//传递数
    			var datajson={"task_id":taskid,"itemCycle":itemCycle,"itemtype":itemType,"itemdescribe":itemDescribe,
    					"department":itemDepartment,"employee.id":employeeid};
    			$.ajax({
    				url:"taskItem",
    				async:false,
    				type:'POST',
    				data:datajson,
    				dataType:'json',
    				success:function(data){
    					if(data.success){
    						appendItem(data.obj);
    						
    						//清空原有数据
    		        		taskid$.val("");
    		        		itemCycle$.val("-1");
    		        		itemType$.val("-1");
    		        		itemDescribe$.val("");
    		        		itemDepartment$.val("");
    		        		employeeid$.val("--请选择--");
    		        		employeeid$.attr("data-id","-1");
    					}else{
							alert(data.msg);
						}
    						
    						
    						
    			
    					
    				
    				}
    			});
    		});
    		
    		
    		
    		
    	});
    	
    	
    	//方法区：
    	function appendItem(taskItem){
    		   console.debug(taskItem);
    		   var stateVal="创建";
    		   switch (taskItem.state) {
			case 0:
				stateVal="创建";
				break;
			case 1:
				stateVal="认领";
				break;
			case 2:
				 stateVal="完成";
				 break;
			case 3:
					stateVal="关闭";
					break;
			}
				//添加数据到列表中
				var body="";
				body+="<tr><td>"+taskItem.itemCycle+"</td>";
				body+="<td>"+taskItem.itemdescribe+"</td>";
				body+="<td>"+taskItem.itemtype+"</td>";
				body+="<td>"+stateVal+"</td>";
				body+="<td>"+taskItem.department+"</td>";
				body+="<td>"+taskItem.employee.name+"</td>";
				//添加删除
				body+="<td><label  class='btn btn-danger btn-xs' title='删除' onclick='deleteTaskItem("+taskItem.id+",this)'><i class='icon-trash'></i></label>";
				body+="</td>";
				body+="</tr>";
				$("#itemBody").append(body);
    	}
    	
    	//点击删除，删除成功，从页面删除当前行
    	function deleteTaskItem(itemId,itemLable){
    		console.debug(itemId);
    		console.debug(itemLable);
    		$.ajax({
    			url:"taskItem/"+itemId+"?method=delete",
    			type:'get',
    			dataType:"json",
    			success:function(data){
    				  if( data.success){  
						//页面中移除 id为itemId的任务
						 $(itemLable).closest("tr").remove();
    				 }  
    			}
    		});
    	}
    </script>
  </body>
</html>