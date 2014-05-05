var functionGrid = null;// 功能表格
var functionForm = null;// 功能表单
var functionWin = null;// 功能窗口

// 增加功能的函数
function add_function() {
	formInit();
	functionWin = $.ligerDialog.open({
		width : 400,
		height : 200,
		title : '新增功能',
		target : functionForm,
		buttons : [ {
			text : '提交',
			width : 80,
			onclick : add_save
		}, {
			text : '取消',
			width : 80,
			onclick : add_cancel
		} ]
	});
}
// 增加功能的保存按钮事件
function add_save() {
	if (functionForm.valid()) {
		var row_data = Form.parseJSON(functionForm);
		
		// 发往服务器，返回成功后再添加到表格中
		$.ajax({
			url : '../../../system/addFunction.action',
			data : row_data,
			type : 'post',
			success : function(data) {
				if (data.success) {
					functionGrid.addRow(data.model);
					$.ligerDialog.tip({
						title : '提示信息',
						content : data.message
					});
					functionWin.close();
				} else {
					$.ligerDialog.error(data.message);
				}
			}
		});
	}
}
// 增加功能的取消按钮事件
function add_cancel() {
	functionWin.close();
}
// 修改功能的函数
function edit_function() {
	formInit();
	if (!functionGrid.getSelected()) {
		$.ligerDialog.warn('请选择您要修改的行.');
		return;
	}
	Form.loadForm(functionForm, functionGrid.getSelected());
	functionWin = $.ligerDialog.open({
		width : 400,
		height : 200,
		title : '编辑功能',
		target : functionForm,
		buttons : [ {
			text : '提交',
			width : 80,
			onclick : edit_save
		}, {
			text : '取消',
			width : 80,
			onclick : edit_cancel
		} ]
	});
}
// 修改功能的保存按钮事件
function edit_save() {
	if (functionForm.valid()) {
		var row_data = Form.parseJSON(functionForm);
		// todo 需要发往服务器，返回成功后再修改到表格中
		$
				.ajax({
					url : '../../../system/updateFunction.action',
					data : row_data,
					type : 'post',
					success : function(data) {
						if (data.success) {
							functionGrid.update(functionGrid.getSelected(),
									data.model);
							$.ligerDialog.tip({
								title : '提示信息',
								content : data.message
							});
							functionWin.close();
						} else {
							$.ligerDialog.error(data.message);
						}
					}
				});
	}
}
// 修改功能的取消按钮事件
function edit_cancel() {
	functionWin.close();
}

// 删除功能的函数
function delete_function() {
	if (!functionGrid.getSelected()) {
		$.ligerDialog.warn('请选择您要删除的行.');
		return;
	}
	var row_data = functionGrid.getSelected();
	$.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除功能', function(r) {
		if (r) {
			$.ajax({
				url : '../../../system/deleteFunction.action',
				data : row_data,
				type : 'post',
				success : function(data) {
					if (data.success) {
						$.ligerDialog.tip({
							title : '提示信息',
							content : data.message
						});
						functionGrid.deleteSelectedRow();
						parameterWin.close();
					} else {
						$.ligerDialog.error(data.message);
					}
				}
			});
		}
	});
}
// 初始化表单，生成form标签
function formInit() {
	functionForm = $('<form></form>');
	functionForm.ligerForm({
		inputWidth : 280,
		fields : [ {
			name : 'id',
			type : "hidden"
		}, {
			display : '功能名称简写',
			name : 'name',
			type : 'text',
			space : 30,
			labelWidth : 100,
			width : 220,
			newline : true,
			validate : {
				required : true,
				maxlength : 50
			}
		}, {
			display : '功能名称',
			name : 'remark',
			type : 'text',
			space : 30,
			labelWidth : 100,
			width : 220,
			newline : true,
			validate : {
				required : true,
				maxlength : 50
			}
		} ]
	});
	$.metadata.setType("attr", "validate");
	functionForm.validate({
		debug : true,
		onkeyup : false,
		errorPlacement : function(error,element) {
            error.appendTo(element.parent().parent().parent().parent());
		}
	});
}
// 初始化表格
$(function() {
	var toolbarItems = [ {
		text : '新增功能',
		click : add_function,
		icon : 'add',
		key : 'add'
	}, {
		text : '修改功能',
		click : edit_function,
		icon : 'modify',
		key : 'modify'
	}, {
		text : '删除功能',
		click : delete_function,
		icon : 'delete',
		key : 'delete'
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
		url : '../../../system/listFunction.action',
		type : 'post',
		success : function(data) {
			functionGrid = $('#functionGrid').ligerGrid({
				columns : [
				// { display:'ID', name:'id', align:'left', width:100 },
				{
					display : '功能名称简写',
					name : 'name',
					width : 200
				}, {
					display : '功能名称',
					name : 'remark',
					align : 'left',
					width : 400
				} ],
				width : '99%',
				height : '98%',
                usePager:false,
				data : data.functionList,
				toolbar : {
					items : toolbarItems
				}
			});
			$("#pageloading").hide();
		}
	});
});