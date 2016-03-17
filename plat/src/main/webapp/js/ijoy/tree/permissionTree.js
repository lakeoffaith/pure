
/**
 * 加载所有的资源权限，
 * @param baseQuery  baseQuery中roleid必须为null;
 * @param $parent
 */
function loadAllTreeAjax(query,$parent){

    $.ajax({
        url:"menu?for=json",
        type:"get",
        data:query,
        dataType:"json",
        success:function(data){
            console.debug(data);

            if(data.success && data.results.length>0){
                //清空
                $parent.find("ul").remove();
                var ulstr="<ul class='sub-tree'>";
                $.each(data.results,function(e,v){

                    ulstr+="<li data-id="+ v.id+">";
                    if(v.childNum>0){
                      ulstr+="<span class='glyphicon glyphicon-plus'></span>"
                    };

                    ulstr+="<input type='checkbox'><span>"+ v.name+"</span></li>"
                });
                ulstr+="</ul>";

                $parent.append(ulstr);

                $parent.find("ul:eq(0)").addClass("active");

                //初始化点击。
                initCheckbox($parent);

            };
        }
    });
}

function loadTreeAjax(baseQuery,$parent){
    console.debug(baseQuery);
    loadAllTreeAjax({"parent_id":baseQuery.parent_id},$parent);
    console.debug(baseQuery);
    $.ajax({
        url:"menu?for=json",
        type:"get",
        data:baseQuery,
        dataType:"json",
        success:function(data){
            console.debug(data);

            if(data.success && data.results.length>0){
                console.log(data.results);

                $.each(data.results,function(e,v){
                    var id= v.id;

                  $parent.find("li[data-id="+id+"]").find("input[type=checkbox]").attr("checked",true);
                });


            };
        }
    });
}
/*
 选中li的checkbox，发送ul，li自带的id，去加载其子项，给本身添加active ,
 */
function openTree($checkbox){

    var $li=$checkbox.parents("li");
    $li.find("span.glyphicon").removeClass("glyphicon-plus");
    $li.find("span.glyphicon").addClass("glyphicon-minus");
    console.debug($li.find("ul"));
    if($li.find("ul").length>0){
        $li.find("ul").css("display","block");
    }else{
        var parent_id=$li.attr("data-id");
        var baseQuery={};
        baseQuery.parent_id=parent_id;
        baseQuery.roleid=$("input[name=id]").val();
        loadTreeAjax(baseQuery,$li);
    }


}

/*
    取消li的checkbox，则将子项ul移除，本身如果有active class,也需要移除
 */
function closeTree($checkbox){
    var $li=$checkbox.parents("li");
   /* $li.find("ul:eq(0)").remove();*/
    $li.find("ul").css("display","none");
    $li.find("span.glyphicon").removeClass("glyphicon-minus");
    $li.find("span.glyphicon").addClass("glyphicon-plus");


}

function initCheckbox($parent){
    $parent.find("ul").find("span.glyphicon").on("click",function(){
        console.log("------------------");
        console.debug($(this).hasClass("glyphicon-plus"));
        if($(this).hasClass("glyphicon-plus")){
            openTree($(this));
        }
        else{
            closeTree($(this));
        }


    });
}

function getTreeids($parent){
    var ids="";
    var id;
    $.each($parent.find("input[type=checkbox]:checked"),function(e,v){
       var $li= $(v).parents("li");
        id=$li.attr("data-id");
        ids+=id+",";
    });
    ids=ids.substr(0,ids.length-1);
    return ids;
}

