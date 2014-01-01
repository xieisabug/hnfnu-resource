window.addEvent('domready', function () {
    var panel = new Panel($('topic-view-panel'), {
        contentHeight: 250
    });
    var searchSelect = new Select('searchSelect', [
        {
            name: '站内资源',
            value: '站内资源'
        },
        {
            name: '百度网盘',
            value: '百度网盘'
        }
    ], {
        height: 34
    }).animate().addButtonClass('btn-group-left');
    if (Browser.ie) {
        searchSelect.setSelectDivOffset(13, -46);
    } else {
        searchSelect.setSelectDivOffset(13, -19);
    }
    var keyWords = new Input($$('#headSearch input')).addClass('input-group-center');

    var searchButton = new Button($$('button')[1]).addClass('btn-group-right');
    new Tab('subtopic_tab', {
        tabChangeEvent: 'mouseover',
        tabTitleCss: 'tabTitle subtopic'
    });
    $$('#headMenu a').each(function (item, index) {
        var option = {
            width: 120
        };
        if (index == 0) {
            new Button(item, option).addClass('btn-group-left').addClass('btn-blue-border');
        } else if (index == 3) {
            new Button(item).addClass('btn-group-right').addClass('btn-blue-border');
        } else {
            new Button(item, option).addClass('btn-group-center').addClass('btn-blue-border');
        }

    });
    $$('.topic-resource-content button').each(function (item) {
        new Button(item, {width: 120});
    });
    $$('.topic-resource-content').each(function (item) {
        item.addEvent('mouseover',function () {
            item.getChildren('table .topic-resource-btn').setStyle('display', 'block');
        }).addEvent('mouseleave', function () {
            item.getChildren('table .topic-resource-btn').setStyle('display', 'none');
        });
    });
    /*$('more').addEvent('click',function(){
        new Request.JSON({
            url:"../topic/page",
            onSuccess:function(data){

            }
        }).get();
    });*/
});
function more(subtitleId){
    var move = $$('.tabContent.selected>.more');
    var page = move.getProperty("page");
    /*new Request.JSON({
        url:"../topic/page",
        onSuccess:function(data){
            var topicSources = data.topicSources;
            var joinSources = data.joinSources;
            var html = '',i = 0;
            for(i = 0; i<topicSources.length; i++) {
                html += generateSourceItem(topicSources[i]);
            }
            for(i = 0; i<joinSources.length; i++) {
                html += generateSourceItem(joinSources[i]);
            }
            move.inject(html,'before');
            if( (topicSources.length<8 && joinSources.length<8 ) ) {
                move.destroy();
            }
        }
    }).get({
            subtitleId : subtitleId,
            page:page+1
        });*/
    var html = new Elements();
    html.append(new Element('div',{
        html:"<p>我是插入的~~</p>"
    }));
    move.grab(html,'before');
    page++;
    move.setProperty("page",page);
}
function generateSourceItem(data) {

}