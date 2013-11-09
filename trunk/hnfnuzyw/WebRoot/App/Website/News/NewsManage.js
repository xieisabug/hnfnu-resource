var newsGrid = null;// 新闻表格
var newsFrom = null;// 新闻表单
var newsWin = null;// 新闻窗口

/*增加tab项的函数
function f_addTab(tabid, text, url) {
    if (!tab) return;
    if (!tabid) {
        tabidcounter++;
        tabid = "tabid" + tabidcounter;
    }
    tab.addTabItem({ tabid:tabid, text:text, url:url });
}*/






// 增加新闻的函数,实际上就是增加一个tab
function add_news(tabid, text, url) {
    if (!tab) return;
    if (!tabid) {
        tabidcounter++;
        tabid = "tabid" + tabidcounter;
    }
    tab.addTabItem({ tabid:tabid, text:text, url:url });
}
// 增加新闻的保存按钮事件
function add_save() {
    if (newsFrom.valid()) {
        var row_data = Form.parseJSON(newsFrom);

        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../system/addFunction.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    newsGrid.addRow(data.model);
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    newsWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加新闻的取消按钮事件
function add_cancel() {
    newsWin.close();
}
// 修改新闻的函数
function edit_news() {
    formInit();
    if (!newsGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(newsFrom, newsGrid.getSelected());
    newsWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'编辑新闻',
        target:newsFrom,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:edit_save
            },
            {
                text:'取消',
                width:80,
                onclick:edit_cancel
            }
        ]
    });
}
// 修改新闻的保存按钮事件
function edit_save() {
    if (newsFrom.valid()) {
        var row_data = Form.parseJSON(newsFrom);
        // todo 需要发往服务器，返回成功后再修改到表格中
        $
            .ajax({
                url:'../../../system/updateFunction.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        newsGrid.update(newsGrid.getSelected(),
                            data.model);
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        newsWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
    }
}
// 修改新闻的取消按钮事件
function edit_cancel() {
    newsWin.close();
}

// 删除新闻的函数
function delete_news() {
    if (!newsGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = newsGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除新闻', function (r) {
        if (r) {
            $.ajax({
                url:'../../../system/deleteFunction.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        newsGrid.deleteSelectedRow();
                        parameterWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}
// 初始化表单，生成form标签
function formInit() {
    newsFrom = $('<form></form>');
    newsFrom.ligerForm({
        inputWidth:280,
        fields:[
            {
                name:'id',
                type:"hidden"
            },
            {
                display:'新闻名称简写',
                name:'name',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    required:true,
                    maxlength:20
                }
            },
            {
                display:'新闻名称',
                name:'remark',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    required:true,
                    maxlength:20
                }
            }
        ]
    });
    $.metadata.setType("attr", "validate");
    newsFrom.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error, element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
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
        url:'../../../system/listFunction.action',
        type:'post',
        success:function (data) {
            newsGrid = $('#newsGrid').ligerGrid({
                columns:[
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display:'新闻名称简写',
                        name:'name',
                        width:200
                    },
                    {
                        display:'新闻名称',
                        name:'remark',
                        align:'left',
                        width:400
                    }
                ],
                width:'99%',
                height:'98%',
                usePager:false,
                data:data.functionList,
                toolbar:{
                    items:toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});