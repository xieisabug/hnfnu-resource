package com.hnfnu.zyw.dao.resources;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.CategoryDto;

public interface ICategoryDao extends IBaseDao<CategoryDto> {
	
	/**
	 * 返回当前排序的最大数
	 * @return
	 */
	public int maxOrder();
	
	/**
	 * 重新给类别排序
	 * @param orders
	 * @return
	 */
	public boolean setCategorysOrder(String[] orders);
	
	public boolean deleteCategoryAndSource(int categoryId);
	
	
}
