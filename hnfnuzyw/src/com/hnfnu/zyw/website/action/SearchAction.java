package com.hnfnu.zyw.website.action;

import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.dto.resources.TopicSubtitleDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.resources.ITopicService;
import com.hnfnu.zyw.service.resources.ITopicSourceVoService;
import com.hnfnu.zyw.service.resources.ITopicSubtitleService;
import com.hnfnu.zyw.service.resources.ITopicSubtitleSourceVoService;
import com.hnfnu.zyw.service.system.IUserService;
import com.hnfnu.zyw.vo.SourceVo;
import com.hnfnu.zyw.vo.TopicSourceVo;
import com.hnfnu.zyw.vo.TopicSubtitleSourceVo;
import com.hnfnu.zyw.website.service.FtlITopicService;
import com.hnfnu.zyw.website.service.ISearchService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("WebsiteSearchAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/search")
public class SearchAction extends ActionSupport {

	private static final long serialVersionUID = 2222487976006742410L;
    private static final int PAGE_SIZE = 8;
    private int page;
    private String keyWord;
    private Map<String,Object> sourceList;
    private Map<String,Object> topicList;

	@Autowired
	@Qualifier("searchService")
	private ISearchService searchService;

	@Action(value = "source", results = { @Result(name = "success", location = "../../../website/source_search_result.jsp") })
	public String source() {
        sourceList = searchService.listSource(keyWord, 1, PAGE_SIZE);
        return SUCCESS;
	}

	@Action(value = "topic", results = { @Result(name = "success", location = "../../../website/topic_search_result.jsp") })
	public String topic() {
        topicList = searchService.listTopic(keyWord,1,PAGE_SIZE);
        return SUCCESS;
	}

    @Action(value = "sourcePage")
    public String sourcePage(){
        sourceList = searchService.listSource(keyWord, page, PAGE_SIZE);
        return SUCCESS;
    }

    @Action(value = "topicPage")
    public String topicPage(){
        topicList = searchService.listTopic(keyWord, 1, PAGE_SIZE);
        return SUCCESS;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Map<String, Object> getSourceList() {
        return sourceList;
    }

    public Map<String, Object> getTopicList() {
        return topicList;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
