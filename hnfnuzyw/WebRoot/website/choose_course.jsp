<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hnfnu.zyw.dto.resources.GroupDto" %>
<%@ page import="com.hnfnu.zyw.dto.resources.GradeDto" %>
<%@ page import="com.hnfnu.zyw.vo.SourceVo" %>
<%@ page import="com.hnfnu.zyw.dao.base.Pager" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.hnfnu.zyw.vo.CourseGradeSubjectVo" %>
<%@ page import="com.hnfnu.zyw.dto.resources.SubjectDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String onlineViewFormat = "mp4,flv,wmv,";
    Map<String, Object> indexRoot = (Map<String, Object>) request.getAttribute("courseMap");
    GradeDto grade = (GradeDto) indexRoot.get("grade");
    GroupDto group = (GroupDto) indexRoot.get("group");
    SubjectDto subject = (SubjectDto) indexRoot.get("subject");
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
    <script type="text/javascript" src="<%=basePath%>website/js/choose_course.js"></script>
    <script type="text/javascript">
        var basePath = '<%=basePath%>';
        var onlineViewFormat = '<%=onlineViewFormat%>';
    </script>
    <title>专题</title>
</head>
<body>
<%@ include file="header.html" %>
<div id="topic-view">
<div class="row">
    <%@ include file="navbar.html" %>
    <div style="margin-top: 10px; font-size: 0.8em">
        您的位置：<a href="<%=basePath%>website/index.jsp">首页</a>
        > <a href="<%=basePath%>source/index"><%=group.getName()%> <%=grade.getName()%></a>
        > <a href="<%=basePath%>source/subject?groupId=<%=group.getId()%>&gradeId=<%=grade.getId()%>"><%=subject.getName()%></a>
    </div>
</div>
<div id="choose-panel" class="row">
    <div class="choose-type">
        <div class="panel-head-icon"></div>
        <span>选择课程</span>
    </div>
    <div class="choose-list">
        <ul>
            <%
                List<CourseGradeSubjectVo> courseGradeSubjectList = (List<CourseGradeSubjectVo>) indexRoot.get("courseGradeSubjectList");
                for (CourseGradeSubjectVo cgs : courseGradeSubjectList) {
            %>
            <li>
                <a href="<%=basePath+"source/final?groupId="+group.getId()+"&gradeId="+grade.getId()+"&subjectId="+subject.getId()+"&courseId="+cgs.getId()%>">
                    <%=cgs.getName()%>
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
        <span>最热课程</span>
    </div>
    <div>
        <%@include file="hot-source.html"%>
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
                        <img src="<%=basePath+"website/image/file_icon_"+sourceVo.getMediaFormat()+".png"%>" style="width:77px; height:77px; display: inline;">
                    </td>
                    <td style="width: 200px;"><span>资源名</span>：<%=sourceVo.getName()%></td>
                    <td style="width: 150px;"><span>资源币</span>：<%=sourceVo.getPrice()==0?"免费":sourceVo.getPrice()%></td>
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
                            <a href="<%=basePath%>online/view?id=<%=sourceVo.getId()%>$type=2">在线预览</a>
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
            if(sources.getDatas().size()==8) {
        %>
        <div class="more" onclick="more(<%=group.getId()%>,<%=grade.getId()%>,<%=subject.getId()%>)" page="1"></div>
        <%
            }
        %>
    </div>
</div>
</div>
<div class="row"  style="clear: both">
    <div style="text-align: center">
        <p>版权所有：湖南第一师范学院公共实验管理中心·湘ICP备05000548号</p>

        <p>地址：湖南省长沙市枫林三路1015号·邮编：410205·电话：0731-82841118</p>

        <p>建议使用IE 8版本以上浏览器浏览</p>
    </div>
</div>
</body>
</html>