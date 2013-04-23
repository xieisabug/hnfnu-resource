function add_function(){
    $.ligerDialog.alert('add');
}
function edit_function(){
    $.ligerDialog.alert('edit');
}
function delete_function(){
    $.ligerDialog.confirm('确认删除？');
}
$(function () {
    $('#functionGrid').ligerGrid({
        columns:[
            { display: 'ID', name: 'id', align: 'left', width: 100 },
            { display: '功能名称', name: 'name', width: 200 },
            { display: '备注', name: 'remark', align: 'left', width: 400 }
        ],
        width:'90%',
        height:'90%',
        toolbar:{
            items:[
                {text:'新增功能',click:add_function,icon:'add'},
                {text:'修改功能',click:edit_function,icon:'modify'},
                {text:'删除功能',click:delete_function,icon:'delete'}
            ]
        }
    });
});