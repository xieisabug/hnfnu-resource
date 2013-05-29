var userGrid = null;// 用户表格
var userForm = null;// 用户表单
var userWin = null;// 用户窗口
var listBox = null;// 用户角色列表
var userRoleJoinWin = null;// 用户赋予角色窗口

// 用户赋予角色listBox的初始化
function listBoxInit() {
	listBox = $('<div style="margin:4px;float:left;"><div id="listbox1"></div></div>'
			+ '<div style="margin:4px;float:left;" class="middle">'
			+ '<input type="button" onclick="moveToLeft()" value="<" />'
			+ '<input type="button" onclick="moveToRight()" value=">" />'
			+ '<input type="button" onclick="moveAllToLeft()" value="<<" /> '
			+ '<input type="button" onclick="moveAllToRight()" value=">>" /> </div>'
			+ '<div style="margin:4px;float:left;"><div id="listbox2"></div></div>');
	listBox.find("#listbox1,#listbox2").ligerListBox({
		textField:'name',
		valueField:'id',
		isShowCheckBox : true,
		isMultiSelect : true,
		height : 500,
		width : 250
	});

}

// 把左边的角色拉进右边的函数
function moveToLeft() {
	var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
	var selecteds = box2.getSelectedItems();
	if (!selecteds || !selecteds.length)
		return;
	box2.removeItems(selecteds);
	box1.addItems(selecteds);
}
// 把右边的角色拉进左边的函数
function moveToRight() {
	var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
	var selecteds = box1.getSelectedItems();
	if (!selecteds || !selecteds.length)
		return;
	box1.removeItems(selecteds);
	box2.addItems(selecteds);
}
// 把左边的角色全部拉进右边的函数
function moveAllToLeft() {
	var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
	var selecteds = box2.data;
	if (!selecteds || !selecteds.length)
		return;
	box1.addItems(selecteds);
	box2.removeItems(selecteds);
}
// 把右边的角色全部拉进左边的函数
function moveAllToRight() {
	var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
	var selecteds = box1.data;
	//alert("selecteds"+selecteds);
	if (!selecteds || !selecteds.length)
		return;
	box2.addItems(selecteds);
	box1.removeItems(selecteds);

}
// 用户赋予角色的函数
function user_role_join() {
	if (!userGrid.getSelected()) {
		$.ligerDialog.warn('请选择您要赋予角色的用户.');
		return;
	}
	var user = userGrid.getSelected();
	if (!listBox) {
		listBoxInit();
	}

	$.ajax({
		url : '/hnfnuzyw/system/roleByUser.action',
		data : {
			userId : user.id
		},
		type : 'post',
		success : function(data) {
				liger.get("listbox1").setData(data.roleByUser.unSelected);
				liger.get("listbox2").setData(data.roleByUser.selected);
				userRoleJoinWin = $.ligerDialog.open({
					width : 600,
					height : 600,
					title : '赋予' + user.username + '角色',
					target : listBox,
					buttons : [ {
						text : '提交',
						width : 80,
						onclick : join_sava
					}, {
						text : '取消',
						width : 80,
						onclick : join_cancel
					} ]
				});
			
		}
	});

}
// 用户赋予角色提交函数
function join_sava() {
	var selecteds = liger.get("listbox1").data;
	alert(selecteds.id);

}// 用户赋予角色取消函数
function join_cancel() {
	listBox.close();
}

// 初始化表单
function formInit() {
	var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
	userForm = $('<form></form>');
	userForm.ligerForm({
		inputWidth : 280,
		fields : [ {
			name : 'id',
			type : 'hidden',
		}, {
			name : 'username',
			display : '用户名',
			type : 'text',
			space : 30,
			labelWidth : 100,
			newline : true,
			group : '必填信息',
			groupicon : groupicon,
			width : 200
		}, {
			name : 'password',
			display : '密码',
			type : 'password',
			space : 30,
			labelWidth : 100,
			newline : true,
			width : 200
		}, {
			name : 'confirmPassword',
			display : '密码确认',
			type : 'text',
			space : 30,
			labelWidth : 100,
			newline : true,
			width : 200
		}, {
			name : 'name',
			display : '姓名',
			type : 'text',
			space : 30,
			labelWidth : 100,
			newline : true,
			width : 200
		}, {
			name : 'idcard',
			display : '身份证',
			type : 'text',
			space : 30,
			labelWidth : 100,
			newline : true,
			width : 200
		}, {
			name : 'department',
			display : '部门',
			type : 'text',
			space : 30,
			labelWidth : 100,
			newline : true,
			width : 200
		}, {
			name : 'telephone',
			display : '电话',
			type : 'text',
			space : 30,
			labelWidth : 100,
			newline : true,
			width : 200,
			group : '选填信息',
			groupicon : groupicon
		}, {
			display : '性别',
			name : 'sex',
			type : 'select',
			comboboxName : 'sex',
			width : 200,
			labelWidth : 100,
			space : 30,

			options : {
				textField : 'name',
				valueFieldID : 'id',
				valueField : 'id',
				url : "../../../Json/Sex.json"
			// data : [ {
			// 'text' : '男',
			// 'id' :'1'
			// }, {
			// 'text' : '女',
			// 'id' : '0'
			// } ]
			}
		}, {
			name : 'qq',
			display : 'QQ',
			type : 'text',
			space : 30,
			labelWidth : 100,
			newline : true,
			width : 200
		}, {
			name : 'birth',
			display : '生日',
			type : 'date',
			space : 30,
			labelWidth : 100,
			newline : true,
			width : 200
		}, {
			name : 'remark',
			display : '备注',
			type : 'text',
			space : 30,
			labelWidth : 100,
			newline : true,
			width : 200
		} ]
	});
}

// 增加用户的函数
function add_user() {
	formInit();

	userWin = $.ligerDialog.open({
		width : 400,
		height : 600,
		title : '新增功能',
		target : userForm,
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
// 增加用户的保存按钮事件
function add_save() {
	var row_data = Form.parseJSON(userForm);
	// 发往服务器，返回成功后再添加到表格中
	$.ajax({
		url : '/hnfnuzyw/system/addUser.action',
		data : row_data,
		type : 'post',
		success : function(data) {
			if (data.success) {
				userGrid.addRow(data.model);
				$.ligerDialog.tip({
					title : '提示信息',
					content : data.message
				});
				userWin.close();
			} else {
				$.ligerDialog.error(data.message);
			}
		}
	});
}

// 增加功能的取消按钮事件
function add_cancel() {
	userWin.close();
}

// 删除用户的函数
function delete_user() {
	if (!userGrid.getSelected()) {
		$.ligerDialog.warn('请选择您要删除的行.');
		return;
	}
	var row_data = userGrid.getSelected();
	console.log(row_data);
	$.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除功能', function(r) {
		if (r) {
			// 进行ajax操作，成功后在回调函数里删除选择的行
			$.ajax({
				url : '/hnfnuzyw/system/deleteUser.action',
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
						userGrid.deleteSelectedRow();
						userWin.close();
					} else {
						$.ligerDialog.error(data.message);
					}
				}
			});
		}
	});
}

// 修改用户函数
function edit_user() {
	formInit();
	if (!userGrid.getSelected()) {
		$.ligerDialog.warn('请选择您要修改的行.');
		return;
	}
	Form.loadForm(userForm, userGrid.getSelected());
	userWin = $.ligerDialog.open({
		width : 400,
		height : 500,
		title : '编辑功能',
		target : userForm,
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

// 修改用户的保存按钮事件
function edit_save() {
	var row_data = Form.parseJSON(userForm);
	// 需要发往服务器，返回成功后再修改到表格中

	$.ajax({
		url : '/hnfnuzyw/system/updateUser.action',
		data : row_data,
		type : 'post',
		success : function(data) {
			if (data.success) {
				userGrid.update(userGrid.getSelected(), data.model);
				$.ligerDialog.tip({
					title : '提示信息',
					content : data.message
				});
				userWin.close();
			} else {
				$.ligerDialog.error(data.message);
			}
		}
	});
}

// 修改功能的取消按钮事件
function edit_cancel() {
	userWin.close();
}

// 初始化表格
$(function() {

	var toolbarItems = [ {
		text : '新增用户',
		click : add_user,
		icon : 'add',
		key : 'add'
	}, {
		text : '删除用户',
		click : delete_user,
		icon : 'delete',
		key : 'delete'
	}, {
		text : '修改用户',
		click : edit_user,
		icon : 'modify',
		key : 'modify'
	}, {
		text : '角色赋予',
		click : user_role_join,
		icon : 'config',
		key : 'join'
	} ];
	// todo 以后这个ajaxToolbar要通过ajax取过来
	var ajaxToolbar = [ {
		name : 'add'
	}, {
		name : 'delete'
	}, {
		name : 'modify'
	}, {
		name : 'join'
	} ];
	// 确认权限的是否有这个功能
	toolbarItems = Toolbar.confirmToolbar(toolbarItems, ajaxToolbar);

	$.ajax({
		url : '/hnfnuzyw/system/listUser.action',
		type : 'post',
		success : function(data) {
			userGrid = $("#userGrid").ligerGrid({
				columns : [ {
					display : '用户名',
					name : 'username',
					align : 'left',
					width : 100
				}, {
					display : '姓名',
					name : 'name',
					align : 'left',
					width : 80
				}, {
					display : '身份证号码',
					name : 'idcard',
					align : 'left',
					width : 100
				}, {
					display : '性别',
					name : 'sex',
					align : 'left',
					width : 50
				}, {
					display : 'QQ',
					name : 'qq',
					align : 'left',
					width : 100
				}, {
					display : '电话号码',
					name : 'telephone',
					align : 'left',
					width : 120
				}, {
					display : '生日',
					name : 'birth',
					align : 'left',
					width : 100
				}, {
					display : '部门',
					name : 'department',
					align : 'left',
					width : 80
				}, {
					display : '备注',
					name : 'remark',
					align : 'left',
					width : 50
				} ],
				width : '99%',
				height : '98%',
				pageSize : 30,
				data : data.userList,
				toolbar : {
					items : toolbarItems
				},
				rowAttrRender : function(rowdata, rowid) {
					if (rowdata.birth) {
						rowdata.birth = rowdata.birth.substring(0, 10);
					}
					return;
				}
			});
			$("#pageloading").hide();
		}
	});
});
