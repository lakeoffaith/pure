$(function(){
	
	/**
	 * 对与select控件，点击后，设置select 标签中的data-id的属性为所选中的值。默认为请选中状态，data-id为-1；
	 */
	$("select").change(function(){
		var $select=$(this);
		var selectVar=$select.val();
		$select.find("option[selected=selected]").attr("selected",null);
		$.each($select.find("option"),function(e,v){
			if($(v).html()==selectVar){
				$(v).attr("selected","selected");
				$select.attr("data-id",$(v).attr("data-id"));
			};
		});
	});
	
});