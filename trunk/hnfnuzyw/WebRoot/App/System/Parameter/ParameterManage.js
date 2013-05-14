var parameterGrid = null;//功能表格
var parameterForm = null;//功能表单
var parameterWin = null;//功能窗口
var id = 5000;

//增加功能的函数
function add_parameter() {
/*
    if (!parameterForm) {
        formInit();
    } else {
        parameterForm[0].reset();
    }
*/
    formInit();
    parameterWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'新增功能',
        target:parameterForm,
        buttons:[
            {text:'提交', width:80, onclick:add_save},
            {text:'取消', width:80, onclick:add_cancel}
        ]
    });
}
//增加功能的保存按钮事件
function add_save() {
    var data = Form.parseJSON(parameterForm);
    //todo 需要发往服务器，返回成功后再添加到表格中
    parameterGrid.addRow(data);
    parameterWin.close();
}
//增加功能的取消按钮事件
function add_cancel() {
    parameterWin.close();
}
//修改功能的函数
function edit_parameter() {
    /*
    if (!parameterForm) {
     formInit();
     }
     */
    formInit();
    if (!parameterGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(parameterForm, parameterGrid.getSelected());
    parameterWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'编辑功能',
        target:parameterForm,
        //isHidden:false,
        buttons:[
            {text:'提交', width:80, onclick:edit_save},
            {text:'取消', width:80, onclick:edit_cancel}
        ]
    });
}
//修改功能的保存按钮事件
function edit_save() {
    var data = Form.parseJSON(parameterForm);
    //console.log(data);
    //todo 需要发往服务器，返回成功后再修改到表格中
    parameterGrid.update(parameterGrid.getSelected(), data);
    parameterWin.close();
}
//修改功能的取消按钮事件
function edit_cancel() {
    parameterWin.close();
}
//删除功能的函数
function delete_parameter() {
    if (!parameterGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row = parameterGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row.name + '？', '删除功能', function (r) {
        if (r) {
            //todo 进行ajax操作，成功后在回调函数里删除选择的行
            parameterGrid.deleteSelectedRow();
        }
    });
}
//初始化表单，生成form标签
function formInit() {
    parameterForm = $('<form id="Form'+id+'"></form>');
    parameterForm.ligerForm({
        options:{
            id:id
        },
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
                display:'参数名称',
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
                display:'参数值',
                name:'value',
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
                display:'参数类型',
                name:'type',
                type:'select',
                comboboxName:'typeList',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                options:{
                    valueFieldID:"type",
                    valueField:"value",
                    data:[
                        {"id":0,"text":"array","value":"array"},
                        {"id":1,"text":"number","value":"number"},
                        {"id":2,"text":"string","value":"string"}
                    ]
                },
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
    id++;
    //console.log(parameterForm);
}
//初始化表格
$(function () {
    var toolbarItems = [
        {text:'新增参数', click:add_parameter, icon:'add', key:'add'},
        {text:'修改参数', click:edit_parameter, icon:'modify', key:'edit'},
        {text:'删除参数', click:delete_parameter, icon:'delete', key:'delete'}
    ];
    //todo 以后这个ajaxToolbar要通过ajax取过来
    var ajaxToolbar = [
        {name:'add'},
        {name:'edit'},
        {name:'delete'}
    ];
    toolbarItems = Toolbar.confirmToolbar(toolbarItems,ajaxToolbar);
    parameterGrid = $('#parameterGrid').ligerGrid({
        columns:[
            { display:'ID', name:'id', align:'left', width:100 },
            { display:'参数名称', name:'name', width:200 },
            { display:'参数值', name:'value', width:200 },
            { display:'参数类型', name:'type', width:200 },
            { display:'备注', name:'remark', align:'left', width:400 }
        ],
        width:'99%',
        height:'98%',
        pageSize:30,
        url:'../../../Json/ParameterData.json',
        toolbar:{
            items:toolbarItems
        }
    });
    $("#pageloading").hide();
});