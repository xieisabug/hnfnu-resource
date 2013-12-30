<div class="row">
    <div id="topic">
        <div>
            <div class="panel-head-icon"></div>
            <span>专题资源</span>
        </div>
        <div id="topic-content">
            <#list topics as topic>
                <#if topic_index % 6 == 0>
                    <div>
                        <table>
                </#if>
                <#if topic_index % 3 == 0>
                    <tr>
                        <td>
                            <a href="#">
                                <img src="../uploads/topic/image/${topic.imageUrl!" default_topic.png"}">

                                <div class="topic-item">
                                    <div class="topic-title">${topic.name}</div>
                                    <div class="topic-description">${topic.description}</div>
                                </div>
                            </a>
                        </td>

                </#if>
                <#if (topic_index - 1) % 3 == 0>
                    <td>
                        <a href="#">
                            <img src="../uploads/topic/${topic.imageUrl}">

                            <div class="topic-item">
                                <div class="topic-title">${topic.name}</div>
                                <div class="topic-description">${topic.description}</div>
                            </div>
                        </a>
                    </td>
                </#if>
                <#if (topic_index + 1) % 3 == 0>
                    <td>
                        <a href="#">
                            <img src="../uploads/topic/${topic.imageUrl}">

                            <div class="topic-item">
                                <div class="topic-title">${topic.name}</div>
                                <div class="topic-description">${topic.description}</div>
                            </div>
                        </a>
                    </td>
                    </tr>
                </#if>
                <#if (topic_index + 1) % 6 == 0>
                    </table>


        </div>
        </#if>
        </#list>

        <#--处理专题个数不是6的整数倍的时候-->
            <#assign x=(topicSize%6)>
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
</div>
</div>