var courseGrid = null;
var courseForm = null;
var courseWin = null;
// 按钮的click事件
function update_course(item) {
	$.ligerDialog.alert(item.text);
}
// 增加课程的函数
function add_course() {

	formInit();

	courseWin = $.ligerDialog.open( {
		width : 400,
		height : 400,
		title : "新增课程",
		target : courseForm,
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
// 增加课程的保存按钮事件
function add_save() {
	// 把表单转化为数组
	if (courseForm.valid()) {
		var row_data = Form.parseJSON(courseForm);
		// 发往服务器，返回成功后再添加到表格中
		$.ajax( {
			url : '../../../resources/addCourse.action',
			data : row_data,
			type : 'post',
			success : function(data) {
				if (data.success) {
					courseGrid.addRow(data.model);
					$.ligerDialog.tip( {
						title : '提示信息',
						content : data.message
					});
					courseWin.close();
				} else {
					$.ligerDialog.error(data.message);
				}
			}
		});
	}
}
// 增加课程的取消按钮事件
function add_cancel() {
	courseWin.close();
}

// 删除课程的函数
function delete_course() {
	if (!courseGrid.getSelected()) {
		$.ligerDialog.warn("请选择您要删除的行！");
		return;
	}
	var row_data = courseGrid.getSelected();
	$.ligerDialog.confirm('确认删除' + row_data.name + '?', '删除功能', function(r) {
		if (r) {
			$.ajax( {
				url : '../../../resources/deleteCourse.action',
				data : row_data,
				type : 'post',
				success : function(data) {
					if (data.success) {
						$.ligerDialog.tip( {
							title : '提示信息',
							content : data.message
						});
						courseGrid.deleteSelectedRow();
						courseWin.close();
					} else {
						$.ligerDialog.error(data.message);
					}
				}
			})
		}
	});

}

// 修改课程的函数
function edit_course() {
	formInit();
	if (!courseGrid.getSelected()) {
		$.ligerDialog.warn("请选择您要修改的行！");
		return;
	}
	// 这个函数的参数为：form，data，作用就是把data放到from
	var courseGridData = courseGrid.getSelected();
	Form.loadForm(courseForm, courseGridData);
	courseWin = $.ligerDialog.open( {
		width : 400,
		height : 400,
		title : "修改课程",
		target : courseForm,
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

	if (courseForm.valid()) {
		var row_data = Form.parseJSON(courseForm);
		// 发往服务器，返回成功后再修改到表格中
		$.ajax( {
			url : '../../../resources/updateCourse.action',
			data : row_data,
			type : 'post',
			success : function(data) {
				if (data.success) {
					courseGrid.update(courseGrid.getSelected(), data.model);
					$.ligerDialog.tip( {
						title : '提示信息',
						content : data.message
					});
					courseWin.close();
				} else {
					$.ligerDialog.error(data.message);
				}
			}
		});
	}
}
function edit_cancel() {
	courseWin.close();
}

function query_course(){
    courseGrid.showFilter();
}

// 初始化表单，生成form标签
function formInit() {
	var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
	courseForm = $('<form></form>');

	$.ajax( {
		url : '../../../resources/listGradesAndSubjects.action',
		type : 'post',
		async : false,
		success : function(data) {
			courseForm.ligerForm( {
				inputWidth : 200,
				labelWidth : 90,
				space : 40,
				fields : [ {
					name : "id",
					type : "hidden"
				}, {
					display : "课程名字",
					name : "name",
					newline : true,
					type : "text",
					group : "必填信息",
					groupicon : groupicon,
					validate : {
						required : true,
						maxlength : 30
					}

				}, {
					display : "所属年级",
					name : "gradeId",
					type : "select",
					comboboxName : "grade",
					options : {
						textField : "name",
						valueField : "id",
						hideOnLoseFocus : true,
						valueFieldID : "gradeId",
						data : data.gradeList
					}
				}, {
					display : "所属学科",
					name : "subjectId",
					type : "select",
					comboboxName : "subject",
					options : {
						textField : "name",
						valueField : "id",
						hideOnLoseFocus : true,
						valueFieldID : "id",
						data : data.subjectList
					}
				}, {
					name : 'remark',
					display : '备注',
					type : 'text',
					newline : true,
					width : 200
				}]
			});
			$.metadata.setType("attr", "validate");
			courseForm.validate( {
				debug : true,
				onkeyup : false,
				errorPlacement : function(error,element) {
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
		click : add_course,
		icon : 'add',
		key : 'add'
	}, {
		line : true
	}, {
		text : '删除',
		click : delete_course,
		icon : 'delete',
		key : 'delete'
	}, {
		line : true
	}, {
		text : '修改',
		click : edit_course,
		icon : 'modify',
		key : 'modify'
	}, {
		line : true
	}, {
        text : '高级查询',
        click : query_course,
        icon : 'search2',
        key : 'query'
    }];

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

	$.ajax( {
		url : '../../../resources/listCourseGradeSubject.action',
		type : 'post',
		success : function(data) {
			courseGrid = $("#courseGrid").ligerGrid( {
				columns : [ {
					display : '课程名字',
					name : 'name',
					align : 'left',
					minWidth : 80
				}, {
					display : '所属年级',
					name : 'gradeName',
					align : 'left',
					minWidth : 100
				}, {
					display : '所属学科',
					name : 'subjectName',
					align : 'left',
					minWidth : 100
				}, {
					display : '备注',
					name : 'remark',
					align : 'left',
					minWidth : 100
				} ],
				data : data.courseGradeSubjectList,
				height : '98%',
				width : '100%',
                pageSize:20,
				toolbar : {
					items : toolbarItems
				}
			});
		}
	});
	$("#pageloading").hide();
});