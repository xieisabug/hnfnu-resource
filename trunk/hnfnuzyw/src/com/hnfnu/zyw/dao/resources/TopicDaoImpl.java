package com.hnfnu.zyw.dao.resources;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.TopicDto;


@Repository("topicDao")
public class TopicDaoImpl extends BaseDao<TopicDto> implements ITopicDao {

public int getTotalCount(String hql) {
		int count = 0;
		try {
			Query query= this.getSession().createQuery(hql);
			count=((Number)query.iterate().next()).intValue();
		} catch (NullPointerException e) {
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

public boolean updateByTran(int id,int viewTimes) {
	Session session = this.getSession();
	String hql = "update TopicDto set viewTimes="+viewTimes + " where id="+id;
	Transaction t = null;
	try {
		t = session.beginTransaction();
		Query q = session.createQuery(hql);
		q.executeUpdate();
		t.commit();
	} catch (Exception ex) {
		ex.printStackTrace();
		if (t != null) {
			t.rollback();
		}
		return false;
	} finally {
		session.close();
	}
	return true;
}
}
