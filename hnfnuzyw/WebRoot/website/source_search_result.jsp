<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hnfnu.zyw.dto.resources.GroupDto" %>
<%@ page import="com.hnfnu.zyw.dto.resources.GradeDto" %>
<%@ page import="com.hnfnu.zyw.vo.SourceVo" %>
<%@ page import="com.hnfnu.zyw.dao.base.Pager" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.hnfnu.zyw.vo.CourseGradeSubjectVo" %>
<%@ page import="com.hnfnu.zyw.dto.resources.SubjectDto" %>
<%@ page import="com.hnfnu.zyw.dto.resources.CourseDto" %>
<%@ page import="com.hnfnu.zyw.vo.TopicSubtitleSourceVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String onlineViewFormat = "mp4,flv,wmv,";
    Map<String, Object> indexRoot = (Map<String, Object>) request.getAttribute("sourceList");
    String keyWord = (String)request.getAttribute("keyWord");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="<%=basePath%>website/css/index.css" type="text/css" rel="stylesheet">
    <link href="<%=basePath%>website/css/xkui.css" type="text/css" rel="stylesheet">
    <script src="<%=basePath%>website/js/mootools.js" type="text/javascript"></script>
    <script src="<%=basePath%>website/js/xkui.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=basePath%>website/js/navbar.js"></script>
    <script type="text/javascript" src="<%=basePath%>website/js/source_search_result.js"></script>
    <script type="text/javascript">
        var basePath = '<%=basePath%>';
        var onlineViewFormat = '<%=onlineViewFormat%>';
    </script>
    <title>搜索 - <%=keyWord%></title>
</head>
<body>
<%@ include file="header.html" %>
<div id="topic-view">
    <div class="row">
        <%@ include file="navbar.html" %>
        <div style="margin-top: 10px; font-size: 0.8em">
            您的位置：<a href="<%=basePath%>website/index.jsp">首页</a>
            > 搜索结果
        </div>
    </div>
    <div class="row" id="show-panel">
        <div>
            <div class="panel-head-icon"></div>
            <span></span>
        </div>
        <div id="source-list">
            <%
                Pager<SourceVo> sourceVoPager = (Pager<SourceVo>) indexRoot.get("sourceVoPager");
                Pager<TopicSubtitleSourceVo> topicSubtitleSourceVoPager = (Pager<TopicSubtitleSourceVo>) indexRoot.get("topicSubtitleSourceVoPager");
            %>
            <span>共有 <%=sourceVoPager.getTotal()+topicSubtitleSourceVoPager.getTotal()%> 个资源</span>
            <%
                for(SourceVo sourceVo : sourceVoPager.getDatas()) {
            %>
            <div class="topic-resource-content">
                <table>
                    <tr>
                        <td style="width: 120px; text-align: center" rowspan="4">
                            <img src="<%=basePath+"website/image/file_icon_"+sourceVo.getMediaFormat()+".png"%>" style="width:77px; height:77px; display: inline;">
                        </td>
                        <td style="width: 200px;"><span>名称</span>：<%=sourceVo.getName()%></td>
                        <td style="width: 150px;"><span>资源价格</span>：<%=sourceVo.getPrice()==0?"免费":sourceVo.getPrice()%></td>
                        <td style="width: 200px;"><span>关键字</span>：
                            <%
                                String k = sourceVo.getKeyWords();
                                String[] kws = k.split(";");
                                for (String kw : kws) {
                            %>
                            <a href="<%=basePath%>search/source?keyword=<%=kw%>"><%=kw%> </a>
                            <%
                                }
                            %>
                        </td>
                        <td style="width: 130px; text-align: center" rowspan="4">
                            <div class="topic-resource-btn">
                                <%
                                    if(onlineViewFormat.contains(sourceVo.getMediaFormat()+",")) {
                                %>
                                <a href="<%=basePath%>online/view?id=<%=sourceVo.getId()%>">在线预览</a>
                                <%
                                    }
                                %>
                                <a href="<%=basePath%>file/download?id=<%=sourceVo.getId()%>">下载资源</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><span>作者</span>：<%=sourceVo.getAuthor()%></td>
                        <td><span>资源类型</span>：<%=sourceVo.getMediaType()%></td>
                        <td rowspan="3"><span>资源描述</span>：<%=sourceVo.getDescription()%></td>
                    </tr>
                    <tr>
                        <td><span>出品方</span>：<%=sourceVo.getPublisher()%></td>
                        <td><span>文件大小</span>：<%=sourceVo.getFileSize()%>M</td>
                    </tr>
                    <tr>
                        <td><span>访问次数</span>：<%=sourceVo.getViewTimes()%></td>
                        <td><span>下载次数</span>：<%=sourceVo.getUseTimes()%></td>
                    </tr>
                </table>
            </div>
            <%
                }
                for(TopicSubtitleSourceVo topicSubtitleSourceVo : topicSubtitleSourceVoPager.getDatas()) {
            %>
            <div class="topic-resource-content">
                <table>
                    <tr>
                        <td style="width: 120px; text-align: center" rowspan="4">
                            <img src="<%=basePath+"website/image/file_icon_"+topicSubtitleSourceVo.getMediaFormat()+".png"%>" style="width:77px; height:77px; display: inline;">
                        </td>
                        <td style="width: 200px;"><span>名称</span>：<%=topicSubtitleSourceVo.getSourceName()%></td>
                        <td style="width: 150px;"><span>资源价格</span>：<%=topicSubtitleSourceVo.getPrice()==0?"免费":topicSubtitleSourceVo.getPrice()%></td>
                        <td style="width: 200px;"><span>关键字</span>：
                            <%
                                String k = topicSubtitleSourceVo.getKeyWords();
                                String[] kws = k.split(";");
                                for (String kw : kws) {
                            %>
                            <a href="<%=basePath%>search/source?keyword=<%=kw%>"><%=kw%> </a>
                            <%
                                }
                            %>
                        </td>
                        <td style="width: 130px; text-align: center" rowspan="4">
                            <div class="topic-resource-btn">
                                <%
                                    if(onlineViewFormat.contains(topicSubtitleSourceVo.getMediaFormat()+",")) {
                                %>
                                <a href="<%=basePath%>online/view?id=<%=topicSubtitleSourceVo.getId()%>">在线预览</a>
                                <%
                                    }
                                %>
                                <a href="<%=basePath%>file/download?id=<%=topicSubtitleSourceVo.getId()%>">下载资源</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><span>作者</span>：<%=topicSubtitleSourceVo.getSourceAuthor()%></td>
                        <td><span>资源类型</span>：<%=topicSubtitleSourceVo.getMediaType()%></td>
                        <td rowspan="3"><span>资源描述</span>：<%=topicSubtitleSourceVo.getSourceDescription()%></td>
                    </tr>
                    <tr>
                        <td><span>出品方</span>：<%=topicSubtitleSourceVo.getPublisher()%></td>
                        <td><span>文件大小</span>：<%=topicSubtitleSourceVo.getFileSize()%>M</td>
                    </tr>
                    <tr>
                        <td><span>访问次数</span>：<%=topicSubtitleSourceVo.getViewTimes()%></td>
                        <td><span>下载次数</span>：<%=topicSubtitleSourceVo.getUseTimes()%></td>
                    </tr>
                </table>
            </div>
            <%
                }
                if( sourceVoPager.getDatas().size() == 8 || topicSubtitleSourceVoPager.getDatas().size() == 8  ) {
            %>
            <div class="more" onclick="more('<%=keyWord%>')" page="1"></div>
            <%
                }
            %>
        </div>
    </div>
</div>
<%@include file="footer.html"%>
</body>
</html>