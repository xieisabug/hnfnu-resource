var newsGrid = null;// 新闻表格
var sortForm = null;// 新闻排序表单
var sortFormWin = null;// 新闻排序窗口
// 增加新闻的函数,实际上就是增加一个tab
function add_news(tabid, text, url) {
    var tabid = "add_news", text = "新增新闻", url = "App/Website/News/NewsEditor.html";
    window.parent.window.f_addTab(tabid, text, url);
}

// 修改新闻的函数
function edit_news() {
    if (!newsGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    var row_data = newsGrid.getSelected();
    var tabid = "update_news", text = "修改新闻", url = "App/Website/News/NewsUpdateEditor.html?id="+row_data.id;
    window.parent.window.f_addTab(tabid, text, url);
}

// 删除新闻的函数
function delete_news() {
    if (!newsGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = newsGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.title + '？', '删除新闻', function (r) {
        if (r) {
            $.ajax({
                url:'../../../website/deleteNews.action',
                data:{
                    "id":row_data.id,
                    "content":row_data.content
                },
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        newsGrid.deleteSelectedRow();
                        //parameterWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}

// 刷新新闻的函数
function refresh_news() {
    $.ajax( {
        url : '../../../website/listNews.action',
        type : 'post',
        success : function(data) {
            newsGrid.loadData(data.newsList);
        }
    });
    $("#pageloading").hide();
}

//给新闻指定排序
function sort_news(){
    if (!newsGrid.getSelected()) {
        $.ligerDialog.warn("请选择您要修改的行！");
        return;
    }
    sortFormInit();
    //Form.loadForm(sortForm, newsGrid.getSelected());
    sortFormWin = $.ligerDialog.open({
        width : 400,
        height : 100,
        title : "新闻排序:"+newsGrid.getSelected().title,
        target : sortForm,
        buttons : [ {
            text : "提交",
            width : 80,
            onclick : sort_save
        }, {
            text : "取消",
            width : 80,
            onclick : sort_cancel
        } ]
    });
}

function sortFormInit(){
    var priorityList = [
        {
            priority:'1',
            num : 1
        },
        {
            priority:'2',
            num : 2
        },
        {
            priority:'3',
            num : 3
        },
        {
            priority:'4',
            num : 4
        },
        {
            priority:'5',
            num : 5
        },
        {
            priority:'6',
            num : 6
        }
    ];

    sortForm = $('<form></form>');
    sortForm.ligerForm({
        inputWidth : 200,
        labelWidth : 90,
        space : 40,
        fields : [{
            display : "优先级列表",
            name : "priorityList",
            type : "select",
            //value : newsGrid.getSelected().priority,
            //comboboxName : "priority",
            options : {
                textField : "priority",
                valueField : "num",
                initValue : newsGrid.getSelected().priority,
                initText : newsGrid.getSelected().priority,
                hideOnLoseFocus:true,
                isMultiSelect : false,
                isShowCheckBox : false,
                valueFieldID : "priorityList",
                data : priorityList
            }
        } ]
    });
}

function sort_save(){
    if (sortForm.valid()) {
        var row_data = Form.parseJSON(sortForm);
        var send = newsGrid.getSelected();
        send.priority = row_data.priorityList;
//        console.log(row_data);
//        console.log(send);
        // 发往服务器，返回成功后再修改到表格中
        $.ajax({
            url : '../../../website/sortNews.action',
            data : send,
            type : 'post',
            success : function(data) {
//                console.log(data);
                if (data.success) {
                    refresh_news();
                    $.ligerDialog.tip({title:'提示信息', content:data.message});
                    sortFormWin.close();
                }else{
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}

function sort_cancel() {
    sortFormWin.close();
}

// 初始化表格
$(function () {
    var toolbarItems = [
        {
            text:'新增新闻',
            click:add_news,
            icon:'add',
            key:'add'
        },
        {
            text:'修改新闻',
            click:edit_news,
            icon:'modify',
            key:'modify'
        },
        {
            text:'删除新闻',
            click:delete_news,
            icon:'delete',
            key:'delete'
        },
        {
            text:'刷新新闻',
            click:refresh_news,
            icon:'refresh',
            key:'refresh'
        },
        {
            text:'显示排序',
            click:sort_news,
            icon:'modify',
            key:'sort'
        }
    ];
    var menuId = window.parent.tab.getSelectedTabItemID();
    $.ajax({
        url:'../../../system/listFunctionIdList.action',
        type:'post',
        data:{
            menuId:menuId.substr(0, menuId.indexOf("t"))
        },
        success:function (data) {
            var idList = data.functionIdList.split(";");
            var ajaxToolbar = [];
            for (var i = 0; i < idList.length; i++) {
                ajaxToolbar.push({name:parent.hnfnu.functionList[idList[i]]});
            }
            toolbarItems = Toolbar.confirmToolbar(toolbarItems, ajaxToolbar);
        }
    });

    $.ajax({
        url:'../../../website/listNews.action',
        type:'post',
        success:function (data) {
//            console.log(data);
            newsGrid = $('#newsGrid').ligerGrid({
                columns:[
                    // { display:'ID', name:'id', align:'left', width:100 },
                    
                    {
                        display:'新闻名称',
                        name:'title',
                        width:200
                    },
                    {
                    	display:'日期',
                        name:'date',
                        align:'left',
                        width:100
                    },
                    {
                        display:'优先级',
                        name:'priority',
                        align:'center',
                        width:100
                    }
                ],
                width:'99%',
                height:'98%',
                usePager:false,
                data:data.newsList,
                toolbar:{
                    items:toolbarItems
                },
            rowAttrRender:function (rowdata) {
                if (rowdata.date) {
                    rowdata.date = rowdata.date.substring(0, 10);
                }
                return;
            }
            });
            $("#pageloading").hide();
        }
    });
});