package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.CategoryDto;
import com.hnfnu.zyw.vo.CategoryGroupVo;

public interface ICategoryService {
	public boolean add(CategoryDto category);

	public boolean delete(int id);

	public boolean update(CategoryDto category);

	public CategoryDto load(int id);

	/**
	 * 获取表中所有功能，是用List装的
	 * 
	 * @return
	 */
	public List<CategoryDto> list();

	/**
	 *获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listCategory();
	
	public int maxOrder();
	
	public Map<String, Object> getCategoryDtoOrder();
	
	public boolean setCategoryDtoOrder(String orders);
	/**
	 * 根据分组id获得该组下所有类别
	 * 
	 * @return
	 */
	public List<CategoryGroupVo> listCatecoryByGroupId(int groupId);
	
}
