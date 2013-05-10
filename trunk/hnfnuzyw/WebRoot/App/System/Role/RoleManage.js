var roleGrid = null;//功能表格
var roleForm = null;//功能表单
var roleWin = null;//功能窗口
var joinTree = null;//树
var treeManager = null;//树的管理器

//增加功能的函数
function add_role() {
    if (!roleForm) {
        formInit();
    } else {
        roleForm[0].reset();
    }
    roleWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'新增功能',
        target:roleForm,
        buttons:[
            {text:'提交', width:80, onclick:add_save},
            {text:'取消', width:80, onclick:add_cancel}
        ]
    });
}
//增加功能的保存按钮事件
function add_save() {
    var data = Form.parseJSON(roleForm);
    //todo 需要发往服务器，返回成功后再添加到表格中
    roleGrid.addRow(data);
    roleWin.close();
}
//增加功能的取消按钮事件
function add_cancel() {
    roleWin.close();
}
//修改功能的函数
function edit_role() {
    if (!roleForm) {
        formInit();
    }
    if (!roleGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(roleForm, roleGrid.getSelected());
    roleWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'编辑功能',
        target:roleForm,
        buttons:[
            {text:'提交', width:80, onclick:edit_save},
            {text:'取消', width:80, onclick:edit_cancel}
        ]
    });
}
//修改功能的保存按钮事件
function edit_save() {
    var data = Form.parseJSON(roleForm);
    //todo 需要发往服务器，返回成功后再修改到表格中
    roleGrid.update(roleGrid.getSelected(), data);
    roleWin.close();
}
//修改功能的取消按钮事件
function edit_cancel() {
    roleWin.close();
}
//删除功能的函数
function delete_role() {
    if (!roleGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row = roleGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row.name + '？', '删除功能', function (r) {
        if (r) {
            //todo 进行ajax操作，成功后在回调函数里删除选择的行
            roleGrid.deleteSelectedRow();
        }
    });
}
//角色和菜单挂接的方法
function role_menu_join() {
    if (!roleGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要赋予权限的角色.');
        return;
    }
    //var row = roleGrid.getSelected();
    //todo tree需要发送上面获取row的信息到服务器，返回来一系列的数据来生成
    joinTree = $('<ul></ul>');
    joinTree.ligerTree({
        data:[
            {
                text:'test1',
                children:[
                    {
                        text:'test2',
                        ischecked:true
                    },
                    {
                        text:'test3'
                    }
                ]
            }
        ]
    });
    treeManager = joinTree.ligerGetTreeManager();
    roleWin = $.ligerDialog.open({
        width:400,
        height:400,
        title:'权限赋予',
        target:joinTree,
        buttons:[
            {text:'提交', width:80, onclick:join_save},
            {text:'取消', width:80, onclick:join_cancel}
        ]
    });
}
function join_save(){
    //todo ajax发送数据后返回成功消息即可
    var checked = treeManager.getChecked();
    var len = checked.length;
    var data = "";
    for(var i = 0; i < len; i++){
        data  += checked[i].data.text;
    }
    //console.log(data);
    roleWin.close();
}
function join_cancel(){
    roleWin.close();
}
//初始化表单，生成form标签
function formInit() {
    roleForm = $('<form></form>');
    roleForm.ligerForm({
        inputWidth:280,
        fields:[
            {
                name:'id',
                display:'ID',
                type:'text',
                space:30,
                labelWidth:100,
                newline:true,
                width:220
            },
            {
                display:'角色名称',
                name:'name',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    required:true,
                    maxlength:50
                }
            },
            {
                display:'创建用户',
                name:'createUser',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    required:true,
                    maxlength:50
                }
            },
            {
                display:'备注',
                name:'remark',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    required:true,
                    maxlength:50
                }
            }
        ]
    });
}
//初始化表格
$(function () {
    var toolbarItems = [
        {text:'新增角色', click:add_role, icon:'add', key:'add'},
        {text:'修改角色', click:edit_role, icon:'modify', key:'edit'},
        {text:'删除角色', click:delete_role, icon:'delete', key:'delete'},
        {line:true },
        {text:'权限赋予', click:role_menu_join, icon:'config', key:'join'}
    ];
    //todo 以后这个ajaxToolbar要通过ajax取过来
    var ajaxToolbar = [
        {name:'add'},
        {name:'edit'},
        {name:'delete'},
        {name:'join'}
    ];
    toolbarItems = Toolbar.confirmToolbar(toolbarItems, ajaxToolbar);
    roleGrid = $('#roleGrid').ligerGrid({
        columns:[
            { display:'ID', name:'id', align:'left', width:100 },
            { display:'角色名称', name:'name', width:200 },
            //todo 注意这里是createUser，后台需要处理好user的名字后再显示到前台
            { name:'createUserId', hide:true },
            { display:'创建用户', name:'createUser', width:200 },
            { display:'备注', name:'remark', align:'left', width:400 }
        ],
        width:'99%',
        height:'98%',
        pageSize:30,
        url:'../../../Json/RoleData.json',
        toolbar:{
            items:toolbarItems
        }
    });
    $("#pageloading").hide();
});