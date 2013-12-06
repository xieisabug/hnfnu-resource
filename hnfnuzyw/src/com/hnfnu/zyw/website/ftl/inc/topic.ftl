<#macro topic num topicList>
	<div id="topic">
        	<a href="#"><div id="topic_title"></div></a>
            <div id="topic_content">
            	<ul>
                <#list topicList as topic>
                	<#if topic_index < num>
            			<#if topic_index % 2 == 0>
            		 		<li class="topic_item_even"><a href="javascript:openTopicWindow(${topic.id})">${topic.name}</a></li>
            			 <#else>
            		 		<li class="topic_item_odd"><a href="javascript:openTopicWindow(${topic.id})">${topic.name}</a></li>
            			</#if>
            		</#if>
            	</#list>
                </ul>
            </div>
        </div>
</#macro>