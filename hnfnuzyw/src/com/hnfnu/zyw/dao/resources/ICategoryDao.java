package com.hnfnu.zyw.dao.resources;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.CategoryDto;

public interface ICategoryDao extends IBaseDao<CategoryDto> {
	
	/**
	 * ·µ»Øµ±Ç°ÅÅÐòµÄ×î´óÊý
	 * @return
	 */
	public int maxOrder();
	
	/**
	 * ÖØÐÂ¸øÀà±ðÅÅÐò
	 * @param orders
	 * @return
	 */
	public boolean setCategorysOrder(String[] orders);
	
	public boolean deleteCategoryAndSource(int categoryId);
	
	
}
