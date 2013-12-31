var topicGrid = null;// 专题表格
var topicForm = null;// 专题表单
var topicWin = null;// 专题窗口
var joinWin = null;//挂接窗口
var sourceWin = null;//添加资源的窗口
var sourceForm = null;//添加资源的表单
var topicSubtitleFrom = null;//新增二级标题的表单
var subtitleGrid = null;//用于显示二级标题的表格
var subtitleWin = null;//用于显示二级标题的窗口
var topicSelectData = null;//用于在修改专题的时候保存的数据
// 增加专题的函数
function add_topic() {
    topicWin = $.ligerDialog.open({
        width:400,
        height:400,
        title:'新增专题',
        url:'AddTopicImageForm.html',
        allowClose:false,
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
// 增加专题的保存按钮事件
function add_save() {
    topicForm = topicWin.frame.sourceForm;
    if (topicForm.valid()) {

        var row_data = Form.parseJSON(topicForm);
        if (row_data.isOutlink == 1 && (row_data.outlink == null || row_data.outlink == "")) {
            $.ligerDialog.error("选择了外链之后，必须填写外链地址！");
            return;
        }

        if (row_data.imageUrl == null || row_data.imageUrl == "") {
            $.ligerDialog.error("请上传专题图片");
            return;
        }
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../resources/addTopic.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                   // topicGrid.addRow(data.model);
                    refresh_info();
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    topicWin.close();
                    //如果不是外链，则里面提示是否添加二级标题，是则立马添加，否则自动添加和标题一模一样的标题
                    if (data.topic.isOutlink == 0) {
                        var topicDialog = $.ligerDialog.confirm('专题添加成功，专题需要添加二级标题吗？', function (answer) {
                            if (answer) {
                                add_topic_subtille();
                            } else {
                                //不存在二级标题，就添加和专题名字一样的二级标题
                                //alert("不存在二级标题，我来添加。");
                                auto_add_subtitle(data.topic);
                            }
                        });
                    }

                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}

//当二级标题不存在时，自动给专题添加二级标题
function auto_add_subtitle(topic) {
    $.ajax({
        url:'../../../resources/addTopicSubtitle.action',
        data:{
            "topicId":topic.id,
            "subtitle":topic.name,
            'isAuto':1
        },
        type:'post',
        success:function (data) {
            if (data.success) {
                $.ligerDialog.tip({
                    title:'提示信息',
                    content:'系统添加二级标题' + data.message
                });
                topicWin.close();
            } else {
                $.ligerDialog.error('系统添加二级标题' + data.message);
            }
        }
    });
}

// 增加专题的取消按钮事件
function add_cancel() {
    topicWin.close();
}
//增加专题的二级标题
function add_topic_subtille() {
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要添加的专题.');
        return;
    }
    topicSubtitleFromInit();
    topicWin = $.ligerDialog.open({
        width:400,
        height:200,
        title:'新增二级标题',
        target:topicSubtitleFrom,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:add_subtitle_save
            },
            {
                text:'取消',
                width:80,
                onclick:add_subtitle_cancel
            }
        ]
    });

}

// 增加专题的二级标题的保存按钮事件
function add_subtitle_save() {
    if (topicSubtitleFrom.valid()) {
        var row_data = Form.parseJSON(topicSubtitleFrom);
        var data2 = topicGrid.getSelected();
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../resources/addTopicSubtitle.action',
            data:{
                "topicId":data2.id,
                "subtitle":row_data.subtitle,
                "isAuto":0,
                "remark":row_data.remark
            },
            type:'post',
            success:function (data) {
                if (data.success) {
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    subtitleGrid.addRow(data.model);
                    topicWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加专题的二级标题的取消按钮事件
function add_subtitle_cancel() {
    topicWin.close();
}
//给专题上传资源
function upload() {
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要添加资源的专题.');
        return;
    }
    var topic = topicGrid.getSelected();
    select_subtitle('下一步', null, add_file_save, add_file_cancel, topic);
}
function add_file_save() {
    // alert("add_file_save");
    if (!subtitleGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要添加资源的专题的二级标题.');
        return;
    }
    var subtitle = subtitleGrid.getSelected();
    sourceWin = $.ligerDialog.open({
        width:400,
        height:550,
        title:"上传资源",
        url:'AddTopicFileForm.html?topicSubtitleId=' + subtitle.id,
        allowClose:false,
        buttons:[
            {
                text:"提交",
                width:80,
                onclick:topic_source_save
            },
            {
                text:"取消",
                width:80,
                onclick:topic_source_cancel
            }
        ]
    });
}
function add_file_cancel() {
    subtitleWin.hide();
}

function topic_source_save() {
    sourceForm = sourceWin.frame.sourceForm;
    // 把表单转化为数组
    if (sourceForm.valid()) {
        var row_data = Form.parseJSON(sourceForm);
        if (row_data.url == "" || row_data.url == null) {
            $.ligerDialog.error("未上传文件");
            return;
        }

        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url:'../../../resources/addTopicSource.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    // courseGrid.addRow(data.model);
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    // refresh_info();
                    sourceWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });

    }


}
function topic_source_cancel() {
    //subtitleWin.hide();
    sourceWin.close();
}


//在该界面有挂接资源和添加资源用到的选择二级标题的win，text是确定按钮叫什么名字，有叫下一步，也有叫确定，onclick_name则是调用的函数的名字
function select_subtitle(text, toolbarItems, onclick_save, onclick_cancel, topic) {
    $.ajax({
        url:'../../../resources/listTopicSubtitle.action',
        type:'post',
        data:{
            "topicId":topic.id
        },
        success:function (data) {
            var s = $('#subtitleGrid');
            subtitleGrid = s.ligerGrid({
                columns:[
                    {
                        display:'二级标题名称',
                        name:'subtitle',
                        width:300
                    },
                    {
                        display:'备注',
                        name:'remark',
                        width:300
                    }
                ],
                width:560,
                height:400,
                pageSize:30,
                data:data.topicSubtitleList,
                toolbar:{
                    items:toolbarItems
                }
            });
            subtitleWin = $.ligerDialog.open({
                width:600,
                height:400,
                title:topic.name + '的二级标题',
                target:s,
                buttons:[
                    {
                        text:text,
                        width:80,
                        onclick:onclick_save
                    },
                    {
                        text:'取消',
                        width:80,
                        onclick:onclick_cancel
                    }
                ]
            });
            $(".l-grid2", subtitleWin.element).css({width:600});
            $("#pageloading").hide();
        }
    });
}


// 修改专题的函数
function edit_topic() {
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    topicSelectData = topicGrid.getSelected();
    if (topicSelectData.isOutlink == "否") {
        topicSelectData.isOutlink = 0;
    } else {
        topicSelectData.isOutlink = 1;
    }
    topicWin = $.ligerDialog.open({
        width:400,
        height:280,
        title:'编辑专题',
        url:'TopicEditForm.html',
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
// 修改专题的保存按钮事件
function edit_save() {
    topicForm = topicWin.frame.sourceForm;
    if (topicForm.valid()) {
        var row_data = Form.parseJSON(topicForm);
        if (row_data.isOutlink == 1 && (row_data.outlink == null || row_data.outlink == "")) {
            $.ligerDialog.error("选择了外链之后，必须填写外链地址！");
            return;
        }
        // todo 需要发往服务器，返回成功后再修改到表格中
        $.ajax({
            url:'../../../resources/updateTopic.action',
            data:row_data,
            type:'post',
            success:function (data) {
                if (data.success) {
                    refresh_info();
                    $.ligerDialog.tip({
                        title:'提示信息',
                        content:data.message
                    });
                    topicWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 修改专题的取消按钮事件
function edit_cancel() {
    topicWin.close();
}

// 删除专题的函数
function delete_topic() {
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的行.');
        return;
    }
    var row_data = topicGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除专题', function (r) {
        if (r) {
            $.ajax({
                url:'../../../resources/deleteTopic.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        refresh_info();
                        topicWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}
function topic_source_join() {
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要挂接的专题.');
        return;
    }

    var topic = topicGrid.getSelected();
    select_subtitle('下一步', null, select_source, select_source_cancel, topic);
}

//给专题挂接资源选择了二级标题后的下一步，也就是接下来是给专题选择资源
function select_source() {
    var topic = topicGrid.getSelected();

    if (!subtitleGrid.getSelected()) {
        $.ligerDialog.warn('请选择' + topic.name + '二级标题');
        return;
    }
    var subtitleId = subtitleGrid.getSelected().id;
    joinWin = $.ligerDialog.open({
        width:1000,
        height:550,
        title:'挂接资源',
        url:"JoinSource.html?subtitleId=" + subtitleId,
        buttons:[
            {
                text:'提交',
                width:80,
                onclick:join_save
            },
            {
                text:'取消',
                width:80,
                onclick:join_cancel
            }
        ]
    });


}
//给专题挂接资源选择了二级标题后的放弃挂接资源
function select_source_cancel() {
    subtitleWin.hide();
}

function join_save() {
    var seletedSourceIds = joinWin.frame.joinSelectData;
    var subtitleId = subtitleGrid.getSelected().id;
    var sendIds = '';
    for (var i = 0; i < seletedSourceIds.length; i++) {
        if (i == 0) {
            sendIds += seletedSourceIds[i];
        } else {
            sendIds += ',' + seletedSourceIds[i];
        }
    }
    $.ajax({
        url:'../../../resources/updateTopicSourceJoins.action',
        type:'post',
        data:{
            subtitleId:subtitleId,
            seletedSourceIds:sendIds
        },
        success:function (data) {
            if (data.success) {
                $.ligerDialog.tip({
                    title:'提示信息',
                    content:data.message
                });
                joinWin.close();
                subtitleWin.hide();
            } else {
                $.ligerDialog.error(data.message);
            }

        }
    });
}
function join_cancel() {
    joinWin.close();
    subtitleWin.hide();
}
// 初始化表单，生成form标签
function topicSubtitleFromInit() {
    topicSubtitleFrom = $('<form></form>');
    topicSubtitleFrom.ligerForm({
        inputWidth:280,
        fields:[
            {
                name:'id',
                type:"hidden"
            },
            {
                display:'二级标题',
                name:'subtitle',
                type:'text',
                space:30,
                labelWidth:100,
                width:100,
                newline:true,
                validate:{
                    required:true,
                    maxlength:100
                }
            },
            {
                display:'备注',
                name:'remark',
                type:'text',
                space:30,
                labelWidth:100,
                width:100,
                newline:true
            }
        ]
    });
    $.metadata.setType("attr", "validate");
    topicSubtitleFrom.validate({
        debug:true,
        onkeyup:false,
        errorPlacement:function (error, element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
}
// 刷新专题的函数
function refresh_info() {
    $.ajax({
        url:'../../../resources/listTopic.action',
        type:'post',
        success:function (data) {
            topicGrid.loadData(data.topicList);
        }
    });
    $("#pageloading").hide();

}

//todo
function query_topic_subtille() {
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要查看的专题.');
        return;
    }
    var topic = topicGrid.getSelected();
    var toolbarItems = [
        {
            text:'删除二级标题',
            click:delete_subtitle,
            icon:'add',
            key:'add'
        },
        {
            text:'增加二级标题',
            click:add_topic_subtille,
            icon:'add',
            key:'modify'
        }
    ];
    select_subtitle("确定", toolbarItems, oquery_topic_subtille_cancel, oquery_topic_subtille_cancel, topic)
}
//查看二级标题按钮的确定和取消按钮事件
function oquery_topic_subtille_cancel() {
    subtitleWin.hide();
}
// 删除二级标题按钮事件
function delete_subtitle(){
    if (!subtitleGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要删除的二级标题.');
        return;
    }
    var row_data = subtitleGrid.getSelected();
    $.ligerDialog.confirm('确认删除' + row_data.subtitle + '？', '删除二级标题', function (r) {
        if (r) {
            $.ajax({
                url:'../../../resources/deleteTopicSubtitle.action',
                data:row_data,
                type:'post',
                success:function (data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title:'提示信息',
                            content:data.message
                        });
                        subtitleGrid.deleteSelectedRow();
                        //topicWin.close();
                    } else {
                        $.ligerDialog.error(data.message);
                    }
                }
            });
        }
    });
}


// 初始化表格
$(function () {
    var toolbarItems = [
        {
            text:'新增专题',
            click:add_topic,
            icon:'add',
            key:'add'
        },
        {
            text:'修改专题',
            click:edit_topic,
            icon:'modify',
            key:'modify'
        },
        {
            text:'删除专题',
            click:delete_topic,
            icon:'delete',
            key:'delete'
        },
        {
            text:'挂接资源',
            click:topic_source_join,
            icon:'config',
            key:'join'
        },
        {
            text:'增加二级标题',
            click:add_topic_subtille,
            icon:'add',
            key:'add_subtitle'
        },
        {
            text:'查看二级标题',
            click:query_topic_subtille,
            icon:'refresh',
            key:'query_subtitle'
        },
        {
            text:'给专题上传资源',
            click:upload,
            icon:'add',
            key:'upload'
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
        url:'../../../resources/listTopic.action',
        type:'post',
        success:function (data) {
            topicGrid = $('#topicGrid').ligerGrid({
                columns:[
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display:'专题名称',
                        name:'name',
                        width:200
                    },
                    {
                        display:'是否显示',
                        name:'isDisplay',
                        width:200
                    },
                    {
                        display:'专题介绍',
                        name:'description',
                        align:'left',
                        width:400
                    },
                    {
                        display:'专题作者',
                        name:'author',
                        align:'left',
                        width:200
                    },
                    {
                        display:'专题图片地址',
                        name:'imageUrl',
                        align:'left',
                        width:300
                    },
                    {
                        display:'是否外链',
                        name:'isOutlink',
                        align:'left',
                        width:200
                    },
                    {
                        display:'外链地址',
                        name:'outlink',
                        align:'left',
                        width:200
                    },
                    {
                        display:'备注',
                        name:'remark',
                        align:'left',
                        width:200
                    }
                ],
                width:'99%',
                height:'98%',
                pageSize:20,
                data:data.topicList,
                toolbar:{
                    items:toolbarItems
                },
                rowAttrRender:function (rowdata) {
                    if (rowdata.isDisplay == 0) {
                        rowdata.isDisplay = "否";
                    } else {
                        rowdata.isDisplay = "是";
                    }
                    if (rowdata.isOutlink == 0) {
                        rowdata.isOutlink = "否";
                    } else {
                        rowdata.isOutlink = "是";
                    }
                    return;
                }
            });
            $("#pageloading").hide();
        }
    });
});