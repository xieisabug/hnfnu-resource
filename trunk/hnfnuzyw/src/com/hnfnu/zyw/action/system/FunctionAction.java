package com.hnfnu.zyw.action.system;

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
import com.hnfnu.zyw.dto.system.FunctionDto;
import com.hnfnu.zyw.service.system.IFunctionService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 功能类
 * @author Administrator
 *
 */
@Controller("functionAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class FunctionAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<FunctionDto> {

	private FunctionDto function = new FunctionDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> functionList;

	@Autowired
	@Qualifier("functionService")
	private IFunctionService functionService;

	/**
	 * 添加菜单
	 * @return
	 */
	@Action(value = "addFunction")
	public String add() {
		success = functionService.add(function);
		if (success) {
			message = "添加功能成功！";
		} else {
			message = "添加功能失败！";
		}
		return SUCCESS;
	}

	/**
	 * 修改菜单
	 * @return
	 */
	@Action(value = "updateFunction")
	public String update() {
		success = functionService.update(function);
		if (success) {
			message = "修改功能成功！";
		} else {
			message = "修改功能失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据菜单ID查询一个菜单
	 * @return
	 */
	@Action(value = "loadFunction")
	public String load() {
		function = functionService.load(function);
		return SUCCESS;
	}

	/**
	 * 根据菜单id删除一个菜单
	 * @return
	 */

	@Action(value = "deleteFunction")
	public String delete() {
		success = functionService.delete(function);
		if (success) {
			message = "删除功能成功！";
		} else {
			message = "删除功能失败！";
		}
		return SUCCESS;
	}

	/**
	 *  获取表中所有功能
	 *  用Map装，为了分页的需要加上Rows和Total
	 * @return
	 */
	@Action(value = "listFunction")
	public String list() {
		functionList = functionService.listFun();
		return SUCCESS;
	}

	
	/* get set */
	public FunctionDto getModel() {
		return function;
	}

	public FunctionDto getFunction() {
		return function;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getFunctionList() {
		return functionList;
	}


}
