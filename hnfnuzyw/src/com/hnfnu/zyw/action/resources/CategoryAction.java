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

	private CategoryDto category = new CategoryDto();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private String orders;
	private Map<String, Object> categoryList;

	@Autowired
	@Qualifier("categoryService")
	private ICategoryService categoryService;

	// ������
	@Action(value = "addCategory")
	public String add() {
		int order = categoryService.maxOrder() + 1;
		if (order < 1) {
			message = "������ʧ��,����ȡʧ��";
		} else {
			category.setOrd(order);
			success = categoryService.add(category);
			if (success) {
				message = "������ɹ���";
			} else {
				message = "������ʧ�ܣ�";
			}
		}

		return SUCCESS;
	}

	// �޸����
	@Action(value = "updateCategory")
	public String update() {
		success = categoryService.update(category);
		if (success) {
			message = "�޸����ɹ���";
		} else {
			message = "�޸����ʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * �������ID��ѯһ�����
	 * 
	 * @return
	 */
	@Action(value = "loadCategory")
	public String load() {
		category = categoryService.load(category.getId());
		return SUCCESS;
	}

	/**
	 * �������idɾ��һ�����
	 * 
	 * @return
	 */

	@Action(value = "deleteCategory")
	public String delete() {
		success = categoryService.delete(category.getId());
		if (success) {
			message = "ɾ�����ɹ�,��ˢ����Դ����������´���Դ���棡";
		} else {
			message = "ɾ�����ʧ�ܣ�";
		}
		return SUCCESS;
	}

	// ��ȡ�������������Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	@Action(value = "listCategory")
	public String list() {
		categoryList = categoryService.listCategory();
		return SUCCESS;
	}

	// ��ȡ����������𣬸���ord���� ����Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	@Action(value = "listCategoryOrder")
	public String listCategoryOrder() {
		categoryList = categoryService.getCategoryDtoOrder();
		return SUCCESS;
	}

	// �޸���������
	@Action(value = "categoryOrder")
	public String categoryOrder() {
		success = categoryService.setCategoryDtoOrder(orders);
		if (success) {
			message = "�������ɹ���";
		} else {
			message = "�������ʧ�ܣ�";
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
