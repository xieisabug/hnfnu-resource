var picturesGrid = null;// 图片表格
var picturesForm = null;// 图片表单
var picturesWin = null;// 图片窗口

// 增加图片的函数
function add_pictures() {
    picturesWin = $.ligerDialog.open({
        width:400,
        height:300,
        title:'添加图片',
        url:'AddForm.html',
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
// 增加图片的保存按钮事件
function add_save() {
    picturesForm = picturesWin.frame.fileForm;

    if (picturesForm.valid()) {
        var row_data = Form.parseJSON(picturesForm);

        if (row_data.src == "" || row_data.src == null) {
            $.ligerDialog.error("未上传文件");
            return;
        }

        if (row_data.link == "" || row_data.link == null) {
            $.ligerDialog.error("未填写图片的链接地址");
            return;
        }

        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../website/addPictures.action',
            data:{
                src:row_data.src,
                link:row_data.link,
                show:row_data.show,
                remark:row_data.remark
            },
            type:'post',
            success:function (data) {
                if (data.success) {
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    refresh_pictures();
                    picturesWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加图片的取消按钮事件
function add_cancel() {
    picturesWin.close();
}
// 修改图片的函数
function edit_pictures() {
    formInit();
    if (!picturesGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(picturesForm, picturesGrid.getSelected());
    picturesWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'编辑图片',
        target:picturesForm,
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
// 修改图片的保存按钮事件
function edit_save() {
    if (picturesForm.valid()) {
        var row_data = Form.parseJSON(picturesForm);
        // todo 需要发往服务器，返回成功后再修改到表格中
        $ .ajax({
                url:'../../../website/updatePictures.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        picturesGrid.update(picturesGrid.getSelected(),
                            data.model);
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        picturesWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
    }
}
// 修改图片的取消按钮事件
function edit_cancel() {
    picturesWin.close();
}

// 删除图片的函数
function delete_pictures() {
    if (!picturesGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = picturesGrid.getSelected();
    $.ligerDialog.confirm('确认删除？', '删除图片', function (r) {
        if (r) {
            $.ajax({
                url:'../../../website/deletePictures.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        picturesGrid.deleteSelectedRow();
                        parameterWin.close();

                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}

//修改图片的表单，生成form标签
function formInit() {
    picturesForm = $('<form></form>');
    picturesForm.ligerForm({
        inputWidth:280,
        fields:[
            {
                name:'id',
                type:"hidden"
            },{
                name:'createUserId',
                type:"hidden"
            },
            {
                name:'createUserName',
                type:"hidden"
            },
            {
                name:'createDate',
                type:"hidden"
            },
            {
                name:'src',
                type:"hidden"
            },
            {
                display:'点击图片的链接地址',
                name:'link',
                type:'text',
                space:30,
                labelWidth:100,
                width:220,
                newline:true,
                validate:{
                    required:true,
                    maxlength:100
                }
            },
            {
                display:"图片是否显示在主界面",
                name:"display",
                type:"select",
                width:200,
                space:30,
                labelWidth:100,
                comboboxName:"show",
                textField:"text",
                valueField:"id",
                initValue:"1",
                initText:"是",
                newline:true,
                options:{
                    hideOnLoseFocus:true,
                    valueFieldID:"id",
                    data:[
                        {
                            "id":"1",
                            "text":"是"
                        },
                        {
                            "id":"0",
                            "text":"否"
                        }
                    ]

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
    picturesForm.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error, element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
}


// 刷新学生的函数
function refresh_pictures() {
    $.ajax( {
        url : '../../../website/mapPictures.action',
        type : 'post',
        success : function(data) {
            picturesGrid.loadData(data.picturesMap);
        }
    });
    $("#pageloading").hide();

}

// 初始化表格
$(function () {
    var toolbarItems = [
        {
            text:'新增图片',
            click:add_pictures,
            icon:'add',
            key:'add'
        },
        {
            text:'修改图片',
            click:edit_pictures,
            icon:'modify',
            key:'modify'
        },
        {
            text:'删除图片',
            click:delete_pictures,
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
        url:'../../../website/listPictures.action',
        type:'post',
        success:function (data) {
            picturesGrid = $('#picturesGrid').ligerGrid({
                columns:[
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display:'点击图片的链接地址',
                        name:'link',
                        width:200
                    },
                    {
                        display:'图片是否显示在主界面',
                        name:'display',
                        width:200
                    },
                    {
                        display:'图片创建时间',
                        name:'createDate',
                        width:200
                    }, {
                        display:'图片创建人',
                        name:'createUserName',
                        width:200
                    },
                    {
                        display:'备注',
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
                },
                rowAttrRender:function (rowdata) {
                    if (rowdata.createDate) {
                        rowdata.createDate = rowdata.createDate.substring(0, 10);
                    }
                    if (rowdata.show == 0) {
                        rowdata.sex = "否";
                    } else {
                        rowdata.sex = "是";
                    }
                    return;
                }
            });
            $("#pageloading").hide();
        }
    });
});