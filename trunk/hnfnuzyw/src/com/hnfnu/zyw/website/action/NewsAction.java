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
import com.hnfnu.zyw.website.utils.FreemarkerUtil;
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
    @Autowired
    @Qualifier("ftl_newsService")
    private INewsService newsService;


    private FreemarkerUtil fu = new FreemarkerUtil();

    @Action(value = "newsIndex")
    public String newsIndex() {
        String filePath = ServletActionContext.getServletContext().getRealPath("/");
        // 获得数据模型
        Map<String, Object> root = newsService.getIndexNews();

        //打印到输出台，以便于测试
        //fu.print("index.ftl", root);
        //输出到文件
        success = fu.fprint("news.ftl", root, filePath + "website\\", "news.html");
        if (success) {
            message = "新闻模块生成成功";
        } else {
            message = "新闻模块生成失败";
        }
        return SUCCESS;
    }

    @Action(value = "view", results = {@Result(name = "success", location = "../../html3/news.jsp")})
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
}
