package com.hnfnu.zyw.service.website;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.website.NewsDto;

public interface INewsService {
	
	public boolean add(NewsDto news);

	public boolean delete(NewsDto news);

	public boolean update(NewsDto news);

	public NewsDto load(NewsDto news);

	
	/**
	 * 获取表中所有功能，是用List装的
	 * @return
	 */
	public List<NewsDto> list();
	/**
	 *获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	 * @return
	 */
	public Map<String, Object> listNews();
	

}
