package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.vo.SourceVo;

public interface ISourceVoService {
	public SourceVo load(int id);

	/**
	 * 获取表中所有功能，是用List装的
	 * 
	 * @return
	 */
	public List<SourceVo> list();

	/**
	 *获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listSourceVo();
	
	
	/**
	 * 获得特定用户的资源树
	 */
	public List<Map<String, Object>> treeByUserId(int userId);
	
	/**
	 * 根据课程和类别获得资源制定用户的资源
	 */
	public Map<String, Object> listSourceVoByUserId(int courseId, int categoryId,int userId);
	
	/**
	 *根据courseId和categoryId获得相应的资列表，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listSourceVo(int courseId,int categoryId);
	
	/**
	 *根据gradeId和subjectId获得前16个相应的资列表，根据浏览次数排序
	 * 
	 * @return
	 */
	public List<SourceVo> listSourceVoOrder(int gradeId,int subjectId);


	public List<Map<String, Object>> allTree();

	public List<Map<String, Object>> courseTree(int groupId);

}
