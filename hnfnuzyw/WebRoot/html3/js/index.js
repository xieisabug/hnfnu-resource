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
    var keyWords = new Input($$('#headSearch input'),{width:236}).addClass('input-group-center');

    //用户名、密码输入
    var username = new Input($('username'),{width:100});
    var password = new Input($('password'),{width:100});

    //验证码输入框
    var captcha = new Input($('captcha'),{width:100});
    //验证码输入时弹出层
    var captchaDiv = $('captchaDiv');
    captcha.body.addEvent('focus',function(){
        changeImg();//每次点击输入框，都会重新生成验证码
        captchaDiv.setStyle('visibility','visible');
    });
    captcha.body.addEvent('blur',function(){
        captchaDiv.setStyle('visibility','hidden');
    });
    function changeImg(){
        var imgSrc = $("imgObj");
        var src = imgSrc.getAttribute("src");
        imgSrc.setAttribute("src",chgUrl(src));
    }
    function chgUrl(url){
        var timestamp = (new Date()).valueOf();//时间戳
        url = url.substring(0,21);
        if((url.indexOf("&")>=0)){
            //为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
            url = url + "×tamp=" + timestamp;
        }else{
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }
    //登陆方式的下拉列表
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

    //登陆和注册
    var loginBtn = new Button($('login_btn'),{width:85}).addClass('login-btn');
    var registBtn = new Button($('register_btn'),{width:85}).addClass('login-btn');
    var loginDialog = new Dialog($('loginDialog'),{
        width:300,
        height:100,
        left:300,
        top:200,
        position:'absolute',
        titleHtml:'<span style="margin-left: 30px;">错误</span>',
        draggable:true,
        model:false,
        closeable:true
    });
    loginBtn.body.addEvent('click',function(){
        new Request.JSON({
            url:"../website/login",
            onSuccess:function(data){
                if(data.success) {
                    console.log('success');
                    console.log(data);
                } else {
                    loginDialog.setContentHtml('<div style="padding: 10px">'+data.message+'</div>');
                    loginDialog.show();
                }
            }
        }).get({
                username:username.getValue(),
                password:password.getValue(),
                loginType:role.getValue()=="老师"?1:0,
                captcha:captcha.getValue()
            });
    });


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
    new Scroll($('topic-content'), {
        width:960,
        height:358
    }).withAnimate('fadeSlide');
});