<#macro pager subjectId gradeId totalPage curPage=1 class="" showPageNum=5>
	<@showPage start=1 end=totalPage subjectId=subjectId gradeId=gradeId class=class curPage=curPage/>
</#macro>

<#macro showPage start end curPage subjectId gradeId class>
	<#list start..end as page>
		<#if curPage==page>
			[${page}]
		<#else>
			<a href="javascript:pager(${subjectId},${gradeId},${page})" class="${class}">${page}</a>
		</#if>
	</#list>
</#macro>