window.addEvent('domready',function(){
    var loginPanel = new Panel($('login'),{
        contentHeight:220
    });
    var countPanel = new Panel($('source-count'),{
        contentHeight:220
    });
    var topicPanel = new Panel($('topic'),{
        contentHeight:358
    });
    var searchSelect = new Select('searchSelect',[
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
    if(Browser.ie) {
        searchSelect.setSelectDivOffset(13,-46);
    }else {
        searchSelect.setSelectDivOffset(13,-19);
    }
    var keyWords = new Input($$('#headSearch input')).addClass('input-group-center');
    var username = new Input($('username'),{width:100});
    var password = new Input($('password'),{width:100});
    var captcha = new Input($('captcha'),{width:100});
    var role = new Select('role',[
        {
            name:'老师',
            value:'老师'
        },
        {
            name:'学生',
            value:'学生'
        }
    ],{width:125}).animate();
    var loginBtn = new Button($('login_btn'),{width:85}).addClass('login-btn');
    var registBtn = new Button($('register_btn'),{width:85}).addClass('login-btn');

    var searchButton = new Button($$('button')[1]).addClass('btn-group-right');
    var collageSource = new Tab('collageSource', {
        tabChangeEvent:'mouseover',
        tabTitleCss:'my-tab',
        tabContentCss:'my-tabContent'
    });
    var primarySource = new Tab('primarySource', {
        tabChangeEvent:'mouseover',
        tabTitleCss:'my-tab',
        tabContentCss:'my-tabContent'
    });
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
    $$('#collageSource>div').each(function(item){
        new Scroll(item,{
            width:960,
            height:200
        }).withAnimate('fadeSlide');
    });
    $$('#primarySource>div').each(function(item){
        new Scroll(item,{
            width:960,
            height:200
        }).withAnimate('fadeSlide');
    });
    var topicContent = $('topic-content');
    new Scroll(topicContent, {
        width:960,
        height:358
    }).withAnimate('fadeSlide');

});