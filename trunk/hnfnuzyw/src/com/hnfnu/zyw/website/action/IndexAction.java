package com.hnfnu.zyw.website.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnfnu.zyw.website.service.IIndexService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ftlIndexAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/ftl")
public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 8211651083165988085L;
	private boolean success;
	private String message;
	@Autowired
	@Qualifier("ftl_indexService")
	private IIndexService indexService;
	
	@Action(value = "makeGallery")
	public String makeGallery() {
		indexService.getPictures();
		if(success){
			message="轮播图片生成成功";
		}else{
			message="轮播图片生成失败";
		}
		return SUCCESS;
	}
	
	@Action(value = "makeTopic")
	public String makeTopic() {
		
		indexService.getTopics();
		if(success){
			message="专题生成成功";
		}else{
			message="专题生成失败";
		}
		return SUCCESS;
	}
	
	@Action(value = "makeTabGroup")
	public String makeTabGroup() {
		indexService.makeTabGroups();
		if(success){
			message="专题生成成功";
		}else{
			message="专题生成失败";
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
