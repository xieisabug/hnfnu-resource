    <%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" %>
            <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <html>
        <head>
        <base href="<%=basePath%>">

        <title>在线预览</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jwplayer.js"></script>
        </head>

        <body>
        <div id="myElement">Loading the player...</div>

        <script type="text/javascript">
        jwplayer("myElement").setup({
        flashplayer: "player.swf",
        file : "../uploads/test.mp4"
        });
        </script>
        </body>
        </html>