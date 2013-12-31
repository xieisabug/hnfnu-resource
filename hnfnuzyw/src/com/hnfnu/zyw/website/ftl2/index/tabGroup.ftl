<#list groupList as groupMap>
	<div class="row">
		<div class="tabGroupItem">
			<ul>
			    <#list groupMap.grades as grade>
			        <#if (grade_index<6)>
			            <li>${grade.name}</li>
			        </#if>
			    </#list>
			</ul>
			<#list groupMap.gradeList as subjectMap>
			    <#if (subjectMap_index<6)>
			        <div>
			            <#list subjectMap.subjects as subject>
			        <#-- 轮转内容的div -->
			                <#if subject_index % 6 == 0>
			                    <div>
			                        <table>
			                </#if>
			                <#if subject_index % 3 == 0>
			                    <tr>
			                        <td class="subject-item">
			                            <table>
			                                <tr>
			                                    <td rowspan="3" style="width: 80px;"><img src="../uploads/subject/image/${subject.dto.imageUrl!"default_subject.png"}" alt="查看学科资源"/></td>
			                                    <td style="font-weight: bolder;">${subject.dto.name}</td>
			                                </tr>
			                                <tr>
			                                    <td>${subject.dto.remark}</td>
			                                </tr>
			                                <tr>
			                                    <td style="color:#0099ff;">浏览次数：${subject.viewTimes}</td>
			                                </tr>
			                            </table>
			                        </td>
			
			                </#if>
			                <#if (subject_index - 1) % 3 == 0>
			                    <td class="subject-item">
			                        <table>
			                            <tr>
			                                <td rowspan="3" style="width: 80px;"><img src="../uploads/subject/image/${subject.dto.imageUrl!"default_subject.png"}"  alt="查看学科资源"/></td>
			                                <td style="font-weight: bolder;">${subject.dto.name}</td>
			                            </tr>
			                            <tr>
			                                <td>${subject.dto.remark}</td>
			                            </tr>
			                            <tr>
			                                <td style="color:#0099ff;">浏览次数：${subject.viewTimes}</td>
			                            </tr>
			                        </table>
			                    </td>
			                </#if>
			                <#if (subject_index + 1) % 3 == 0>
			                    <td class="subject-item">
			                        <table>
			                            <tr>
			                                <td rowspan="3" style="width: 80px;"><img src="../uploads/subject/image/${subject.dto.imageUrl!"default_subject.png"}"  alt="查看学科资源"/></td>
			                                <td style="font-weight: bolder;">${subject.dto.name}</td>
			                            </tr>
			                            <tr>
			                                <td>${subject.dto.remark}</td>
			                            </tr>
			                            <tr>
			                                <td style="color:#0099ff;">浏览次数：${subject.viewTimes}</td>
			                            </tr>
			                        </table>
			                    </td>
			                     </tr>
			                </#if>
			                <#if (subject_index + 1) % 6 == 0>
			                    </table>
			                    </div>
			                </#if>
			            </#list>
			
			    	<#--处理专题个数不是6的整数倍的时候-->
			        <#assign x=(subjectMap.subjectSize%6)>
			            <#if (x>0)>
			                <#list x..5 as y>
			                    <#if y % 3 == 0>
			                        <tr>
			                            <td>
			                            </td>
			                    </#if>
			                    <#if (y - 1) % 3 == 0>
			                        <td>
			                        </td>
			                    </#if>
			                    <#if (y + 1) % 3 == 0>
			                        <td>
			                        </td>
			                        </tr>
			                    </#if>
			                    <#if (y + 1) % 6 == 0>
			                        </table>
			                        </div>
			                    </#if>
			            	</#list>
			            </#if>
			        </div>
			    </#if>
			</#list>
		</div>
	</div>
</#list>