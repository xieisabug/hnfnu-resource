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

import com.hnfnu.zyw.dto.resources.CategoryDto;
import com.hnfnu.zyw.service.resources.ICategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("categoryAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/resources")
public class CategoryAction extends ActionSupport implements
		ModelDriven<CategoryDto> {

	private static final long serialVersionUID = -7199971221300636848L;
	private CategoryDto category = new CategoryDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private String orders;
	private Map<String, Object> categoryList;

	@Autowired
	@Qualifier("categoryService")
	private ICategoryService categoryService;

	// 添加类别
	@Action(value = "addCategory")
	public String add() {
		int order = categoryService.maxOrder() + 1;
		if (order < 1) {
			message = "添加类别失败,类别获取失败";
		} else {
			category.setOrd(order);
			success = categoryService.add(category);
			if (success) {
				message = "添加类别成功！";
			} else {
				message = "添加类别失败！";
			}
		}

		return SUCCESS;
	}

	// 修改类别
	@Action(value = "updateCategory")
	public String update() {
		success = categoryService.update(category);
		if (success) {
			message = "修改类别成功！";
		} else {
			message = "修改类别失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据类别ID查询一个类别
	 * 
	 * @return
	 */
	@Action(value = "loadCategory")
	public String load() {
		category = categoryService.load(category.getId());
		return SUCCESS;
	}

	/**
	 * 根据类别id删除一个类别
	 * 
	 * @return
	 */

	@Action(value = "deleteCategory")
	public String delete() {
		success = categoryService.delete(category.getId());
		if (success) {
			message = "删除类别成功,请刷新资源界面或者重新打开资源界面！";
		} else {
			message = "删除类别失败！";
		}
		return SUCCESS;
	}

	// 获取表中所有类别，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listCategory")
	public String list() {
		categoryList = categoryService.listCategory();
		return SUCCESS;
	}

	// 获取表中所有类别，根据ord排序 ，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listCategoryOrder")
	public String listCategoryOrder() {
		categoryList = categoryService.getCategoryDtoOrder();
		return SUCCESS;
	}

	// 修改类别的排序
	@Action(value = "categoryOrder")
	public String categoryOrder() {
		success = categoryService.setCategoryDtoOrder(orders);
		if (success) {
			message = "类别排序成功！";
		} else {
			message = "类别排序失败！";
		}
		return SUCCESS;
	}

	/* get set */
	public ICategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

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
