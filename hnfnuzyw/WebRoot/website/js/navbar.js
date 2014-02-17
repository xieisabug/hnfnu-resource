window.addEvent('domready', function () {

    //搜索的下拉框
    var searchSelect = new Select('searchSelect',[
        {
            name:'站内资源',
            value:'站内资源'
        }
    ], {
        height:34,
        width:130
    }).animate().addButtonClass('btn-group-left').addButtonClass('btn-blue-border');
    //为了平衡ie浏览器的bug
    if(Browser.ie) {
        searchSelect.setSelectDivOffset(-55,8);
    }else {
        searchSelect.setSelectDivOffset(-55,35);
    }
    //搜索输入框
    var keyWords = new Input($$('#headSearch input'),{width:182}).addClass('input-group-center').addClass('btn-blue-border');
    //搜索按钮
    var searchButton = new Button($$('button')[1],{width:78}).addClass('btn-group-right').addClass('btn-blue-border');
    $$('#headMenu a').each(function(item,index) {
        var option = {
            width:120
        };
        if(index == 0){
            new Button(item,option).addClass('btn-group-left').addClass('btn-blue-border');
        } else if(index == 3) {
            new Button(item).addClass('btn-group-right').addClass('btn-blue-border');
        } else {
            new Button(item,option).addClass('btn-group-center').addClass('btn-blue-border');
        }
    });
});