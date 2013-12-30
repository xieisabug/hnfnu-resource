package com.hnfnu.zyw.dao.resources;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.ejb.HibernateEntityManager;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.vo.SourceVo;
import com.sun.org.apache.commons.beanutils.converters.BigDecimalConverter;

@Repository("sourceVoDao")
public class SourceVoDaoImpl extends BaseDao<SourceVo> implements ISourceVoDao {

	public List<SourceVo> sourceVoList(String sql) throws Exception {
		List<SourceVo> l  = this.getHibernateTemplate().find(sql);
		return l;
	}


	public int getViewTimesBySubjectId(int subjectId,int groupId,int gradeId) {
		String sql = "select sum(viewTimes) as allViewTimes  from v_source " +
				"where subjectId="+subjectId+" and gradeId="+gradeId+" and groupId="+groupId; 
		List l = this.getSession().createSQLQuery(sql).list();
		return Integer.valueOf(l.get(0).toString());
	}
	
	
}
