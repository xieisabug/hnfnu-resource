var tree = null;
var grid = null;
$(function() {
	$("#layout").ligerLayout({
		leftWidth : 260,
		rightWidth : 380
	});
	var argsArr = getArgs();
	$.ajax({
		url : '/hnfnuzyw/resources/allTree.action',
		type : 'post',
		success : function(data) {
			tree = $("#tree").ligerTree({
				nodeWidth : 150,
				textFieldName : 'name',
				idFieldName : 'id',
				parentIDFieldName : 'pid',
				checkbox : false,
				data : data.allTree,
                onAfterAppend : function() {
                    this.collapseAll();
                },
				onSelect : function(data) {
                    var params;
                    if(isCourse(data)){
                        params = {
                            courseId:data.data.id,
                            categoryId:0
                        };
                        $.ajax( {
                            url:'/hnfnuzyw/resources/sourceMoreVoList.action',
                            type : 'post',
                            data:params,
                            success : function(data) {
                                grid.loadData(data.sourceMoreVoList);
                            }
                        });
                    } else if(isCategory(data)){
                        params = {
                            courseId:getParentId(data),
                            categoryId:data.data.id
                        };
                        $.ajax( {
                            url:'/hnfnuzyw/resources/sourceMoreVoList.action',
                            type : 'post',
                            data:params,
                            success : function(data) {
                                grid.loadData(data.sourceMoreVoList);
                            }
                        });
                    }
				}
			});
		}
	});
    $.ajax({
        url : '/hnfnuzyw/resources/loadSourceVo.action',
        type : 'post',
        data:{
            id:argsArr.id
        },
        success : function(data) {
            //todo 把dataload到这个grid里
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
                width : '100%',
                data:{Rows:[data.sourceVo]},
                onDblClickRow:function(data){
                    console.log(data);
                    sourceViewTable(data);
                }
            });
            sourceViewTable(data.sourceVo);
            $("#source").html();
        }
    });

});
function sourceViewTable(data){
    var id = data.id;
    var url =data.url.replaceAll(/\\/g,'\\\\');
    var html = "";
    html += '<table>';
    html += '<tr>';
    html += '<td class="attrName">名称</td>';
    html += '<td>'+data.name+'</td>';
    html += '<td class="attrName">课程名称</td>';
    html += '<td>'+data.courseName+'</td>';
    html += '</tr>';
    html += '<tr>';
    html += '<td class="attrName">科目</td>';
    html += '<td>'+data.subjectName+'</td>';
    html += '<td class="attrName">年级</td>';
    html += '<td>'+data.gradeName+'</td>';
    html += '</tr>';
    html += '<tr>';
    html += '<td class="attrName">关键字</td>';
    html += '<td>'+data.keyWords+'</td>';
    html += '<td class="attrName">媒体类型</td>';
    html += '<td>'+data.mediaType+'</td>';
    html += '</tr>';
    html += '<tr>';
    html += '<td class="attrName">媒体格式</td>';
    html += '<td>'+data.mediaFormat+'</td>';
    html += '<td class="attrName">播放时间</td>';
    html += '<td>'+data.playTime+'</td>';
    html += '</tr>';
    html += '<tr>';
    html += '<td class="attrName">文件大小</td>';
    html += '<td>'+data.fileSize+'</td>';
    html += '<td class="attrName">作者</td>';
    html += '<td>'+data.author+'</td>';
    html += '</tr>';
    html += '<tr>';
    html += '<td class="attrName">出版社</td>';
    html += '<td>'+data.publisher+'</td>';
    html += '<td class="attrName">描述</td>';
    html += '<td>'+data.description+'</td>';
    html += '</tr>';
    html += '<tr>';
    html += '<td class="attrName">创建时间</td>';
    html += '<td>'+data.createDate+'</td>';
    html += '<td class="attrName">创建者</td>';
    html += '<td>'+data.createUserName+'</td>';
    html += '</tr>';
    html += '<tr>';
    html += '<td class="attrName">价格</td>';
    html += '<td>'+data.price+'</td>';
    html += '</tr>';
    html += '</table>';
    html += '<div id="button">';
    html += '<a href=javascript:download('+id+',"'+url+'")>下载</a>';
    if(data.mediaFormat == "mp4") {
    	html += '<a href=javascript:onlineView("'+url.substr(url.indexOf("uploads"))+'")>预览</a>';
    }
    html += '</div>';
    $("#source").html(html);
}
function onlineView(data){
    window.open("online_view_test.html?id="+data, '', 'height=650,width=1024,top=50,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');

}
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
function isCourse(obj){
    return tree.getParentTreeItem(tree.getParentTreeItem(tree.getParentTreeItem(obj.target)))==null &&
        tree.getParentTreeItem(tree.getParentTreeItem(obj.target))!=null;
}
//判断选择的是否是类别
function isCategory(obj){
    return !isCourse(obj) &&
        tree.getParentTreeItem(tree.getParentTreeItem(tree.getParentTreeItem(obj.target)))!=null;
}
//获取树的父一级的id
function getParentId(obj){
    return $(tree.getParentTreeItem(obj.target)).attr("id");
}

function download(id,url){
    $.ajax({
        url : '/hnfnuzyw/website/validateLogin.action',
        type : 'post',
        success : function(data) {
            if (data.success) {
                window.location.href="/hnfnuzyw/file/download.action?url="+url+"&id="+id;
            } else {
                $.ligerDialog.error(data.message);
            }
        }
    });
}
