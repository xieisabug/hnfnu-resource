var grid = null;

$(function(){
        grid = $("menugrid").ligerGrid({
            columns:[
                {display:'菜单id',name:'id',align:'left',width:120},
                {display:'菜单名字',name:'name',align:'left',minWidth:80},
                {display:'菜单链接',name:'url',align:'left',minWidth:80},
                {display:'功能列表',name:'functionIdList',align:'left',minWidth:100},
                {display:'图标链接',name:'' }
            ]
        });
    }
);