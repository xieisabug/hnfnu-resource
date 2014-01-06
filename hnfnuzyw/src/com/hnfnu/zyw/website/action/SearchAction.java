package com.hnfnu.zyw.website.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnfnu.zyw.website.service.ISearchService;
import com.opensymphony.xwork2.ActionSupport;

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
