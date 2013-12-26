package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.GroupDto;

public interface IGroupService {
	
	public boolean add(GroupDto group);

	public boolean delete(int id);

	public boolean update(GroupDto group);

	public GroupDto load(int id);

	/**
	 * 获取表中所有分组，是用List装的
	 * 
	 * @return
	 */
	public List<GroupDto> list();

	/**
	 *获取表中所有分组，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listGroup();
}
