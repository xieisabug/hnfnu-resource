var studentGrid = null;// 学生表格
var studentForm = null;// 学生表单
var studentWin = null;// 学生窗口

// 增加学生的函数
function add_student() {
    formInit("add");
    studentWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'新增学生',
        target:studentForm,
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
// 增加学生的保存按钮事件
function add_save() {
    if (studentForm.valid()) {
        var row_data = Form.parseJSON(studentForm);

        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../system/addStudent.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    studentGrid.addRow(data.model);
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    studentWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加学生的取消按钮事件
function add_cancel() {
    studentWin.close();
}
// 修改学生的函数
function edit_student() {
    formInit("edit");
    if (!studentGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(studentForm, studentGrid.getSelected());
    studentWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'编辑学生',
        target:studentForm,
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
// 修改学生的保存按钮事件
function edit_save() {
    if (studentForm.valid()) {
        var row_data = Form.parseJSON(studentForm);
        // todo 需要发往服务器，返回成功后再修改到表格中
        $.ajax({
            url:'../../../system/updateStudent.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    studentGrid.update(studentGrid.getSelected(),
                        data.model);
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    studentWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 修改学生的取消按钮事件
function edit_cancel() {
    studentWin.close();
}

// 删除学生的函数
function delete_student() {
    if (!studentGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = studentGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除学生', function (r) {
        if (r) {
            $.ajax({
                url:'../../../system/deleteStudent.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        studentGrid.deleteSelectedRow();
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
    studentForm = $('<form></form>');
    var fields = [];
    fields.push({
        name:'id',
        type:'hidden'
    },
       {
            name:'balance',
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
        name:'number',
        display:'学号',
        type:'text',
        space:30,
        labelWidth:100,
        newline:true,
        width:200,
        validate:{
            required:true,
            maxlength:20
        }
    }, {
            name:'major',
            display:'专业',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:50
            }
        },
        {
        name:'department',
        display:'系部',
        type:'text',
        space:30,
        labelWidth:100,
        newline:true,
        width:200,
        validate:{
            required:true,
            maxlength:50
        }
    }, {
        display:"入学年份",
        name:"entranceTime",
        type:"select",
        width:200,
        space:30,
        labelWidth:100,
        comboboxName:"entranceTime",
        textField:"text",
        valueField:"text",
        newline:true,
        options:{
            hideOnLoseFocus:true,
            valueFieldID:"id",
            data:[
                {
                    "text":"2010"
                },
                {
                    "text":"2011"
                },
                {
                    "text":"2012"
                },
                {
                    "text":"2013"
                },
                {
                    "text":"2014"
                },
                {
                    "text":"2015"
                },
                {
                    "text":"2016"
                },
                {
                    "text":"2017"
                },
                {
                    "text":"2018"
                },
                {
                    "text":"2019"
                },
                {
                    "text":"2020"
                },
                {
                    "text":"2021"
                },
                {
                    "text":"2011"
                },
                {
                    "text":"2011"
                },
                {
                    "text":"2011"
                },
                {
                    "text":"2011"
                },
                {
                    "text":"2011"
                },
                {
                    "text":"2011"
                },
                {
                    "text":"2011"
                }
            ]

        }
    }, {
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

    studentForm.ligerForm({
        inputWidth:280,
        fields:fields
    });
    $.metadata.setType("attr", "validate");
    studentForm.validate({
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
            text:'新增学生',
            click:add_student,
            icon:'add',
            key:'add'
        },
        {
            text:'修改学生',
            click:edit_student,
            icon:'modify',
            key:'modify'
        },
        {
            text:'删除学生',
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
        url:'../../../system/listStudent.action',
        type:'post',
        success:function (data) {
            studentGrid = $('#studentGrid').ligerGrid({
                columns:[
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display:'学生名字',
                        name:'name',
                        width:200
                    },
                    {
                        display:'学号',
                        name:'number',
                        align:'left',
                        width:100
                    },
                    {
                        display:'专业',
                        name:'major',
                        align:'left',
                        width:100
                    },
                    {
                        display:'系部',
                        name:'department',
                        align:'left',
                        width:100
                    },
                    {
                        display:'入学年份',
                        name:'entranceTime',
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
                data:data.studentList,
                toolbar:{
                    items:toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});