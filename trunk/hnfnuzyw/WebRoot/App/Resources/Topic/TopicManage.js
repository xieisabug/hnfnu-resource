var topicGrid = null;// 专题表格
var topicFrom = null;// 专题表单
var topicWin = null;// 专题窗口
var joinWin = null;//挂接窗口
var sourceWin = null;//添加资源的窗口
var sourceForm = null;//添加资源的表单
var topicSubtitleFrom = null;//新增二级标题的表单
var subtitleGrid = null;//用于显示二级标题的表格
var subtitleWin = null;//用于显示二级标题的窗口
// 增加专题的函数
function add_topic() {
    formInit();
    topicWin = $.ligerDialog.open({
        width : 400,
        height : 200,
        title : '新增专题',
        target : topicFrom,
        buttons : [ {
            text : '提交',
            width : 80,
            onclick : add_save
        }, {
            text : '取消',
            width : 80,
            onclick : add_cancel
        } ]
    });
}
// 增加专题的保存按钮事件
function add_save() {
    if (topicFrom.valid()) {
        var row_data = Form.parseJSON(topicFrom);
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url : '../../../resources/addTopic.action',
            data : row_data,
            type : 'post',
            success : function(data) {
                if (data.success) {
                    topicGrid.addRow(data.model);
                    $.ligerDialog.tip({
                        title : '提示信息',
                        content : data.message
                    });
                    topicWin.close();
                } else {
                    $.ligerDialog.error(data.message);
                }
            }
        });
    }
}
// 增加专题的取消按钮事件
function add_cancel() {
    topicWin.close();
}
//增加专题的二级标题
function add_topic_subtille(){
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要添加的专题.');
        return;
    }
    topicSubtitleFromInit();
    topicWin = $.ligerDialog.open({
        width :400,
        height : 200,
        title : '新增二级标题',
        target : topicSubtitleFrom,
        buttons : [ {
            text : '提交',
            width : 80,
            onclick : add_subtitle_save
        }, {
            text : '取消',
            width : 80,
            onclick : add_subtitle_cancel
        } ]
    });

}

// 增加专题的二级标题的保存按钮事件
function add_subtitle_save() {
    if (topicSubtitleFrom.valid()) {
        var row_data = Form.parseJSON(topicSubtitleFrom);
        var data2 = topicGrid.getSelected();
        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url : '../../../resources/addTopicSubtitle.action',
            data : {
                "topicId":data2.id,
                "subtitle":row_data.subtitle,
                "remark":row_data.remark
            },
            type : 'post',
            success : function(data) {
                if (data.success) {
                    $.ligerDialog.tip({
                        title : '提示信息',
                        content : data.message
                    });
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
function upload(){
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要添加资源的专题.');
        return;
    }
    var topic = topicGrid.getSelected();
    select_subtitle('下一步',add_file_save,add_file_cancel,topic);

   /* $.ajax({
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
                    },  {
                        display:'备注',
                        name:'remark',
                        width:300
                    }
                ],
                width:560,
                height:400,
                pageSize:30,
                data:data.topicSubtitleList
            });
            subtitleWin = $.ligerDialog.open({
                width:600,
                height:400,
                title:topic.name +'的二级标题',
                target:s,
                buttons:[
                    {
                        text:'下一步',
                        width:80,
                        onclick:add_file_save                    },
                    {
                        text:'取消',
                        width:80,
                        onclick:add_file_cancel
                    }
                ]
            });
            console.log(subtitleGrid);
            console.log(subtitleWin);
            $(".l-grid2",subtitleWin.element).css({width:600});
            $("#pageloading").hide();
        }
    });*/
}
function add_file_save(){
   // alert("add_file_save");
    if (!subtitleGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要添加资源的专题的二级标题.');
        return;
    }
    var subtitle = subtitleGrid.getSelected();
    sourceWin = $.ligerDialog.open({
        width : 400,
        height : 550,
        title : "上传资源",
        url : 'AddForm.html?topicSubtitleId='+subtitle.id,
        allowClose : false,
        buttons : [ {
            text : "提交",
            width : 80,
            onclick : topic_source_save
        }, {
            text : "取消",
            width : 80,
            onclick : topic_source_cancel
        } ]
    });
}
function add_file_cancel(){
    subtitleWin.hide();
}

function topic_source_save(){
    sourceForm = sourceWin.frame.sourceForm;
    // 把表单转化为数组
    if (sourceForm.valid()) {
        var row_data = Form.parseJSON(sourceForm);
        if (row_data.url == "" || row_data.url == null) {
            $.ligerDialog.error("未上传文件");
            return;
        }
        //todo 最后得删除，调试用
        if (row_data.topicSubtitleId == "" || row_data.topicSubtitleId == null) {
            $.ligerDialog.error("没有成功获取二级标题的id");
            return;
        }

        // 发往服务器，返回成功后再添加到表格中
        $.ajax({
            url : '../../../resources/addTopicSource.action',
            data : row_data,
            type : 'post',
            success : function(data) {
                if (data.success) {
                    // courseGrid.addRow(data.model);
                    $.ligerDialog.tip({
                        title : '提示信息',
                        content : data.message
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
function topic_source_cancel(){
    //subtitleWin.hide();
    sourceWin.close();
}



//在该界面有挂接资源和添加资源用到的选择二级标题的win，text是确定按钮叫什么名字，有叫下一步，也有叫确定，onclick_name则是调用的函数的名字
function select_subtitle(text,onclick_save,onclick_cancel,topic){
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
                    },  {
                        display:'备注',
                        name:'remark',
                        width:300
                    }
                ],
                width:560,
                height:400,
                pageSize:30,
                data:data.topicSubtitleList
            });
            subtitleWin = $.ligerDialog.open({
                width:600,
                height:400,
                title:topic.name +'的二级标题',
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
           // console.log(subtitleGrid);
          //  console.log(subtitleWin);
            $(".l-grid2",subtitleWin.element).css({width:600});
            $("#pageloading").hide();
        }
    });
}



// 修改专题的函数
function edit_topic() {
        formInit();
    if (!topicGrid.getSelected()) {
        $.ligerDialog.warn('请选择您要修改的行.');
        return;
    }
    Form.loadForm(topicFrom, topicGrid.getSelected());
    topicWin = $.ligerDialog.open({
        width : 400,
        height : 200,
        title : '编辑专题',
        target : topicFrom,
        buttons : [ {
            text : '提交',
            width : 80,
            onclick : edit_save
        }, {
            text : '取消',
            width : 80,
            onclick : edit_cancel
        } ]
    });
}
// 修改专题的保存按钮事件
function edit_save() {
    if (topicFrom.valid()) {
        var row_data = Form.parseJSON(topicFrom);
        // todo 需要发往服务器，返回成功后再修改到表格中
        $ .ajax({
                url : '../../../resources/updateTopic.action',
                data : row_data,
                type : 'post',
                success : function(data) {
                    if (data.success) {
                        topicGrid.update(topicGrid.getSelected(),
                            data.model);
                        $.ligerDialog.tip({
                            title : '提示信息',
                            content : data.message
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
    $.ligerDialog.confirm('确认删除' + row_data.name + '？', '删除专题', function(r) {
        if (r) {
            $.ajax({
                url : '../../../resources/deleteTopic.action',
                data : row_data,
                type : 'post',
                success : function(data) {
                    if (data.success) {
                        $.ligerDialog.tip({
                            title : '提示信息',
                            content : data.message
                        });
                        topicGrid.deleteSelectedRow();
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
    select_subtitle('下一步',select_source,select_source_cancel,topic);
   /* $.ajax({
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
                    },  {
                        display:'备注',
                        name:'remark',
                        width:300
                    }
                ],
                width:560,
                height:400,
                pageSize:30,
                data:data.topicSubtitleList
            });
            subtitleWin = $.ligerDialog.open({
                width:600,
                height:400,
                title:topic.name +'的二级标题',
                target:s,
                buttons:[
                    {
                        text:'下一步',
                        width:80,
                        onclick:select_source
                    },
                    {
                        text:'取消',
                        width:80,
                        onclick:select_source_cancel
                    }
                ]
            });
            console.log(subtitleGrid);
            console.log(subtitleWin);
            $(".l-grid2",subtitleWin.element).css({width:600});
            $("#pageloading").hide();
        }
    });*/
}

//给专题挂接资源选择了二级标题后的下一步，也就是接下来是给专题选择资源
function select_source(){
    var topic = topicGrid.getSelected();

    if (!subtitleGrid.getSelected()) {
        $.ligerDialog.warn('请选择'+topic.name+'二级标题');
        return;
    }
    var subtitleId = subtitleGrid.getSelected().id;
    joinWin = $.ligerDialog.open({
        width : 1000,
        height : 550,
        title : '挂接资源',
        url : "JoinSource.html?subtitleId="+subtitleId,
        buttons : [ {
            text : '提交',
            width : 80,
            onclick : join_save
        }, {
            text : '取消',
            width : 80,
            onclick : join_cancel
        } ]
    });


}
//给专题挂接资源选择了二级标题后的放弃挂接资源
function select_source_cancel(){
    subtitleWin.hide();
}

function join_save(){
    var seletedSourceIds = joinWin.frame.joinSelectData;
    var subtitleId = subtitleGrid.getSelected().id;
    var sendIds = '';
    for(var i = 0; i<seletedSourceIds.length; i++){
        if(i==0){
            sendIds += seletedSourceIds[i];
        } else {
            sendIds += ',' + seletedSourceIds[i];
        }
    }
    $.ajax( {
        url : '../../../resources/updateTopicSourceJoins.action',
        type : 'post',
        data : {
            subtitleId : subtitleId,
            seletedSourceIds : sendIds
        },
        success : function(data) {
            if (data.success) {
                $.ligerDialog.tip({
                    title : '提示信息',
                    content : data.message
                });
                joinWin.close();
                subtitleWin.hide();
            } else {
                $.ligerDialog.error(data.message);
            }

        }
    });
}
function join_cancel(){
    joinWin.close();
    subtitleWin.hide();
}
// 初始化表单，生成form标签
function formInit() {
    topicFrom = $('<form></form>');
    topicFrom.ligerForm({
        inputWidth : 280,
        fields : [ {
            name : 'id',
            type : "hidden"
        }, {
            display : '专题名称',
            name : 'name',
            type : 'text',
            space : 30,
            labelWidth : 100,
            width : 220,
            newline : true,
            validate : {
                required : true,
                maxlength : 22
            }
        },
            {
                display : '专题简介',
                name : 'description',
                type : 'text',
                space : 30,
                labelWidth : 100,
                width : 220,
                newline : true,
                validate : {
                    required : true
                }
            },
            {
                display : '专题作者',
                name : 'author',
                type : 'text',
                space : 30,
                labelWidth : 100,
                width : 220,
                newline : true,
                validate : {
                    required : true,
                    maxlength : 22
                }
            },{
            display : '备注',
            name : 'remark',
            type : 'text',
            space : 30,
            labelWidth : 100,
            width : 220,
            newline : true
        } ]
    });
    $.metadata.setType("attr", "validate");
    topicFrom.validate({
        debug : true,
        onkeyup : false,
        errorPlacement : function(error,element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
}

// 初始化表单，生成form标签
function topicSubtitleFromInit() {
    topicSubtitleFrom = $('<form></form>');
    topicSubtitleFrom.ligerForm({
        inputWidth : 280,
        fields : [ {
            name : 'id',
            type : "hidden"
        }, {
            display : '二级标题',
            name : 'subtitle',
            type : 'text',
            space : 30,
            labelWidth : 100,
            width : 100,
            newline : true,
            validate : {
                required : true,
                maxlength : 100
            }
        },{
                display : '备注',
                name : 'remark',
                type : 'text',
                space : 30,
                labelWidth : 100,
                width : 100,
                newline : true
            } ]
    });
    $.metadata.setType("attr", "validate");
    topicSubtitleFrom.validate({
        debug : true,
        onkeyup : false,
        errorPlacement : function(error,element) {
            error.appendTo(element.parent().parent().parent().parent());
        }
    });
}


// 初始化表格
$(function() {
    var toolbarItems = [ {
        text : '新增专题',
        click : add_topic,
        icon : 'add',
        key : 'add'
    }, {
        text : '修改专题',
        click : edit_topic,
        icon : 'modify',
        key : 'modify'
    }, {
        text : '删除专题',
        click : delete_topic,
        icon : 'delete',
        key : 'delete'
    }, {
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
        },{
            text:'给专题上传资源',
            click:upload,
            icon:'add',
            key:'upload'
        }];
    var menuId = window.parent.tab.getSelectedTabItemID();
    $.ajax({
        url : '../../../system/listFunctionIdList.action',
        type : 'post',
        data : {
            menuId : menuId.substr(0,menuId.indexOf("t"))
        },
        success : function(data) {
            var idList = data.functionIdList.split(";");
            var ajaxToolbar = [];
            for(var i = 0; i<idList.length; i++){
                ajaxToolbar.push({name:parent.hnfnu.functionList[idList[i]]});
            }
            toolbarItems = Toolbar.confirmToolbar(toolbarItems, ajaxToolbar);
        }
    });

    $.ajax({
        url : '../../../resources/listTopic.action',
        type : 'post',
        success : function(data) {
            topicGrid = $('#topicGrid').ligerGrid({
                columns : [
                    // { display:'ID', name:'id', align:'left', width:100 },
                    {
                        display : '专题名称',
                        name : 'name',
                        width : 200
                    }, {
                        display : '专题介绍',
                        name : 'description',
                        align : 'left',
                        width : 400
                    },
                    {
                        display : '专题作者',
                        name : 'author',
                        align : 'left',
                        width : 200
                    },
                    {
                        display : '备注',
                        name : 'remark',
                        align : 'left',
                        width : 200
                    } ],
                width : '99%',
                height : '98%',
                pageSize : 20,
                data : data.topicList,
                toolbar : {
                    items : toolbarItems
                }
            });
            $("#pageloading").hide();
        }
    });
});