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
	 *根据courseId和categoryId获得相应的资列表，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listSourceVo(int courseId,int categoryId);

	public List<Map<String, Object>> allTree();

}
