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
		} catch (Exception e) {
			//System.out.println("session 可能有问题！　");
			//System.out.println("我们来看看session吧：" + session);
			e.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
		
	}

	public Float getTotalCapacity(String hql) {
		Query query = this.getSession().createQuery(hql);
		Float count = (float) ((Double) query.iterate().next()).intValue();
		return count;
	}
}
