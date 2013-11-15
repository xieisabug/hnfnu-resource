package com.hnfnu.zyw.website.action;

import java.util.Map;

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

import com.hnfnu.zyw.website.service.INewsService;
import com.hnfnu.zyw.website.utils.FreemarkerUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ftlNewsAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/ftl")
public class NewsAction extends ActionSupport {

	private static final long serialVersionUID = 8211651083165988085L;
	private boolean success;
	private String message;
	@Autowired
	@Qualifier("ftl_newsService")
	private INewsService newsService;
	
	
	private FreemarkerUtil fu =new FreemarkerUtil();
	private Map<String,Object> root = null;
	
	@Action(value = "newsIndex")
	public String newsIndex() {
		String filePath = null;
		
		filePath = ServletActionContext.getServletContext().getRealPath("/");
		// 获得数据模型
		root = newsService.getIndexNews();
		
		//打印到输出台，以便于测试
		//fu.print("index.ftl", root);
		//输出到文件
		success = fu.fprint("news.ftl", root, filePath+"website\\", "news.html");
		if(success){
			message="新闻模块生成成功";
		}else{
			message="新闻模块生成失败";
		}
		return SUCCESS;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
}
