<%@ page import="com.hnfnu.zyw.dto.system.UserDto" %>
<%@ page import="com.hnfnu.zyw.dto.system.StudentDto" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserDto user = (UserDto) session.getAttribute("user");
    boolean login = false;
    String name = null;
    String icon = null;
    int balance = 0;
    Date latestLoginDate = null;
    String entranceTime = null;
    String department = null;
    String major = null;

    if (user == null) {
        StudentDto stu = (StudentDto) session.getAttribute("student");
        if (stu != null) {
            login = true;
            name = stu.getName();
            icon = stu.getIcon();
            balance = stu.getBalance();
            entranceTime = stu.getEntranceTime();
            department = stu.getDepartment();
            major = stu.getMajor();
        }
    } else {
        login = true;
        name = user.getName();
        icon = user.getIcon();
        balance = user.getBalance();
        latestLoginDate = user.getLatestLoginDate();
    }
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link href="css/index.css" type="text/css" rel="stylesheet">
    <link href="css/xkui.css" type="text/css" rel="stylesheet">
    <script src="js/mootools.js" type="text/javascript"></script>
    <script src="js/xkui.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="js/gallery.js"></script>
</head>
<body>
<%@ include file="header.html" %>
<div id="allContent">
    <%@ include file="navbar.html" %>
    <div class="row">
        <div id="loginDialog"></div>
        <div id="login">
            <div>
                <div class="panel-head-icon"></div>
                <span>用户登陆</span>
            </div>
            <div>
                <%
                    if (!login) {
                %>
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
                        <img id="imgObj" alt="" src="../website/captchaImg" style="z-index: 9999">
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
                <%
                } else {
                %>
                <table>
                    <tr>
                        <td rowspan="4" style="width:75px;">
                            <img src="<%=icon%>" style="width:75px;height:75px;">
                            <button id="logout_btn">
                                退出登录
                            </button>
                        </td>
                        <td>
                            <%=name%>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            资源币:<%=balance%>
                        </td>
                    </tr>
                    <%
                        if (entranceTime == null) {
                    %>
                    <tr>
                        <td>
                            您上次登录的时间是：
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <%=latestLoginDate%>
                        </td>
                    </tr>
                    <%
                    } else {
                    %>
                    <tr>
                        <td>
                            <%=entranceTime%>级
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <%=department%> 系 <%=major%> 专业
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <%
                    }
                %>
            </div>
        </div>
        <%@ include file="gallery.html" %>
        <div id="source-count">
            <div>
                <div class="panel-head-icon"></div>
                <span>资源统计</span>
            </div>
            <div>
                <div>
                    <ul>
                        <li>资源总数量：&nbsp;&nbsp;<a href="#">12356 个</a></li>
                        <li>资源总容量：&nbsp;&nbsp;<a href="#">1235 GB</a></li>
                        <li>资源总下载：&nbsp;&nbsp;<a href="#">12356 次</a></li>
                        <li>专题总数量：&nbsp;&nbsp;<a href="#">12356 个</a></li>
                        <li>注册用户数：&nbsp;&nbsp;<a href="#">12356 人</a></li>
                        <li>总访问数量：&nbsp;&nbsp;<a href="#">99999 次</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="topic.html" %>
    <%@ include file="tabGroup.html" %>
    <%@ include file="footer.html" %>
</div>
</body>
</html>