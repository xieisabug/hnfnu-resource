var tree = null;
var grid = null;
$(function() {
	$("#layout").ligerLayout({
		leftWidth : 240,
		rightWidth : 400
	});
	var argsArr = getArgs();
	$.ajax({
		url : '/hnfnuzyw/resources/allTree.action',
		type : 'post',
		success : function(data) {
			tree = $("#tree").ligerTree({
				nodeWidth : 200,
				textFieldName : 'name',
				idFieldName : 'id',
				parentIDFieldName : 'pid',
				checkbox : false,
				data : data.allTree,
				onSelect : function(data) {
					console.log(data);
				}
			});
		}
	});
	grid = $("#grid").ligerGrid({
		columns : [ {
			display : '资源名',
			name : 'name',
			align : 'left',
			minWidth : 120
		}, {
			display : '关键字',
			name : 'keyWords',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '所属课程ID',
			name : 'courseId',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '所属课程名',
			name : 'courseName',
			align : 'left',
			minWidth : 150
		}, {
			display : '所属类别ID',
			name : 'categoryIdList',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '所属类别',
			name : 'categoryNameList',
			align : 'left',
			minWidth : 150
		}, {
			display : '媒体类型',
			name : 'mediaType',
			align : 'left',
			minWidth : 60
		}, {
			display : '媒体格式',
			name : 'mediaFormat',
			align : 'left',
			minWidth : 60
		}, {
			display : '播放时间',
			name : 'playTime',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '文件大小',
			name : 'fileSize',
			align : 'left',
			minWidth : 60
		}, {
			display : '作者',
			name : 'author',
			align : 'left',
			minWidth : 60
		}, {
			display : '出版社',
			name : 'publisher',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '描述',
			name : 'description',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '创建时间',
			name : 'createDate',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '审核状态',
			name : 'approvalStatus',
			align : 'left',
			minWidth : 60
		}, {
			display : '质量等级',
			name : 'quality',
			align : 'left',
			minWidth : 60
		}, {
			display : '价格',
			name : 'price',
			align : 'left',
			hide : true,
			minWidth : 100
		}, {
			display : '访问次数',
			name : 'viewTimes',
			align : 'left',
			minWidth : 60
		}, {
			display : '使用次数',
			name : 'useTimes',
			align : 'left',
			minWidth : 60
		} ],
		height : '94%',
		width : '100%'
	});
});
// 提取URL中的参数
function getArgs() {
	// 加上substring的意义是去掉查询字符串中的？号。
	// var query = window.location.search.substring(1);
	// 定义一个数组，用于存放取出来的字符串参数。
	var argsArr = {};
	// 获取URL中的查询字符串参数
	var query = window.location.search;
	query = query.substring(1);
	// 这里的pairs是一个字符串数组
	// name=myname&password=1234&sex=male&address=nanjing
	var pairs = query.split("&");
	for ( var i = 0; i < pairs.length; i++) {
		var sign = pairs[i].indexOf("=");
		// 如果没有找到=号，那么就跳过，跳到下一个字符串（下一个循环）。
		if (sign == -1) {
			continue;
		}
		var aKey = pairs[i].substring(0, sign);
		var aValue = pairs[i].substring(sign + 1);
		argsArr[aKey] = aValue;
	}
	return argsArr;
}