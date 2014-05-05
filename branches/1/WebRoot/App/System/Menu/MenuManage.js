var grid = null;
var menuForm = null;
var menuFormWin = null;
// 按钮的click事件
function update_menu(item) {
	$.ligerDialog.alert(item.text);
}
// 增加菜单的函数
function add_menu() {

	formInit();

	menuFormWin = $.ligerDialog.open({
		width : 400,
		height : 400,
		title : "新增菜单",
		target : menuForm,
		buttons : [ {
			text : "提交",
			width : 80,
			onclick : add_save
		}, {
			text : "取消",
			width : 80,
			onclick : add_cancel
		} ]
	});
}
// 增加菜单的保存按钮事件
function add_save() {
	// 把表单转化为数组
	if (menuForm.valid()) {
		var row_data = Form.parseJSON(menuForm);
//		console.log(row_data);
		// 发往服务器，返回成功后再添加到表格中
		$.ajax({
			url : '../../../system/addMenu.action',
			data : row_data,
			type : 'post',
			success : function(data) {
//				console.log(data);
				if (data.success) {
					refresh_menu();
					$.ligerDialog.tip({
						title : '提示信息',
						content : data.message
					});
					menuFormWin.close();
				} else {
					$.ligerDialog.error(data.message);
				}
			}
		});
	}
}
// 增加菜单的取消按钮事件
function add_cancel() {
	menuFormWin.close();
}

//刷新菜单的函数
function refresh_menu() {
    $.ajax( {
        url : '../../../system/listMenu.action',
        type : 'post',
        success : function(data) {
        	grid.loadData(data.menuList);
        }
    });
    $("#pageloading").hide();

}


// 删除菜单的函数
function delete_menu() {
	if (!grid.getSelected()) {
		$.ligerDialog.warn("请选择您要删除的行！");
		return;
	}
	var row_data = grid.getSelected();
	$.ligerDialog.confirm('确认删除' + row_data.name + '?', '删除功能', function(r) {
		if (r) {
			// todo 进行ajax操作，成功后在回调函数里删除选择的行
			$.ajax({
				url : '../../../system/deleteMenu.action',
				data : row_data,
				type : 'post',
				success : function(data) {
					if (data.success) {
						$.ligerDialog.tip({title:'提示信息', content:data.message});
						refresh_menu();
						menuFormWin.close();
					}else{
						 $.ligerDialog.error(data.message);
					}
				}
			})
		}
	});

}

// 修改菜单的函数
function edit_menu() {
	formInit();
	if (!grid.getSelected()) {
		$.ligerDialog.warn("请选择您要修改的行！");
		return;
	}
	// 这个函数的参数为：form，data，作用就是把data放到from
    var gridData = grid.getSelected();
	Form.loadForm(menuForm, gridData);
    menuFormWin = $.ligerDialog.open({
		width : 400,
		height : 400,
		title : "修改菜单",
		target : menuForm,
		buttons : [ {
			text : "提交",
			width : 80,
			onclick : edit_save
		}, {
			text : "取消",
			width : 80,
			onclick : edit_cancel
		} ]
	});
}
function edit_save() {

	if (menuForm.valid()) {
		var row_data = Form.parseJSON(menuForm);
		// 发往服务器，返回成功后再修改到表格中
		$.ajax({
			url : '../../../system/updateMenu.action',
			data : row_data,
			type : 'post',
			success : function(data) {
//				console.log(data);
				if (data.success) {
					refresh_menu();
					$.ligerDialog.tip({title:'提示信息', content:data.message});
					menuFormWin.close();
				}else{
					$.ligerDialog.error(data.message);
				}
			}
		});
	}
}
function edit_cancel() {
	menuFormWin.close();
}
// 初始化表单，生成form标签
function formInit() {
	var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
	menuForm = $('<form></form>');

	$.ajax({
		url : '../../../system/listFunAndMenu.action',
		type : 'post',
        async:false,
		success : function(data) {
			menuForm.ligerForm({
				inputWidth : 200,
				labelWidth : 90,
				space : 40,
				fields : [ {
					name : "id",
					type : "hidden"
				}, {
					display : "菜单名字",
					name : "name",
					newline : true,
					type : "text",
					group : "必填信息",
					groupicon : groupicon,
					validate:{
	                	required: true,
	                    maxlength:30
	                }
					
				}, {
					display : "菜单链接",
					name : "url",
					newline : true,
					type : "text",
					validate:{
	                    maxlength:50
	                }
				}, {
					display : "功能列表",
					name : "functionIdList",
					type : "select",
					comboboxName : "functionId",
					options : {
						textField : "remark",
						valueField : "id",
						hideOnLoseFocus:true,
						isMultiSelect : true,
						isShowCheckBox : true,
						valueFieldID : "functionIdList",
						data : data.functionList
					},
					validate:{
	                    maxlength:100
	                }
				}, {
					display : "图标链接",
					name : "icon",
					type : "text",
					group : "可选信息",
					groupicon : groupicon,
					validate:{
	                    maxlength:100
	                }
				}, {
					//todo 这个最后要搞成下拉框的形式，从后台取数据
					display : "上级菜单",
					name : "parentId",
					type : "select",
					comboboxName : "parentIdList",
					options : {
						textField : "name",
						valueField : "id",
						hideOnLoseFocus:true,
						valueFieldID : "parentId",
						data : data.menus
					}
				} ]
			});
			$.metadata.setType("attr", "validate");
			menuForm.validate({
		        debug:true,
		        onkeyup:false,
		        errorPlacement:function (error,element) {
                    error.appendTo(element.parent().parent().parent().parent());
		        }
		    });

		}
	});
}

// 页面加载完成后就开始调用
$(function() {

	var toolbarItems = [ {
		text : '增加',
		click : add_menu,
		icon : 'add',
		key : 'add'
	}, {
		line : true
	}, {
		text : '删除',
		click : delete_menu,
		icon : 'delete',
		key : 'delete'
	}, {
		line : true
	}, {
		text : '修改',
		click : edit_menu,
		icon : 'modify',
		key : 'modify'
	}, {
		line : true
	} ];

    var menuId = window.parent.tab.getSelectedTabItemID();
    $.ajax({
        async: false,
        url : '../../../system/listFunctionIdList.action',
        type : 'post',
        data : {
            menuId : menuId.substr(0,menuId.indexOf("t"))
        },
        success : function(data) {
            var idList = data.functionIdList.split(";");
            var ajaxToolbar = [];
            for(var i = 0; i<idList.length; i++){
                ajaxToolbar.push({name:parent.hnfnu.functionList[idList[i]]});
            }
            toolbarItems = Toolbar.confirmToolbar(toolbarItems, ajaxToolbar);
        }
    });

	$.ajax({
		url : '../../../system/listMenu.action',
		type : 'post',
		success : function(data) {
			grid = $("#menuGrid").ligerGrid({
				columns : [ {
					display : '菜单名字',
					name : 'name',
					align : 'left',
					minWidth : 80
				}, {
					display : '菜单链接',
					name : 'url',
					align : 'left',
					minWidth : 120
				}, {
					display : '功能列表',
					name : 'functionIdList',
					align : 'left',
					minWidth : 100
				}, {
					display : '图标链接',
					name : 'icon',
					align : 'left',
					minWidth : 120
				}],
				data : data.menuList,
				height : '98%',
				width : '100%',
                pageSize : 20,
                groupColumnName:'parentName',
                groupColumnDisplay:'一级菜单',
				toolbar : {
					items : toolbarItems
				}
			});
		}
	});
	$("#pageloading").hide();
});