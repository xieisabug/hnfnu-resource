package com.hnfnu.zyw.service.resources;

import java.util.List;

import com.hnfnu.zyw.dto.resources.SourceCategoryJoinDto;

public interface ISourceCategoryJoinService {
	public boolean add(SourceCategoryJoinDto sourceCategoryJoin);

	public boolean delete(int id);

	public boolean update(SourceCategoryJoinDto sourceCategoryJoin);

	public SourceCategoryJoinDto load(int id);

	/**
	 * 获取表中所有功能，是用List装的
	 * 
	 * @return
	 */
	public List<SourceCategoryJoinDto> list();

}
