var currentPage = 1;
var pageCount = $("#pager a").length - 4;
var type = "";
var keyWords = "";
function openWindow(url) {
    window.open(url, '', 'height=650,width=1024,top=50,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
function pager(subjectId,gradeId,page){
    $.ajax({
        url:'/hnfnuzyw/ftl/pager.action',
        type:'post',
        data:{
            subjectId:subjectId,
            gradeId:gradeId,
            page:page,
            type:type,
            keywords:keyWords
        },
        success:function(data){
            var list = data.sourcePager.datas;
            var trs = $("#source_list_table tr");
            for(var i = 0; i < 10; i++){
            	var item;
            	if(i < list.length){
            		item = list[i];
            		var url = "";
                	$(trs[i+1]).attr("onclick", "javascript:openWindow(" + url + ")");
            	} else {
            		item = {
            			id:"",
            			name:"",
            			createDate:"",
            			mediaType:""
            		};
            		$(trs[i+1]).attr("onclick", "");
            	}
            	var tds = $("td",trs[i+1]);
            	$(tds[0]).html(item.id);
            	$(tds[1]).html(item.name);
            	$(tds[2]).html((item.createDate).substr(0,9));
            	$(tds[3]).html(item.mediaType);
            	$(tds[4]).html(item.mediaType);
            }
        }
    });
}
function firstPage(subjectId,gradeId){
    pager(subjectId,gradeId,1);
}
function lastPage(subjectId,gradeId){
    pager(subjectId,gradeId,pageCount);
}
function prePage(subjectId,gradeId){
    var pre;
    if(currentPage>1){
        pre = currentPage-1;
    } else if(currentPage == 1) {
        pre = 1;
    } else {
        pre = currentPage;
    }
    pager(subjectId,gradeId,pre);
}
function nextPage(subjectId,gradeId){
    var next;
    if(currentPage < pageCount){
        next = currentPage + 1;
    } else if(currentPage == pageCount) {
        next = pageCount;
    } else {
        next = currentPage;
    }
    pager(subjectId,gradeId,next);
}

function search(subjectId,gradeId){
    type = $("#source_type").val();
    keyWords = $("#key_word").val();
    pager(subjectId,gradeId,1);
}