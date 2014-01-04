<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="css/xkui.css" type="text/css" rel="stylesheet">
    <link href="css/index.css" type="text/css" rel="stylesheet">
    <!--<link href="css/ui.css" type="text/css" rel="stylesheet">-->

    <script src="js/mootools.js" type="text/javascript"></script>
    <script src="js/xkui.js" type="text/javascript"></script>
    <script src="js/topic_source.js" type="text/javascript"></script>
    <title>专题</title>
</head>
<body>
<div id="headContent" style="height: 90px;">
    <div id="headLogo"></div>
    <div id="headMenu">
        <div class="btn-group">
            <a href="#">湖南第一师范学院</a><a href="#">公馆实验管理中心</a><a href="#">联系我们</a><a href="#">添加收藏</a>
        </div>
    </div>
    <div id="headSearch">
        <button id="searchSelect">站内资源</button>
        <input type="text" style="width: 270px; *padding:0;">
        <button type="button">搜索</button>
    </div>
</div>

<div class="center">
    <div class="row">
        <div class="navbar">
            <ul class="nav">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#">学科资源</a></li>
                <li><a href="#">专题资源</a></li>
                <li><a href="#">教学视频示范中心</a></li>
                <li><a href="#">教师职业技能训练</a></li>
                <li><a href="#">语言学科平台</a></li>
            </ul>
        </div>
        <div style="margin-top: 10px; font-size: 0.8em">
            您的位置：<a href="#">首页</a> > <a href="#">专题</a>
        </div>
    </div>
    <div class="row">
        <div id="topic-source">
            <div>
                <div class="panel-head-icon"></div>
                <span>专题资源</span>
            </div>
            <div id="topic-source-content">
	            <#list topics!"专题生成错误" as topic>
	            	<#if (topic_index%20==0)>
	            		<div>
	                    <table>
	            	</#if>
	            	<#if ((topic_index+1)%20==0)>
	                    </table>
	                    </div>
	            	</#if>
	            	
	            	<#if (topic_index%4==0)>
	                        <tr>
	                            <td>
	                            	<#if (topic.isOutlink?number == 0)>
                        				<a target="_blank" href="../topic/view?topicId=${topic.id}">
                        			<#else>
			                        	<a target="_blank" href="${topic.outlink}">
			                        </#if>
                                	<img src="../uploads/topic/image/${topic.imageUrl!" default_topic.png"}">
                                    <div class="topic-source-item">
                                        <div class="topic-title">${topic.name}</div>
                                        <div class="topic-description">${topic.description}</div>
                                    </div>
                               		 </a>
	                            </td>
	            	</#if>
	            	<#if ((topic_index-1)%4)==0>
	            				<td>
	                                <#if (topic.isOutlink?number == 0)>
                        				<a target="_blank" href="../topic/view?topicId=${topic.id}">
                        			<#else>
			                        	<a target="_blank" href="${topic.outlink}">
			                        </#if>
                                	<img src="../uploads/topic/image/${topic.imageUrl!" default_topic.png"}">
                                    <div class="topic-source-item">
                                        <div class="topic-title">${topic.name}</div>
                                        <div class="topic-description">${topic.description}</div>
                                    </div>
                               		 </a>
	                            </td>
	            	</#if>
	            	<#if ((topic_index-2)%4)==0>
	            				<td>
	                                <#if (topic.isOutlink?number == 0)>
                        				<a target="_blank" href="../topic/view?topicId=${topic.id}">
                        			<#else>
			                        	<a target="_blank" href="${topic.outlink}">
			                        </#if>
                                	<img src="../uploads/topic/image/${topic.imageUrl!" default_topic.png"}">
                                    <div class="topic-source-item">
                                        <div class="topic-title">${topic.name}</div>
                                        <div class="topic-description">${topic.description}</div>
                                    </div>
                               		 </a>
	                            </td>
	            	</#if>
	            	<#if ((topic_index+1)%4)==0 >
	            		    <td>
	                                <#if (topic.isOutlink?number == 0)>
                        				<a target="_blank" href="../topic/view?topicId=${topic.id}">
                        			<#else>
			                        	<a target="_blank" href="${topic.outlink}">
			                        </#if>
                                	<img src="../uploads/topic/image/${topic.imageUrl!" default_topic.png"}">
                                    <div class="topic-source-item">
                                        <div class="topic-title">${topic.name}</div>
                                        <div class="topic-description">${topic.description}</div>
                                    </div>
                               		 </a>
	                            </td>
	                        </tr>
	            	</#if>
	            </#list>

	             <#--处理不满20个的时候-->
	            	<#assign x=(topic_size%20)>
	            	<#if (x>0)>
	                    <#list x..19 as y>
	                        <#if y % 4 == 0>
	                            <tr>
	                                <td>
	                                </td>
	                        </#if>
	                        <#if (y - 1) % 4 == 0>
	                            <td>
	                            </td>
	                        </#if>
	                        <#if (y  - 2) % 4 == 0>
	                            <td>
	                            </td>
	                        </#if>
	                         <#if (y+1) % 4 == 0>
	                             <td>
	                            </td>
	                            </tr>
	                        </#if>
	                        <#if (y + 1) % 20== 0>
	                            </table>
	    						</div>
	   						 </#if>
	   					</#list>	 
	   				</#if>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div style="text-align: center">
        <p>版权所有：湖南第一师范学院公共实验管理中心·湘ICP备05000548号</p>

        <p>地址：湖南省长沙市枫林三路1015号·邮编：410205·电话：0731-82841118</p>

        <p>建议使用IE 8版本以上浏览器浏览</p>
    </div>
</div>
</body>
</html>