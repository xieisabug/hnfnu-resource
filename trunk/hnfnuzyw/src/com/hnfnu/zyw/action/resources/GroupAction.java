package com.hnfnu.zyw.action.resources;

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

import com.hnfnu.zyw.action.base.AopNoSuchMethodErrorSolveBaseAction;
import com.hnfnu.zyw.dto.resources.GroupDto;
import com.hnfnu.zyw.service.resources.IGroupService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("groupAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class GroupAction extends AopNoSuchMethodErrorSolveBaseAction implements ModelDriven<GroupDto> {

	private GroupDto group = new GroupDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> groupList;

	@Autowired
	@Qualifier("groupService")
	private IGroupService groupService;

	// 添加分组
	@Action(value = "addGroup")
	public String add() {
		success = groupService.add(group);
		if (success) {
			message = "添加分组成功！";
		} else {
			message = "添加分组失败！";
		}
		return SUCCESS;
	}

	// 修改分组
	@Action(value = "updateGroup")
	public String update() {
		success = groupService.update(group);
		if (success) {
			message = "修改分组成功！";
		} else {
			message = "修改分组失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据分组ID查询一个分组
	 * 
	 * @return
	 */
	@Action(value = "loadGroup")
	public String load() {
		group = groupService.load(group.getId());
		return SUCCESS;
	}

	/**
	 * 根据分组id删除一个分组
	 * 
	 * @return
	 */

	@Action(value = "deleteGroup")
	public String delete() {
		success = groupService.delete(group.getId());
		if (success) {
			message = "删除分组成功！";
		} else {
			message = "删除分组失败！";
		}
		return SUCCESS;
	}

	// 获取表中所有分组，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listGroup")
	public String list() {
		groupList = groupService.listGroup();
		return SUCCESS;
	}

	/* get set */
	public GroupDto getModel() {
		return group;
	}

	public GroupDto getGroup() {
		return group;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getGroupList() {
		return groupList;
	}

}
