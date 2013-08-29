var currentPage = 1;
var pageCount = $("#pager a").length - 4;
var type = "";
var keyWords = "";
var subjectGradeWin = null;
var subjectGradeForm = null;
function openSourceWindow(id) {
    window.open('source_view.html?id='+id, '', 'height=650,width=1024,top=50,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
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
            var page;
            if(data.sourcePager.total % data.sourcePager.size == 0){
                page = data.sourcePager.total / data.sourcePager.size;
            } else {
                page = (data.sourcePager.total / data.sourcePager.size)+1;
            }
            if(page != pageCount){
                pageCount = page;
                var links = $("#pager a");
                for(var l = links.length-3; l>1; l--){
                    links[l].remove();
                }
                for(l = 1; l<=page; l++){
                    var html = '<a href="javascript:pager('+subjectId + ','+ gradeId+ ','+ l +')">1</a>';
                    $(html).appendTo(links[l]);
                    //links[l+1].append(html);
                }
            }
            var trs = $("#source_list_table tr");
            for(var i = 0; i < 10; i++){
            	var item;
            	if(i < list.length){
            		item = list[i];
            		var url = item.id;
                    $(trs[i+1]).removeAttr('onclick');
                    $(trs[i+1]).unbind('click');
                    $(trs[i+1]).click(function(){
                        openSourceWindow(url);
                    });
            	} else {
            		item = {
            			id:"",
            			name:"",
            			createDate:"",
            			mediaType:""
            		};
                    $(trs[i+1]).removeAttr('onclick');
                    $(trs[i+1]).unbind('click');
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

function chooseSubjectGrade(){
    initListForm();
    subjectGradeWin = $.ligerDialog.open( {
        width : 370,
        height : 140,
        title : "选择您需要查看的年级和学科",
        target : subjectGradeForm,
        buttons : [ {
            text : "提交",
            width : 80,
            onclick : jump
        }, {
            text : "取消",
            width : 80,
            onclick : cancel
        } ]
    });
}

function jump(){
    var gradeId = $("div.l-text-wrapper #gradeId").val();
    var subjectId = $("div.l-text-wrapper #subjectId").val();
    if(gradeId == "" || subjectId == "") {
        subjectGradeWin.close();
        return;
    }
    var url = "sourceList_" + subjectId + "_" + gradeId + ".html";
    window.location = url;
}

function cancel(){
    subjectGradeWin.close();
}

function initListForm(){
    subjectGradeForm = $('<form></form>');

    $.ajax( {
        url : '/hnfnuzyw/resources/listGradesAndSubjects.action',
        type : 'post',
        async : false,
        success : function(data) {
            subjectGradeForm.ligerForm( {
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