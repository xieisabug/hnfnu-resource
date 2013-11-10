var topicGrid = null;// 专题表格
var topicFrom = null;// 专题表单
var topicWin = null;// 专题窗口
var joinWin = null;//挂接窗口

// 增加专题的函数
function add_topic() {
    formInit();
    topicWin = $.ligerDialog.open({
        width : 400,
        height : 200,
        title : '新增专题',
        target : topicFrom,
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
// 增加专题的保存按钮事件
function add_save() {
    if (topicFrom.valid()) {
        var row_data = Form.parseJSON(topicFrom);
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url : '../../../resources/addTopic.action',
            data : row_data,
            type : 'post',
            success : function(data) {
                if (data.success) {
                    topicGrid.addRow(data.model);
                    $.ligerDialog.tip({
                        title : '提示信息',
                        content : data.message
                    });
                    topicWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加专题的取消按钮事件
function add_cancel() {
    topicWin.close();
}
// 修改专题的函数
function edit_topic() {
        formInit();
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(topicFrom, topicGrid.getSelected());
    topicWin = $.ligerDialog.open({
        width : 400,
        height : 200,
        title : '编辑专题',
        target : topicFrom,
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
// 修改专题的保存按钮事件
function edit_save() {
    if (topicFrom.valid()) {
        var row_data = Form.parseJSON(topicFrom);
        // todo 需要发往服务器，返回成功后再修改到表格中
        $ .ajax({
                url : '../../../resources/updateTopic.action',
                data : row_data,
                type : 'post',
                success : function(data) {
                    if (data.success) {
                        topicGrid.update(topicGrid.getSelected(),
                            data.model);
                        $.ligerDialog.tip({
                            title : '提示信息',
                            content : data.message
                        });
                        topicWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
    }
}
// 修改专题的取消按钮事件
function edit_cancel() {
    topicWin.close();
}

// 删除专题的函数
function delete_topic() {
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = topicGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除专题', function(r) {
        if (r) {
            $.ajax({
                url : '../../../resources/deleteTopic.action',
                data : row_data,
                type : 'post',
                success : function(data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title : '提示信息',
                            content : data.message
                        });
                        topicGrid.deleteSelectedRow();
                        topicWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}
function topic_source_join() {
	if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    joinWin = $.ligerDialog.open({
        width : 1000,
        height : 550,
        title : '挂接资源',
        url : "JoinSource.html",
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
}
function join_save(){
    var seletedSourceIds = joinWin.frame.joinSelectData;
    var topicId = topicGrid.getSelected().id;
    var sendIds = '';
    for(var i = 0; i<seletedSourceIds.length; i++){
        if(i==0){
            sendIds += seletedSourceIds[i];
        } else {
            sendIds += ',' + seletedSourceIds[i];
        }
    }
    $.ajax( {
        url : '../../../resources/updateTopicSourceJoins.action',
        type : 'post',
        data : {
            topicId : topicId,
            seletedSourceIds : sendIds
        },
        success : function() {
            joinWin.close();
        }
    });
}
function join_cancel(){
    joinWin.close();
}
// 初始化表单，生成form标签
function formInit() {
    topicFrom = $('<form></form>');
    topicFrom.ligerForm({
        inputWidth : 280,
        fields : [ {
            name : 'id',
            type : "hidden"
        }, {
            display : '专题名称',
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
        },
            {
                display : '专题简介',
                name : 'description',
                type : 'text',
                space : 30,
                labelWidth : 100,
                width : 220,
                newline : true,
                validate : {
                    required : true
                }
            },
            {
                display : '专题作者',
                name : 'author',
                type : 'text',
                space : 30,
                labelWidth : 100,
                width : 220,
                newline : true,
                validate : {
                    required : true,
                    maxlength : 22
                }
            },{
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
    topicFrom.validate({
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
        text : '新增专题',
        click : add_topic,
        icon : 'add',
        key : 'add'
    }, {
        text : '修改专题',
        click : edit_topic,
        icon : 'modify',
        key : 'modify'
    }, {
        text : '删除专题',
        click : delete_topic,
        icon : 'delete',
        key : 'delete'
    }, {
            text:'挂接资源',
            click:topic_source_join,
            icon:'config',
            key:'join'
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

    $.ajax({
        url : '../../../resources/listTopic.action',
        type : 'post',
        success : function(data) {
            topicGrid = $('#topicGrid').ligerGrid({
                columns : [
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display : '专题名称',
                        name : 'name',
                        width : 200
                    }, {
                        display : '专题介绍',
                        name : 'description',
                        align : 'left',
                        width : 400
                    },
                    {
                        display : '专题作者',
                        name : 'author',
                        align : 'left',
                        width : 200
                    },
                    {
                        display : '备注',
                        name : 'remark',
                        align : 'left',
                        width : 200
                    } ],
                width : '99%',
                height : '98%',
                pageSize : 20,
                data : data.topicList,
                toolbar : {
                    items : toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});