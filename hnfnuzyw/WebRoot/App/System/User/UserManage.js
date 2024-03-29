var userGrid = null;// 用户表格
var multipleGrid = null;// 多选
var userForm = null;// 用户表单
var userWin = null;// 用户窗口
var listBox = null;// 用户角色列表
var userRoleJoinWin = null;// 用户赋予角色窗口
var pwdForm = null;// 修改密码的表单
var pwdWin = null;// 修改密码窗口
var manyWin = null;//批量操作窗口
var manyForm = null;//批量操作表单
var manyGrid = null;//批量操作表格
var balanceForm = null;//批量充值资源币
var balanceWin = null;//批量充值资源币
var fileWin = null;//批量注册用户的窗口
var fileForm = null;//批量注册用户的表单
var addUserFailGrid = null;//批量注册用户的时候反馈失败信息
var addUserFailWin = null;//批量注册用户的时候反馈失败信息
var editManyUserPasswdForm = null;//批量修改密码的表单
var editManyUserPasswdWin = null;//批量修改密码的窗口
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
                    refresh_user();
                }
            });
        }
    });
}// 用户赋予角色取消函数

function join_cancel() {
    refresh_user();
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
    pwdWin.close();
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
        },
        {
            name:'username',
            display:'用户名',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
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
        fields.push({
            name:'balance',
            display:'资源币余额',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            validate:{
                required:true,
                maxlength:11
            }
        });
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
            groupicon:groupicon,
            validate:{
                required:true,
                maxlength:15
            }
        },
        {
            name:'email',
            display:'邮箱',
            type:'text',
            space:30,
            labelWidth:100,
            newline:true,
            width:200,
            groupicon:groupicon,
            validate:{
                required:true,
                maxlength:45
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
                selectBoxHeight:40,
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
        errorPlacement:function (error, element) {
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


//批量给用户修改密码
function edit_many_password() {
    var datas = manyGrid.getSelecteds();
    //console.log(datas);
    if (datas.length == 0) {
        $.ligerDialog.warn('请选择您要修改密码用户们.');
        return;
    }
    editManyUserPasswdFormInit();;
    editManyUserPasswdWin = $.ligerDialog.open({
        width:300,
        height:200,
        title:'修改密码',
        target:editManyUserPasswdForm,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:edit_many_password_save
            },
            {
                text:'取消',
                width:80,
                onclick:edit_many_password_cancel
            }
        ]
    });
}
function edit_many_password_save(){
    if (editManyUserPasswdForm.valid()) {
        var userDatas = manyGrid.getSelecteds();
        var userIds = "";
        for (var i = 0; i < userDatas.length; i++) {
            if (i > 0) {
                userIds = userIds + ";";
            }
            userIds = userIds + userDatas[i].id;
        }
        //console.log(userIds);
        var row_data = Form.parseJSON(editManyUserPasswdForm);
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../system/editManyUserPassword.action',
            data:{
                userIds:userIds,
                newPassword:row_data.newPassword
            },
            type:'post',
            success:function (data) {
                if (data.success) {
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    refresh_user();
                    editManyUserPasswdWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
function edit_many_password_cancel(){
    editManyUserPasswdWin.close();
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
        var flat = false;
        $.ajax({
            url:'../../../system/validateUsername.action',
            data:{
                "username":row_data.username
            },
            type:'post',
            async:false,
            success:function (data) {
                if (data.success) {
                    flat = true;
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                }
            }
        });
        //如果用户名不存在
        if (!flat) {
            $.ajax({
                url:'../../../system/addUser.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        userGrid.addRow(data.model);
                        var userDialog = $.ligerDialog.confirm('用户添加成功，需要马上为该用户赋予角色吗？', function (answer) {
                            if (answer) {
                                userGrid.select(data.model);
                                user_role_join();
                            } else {
                                refresh_user();
                            }
                        });
                        userWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
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
                        refresh_user();
                        //refresh_many_user();
                        //manyWin.hide();
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
    var row_data = userGrid.getSelected();
    if (row_data.sex == "女") {
        row_data.sex = 0;
    } else {
        row_data.sex = 1;
    }
    Form.loadForm(userForm, row_data);
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


// 刷新用户的单选操作的函数
function refresh_user() {
    $.ajax({
        url:'../../../system/listUser.action',
        type:'post',
        success:function (data) {
            userGrid.loadData(data.userList);
            if(manyGrid){
                manyGrid.loadData(data.userList);
            }
        }
    });
    $("#pageloading").hide();

}
// // 刷新用户的批量操作的函数
function refresh_many_user() {
    $.ajax({
        url:'../../../system/listUser.action',
        type:'post',
        success:function (data) {
            manyGrid.loadData(data.userList);
        }
    });
    $("#pageloading").hide();

}
//批量给用户充值资源币
function add_balance() {
    var datas = manyGrid.getSelecteds();
    //console.log(datas);
    if (datas.length == 0) {
        $.ligerDialog.warn('请选择您要充值的用户们.');
        return;
    }
    balanceFormInit();
    balanceWin = $.ligerDialog.open({
        width:300,
        height:200,
        title:'充值资源币',
        target:balanceForm,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:add_balance_save
            },
            {
                text:'取消',
                width:80,
                onclick:add_balance_cancel
            }
        ]
    });
}

//批量充值资源币的保存按钮事件
function add_balance_save() {
    if (balanceForm.valid()) {
        var userDatas = manyGrid.getSelecteds();
        var userIds = "";
        for (var i = 0; i < userDatas.length; i++) {
            if (i > 0) {
                userIds = userIds + ";";
            }
            userIds = userIds + userDatas[i].id;
        }
//        console.log(userIds);
        var row_data = Form.parseJSON(balanceForm);
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../system/addUserBalanceCount.action',
            data:{
                userIds:userIds,
                balanceCount:row_data.addCount
            },
            type:'post',
            success:function (data) {
                if (data.success) {
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    refresh_user();
                    refresh_many_user();
                    //manyWin.hide();
                    balanceWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 批量充值资源币的取消按钮事件
function add_balance_cancel() {
    balanceWin.close();
}
//初始化批量充值资源币的表单，生成form标签
function balanceFormInit() {
    balanceForm = $('<form></form>');
    balanceForm.ligerForm({
        inputWidth:80,
        fields:[
            {
                display:'充值资源币数量',
                name:'addCount',
                type:'text',
                space:50,
                labelWidth:100,
                width:100,
                height:50,
                newline:true,
                validate:{
                    required:true,
                    maxlength:9
                }
            }
        ]
    });
    $.metadata.setType("attr", "validate");
    balanceForm.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error, element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
}

//初始化批量修改密密码的表单，生成form标签
function editManyUserPasswdFormInit() {
    editManyUserPasswdForm = $('<form></form>');
    editManyUserPasswdForm.ligerForm({
        inputWidth:80,
        fields:[
            {
                display:'修改后的密码',
                name:'newPassword',
                type:'text',
                space:50,
                labelWidth:100,
                width:100,
                height:50,
                newline:true,
                validate:{
                    required:true,
                    maxlength:20
                }
            }, {
                display:'请确认一次',
                name:'newPassword2',
                type:'text',
                space:50,
                labelWidth:100,
                width:100,
                height:50,
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
    editManyUserPasswdForm.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error, element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
}


/**
 * 批量重置用户的资源币
 */
function set_balance(){
    var datas = manyGrid.getSelecteds();
    //console.log(datas);
    if (datas.length == 0) {
        $.ligerDialog.warn('请选择您要重置的用户们.');
        return;
    }
    balanceFormInit();
    balanceWin = $.ligerDialog.open({
        width:300,
        height:200,
        title:'重置资源币',
        target:balanceForm,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:set_balance_save
            },
            {
                text:'取消',
                width:80,
                onclick:set_balance_cancel
            }
        ]
    });
}
function set_balance_save(){
    if (balanceForm.valid()) {
        var userDatas = manyGrid.getSelecteds();
        var userIds = "";
        for (var i = 0; i < userDatas.length; i++) {
            if (i > 0) {
                userIds = userIds + ";";
            }
            userIds = userIds + userDatas[i].id;
        }
        //console.log(userIds);
        var row_data = Form.parseJSON(balanceForm);
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../system/changeUserBalance.action',
            data:{
                userIds:userIds,
                balanceCount:row_data.addCount
            },
            type:'post',
            success:function (data) {
                if (data.success) {
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    refresh_user();
                    balanceWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }

}
function set_balance_cancel(){
    balanceWin.close();
}
/**
 * 批量删除用户们
 */
function delete_users(){
    var datas = manyGrid.getSelecteds();
    //console.log(datas);
    if (datas.length == 0) {
        $.ligerDialog.warn('请选择您要删除的用户们.');
        return;
    }
    var userIds = "";
    for (var i = 0; i < datas.length; i++) {
        if (i > 0) {
            userIds = userIds + ";";
        }
        userIds = userIds + datas[i].id;
    }
    $.ligerDialog.confirm('确认删除这些用户们,删除后将无法恢复', function (r) {
        if (r) {
            $.ajax({
                url:'../../../system/deleteUsers.action',
                data:{
                    userIds:userIds
                },
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        //studentGrid.deleteSelectedRow();
                        refresh_user();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}

    



//批量注册用户的函数
function add_many_user() {
    fileWin = $.ligerDialog.open({
        width:400,
        height:300,
        title:'批量注册用户',
        url:'AddForm.html',
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:add_many_save
            },
            {
                text:'取消',
                width:80,
                onclick:add_many_cancel
            }
        ]
    });
}
function add_many_save() {
    fileForm = fileWin.frame.fileForm;

    if (fileForm.valid()) {
        var row_data = Form.parseJSON(fileForm);

        if (row_data.url == "" || row_data.url == null) {
            $.ligerDialog.error("未上传文件");
            return;
        }

        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../system/addManyUser.action',
            data:{
                url:row_data.url
            },
            type:'post',
            success:function (data) {
                if (data.success) {
                    if(data.failUsers.Total > 0){
                        add_user_fail(data.failUsers);
                    }else{
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                    }
                    refresh_user();
                    fileWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
//显示批量注册用户失败的详细信息
function add_user_fail(data){
    var s = $('#addUserFailGrid');
    addUserFailGrid = s.ligerGrid({
        columns:[
            {
                display:'姓名',
                name:'name',
                align:'left',
                width:50
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
                width:20
            },
            {
                display:'QQ',
                name:'qq',
                align:'left',
                width:80
            },
            {
                display:'电话号码',
                name:'telephone',
                align:'left',
                width:80
            },
            {
                display:'邮箱',
                name:'email',
                align:'left',
                width:60
            },
            {
                display:'部门',
                name:'department',
                align:'left',
                width:60
            }, {
                display:'失败原因',
                name:'message',
                align:'left',
                width:120
            }
        ],
        width:660,
        height:500,
        pageSize:30,
        data:data
    });
//    console.log(addUserFailGrid)
    addUserFailWin = $.ligerDialog.open({
        width:700,
        height:600,
        title:'批量注册失败的用户',
        target:s
    });
    $(".l-grid2", addUserFailWin.element).css({width:700});
    $("#pageloading").hide();
}


function add_many_cancel() {
    fileWin.close();
}
//todo 批量修改的操作
function manyUserManage() {
    var toolbarItems = [
        {
            text:'多人重置密码',
            click:edit_many_password,
            icon:'modify',
            key:'modify_pwd'
        },
        {
            text:'资源币充值',
            click:add_balance,
            icon:'modify',
            key:'modify_many'
        },  {
            text:'资源币重置',
            click:set_balance,
            icon:'modify',
            key:'set_many'
        },  {
            text:'删除用户们',
            click:delete_users,
            icon:'delete',
            key:'delete_many'
        }
    ];

    $.ajax({
        async:false,
        url:'../../../system/listUser.action',
        type:'post',
        success:function (data) {
            //console.log(data.userList);
            var s = $('#manyGrid');
            manyGrid = s.ligerGrid({
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
                        display:'资源币余额',
                        name:'balance',
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
                        display:'邮箱',
                        name:'email',
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
                width:560,
                height:530,
                pageSize:30,
                checkbox:true,
                data:data.userList,
                toolbar:{
                    items:toolbarItems
                }
            });
            manyWin = $.ligerDialog.open({
                width:600,
                height:600,
                title:'批量操作',
                target:s
            });
            $(".l-grid2", manyWin.element).css({width:560});
            $("#pageloading").hide();
        }
    });


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
        },
        {
            text:'通过Excel批量注册',
            click:add_many_user,
            icon:'add',
            key:'add_many'
        },
        {
            text:'批量操作',
            click:manyUserManage,
            icon:'modify',
            key:'manyManage'
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
        //async: false,
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
                        display:'资源币余额',
                        name:'balance',
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
                        display:'邮箱',
                        name:'email',
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
                    if (rowdata.sex == 0) {
                        rowdata.sex = "女";
                    } else {
                        rowdata.sex = "男";
                    }
                    return;
                }
            });
            $("#pageloading").hide();
        }
    });
});
