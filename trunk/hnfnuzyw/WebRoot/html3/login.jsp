<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="login">
    <div>
        <div class="panel-head-icon"></div>
        <span>用户登陆</span>
    </div>
    <div>
        <div>
            <label for="username">用户名</label>
            <!--<span>用户名：</span>-->
            <input class="form-control" type="text" id="username"
                   name="username" placeholder="请输入用户名">
        </div>
        <div>
            <label for="password">密&nbsp;&nbsp;码</label>
            <!--<span>密码：</span>-->
            <input class="form-control" type="password" id="password"
                   name="password" placeholder="请输入密码">
        </div>
        <div>
            <label for="role">身&nbsp;&nbsp;份</label>
            <button type="button" id="role" style="width: 128px;">
                学生
            </button>
        </div>
        <div>
            <label for="captcha">验证码</label>
            <!--<span>密码：</span>-->
            <input class="form-control" type="text" id="captcha"
                   name="captcha" placeholder="输入弹出的验证码">
            <div id="captchaDiv">
                <img id="imgObj" alt="" src="../website/captchaImg">
                <a href="#" onclick="changeImg()" style="font-size: 0.8em;">换一张</a>
            </div>
        </div>
        <div>
            <button id="login_btn">
                <span class="btn-login-icon"></span>
                登陆
            </button>
            <button id="register_btn">
                <span class="btn-register-icon"></span>
                注册
            </button>
        </div>
        <div class="p-small-font align-right">
            <p>忘记密码？请<a href="#">点击这里</a></p>
        </div>
    </div>
</div>
</body>
</html>