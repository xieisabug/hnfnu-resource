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
 * ¹¦ÄÜÀà
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

	private FunctionDto function = new FunctionDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private boolean success;
	private String message;
	private Map<String, Object> functionList;

	@Autowired
	@Qualifier("functionService")
	private IFunctionService functionService;

	/**
	 * Ìí¼Ó²Ëµ¥
	 * @return
	 */
	@Action(value = "addFunction")
	public String add() {
		success = functionService.add(function);
		if (success) {
			message = "Ìí¼Ó¹¦ÄÜ³É¹¦£¡";
		} else {
			message = "Ìí¼Ó¹¦ÄÜÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ÐÞ¸Ä²Ëµ¥
	 * @return
	 */
	@Action(value = "updateFunction")
	public String update() {
		success = functionService.update(function);
		if (success) {
			message = "ÐÞ¸Ä¹¦ÄÜ³É¹¦£¡";
		} else {
			message = "ÐÞ¸Ä¹¦ÄÜÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý²Ëµ¥ID²éÑ¯Ò»¸ö²Ëµ¥
	 * @return
	 */
	@Action(value = "loadFunction")
	public String load() {
		function = functionService.load(function);
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý²Ëµ¥idÉ¾³ýÒ»¸ö²Ëµ¥
	 * @return
	 */

	@Action(value = "deleteFunction")
	public String delete() {
		success = functionService.delete(function);
		if (success) {
			message = "É¾³ý¹¦ÄÜ³É¹¦£¡";
		} else {
			message = "É¾³ý¹¦ÄÜÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 *  »ñÈ¡±íÖÐËùÓÐ¹¦ÄÜ
	 *  ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
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
