<%@ page import="com.hnfnu.zyw.vo.SourceVo" %>
<%@ page import="com.hnfnu.zyw.vo.TopicSubtitleSourceVo" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hnfnu.zyw.vo.SourceCommentVo" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String type = (String) request.getAttribute("type");
    boolean couldComment = false;
    int sourceId;
    String sourceName;
    String keyWords;
    String mediaFormat;
    String mediaType;
    Float fileSize;
    String description;
    Integer viewTimes;
    Integer useTimes;
    double price;
    String url;
    boolean login = false;
    if(session.getAttribute("user") != null) {
        login = true;
    }

    if(type.equals("source")) {
        couldComment = true;
        SourceVo source = (SourceVo) request.getAttribute("source");
        sourceId = source.getId();
        sourceName = source.getName();
        keyWords = source.getKeyWords();
        mediaFormat = source.getMediaFormat();
        mediaType = source.getMediaType();
        fileSize = source.getFileSize();
        description = source.getDescription();
        viewTimes = source.getViewTimes();
        useTimes = source.getUseTimes();
        price = source.getPrice();
        url = source.getUrl();
    } else {
        TopicSubtitleSourceVo topicSubtitleSourceVo = (TopicSubtitleSourceVo) request.getAttribute("source");
        sourceId = topicSubtitleSourceVo.getId();
        sourceName = topicSubtitleSourceVo.getSourceName();
        keyWords = topicSubtitleSourceVo.getKeyWords();
        mediaFormat = topicSubtitleSourceVo.getMediaFormat();
        mediaType = topicSubtitleSourceVo.getMediaType();
        fileSize = topicSubtitleSourceVo.getFileSize();
        description = topicSubtitleSourceVo.getRemark();
        viewTimes = topicSubtitleSourceVo.getViewTimes();
        useTimes = topicSubtitleSourceVo.getUseTimes();
        price = topicSubtitleSourceVo.getPrice();
        url = topicSubtitleSourceVo.getUrl();
    }
    url = url.replace("\\","/");

    List<Map<String,Object>> sourceCommentTree = (List<Map<String, Object>>) request.getAttribute("sourceCommentTree");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="<%=basePath%>website/css/xkui.css" type="text/css" rel="stylesheet">
    <link href="<%=basePath%>website/css/index.css" type="text/css" rel="stylesheet">
    <!--<link href="css/ui.css" type="text/css" rel="stylesheet">-->

    <script src="<%=basePath%>website/js/mootools.js" type="text/javascript"></script>
    <script src="<%=basePath%>website/js/xkui.js" type="text/javascript"></script>
    <script src="<%=basePath%>website/js/online_source_view.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=basePath%>website/js/navbar.js"></script>
    <!--<script type="text/javascript" src="js/index.js"></script>-->
    <script type="text/javascript">
        var basePath='<%=basePath%>';
    </script>

    <title>在线预览</title>
</head>
<body>
<%@ include file="header.html"%>

<div id="topic-view">
    <div class="row">
        <%@ include file="navbar.html"%>
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
                            <input type="hidden" id="sourceId" value="<%=sourceId%>">
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
                        if(couldComment) {
                            for (Map<String,Object> comments:sourceCommentTree) {
                                SourceCommentVo sourceCommentVo = (SourceCommentVo) comments.get("sourceComment");
                    %>
                        <div class="comment-item">
                            <table>
                                <tr>
                                    <td rowspan="2">
                                        <img src="<%=basePath+"uploads/user/image/"+sourceCommentVo.getCreateIcon()%>">
                                        <p><%=sourceCommentVo.getCreateName()%></p>
                                    </td>
                                    <td><% out.print(sdf.format(sourceCommentVo.getCreateDate()));%>
                                        <a href="javascript:reply(<%=sourceCommentVo.getId()%>)">回复</a></td>
                                </tr>
                                <tr>
                                    <td><%=sourceCommentVo.getContent()%></td>
                                </tr>
                            </table>
                        </div>
                            <%
                                List<SourceCommentVo> children = (List<SourceCommentVo>) comments.get("children");
                                for(SourceCommentVo scv : children) {
                            %>
                                <div class="comment-sub-item">
                                    <table>
                                        <tr>
                                            <td rowspan="2">
                                                <img src="<%=basePath+"uploads/user/image/"+scv.getCreateIcon()%>">
                                                <p><%=scv.getCreateName()%></p>
                                            </td>
                                            <td><% out.print(sdf.format(scv.getCreateDate()));%>
                                                <a href="javascript:reply(<%=scv.getId()%>)">回复</a></td>
                                        </tr>
                                        <tr>
                                            <td><%=scv.getContent()%></td>
                                        </tr>
                                    </table>
                                </div>
                    <%
                                }
                            }
                        } else {
                    %>
                    <div>此资源不允许评论。</div>
                    <%
                        }
                    %>
                </div>
                <%
                    if(login && couldComment) {
                %>
                <input type="hidden" id="parentId" value="0">
                <textarea id="replyTextarea" <%=couldComment ? "" : "readonly"%>></textarea>
                <button id="replyBtn" value="发表评论" <%=couldComment ? "" : "disable"%>>发表评论</button>
                <a name="commentA"></a>
                <%
                    } else {
                %>
                <div>您没有登录，请登录后再评论。</div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.html"%>
</body>
<%
    if(mediaFormat.equals("mp4") || mediaFormat.equals("flv")) {
%>
<script type="text/javascript" src="<%=basePath%>website/js/jwplayer.js"></script>
<script type="text/javascript">
    jwplayer("webPlayer").setup({
        flashplayer : "<%=basePath%>website/player.swf",
        file: '../uploads/<%=url%>'
    });
</script>
<%
} else if(mediaFormat.equals("wmv")) {
%>
<script type="text/javascript" src="<%=basePath%>website/js/silverlight.js"></script>
<script type="text/javascript" src="<%=basePath%>website/js/wmvplayer.js"></script>
<script type="text/javascript">
    var elm = document.getElementById("myElement");
    var src = '<%=basePath%>website/js/wmvplayer.xaml';
    var cfg = {
        file: '../uploads/<%=url%>',
        //image: 'preview.jpg',   //封面
        //logo: 'ruanko_logo.png',
        //link: 'http://www.ruanko.com/main', //logo的链接
        //linktarget: '_blank',   //新页面打开链接
        width: '500',
        height: '340',
        autostart: 'true',
        //start:'10',   //从第10秒开始播放
        backcolor: '000000',   //背景颜色
        frontcolor: 'FFFFFF'   //字体颜色
    };
    var ply = new jeroenwijering.Player(elm,src,cfg);
</script>
<%
}
%>
</html>
