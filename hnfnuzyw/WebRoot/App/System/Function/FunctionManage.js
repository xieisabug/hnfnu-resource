var functionGrid = null;//功能表格
var functionForm = null;//功能表单
var functionWin = null;//功能窗口

//增加功能的函数
function add_function() {
    formInit();
    functionWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'新增功能',
        target:functionForm,
        buttons:[
            {text:'提交', width:80, onclick:add_save},
            {text:'取消', width:80, onclick:add_cancel}
        ]
    });
}
//增加功能的保存按钮事件
function add_save() {
    var data = Form.parseJSON(functionForm);
    //todo 需要发往服务器，返回成功后再添加到表格中
    functionGrid.addRow(data);
    functionWin.close();
}
//增加功能的取消按钮事件
function add_cancel() {
    functionWin.close();
}
//修改功能的函数
function edit_function() {
    formInit();
    if (!functionGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(functionForm, functionGrid.getSelected());
    functionWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'编辑功能',
        target:functionForm,
        buttons:[
            {text:'提交', width:80, onclick:edit_save},
            {text:'取消', width:80, onclick:edit_cancel}
        ]
    });
}
//修改功能的保存按钮事件
function edit_save() {
    var data = Form.parseJSON(functionForm);
    //todo 需要发往服务器，返回成功后再修改到表格中
    functionGrid.update(functionGrid.getSelected(), data);
    functionWin.close();
}
//修改功能的取消按钮事件
function edit_cancel() {
    functionWin.close();
}
//删除功能的函数
function delete_function() {
    if (!functionGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row = functionGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row.name + '？', '删除功能', function (r) {
        if (r) {
            //todo 进行ajax操作，成功后在回调函数里删除选择的行
            functionGrid.deleteSelectedRow();
        }
    });
}
//初始化表单，生成form标签
function formInit() {
    functionForm = $('<form></form>');
    functionForm.ligerForm({
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
                display:'功能名称',
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
        {text:'新增功能', click:add_function, icon:'add', key:'add'},
        {text:'修改功能', click:edit_function, icon:'modify', key:'modify'},
        {text:'删除功能', click:delete_function, icon:'delete', key:'delete'}
    ];
    //todo 以后这个ajaxToolbar要通过ajax取过来
    var ajaxToolbar = [
        {name:'add'},
        {name:'delete'}
    ];
    toolbarItems = Toolbar.confirmToolbar(toolbarItems,ajaxToolbar);
    functionGrid = $('#functionGrid').ligerGrid({
        columns:[
            { display:'ID', name:'id', align:'left', width:100 },
            { display:'功能名称', name:'name', width:200 },
            { display:'备注', name:'remark', align:'left', width:400 }
        ],
        width:'99%',
        height:'98%',
        pageSize:30,
        url:'../../../Json/FunctionData.json',
        toolbar:{
            items:toolbarItems
        }
    });
    $("#pageloading").hide();
});