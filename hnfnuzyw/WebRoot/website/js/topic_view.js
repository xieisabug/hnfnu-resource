window.addEvent('domready', function () {
    var panel = new Panel($('topic-view-panel'), {
        contentHeight: 250
    });

    new Tab('subtopic_tab', {
        tabChangeEvent: 'mouseover',
        tabTitleCss: 'tabTitle subtopic'
    });

    initStyleAndEvent();
});

function initStyleAndEvent() {
    $$('.topic-resource-content a').each(function (item) {
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

function more(subtitleId){
    var move = $$('.tabContent.selected>.more');
    var content =  $$('.tabContent.selected')[0];
    var page = move.getProperty("page");
    page++;
    new Request.JSON({
        url:"../topic/page",
        onSuccess:function(data){
            var oldH = content.getScrollSize().y;
            var topicSources = data.topicSources;
            var joinSources = data.joinSources;
            var html = '',i = 0;
            for(i = 0; i<topicSources.length; i++) {
                html += generateSourceItem(topicSources[i]);
            }
            for(i = 0; i<joinSources.length; i++) {
                html += generateSourceItem(joinSources[i]);
            }
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
            if( (topicSources.length<8 && joinSources.length<8 ) ) {
                move.destroy();
            }
        }
    }).get({
            subtitleId : subtitleId,
            pageIndex:page
        });

    move.setProperty("page",page);
}
function generateSourceItem(data) {
    var html = '';
    html += '<div class="topic-resource-content">';
    html += '    <table>';
    html += '        <tr>';
    html += '            <td style="width: 140px; text-align: center" rowspan="3">';
    html += '                <img src="' + basePath + 'website/image/file_icon_'+data.mediaFormat+'.png" style="width:77px; height:77px; display: inline;">';
    html += '            </td>';
    html += '            <td style="width: 340px;"><span>资源名</span>：'+data.sourceName+'</td>';
    if(data.price == 0) {
        html += '            <td style="width: 200px;"><span>资源币</span>：免费</td>';
    } else {
        html += '            <td style="width: 200px;"><span>资源币</span>：'+data.price+'</td>';
    }
    html += '            <td style="width: 130px; text-align: center" rowspan="3">';
    html += '                <div class="topic-resource-btn">';
    if(onlineViewFormat.contains(data.mediaFormat+',')) {
        if(!data.sourceId) {
            html += '                    <a href="'+basePath+'online/view?id='+data.id+'&type=1">在线预览</a>';
        } else {
            html += '                    <a href="'+basePath+'online/view?id='+data.sourceId+'&type=2">在线预览</a>';
        }
    }
    if(!data.sourceId) {
        html += '                    <a href="'+basePath+'file/download?id='+data.id+'&type=1">下载资源</a>';
    } else {
        html += '                    <a href="'+basePath+'file/download?id='+data.sourceId+'&type=2">下载资源</a>';
    }
    html += '                </div>';
    html += '            </td>';
    html += '        </tr>';
    html += '        <tr>';
    html += '            <td><span>媒体类型</span>：'+data.mediaType+'</td>';
    html += '            <td><span>文件大小</span>：'+data.fileSize+'M</td>';
    html += '        </tr>';
    html += '        <tr>';
    html += '            <td><span>出版社</span>：'+data.publisher+'</td>';
    html += '            <td>&nbsp;</td>';
    html += '        </tr>';
    html += '    </table>';
    html += '</div>';
    return html;
}