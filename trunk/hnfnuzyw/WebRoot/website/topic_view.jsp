<%@ page import="com.hnfnu.zyw.dto.resources.TopicDto" %>
<%@ page import="com.hnfnu.zyw.dto.system.UserDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.hnfnu.zyw.dto.resources.TopicSubtitleDto" %>
<%@ page import="com.hnfnu.zyw.vo.TopicSourceVo" %>
<%@ page import="com.hnfnu.zyw.vo.TopicSubtitleSourceVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    TopicDto topic = (TopicDto) request.getAttribute("topic");
    UserDto topicUser = (UserDto) request.getAttribute("topicUser");
    List<Map<String,Object>> subTopics = (List<Map<String, Object>>) request.getAttribute("subTopics");
    List<TopicDto> tenHotTopics = (List<TopicDto>) request.getAttribute("tenHotTopics");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String onlineViewFormat = "mp4,flv,wmv,";
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
    <script src="<%=basePath%>website/js/topic_view.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=basePath%>website/js/navbar.js"></script>
    <script type="text/javascript">
        var basePath = '<%=basePath%>';
        var onlineViewFormat = '<%=onlineViewFormat%>';
    </script>
    <!--<script type="text/javascript" src="js/index.js"></script>-->
    <!--<script type="text/javascript" src="js/gallery.js"></script>-->

    <title><%=topic.getName()%></title>
</head>
<body>
<%@ include file="header.html" %>

<div id="topic-view">
    <div class="row">
        <%@ include file="navbar.html" %>
        <div style="margin-top: 10px; font-size: 0.8em">
            您的位置：<a href="#">首页</a> > <a href="#">专题</a>
        </div>
    </div>
    <div class="row">
        <div id="topic-view-panel">
            <div>
                <div class="panel-head-icon"></div>
                <span><%=topic.getName()%></span>
            </div>
            <div class="topic-info">
                <div class="topic-image">
                    <img src="<%=basePath+"uploads/topic/image/"+topic.getImageUrl()%>"/>

                    <div>
                        <p><%=topic.getViewTimes()%> 次浏览</p>
                        <p>发布时间：<%out.print(sdf.format(topic.getCreateDate()));%></p>
                        <p>更新时间：<%out.print(sdf.format(topic.getLastUpdateDate()));%> </p>
                        <div>关键字：
                            <%
                                String keyWords = topic.getKeyWords();
                                String[] keyWordArray = keyWords.split(";");
                                for (String k : keyWordArray) {
                            %>
                            <a href="search?keyword=<%=k%>"><%=k%> </a>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
                <div class="topic-view-description">
                    <div>
                        <div style="float: left;width: 180px;height: 120px;overflow: hidden;">
                            <h3><%=topic.getName()%></h3>
                            <div><%=topic.getRemark()%></div>
                        </div>
                        <div class="topic-user">
                            <img src="<%=basePath+"uploads/user/image/"+topicUser.getIcon()%>">

                            <div class="topic-user-info">
                                <p><%=topicUser.getName()%></p>
                                <p>资源币：<%=topicUser.getBalance()%></p>
                                <p>上次登录时间：<%out.print(sdf.format(topicUser.getLatestLoginDate()));%></p>
                            </div>
                        </div>
                    </div>
                    <div style="clear: both;overflow: hidden;">
                        <%=topic.getDescription()%>
                    </div>
                </div>
            </div>
        </div>
        <div id="hot-topic-panel">
            <div>
                <div class="panel-head-icon"></div>
                <span>最热专题</span>
            </div>
            <div class="hot-topic-list">
                <ul>
                    <%
                        for (TopicDto t : tenHotTopics) {
                    %>
                    <li>
                        <a href="<%=basePath+"topic/view?topicId="+t.getId()%>">
                            <div style="width: 180px;float: left;margin: 0;"><%=t.getName()%></div>
                            <div style="width: 50px;float: right;margin: 0;text-align: right;"><%=t.getViewTimes()%></div>
                        </a>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>
    <div class="row" style="clear: both;">
        <div id="subtopic_tab">
            <ul>
                <%
                    for (Map<String, Object> subTopic : subTopics) {
                %>
                <li><%=((TopicSubtitleDto) subTopic.get("subtitle")).getSubtitle()%>
                </li>
                <%
                    }
                %>
            </ul>
            <%
                for (Map<String, Object> subTopic : subTopics) {
                    List<TopicSubtitleSourceVo> topicSources = (List<TopicSubtitleSourceVo>) subTopic.get("topicSources");
                    List<TopicSourceVo> joinSources = (List<TopicSourceVo>) subTopic.get("joinSources");
            %>
            <div>
                <%
                    for(TopicSubtitleSourceVo tssv : topicSources) {
                %>
                <div class="topic-resource-content">
                    <table>
                        <tr>
                            <td style="width: 140px; text-align: center" rowspan="3">
                                <img src="<%=basePath+"website/image/file_icon_"+tssv.getMediaFormat()+".png"%>" style="width:77px; height:77px; display: inline;">
                            </td>
                            <td style="width: 340px;"><span>资源名</span>：<%=tssv.getSourceName()%></td>
                            <td style="width: 200px;"><span>资源币</span>：<%=tssv.getPrice()==0?"免费":tssv.getPrice()%></td>
                            <td style="width: 130px; text-align: center" rowspan="3">
                                <div class="topic-resource-btn">
                                    <%
                                        if(onlineViewFormat.contains(tssv.getMediaFormat()+",")) {
                                    %>
                                    <a href="<%=basePath%>online/view?id=<%=tssv.getId()%>&type=1">在线预览</a>
                                    <%
                                        }
                                    %>
                                    <a href="<%=basePath%>file/download?id=<%=tssv.getId()%>&type=1">下载资源</a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td><span>媒体类型</span>：<%=tssv.getMediaType()%></td>
                            <td><span>文件大小</span>：<%=tssv.getFileSize()%>M</td>
                        </tr>
                        <tr>
                            <td><span>出品方</span>：<%=tssv.getPublisher()%></td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                </div>
                <%
                    }
                    for(TopicSourceVo tsv : joinSources) {
                %>
                <div class="topic-resource-content">
                    <table>
                        <tr>
                            <td style="width: 140px; text-align: center" rowspan="3">
                                <img src="<%=basePath+"website/image/file_icon_"+tsv.getMediaFormat()+".png"%>" style="width:77px; height:77px; display: inline;">
                            </td>
                            <td style="width: 340px;"><span>资源名</span>：<%=tsv.getSourceName()%></td>
                            <td style="width: 200px;"><span>资源币</span>：<%=tsv.getPrice()==0?"免费":tsv.getPrice()%></td>
                            <td style="width: 130px; text-align: center" rowspan="3">
                                <div class="topic-resource-btn">
                                    <%
                                        if(onlineViewFormat.contains(tsv.getMediaFormat()+",")) {
                                    %>
                                    <a href="<%=basePath%>online/view?id=<%=tsv.getSourceId()%>$type=2">在线预览</a>
                                    <%
                                        }
                                    %>
                                    <a href="<%=basePath%>file/download?id=<%=tsv.getSourceId()%>&type=2">下载资源</a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td><span>媒体类型</span>：<%=tsv.getMediaType()%></td>
                            <td><span>文件大小</span>：<%=tsv.getFileSize()%>M</td>
                        </tr>
                        <tr>
                            <td><span>出品方</span>：<%=tsv.getPublisher()%></td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                </div>
                <%
                    }
                    if(topicSources.size()==8 || joinSources.size() == 8) {
                %>
                <div class="more" onclick="more(<%=((TopicSubtitleDto) subTopic.get("subtitle")).getId()%>)" page="1"></div>
                <%
                    }
                %>
        </div>
        <%
            }
        %>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>