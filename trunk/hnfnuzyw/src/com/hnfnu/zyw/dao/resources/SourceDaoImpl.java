package com.hnfnu.zyw.dao.resources;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.SourceDto;

@Repository("sourceDao")
public class SourceDaoImpl extends BaseDao<SourceDto> implements ISourceDao {
	public int getTotalCount(String hql) {
		
		Query query= this.getSession().createQuery(hql);
		int count=((Number)query.iterate().next()).intValue();
		return count;
	}

	public Float getTotalCapacity(String hql) {
		Query query= this.getSession().createQuery(hql);
		Float count=(float) ((Double)query.iterate().next()).intValue();
		return count;
	}

}
