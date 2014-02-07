var listForm = null;
var listWin = null;
function generateIndex(){
    $.ligerDialog.confirm('确认清除全部冗余文件么？清除时间可能会比较长，请耐心等待', '清除全部', function(r) {
        if (r) {
            $.ajax({
                url : '../../../resources/clearTopicImage.action',
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
/*
$(function(){
    var b1 = $("#b1").ligerDrag({
        proxy: 'clone',
        receive:'#websiteContent'
    });
    var b2 = $("#b2").ligerDrag({
        proxy: 'false',
        receive:'#websiteContent'
    });
    var proxyDiv = '<div class="proxy" style="width: 98%;height: 40px;background-color: #f1f4f5;margin: 1px;border:1px solid #000000;"></div>';
    b1.bind('DragEnter',function(receive, source, e){
        console.log("b1!DragEnter");
        console.log(receive);
        console.log(source);
        console.log(e);
        console.log("b1!DragEnter");
        $(receive).append(proxyDiv);
    });
    b1.bind('DragLeave',function(receive, source, e){
        console.log("b1!DragLeave");
        console.log(receive);
        console.log(source);
        console.log(e);
        console.log("b1!DragLeave");
        $(".proxy",receive).remove();
    });
    b1.bind('Drop',function(receive, source, e){
        console.log("b1!Drop");
        console.log(receive);
        console.log(source);
        console.log(e);
        console.log("b1!Drop");
        $(".proxy",receive).remove();
        $(receive).append('<div style="width: 98%;height: 40px;background-color: #f1f4f5;margin: 1px;border:1px solid #000000;"></div>');
    })

});      */