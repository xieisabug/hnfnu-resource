var functionGrid = null;
function add_function() {
    $.ligerDialog.open({
        width:500,
        height:500,
        title:'新增功能',
        url:'FunctionAdd.html',
        buttons:[
            {text:'提交',width:80,onclick:function(a,b,c){console.log(a);console.log(b);console.log(c);}}
        ]
    });
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