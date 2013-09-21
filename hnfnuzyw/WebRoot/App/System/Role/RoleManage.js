var roleGrid = null;// 功能表格
var roleForm = null;// 功能表单
var roleWin = null;// 功能窗口
var joinTree = null;// 树
var treeManager = null;// 树的管理器

// 增加功能的函数
function add_role() {
	formInit();
	roleWin = $.ligerDialog.open({
		width : 400,
		height : 200,
		title : '新增功能',
		target : roleForm,
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
	if (roleForm.valid()) {
		if (roleForm.valid()) {
			var row_data = Form.parseJSON(roleForm);
			$.ajax({
				url : '../../../system/addRole.action',
				data : row_data,
				type : 'post',
				success : function(data) {
					if (data.success) {
						roleGrid.addRow(data.model);
						$.ligerDialog.tip({
							title : '提示信息',
							content : data.message
						});
						roleWin.close();
					} else {
						$.ligerDialog.error(data.message);
					}
				}
			});
		}
	}
}
// 增加功能的取消按钮事件
function add_cancel() {
	roleWin.close();
}
// 修改功能的函数
function edit_role() {
	formInit();
	if (!roleGrid.getSelected()) {
		$.ligerDialog.warn('请选择您要修改的行.');
		return;
	}
	Form.loadForm(roleForm, roleGrid.getSelected());
	roleWin = $.ligerDialog.open({
		width : 400,
		height : 200,
		title : '编辑功能',
		target : roleForm,
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
	if (roleForm.valid()) {
		if (roleForm.valid()) {
			var row_data = Form.parseJSON(roleForm);
			$.ajax({
				url : '../../../system/updateRole.action',
				data : row_data,
				type : 'post',
				success : function(data) {
					if (data.success) {
						roleGrid.update(roleGrid.getSelected(), data.model);
						$.ligerDialog.tip({
							title : '提示信息',
							content : data.message
						});
						roleWin.close();
					} else {
						$.ligerDialog.error(data.message);
					}
				}
			});
		}
	}
}
// 修改功能的取消按钮事件
function edit_cancel() {
	roleWin.close();
}
// 删除功能的函数
function delete_role() {
	if (!roleGrid.getSelected()) {
		$.ligerDialog.warn('请选择您要删除的行.');
		return;
	}
	var row_data = roleGrid.getSelected();
	$.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除角色', function(r) {
		if (r) {
			$.ajax({
				url : '../../../system/deleteRole.action',
				data : {
					id : row_data.id
				},
				type : 'post',
				success : function(data) {
					if (data.success) {
						$.ligerDialog.tip({
							title : '提示信息',
							content : data.message
						});
						roleGrid.deleteSelectedRow();
						roleWin.close();
					} else {
						$.ligerDialog.error(data.message);
					}
				}
			});
		}
	});
}
// 角色和菜单挂接的方法
function role_menu_join() {
	if (!roleGrid.getSelected()) {
		$.ligerDialog.warn('请选择您要赋予权限的角色.');
		return;
	}
	var role = roleGrid.getSelected();

	$.ajax({
		url : '../../../system/joinTree.action',
		data : {
			roleId : role.id
		},
		type : 'post',
		success : function(data) {
			if (data.success) {
				joinTree = $('<ul></ul>');
				joinTree.ligerTree({
					idFieldName : 'id',
					textFieldName : 'name',
					parentIDFieldName : 'pid',
					data : data.joinTree

				});
				treeManager = joinTree.ligerGetTreeManager();
				roleWin = $.ligerDialog.open({
					width : 400,
					height : 400,
					title : '权限赋予',
					target : joinTree,
					buttons : [ {
						text : '提交',
						width : 80,
						onclick : join_save
					}, {
						text : '取消',
						width : 80,
						onclick : join_cancel
					} ]
				});
			} else {
				$.ligerDialog.error(data.message);
			}
		}
	});
}
function join_save() {
    $.ligerDialog.confirm('挂接成功后将会刷新页面，请保存好其他页面的工作？', '挂接', function(r) {
        if (r) {
            var role = roleGrid.getSelected();
            var checked = treeManager.getChecked();
            var len = checked.length;
            var row_data = role.id + "";

            var temp = -1;
            for ( var i = 0; i < len; i++) {
                if (checked[i].data.pid === undefined) {
                    continue;
                }
                if (checked[i].data.pid == temp) {
                    row_data += ";";
                    row_data += checked[i].data.id;
                } else {
                    temp = checked[i].data.pid;
                    row_data += ":";
                    row_data += temp;
                    row_data += ",";
                    row_data += checked[i].data.id;
                }
            }
            $.ajax({
                url : '../../../system/addRoleMenuJoins.action',
                data : {
                    joinIds : row_data
                },
                type : 'post',
                success : function(data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title : '提示信息',
                            content : data.message
                        });
                        roleWin.close();
                        window.parent.window.location.reload();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}
function join_cancel() {
	roleWin.close();
}
// 初始化表单，生成form标签
function formInit() {
	roleForm = $('<form></form>');
	roleForm.ligerForm({
		inputWidth : 280,
		fields : [ {
			name : 'id',
			type : 'hidden'
		}, {
			display : '角色名称',
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
			display : '备注',
			name : 'remark',
			type : 'text',
			space : 30,
			labelWidth : 100,
			width : 220,
			newline : true
		} ]
	});
	$.metadata.setType("attr", "validate");
	roleForm.validate({
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
		text : '新增角色',
		click : add_role,
		icon : 'add',
		key : 'add'
	}, {
		text : '修改角色',
		click : edit_role,
		icon : 'modify',
		key : 'modify'
	}, {
		text : '删除角色',
		click : delete_role,
		icon : 'delete',
		key : 'delete'
	}, {
		line : true
	}, {
		text : '权限赋予',
		click : role_menu_join,
		icon : 'config',
		key : 'join'
	} ];
    var menuId = window.parent.tab.getSelectedTabItemID();
    $.ajax({
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
		url : '../../../system/listRole.action',
		type : 'post',
		success : function(data) {
			roleGrid = $('#roleGrid').ligerGrid({
				columns : [
				// { display:'ID', name:'id', align:'left', width:100 },
				{
					display : '角色名称',
					name : 'name',
					width : 200
				},
				// todo 注意这里是createUser，后台需要处理好user的名字后再显示到前台
				{
					name : 'createUserId',
					hide : true
				}, {
					display : '创建用户',
					name : 'createUserName',
					width : 200
				}, {
					display : '备注',
					name : 'remark',
					align : 'left',
					width : 400
				} ],
				width : '99%',
				height : '98%',
                usePager:false,
				data : data.roleList,
				toolbar : {
					items : toolbarItems
				}
			});
			$("#pageloading").hide();
		}
	});
	$("#pageloading").hide();
});