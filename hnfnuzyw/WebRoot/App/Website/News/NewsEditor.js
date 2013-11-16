$(function() {
	var ue = UE.getEditor('editor');
/*
	function getContent() {
		var arr = [];
		arr.push("使用editor.getContent()方法可以获得编辑器的内容");
		arr.push("内容为：");
		arr.push(UE.getEditor('editor').getContent());
		alert(arr.join("\n"));
	}
*/
});

// 增加新闻的保存按钮事件
function add_save() {
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
	
	
	var row_data = {
			"title":title,
			"content":content
	}

	// 发往服务器，返回成功后再添加到表格中
	$.ajax({
		url : '../../../website/addNews.action',
		data : row_data,
		type : 'post',
		success : function(data) {
			if (data.success) {
				$.ligerDialog.tip({
					title : '提示信息',
					content : data.message
				});
                var frameLen = top.frames.length;
                for(var i = 0; i < frameLen; i++){
                    if(top.frames[i].newsGrid){
                        top.frames[i].newsGrid.loadData(data.newsList);
                    }
                }



				window.parent.window.tab.removeTabItem("add_news");
			} else {
				$.ligerDialog.error(data.message);
			}
		}
	});
}