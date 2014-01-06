package com.hnfnu.zyw.website.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnfnu.zyw.dto.website.NewsDto;
import com.hnfnu.zyw.website.service.INewsService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ftlNewsAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({@Result(name = "success", type = "json", params = {"root", "action"})})
@Namespace("/news")
public class NewsAction extends ActionSupport {

    private static final long serialVersionUID = 8211651083165988085L;
    private int id;
    private boolean success;
    private String message;
    private Map<String, Object> root;

    @Autowired
    @Qualifier("ftl_newsService")
    private INewsService newsService;


    //private FreemarkerUtil fu = new FreemarkerUtil();

    @Action(value = "newsIndex")
    public String newsIndex() {
        //String filePath = ServletActionContext.getServletContext().getRealPath("/");
        // 获得数据模型
        root = newsService.getIndexNews();

        return SUCCESS;
    }

    @Action(value = "view", results = {@Result(name = "success", location = "../../../website/news.jsp")})
    public String newsView() {
        NewsDto news = newsService.get(id);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("news", news);
        request.setAttribute("hotNews", newsService.getIndexNews().get("newsList"));
        request.setAttribute("message", message);
        request.setAttribute("success", success);
        return SUCCESS;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getRoot() {
        return root;
    }
}
