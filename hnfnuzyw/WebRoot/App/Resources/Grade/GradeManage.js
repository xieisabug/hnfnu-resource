var gradeGrid = null;// 年级表格
var gradeFrom = null;// 年级表单
var gradeWin = null;// 年级窗口

// 增加年级的函数
function add_grade() {
    formInit();
    gradeWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'新增年级',
        target:gradeFrom,
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
// 增加年级的保存按钮事件
function add_save() {
    if (gradeFrom.valid()) {
        var row_data = Form.parseJSON(gradeFrom);
        if (row_data.groupId == "" || row_data.groupId == null) {
            $.ligerDialog.error("未选择分组");
            return;
        }
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../resources/addGrade.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    refresh_grade();
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    gradeWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加年级的取消按钮事件
function add_cancel() {
    gradeWin.close();
}
// 修改年级的函数
function edit_grade() {
    formInit();
    if (!gradeGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(gradeFrom, gradeGrid.getSelected());
    gradeWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'编辑年级',
        target:gradeFrom,
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
// 修改年级的保存按钮事件
function edit_save() {
    if (gradeFrom.valid()) {
        var row_data = Form.parseJSON(gradeFrom);
        // todo 需要发往服务器，返回成功后再修改到表格中
        $.ajax({
            url:'../../../resources/updateGrade.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    refresh_grade();
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    gradeWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 修改年级的取消按钮事件
function edit_cancel() {
    gradeWin.close();
}
// 刷新分组的函数
function refresh_grade() {
    $.ajax({
        url:'../../../resources/listGrade.action',
        type:'post',
        success:function (data) {
            gradeGrid.loadData(data.gradeList);
        }
    });
    $("#pageloading").hide();

}
// 删除年级的函数
function delete_grade() {
    if (!gradeGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = gradeGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除年级', function (r) {
        if (r) {
            $.ajax({
                url:'../../../resources/deleteGrade.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        refresh_grade();
                        gradeWin.close();
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
    gradeFrom = $('<form></form>');
    $.ajax( {
        url : '../../../resources/listGroups.action',
        type : 'post',
        async : false,
        success : function(data) {
            gradeFrom.ligerForm({
                inputWidth:280,
                fields:[
                    {
                        name:'id',
                        type:"hidden"
                    },
                    {
                        display:'年级名称',
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
                        display:"显示顺序",
                        name:"isDisplay",
                        type:"select",
                        comboboxName:"displayS",
                        space:30,
                        labelWidth:100,
                        width:220,
                        newline:true,
                        options:{
                            textField:"text",
                            valueField:"id",
                            initValue:"0",
                            initText:"否",
                            hideOnLoseFocus:true,
                            valueFieldID:"isDisplay",
                            data:[
                                {
                                    "id":"0",
                                    "text":"0"
                                },
                                {
                                    "id":"1",
                                    "text":"1"
                                },
                                {
                                    "id":"2",
                                    "text":"2"
                                },
                                {
                                    "id":"3",
                                    "text":"3"
                                },
                                {
                                    "id":"4",
                                    "text":"4"
                                },
                                {
                                    "id":"5",
                                    "text":"5"
                                },  {
                                    "id":"6",
                                    "text":"6"
                                }
                            ]

                        }
                    },
                    {
                        display:"所属分组",
                        name:"groupId",
                        type:"select",
                        space:30,
                        labelWidth:100,
                        width:220,
                        newline:true,
                        comboboxName:"group",
                        options:{
                            textField:"name",
                            valueField:"id",
                            hideOnLoseFocus:true,
                            valueFieldID:"groupId",
                            data:data.groups
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
            gradeFrom.validate({
                debug:true,
                onkeyup:false,
                errorPlacement:function (error, element) {
                    error.appendTo(element.parent().parent().parent().parent());
                }
            });
        }
    });








}
// 初始化表格
$(function () {
    var toolbarItems = [
        {
            text:'新增年级',
            click:add_grade,
            icon:'add',
            key:'add'
        },
        {
            text:'修改年级',
            click:edit_grade,
            icon:'modify',
            key:'modify'
        },
        {
            text:'删除年级',
            click:delete_grade,
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
        url:'../../../resources/listGrade.action',
        type:'post',
        success:function (data) {
            gradeGrid = $('#gradeGrid').ligerGrid({
                columns:[
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display:'年级名称',
                        name:'name',
                        width:200
                    },
                    {
                        display:'显示顺序',
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
                groupColumnName:'groupName',
                groupColumnDisplay:'分组',
                width:'99%',
                height:'98%',
                pageSize:20,
                data:data.gradeList,
                toolbar:{
                    items:toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});