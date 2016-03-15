

function doModelDomain(domainName,method){
	doModelDomain(domainName,method,null);
}
/*type可以为*/
function doModelDomain(domainName,method, id){
	
	
	
	var url=domainName;
	url=id==null?url:url+"/"+id;
	url=method==null?url:url+"?method="+method;
	
	if(method=='delete'){
		console.debug(url);
		$.ajax({
			url:url,
			type:"get",
			async:false,
			dataType:"json",
			success:function(data){
				console.debug(data);
				if(data.success){
				 location.href=domainName;
				}
			}
		});
		return;
	}else if(method=='batchDelete'){
		var checkChilds=$("#checkboxes").parents("table").find("tbody").find("input[type='checkbox']:checked");
		//如果没有选中
		if(checkChilds.length==0){
			alert("请选中再删除");
			return;
		}
		//定义数组
		var ids=[];
		$.each(checkChilds,function(i,e){
			ids.push($(e).parent().next("td").text());
		});
		var jsondata= {ids:ids.join(','),};
		$.ajax({
			type:"get",
			url:url,
			async:false,
			data:jsondata,
			dataType:"json",
			success:function(data){
				if(data.success){
					location.href=domainName;
				}
			}
		});
		return;
	}else if(method=='search'){
		$("#domainForm").submit();
		return;
	}else{
		  $('#myModal').removeData('bs.modal');
	      $('#myModal').modal({remote: url});
	      $('#myModal').modal('show');
	}
	
	

	
	/*	var url=domainName;
		if(id!=null){
			url+="/"+id;
		}
	    var jsonData={"method":method,"returnType":returnType};
	    var resultData;
	    if(returnType=='json'){
	    	   $.ajax({
	   	    	url:url,
	   	    	type:"get",
	   	    	dataType:"json",
	   	    	async:false,
	   	    	data:jsonData,
	   	    	success:function(data){
	   	    		if(data.success){
	   	    			resultData=data.obj;
	   	    		}
	   	    	}
	   	    });
	    }
	 return resultData;*/
	/*var url=domainName+"/"+id;
	//为删除的时候 ,删除之后才能进行其余操作
	if(type=='delete'){
		
		var jsondata=id==null?{async:false}:{id:id,async:false};
		$.post(url,jsondata,function(data){
			if(data instanceof Object){
				console.debug(data);
				if(data.success){
					alert(data.message);
				}else{
					alert(data.message);
				}
			}
		},"json");
		$("#domainForm").submit();
	}else if(type=="search"){
		$("#domainForm").submit();
	}else{
		//为新增，和修改的时候
		location.href=url+"?id="+id;
			  $('#myModal').removeData('bs.modal');
		        $('#myModal').modal({remote: url+"?type="+type });
		        $('#myModal').modal('show');
	}*/
}
//批量删除
//加载完成后绑定事件
$(function(){
	//checkbox事件处理
	$("#checkboxes").on('click',function(){
		var flag=this.checked;
		//查找#pageResultRows 下面的checkbox
		var childs=$("#checkboxes").parents("table").find("tbody").find(":checkbox");
		$.each(childs,function(i,e){
			e.checked=flag;
		});
	});	
});

	
		

//分页js
//1:定义变量
//2:加载完后初始化   
   //初始化页面page下拉控件
   $(function(){
	   var $pageSelect=$("#pageSelect");
	   $pageSelect.width('40px');
   	//获得初始的每页数据条数
   	var pageSize=$("input[name='pageSize']").val();
   	//将baseQuery.pageSize的值给select;
   	$.each($pageSelect.find("option"),function(e,v){
   		console.debug("--------");
   		console.debug($(v).html());
   		console.debug(pageSize);
   		if($(v).html()==pageSize){
   			$(v).attr("selected","selected");
   			return;
   		}
   	});
   	$pageSelect.change(function () {goPage(0,$(this).val());});
   	
       
   });
   
   
   //3:方法
   function goPage(currentPage,pageSize){
		if(currentPage!=0){
		$("input[name='currentPage']").val(currentPage);
		}
		if(pageSize!=0){
			$("input[name='currentPage']").val(1);
			$("input[name='pageSize']").val(pageSize);
		}
		$("#domainForm").submit();
	}
