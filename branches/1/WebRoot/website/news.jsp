<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hnfnu.zyw.dto.website.NewsDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    NewsDto news = (NewsDto) request.getAttribute("news");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
    <script src="<%=basePath%>website/js/news_view.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=basePath%>website/js/navbar.js"></script>

    <!--<script type="text/javascript" src="js/index.js"></script>-->
    <!--<script type="text/javascript" src="js/gallery.js"></script>-->

    <title>新闻</title>
</head>
<body>
<%@ include file="header.html"%>
<div id="topic-view">
    <div class="row">
        <%@ include file="navbar.html" %>
        <div style="margin-top: 10px; font-size: 0.8em">
            您的位置：<a href="index.jsp">首页</a> > <a href="#">新闻公告</a>
        </div>
    </div>
    <div class="row">
        <div id="news-view-panel">
            <div>
                <div class="panel-head-icon"></div>
                <span><%=news.getTitle()%></span>
            </div>
            <div>
                <div class="news-title">
                    <h3><%=news.getTitle()%></h3>
                    <h5>
                        <%
                            out.print(sdf.format(news.getDate()));
                        %></h5>
                    <h5>编辑：<%=news.getCreateUserName()%></h5>
                </div>
                <div class="news-content">
                    <%=news.getContent()%>
                </div>
            </div>
        </div>
        <div id="hot-news-panel">
            <div>
                <div class="panel-head-icon"></div>
                <span>最近新闻</span>
            </div>
            <div style="padding-left:0px;">
                <ul class="hot-news-content" >
                    <%
                        List<NewsDto> hotNews = (List<NewsDto>)request.getAttribute("hotNews");
                        for(NewsDto n : hotNews) {
                    %>
                        <li>
                            <a href="<%=basePath%>news/view?id=<%=n.getId()%>">
                                <%
                                    if(n.getTitle().length() > 12) {
                                        out.print(n.getTitle().substring(0,11) + "...");
                                    } else {
                                        out.print(n.getTitle());
                                    }
                                %>
                                <span style="float:right;">
                                    <% out.print(sdf.format(n.getDate()));%>
                                </span>
                            </a>
                        </li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.html"%>
</body>
</html>