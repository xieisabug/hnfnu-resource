<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hnfnu.zyw.dto.resources.GroupDto" %>
<%@ page import="com.hnfnu.zyw.dto.resources.GradeDto" %>
<%@ page import="com.hnfnu.zyw.vo.SourceVo" %>
<%@ page import="com.hnfnu.zyw.dao.base.Pager" %>
<%@ page import="com.hnfnu.zyw.vo.CourseGradeSubjectVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String onlineViewFormat = "mp4,flv,wmv,";
    Map<String, Object> indexRoot = (Map<String, Object>) request.getAttribute("subjectMap");
    GradeDto grade = (GradeDto) indexRoot.get("grade");
    GroupDto group = (GroupDto) indexRoot.get("group");
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
    <script type="text/javascript" src="<%=basePath%>website/js/choose_subject.js"></script>
    <script type="text/javascript">
        var basePath = '<%=basePath%>';
        var onlineViewFormat = '<%=onlineViewFormat%>';
    </script>
    <title>数字资源中心-学科资源</title>
</head>
<body>
<%@ include file="header.html" %>
<div id="topic-view">
<div class="row">
    <%@ include file="navbar.html" %>
    <div style="margin-top: 10px; font-size: 0.8em">
        您的位置：<a href="<%=basePath%>website/index.jsp">首页</a> > <a href="<%=basePath%>source/index"><%=group.getName()%> <%=grade.getName()%></a>
    </div>
</div>
<div id="choose-panel" class="row">
    <div class="choose-type">
        <div class="panel-head-icon"></div>
        <span>选择学科</span>
    </div>
    <div class="choose-list">
        <ul>
            <%
                List<CourseGradeSubjectVo> courseGradeSubjectList = (List<CourseGradeSubjectVo>) indexRoot.get("courseGradeSubjectList");
                for (CourseGradeSubjectVo cgs : courseGradeSubjectList) {
            %>
            <li>
                <a href="<%=basePath+"source/course?groupId="+group.getId()+"&gradeId="+grade.getId()+"&subjectId="+cgs.getSubjectId()%>">
                    <%=cgs.getSubjectName()%>
                </a>
            </li>
            <%
                }
            %>
        </ul>
    </div>
</div>
<div id="hot-grade-panel" class="row">
    <div>
        <div class="panel-head-icon"></div>
        <span>热门课程</span>
    </div>
    <div>
        <%@include file="hot-course.html"%>
    </div>
</div>
<div class="row" id="show-panel">
    <div>
        <div class="panel-head-icon"></div>
        <span></span>
    </div>
    <div id="source-list">
        <%
            Pager<SourceVo> sources = (Pager<SourceVo>) indexRoot.get("sourcePager");
        %>
        <span>共有 <%=sources.getTotal()%> 个资源</span>
        <%
            for(SourceVo sourceVo : sources.getDatas()) {
        %>
        <div class="topic-resource-content">
            <table>
                <tr>
                    <td style="width: 120px; text-align: center" rowspan="4">
                        <img src="<%=basePath+"website/image/file_icon_"+sourceVo.getMediaFormat().toLowerCase()+".png"%>" style="width:77px; height:77px; display: inline;">
                    </td>
                    <td style="width: 200px;">
                        <div style="width: 190px; height: 15px;margin-top: 0;word-break: break-all;overflow: hidden;">
                            <span>名称</span>：<%=sourceVo.getName()%>
                        </div>
                    </td>
                    <td style="width: 150px;"><span>资源价格</span>：<%=sourceVo.getPrice()==0?"免费":sourceVo.getPrice()%></td>
                    <td style="width: 200px;">
                        <div style="width: 190px; height: 15px;margin-top: 0;word-break: break-all;overflow: hidden;">
                            <span>关键字</span>：
                            <%
                                String k = sourceVo.getKeyWords();
                                String[] kws = k.split(";");
                                for (String kw : kws) {
                            %>
                            <a href="<%=basePath%>search/source?keyword=<%=kw%>"><%=kw%> </a>
                            <%
                                }
                            %>
                        </div>
                    </td>
                    <td style="width: 130px; text-align: center" rowspan="4">
                        <div class="topic-resource-btn">
                            <%
                                if(onlineViewFormat.contains(sourceVo.getMediaFormat()+",")) {
                            %>
                            <a href="<%=basePath%>online/view?id=<%=sourceVo.getId()%>&type=2">在线预览</a>
                            <%
                                }
                            %>
                            <a href="<%=basePath%>file/download?id=<%=sourceVo.getId()%>&type=2">下载资源</a>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><span>作者</span>：<%=sourceVo.getAuthor()%></td>
                    <td><span>资源类型</span>：<%=sourceVo.getMediaType()%></td>
                    <td rowspan="3">
                        <div style="height: 58px;word-break: break-all;overflow: hidden;">
                            <span>资源描述</span>：<%=sourceVo.getDescription()%>
                        </div>
                    </td>
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
            if(sources.getDatas().size()==8) {
        %>
        <div class="more" onclick="more(<%=group.getId()%>,<%=grade.getId()%>)" page="1"></div>
        <%
            }
        %>
    </div>
</div>
</div>
<%@include file="footer.html"%>
</body>
</html>