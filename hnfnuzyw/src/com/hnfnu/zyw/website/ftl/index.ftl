<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>资源管理系统首页</title>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <script src="js/gallery.js" type="text/javascript"></script>
    <script src="js/menu.js" type="text/javascript"></script>
    <script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript"></script>
    <script src="js/ligerui.min.js" type="text/javascript"></script>
	<script src="js/list.js" type="text/javascript"></script>
</head>

<body>
<#import "/inc/topic.ftl" as myTopic/>


<div style="width:846px; margin:0 auto;">
<!-- 顶部菜单 -->
<div id="top">
    <div id="logo"></div>
    <div id="top_menu">
        <div style="background:url(images/black.jpg); height:4px; width:433px; float:left;"></div>
        <a href="#" style="background:url(images/top_menu1.jpg); height:30px; width:43px; float:left;"></a>
        <a href="#" style="background:url(images/top_menu2.jpg); height:30px; width:65px; float:left;"></a>
        <a href="#" style="background:url(images/top_menu3.jpg); height:30px; width:48px; float:left;"></a>
        <a href="#" style="background:url(images/top_menu4.jpg); height:30px; width:51px; float:left;"></a>
    </div>
    <div id="bar">
        <a href="#" style="background:url(images/bar1.jpg); height:41px; width:93px; float:left;"></a>
        <a href="#" style="background:url(images/bar2.jpg); height:41px; width:182px; float:left;"></a>
        <a href="#" style="background:url(images/bar3.jpg); height:41px; width:182px; float:left;"></a>
        <a href="#" style="background:url(images/bar4.jpg); height:41px; width:183px; float:left;"></a>
    </div>
</div>
<!-- 顶部菜单 -->

<!-- banner -->
<div id="idContainer2" class="container">
    <table id="idSlider2" cellSpacing=0 cellPadding=0>
        <tr>
            <td class="td_f"><IMG src="images/slider1.jpg"></td>
            <td class="td_f"><IMG src="images/slider2.jpg"></td>
            <td class="td_f"><IMG src="images/slider1.jpg"></td>
            <td class="td_f"><IMG src="images/slider2.jpg"></td>
            <td class="td_f"><IMG src="images/slider1.jpg"></td>
        </tr>
    </table>
    <ul id="idNum" class="num"></ul>
</div>
<!-- banner -->

<div class="left">
    <!-- 登陆 -->
    <div id="login">
        <div id="login_title"></div>
        <div id="login_form">
            <form name="login" action="" method="post">
                <div id="login_input">
                    <label for="username">账 号：</label>
                    <input type="text" name="username" id="username"/><br/>
                    <label for="password">密 码：</label>
                    <input type="password" name="password" id="password"/>
                </div>
                <div id="login_button">
                    <a href="#" id="login_submit_button"></a>
                    <a href="#" id="regist_button"></a>
                    <a href="#" id="forget_button"></a>
                </div>
            </form>
        </div>
    </div>
    <!-- 登陆 -->

     	<!-- 专题   -->
       <@myTopic.topic num=topicNum topicList=topicList/>
         

    <!-- 服务中心  -->
    <div id="service">
        <div id="service_title"></div>
        <div id="service_content">
            <a href="#" id="zaixianfuwu"></a>
            <a href="#" id="lianxidianhua"></a>
        </div>
    </div>
    <!-- 服务中心  -->
</div>
<div class="left center">
    <!-- 最新公告 -->
    <div id="notice">
        <a href="#">
            <div id="notice_title"></div>
        </a>

        <div id="notice_content">
            <ul>
                <li>
                    <a href="#">
                        <div class="notice_item_title">关于学校创新项目立项的通知</div>
                        <div class="notice_item_date">2013-01-22</div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="notice_item_title">关于2014级学生开课通知</div>
                        <div class="notice_item_date">2013-07-08</div>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <div class="notice_item_title">资源管理系统开通了！</div>
                        <div class="notice_item_date">2013-01-22</div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <!-- 最新公告 -->

    <!-- 资源库统计 -->
    <div id="source_count">
        <div id="source_count_title"></div>
        <div id="source_count_content"></div>
    </div>
    <!-- 资源库统计 -->

    <!-- 资源库 -->
        <div id="resource">
        	<div id="resource_title"></div>
            <div id="subject_title"></div>
            <div id="subject_menu">
            	<div id="idSlideView3" class="sv3">
            	
            		<#list subjectList?if_exists as subject>
            			<#if subject_index == 0>
            		 		<dl class="on">
            		 	<#else>
            		 		<dl>
            			</#if>
            			
						<dt>${subject.name}</dt>
					
					 <dd>
					 <table width="127" cellpadding="0" cellspacing="0" height="80">
					 	<#list gradeList as grade>
					 		<#if grade_index % 2 == 0>
                               			 <tr>
                                   		 <td><a href="sourceList_${subject.id}_${grade.id}.html">${grade.name}</a></td>
					 		<#else>
					 					<td><a href="sourceList_${subject.id}_${grade.id}.html">${grade.name}</a></td>
					 					 </tr>
					 		</#if>
					 	</#list>
					 	</table>
					 	</dd>
					 	 </dl> 
					</#list> 
					
                </div>
            </div>
            <div id="resource_content">
            	<table>
            	
            		<#if sourceList?size = 0>
            		
            		<#else>
	            		<#list sourceList as source>
		            		<#if source_index +1 / 3 < sourceLine>
			            		<#if source_index +1 % 3 == 1>
				                	<tr>
				                    	<td>
				                        	<a href="javascript:openSourceWindow(${source.id})">${source.name}</a><br/>
				                        	<span>浏览：${source.viewTimes} 类型：${source.mediaType}</span>
				                    	</td>
			                    </#if>	
			                    <#if source_index +1 % 3 == 2>
			                       	<td>
			                        	<a href="javascript:openSourceWindow(${source.id})">${source.name}</a><br/>
			                        	<span>浏览：${source.viewTimes} 类型：${source.mediaType}</span>
			                    	</td>
			                     </#if>	
			                    <#if source_index +1 % 3 == 0>
				                        <td>
				                        	<a href="javascript:openSourceWindow(${source.id})">${source.name}</a><br/>
				                        	<span>浏览：${source.viewTimes} 类型：${source.mediaType}</span>
				                    	</td>
			                    	</tr>
			                     </#if>
		                    </#if>
	                    </#list>
                   </#if>
                </table>
                
                <div id="resource_more">
                	<a href="javascript:openSourceWindow(${sourceList[0].id})">更多...</a>
                </div>
            </div>
        </div>
        <!-- 资源库 -->

    <!-- 优质课程库 -->
    <div id="course">
        <a href="#">
            <div id="course_title"></div>
        </a>

        <div id="course_content"></div>
    </div>
    <!-- 优质课程库 -->
</div>
<div id="foot_menu">
    <div id="foot_menu_content">| 关于我们 | 联系我们 | 版权申明 | 网站帮助 |</div>
</div>
<div id="foot_info">
    <div id="foot_info_content">版权所有 湖南第一师范学院公共实验管理中心 湘ICP备05000548号<br/>
        地址:湖南省长沙市枫林三路1015号 科技楼B403 邮编:410205 电话 (0731)82841118
    </div>
</div>
<div id="foot_black"></div>
</div>
</body>
</html>
