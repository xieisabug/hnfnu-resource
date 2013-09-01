var subjectGrid = null;// 学科表格
var subjectFrom = null;// 学科表单
var subjectWin = null;// 学科窗口

// 增加学科的函数
function add_subject() {
    formInit();
    subjectWin = $.ligerDialog.open({
        width : 400,
        height : 200,
        title : '新增学科',
        target : subjectFrom,
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
// 增加学科的保存按钮事件
function add_save() {
    if (subjectFrom.valid()) {
        var row_data = Form.parseJSON(subjectFrom);
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url : '/hnfnuzyw/resources/addSubject.action',
            data : row_data,
            type : 'post',
            success : function(data) {
                if (data.success) {
                    subjectGrid.addRow(data.model);
                    $.ligerDialog.tip({
                        title : '提示信息',
                        content : data.message
                    });
                    subjectWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加学科的取消按钮事件
function add_cancel() {
    subjectWin.close();
}
// 修改学科的函数
function edit_subject() {
    formInit();
    if (!subjectGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(subjectFrom, subjectGrid.getSelected());
    subjectWin = $.ligerDialog.open({
        width : 400,
        height : 200,
        title : '编辑学科',
        target : subjectFrom,
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
// 修改学科的保存按钮事件
function edit_save() {
    if (subjectFrom.valid()) {
        var row_data = Form.parseJSON(subjectFrom);
        // todo 需要发往服务器，返回成功后再修改到表格中
        $ .ajax({
                url : '/hnfnuzyw/resources/updateSubject.action',
                data : row_data,
                type : 'post',
                success : function(data) {
                    if (data.success) {
                        subjectGrid.update(subjectGrid.getSelected(),
                            data.model);
                        $.ligerDialog.tip({
                            title : '提示信息',
                            content : data.message
                        });
                        subjectWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
    }
}
// 修改学科的取消按钮事件
function edit_cancel() {
    subjectWin.close();
}

// 删除学科的函数
function delete_subject() {
    if (!subjectGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = subjectGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除学科', function(r) {
        if (r) {
            $.ajax({
                url : '/hnfnuzyw/resources/deleteSubject.action',
                data : row_data,
                type : 'post',
                success : function(data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title : '提示信息',
                            content : data.message
                        });
                        subjectGrid.deleteSelectedRow();
                        subjectWin.close();
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
    subjectFrom = $('<form></form>');
    subjectFrom.ligerForm({
        inputWidth : 280,
        fields : [ {
            name : 'id',
            type : "hidden"
        }, {
            display : '学科名称',
            name : 'name',
            type : 'text',
            space : 30,
            labelWidth : 100,
            width : 220,
            newline : true,
            validate : {
                required : true,
                maxlength : 22
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
    subjectFrom.validate({
        debug : true,
        onkeyup : false,
        errorPlacement : function(error) {
            $.ligerDialog.error(error[0].innerHTML);
        }
    });
}
// 初始化表格
$(function() {
    var toolbarItems = [ {
        text : '新增学科',
        click : add_subject,
        icon : 'add',
        key : 'add'
    }, {
        text : '修改学科',
        click : edit_subject,
        icon : 'modify',
        key : 'modify'
    }, {
        text : '删除学科',
        click : delete_subject,
        icon : 'delete',
        key : 'delete'
    } ];
    var menuId = window.parent.tab.getSelectedTabItemID();
    $.ajax({
        url : '/hnfnuzyw/system/listFunctionIdList.action',
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
        url : '/hnfnuzyw/resources/listSubject.action',
        type : 'post',
        success : function(data) {
            subjectGrid = $('#subjectGrid').ligerGrid({
                columns : [
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display : '学科名称',
                        name : 'name',
                        width : 200
                    }, {
                        display : '备注',
                        name : 'remark',
                        align : 'left',
                        width : 800
                    } ],
                width : '99%',
                height : '98%',
                pageSize : 30,
                data : data.subjectList,
                toolbar : {
                    items : toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});