var parameterGrid = null;//功能表格
var parameterForm = null;//功能表单
var parameterWin = null;//功能窗口
var id = 5000;

//增加功能的函数
function add_parameter() {
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
    if (parameterForm.valid()) {
        var row_data = Form.parseJSON(parameterForm);
        $.ajax({
            url:'../../../system/addParameter.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    parameterGrid.addRow(data.model);
                    $.ligerDialog.tip({title:'提示信息', content:data.message});
                    parameterWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
//增加功能的取消按钮事件
function add_cancel() {
    parameterWin.close();
}
//修改功能的函数
function edit_parameter() {
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
    if (parameterForm.valid()) {
        var row_data = Form.parseJSON(parameterForm);
        $.ajax({
            url:'../../../system/updateParameter.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    parameterGrid.update(parameterGrid.getSelected(), data.model);
                    $.ligerDialog.tip({title:'提示信息', content:data.message});
                    parameterWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
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
    var row_data = parameterGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除功能', function (r) {
        if (r) {
            $.ajax({
                url:'../../../system/deleteParameter.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({title:'提示信息', content:data.message});
                        parameterGrid.deleteSelectedRow();
                        parameterWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}
//初始化表单，生成form标签
function formInit() {
    parameterForm = $('<form id="Form' + id + '"></form>');
    parameterForm.ligerForm({
        options:{
            id:id
        },
        inputWidth:280,
        fields:[
            {
                name:'id',
                type:'hidden'
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
                	required: true,
                    maxlength:100
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
                	required: true,
                    maxlength:20
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
                    hideOnLoseFocus:true,
                    data:[
                        {"id":0, "text":"array", "value":"array"},
                        {"id":1, "text":"number", "value":"number"},
                        {"id":2, "text":"string", "value":"string"}
                    ],
                    initValue:"array",
                    initText:"array"
                },
                validate:{
                    maxlength:20
                }
            },
            {
                display:'备注',
                name:'remark',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true
            }
        ]
    });
    id++;
    $.metadata.setType("attr", "validate");
    parameterForm.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error,element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
}
//初始化表格
$(function () {
    var toolbarItems = [
        {text:'新增参数', click:add_parameter, icon:'add', key:'add'},
        {text:'修改参数', click:edit_parameter, icon:'modify', key:'modify'},
        {text:'删除参数', click:delete_parameter, icon:'delete', key:'delete'}
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
        url:'../../../system/listParameter.action',
        type:'post',
        success:function (data) {
            parameterGrid = $('#parameterGrid').ligerGrid({
                columns:[
                    //{ display:'ID', name:'id', align:'left', width:100 },
                    { display:'参数名称', name:'name', width:200 },
                    { display:'参数值', name:'value', width:200 },
                    { display:'参数类型', name:'type', width:200 },
                    { display:'备注', name:'remark', align:'left', width:400 }
                ],
                width:'99%',
                height:'98%',
                pageSize:30,
                data:data.parameterList,
                toolbar:{
                    items:toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});