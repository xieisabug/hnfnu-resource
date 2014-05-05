var listForm = null;
var listWin = null;
function clearAll(){
  /*  $.ligerDialog.confirm('确认清除全部冗余文件么？清除时间可能会比较长，请耐心等待', '清除全部', function(r) {
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
    });*/
    clearSource();
    clearSubjectImage();
    clearTopicSourceFile();
    clearTopicImage();
}

function clearSource(){
    $.ligerDialog.confirm('确认清除全部资源的冗余文件么？清除时间可能会比较长，请耐心等待', '清除全部', function(r) {
        if (r) {
            $.ajax({
                url : '../../../resources/clearSourceFile.action',
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

function clearSubjectImage(){
    $.ligerDialog.confirm('确认清除学科的冗余图片么？清除时间可能会比较长，请耐心等待', '清除全部', function(r) {
        if (r) {
            $.ajax({
                url : '../../../resources/clearSubjectImage.action',
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
function clearTopicSourceFile(){
    $.ligerDialog.confirm('确认清除专题的冗余文件么？清除时间可能会比较长，请耐心等待', '清除全部', function(r) {
        if (r) {
            $.ajax({
                url : '../../../resources/clearTopicSourceFile.action',
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

function clearTopicImage(){
    $.ligerDialog.confirm('确认清除专题的冗余图片么？清除时间可能会比较长，请耐心等待', '清除全部', function(r) {
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
/*
function cancel(){
    listWin.close();
}

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