package com.hnfnu.zyw.action.resources;

import java.util.Date;
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

import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.resources.ISourceService;
import com.hnfnu.zyw.service.resources.ISourceVoService;
import com.hnfnu.zyw.vo.SourceVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("sourceAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class SourceAction extends ActionSupport implements ModelDriven<SourceDto>{
	private static final long serialVersionUID = -7199971221300636848L;
	private SourceDto source = new SourceDto();// 获取页面提交参数
	private SourceVo sourceVo;// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> sourceVoList;
	private UserDto user;

	@Autowired
	@Qualifier("sourceService")
	private ISourceService sourceService;
	
	@Autowired
	@Qualifier("sourceVoService")
	private ISourceVoService sourceVoService;
	

	// 添加资源
	@Action(value = "addSource")
	public String add() {
		//获取当前时间
		source.setCreateDate(new Date());
		//获取当前用户
		 ActionContext context = ActionContext.getContext();  
		 Map session = context.getSession();
		 user = (UserDto) session.get("user");
		 source.setCreateUserId(user.getId());
		success = sourceService.add(source);
		if (success) {
			message = "添加资源成功！";
		} else {
			message = "添加资源失败！";
		}
		return SUCCESS;
	}

	// 修改资源
	@Action(value = "updateSource")
	public String update() {
		success = sourceService.update(source);
		if (success) {
			message = "修改资源成功！";
		} else {
			message = "修改资源失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据资源ID查询一个资源
	 * 
	 * @return
	 */
	@Action(value = "loadSourceVo")
	public String load() {
		sourceVo = sourceVoService.load(source.getId());
		return SUCCESS;
	}

	/**
	 * 根据资源id删除一个资源文件以及在数据库里面的信息,
	 * 
	 * @return
	 */

	@Action(value = "deleteSourceMessege")
	public String deleteMessege() {
		success = sourceService.deleteMessege(source.getId());
		if (success) {
			message = "删除资源信息成功！";
		} else {
			message = "删除资源信息失败！";
		}
		return SUCCESS;
	}
	
	@Action(value = "deleteSource")
	public String delete() {
		int i = sourceService.delete(source.getUrl());
		if (i == 1) {
			success = true;
			message = "删除资源文件成功！";
		} else if (i == -1){
			success = false;
			message = "删除资源文件失败，因为该文件不存在！";
		}else if(i == -1){
			success = false;
			message = "删除资源文件失败,因为不是文件！";
		}
		return SUCCESS;
	}
	

	// 获取表中所有资源，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listSourceVo")
	public String list() {
		sourceVoList = sourceVoService.listSourceVo();
		return SUCCESS;
	}

	/* get set */
	public ISourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(ISourceService sourceService) {
		this.sourceService = sourceService;
	}

	public SourceDto getModel() {
		return source;
	}

	public SourceDto getSource() {
		return source;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getSourceList() {
		return sourceVoList;
	}

	public SourceVo getSourceVo() {
		return sourceVo;
	}

	public void setSourceVo(SourceVo sourceVo) {
		this.sourceVo = sourceVo;
	}
	
}
