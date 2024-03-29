package com.hnfnu.zyw.service.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ICategoryDao;
import com.hnfnu.zyw.dao.resources.ICategoryGroupVoDao;
import com.hnfnu.zyw.dto.resources.CategoryDto;
import com.hnfnu.zyw.vo.CategoryGroupVo;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	@Qualifier("categoryDao")
	public ICategoryDao categoryDao;
	
	@Autowired
	@Qualifier("categoryGroupVoDao")
	public ICategoryGroupVoDao categoryGroupVoDao;

	public boolean add(CategoryDto category) {
		try {
			categoryDao.add(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
			return categoryDao.deleteCategoryAndSource(id);
	}

	public boolean update(CategoryDto category) {
		try {
			categoryDao.update(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public CategoryDto load(int id) {
		try {
			return categoryDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CategoryDto> list(int groupId) {
		String hql = "from CategoryDto where groupId="+groupId;
		List<CategoryDto> categorys = null;
		try {
			categorys = categoryDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categorys;
	}

	public Map<String, Object> listCategory() {
		String hql = "from CategoryGroupVo";
		Map<String, Object> categoryList = new HashMap<String, Object>();
		List<CategoryGroupVo> l = null;

		try {
			l = categoryGroupVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		categoryList.put("Rows", l);
		categoryList.put("Total", l.size());
		return categoryList;
	}

	public int maxOrder() {
		return categoryDao.maxOrder();
	}

	public Map<String, Object> getCategoryDtoOrder() {
		String hql = "from CategoryGroupVo order by ord asc";
		Map<String, Object> categoryList = new HashMap<String, Object>();
		List<CategoryGroupVo> l = null;

		try {
			l = categoryGroupVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		categoryList.put("Rows", l);
		categoryList.put("Total", l.size());
		return categoryList;
		
	}

	public boolean setCategoryDtoOrder(String orders) {
		String[] s = orders.split(";");
		return categoryDao.setCategorysOrder(s);
	}

	public List<CategoryGroupVo> listCatecoryByGroupId(int groupId) {
		String hql = "from CategoryGroupVo where groupId="+groupId+" order by ord asc";
		List<CategoryGroupVo> categorys = null;
		try {
			categorys = categoryGroupVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categorys;
	}

}
