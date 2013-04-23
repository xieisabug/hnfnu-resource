var grid = null;

function itemclick(item) {
    $.ligerDialog.alert(item.text);
}

$(function () {
    grid = $("#menuGrid").ligerGrid({
        columns:[
            {display:'菜单id', name:'id', align:'left', width:120},
            {display:'菜单名字', name:'name', align:'left', minWidth:80},
            {display:'菜单链接', name:'url', align:'left', minWidth:120},
            {display:'功能列表', name:'functionIdList', align:'left', minWidth:100},
            {display:'图标链接', name:'icon', align:'left', minWidth:120},
            {display:'上级菜单', name:'parentId', align:'left', minWidth:100}
        ],
        url:'../../../Json/MenuData.json',
        height:'100%', width:'100%',
        toolbar:{
            items:[
                {text:'增加', click:itemclick, icon:'add' },
                { line:true },
                {text:'删除', click:itemclick, icon:'delete'},
                {line:true},
                {text:'修改', click:itemclick, icon:'modify'},
                {line:true},
                {text:'刷新', click:itemclick, icon:'refresh'}
            ]
        }
    });
    //$("#pageloading").hide();
});