var userGrid = null;//用户表格
var userForm = null;//用户表单
var userWin = null;//用户窗口
//初始化表单
function formInit() {
    var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
    userForm = $('<form></form>');
    userForm.ligerForm(
        {
            inputWidth:280,
            fields:[
                {
                    name:'id',
                    display:'ID',
                    type:'text',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200,
                    group:'必填信息',
                    groupicon:groupicon
                },
                {
                    name:'username',
                    display:'用户名',
                    type:'text',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200
                },
                {
                    name:'password',
                    display:'密码',
                    type:'password',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200
                },
                {
                    name:'confirmPassword',
                    display:'密码确认',
                    type:'text',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200
                },
                {
                    name:'name',
                    display:'姓名',
                    type:'text',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200
                },
                {
                    name:'idcard',
                    display:'身份证',
                    type:'text',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200
                },
                {
                    name:'department',
                    display:'部门',
                    type:'text',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200
                },
                {
                    name:'telephone',
                    display:'电话',
                    type:'text',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200,
                   group:'选填信息',
                   groupicon:groupicon
                },
                {
                    name:'sex',
                    display:'性别',
                    type:'select',
                    comboboxName:'sex',
                    options:{isShowCheckBox:true,data:[{text:'男',id:'1'},{text:'女',id:'0'}],valueFieldID:'sexId'}
                },
                {
                    name:'qq',
                    display:'QQ',
                    type:'text',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200
                },
                {
                    name:'birth',
                    display:'生日',
                    type:'text',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200
                },
                {
                    name:'remark',
                    display:'备注',
                    type:'text',
                    space:30,
                    labelWidth:100,
                    newline:true,
                    width:200
                }
            ]
        }
    );
}
//增加用户的函数
function add_user() {
    if(!userForm){
        formInit();
    }else {
        userForm[0].reset();
    }

   userWin = $.ligerDialog.open({
        width:400,
        height:600,
        title:'新增功能',
        target:userForm,
        buttons:[
            {text:'提交', width:80, onclick:add_save},
            {text:'取消', width:80, onclick:add_cancel}
        ]
    });
}
//增加用户的保存按钮事件
function add_save() {
    var data = Form.parseJSON(userForm);
    //todo 需要发往服务器，返回成功后再添加到表格中
    userGrid.addRow(data);
    userWin.close();
}
//增加功能的取消按钮事件
function add_cancel() {
    userWin.close();
}

//删除用户的函数
function delete_user() {
    if (!userGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row = userGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row.name + '？', '删除功能', function (r) {
        if (r) {
            //todo 进行ajax操作，成功后在回调函数里删除选择的行
            userGrid.deleteSelectedRow();
        }
    });
}
function edit_user() {
    if (!userForm) {
        formInit();
    }
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
            {text:'提交', width:80, onclick:edit_save},
            {text:'取消', width:80, onclick:edit_cancel}
        ]
    });
}
//修改用户的保存按钮事件
function edit_save() {
    var data = Form.parseJSON(userForm);
    //todo 需要发往服务器，返回成功后再修改到表格中
    userGrid.update(userGrid.getSelected(), data);
    userWin.close();
}
//修改功能的取消按钮事件
function edit_cancel() {
    userWin.close();
}




//初始化表格
$(function () {

        var toolbarItems = [
            {text:'新增用户', click:add_user, icon:'add', key:'add'},
            {text:'删除用户', click:delete_user, icon:'delete', key:'delete'},
            {text:'修改用户', click:edit_user, icon:'add', key:'add'}
        ];
//todo 以后这个ajaxToolbar要通过ajax取过来
        var ajaxToolbar = [
            {name:'add'},
            {name:'delete'}
        ];
        //确认权限的是否有这个功能
        toolbarItems = Toolbar.confirmToolbar(toolbarItems, ajaxToolbar);
        userGrid = $("#userGrid").ligerGrid(
            {
                columns:[
                    {display:'ID', name:'id', align:'left', width:50},
                    {display:'用户名', name:'username', align:'left', width:100},
                    {display:'姓名', name:'name', align:'left', width:80},
                    {display:'身份证号码', name:'idcard', align:'left', width:100},
                    {display:'性别', name:'sex', align:'left', width:50},
                    {display:'QQ', name:'qq', align:'left', width:100},
                    {display:'电话号码', name:'telephone', align:'left', width:120},
                    {display:'生日', name:'birth', align:'left', width:100},
                    {display:'部门', name:'department', align:'left', width:80},
                    {display:'创建日期', name:'createDate', align:'left', width:100},
                    {display:'最近登录时间', name:'latestLoginDate', align:'left', width:100},
                    {display:'设置', name:'set', align:'left', width:50},
                    {display:'备注', name:'remark', align:'left', width:50}
                ],
                width:'99%',
                height:'98%',
                pageSize:30,
                //todo
                url:'../../../Json/UserData.json',
                toolbar:{
                    items:toolbarItems
                }
            }
        );
        $("#pageloading").hide();
    }
);
