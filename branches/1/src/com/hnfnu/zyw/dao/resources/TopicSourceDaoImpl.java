package com.hnfnu.zyw.dao.resources;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.TopicSourceDto;

@Repository("topicSourceDao")
public class TopicSourceDaoImpl extends BaseDao<TopicSourceDto> implements
		ITopicSourceDao {

	public int getTotalCount(String hql) {
		Query query = null;
		Session session = null;
		try {
			session  = this.getSession();
			query = session.createQuery(hql);
			int count = ((Number) query.iterate().next()).intValue();
			return count;
		} catch (NullPointerException e) {
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
		
	}

	public Float getTotalCapacity(String hql) {
		Float count = null;
		try {
			Query query = this.getSession().createQuery(hql);
			count = (float) ((Double) query.iterate().next()).intValue();
		} catch (NullPointerException e) {
			return 0.0f;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
