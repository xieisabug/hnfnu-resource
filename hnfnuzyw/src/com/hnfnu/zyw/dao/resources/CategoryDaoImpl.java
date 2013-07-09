package com.hnfnu.zyw.dao.resources;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.CategoryDto;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDao<CategoryDto> implements
		ICategoryDao {

}
