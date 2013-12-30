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

import com.hnfnu.zyw.website.service.IIndexService;
import com.hnfnu.zyw.website.utils.FreemarkerUtil;
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

	
	private FreemarkerUtil fu =new FreemarkerUtil();
	private Map<String, Object> root;
	
	
	
	@Action(value = "makeGallery")
	public String makeGallery() {
		String filePath = null;
		
		filePath = ServletActionContext.getServletContext().getRealPath("/");
		// 获得数据模型
		root = indexService.getPictures();
		//打印到输出台，以便于测试
		fu.print("index/gallery.ftl", root);
		//输出到文件
		success = fu.fprint("index/gallery.ftl", root, filePath+"website\\", "gallery.html");
		if(success){
			message="轮播图片生成成功";
		}else{
			message="轮播图片生成失败";
		}
		return SUCCESS;
	}
	
	@Action(value = "makeTopic")
	public String makeTopic() {
		String filePath = null;
		
		filePath = ServletActionContext.getServletContext().getRealPath("/");
		// 获得数据模型
		root = indexService.getTopics();
		//打印到输出台，以便于测试
		fu.print("index/topic.ftl", root);
		//输出到文件
		success = fu.fprint("index/topic.ftl", root, filePath+"website\\", "topic.html");
		if(success){
			message="专题生成成功";
		}else{
			message="专题生成失败";
		}
		return SUCCESS;
	}
	
	@Action(value = "makeTabGroup")
	public String makeTabGroup() {
		String filePath = null;
		
		filePath = ServletActionContext.getServletContext().getRealPath("/");
		// 获得数据模型
		root = indexService.makeTabGroups();
		//打印到输出台，以便于测试
		fu.print("index/tabGroup.ftl", root);
		//输出到文件
		success = fu.fprint("index/tabGroup.ftl", root, filePath+"website\\", "tabGroup.html");
		if(success){
			message="专题生成成功";
		}else{
			message="专题生成失败";
		}
		return SUCCESS;
	}
	
	@Action(value = "makeTabGroupT")
	public String makeTabGroupT() {
		root = indexService.makeTabGroups();
		return SUCCESS;
	}
	
	
	
	public Map<String, Object> getRoot() {
		return root;
	}

	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
}
