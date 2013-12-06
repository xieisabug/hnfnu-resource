package com.hnfnu.zyw.website.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.service.resources.ISourceService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("onlineViewAction")
@Scope("prototype")
@Namespace("/online")
public class OnlineViewAction extends ActionSupport{

	private static final long serialVersionUID = 8211651083165988085L;
	private boolean success;
	private String message;
	private int id;
	//private HttpServletRequest request;
	public SourceDto getS() {
		return s;
	}

	private SourceDto s;
	
	@Autowired
	@Qualifier("sourceService")
	private ISourceService sourceService;
	
	@Action(value = "viewSource", results={
			@Result(name="success", location="../../../html2/onlineView.jsp")
			})
	public String viewSource() {
		//System.out.println(id);
		s = sourceService.load(id);
		if(s!=null) {
			success = true;
			message = "读取成功";
		} else {
			success = false;
			message = "读取失败";
		}
		//System.out.println(message);
		//System.out.println(s);
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("source", s);
		//ActionContext.getContext().put("aaaa", s);
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

	/*public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}*/

}
