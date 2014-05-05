package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.vo.GradeGroupVo;

public interface IGradeService {

	public boolean add(GradeDto grade);

	public boolean delete(int id);

	public boolean update(GradeDto grade);

	public GradeDto load(int id);

	/**
	 * 获取表中所有功能，是用List装的
	 * 
	 * @return
	 */
	public List<GradeDto> list();

	/**
	 *获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listGrade();
	
	/**
	 * 根据分组id获得该组下所有年级
	 * 
	 * @return
	 */
	public List<GradeGroupVo> listGradeByGroupId(int groupId);
	
	/**
	 * 获取已有资源的年级
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<GradeGroupVo> haveGradeList();

}
