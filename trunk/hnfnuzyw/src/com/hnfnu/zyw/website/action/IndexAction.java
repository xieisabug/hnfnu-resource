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
	
	@Autowired
	@Qualifier("ftl_indexService")
	private IIndexService indexService;
	
	
	private FreemarkerUtil fu =new FreemarkerUtil();
	private Map<String,Object> root = null;
	
	
	
	
	@Action(value = "makeIndex")
	public String makeIndex() {
		String filePath = null;
		
		filePath = ServletActionContext.getServletContext().getRealPath("/");
		System.out.println("filepPth:"+filePath);
		// 获得数据模型
		root = indexService.getDataModel();
		System.out.println("root"+root);
		
		//打印到输出台，以便于测试
		//fu.print("index.ftl", root);
		//输出到文件
		fu.fprint("index.ftl", root, filePath+"website\\", "index.html");
		return SUCCESS;
	}

}
