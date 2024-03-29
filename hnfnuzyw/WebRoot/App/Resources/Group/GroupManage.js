var groupGrid = null;// 分组表格
var groupFrom = null;// 分组表单
var groupWin = null;// 分组窗口

// 增加分组的函数
function add_group() {
    formInit();
    groupWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'新增分组',
        target:groupFrom,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:add_save
            },
            {
                text:'取消',
                width:80,
                onclick:add_cancel
            }
        ]
    });
}
// 增加分组的保存按钮事件
function add_save() {
    if (groupFrom.valid()) {
        var row_data = Form.parseJSON(groupFrom);
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../resources/addGroup.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    refresh_group();
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    groupWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加分组的取消按钮事件
function add_cancel() {
    groupWin.close();
}
// 修改分组的函数
function edit_group() {
    formInit();

    if (!groupGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    var row_data = groupGrid.getSelected();
    if (row_data.isDisplay == "是") {
        row_data.isDisplay = 1;
    } else {
        row_data.isDisplay = 0;
    }
    Form.loadForm(groupFrom, groupGrid.getSelected());
    groupWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'编辑分组',
        target:groupFrom,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:edit_save
            },
            {
                text:'取消',
                width:80,
                onclick:edit_cancel
            }
        ]
    });
}
// 修改分组的保存按钮事件
function edit_save() {
    if (groupFrom.valid()) {
        var row_data = Form.parseJSON(groupFrom);
        // todo 需要发往服务器，返回成功后再修改到表格中
        $.ajax({
            url:'../../../resources/updateGroup.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    refresh_group();
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    groupWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 修改分组的取消按钮事件
function edit_cancel() {
    groupWin.close();
}
// 刷新分组的函数
function refresh_group() {
    $.ajax({
        url:'../../../resources/listGroup.action',
        type:'post',
        success:function (data) {
            groupGrid.loadData(data.groupList);
        }
    });
    $("#pageloading").hide();

}
// 删除分组的函数
function delete_group() {
    if (!groupGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = groupGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '？,删除该分组后，该分组下的年级，科目，类别，资源都将级联删除，删除后将不可恢复，请慎重。', '删除分组', function (r) {
        if (r) {
            $.ajax({
                url:'../../../resources/deleteGroup.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        groupGrid.deleteSelectedRow();
                        groupWin.close();
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
    groupFrom = $('<form></form>');
    groupFrom.ligerForm({
        inputWidth:280,
        fields:[
            {
                name:'id',
                type:"hidden"
            },
            {
                display:'分组名称',
                name:'name',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    required:true,
                    maxlength:22
                }
            },
            {
                display:'分组样式',
                name:'style',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true
            },
            {
                display:"是否显示",
                name:"isDisplay",
                type:"select",
                width:200,
                space:30,
                labelWidth:100,
                comboboxName:"isDisplay",
                textField:"text",
                valueField:"id",
                newline:true,
                options:{
                    selectBoxHeight:40,
                    hideOnLoseFocus:true,
                    valueFieldID:"id",
                    initValue:"1",
                    initText:"是",
                    data:[
                        {
                            "id":"1",
                            "text":"是"
                        },
                        {
                            "id":"0",
                            "text":"否"
                        }
                    ]

                }
            },
            {
                display:'备注',
                name:'remark',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true
            }
        ]
    });
    $.metadata.setType("attr", "validate");
    groupFrom.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error, element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
}
// 初始化表格
$(function () {
    var toolbarItems = [
        {
            text:'新增分组',
            click:add_group,
            icon:'add',
            key:'add'
        },
        {
            text:'修改分组',
            click:edit_group,
            icon:'modify',
            key:'modify'
        },
        {
            text:'删除分组',
            click:delete_group,
            icon:'delete',
            key:'delete'
        }
    ];
    var menuId = window.parent.tab.getSelectedTabItemID();
    $.ajax({
        async:false,
        url:'../../../system/listFunctionIdList.action',
        type:'post',
        data:{
            menuId:menuId.substr(0, menuId.indexOf("t"))
        },
        success:function (data) {
            var idList = data.functionIdList.split(";");
            var ajaxToolbar = [];
            for (var i = 0; i < idList.length; i++) {
                ajaxToolbar.push({name:parent.hnfnu.functionList[idList[i]]});
            }
            toolbarItems = Toolbar.confirmToolbar(toolbarItems, ajaxToolbar);
        }
    });

    $.ajax({
        url:'../../../resources/listGroup.action',
        type:'post',
        success:function (data) {
            groupGrid = $('#groupGrid').ligerGrid({
                columns:[
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display:'分组名称',
                        name:'name',
                        width:200
                    }, {
                        display:'分组样式',
                        name:'style',
                        width:200
                    }, {
                        display:'是否显示',
                        name:'isDisplay',
                        width:200
                    },
                    {
                        display:'备注',
                        name:'remark',
                        align:'left',
                        width:800
                    }
                ],
                width:'99%',
                height:'98%',
                pageSize:20,
                data:data.groupList,
                toolbar:{
                    items:toolbarItems
                },
                rowAttrRender:function (rowdata) {
                    if (rowdata.isDisplay == 0) {
                        rowdata.isDisplay = "否";
                    } else {
                        rowdata.isDisplay = "是";
                    }
                    return;
                }
            });
            $("#pageloading").hide();
        }
    });
});