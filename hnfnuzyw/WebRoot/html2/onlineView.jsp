<%@ page import="com.hnfnu.zyw.dto.resources.SourceDto" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	SourceDto s = (SourceDto)request.getAttribute("source");
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


</head>

<body>
	<div id="myElement">Loading the player...</div>
</body>
<% 
	if(s != null) {
		if(s.getMediaFormat().equals("mp4") || s.getMediaFormat().equals("flv")) {
%>
<script type="text/javascript" src="html2/js/jwplayer.js"></script>
<script type="text/javascript">
	jwplayer("myElement").setup({
		flashplayer : "html2/player.swf",
		file: '../uploads/<%=s.getUrl().substring(s.getUrl().indexOf("uploads")+8) %>'
	});
</script>
<% 
		} else if(s.getMediaFormat().equals("wmv")) {
%>
<script type="text/javascript" src="html2/js/silverlight.js"></script>
<script type="text/javascript" src="html2/js/wmvplayer.js"></script>
<script type="text/javascript">
	var elm = document.getElementById("myElement");
	var src = 'html2/js/wmvplayer.xaml';
	var cfg = {
	    file: '../uploads/<%=s.getUrl().substring(s.getUrl().indexOf("uploads")+8) %>',
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
	} else {
%>
<h1>错误！</h1>
<% 	} %>
</html>