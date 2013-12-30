<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%@ include file="header.html"%>
<div id="allContent">
<div class="navbar">
    <ul class="nav">
        <li class="active"><a href="#">首页</a></li>
        <li><a href="#">学科资源</a></li>
        <li><a href="#">专题资源</a></li>
        <li><a href="#">教学视频示范中心</a></li>
        <li><a href="#">教师职业技能训练</a></li>
        <li><a href="#">语言学科平台</a></li>
    </ul>
</div>

<div class="row">
    <div id="loginDialog"></div>
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
        </div>
    </div>
    <div id="gallery">
        <div id="idContainer2" class="container">
            <table id="idSlider2" cellSpacing=0 cellPadding=0>
                <tr>
                    <td class="td_f">
                        <a target="_blank" href="http://www.baidu.com">
                            <IMG src="../uploads/2013111719475571.jpg">
                        </a>
                    </td>
                    <td class="td_f">
                        <a target="_blank" href="http://www.baidu.com">
                            <IMG src="../uploads/2013111719481912.jpg">
                        </a>
                    </td>
                    <td class="td_f">
                        <a target="_blank" href="http://www.baidu.com/">
                            <IMG src="../uploads/2013111719485623.jpg">
                        </a>
                    </td>
                    <td class="td_f">
                        <a target="_blank" href="http://www.baidu.com/">
                            <IMG src="../uploads/2013111719491574.jpg">
                        </a>
                    </td>
                    <td class="td_f">
                        <a target="_blank" href="http://www.baidu.com/">
                            <IMG src="../uploads/2013111719505345.jpg">
                        </a>
                    </td>
                    <td class="td_f">
                        <a target="_blank" href="http://www.baidu.com/">
                            <IMG src="../uploads/2013111719510311.jpg">
                        </a>
                    </td>
                    <td class="td_f">
                        <a target="_blank" href="http://www.baidu.com/">
                            <IMG src="../uploads/2013111719514532.jpg">
                        </a>
                    </td>
                </tr>
            </table>
            <ul id="idNum" class="num"></ul>
        </div>
    </div>
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
<div class="row">
    <div id="topic">
        <div>
            <div class="panel-head-icon"></div>
            <span>专题资源</span>
        </div>
        <div id="topic-content">
            <div>
                <table>
                    <tr>
                        <td>
                            <a href="#">
                                <img src="image/topic_01.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">小学计算机教学</div>
                                    <div class="topic-description">全国中小学电脑制作活动-获奖作品精选</div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                <img src="image/topic_02.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">优秀少儿短片</div>
                                    <div class="topic-description">大头儿子小头爸爸 小头儿子大头爸爸</div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                <img src="image/topic_03.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">世界地理知识</div>
                                    <div class="topic-description">亚洲：希望之旅 非洲：神秘之旅 欧洲：风情之旅......
                                    </div>
                                </div>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="#">
                                <img src="image/topic_03.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">世界地理知识</div>
                                    <div class="topic-description">亚洲：希望之旅 非洲：神秘之旅 欧洲：风情之旅......
                                    </div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                <img src="image/topic_03.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">世界地理知识</div>
                                    <div class="topic-description">亚洲：希望之旅 非洲：神秘之旅 欧洲：风情之旅......
                                    </div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                <img src="image/topic_03.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">世界地理知识</div>
                                    <div class="topic-description">亚洲：希望之旅 非洲：神秘之旅 欧洲：风情之旅......
                                    </div>
                                </div>
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
            <div>
                <table>
                    <tr>
                        <td>
                            <a href="#">
                                <img src="image/topic_01.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">小学计算机教学</div>
                                    <div class="topic-description">全国中小学电脑制作活动-获奖作品精选</div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                <img src="image/topic_02.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">优秀少儿短片</div>
                                    <div class="topic-description">大头儿子小头爸爸 小头儿子大头爸爸</div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                <img src="image/topic_03.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">世界地理知识</div>
                                    <div class="topic-description">亚洲：希望之旅 非洲：神秘之旅 欧洲：风情之旅......
                                    </div>
                                </div>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="#">
                                <img src="image/topic_03.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">世界地理知识</div>
                                    <div class="topic-description">亚洲：希望之旅 非洲：神秘之旅 欧洲：风情之旅......
                                    </div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                <img src="image/topic_03.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">世界地理知识</div>
                                    <div class="topic-description">亚洲：希望之旅 非洲：神秘之旅 欧洲：风情之旅......
                                    </div>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                <img src="image/topic_03.jpg">

                                <div class="topic-item">
                                    <div class="topic-title">世界地理知识</div>
                                    <div class="topic-description">亚洲：希望之旅 非洲：神秘之旅 欧洲：风情之旅......
                                    </div>
                                </div>
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="row">
<div id="collageSource">
<ul>
    <li>教育学</li>
    <li>心理学</li>
    <li>音乐学</li>
    <li>美术学</li>
    <li>设计学</li>
    <li>经济学</li>
</ul>
<div>
    <!-- 轮转内容的div -->
    <div>
        <table>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
    <div>
        <table>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
<div>
    <div>
        <table>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
<div>
    <div>
        <table>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
<div>
    <div>
        <table>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
<div>
    <div>
        <table>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
<div>
    <div>
        <table>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
                <td class="subject-item">
                    <table>
                        <tr>
                            <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                            <td style="font-weight: bolder;">教育心理学</td>
                        </tr>
                        <tr>
                            <td>湖南一师一附小</td>
                        </tr>
                        <tr>
                            <td style="color:#0099ff;">浏览次数：123456</td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
</div>
</div>

<div class="row">
<div id="primarySource">
<ul>
    <li>小学一年级</li>
    <li>小学二年级</li>
    <li>小学三年级</li>
    <li>小学四年级</li>
    <li>小学五年级</li>
    <li>小学六年级</li>
</ul>
<div>
    <div>
        <div>
            <table>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div>
    <div>
        <div>
            <table>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div>
    <div>
        <div>
            <table>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div>
    <div>
        <div>
            <table>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div>
    <div>
        <div>
            <table>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div>
    <div>
        <div>
            <table>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                    <td class="subject-item">
                        <table>
                            <tr>
                                <td rowspan="3" style="width: 80px;"><img src="image/subject-item.png" alt="查看学科资源" /></td>
                                <td style="font-weight: bolder;">教育心理学</td>
                            </tr>
                            <tr>
                                <td>湖南一师一附小</td>
                            </tr>
                            <tr>
                                <td style="color:#0099ff;">浏览次数：123456</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</div>
</div>
<div class="row">
    <div style="text-align: center">
        <p>版权所有：湖南第一师范学院公共实验管理中心·湘ICP备05000548号</p>
        <p>地址：湖南省长沙市枫林三路1015号·邮编：410205·电话：0731-82841118</p>
        <p>建议使用IE 8版本以上浏览器浏览</p>
    </div>
</div>
</div>
</body>
</html>