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
import com.hnfnu.zyw.dto.resources.CategoryDto;
import com.hnfnu.zyw.service.resources.ICategoryService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("categoryAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/resources")
public class CategoryAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<CategoryDto> {

	private CategoryDto category = new CategoryDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private boolean success;
	private String message;
	private String orders;
	private Map<String, Object> categoryList;

	@Autowired
	@Qualifier("categoryService")
	private ICategoryService categoryService;

	// Ìí¼ÓÀà±ð
	@Action(value = "addCategory")
	public String add() {
		int order = categoryService.maxOrder() + 1;
		if (order < 1) {
			message = "Ìí¼ÓÀà±ðÊ§°Ü,Àà±ð»ñÈ¡Ê§°Ü";
		} else {
			category.setOrd(order);
			success = categoryService.add(category);
			if (success) {
				message = "Ìí¼ÓÀà±ð³É¹¦£¡";
			} else {
				message = "Ìí¼ÓÀà±ðÊ§°Ü£¡";
			}
		}

		return SUCCESS;
	}

	// ÐÞ¸ÄÀà±ð
	@Action(value = "updateCategory")
	public String update() {
		success = categoryService.update(category);
		if (success) {
			message = "ÐÞ¸ÄÀà±ð³É¹¦£¡";
		} else {
			message = "ÐÞ¸ÄÀà±ðÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾ÝÀà±ðID²éÑ¯Ò»¸öÀà±ð
	 * 
	 * @return
	 */
	@Action(value = "loadCategory")
	public String load() {
		category = categoryService.load(category.getId());
		return SUCCESS;
	}

	/**
	 * ¸ù¾ÝÀà±ðidÉ¾³ýÒ»¸öÀà±ð
	 * 
	 * @return
	 */

	@Action(value = "deleteCategory")
	public String delete() {
		success = categoryService.delete(category.getId());
		if (success) {
			message = "É¾³ýÀà±ð³É¹¦,ÇëË¢ÐÂ×ÊÔ´½çÃæ»òÕßÖØÐÂ´ò¿ª×ÊÔ´½çÃæ£¡";
		} else {
			message = "É¾³ýÀà±ðÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	// »ñÈ¡±íÖÐËùÓÐÀà±ð£¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	@Action(value = "listCategory")
	public String list() {
		categoryList = categoryService.listCategory();
		return SUCCESS;
	}

	// »ñÈ¡±íÖÐËùÓÐÀà±ð£¬¸ù¾ÝordÅÅÐò £¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	@Action(value = "listCategoryOrder")
	public String listCategoryOrder() {
		categoryList = categoryService.getCategoryDtoOrder();
		return SUCCESS;
	}

	// ÐÞ¸ÄÀà±ðµÄÅÅÐò
	@Action(value = "categoryOrder")
	public String categoryOrder() {
		success = categoryService.setCategoryDtoOrder(orders);
		if (success) {
			message = "Àà±ðÅÅÐò³É¹¦£¡";
		} else {
			message = "Àà±ðÅÅÐòÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/* get set */

	public CategoryDto getModel() {
		return category;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getCategoryList() {
		return categoryList;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

}
