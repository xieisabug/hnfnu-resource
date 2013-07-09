package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.CategoryDto;

public interface ICategoryService {
	public boolean add(CategoryDto category);

	public boolean delete(int id);

	public boolean update(CategoryDto category);

	public CategoryDto load(int id);

	/**
	 * ��ȡ�������й��ܣ�����Listװ��
	 * 
	 * @return
	 */
	public List<CategoryDto> list();

	/**
	 *��ȡ�������й��ܣ���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * 
	 * @return
	 */
	public Map<String, Object> listCategory();
}
