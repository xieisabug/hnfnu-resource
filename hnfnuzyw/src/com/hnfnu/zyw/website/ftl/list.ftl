<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>${subject.name}${grade.name}资源库</title>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <link href="css/Aqua/css/ligerui-all.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<#import "/inc/topic.ftl" as myTopic/>
<#import "/inc/pager.ftl" as myPager/>

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
        <a href="index.html" style="background:url(images/bar1.jpg); height:41px; width:93px; float:left;"></a>
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

    <!-- 专题  -->
        <@myTopic.topic num=10 topicList=topicList/>
    <!-- 专题  -->

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
    	<!--资源列表-->
        <div id="source_list">
        	<div id="toast">
            	<div>
                	<a href="index.html">首页</a> >> <a href="avascript:chooseSubjectGrade();">${subject.name}</a> >> <a href="javascript:chooseSubjectGrade();">${grade.name}</a>
                </div>
            </div>
            <div id="source_list_title">
            	<div id="source_list_title_icon"></div>
                <p>${subject.name}备课资源</p>
            </div>
            <div id="source_list_search">
            	<div class="left">
                    素材类型：
                    <select id="source_type">
                        <option value="ppt">PPT</option>
                        <option value="word">WORD</option>
                    </select>
                </div>
                <div class="right">
                    <input type="text" id="key_word" />
                    <a href="javascript:search(${subject.id},${grade.id})">search</a>
                </div>
            </div>
            <div id="source_list_table">
            	<table>
                	<thead>
                    	<th width="10%">序号</th>
                        <th width="43%">素材名称</th>
                        <th width="18%">添加日期</th>
                        <th width="17%">素材类型</th>
                        <th width="12%">媒体格式</th>
                    </thead>
                    <tbody>
                    <#if (sourcePager.datas?size > 0)>
                     <#list sourcePager.datas as source>
                     	<#if source_index%2==0>
                     		<tr class="grid_even" onclick="javascript:openSourceWindow(${source.id})">
                        	<td>${source.id}</td>
                            <td>${source.name}</td>
                            <td>${source.createDate}</td>
                            <td>${source.mediaType}</td>
                            <td>${source.mediaFormat}</td>
                        </tr>
                     	<#else>
                     	<tr class="grid_odd" onclick="javascript:openSourceWindow(${source.id})">
                        	<td>${source.id}</td>
                            <td>${source.name}</td>
                            <td>${source.createDate}</td>
                            <td>${source.mediaType}</td>
                            <td>${source.mediaFormat}</td>
                        </tr>
                     	</#if>
                    	
                        <#if source_has_next>
                        <#else>
                        <#if source_index < 9>
                        		<#list source_index+1..9 as y>
                        			<#if y%2 == 0>
                        				<tr class="grid_even" onclick="javascript:void(0)">
                        				<td></td>
                            			<td></td>
                            			<td></td>
                            			<td></td>
                            			<td></td>
                        				</tr>
                        			<#else>
                        				<tr class="grid_odd" onclick="javascript:void(0)">
                        				<td></td>
                            			<td></td>
                            			<td></td>
                            			<td></td>
                            			<td></td>
                        				</tr>
                        			</#if>
                        		</#list>
                        	</#if>
                        </#if>
                    </#list>
                   <#else>
                   		<#list 0..9 as y>
                        			<#if y%2 == 0>
                        				<tr class="grid_even" onclick="javascript:void(0)">
                        				<td></td>
                            			<td></td>
                            			<td></td>
                            			<td></td>
                            			<td></td>
                        				</tr>
                        			<#else>
                        				<tr class="grid_odd" onclick="javascript:void(0)">
                        				<td></td>
                            			<td></td>
                            			<td></td>
                            			<td></td>
                            			<td></td>
                        				</tr>
                        			</#if>
                        		</#list>
                   </#if>
                    </tbody>
                </table>
                <div id="pager">
                	<a href="javascript:firstPage(${subject.id},${grade.id})">第一页</a> 
                    <a href="javascript:prePage(${subject.id},${grade.id})">上一页</a> 
                    <#assign x = sourcePager.total%sourcePager.size>
                    <#if x==0 && sourcePager.total!=0> 
                     <#assign tp = sourcePager.total/sourcePager.size>
                    <#else>
                     <#assign tp = (sourcePager.total/sourcePager.size)+1>
                    </#if>
                   	<@myPager.pager subjectId=subject.id gradeId=grade.id totalPage=tp curPage=1 class="pagers" showPageNum=5/>
                    <a href="javascript:nextPage(${subject.id},${grade.id})">下一页</a> 
                    <a href="javascript:lastPage(${subject.id},${grade.id})">最后一页</a> 
                </div>
            </div>
        </div>
        <!--资源列表-->
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
<script src="js/gallery.js" type="text/javascript"></script>
<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
<script src="js/ligerui.min.js" type="text/javascript"></script>
<script src="js/list.js" type="text/javascript"></script>
</html>
