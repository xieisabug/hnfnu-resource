package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.SourceDto;

public interface ISourceService {
	public boolean add(SourceDto source,String categoryList);

	public boolean deleteMessege(int id);
	public boolean deleteFile(String url);

	public boolean update(SourceDto source,String categoryIdList);
	public boolean update(SourceDto source);

	public SourceDto load(int id);

	/**
	 * 获取表中所有功能，是用List装的
	 * 
	 * @return
	 */
	public List<SourceDto> list();

	/**
	 *获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listSource();

	public boolean delete(String url,int id);
}
