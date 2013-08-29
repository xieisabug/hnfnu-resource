<#macro pager url totalPage curPage=1 class="" showPageNum=5>
	<@showPage start=1 end=totalPage url=url class=class curPage=curPage/>
</#macro>

<#macro showPage start end curPage url class>
	<#list start..end as page>
		<#if curPage==page>
			[${page}]
		<#else>
			<a href="${url}" class="${class}">${page}</a>
		</#if>
	</#list>
</#macro>