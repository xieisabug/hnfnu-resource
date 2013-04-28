var grid = null;
var addMenuForm = null;
var menuFormWin = null;
//按钮的click事件
function itemclick(item) {
    $.ligerDialog.alert(item.text);
}

function add_menu() {
    var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
    if (!addMenuForm) {
        addMenuForm = $('<form></form>');
        addMenuForm.ligerForm(
            {
                inputWidth:170,
                labelWidth:90,
                space:40,
                fields:[
                    {name:"id", type:"hidden"},
                    {display:"菜单名字", name:"name", newline:true, type:"text", group:"必填信息", groupicon:groupicon},
                    {display:"菜单链接", name:"url", newline:false, type:"text"},
                    {display:"功能列表", name:"functionId", type:"select", comboboxName:"functionIdList", options:{valueFieldID:"functionId", url:"../../../Json/Function.json"}},
                    {display:"图标链接", name:"icon", type:"text", group:"可选信息", groupicon:groupicon},
                    {display:"上级菜单", name:"parentId", type:"select", comboboxName:"parentIdList", options:{valueFieldID:"parentId", url:"../../../Json/ParentMenu.json"}}
                ]
            }
        );
    }
    menuFormWin = $.ligerDialog.open(
        {
            width:500,
            height:500,
            title:"新增菜单",
            target:addMenuForm,
            buttons:[
                {text:"提交", width:80, onclick:add_save}
            ]
        }
    );
}

function add_save() {
    //把表单转化为数组
    var data = Form.parseJSON(addMenuForm);
    grid.addRow(data);
    menuFormWin.close();
}


//创建add表单

/*function addform(){
 var groupicon = "../../../App/Lib/ligerUI/skins/icons/communication.gif";
 $("" +
 "").ligerForm({
 inputWidth:170,labelWidth:90,space:40,
 fields:[
 {name:"id",type:"hidden"},
 {display:"菜单名字",name:"name",newline:true,type:"text",group:"必填信息",groupicon:groupicon},
 {display:"菜单链接",name:"url",newline:false,type:"text"},
 {display:"功能列表",name:"functionIdList",type:"select",comboboxName:"functionComBox",options:{valueFieldID:"id",url:"../../../Json/Function.json"}},
 {display:"图标链接",name:"icon",type:"text",group:"可选信息",groupicon:groupicon},
 {display:"上级菜单",name:"parentId",type:"select",comboboxName:"menuCombox",options:{valueFieldID:"id",url:"../../../Json/ParentMenu.json"}}
 ]
 });
 }*/


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