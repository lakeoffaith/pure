<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta content="utf-8">
	<link rel="stylesheet" href="<%=path %>/assets/dist/themes/default/style.min.css" />
</head>
<body>
	 <div id="jstree">
    <!-- in this example the tree is populated from inline HTML -->
    <ul>
      <li>Root node 1
        <ul>
          <li id="child_node_1">Child node 1</li>
          <li>Child node 2</li>
        </ul>
      </li>
      <li>Root node 2</li>
    </ul>
  </div>
  <button>demo button</button>
	<script src="<%=path %>/js/jquery.js"></script>
	<script src="<%=path %>/assets/dist/jstree.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#jstree").jstree();
			$('#jstree').on("changed.jstree", function (e, data) {
			      console.log(data.selected);
			    });
			
			$('button').on('click', function () {
			      $('#jstree').jstree(true).select_node('child_node_1');
			      $('#jstree').jstree('select_node', 'child_node_1');
			      $.jstree.reference('#jstree').select_node('child_node_1');
			    });
		});
	</script>
</body>
</html>