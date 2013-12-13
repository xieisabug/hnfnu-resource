var sourceForm = null;// 表单
var sourceGrid = null;// 右侧表格
var sourceTree = null;// 左侧树
var sourceWin = null;// 显示的窗口
var sourceSelectData = null;// 表格选择的数据
var treeUrl = "",selectUrl = "";
// 增加资源
function add_source2() {
	sourceWin = $.ligerDialog.open({
		width : 400,
		height : 550,
		title : "上传资源",
		url : 'AddForm.html',
		allowClose : false,
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
	// sourceForm = sourceWin.frame.sourceForm;
}
// 增加资源的保存按钮事件
function add_save() {
	sourceForm = sourceWin.frame.sourceForm;
	// 把表单转化为数组
	if (sourceForm.valid()) {
		var row_data = Form.parseJSON(sourceForm);
		if (row_data.url == "" || row_data.url == null) {
			$.ligerDialog.error("未上传文件");
			return;
		}

		// 发往服务器，返回成功后再添加到表格中
		$.ajax({
			url : '../../../resources/addSource.action',
			data : row_data,
			type : 'post',
			success : function(data) {
				if (data.success) {
					// courseGrid.addRow(data.model);
					$.ligerDialog.tip({
						title : '提示信息',
						content : data.message
					});
					refresh_info();
					sourceWin.close();
				} else {
					$.ligerDialog.error(data.message);
				}
			}
		});

	}
}
// 增加资源的取消按钮事件
function add_cancel() {
	sourceForm = sourceWin.frame.sourceForm;
	var dlg = $.ligerDialog.waitting('正在撤销已经上传的文件...');
	$.ajax({
		url : '../../../resources/deleteFile.action',
		data : {
			url : $("#url", sourceForm).val()
		},
		type : 'post',
		success : function(data) {
			dlg.close();
			if (data.success) {
				sourceWin.close();
				$.ligerDialog.success(data.message);
			} else {
				$.ligerDialog.error(data.message);
			}
		}
	});
}
// 删除资源
function delete_source() {
	if (!sourceGrid.getSelected()) {
		$.ligerDialog.warn("请选择您要删除的行！");
		return;
	}
	var row_data = sourceGrid.getSelected();
	$.ligerDialog.confirm('确认删除' + row_data.name + '?', '删除功能', function(r) {
		if (r) {
			$.ajax({
				url : '../../../resources/deleteSource.action',
				data : row_data,
				type : 'post',
				success : function(data) {
					if (data.success) {
						$.ligerDialog.tip({
							title : '提示信息',
							content : data.message
						});
						refresh_info();
						sourceGrid.deleteSelectedRow();
						if (sourceWin) {
							sourceWin.close();
						}
					} else {
						$.ligerDialog.error(data.message);
					}
				}
			})
		}
	});
}
// 编辑资源
function edit_source() {
	if (!sourceGrid.getSelected()) {
		$.ligerDialog.warn("请选择您要修改的行！");
		return;
	}
	// 这个函数的参数为：form，data，作用就是把data放到from
	sourceSelectData = sourceGrid.getSelected();
	sourceWin = $.ligerDialog.open({
		width : 400,
		height : 550,
		title : "修改资源",
		url : 'EditForm.html',
		allowClose : false,
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
// 编辑完成资源后进行保存
function edit_save() {
	sourceForm = sourceWin.frame.sourceForm;
	if (sourceForm.valid()) {
		var row_data = Form.parseJSON(sourceForm);
		// 发往服务器，返回成功后再修改到表格中
		$.ajax({
			url : '../../../resources/updateSource.action',
			data : row_data,
			type : 'post',
			success : function(data) {
				if (data.success) {
					sourceGrid.update(sourceGrid.getSelected(), data.model);
					$.ligerDialog.tip({
						title : '提示信息',
						content : data.message
					});
					refresh_info();
					sourceWin.close();
				} else {
					$.ligerDialog.error(data.message);
				}
			}
		});
	}
}
// 取消编辑
function edit_cancel() {
	sourceWin.close();
}

// 刷新资源的函数
function refresh_info() {
	$.ajax({
		url : treeUrl,
		type : 'post',
		success : function(data) {
			sourceGrid.loadData({
				Rows : [],
				Total : 0
			});
			sourceTree.clear();
			sourceTree.setData(data.allTree);
		}
	});
	$("#pageloading").hide();

}

// 查看资源全部的信息
function all_info() {
	if (!sourceGrid.getSelected()) {
		$.ligerDialog.warn("请选择您要查看的数据。");
		return;
	}
	var sourceGridData = sourceGrid.getSelected();
	$.ligerDialog.open({
		title : '查看全部信息',
		name : 'winSelector',
		width : 1024,
		height : 650,
		url : 'SourceView.html?id=' + sourceGridData.id
	});
}
// 打开一个选择资源的树形结构的对话框
function openTreeDialog() {
	$.ligerDialog.open({
		title : '选择资源',
		name : 'winSelector',
		width : 500,
		height : 500,
		url : 'SelectCourse.html',
		isHidden : false,
		buttons : [
				{
					text : '确定',
					onclick : function(item, dialog) {// 选择了资源后进行数据处理的函数
						//console.log(dialog);
						var fn = dialog.frame.selectCourse
								|| dialog.frame.window.selectCourse;
						var data = fn();
						if (!data) {
							alert('请选择行。');
							return;
						}
						if (isCourse(data)) {
							sourceWin.frame.setCourseData(data);
						} else {
							alert('请选择资源。');
							return;
						}
						dialog.close();
					}
				}, {
					text : '取消',
					onclick : function(item, dialog) {// 取消选择
						dialog.close();
					}
				} ]
	});
	return false;
}
// 判断选择的是否是资源
function isCourse(obj) {
	return sourceTree.getParentTreeItem(sourceTree.getParentTreeItem(sourceTree
			.getParentTreeItem(obj.target))) == null
			&& sourceTree.getParentTreeItem(sourceTree
					.getParentTreeItem(obj.target)) != null;
}
// 判断选择的是否是类别
function isCategory(obj) {
	return !isCourse(obj)
			&& sourceTree
					.getParentTreeItem(sourceTree.getParentTreeItem(sourceTree
							.getParentTreeItem(obj.target))) != null;
}
// 获取树的父一级的id
function getParentId(obj) {
	return $(sourceTree.getParentTreeItem(obj.target)).attr("id");
}
// 初始化表单
function formInit() {
	var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
	sourceForm = $('<form></form>');

	$.ajax({
		url : '../../../resources/formSelect.action',
		type : 'post',
        async: false,
		success : function(data) {
			sourceForm.ligerForm({
				inputWidth : 200,
				labelWidth : 120,
				space : 40,
				fields : [ {
					name : "id",
					type : "hidden"
				}, {
					name : "url",
					type : "hidden"
				}, {
					display : "资源名字",
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
					display : "所属资源",
					name : "courseId",
					type : "select",
					comboboxName : "course",
					options : {
						textField : "name",
						valueField : "id",
						hideOnLoseFocus : true,
						valueFieldID : "courseId",
						onBeforeOpen : openTreeDialog
					},
					validate : {
						required : true
					}
				}, {
					display : "所属分类",
					name : "categoryIdList",
					type : "select",
					comboboxName : "category",
					options : {
						textField : "name",
						valueField : "id",
						hideOnLoseFocus : true,
						isMultiSelect : true,
						isShowCheckBox : true,
						valueFieldID : "categoryIdList",
						data : data.categoryList
					}
				}, {
					name : 'keyWords',
					display : '关键字(用;分割)',
					type : 'text',
					group : "选填信息",
					groupicon : groupicon,
					newline : true,
					width : 200
				}, {
					name : 'mediaType',
					display : '媒体类型',
					type : "select",
					comboboxName : "mediaType",
					options : {
						textField : "name",
						valueField : "id",
						hideOnLoseFocus : true,
						isMultiSelect : true,
						isShowCheckBox : true,
						valueFieldID : "mediaType",
						data : [ {
							name : "图片",
							id : "图片"
						}, {
							name : "动画",
							id : "动画"
						}, {
							name : "声音",
							id : "声音"
						}, {
							name : "视频",
							id : "视频"
						}, {
							name : "文档",
							id : "文档"
						}, {
							name : "程序",
							id : "程序"
						} ]
					}
				}, {
					name : 'mediaFormat',
					display : '媒体格式',
					type : 'text',
					newline : true,
					width : 200
				}, {
					name : 'playTime',
					display : '播放时间',
					type : 'text',
					newline : true,
					width : 200,
					validate : {
						maxlength : 20
					}
				}, {
					name : 'fileSize',
					display : '文件大小',
					type : 'number',
					newline : true,
					width : 200,
					validate : {
						maxlength : 50
					}
				}, {
					name : 'author',
					display : '作者',
					type : 'text',
					newline : true,
					width : 200,
					validate : {
						maxlength : 100
					}
				}, {
					name : 'publisher',
					display : '出版社',
					type : 'text',
					newline : true,
					width : 200
				}, {
					name : 'description',
					display : '描述',
					type : 'text',
					newline : true,
					width : 200
				}, {
					name : 'price',
					display : '价格',
					type : 'number',
					newline : true,
					width : 200
				} ]
			});
			$.metadata.setType("attr", "validate");
			sourceForm.validate({
				debug : true,
				onkeyup : false,
				errorPlacement : function(error) {
					$.ligerDialog.error(error[0].innerHTML);
				}
			});
		}
	});
}
// 页面加载完成后就开始调用
$(function() {
	$("#sourceLayout").ligerLayout({
		leftWidth : 260
	});
	var toolbarItems = [ {
		text : '上传资源',
		click : add_source2,
		icon : 'add',
		key : 'add'
	}, {
		line : true
	}, {
		text : '删除资源',
		click : delete_source,
		icon : 'delete',
		key : 'delete'
	}, {
		line : true
	}, {
		text : '修改资源',
		click : edit_source,
		icon : 'modify',
		key : 'modify'
	}, {
		line : true
	}, {
		text : '详细信息',
		click : all_info,
		icon : 'attibutes',
		key : 'info'
	}, {
		text : '刷新资源',
		click : refresh_info,
		icon : 'refresh',
		key : 'refresh'
	} ];

	var menuId = window.parent.tab.getSelectedTabItemID();

	$.ajax({
        async: false,
		url : '../../../system/listFunctionIdList.action',
		type : 'post',
		data : {
			menuId : menuId.substr(0, menuId.indexOf("t"))
		},
		success : function(data) {
			var idList = data.functionIdList.split(";");
			var ajaxToolbar = [];
			for ( var i = 0; i < idList.length; i++) {
				ajaxToolbar.push({
					name : parent.hnfnu.functionList[idList[i]]
				});
			}
            //console.log(parent.hnfnu);
            var super_query = false;
            ajaxToolbar.forEach(function(data){
                //console.log(data);
                if(data.name == "super_query"){
                    super_query = true;
                }
            });
            if(super_query){
                treeUrl = "../../../resources/allTree.action";
                selectUrl = "../../../resources/sourceMoreVoList.action";
            } else {
                treeUrl = "../../../resources/treeByUserId.action";
                selectUrl = "../../../resources/sourceMoreVoListByUserId.action";
            }
			toolbarItems = Toolbar.confirmToolbar(toolbarItems, ajaxToolbar);
            //console.log("treeUrl : " + treeUrl + ", selectUrl : " + selectUrl);
            $.ajax({
                url : treeUrl,
                type : 'post',
                success : function(data) {
                    sourceTree = $("#sourceTree").ligerTree({
                        nodeWidth : 150,
                        textFieldName : 'name',
                        idFieldName : 'id',
                        parentIDFieldName : 'pid',
                        checkbox : false,
                        data : data.allTree,
                        onAfterAppend : function() {
                            this.collapseAll();
                        },
                        onSelect : function(data) {
                            var params;
                            if (isCourse(data)) {
                                params = {
                                    courseId : data.data.id,
                                    categoryId : 0
                                };
                                $.ajax({
                                    url : selectUrl,
                                    type : 'post',
                                    data : params,
                                    success : function(data) {
                                        sourceGrid.loadData(data.sourceMoreVoList);
                                    }
                                });
                            } else if (isCategory(data)) {
                                params = {
                                    courseId : getParentId(data),
                                    categoryId : data.data.id
                                };
                                $.ajax({
                                    url : selectUrl,
                                    type : 'post',
                                    data : params,
                                    success : function(data) {
                                        sourceGrid.loadData(data.sourceMoreVoList);
                                    }
                                });
                            }
                        }
                    });
                }
            });
		}
	});
    //console.log("treeUrl : " + treeUrl);
    //console.log("selectUrl : " + selectUrl);

	$("#sourceToolBar").ligerToolBar({
		items : toolbarItems
	});

	sourceGrid = $("#sourceGrid").ligerGrid({
		columns : [ {
			display : '资源名',
			name : 'name',
			align : 'left',
			minWidth : 120
		}, {
			display : '关键字',
			name : 'keyWords',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '所属资源ID',
			name : 'courseId',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '所属资源名',
			name : 'courseName',
			align : 'left',
			minWidth : 150
		}, {
			display : '所属类别ID',
			name : 'categoryIdList',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '所属类别',
			name : 'categoryNameList',
			align : 'left',
			minWidth : 150
		}, {
			display : '媒体类型',
			name : 'mediaType',
			align : 'left',
			minWidth : 60
		}, {
			display : '媒体格式',
			name : 'mediaFormat',
			align : 'left',
			minWidth : 60
		}, {
			display : '播放时间',
			name : 'playTime',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '文件大小',
			name : 'fileSize',
			align : 'left',
			minWidth : 60
		}, {
			display : '作者',
			name : 'author',
			align : 'left',
			minWidth : 60
		}, {
			display : '出版社',
			name : 'publisher',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '描述',
			name : 'description',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '创建时间',
			name : 'createDate',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '审核状态',
			name : 'approvalStatus',
			align : 'left',
			minWidth : 60
		}, {
			display : '价格',
			name : 'price',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '访问次数',
			name : 'viewTimes',
			align : 'left',
			minWidth : 60
		}, {
			display : '使用次数',
			name : 'useTimes',
			align : 'left',
			minWidth : 60
		} ],
		height : '98%',
		width : '100%',
		pageSize : 20
	});
	$("#pageloading").hide();
});