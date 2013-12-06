package com.hnfnu.zyw.dao.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.vo.SourceVo;

@Repository("sourceVoDao")
public class SourceVoDaoImpl extends BaseDao<SourceVo> implements ISourceVoDao {

	public List<SourceVo> sourceVoList(String sql) throws Exception {
		List<SourceVo> l  = this.getHibernateTemplate().find(sql);
		return l;
	}

	
	
	
}
