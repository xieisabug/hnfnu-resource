package com.hnfnu.zyw.dao.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.vo.SourceCommentVo;

public interface ISourceCommentVoDao extends IBaseDao<SourceCommentVo>{
	/**
	 * 获得一个资源的所有id，树形显示
	 * @param sourceId
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> sourceCommentTree(int sourceId) throws Exception;

}
