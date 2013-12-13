window.addEvent('domready',function(){
    new Select('searchSelect',[
        {
            name:'站内资源',
            value:'站内资源'
        },
        {
            name:'百度网盘',
            value:'百度网盘'
        }
    ], {
        height:34
    }).animate().addButtonClass('btn-group-left');
    new Tab('subtopic_tab', {
        tabChangeEvent:'mouseover',
        tabTitleCss:'tabTitle subtopic'
    });
    $$('#headMenu a').each(function(item,index) {
        var option = {
            width:120
        };
        if(index == 0){
            new Button(item,option).addClass('btn-group-left');
        } else if(index == 3) {
            new Button(item).addClass('btn-group-right');
        } else {
            new Button(item,option).addClass('btn-group-center');
        }

    });
});