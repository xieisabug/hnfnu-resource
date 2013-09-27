function loadSource(subjectId,gradeId){
    $.ajax({
        url:'../../../resources/listSourceVoOrder.action',
        type:'post',
        data:{
            subjectId:subjectId,
            gradeId:gradeId
        },
        success:function(data){
            var sourceList = data.sourceMoreVoList;
            var html = "<table>";
            for(var i = 0; i<sourceList.length; i++){
                var s = sourceList[i];
                if(i%3 == 0) {
                    html += "<tr>";
                }
                html +=
                    "<td>" +
                        "<a href='javascript:openSourceWindow(" + s.id + ")'>"+ s.name +"</a><br/>" +
                        "<span>浏览："+ s.viewTimes+" 类型："+ s.mediaType+"</span>" +
                    "</td>";
                if(i%3 == 2) {
                    html += "</tr>";
                }
            }
            if(sourceList.length%3 != 2) {
                html += "</tr>";
            }
            html += "</table>";

            $("#resource_content").html(html);
        }
    });
}
function openTopicWindow(id) {
    window.open('topic_view.html?id='+id, '', 'height=650,width=1024,top=50,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
function openSourceWindow(id) {
    window.open('source_view.html?id='+id, '', 'height=650,width=1024,top=50,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}