var grid = null;
var addMenuForm = null;
var menuFormWin = null;
//按钮的click事件
function itemclick(item) {
    $.ligerDialog.alert(item.text);
}
//增加菜单的函数
function add_menu() {

    if (!addMenuForm) {
       formInit();
    }else{
        addMenuForm[0].reset();
    }

    menuFormWin = $.ligerDialog.open(
        {
            width:400,
            height:400,
            title:"新增菜单",
            target:addMenuForm,
            buttons:[
                {text:"提交", width:80, onclick:add_save},
                {text:"取消", width:80, onclick:add_cancel}
            ]
        }
    );
}
//增加菜单的保存按钮事件
function add_save() {
    //把表单转化为数组
    var data = Form.parseJSON(addMenuForm);
    //todo 需要发往服务器，返回成功后再添加到表格中
    grid.addRow(data);
    menuFormWin.close();
}
//增加菜单的取消按钮事件
function add_cancel() {
    menuFormWin.close();
}


//删除菜单的函数
function delete_menu() {
    if (!grid.getSelected()) {
        $.ligerDialog.warn("请选择您要删除的行！");
        return;
    }
    var row = grid.getSelected();
    $.ligerDialog.confirm('确认删除' + row.name + '?', '删除功能', function (r) {
        if (r) {
            //todo 进行ajax操作，成功后在回调函数里删除选择的行
            grid.deleteSelectedRow();
        }
    });

}

//修改菜单的函数
function edit_menu() {
    if (!addMenuForm) {
        formInit();
    }
    if (!grid.getSelected()) {
        $.ligerDialog.warn("请选择您要修改的行！");
        return;
    }
    //这个函数的参数为：form，data，作用就是把data放到from
    Form.loadForm(addMenuForm, grid.getSelected());
    menuFormWin = $.ligerDialog.open({
        width:400,
        height:400,
        title:"修改菜单",
        target:addMenuForm,
        buttons:[
            {text:"提交", width:80, onclick:edit_save},
            {text:"取消", width:80, onclick:edit_cancel}
        ]

    });
}
function edit_save() {
    var data = Form.parseJSON(addMenuForm);
    //todo 需要发往服务器，返回成功后再修改到表格中
    grid.update(grid.getSelected(), data);
    menuFormWin.close();
}
function edit_cancel() {
    menuFormWin.close();
}
//初始化表单，生成form标签
function formInit() {
    var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
    addMenuForm = $('<form></form>');
    addMenuForm.ligerForm(
        {
            inputWidth:200,
            labelWidth:90,
            space:40,
            fields:[
                {name:"id", type:"hidden"},
                {display:"菜单名字", name:"name", newline:true, type:"text", group:"必填信息", groupicon:groupicon},
                {display:"菜单链接", name:"url", newline:true, type:"text"},
                {display:"功能列表", name:"functionId", type:"select", comboboxName:"functionIdList", options:{valueFieldID:"functionId", url:"../../../Json/Function.json"}},
                {display:"图标链接", name:"icon", type:"text", group:"可选信息", groupicon:groupicon},
                {display:"上级菜单", name:"parentId", type:"select", comboboxName:"parentIdList", options:{valueFieldID:"parentId", url:"../../../Json/ParentMenu.json"}}
            ]
        }
    );
}

//页面加载完成后就开始调用
$(function () {
    grid = $("#menuGrid").ligerGrid({
        columns:[
            {display:'菜单id', name:'id', align:'left', width:120},
            {display:'菜单名字', name:'name', align:'left', minWidth:80},
            {display:'菜单链接', name:'url', align:'left', minWidth:120},
            {display:'功能列表', name:'functionId', align:'left', minWidth:100},
            {display:'图标链接', name:'icon', align:'left', minWidth:120},
            {display:'上级菜单', name:'parentId', align:'left', minWidth:100}
        ],
        url:'../../../Json/MenuData.json',
        height:'100%', width:'100%',
        toolbar:{
            items:[
                {text:'增加', click:add_menu, icon:'add' },
                { line:true },
                {text:'删除', click:delete_menu, icon:'delete'},
                {line:true},
                {text:'修改', click:edit_menu, icon:'modify'},
                {line:true},
                {text:'刷新', click:itemclick, icon:'refresh'}
            ]
        }
    });
    //$("#pageloading").hide();
});