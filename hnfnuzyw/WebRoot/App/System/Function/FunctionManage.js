var functionGrid = null;
var addFunctionForm = null;
var functionWin = null;

function add_function() {
    if(!addFunctionForm){
        addFunctionForm = $('<form></form>');
        addFunctionForm.ligerForm({
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
    } else {
        addFunctionForm[0].reset();
    }
    functionWin = $.ligerDialog.open({
        width:500,
        height:500,
        title:'新增功能',
        target:addFunctionForm,
        buttons:[
            {text:'增加', width:80, onclick:add_save},
            {text:'取消', width:80, onclick:add_cancel}
        ]
    });
}
function add_save() {
    var data, form = addFunctionForm.formToArray();
    var row = functionGrid.getSelectedRow(), len = form.length;
    data = '{';
    for (var i = 0; i < len; i++) {
        data += '"' + form[i].name + '"' + ':"' + form[i].value + '"';
        if (i != len - 1) {
            data += ',';
        }
    }
    data += '}';
    functionGrid.addRow($.parseJSON(data));
    functionWin.close();
}
function add_cancel() {
    functionWin.close();
}
function edit_function() {
    $.ligerDialog.alert('edit');
}
function delete_function() {
    var row = functionGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row.name + '？', '删除功能', function (r) {
        if (r) {
            //todo 进行ajax操作，成功后在回调函数里删除选择的行
            functionGrid.deleteSelectedRow();
        }
    });
}
$(function () {
    functionGrid = $('#functionGrid').ligerGrid({
        columns:[
            { display:'ID', name:'id', align:'left', width:100 },
            { display:'功能名称', name:'name', width:200 },
            { display:'备注', name:'remark', align:'left', width:400 }
        ],
        width:'99%',
        height:'95%',
        pageSize:30,
        url:'../../../Json/FunctionData.json',
        toolbar:{
            items:[
                {text:'新增功能', click:add_function, icon:'add'},
                {text:'修改功能', click:edit_function, icon:'modify'},
                {text:'删除功能', click:delete_function, icon:'delete'}
            ]
        }
    });
    $("#pageloading").hide();
});