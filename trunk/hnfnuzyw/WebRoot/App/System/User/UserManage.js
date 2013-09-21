var userGrid = null;// 用户表格
var userForm = null;// 用户表单
var userWin = null;// 用户窗口
var listBox = null;// 用户角色列表
var userRoleJoinWin = null;// 用户赋予角色窗口
var pwdForm = null;// 修改密码的表单
var pwdWin = null;// 修改密码窗口
// 用户赋予角色listBox的初始化
$.extend($.ligerMethos.ListBox, {
    clearData:function () {
        this.data = null;
        this.refresh();
    }
});
function listBoxInit() {
    listBox = $('<div style="margin:4px;float:left;">未选角色：<div id="listbox1"></div></div>'
        + '<div style="margin:4px;float:left;" class="middle">'
        + '<input type="button" onclick="moveToLeft()" value="<" />'
        + '<input type="button" onclick="moveToRight()" value=">" />'
        + '<input type="button" onclick="moveAllToLeft()" value="<<" /> '
        + '<input type="button" onclick="moveAllToRight()" value=">>" /> </div>'
        + '<div style="margin:4px;float:left;">已选角色：<div id="listbox2"></div></div>');
    listBox.find("#listbox1,#listbox2").ligerListBox({
        textField:'name',
        valueField:'id',
        isShowCheckBox:true,
        isMultiSelect:true,
        height:500,
        width:250
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
    // alert("selecteds"+selecteds);
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
        url:'../../../system/roleByUser.action',
        data:{
            userId:user.id
        },
        type:'post',
        success:function (data) {
            var box1 = liger.get("listbox1");
            var box2 = liger.get("listbox2");
            box1.setData(data.roleByUser.unSelected);
            box2.setData(data.roleByUser.selected);
            if (!data.roleByUser.unSelected.length) {
                box1.clearData();
            }
            if (!data.roleByUser.selected.length) {
                box2.clearData();
            }
            userRoleJoinWin = $.ligerDialog.open({
                width:600,
                height:400,
                title:'赋予' + user.username + '角色',
                target:listBox,
                buttons:[
                    {
                        text:'提交',
                        width:80,
                        onclick:join_save
                    },
                    {
                        text:'取消',
                        width:80,
                        onclick:join_cancel
                    }
                ]
            });

        }
    });

}
// 用户赋予角色提交函数
function join_save() {
    $.ligerDialog.confirm('挂接成功后将会刷新页面，请保存好其他页面的工作？', '挂接', function (r) {
        if (r) {
            // 得到用户
            var user = userGrid.getSelected();
            var userRoleIds = user.id + "";
            var selecteds = liger.get("listbox2").data;
            for (var i = 0; i < selecteds.length; i++) {
                userRoleIds += ";";
                userRoleIds += selecteds[i].id;
            }
            $.ajax({
                url:'../../../system/addUserRoleJoins.action',
                data:{
                    seletedRoleIds:userRoleIds
                },
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        userRoleJoinWin.close();
                        window.parent.window.location.reload();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}// 用户赋予角色取消函数

function join_cancel() {
    userRoleJoinWin.close();
}

function edit_pwd_save() {
    if (pwdForm.valid()) {
        if (pwdForm.valid()) {
            var row_data = Form.parseJSON(pwdForm);
            $.ajax({
                url:'../../../system/updatePwd.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        pwdWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    }
}

function edit_pwd_cancel() {
    pwdForm.close();
}

// 初始化修改密码的表单
function pwd_formInit() {
    pwdForm = $('<form></form>');
    pwdForm.ligerForm({
        inputWidth:280,
        fields:[
            {
                name:'id',
                type:'hidden'
            },
            {
                display:'新密码',
                name:'newPassword',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    required:true,
                    maxlength:20
                }
            },
            {
                display:'新密码确认',
                name:'newPassword2',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    required:true,
                    maxlength:20,
                    equalTo:"#newPassword"
                }
            }
        ]
    });
    $.metadata.setType("attr", "validate");
    pwdForm.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });

}

// 初始化表单
function formInit(func) {
    var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
    userForm = $('<form></form>');
    var fields = [];
    fields.push({
        name:'id',
        type:'hidden'
    }, {
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
        display:'身份证',
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
        name:'department',
        display:'部门',
        type:'text',
        space:30,
        labelWidth:100,
        newline:true,
        width:200,
        validate:{
            required:true,
            maxlength:40
        }
    }, {
        name:'telephone',
        display:'电话',
        type:'text',
        space:30,
        labelWidth:100,
        newline:true,
        width:200,
        group:'选填信息',
        groupicon:groupicon,
        validate:{
            required:true,
            maxlength:15
        }
    }, {
        display:"性别",
        name:"sex",
        type:"select",
        width:200,
        space:30,
        labelWidth:100,
        comboboxName:"sex",
        textField:"text",
        valueField:"id",
        newline:true,
        options:{
            hideOnLoseFocus:true,
            valueFieldID:"id",
            data:[
                {
                    "id":"1",
                    "text":"男"
                },
                {
                    "id":"0",
                    "text":"女"
                }
            ]

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
            maxlength:15
        }
    }, {
        name:'birth',
        display:'生日',
        type:'date',
        space:30,
        labelWidth:100,
        newline:true,
        width:200
    }, {
        name:'remark',
        display:'备注',
        type:'text',
        space:30,
        labelWidth:100,
        newline:true,
        width:200
    });

    userForm.ligerForm({
        inputWidth:280,
        fields:fields
    });
    $.metadata.setType("attr", "validate");
    userForm.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error,element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });

}
// 修改密码的函数
function edit_password() {
    var data = userGrid.getSelected();
    if (!data) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }

    pwd_formInit();

    pwdWin = $.ligerDialog.open({
        width:400,
        height:250,
        title:'修改密码',
        target:pwdForm,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:edit_pwd_save
            },
            {
                text:'取消',
                width:80,
                onclick:edit_pwd_cancel
            }
        ]
    });
    $.metadata.setType("attr", "validate");
    pwdForm.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error) {
            $.ligerDialog.error(error[0].innerHTML);
        }
    });
    $("#id", pwdForm).val(data.id);
}

// 增加用户的函数
function add_user() {
    formInit("add");

    userWin = $.ligerDialog.open({
        width:400,
        height:470,
        title:'新增用户',
        target:userForm,
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
// 增加用户的保存按钮事件
function add_save() {
    if (userForm.valid()) {
        var row_data = Form.parseJSON(userForm);
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../system/addUser.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    userGrid.addRow(data.model);
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    userWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
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
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除功能', function (r) {
        if (r) {
            // 进行ajax操作，成功后在回调函数里删除选择的行
            $.ajax({
                url:'../../../system/deleteUser.action',
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
    formInit("edit");
    if (!userGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(userForm, userGrid.getSelected());
    userWin = $.ligerDialog.open({
        width:400,
        height:500,
        title:'编辑功能',
        target:userForm,
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

// 修改用户的保存按钮事件
function edit_save() {

    if (userForm.valid()) {
        var row_data = Form.parseJSON(userForm);
        // 需要发往服务器，返回成功后再修改到表格中

        $.ajax({
            url:'../../../system/updateUser.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    var model = data.model;
                    userGrid.update(userGrid.getSelected(), model);
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    userGrid.reRender();
                    userWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}

// 修改功能的取消按钮事件
function edit_cancel() {
    userWin.close();
}

// 初始化表格
$(function () {
    var toolbarItems = [
        {
            text:'新增用户',
            click:add_user,
            icon:'add',
            key:'add'
        },
        {
            text:'删除用户',
            click:delete_user,
            icon:'delete',
            key:'delete'
        },
        {
            text:'修改用户',
            click:edit_user,
            icon:'modify',
            key:'modify'
        },
        {
            text:'角色赋予',
            click:user_role_join,
            icon:'config',
            key:'join'
        },
        {
            text:'修改密码',
            click:edit_password,
            icon:'modify',
            key:'modify_pwd'
        }
    ];
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
        url:'../../../system/listUser.action',
        type:'post',
        success:function (data) {
            userGrid = $("#userGrid").ligerGrid({
                columns:[
                    {
                        display:'用户名',
                        name:'username',
                        align:'left',
                        width:100
                    },
                    {
                        display:'姓名',
                        name:'name',
                        align:'left',
                        width:80
                    },
                    {
                        display:'身份证号码',
                        name:'idcard',
                        align:'left',
                        width:100
                    },
                    {
                        display:'性别',
                        name:'sex',
                        align:'left',
                        width:50
                    },
                    {
                        display:'QQ',
                        name:'qq',
                        align:'left',
                        width:100
                    },
                    {
                        display:'电话号码',
                        name:'telephone',
                        align:'left',
                        width:120
                    },
                    {
                        display:'生日',
                        name:'birth',
                        align:'left',
                        width:100
                    },
                    {
                        display:'部门',
                        name:'department',
                        align:'left',
                        width:80
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
                pageSize:20,
                data:data.userList,
                toolbar:{
                    items:toolbarItems
                },
                rowAttrRender:function (rowdata) {
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
