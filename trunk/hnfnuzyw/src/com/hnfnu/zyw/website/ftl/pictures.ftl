<div id="idContainer2" class="container">
    <table id="idSlider2" cellSpacing=0 cellPadding=0>
        <tr>
        	<#list picturesList?if_exists as picture>
        		<td class="td_f">
        			<a target="_blank" href="${picture.link}">
        				<IMG src="${picture.src}">
        			</a>
        		</td>
        	</#list>
        </tr>
    </table>
    <ul id="idNum" class="num"></ul>
</div>