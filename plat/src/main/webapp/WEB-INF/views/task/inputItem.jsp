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
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="img/favicon.html">

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
    <script src="<%=path%>/js/jquery.js"></script>
     <!-- domain.js for domain -->
     <script src="<%=path%>/js/model/domain.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    
     <script src="<%=path%>/js/jquery.scrollTo.min.js"></script>
    <script src="<%=path%>/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="<%=path%>/js/common-scripts.js"></script>
    
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
        		    	<s:select  cssClass="form-control" list="employees" id="employeeid" headerKey="-1" headerValue="--请选择--" listKey="id" listValue="name">
        		    	</s:select>
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
     			
     				
     				<s:iterator value="task.taskItems" var="item"> 
     					<tr>		
                              <td class="hidden-phone"><s:property value="#item.itemCycle"/></td>
                              <td class="hidden-phone"><s:property value="#item.itemdescribe"/></td>
                              <td class="hidden-phone"><s:property value="#item.itemtype"/></td>
                              <s:if test="item.state==0">
                              		<td class="hidden-phone" background="gray">创建</td>
                              </s:if>
                              <s:elseif test="item.state==1">
                              		<td class="hidden-phone" background="blue">认领</td>
                              </s:elseif>
                              <s:elseif test="item.state==2">
                              		<td class="hidden-phone" background="green">完成</td>
                              </s:elseif>
                              <s:else>
                              		<td class="hidden-phone"><font style="color: red">关闭</font></td>
                              </s:else>
                              <td class="hidden-phone"><s:property value="#item.department"/></td>
                              <td class="hidden-phone"><s:property value="#item.employee.name"/></td>
                              <td width="12%">
                                   <label class="btn btn-danger btn-xs" title="删除" onclick='deleteTaskItem(<s:property value="#item.id"/>,this)'><i class="icon-trash"></i></label>
                              </td>
                              </tr>
               </s:iterator>
     			
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
    			url:pathjs+"taskItem/list.action",
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
        		employeeid=employeeid$.val();
        		
        		
        		
        		
    			//传递数据
    			var datajson={'taskItem.task_id':taskid,'taskItem.itemCycle':itemCycle,'taskItem.itemtype':itemType,'taskItem.itemdescribe':itemDescribe,
    					'taskItem.department':itemDepartment,'taskItem.employee.id':employeeid,'taskItem.task_id':taskid};
    			$.ajax({
    				url:pathjs+"taskItem/saveItem.action",
    				asyn:true,
    				type:'POST',
    				data:datajson,
    				dataType:'json',
    				success:function(taskItem){
    					
    						appendItem(taskItem);
    						
    						
    						//清空原有数据
    		        		taskid$.val("");
    		        		itemCycle$.val("-1");
    		        		itemType$.val("-1");
    		        		itemDescribe$.val("");
    		        		itemDepartment$.val("");
    		        		employeeid$.val("-1");
    					
    				
    				}
    			});
    		});
    		
    		
    		
    		
    	});
    	
    	
    	
    	//方法区：
    	function appendItem(taskItem){
    		   console.debug(taskItem);
				//添加数据到列表中
				var body="";
				body+="<tr><td>"+taskItem.itemCycle+"</td>";
				body+="<td>"+taskItem.itemdescribe+"</td>";
				body+="<td>"+taskItem.itemtype+"</td>";
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
    			url:pathjs+"taskItem/deleteItem.action",
    			data:{'taskItem.id':itemId},
    			type:'POST',
    			dataType:"json",
    			success:function(data){
    				  if(data && data.success){  
						//页面中移除 id为itemId的任务
						 $(itemLable).closest("tr").remove();
    				 }  
    			}
    		});
    	}
    </script>
  </body>
</html>