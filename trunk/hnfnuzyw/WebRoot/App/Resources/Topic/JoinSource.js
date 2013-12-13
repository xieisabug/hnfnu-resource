var joinGrid = null;//右侧表格
var joinTree = null;//左侧树
var joinSelectData = null;//表格选择的数据
var subtitleId = null;//当前选择的topic的二级标题id


//判断选择的是否是课程
function isCourse(obj){
    return joinTree.getParentTreeItem(joinTree.getParentTreeItem(joinTree.getParentTreeItem(obj.target)))==null &&
           joinTree.getParentTreeItem(joinTree.getParentTreeItem(obj.target))!=null;
}
//判断选择的是否是类别
function isCategory(obj){
    return !isCourse(obj) &&
        joinTree.getParentTreeItem(joinTree.getParentTreeItem(joinTree.getParentTreeItem(obj.target)))!=null;
}
//获取树的父一级的id
function getParentId(obj){
    return $(joinTree.getParentTreeItem(obj.target)).attr("id");
}
// 页面加载完成后就开始调用
$(function() {
    $("#joinLayout").ligerLayout({leftWidth:250});
    subtitleId = Url.getArgs().subtitleId;
    $.ajax( {
        async: false,
        url : '../../../resources/querySourceIdsByTopicId.action',
        type : 'post',
        data : {
            subtitleId : subtitleId
        },
        success : function(data) {
            joinSelectData = data.sourceIds;
           // console.log(joinSelectData);
        }
    });
    $.ajax( {
        url : '../../../resources/allTree.action',
        type : 'post',
        success : function(data) {
            joinTree = $("#joinTree").ligerTree({
                nodeWidth:200,
                textFieldName : 'name',
                idFieldName : 'id',
                parentIDFieldName : 'pid',
                checkbox:false,
                data : data.allTree,
                onSelect:function(data){
                    var params;
                    if(isCourse(data)){
                        params = {
                            courseId:data.data.id,
                            categoryId:0
                        };
                        $.ajax( {
                            url:'../../../resources/sourceMoreVoList.action',
                            type : 'post',
                            data:params,
                            success : function(data) {
                                joinGrid.loadData(data.sourceMoreVoList);
                            }
                        });
                    } else if(isCategory(data)){
                        params = {
                            courseId:getParentId(data),
                            categoryId:data.data.id
                        };
                        $.ajax( {
                            url:'../../../resources/sourceMoreVoList.action',
                            type : 'post',
                            data:params,
                            success : function(data) {
                                joinGrid.loadData(data.sourceMoreVoList);
                            }
                        });
                    }
                }
            });
        }
    });

    joinGrid = $("#joinGrid").ligerGrid( {
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
        },  {
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
        height : '98%',
        width : '100%',
        checkbox : true,
        onCheckRow : function(checked,data){
            if(checked){
                joinSelectData.push(data.id);
            } else {
                joinSelectData.splice(joinSelectData.indexOf(data.id,0), 1);
            }
        },
        isChecked:function(rowdata){
            for(var i = 0; i<joinSelectData.length; i++){
                if(rowdata.id==joinSelectData[i]){
                    return true;
                }
            }
            return false;
        }
    });
	$("#pageloading").hide();
});