package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.SourceCommentDto;

public interface ISourceCommentService {
	public boolean add(SourceCommentDto sourceComment);

	public boolean delete(int id);

	public boolean update(SourceCommentDto sourceComment);

	public SourceCommentDto load(int id);

	/**
	 * 获取表中所有分组，是用List装的
	 * 
	 * @return
	 */
	public List<SourceCommentDto> list();

	/**
	 *获取一个资源的所有评论树
	 * 
	 * @return
	 */
	public List<Map<String, Object>> sourceCommentTree(int sourceId);

}
