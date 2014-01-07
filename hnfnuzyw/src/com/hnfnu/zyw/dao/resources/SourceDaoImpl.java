package com.hnfnu.zyw.dao.resources;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.SourceDto;

@Repository("sourceDao")
public class SourceDaoImpl extends BaseDao<SourceDto> implements ISourceDao {
	public int getTotalCount(String hql) {
		int count = 0;
		try {
			Query query= this.getSession().createQuery(hql);
			 count=((Number)query.iterate().next()).intValue();
		} catch (NullPointerException e) {
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return count;
	}

	public Float getTotalCapacity(String hql) {
		Float count =null;
		try {
			Query query= this.getSession().createQuery(hql);
			count=(float) ((Double)query.iterate().next()).intValue();
		} catch (NullPointerException e) {
			return 0.0f;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
