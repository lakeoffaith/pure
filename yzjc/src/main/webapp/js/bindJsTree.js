//以指定的Json数据，初始化JStree控件
//treeName为树div名称，url为数据源地址，checkbox为是否显示复选框，loadedfunction为加载完毕的回调函数
function bindJsTree(treeName,jsondata, url, checkbox, loadedfunction) {
    var control = $('#' + treeName)
    control.data('jstree', false);//清空数据，必须
    var isCheck = arguments[2] || false; //设置checkbox默认值为false
    if(isCheck) {
        //复选框树的初始化
    	$.getJSON(url,jsondata, function (data) {
            control.jstree({
            	"ui":{selected_parent_open:false},
                'plugins' : [ "checkbox" ], //出现选择框
                'checkbox': { cascade: "", three_state: true }, //不级联
                'core': {
                    'data': data,
                    "themes": {
                        "responsive": false
                    }
                }
            }).on('loaded.jstree',loadedfunction);
        });
    }
    else {
        //普通树列表的初始化
    	$.getJSON(url,{async:true}, function (data) {
            control.jstree({
                'core': {
                    'data': data,
                    "themes": {
                        "responsive": false
                    }
                }
            }).bind('loaded.jstree', loadedfunction);
        });        
    }
}