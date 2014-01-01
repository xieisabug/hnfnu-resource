window.addEvent('domready',function(){
    //登陆面板
    var loginPanel = new Panel($('login'),{
        contentHeight:220
    });
    //统计面板
    var countPanel = new Panel($('source-count'),{
        contentHeight:220
    });
    //专题面板
    var topicPanel = new Panel($('topic'),{
        contentHeight:358
    });
    //搜索的下拉框
    var searchSelect = new Select('searchSelect',[
        {
            name:'站内资源',
            value:'站内资源'
        }
    ], {
        height:34
    }).animate().addButtonClass('btn-group-left');
    //为了平衡ie浏览器的bug
    if(Browser.ie) {
        searchSelect.setSelectDivOffset(13,-46);
    }else {
        searchSelect.setSelectDivOffset(13,-19);
    }
    //搜索输入框
    var keyWords = new Input($$('#headSearch input'),{width:236}).addClass('input-group-center');
    //搜索按钮
    var searchButton = new Button($$('button')[1]).addClass('btn-group-right');

    if($('username')) {
        registNoLoginEvent();
    } else {
        registLoginEvent();
    }

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
    //登陆时出错弹出的登陆框
    var loginDialog = new Dialog($('loginDialog'),{
        width:200,
        height:80,
        left:300,
        top:200,
        position:'absolute',
        titleHtml:'<span style="margin-left: 30px;">错误</span>',
        draggable:true,
        model:false,
        closeable:true
    });
    //生成所有tab
    $$(".tabGroupItem").each(function(item){
        new Tab(item, {
            tabChangeEvent:'mouseover',
            tabTitleCss:'my-tab',
            tabContentCss:'my-tabContent'
        });
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
    //生成所有滚动
    $$('.tabGroupItem>div').each(function(item){
        new Scroll(item,{
            width:960,
            height:200
        }).withAnimate('fadeSlide');
    });

    //生成专题的滚动
    new Scroll($('topic-content'), {
        width:960,
        height:358
    }).withAnimate('fadeSlide');

    //未登陆的初始化
    function registNoLoginEvent(){
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
        //登陆逻辑
        loginBtn.body.addEvent('click',function(){
            new Request.JSON({
                url:"../website/login",
                onSuccess:function(data){
                    if(data.success) {
                        loginShow(data);
                    } else {
                        loginDialog.setContentHtml('<div style="padding: 10px;">'+data.message+'</div>');
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
    }

    //登录后的初始化
    function registLoginEvent(){
        var logoutBtn = new Button($('logout_btn'),{width:85});
        logoutBtn.body.addEvent('click',function(){
            new Request.JSON({
                url:"../website/exit",
                onSuccess:function(data){
                    if(data.success) {
                        noLoginShow();
                    }
                }
            }).get();
        });
    }
    //没有登录时，显示
    function noLoginShow(){
        var html = '';
        html +='<div>';
        html +='    <label for="username">用户名</label>';
        html +='    <input class="form-control" type="text" id="username"';
        html +='           name="username" placeholder="请输入用户名">';
        html +='</div>';
        html +='<div>';
        html +='    <label for="password">密&nbsp;&nbsp;码</label>';
        html +='    <input class="form-control" type="password" id="password"';
        html +='           name="password" placeholder="请输入密码">';
        html +='</div>';
        html +='<div>';
        html +='    <label for="role">身&nbsp;&nbsp;份</label>';
        html +='    <button type="button" id="role" style="width: 128px;">';
        html +='        学生';
        html +='    </button>';
        html +='</div>';
        html +='<div>';
        html +='    <label for="captcha">验证码</label>';
        html +='    <input class="form-control" type="text" id="captcha"';
        html +='           name="captcha" placeholder="输入弹出的验证码">';
        html +='    <div id="captchaDiv">';
        html +='        <img id="imgObj" alt="" src="../website/captchaImg" style="z-index: 9999">';
        html +='    </div>';
        html +='</div>';
        html +='<div>';
        html +='    <button id="login_btn">';
        html +='        <span class="btn-login-icon"></span>';
        html +='        登陆';
        html +='    </button>';
        html +='    <button id="register_btn">';
        html +='        <span class="btn-register-icon"></span>';
        html +='        注册';
        html +='    </button>';
        html +='</div>';
        html +='<div class="p-small-font align-right">';
        html +='    <p>忘记密码？请<a href="#">点击这里</a></p>';
        html +='</div>';
        loginPanel.updateWithAnimate('toggle',html,function(){
            registNoLoginEvent();
        });
    }

    //登录时显示
    function loginShow(data){
        var html = '';
        html +='<table style="font-size:0.8em;height:200px;">	';
        html +='	<tr>';
        html +='		<td rowspan="4" style="width:75px;" >';
        html +='			<img src="'+data.info.icon+'" style="width:75px;height:75px;" >';
        html +='			<button id="logout_btn">';
        html +='				退出登录';
        html +='			</button>';
        html +='		</td>';
        html +='		<td>';
        html +=data.info.name;
        html +='		</td>';
        html +='	</tr>';
        html +='	<tr>';
        html +='		<td>';
        html +='			资源币:' + data.info.balance;
        html +='		</td>';
        html +='	</tr>';
        html +='	<tr>';
        html +='		<td>';
        if(data.info.department) {
            html += data.info.entranceTime + "级 " +  data.info.department + "系";
            html +='		</td>';
            html +='	</tr>';
        } else {
            html +='			您上次登录的时间是：';
            html +='		</td>';
            html +='	</tr>';
            html +='	<tr>';
            html +='		<td>';
            html +='		' + data.info.lastedLoginDate;
            html +='		</td>';
            html +='	</tr>';
        }
        html +='</table>';
        //面板伸缩后更新html
        loginPanel.updateWithAnimate('toggle',html,function(){
            registLoginEvent();
        });
    }
});