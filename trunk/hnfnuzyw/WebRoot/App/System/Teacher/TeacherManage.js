var teacherGrid = null;// 老师表格
var teacherFrom = null;// 老师表单
var teacherWin = null;// 老师窗口

// 增加老师的函数
function add_teacher() {
    formInit("add");
    teacherWin = $.ligerDialog.open({
        width:400,
        height:500,
        title:'新增老师',
        target:teacherFrom,
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
// 增加老师的保存按钮事件
function add_save() {
    if (teacherFrom.valid()) {
        var row_data = Form.parseJSON(teacherFrom);

        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../system/addTeacher.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    teacherGrid.addRow(data.model);
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    teacherWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加老师的取消按钮事件
function add_cancel() {
    teacherWin.close();
}
// 修改老师的函数
function edit_student() {
    formInit("edit");
    if (!teacherGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(teacherFrom, teacherGrid.getSelected());
    teacherWin = $.ligerDialog.open({
        width:400,
        height:500,
        title:'编辑老师',
        target:teacherFrom,
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
// 修改老师的保存按钮事件
function edit_save() {
    if (teacherFrom.valid()) {
        var row_data = Form.parseJSON(teacherFrom);
        // todo 需要发往服务器，返回成功后再修改到表格中
        $.ajax({
            url:'../../../system/updateTeacher.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    teacherGrid.update(teacherGrid.getSelected(),
                        data.model);
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    teacherWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 修改老师的取消按钮事件
function edit_cancel() {
    teacherWin.close();
}

// 删除老师的函数
function delete_student() {
    if (!teacherGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = teacherGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除老师', function (r) {
        if (r) {
            $.ajax({
                url:'../../../system/deleteTeacher.action',
                data:{
                    id:row_data.id
                },
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        teacherGrid.deleteSelectedRow();
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
function formInit(func) {
    var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
    teacherFrom = $('<form></form>');
    var fields = [];
    fields.push({
            name:'id',
            type:'hidden'
        },
        {
            name:'balance',
            type:'hidden'
        },
        {
            name:'password',
            type:'hidden'
        },{
            name:'username',
            display:'用户名',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            group:'必填信息',
            groupicon:groupicon,
            width:200,
            validate:{
                required:true,
                maxlength:20
            }
        });

    if (func === "add") {
        fields.push({
            name:'password',
            display:'密码',
            type:'password',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:20
            }
        }, {
            name:'confirmPassword',
            display:'密码确认',
            type:'password',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:20,
                equalTo:"#password"
            }
        });
    } else if (func === "edit") {
    }
    fields.push({
            name:'name',
            display:'姓名',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:10
            }
        }, {
            name:'idcard',
            display:'身份证号码',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:18
            }
        }, {
            name:'qq',
            display:'QQ',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:15
            }
        },
        {
            name:'department',
            display:'部门',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:50
            }
        },  {
            name:'telephone',
            display:'手机号码',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:false,
                maxlength:15
            }
        },
        {
            name:'remark',
            display:'备注',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200
        });

    teacherFrom.ligerForm({
        inputWidth:280,
        fields:fields
    });
    $.metadata.setType("attr", "validate");
    teacherFrom.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error,element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
}
// 初始化表格
$(function () {
    var toolbarItems = [
        {
            text:'新增老师',
            click:add_teacher,
            icon:'add',
            key:'add'
        },
        {
            text:'修改老师',
            click:edit_student,
            icon:'modify',
            key:'modify'
        },
        {
            text:'删除老师',
            click:delete_student,
            icon:'delete',
            key:'delete'
        }
    ];
    var menuId = window.parent.tab.getSelectedTabItemID();
    $.ajax({
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
        url:'../../../system/listTeacher.action',
        type:'post',
        success:function (data) {
            teacherGrid = $('#teacherGrid').ligerGrid({
                columns:[
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display:'账号',
                        name:'username',
                        width:200
                    },{
                        display:'老师名字',
                        name:'name',
                        width:200
                    },
                    {
                        display:'身份证号码',
                        name:'idcard',
                        align:'left',
                        width:100
                    },
                    {
                        display:'QQ',
                        name:'qq',
                        align:'left',
                        width:100
                    },
                    {
                        display:'部门',
                        name:'department',
                        align:'left',
                        width:100
                    },
                    {
                        display:'资源币余额',
                        name:'balance',
                        align:'left',
                        width:80
                    },
                    {
                        display:'电话号码',
                        name:'telephone',
                        align:'left',
                        width:120
                    },
                    {
                        display:'备注',
                        name:'remark',
                        align:'left',
                        width:50
                    }
                ],
                width:'99%',
                height:'98%',
                usePager:false,
                data:data.teacherList,
                toolbar:{
                    items:toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});