<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SourceInfo.jsp' starting page</title>
    
  </head>
  
  <body>
    <table>
    	<tr>
    		<td>名称：</td>
    		<td>小妈妈找蝌蚪</td>
    		<td>课程：</td>
    		<td>语文</td>
    	</tr>
    </table>
  </body>
</html>
