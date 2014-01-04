<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="css/xkui.css" type="text/css" rel="stylesheet">
    <link href="css/index.css" type="text/css" rel="stylesheet">
    <!--<link href="css/ui.css" type="text/css" rel="stylesheet">-->

    <script src="js/mootools.js" type="text/javascript"></script>
    <script src="js/xkui.js" type="text/javascript"></script>
    <script src="js/choose_view.js" type="text/javascript"></script>

    <!--<script type="text/javascript" src="js/index.js"></script>-->
    <!--<script type="text/javascript" src="js/gallery.js"></script>-->
    <style type="text/css">
        .choose-list>ul>li {
            float: left;
            margin-left: 25px;
            width: 90px;
            height: 20px;
            padding-top: 5px;
            font-size: 0.9em;
        }
        #more {
            cursor: pointer;
            margin: 0 auto;
            width: 50px;
            height: 20px;
            background: url(image/arrow_down.png) no-repeat;
            opacity: 0.6;
        }
        #more:hover {
            opacity: 1;
        }
    </style>
    <title>专题</title>
</head>
<body>
<div id="headContent" style="height: 90px;">
    <div id="headLogo"></div>
    <div id="headMenu">
        <div class="btn-group">
            <a href="#">湖南第一师范学院</a><a href="#">公馆实验管理中心</a><a href="#">联系我们</a><a href="#">添加收藏</a>
        </div>
    </div>
    <div id="headSearch">
        <button id="searchSelect">站内资源</button>
        <input type="text" style="width: 270px; *padding:0;">
        <button type="button">搜索</button>
    </div>
</div>

<div id="topic-view">
    <div class="row">
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
        <div style="margin-top: 10px; font-size: 0.8em">
            您的位置：<a href="#">首页</a> > <a href="#">学科资源</a>
        </div>
    </div>
    <div class="row" id="choose-accordion">
        <div class="choose-type">
            <div class="panel-head-icon"></div>
            <span>选择学科</span>
        </div>
        <div class="choose-list">
            <ul>
                <li><a href="#">数学</a></li>
                <li><a href="#">语文</a></li>
                <li><a href="#">英语</a></li>
                <li><a href="#">自然</a></li>
                <li><a href="#">数学</a></li>
                <li><a href="#">语文</a></li>
                <li><a href="#">英语</a></li>
                <li><a href="#">自然</a></li>
                <li><a href="#">数学</a></li>
                <li><a href="#">语文</a></li>
                <li><a href="#">英语</a></li>
                <li><a href="#">自然</a></li>
                <li><a href="#">数学</a></li>
                <li><a href="#">语文</a></li>
                <li><a href="#">英语</a></li>
                <li><a href="#">自然</a></li>
            </ul>
        </div>
        <div class="choose-type">
            <div class="panel-head-icon"></div>
            <span>选择学科</span>
        </div>
        <div class="choose-list">
            <ul>
                <li><a href="#">数学</a></li>
                <li><a href="#">语文</a></li>
                <li><a href="#">英语</a></li>
                <li><a href="#">自然</a></li>
                <li><a href="#">数学</a></li>
                <li><a href="#">语文</a></li>
                <li><a href="#">英语</a></li>
                <li><a href="#">自然</a></li>
                <li><a href="#">数学</a></li>
                <li><a href="#">语文</a></li>
                <li><a href="#">英语</a></li>
                <li><a href="#">自然</a></li>
                <li><a href="#">数学</a></li>
                <li><a href="#">语文</a></li>
                <li><a href="#">英语</a></li>
                <li><a href="#">自然</a></li>
            </ul>
        </div>
    </div>
    <div class="row" id="show-panel">
        <div>
            <div class="panel-head-icon"></div>
            <span></span>
        </div>
        <div>
            <div class="topic-resource-content">
                <table>
                    <tr>
                        <td style="width: 140px; text-align: center" rowspan="3">
                            <img src="image/topic_01.jpg" style="width:77px; height:77px; display: inline;">
                        </td>
                        <td style="width: 340px;"><span>资源名</span>：大头儿子小头爸爸 第一季 第二集 第三段</td>
                        <td style="width: 200px;"><span>资源币</span>：免费</td>
                        <td style="width: 130px; text-align: center" rowspan="3">
                            <div class="topic-resource-btn">
                                <button value="在线预览" onclick="">在线预览</button>
                                <button value="下载资源" onclick="">下载资源</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><span>媒体类型</span>：动画</td>
                        <td><span>文件大小</span>：210M</td>
                    </tr>
                    <tr>
                        <td><span>出版社</span>：中国人民美术公司</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </div>
            <div class="topic-resource-content">
                <table>
                    <tr>
                        <td style="width: 140px; text-align: center" rowspan="3">
                            <img src="image/topic_01.jpg" style="width:77px; height:77px; display: inline;">
                        </td>
                        <td style="width: 340px;"><span>资源名</span>：大头儿子小头爸爸 第一季 第二集 第三段</td>
                        <td style="width: 200px;"><span>资源币</span>：免费</td>
                        <td style="width: 130px; text-align: center" rowspan="3">
                            <div class="topic-resource-btn">
                                <button value="在线预览" onclick="">在线预览</button>
                                <button value="下载资源" onclick="">下载资源</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><span>媒体类型</span>：动画</td>
                        <td><span>文件大小</span>：210M</td>
                    </tr>
                    <tr>
                        <td><span>出版社</span>：中国人民美术公司</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </div>
            <div class="topic-resource-content">
                <table>
                    <tr>
                        <td style="width: 140px; text-align: center" rowspan="3">
                            <img src="image/topic_01.jpg" style="width:77px; height:77px; display: inline;">
                        </td>
                        <td style="width: 340px;"><span>资源名</span>：大头儿子小头爸爸 第一季 第二集 第三段</td>
                        <td style="width: 200px;"><span>资源币</span>：免费</td>
                        <td style="width: 130px; text-align: center" rowspan="3">
                            <div class="topic-resource-btn">
                                <button value="在线预览" onclick="">在线预览</button>
                                <button value="下载资源" onclick="">下载资源</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><span>媒体类型</span>：动画</td>
                        <td><span>文件大小</span>：210M</td>
                    </tr>
                    <tr>
                        <td><span>出版社</span>：中国人民美术公司</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </div>
            <div class="topic-resource-content">
                <table>
                    <tr>
                        <td style="width: 140px; text-align: center" rowspan="3">
                            <img src="image/topic_01.jpg" style="width:77px; height:77px; display: inline;">
                        </td>
                        <td style="width: 340px;"><span>资源名</span>：大头儿子小头爸爸 第一季 第二集 第三段</td>
                        <td style="width: 200px;"><span>资源币</span>：免费</td>
                        <td style="width: 130px; text-align: center" rowspan="3">
                            <div class="topic-resource-btn">
                                <button value="在线预览" onclick="">在线预览</button>
                                <button value="下载资源" onclick="">下载资源</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><span>媒体类型</span>：动画</td>
                        <td><span>文件大小</span>：210M</td>
                    </tr>
                    <tr>
                        <td><span>出版社</span>：中国人民美术公司</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </div>
            <div id="more"></div>
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
</body>
</html>