<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.hnfnu.zyw.dto.system.UserDto" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//TODO 登陆用户需要判断两个，一个是student，一个是user，还需要确定
	//TODO 需要把UserDto换成VO
	UserDto user = (UserDto) session.getAttribute("user");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>主页</title>
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="js/gallery.js" type="text/javascript"></script>
    <script src="js/menu.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript"></script>
    <script src="js/ligerui.min.js" type="text/javascript"></script>
	<script src="js/list.js" type="text/javascript"></script>
</head>

<body>
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
            <td class="td_f"><a target="_blank" href="http://www.baidu.com"><IMG src="images/slider1.jpg"></a></td>
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
        <%
        	if(user==null) {
        %>
        <div id="login_form">
            <form name="login" action="" method="post">
                <div id="login_input">
                    <label for="username">账 号：</label>
                    <input type="text" name="username" id="username"/><br/>
                    <label for="password">密 码：</label>
                    <input type="password" name="password" id="password"/><br>
                    <label for="login_type">身份：</label>
                    <select name="login_type" id="login_type">
                        <option value="1">老师</option>
                        <option value="0">学生</option>
                    </select>
                </div>
                <div id="login_button">
                    <a href="javascript:login();" id="login_submit_button"></a>
                    <a href="#" id="regist_button"></a>
                    <a href="#" id="forget_button"></a>
                </div>
            </form>
        </div>
        <%
        	} else {
        %>
        <div id="login_form">
        	<p>您好， <%=user.getName() %> </p>
        	<button name="exit" id="exit" onclick="javascript:void(0)">退出</button>
        </div>
        <%
        	}
        %>
    </div>
    <!-- 登陆 -->
    <!-- 教学视频示范中心  -->
    <div id="teachvideo">
        <a href="#">
            <div id="teachvideo_title"></div>
        </a>

        <div id="teachvideo_content">
            <ul>
                <li class="teachvideo_item_odd"><a href="javascript:openTopicWindow(1)">身体健康专题</a></li>
                <li class="teachvideo_item_even"><a href="#">三笔字</a></li>
                <li class="teachvideo_item_odd"><a href="#">教育理论</a></li>
                <li class="teachvideo_item_even"><a href="#">微机教学</a></li>
                <li class="teachvideo_item_odd"><a href="#">PPT制作专题</a></li>
                <li class="teachvideo_item_even"><a href="#">公开课专题</a></li>
                <li class="teachvideo_item_odd"><a href="#">课堂笔记</a></li>
                <li class="teachvideo_item_even"><a href="#">网站专题</a></li>
            </ul>
        </div>
    </div>
    <!-- 教学视频示范中心  -->
    
    <!-- 专题  -->
    <div id="topic">
        <a href="#">
            <div id="topic_title"></div>
        </a>

        <div id="topic_content">
            <ul>
                <li class="topic_item_odd"><a href="javascript:openTopicWindow(1)">身体健康专题</a></li>
                <li class="topic_item_even"><a href="#">三笔字</a></li>
                <li class="topic_item_odd"><a href="#">教育理论</a></li>
                <li class="topic_item_even"><a href="#">微机教学</a></li>
                <li class="topic_item_odd"><a href="#">PPT制作专题</a></li>
                <li class="topic_item_even"><a href="#">公开课专题</a></li>
                <li class="topic_item_odd"><a href="#">课堂笔记</a></li>
                <li class="topic_item_even"><a href="#">公开课专题</a></li>
                <li class="topic_item_odd"><a href="#">学习路线专题</a></li>
                <li class="topic_item_even"><a href="#">网站专题</a></li>
            </ul>
        </div>
    </div>
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
	<!-- ！！！！！！！！！！！记得更改引用文件的位置 ！！！！！！！！！ -->
    <jsp:include page="../website/news.html" />

    <!-- 资源库统计 -->
    <div id="source_count">
        <div id="source_count_title"></div>
        <div id="source_count_content"></div>
    </div>
    <!-- 资源库统计 -->
    
    <!-- 教师职业技能训练中心  -->
    <div id="teacher">
        <a href="#">
            <div id="teacher_title"></div>
        </a>

        <div id="teacher_content">
            <ul>
                <li class="teacher_item_odd"><a href="javascript:openTopicWindow(1)">身体健康专题</a></li>
                <li class="teacher_item_even"><a href="#">三笔字</a></li>
                <li class="teacher_item_odd"><a href="#">教育理论</a></li>
                <li class="teacher_item_even"><a href="#">微机教学</a></li>
                <li class="teacher_item_odd"><a href="#">PPT制作专题</a></li>
                <li class="teacher_item_even"><a href="#">公开课专题</a></li>
                <li class="teacher_item_odd"><a href="#">课堂笔记</a></li>
                <li class="teacher_item_even"><a href="#">公开课专题</a></li>
            </ul>
        </div>
    </div>
    <!-- 教师职业技能训练中心  -->
    
    <!-- 资源库 -->
    <div id="resource">
        <div id="resource_title"></div>
        <div id="subject_title"></div>
        <div id="subject_menu">
            <div id="idSlideView3" class="sv3">
                <dl class="on">
                    <dt>语 文</dt>
                    <dd>
                        <table width="127" cellpadding="0" cellspacing="0" height="80">
                            <tr>
                                <td><a href="sourceList_1_1.html" id="0101">一年级</a></td>
                                <td><a href="javascript:void(0);" id="0102">二年级</a></td>
                            </tr>
                            <tr>
                                <td><a href="javascript:void(0);" id="0103">三年级</a></td>
                                <td><a href="javascript:void(0);" id="0104">四年级</a></td>
                            </tr>
                            <tr>
                                <td><a href="javascript:void(0);" id="0105">五年级</a></td>
                                <td><a href="javascript:void(0);" id="0106">六年级</a></td>
                            </tr>
                        </table>
                    </dd>
                </dl>
                <dl>
                    <dt>数 学</dt>
                    <dd>
                        <table width="127" cellpadding="0" cellspacing="0" height="80">
                            <tr>
                                <td>一年级</td>
                                <td>二年级</td>
                            </tr>
                            <tr>
                                <td>三年级</td>
                                <td>四年级</td>
                            </tr>
                            <tr>
                                <td>五年级</td>
                                <td>六年级</td>
                            </tr>
                        </table>
                    </dd>
                </dl>
                <dl>
                    <dt> 英 语</dt>
                    <dd>
                        <table width="127" cellpadding="0" cellspacing="0" height="80">
                            <tr>
                                <td>一年级</td>
                                <td>二年级</td>
                            </tr>
                            <tr>
                                <td>三年级</td>
                                <td>四年级</td>
                            </tr>
                            <tr>
                                <td>五年级</td>
                                <td>六年级</td>
                            </tr>
                        </table>
                    </dd>
                </dl>
                <dl>
                    <dt> 科 学</dt>
                    <dd>
                        <table width="127" cellpadding="0" cellspacing="0" height="80">
                            <tr>
                                <td>一年级</td>
                                <td>二年级</td>
                            </tr>
                            <tr>
                                <td>三年级</td>
                                <td>四年级</td>
                            </tr>
                            <tr>
                                <td>五年级</td>
                                <td>六年级</td>
                            </tr>
                        </table>
                    </dd>
                </dl>
                <dl>
                    <dt> 思 政</dt>
                    <dd>
                        <table width="127" cellpadding="0" cellspacing="0" height="80">
                            <tr>
                                <td>一年级</td>
                                <td>二年级</td>
                            </tr>
                            <tr>
                                <td>三年级</td>
                                <td>四年级</td>
                            </tr>
                            <tr>
                                <td>五年级</td>
                                <td>六年级</td>
                            </tr>
                        </table>
                    </dd>
                </dl>
            </div>
        </div>
        <div id="resource_content">
            <table>
                <tr>
                    <td>
                        <a href="javascript:openSourceWindow(1)">小妈妈找蝌蚪</a><br/>
                        <span>浏览：1210120 类型：PPT</span>
                    </td>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：12120 类型：PPT</span>
                    </td>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：1112 类型：PPT</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：1210120 类型：PPT</span>
                    </td>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：12120 类型：PPT</span>
                    </td>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：1112 类型：PPT</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：1210120 类型：PPT</span>
                    </td>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：12120 类型：PPT</span>
                    </td>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：1112 类型：PPT</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：1210120 类型：PPT</span>
                    </td>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：12120 类型：PPT</span>
                    </td>
                    <td>
                        <a href="#">小妈妈找蝌蚪</a><br/>
                        <span>浏览：1112 类型：PPT</span>
                    </td>
                </tr>
            </table>
            <div id="resource_more">
                <a href="list.html">更多...</a>
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