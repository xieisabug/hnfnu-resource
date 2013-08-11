var sourceForm = null;//表单
var sourceGrid = null;//右侧表格
var sourceTree = null;//左侧树
var sourceWin = null;//显示的窗口
var sourceSelectData = null;//表格选择的数据

//增加课程
function add_source2(){
    sourceWin = $.ligerDialog.open( {
        width : 400,
        height : 550,
        title : "上传资源",
        url:'AddForm.html',
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
    //sourceForm = sourceWin.frame.sourceForm;
}
// 增加课程的保存按钮事件
function add_save() {
    sourceForm = sourceWin.frame.sourceForm;
    // 把表单转化为数组
    if (sourceForm.valid()) {
        var row_data = Form.parseJSON(sourceForm);
        // 发往服务器，返回成功后再添加到表格中
        $.ajax( {
            url : '/hnfnuzyw/resources/addSource.action',
            data : row_data,
            type : 'post',
            success : function(data) {
                if (data.success) {
                    //courseGrid.addRow(data.model);
                    $.ligerDialog.tip( {
                        title : '提示信息',
                        content : data.message
                    });
                    sourceWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加课程的取消按钮事件
function add_cancel() {
    sourceForm = sourceWin.frame.sourceForm;
    var dlg = $.ligerDialog.waitting('正在撤销已经上传的文件...');
    $.ajax({
        url:'/hnfnuzyw/resources/deleteSource.action',
        data:{url:$("#url",sourceForm).val()},
        type:'post',
        success:function (data) {
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
//删除课程
function delete_source(){
    if (!sourceGrid.getSelected()) {
        $.ligerDialog.warn("请选择您要删除的行！");
        return;
    }
    var row_data = sourceGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '?', '删除功能', function(r) {
        if (r) {
            $.ajax( {
                url : '/hnfnuzyw/resources/deleteSource.action',
                data : row_data,
                type : 'post',
                success : function(data) {
                    if (data.success) {
                        $.ligerDialog.tip( {
                            title : '提示信息',
                            content : data.message
                        });
                        sourceGrid.deleteSelectedRow();
                        sourceWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            })
        }
    });
}
//编辑课程
function edit_source(){
    if (!sourceGrid.getSelected()) {
        $.ligerDialog.warn("请选择您要修改的行！");
        return;
    }
    // 这个函数的参数为：form，data，作用就是把data放到from
    sourceSelectData = sourceGrid.getSelected();
    sourceWin = $.ligerDialog.open( {
        width : 400,
        height : 550,
        title : "修改课程",
        url:'EditForm.html',
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
//编辑完成课程后进行保存
function edit_save() {

    if (sourceForm.valid()) {
        var row_data = Form.parseJSON(sourceForm);
        // 发往服务器，返回成功后再修改到表格中
        $.ajax( {
            url : '/hnfnuzyw/resources/updateSource.action',
            data : row_data,
            type : 'post',
            success : function(data) {
                if (data.success) {
                    sourceGrid.update(sourceGrid.getSelected(), data.model);
                    $.ligerDialog.tip( {
                        title : '提示信息',
                        content : data.message
                    });
                    sourceWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
//取消编辑
function edit_cancel() {
    sourceWin.close();
}
//查看资源全部的信息
function all_info(){
    if (!sourceGrid.getSelected()) {
        $.ligerDialog.warn("请选择您要查看的数据。");
        return;
    }
    var sourceGridData = sourceGrid.getSelected();
    $.ligerDialog.open({
        title: '查看全部信息',
        name:'winSelector',
        width: 500,
        height: 550,
        url: 'SourceInfo.jsp?id='+sourceGridData.id
    });
}
//打开一个选择课程的树形结构的对话框
function openTreeDialog(){
    $.ligerDialog.open({
        title: '选择课程',
        name:'winSelector',
        width: 500,
        height: 500,
        url: 'SelectCourse.html',
        isHidden:false,
        buttons: [
            {
                text: '确定',
                onclick: function(item, dialog){//选择了课程后进行数据处理的函数
                    var fn = dialog.frame.selectCourse || dialog.frame.window.selectCourse;
                    var data = fn();
                    if (!data){
                        alert('请选择行。');
                        return;
                    }
                    if(isCourse(data)){
                        sourceWin.frame.setCourseData(data);
                    } else {
                        alert('请选择课程。');
                        return;
                    }
                    dialog.close();
                }
            },
            {
                text: '取消',
                onclick: function(item, dialog){//取消选择
                    dialog.close();
                }
            }
        ]
    });
    return false;
}
//判断选择的是否是课程
function isCourse(obj){
    return sourceTree.getParentTreeItem(sourceTree.getParentTreeItem(sourceTree.getParentTreeItem(obj.target)))==null &&
           sourceTree.getParentTreeItem(sourceTree.getParentTreeItem(obj.target))!=null;
}
//判断选择的是否是类别
function isCategory(obj){
    return !isCourse(obj) &&
        sourceTree.getParentTreeItem(sourceTree.getParentTreeItem(sourceTree.getParentTreeItem(obj.target)))!=null;
}
//获取树的父一级的id
function getParentId(obj){
    return $(sourceTree.getParentTreeItem(obj.target)).attr("id");
}
//初始化表单
function formInit() {
    var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
    sourceForm = $('<form></form>');

    $.ajax({
        url:'/hnfnuzyw/resources/formSelect.action',
        type:'post',
        success:function(data){
            sourceForm.ligerForm( {
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
                    display : "所属课程",
                    name : "courseId",
                    type : "select",
                    comboboxName : "course",
                    options : {
                        textField : "name",
                        valueField : "id",
                        hideOnLoseFocus : true,
                        valueFieldID : "courseId",
                        onBeforeOpen:openTreeDialog
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
                        hideOnLoseFocus:true,
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
                    type : 'text',
                    newline : true,
                    width : 200
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
                }]
            });
            $.metadata.setType("attr", "validate");
            sourceForm.validate( {
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
    $("#sourceLayout").ligerLayout({leftWidth:250});
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
	} ];

	// todo 以后这个ajaxToolbar要通过ajax取过来
	var ajaxToolbar = [ {
		name : 'add'
	}, {
		name : 'modify'
	}, {
		name : 'delete'
	}, {
		name : 'info'
	} ];
	toolbarItems = Toolbar.confirmToolbar(toolbarItems, ajaxToolbar);
    $("#sourceToolBar").ligerToolBar({items:toolbarItems});

    $.ajax( {
        url : '/hnfnuzyw/resources/allTree.action',
        type : 'post',
        success : function(data) {
            sourceTree = $("#sourceTree").ligerTree({
                nodeWidth:200,
                textFieldName : 'name',
                idFieldName : 'id',
                parentIDFieldName : 'pid',
                checkbox:false,
                data : data.allTree,
                onSelect:function(data){
                    var params;
                    if(isCourse(data)){
                        params = {
                            courseId:data.data.id,
                            categoryId:0
                        };
                        $.ajax( {
                            url:'/hnfnuzyw/resources/sourceMoreVoList.action',
                            type : 'post',
                            data:params,
                            success : function(data) {
                                sourceGrid.loadData(data.sourceMoreVoList);
                            }
                        });
                    } else if(isCategory(data)){
                        params = {
                            courseId:getParentId(data),
                            categoryId:data.data.id
                        };
                        $.ajax( {
                            url:'/hnfnuzyw/resources/sourceMoreVoList.action',
                            type : 'post',
                            data:params,
                            success : function(data) {
                                sourceGrid.loadData(data.sourceMoreVoList);
                            }
                        });
                    }
                }
            });
        }
    });

    sourceGrid = $("#sourceGrid").ligerGrid( {
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
            display : '所属课程ID',
            name : 'courseId',
            align : 'left',
            hide : true,
            minWidth : 100
        }, {
            display : '所属课程名',
            name : 'courseName',
            align : 'left',
            minWidth : 150
        }, {
            display : '所属类别ID',
            name : 'categoryIdList',
            align : 'left',
            hide : true,
            minWidth : 100
        },  {
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
            display : '质量等级',
            name : 'quality',
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
        width : '100%'
    });
	$("#pageloading").hide();
});