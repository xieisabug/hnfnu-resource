<!-- 最新公告 -->
<div id="notice">
    <a href="#">
        <div id="notice_title"></div>
    </a>

    <div id="notice_content">
        <ul>
        <#list newsList?if_exists as news>
        	<li>
        		<a target="_blank" href="news_view.html?id=${news.id}">
        			<div class="notice_item_title">${news.title}</div>
                    <div class="notice_item_date">${news.date?string('yyyy-MM-dd')}</div>
        		</a>
        	</li>
        </#list>
        </ul>
    </div>
</div>
<!-- 最新公告 -->