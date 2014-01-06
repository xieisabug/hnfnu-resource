window.addEvent('domready', function () {
    var showPanel = new Panel($('show-panel'));
    var hotGradePanel = new Panel($('hot-grade-panel'));
    var choosePanel = new Panel($('choose-panel'));
    initStyleAndEvent();
});

function initStyleAndEvent(){
    $$('.topic-resource-btn a').each(function (item) {
        new Button(item).addClass('topic-view-btn');
    });
    $$('.topic-resource-content').each(function (item) {
        item.addEvent('mouseover',function () {
            item.getChildren('table .topic-resource-btn').setStyle('display', 'block');
        }).addEvent('mouseleave', function () {
                item.getChildren('table .topic-resource-btn').setStyle('display', 'none');
            });
    });
}

function more(groupId, gradeId,subjectId){
    var move = $$('#source-list div.more')[0];
    var content =  $('source-list');
    var page = move.getProperty("page");
    page++;
    new Request.JSON({
        url:basePath + "source/coursePage",
        onSuccess:function(data){
            var oldH = content.getScrollSize().y;
            var datas = data.sourcePager.datas;
            var html = '',i = 0;
            for(i = 0; i<datas.length; i++) {
                html += generateSourceItem(datas[i]);
            }
            console.log(html);
            new Element('div',{
                html:html
            }).getChildren().each(function(item){
                    move.grab(item,'before');
                });
            initStyleAndEvent();
            content.setStyle('height',oldH);
            var h = content.getScrollSize().y;
            var fx = new Fx.Morph(content, {
                duration: 1000,
                transition:Fx.Transitions['Quad']['easeIn']
            });
            fx.start({
                height:[oldH, h]
            });
            if( data.sourcePager.datas.length < 8 ) {
                move.destroy();
            }
        }
    }).get({
            pageIndex:page,
            gradeId: gradeId,
            groupId : groupId,
            subjectId: subjectId
        });

    move.setProperty("page",page);
}
function generateSourceItem(data) {
    var html = '';
    html += '<div class="topic-resource-content">';
    html += '    <table>';
    html += '        <tr>';
    html += '            <td style="width: 120px; text-align: center" rowspan="4">';
    html += '                <img src="' + basePath + 'website/image/file_icon_'+data.mediaFormat+'.png" style="width:77px; height:77px; display: inline;">';
    html += '            </td>';
    html += '            <td style="width: 200px;"><span>名称</span>：'+data.name+'</td>';
    if(data.price == 0) {
        html += '            <td style="width: 150px;"><span>资源价格</span>：免费</td>';
    } else {
        html += '            <td style="width: 150px;"><span>资源价格</span>：'+data.price+'</td>';
    }
    html += '<td style="width: 200px;"><span>关键字</span>：';
    var a = data.keyWords.split(";");
    a.forEach(function(item){
        html += '<a href="'+basePath+'search/source?keyword="'+item+'></a>';
    });
    html += '</td>';
    html += '            <td style="width: 130px; text-align: center" rowspan="4">';
    html += '                <div class="topic-resource-btn">';
    if(onlineViewFormat.contains(data.mediaFormat+',')) {
        html += '                    <a href="'+basePath+'online/view?id='+data.id+'">在线预览</a>';
    }
    html += '                    <a href="'+basePath+'file/download?id='+data.id+'">下载资源</a>';
    html += '                </div>';
    html += '            </td>';
    html += '        </tr>';
    html += '        <tr>';
    html += '            <td><span>作者</span>：'+data.author+'</td>';
    html += '            <td><span>资源类型</span>：'+data.mediaType+'</td>';
    html += '            <td rowspan="3"><span>资源描述</span>：'+data.description+'M</td>';
    html += '        </tr>';
    html += '        <tr>';
    html += '            <td><span>出品方</span>：'+data.publisher+'</td>';
    html += '            <td><span>文件大小</span>：'+data.fileSize+'</td>';
    html += '        </tr>';
    html += '        <tr>';
    html += '            <td><span>访问次数</span>：'+data.viewTimes+'</td>';
    html += '            <td><span>下载次数</span>：'+data.useTimes+'</td>';
    html += '        </tr>';
    html += '    </table>';
    html += '</div>';
    return html;
}