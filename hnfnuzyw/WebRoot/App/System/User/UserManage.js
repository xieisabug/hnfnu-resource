var userGrid = null;//用户表格
var userForm = null;//用户表单
var userWin = null;//用户窗口
var listBox = null;//用户角色列表
var userRoleJoinWin = null;//用户赋予角色窗口
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
                    options:{isShowCheckBox:true, data:[
                        {text:'男', id:'1'},
                        {text:'女', id:'0'}
                    ], valueFieldID:'sexId'}
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
//用户赋予角色的函数
function user_role_join() {
    if (!userGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要赋予角色的用户.');
        return;
    }

    if(!listBox){
        listBoxInit();
    }
    //todo 这个数据要根据选择的用户得到两组数据，一组是该用户没有赋予的角色，左边的盒子，一组是该用户已经赋予的角色，放在右边的盒子里面。
    var data = [
        { text:'张三jsadfajsgha', id:'1' },
        { text:'李四', id:'2' },
        { text:'赵武2', id:'3' },
        { text:'赵武3', id:'4' },
        { text:'赵武4', id:'5' },
        { text:'赵武5', id:'6' },
        { text:'赵武6', id:'7' },
        { text:'赵武7', id:'8' }
    ];
    liger.get("listbox1").setData(data);
    userRoleJoinWin = $.ligerDialog.open({
        width:600,
        height:600,
        title:'赋予角色',
        target:listBox,
        buttons:[
            {text:'提交',width:80,onclick:join_sava},
            {text:'取消',width:80,onclick:join_cancel}
        ]
    });
}
//用户赋予角色提交函数
function join_sava(){

}//用户赋予角色取消函数
function join_cancel(){

}

//增加用户的函数
function add_user() {
    formInit();

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
//修改用户函数
function edit_user() {
    formInit();
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
//把左边的角色拉进右边的函数
function moveToLeft()
{
    var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
    var selecteds = box2.getSelectedItems();
    if (!selecteds || !selecteds.length) return;
    box2.removeItems(selecteds);
    box1.addItems(selecteds);
}
//把右边的角色拉进左边的函数
function moveToRight()
{
    var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
    var selecteds = box1.getSelectedItems();
    if (!selecteds || !selecteds.length) return;
    box1.removeItems(selecteds);
    box2.addItems(selecteds);
}
//把左边的角色全部拉进右边的函数
function moveAllToLeft()
{
    var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
    var selecteds = box2.data;
    if (!selecteds || !selecteds.length) return;
    box1.addItems(selecteds);
    box2.removeItems(selecteds);
}
//把右边的角色全部拉进左边的函数
function moveAllToRight()
{
    var box1 = liger.get("listbox1"), box2 = liger.get("listbox2");
    var selecteds = box1.data;
    if (!selecteds || !selecteds.length) return;
    box2.addItems(selecteds);
    box1.removeItems(selecteds);

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
//用户赋予角色listBox的初始化
function listBoxInit() {
    listBox = $('<div style="margin:4px;float:left;"><div id="listbox1"></div></div>' +
        '<div style="margin:4px;float:left;" class="middle">' +
        '<input type="button" onclick="moveToLeft()" value="<" />' +
        '<input type="button" onclick="moveToRight()" value=">" />' +
        '<input type="button" onclick="moveAllToLeft()" value="<<" /> ' +
        '<input type="button" onclick="moveAllToRight()" value=">>" /> </div>' +
        '<div style="margin:4px;float:left;"><div id="listbox2"></div></div>');
    listBox.find("#listbox1,#listbox2").ligerListBox({
        isShowCheckBox:true,
        isMultiSelect:true,
        height:500,
        width:250
    });


}
//初始化表格
$(function () {

    var toolbarItems = [
        {text:'新增用户', click:add_user, icon:'add', key:'add'},
        {text:'删除用户', click:delete_user, icon:'delete', key:'delete'},
        {text:'修改用户', click:edit_user, icon:'modify', key:'modify'},
        {text:'角色赋予', click:user_role_join, icon:'config', key:'join'}
    ];
//todo 以后这个ajaxToolbar要通过ajax取过来
    var ajaxToolbar = [
        {name:'add'},
        {name:'delete'},
        {name:'modify'},
        {name:'join'}
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
});
