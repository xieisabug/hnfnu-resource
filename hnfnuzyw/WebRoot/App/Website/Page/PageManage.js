var listForm = null;
var listWin = null;
function generateIndex(){
    $.ligerDialog.confirm('确认生成主页么（将会覆盖您上次生成的主页）?', '生成主页', function(r) {
        if (r) {
            $.ajax({
                url : '../../../ftl/makeIndex.action',
                type : 'post',
                success : function(data) {
                    if (data.success) {
                        $.ligerDialog.tip({title:'提示信息', content:data.message});
                    }else{
                        $.ligerDialog.error(data.message);
                    }
                }
            })
        }
    });
}

function generateAllList(){
    $.ligerDialog.confirm('确认生成所有列表页么（将会覆盖您上次生成的所有的列表页，并且会耗用较长的时间）?', '生成所有列表页', function(r) {
        if (r) {
            $.ajax({
                //todo url没有更改
                url : '../../../ftl/makeAllListFtl.action',
                type : 'post',
                success : function(data) {
                    if (data.success) {
                        $.ligerDialog.tip({title:'提示信息', content:data.message});
                    }else{
                        $.ligerDialog.error(data.message);
                    }
                }
            })
        }
    });
}

function generateOneList(){
    initListForm();
    listWin = $.ligerDialog.open( {
        width : 400,
        height : 400,
        title : "生成单一列表",
        target : listForm,
        buttons : [ {
            text : "提交",
            width : 80,
            onclick : generate
        }, {
            text : "取消",
            width : 80,
            onclick : cancel
        } ]
    });
}

function generate(){
    var gradeId = $("div.l-text-wrapper #gradeId").val();
    var subjectId = $("div.l-text-wrapper #subjectId").val();
    $.ajax( {
        //todo url不对
        url : '../../../ftl/makeListFtl.action',
        data : {
            gradeId:gradeId,
            subjectId:subjectId
        },
        type : 'post',
        success : function(data) {
            if (data.success) {
                $.ligerDialog.tip( {
                    title : '提示信息',
                    content : data.message
                });
                listWin.close();
            } else {
                $.ligerDialog.error(data.message);
            }
        }
    });
}

function cancel(){
    listWin.close();
}

function initListForm(){
    listForm = $('<form></form>');

    $.ajax( {
        url : '../../../resources/listGradesAndSubjects.action',
        type : 'post',
        async : false,
        success : function(data) {
            listForm.ligerForm( {
                inputWidth : 200,
                labelWidth : 90,
                space : 40,
                fields : [  {
                    display : "年级",
                    name : "gradeId",
                    type : "select",
                    comboboxName : "grade",
                    options : {
                        textField : "name",
                        valueField : "id",
                        hideOnLoseFocus : true,
                        valueFieldID : "gradeId",
                        data : data.gradeList
                    }
                }, {
                    display : "学科",
                    name : "subjectId",
                    type : "select",
                    comboboxName : "subject",
                    options : {
                        textField : "name",
                        valueField : "id",
                        hideOnLoseFocus : true,
                        valueFieldID : "id",
                        data : data.subjectList
                    }
                }]
            });
        }
    });
}