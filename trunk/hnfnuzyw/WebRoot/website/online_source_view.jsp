<%@ page import="com.hnfnu.zyw.vo.SourceVo" %>
<%@ page import="com.hnfnu.zyw.vo.TopicSubtitleSourceVo" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String type = (String) request.getAttribute("type");
    String sourceName;
    String keyWords;
    String mediaFormat;
    String mediaType;
    String fileSize;
    String description;
    Integer viewTimes;
    Integer useTimes;
    double price;

    if(type.equals("source")) {
        SourceVo source = (SourceVo) request.getAttribute("source");
        sourceName = source.getName();
        keyWords = source.getKeyWords();
        mediaFormat = source.getMediaFormat();
        mediaType = source.getMediaType();
        fileSize = source.getFileSize();
        description = source.getDescription();
        viewTimes = source.getViewTimes();
        useTimes = source.getUseTimes();
        price = source.getPrice();
    } else {
        TopicSubtitleSourceVo topicSubtitleSourceVo = (TopicSubtitleSourceVo) request.getAttribute("source");
        sourceName = topicSubtitleSourceVo.getSourceName();
        keyWords = topicSubtitleSourceVo.getKeyWords();
        mediaFormat = topicSubtitleSourceVo.getMediaFormat();
        mediaType = topicSubtitleSourceVo.getMediaType();
        fileSize = topicSubtitleSourceVo.getFileSize();
        description = topicSubtitleSourceVo.getRemark();
        viewTimes = topicSubtitleSourceVo.getViewTimes();
        useTimes = topicSubtitleSourceVo.getUseTimes();
        price = topicSubtitleSourceVo.getPrice();
    }
    List<Map<String,Object>> sourceCommentTree = (List<Map<String, Object>>) request.getAttribute("sourceCommentTree");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="css/xkui.css" type="text/css" rel="stylesheet">
    <link href="css/index.css" type="text/css" rel="stylesheet">
    <!--<link href="css/ui.css" type="text/css" rel="stylesheet">-->

    <script src="js/mootools.js" type="text/javascript"></script>
    <script src="js/xkui.js" type="text/javascript"></script>
    <script src="js/online_source_view.js" type="text/javascript"></script>
    <!--<script type="text/javascript" src="js/index.js"></script>-->
    <!--<script type="text/javascript" src="js/gallery.js"></script>-->

    <title>在线预览</title>
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
            您的位置：<a href="#">首页</a> > <a href="javascript:void(0)">在线预览</a>
        </div>
    </div>
    <div class="row">
        <div id="source-info-panel">
            <div>
                <div class="panel-head-icon"></div>
                <span>资源信息</span>
            </div>
            <div>
                <div id="source-info-content">
                    <table>
                        <tr>
                            <td>资源名：</td>
                            <td><%=sourceName%></td>
                        </tr>
                        <tr>
                            <td>关键字：</td>
                            <td><%=keyWords%></td>
                        </tr>
                        <tr>
                            <td>媒体类型：</td>
                            <td><%=mediaType%></td>
                        </tr>
                        <tr>
                            <td>媒体格式：</td>
                            <td><%=mediaFormat%></td>
                        </tr>
                        <tr>
                            <td>文件大小：</td>
                            <td><%=fileSize%>M</td>
                        </tr>
                        <tr>
                            <td>简介：</td>
                            <td><%=description%></td>
                        </tr>
                        <tr>
                            <td>浏览次数：</td>
                            <td><%=viewTimes%></td>
                        </tr>
                        <tr>
                            <td>下载次数：</td>
                            <td><%=useTimes%></td>
                        </tr>
                        <tr>
                            <td>下载价格：</td>
                            <td><%=price%></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div id="online-view-panel">
            <div>
                <div class="panel-head-icon"></div>
                <span>在线预览</span>
            </div>
            <div>
                <h3 style="float: left; margin-right: 20px; width: 500px; overflow: hidden;"><%=sourceName%></h3>
                <a id="downloadBtn" href="#">下载资源</a>
                <div id="webPlayer">
                    网速过慢，正在载入播放器，请稍等。。。。
                </div>
            </div>
        </div>
        <div id="comment-panel">
            <div>
                <div class="panel-head-icon"></div>
                <span>评论</span>
            </div>
            <div>
                <div id="comment-content">
                    <%
                        for (Map<String,Object> comments:sourceCommentTree) {

                        }
                    %>
                    <div class="comment-item">
                        <table>
                            <tr>
                                <td rowspan="2">
                                    <img src="image/user1.jpg">
                                    <p>admin</p>
                                </td>
                                <td>2013-12-17 20:22:36 <a href="javascript:void(0)">回复</a></td>
                            </tr>
                            <tr>
                                <td>不错！很好看！</td>
                            </tr>
                        </table>
                    </div>
                    <div class="comment-sub-item">
                        <table>
                            <tr>
                                <td rowspan="2">
                                    <img src="image/user1.jpg">
                                    <p>guest</p>
                                </td>
                                <td>2013-12-17 20:22:36 <a href="javascript:void(0)">回复</a></td>
                            </tr>
                            <tr>
                                <td>//@天秤先森-:你告诉我，四岁小孩会装什么//@原色男装 :他都会装.那你的脑袋里面装的是什么东西呀？ //@ty54138937486 :裝？？？O~M~G .......//@yusimida :真的从一开始就不喜欢kimi 觉得他一点都不懂事不听话，也很装。最喜欢天天和安吉拉，单纯可爱。 心地还很善良。泥马你咋真贱贱啊 他咋装了 四岁小孩装的累不累啊 Kimi一点也不装 可爱死了</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <textarea id="replyTextarea"></textarea>
                <button id="replyBtn" value="发表评论">发表评论</button>
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
</body>
<script type="text/javascript" src="js/jwplayer.js"></script>
<script type="text/javascript">
    jwplayer("webPlayer").setup({
        flashplayer : "player.swf",
        file: '../uploads/201311241909381test.mp4'
    });
</script>
</html>
