var categoryGrid = null;// 类别表格
var sortGrid = null;//用于排序的类别表格
var sortWin = null;//用于显示排序的类别的窗口
var categoryFrom = null;// 类别表单
var categoryWin = null;// 类别窗口

// 增加类别的函数
function add_catecory() {
    formInit();
    categoryWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'新增类别',
        target:categoryFrom,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:add_save
            },
            {
                text:'取消',
                width:80,
                onclick:add_cancel
            }
        ]
    });
}
// 增加类别的保存按钮事件
function add_save() {
    if (categoryFrom.valid()) {
        var row_data = Form.parseJSON(categoryFrom);
        if (row_data.groupId == "" || row_data.groupId == null) {
            $.ligerDialog.error("未选择分组");
            return;
        }
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../resources/addCategory.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    refresh_category();
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    categoryWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加类别的取消按钮事件
function add_cancel() {
    categoryWin.close();
}
// 修改类别的函数
function edit_category() {
    formInit();
    if (!categoryGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(categoryFrom, categoryGrid.getSelected());
    categoryWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'编辑类别',
        target:categoryFrom,
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
// 修改类别的保存按钮事件
function edit_save() {
    if (categoryFrom.valid()) {
        var row_data = Form.parseJSON(categoryFrom);
        $.ajax({
            url:'../../../resources/updateCategory.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    refresh_category();
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    categoryWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 修改类别的取消按钮事件
function edit_cancel() {
    categoryWin.close();
}

// 删除类别的函数
function delete_category() {
    if (!categoryGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = categoryGrid.getSelected();
    $.ligerDialog.warn('<p style="color:red;font-weight: bolder;">（警告：删除此类别后，类别下所有不同时属于其它类别的资源会全部删除。）</p>确认删除' + row_data.name + '？', '删除类别', function (r) {
        if (r) {
            $.ajax({
                url:'../../../resources/deleteCategory.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        refresh_category();
                        categoryWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}

//排序类别
function sort_category() {
    $.ajax({
        url:'../../../resources/listCategoryOrder.action',
        type:'post',
        success:function (data) {
            var s = $('#sortGrid');
            sortGrid = s.ligerGrid({
                columns:[
                    {
                        display:'类别名称',
                        name:'name',
                        width:200
                    }
                ],
                width:250,
                height:400,
                pageSize:30,
                data:data.categoryList,
                rownumbers:true,
                rowDraggable:true
            });
            sortWin = $.ligerDialog.open({
                width:300,
                height:400,
                title:'类别排序',
                target:s,
                buttons:[
                    {
                        text:'提交',
                        width:80,
                        onclick:sort_save
                    },
                    {
                        text:'取消',
                        width:80,
                        onclick:sort_cancel
                    }
                ]
            });
            //console.log($(".l-grid2",categoryWin.element));
            $(".l-grid2",sortWin.element).css({width:223});
            $("#pageloading").hide();
        }
    });
}

function sort_save(){
    var objArray = sortGrid.getData();
    var ids = "";
    for(var i = 0; i < objArray.length; i++){
        ids += objArray[i].id + ';';
    }
    $.ajax({
        url:'../../../resources/categoryOrder.action',
        type:'post',
        data : {
            orders : ids
        },
        success:function (data) {
            if (data.success) {
                $.ligerDialog.tip({
                    title:'提示信息',
                    content:data.message
                });
                sortWin.hide();
            } else {
                $.ligerDialog.error(data.message);
            }
        }
    });
}

function sort_cancel(){
    sortWin.hide();
}
// 刷新分组的函数
function refresh_category() {
    $.ajax({
        url:'../../../resources/listCategory.action',
        type:'post',
        success:function (data) {
            categoryGrid.loadData(data.categoryList);
        }
    });
    $("#pageloading").hide();

}

// 初始化表单，生成form标签
function formInit() {
    categoryFrom = $('<form></form>');
    $.ajax( {
        url : '../../../resources/listGroups.action',
        type : 'post',
        async : false,
        success : function(data) {
            categoryFrom.ligerForm({
                inputWidth:280,
                fields:[
                    {
                        name:'id',
                        type:"hidden"
                    },
                    {
                        display:'类别名称',
                        name:'name',
                        type:'text',
                        space:30,
                        labelWidth:100,
                        width:220,
                        newline:true,
                        validate:{
                            required:true,
                            maxlength:22
                        }
                    },
                    {
                        display:"所属分组",
                        name:"groupId",
                        type:"select",
                        space:30,
                        labelWidth:100,
                        width:220,
                        newline:true,
                        comboboxName:"group",
                        options:{
                            textField:"name",
                            valueField:"id",
                            hideOnLoseFocus:true,
                            valueFieldID:"groupId",
                            data:data.groups
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
            $.metadata.setType("attr", "validate");
            categoryFrom.validate({
                debug:true,
                onkeyup:false,
                errorPlacement:function (error, element) {
                    error.appendTo(element.parent().parent().parent().parent());
                }
            });
        }
    });



}
// 初始化表格
$(function () {
    var toolbarItems = [
        {
            text:'新增类别',
            click:add_catecory,
            icon:'add',
            key:'add'
        },
        {
            text:'修改类别',
            click:edit_category,
            icon:'modify',
            key:'modify'
        },
        {
            text:'删除类别',
            click:delete_category,
            icon:'delete',
            key:'delete'
        },
        {
            text:'排序类别',
            click:sort_category,
            icon:'modify',
            key:'sort'
        }
    ];
    var menuId = window.parent.tab.getSelectedTabItemID();
    $.ajax({
        async: false,
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
        url:'../../../resources/listCategory.action',
        type:'post',
        success:function (data) {
            categoryGrid = $('#categoryGrid').ligerGrid({
                columns:[
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display:'类别名称',
                        name:'name',
                        width:200
                    },
                    {
                        display:'备注',
                        name:'remark',
                        align:'left',
                        width:800
                    }
                ],
                width:'99%',
                height:'98%',
                pageSize:30,
                groupColumnName:'groupName',
                groupColumnDisplay:'分组',
                data:data.categoryList,
                toolbar:{
                    items:toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});