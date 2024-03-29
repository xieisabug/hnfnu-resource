var newsId = null;

$(function () {
    var ue = UE.getEditor('editor');
    newsId = Url.getArgs().id;
    $.ajax({
        url:'../../../website/loadNews.action',
        data:{
            "id":newsId
        },
        type:'post',
        success:function (data) {
            if (data.success) {
                $('#id').val(data.news.id);
                $('#date').val(data.news.date);
                $('#title').val(data.news.title);
                ue.ready(function(){
                    ue.setContent(data.news.content);
                });
            } else {
                $.ligerDialog.error(data.message);
                window.parent.window.tab.removeTabItem("update_news");
            }
        }
    });


});

// 修改新闻的保存按钮事件
function update_save() {
    var title = $('#title').val();
    if (!title && title == "") {
        alert("标题不能为空");
        return;
    }
    var content = UE.getEditor('editor').getContent();
    if (!content && content == "") {
        alert("新闻内容不能为空");
        return;
    }

    var id = $('#id').val();
    var date = $('#date').val();

    var row_data = {
        "id":id,
        "date":date,
        "title":title,
        "content":content
    }

    // 发往服务器，返回成功后再添加到表格中
    $.ajax({
        url:'../../../website/updateNews.action',
        data:row_data,
        type:'post',
        success:function (data) {
            if (data.success) {
//                console.log(data.newsList);

                $.ligerDialog.tip({
                    title:'提示信息',
                    content:data.message
                });
                var frameLen = top.frames.length;
                for(var i = 0; i < frameLen; i++){
                    if(top.frames[i].newsGrid){
                        top.frames[i].newsGrid.loadData(data.newsList);
//                        console.log(top.frames[i].newsGrid);
                        window.parent.window.tab.removeTabItem("update_news");
                        return;
                    }
                }

            } else {
                $.ligerDialog.error(data.message);
            }
        }
    });
}

